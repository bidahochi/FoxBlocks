package com.bidahochi.BlockMod.blocks.displayframe.client;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.world.ChunkPosition;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.world.WorldEvent;
import org.apache.logging.log4j.Level;
import org.lwjgl.opengl.GL11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Pattern;

/** Builds item previews on the render thread and reuses them across chunk builds. */
public final class DisplayFramePreviews
{
    static final int SIZE = 64;
    private static final int SECTION_SIZE = 16;
    private static final int CAPACITY = 512;
    private static final int PREVIEWS_PER_FRAME = 4;
    private static final int LABEL_CAPACITY = 256;
    private static final int LABELS_PER_FRAME = 2;
    private static final Pattern LABEL_WHITESPACE = Pattern.compile("[\\p{Z}\\s\\p{Cntrl}]+", Pattern.UNICODE_CHARACTER_CLASS);
    private final Map<StackKey, Preview> cache = new HashMap<>();
    private final Queue<Preview> pending = new ArrayDeque<>();
    private final List<PreviewSprite> slots = new ArrayList<>(CAPACITY);
    private final Map<String, Label> labels = new HashMap<>();
    private final Queue<Label> pendingLabels = new ArrayDeque<>();
    private final List<PreviewSprite> labelSlots = new ArrayList<>(LABEL_CAPACITY);
    private final DisplayFrameThumbnail thumbnail = new DisplayFrameThumbnail();
    private final DisplayFrameBlockMesh blockMesh = new DisplayFrameBlockMesh();
    private TextureMap atlas;
    private IIcon placeholder;
    private Appearance fallback;
    private int nextSprite;
    private int nextLabelSprite;
    private boolean atlasReady;

    /** Reserves preview slots in each newly stitched terrain atlas. */
    @SubscribeEvent
    public synchronized void onStitchPre(TextureStitchEvent.Pre event)
    {
        if (event.map.getTextureType() != 0)
        {
            return;
        }
        atlasReady = false;
        atlas = event.map;
        clearPreviews();
        slots.clear();
        labelSlots.clear();
        placeholder = atlas.registerIcon("foxblocks:although");
        fallback = new Appearance(placeholder, null);
        for (int i = 0; i < CAPACITY; i++)
        {
            PreviewSprite slot = new PreviewSprite("foxblocks:display_frame_preview_" + i, SIZE);
            atlas.setTextureEntry(slot.getIconName(), slot);
            slots.add(slot);
        }
        for (int index = 0; index < LABEL_CAPACITY; index++)
        {
            String name = "foxblocks:display_frame_label_" + index;
            PreviewSprite slot = new PreviewSprite(name, DisplayFrameThumbnail.LABEL_WIDTH);
            atlas.setTextureEntry(name, slot);
            labelSlots.add(slot);
        }
    }

    /** Clears item and chunk references when the client leaves the world. */
    @SubscribeEvent
    public synchronized void onWorldUnload(WorldEvent.Unload event)
    {
        if (event.world.isRemote)
        {
            clearPreviews();
        }
    }

    private void clearPreviews()
    {
        cache.clear();
        pending.clear();
        nextSprite = 0;
        labels.clear();
        pendingLabels.clear();
        nextLabelSprite = 0;
    }

    /** Allows chunk builds to request previews once the terrain atlas is ready. */
    @SubscribeEvent
    public synchronized void onStitchPost(TextureStitchEvent.Post event)
    {
        if (event.map == atlas)
        {
            atlasReady = true;
        }
    }

    static DisplayFrameIconOutline getOutline(IIcon icon)
    {
        return icon instanceof PreviewSprite ? ((PreviewSprite) icon).outline : null;
    }

    /**
     * Returns the cached preview or queues it on the render thread. The chunk uses a placeholder
     * until the preview is ready and its render section can be rebuilt.
     */
    synchronized Appearance getPreview(ItemStack stack, int x, int y, int z, boolean flat)
    {
        if (atlasReady == false)
        {
            IIcon icon = placeholder;
            if (icon == null)
            {
                icon = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("missingno");
            }
            return new Appearance(icon, null);
        }
        StackKey key = new StackKey(stack, flat);
        Preview preview = cache.get(key);
        if (preview == null)
        {
            if (cache.size() >= 2 * CAPACITY)
            {
                return fallback;
            }
            preview = new Preview(stack.copy(), flat);
            cache.put(new StackKey(preview.stack, flat), preview);
            pending.add(preview);
        }
        if (preview.complete == false)
        {
            preview.sections.add(sectionAt(x, y, z));
        }
        return preview.appearance == null ? fallback : preview.appearance;
    }

    /**
     * Reuses labels by their client-local display name. A null result leaves the frame without text
     * while the label is pending or when no label slot is available.
     */
    public synchronized IIcon getLabel(ItemStack stack, int x, int y, int z)
    {
        if (atlasReady == false)
        {
            return null;
        }
        String displayName;
        try
        {
            displayName = stack.getDisplayName();
        }
        catch (RuntimeException invalidModItemName)
        {
            // Mod items can fail to provide a display name without affecting their item preview.
            return null;
        }
        if (displayName == null || displayName.isEmpty())
        {
            return null;
        }
        String plainName = StringUtils.stripControlCodes(displayName);
        String name = LABEL_WHITESPACE.matcher(plainName).replaceAll(" ").trim();
        if (name.isEmpty())
        {
            return null;
        }

        Label label = labels.get(name);
        if (label == null)
        {
            if (labels.size() >= labelSlots.size())
            {
                return null;
            }
            label = new Label(name);
            labels.put(name, label);
            pendingLabels.add(label);
        }
        if (label.complete == false)
        {
            label.sections.add(sectionAt(x, y, z));
        }
        return label.sprite;
    }

    private static ChunkPosition sectionAt(int x, int y, int z)
    {
        int sectionX = Math.floorDiv(x, SECTION_SIZE);
        int sectionY = Math.floorDiv(y, SECTION_SIZE);
        int sectionZ = Math.floorDiv(z, SECTION_SIZE);
        return new ChunkPosition(sectionX, sectionY, sectionZ);
    }

    /** Builds a bounded number of previews and rebuilds the sections that were awaiting them. */
    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event)
    {
        Minecraft minecraft = Minecraft.getMinecraft();
        if (event.phase != TickEvent.Phase.END || minecraft.theWorld == null)
        {
            return;
        }
        Set<ChunkPosition> sections = null;
        for (int i = 0; i < PREVIEWS_PER_FRAME; i++)
        {
            Preview preview;
            synchronized (this)
            {
                preview = pending.poll();
            }
            if (preview == null)
            {
                break;
            }

            Appearance appearance = buildPreview(preview, minecraft);
            synchronized (this)
            {
                preview.appearance = appearance;
                preview.complete = true;
                if (appearance != null)
                {
                    if (sections == null)
                    {
                        sections = new HashSet<>();
                    }
                    sections.addAll(preview.sections);
                }
                preview.sections.clear();
            }
        }
        sections = buildPendingLabels(minecraft, sections);
        if (sections != null)
        {
            for (ChunkPosition section : sections)
            {
                // A single point marks its render section dirty.
                int halfSection = SECTION_SIZE / 2;
                int centerX = section.chunkPosX * SECTION_SIZE + halfSection;
                int centerY = section.chunkPosY * SECTION_SIZE + halfSection;
                int centerZ = section.chunkPosZ * SECTION_SIZE + halfSection;
                minecraft.theWorld.markBlockRangeForRenderUpdate(centerX, centerY, centerZ, centerX, centerY, centerZ);
            }
        }
    }

    /** Rasterizes a bounded number of labels and queues rebuilds only for successful uploads. */
    private synchronized Set<ChunkPosition> buildPendingLabels(Minecraft minecraft, Set<ChunkPosition> sections)
    {
        for (int index = 0; index < LABELS_PER_FRAME; index++)
        {
            Label label = pendingLabels.poll();
            if (label == null)
            {
                break;
            }
            label.sprite = buildLabel(minecraft, label);
            label.complete = true;
            if (label.sprite != null)
            {
                if (sections == null)
                {
                    sections = new HashSet<>();
                }
                sections.addAll(label.sections);
            }
            label.sections.clear();
        }
        return sections;
    }

    private IIcon buildLabel(Minecraft minecraft, Label label)
    {
        try
        {
            List<String> lines = DisplayFrameThumbnail.fitLabel(minecraft.fontRenderer, label.name);
            int[] pixels = thumbnail.captureLabel(minecraft.fontRenderer, lines);
            if (pixels == null)
            {
                return null;
            }
            PreviewSprite sprite = labelSlots.get(nextLabelSprite);
            uploadSprite(minecraft, sprite, pixels, false);
            nextLabelSprite++;
            return sprite;
        }
        catch (RuntimeException ex)
        {
            FMLLog.log("FoxBlocks", Level.WARN, ex, "Cannot make a display frame label for %s", label.name);
            return null;
        }
    }

    /**
     * Builds a mesh or uploads a thumbnail. Capture restores graphics state even if a custom
     * renderer fails, so the caller can safely keep the placeholder.
     */
    private Appearance buildPreview(Preview preview, Minecraft minecraft)
    {
        ItemStack stack = preview.stack;
        if (preview.flat == false)
        {
            try
            {
                DisplayFrameBlockMesh.Mesh mesh = blockMesh.capture(minecraft, stack);
                if (mesh != null)
                {
                    return new Appearance(null, mesh);
                }
            }
            catch (RuntimeException ex)
            {
                FMLLog.log("FoxBlocks", Level.WARN, ex, "Cannot capture display frame block geometry for %s",
                        Item.itemRegistry.getNameForObject(stack.getItem()));
            }
        }
        if (nextSprite >= slots.size())
        {
            return null;
        }
        try
        {
            int[] pixels = thumbnail.capture(minecraft, stack);
            if (pixels == null)
            {
                return null;
            }
            PreviewSprite sprite = slots.get(nextSprite);
            uploadSprite(minecraft, sprite, pixels, preview.flat == false);
            nextSprite++;
            return new Appearance(sprite, null);
        }
        catch (RuntimeException ex)
        {
            FMLLog.log("FoxBlocks", Level.WARN, ex, "Cannot make a display frame preview for %s",
                    Item.itemRegistry.getNameForObject(stack.getItem()));
            return null;
        }
    }

    /** Uploads the pixels to a reserved terrain slot and restores the prior texture binding. */
    private static void uploadSprite(Minecraft minecraft, PreviewSprite sprite, int[] pixels, boolean withOutline)
    {
        GL11.glPushAttrib(GL11.GL_TEXTURE_BIT);
        try
        {
            minecraft.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            sprite.upload(pixels, withOutline);
        }
        finally
        {
            GL11.glPopAttrib();
        }
    }

    private static final class Label
    {
        private final String name;
        private final Set<ChunkPosition> sections = new HashSet<>();
        private boolean complete;
        private IIcon sprite;

        private Label(String name)
        {
            this.name = name;
        }
    }

    static final class Appearance
    {
        final IIcon icon;
        final DisplayFrameBlockMesh.Mesh mesh;

        Appearance(IIcon icon, DisplayFrameBlockMesh.Mesh mesh)
        {
            this.icon = icon;
            this.mesh = mesh;
        }
    }

    private static final class Preview
    {
        private final ItemStack stack;
        private final boolean flat;
        private final Set<ChunkPosition> sections = new HashSet<>();
        private boolean complete;
        private Appearance appearance;

        private Preview(ItemStack stack, boolean flat)
        {
            this.stack = stack;
            this.flat = flat;
        }
    }

    private static final class StackKey
    {
        private final Item item;
        private final int damage;
        private final NBTTagCompound tag;
        private final boolean flat;

        private StackKey(ItemStack stack, boolean flat)
        {
            item = stack.getItem();
            damage = stack.getItemDamage();
            tag = stack.getTagCompound();
            this.flat = flat;
        }

        @Override
        public int hashCode()
        {
            int hash = 31 * System.identityHashCode(item) + damage;
            hash = 31 * hash + Objects.hashCode(tag);
            return 31 * hash + (flat ? 1 : 0);
        }

        @Override
        public boolean equals(Object object)
        {
            if ((object instanceof StackKey) == false)
            {
                return false;
            }
            StackKey other = (StackKey) object;
            return item == other.item && damage == other.damage && flat == other.flat && Objects.equals(tag, other.tag);
        }
    }

    private static final class PreviewSprite extends TextureAtlasSprite
    {
        private final int size;
        private int mipmaps;
        private DisplayFrameIconOutline outline;

        private PreviewSprite(String name, int size)
        {
            super(name);
            this.size = size;
        }

        /** Uses generated pixel data for the reserved sprite. */
        @Override
        public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location)
        {
            return true;
        }

        /** Reserves an empty atlas slot for the first upload. */
        @Override
        public boolean load(IResourceManager manager, ResourceLocation location)
        {
            setIconWidth(size);
            setIconHeight(size);
            setFramesTextureData(Collections.singletonList(new int[][] {new int[size * size]}));
            // Forge includes the reserved slot in the stitch when the loader returns false.
            return false;
        }

        /** Records the atlas mipmap count for later uploads into this slot. */
        @Override
        public void generateMipmaps(int levels)
        {
            mipmaps = levels;
            int[][] levelsToGenerate = Arrays.copyOf(getFrameTextureData(0), levels + 1);
            int[][] generated = TextureUtil.generateMipmapData(levels, size, levelsToGenerate);
            setFramesTextureData(new ArrayList<>(Collections.singletonList(generated)));
        }

        private void upload(int[] pixels, boolean withOutline)
        {
            int[][] data = new int[mipmaps + 1][];
            data[0] = pixels;
            int[][] generated = TextureUtil.generateMipmapData(mipmaps, size, data);
            TextureUtil.uploadTextureMipmap(generated, size, size, getOriginX(), getOriginY(), false, false);
            outline = withOutline ? DisplayFrameIconOutline.fromPixels(pixels, size) : null;
        }
    }

}
