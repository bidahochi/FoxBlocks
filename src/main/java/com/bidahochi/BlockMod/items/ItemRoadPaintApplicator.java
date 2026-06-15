package com.bidahochi.BlockMod.items;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.roadpaints.RoadPaintCatalog;
import com.bidahochi.BlockMod.blocks.roadpaints.RoadPaintPlacement;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRPB;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class ItemRoadPaintApplicator extends Item {
    public static final int MAX_CHARGES = 1024;
    public static final int PAINT_COMPOUND_CHARGES = 256;
    public static final int HEIGHT_AUTO = -1;
    public static final int HEIGHT_FULL_BLOCK = 0;
    public static final int HEIGHT_SLAB = 8;
    public static final int HEIGHT_ROAD_COVER = 15;
    private static final String TAG_CHARGES = "PaintCharges";
    private static final String TAG_SELECTION = "PaintSelection";
    private static final String TAG_ROTATION = "PaintRotation";
    private static final String TAG_MANUAL_ROTATION = "PaintManualRotation";
    private static final String TAG_LAYERED = "PaintLayered";
    private static final String TAG_HEIGHT_OVERRIDE = "PaintHeightOverride";
    private static final String TAG_GUI_CATEGORY = "PaintGuiCategory";
    private static final String TAG_GUI_PAGE = "PaintGuiPage";

    public ItemRoadPaintApplicator() {
        setMaxStackSize(1);
        setTextureName(FoxBlocks.MODID + ":bolsterchisel");
    }

    private static NBTTagCompound getTag(ItemStack stack) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        return stack.getTagCompound();
    }

    public static int getCharges(ItemStack stack) {
        return stack != null && stack.hasTagCompound() ? stack.getTagCompound().getInteger(TAG_CHARGES) : 0;
    }

    public static void setCharges(ItemStack stack, int charges) {
        getTag(stack).setInteger(TAG_CHARGES, Math.max(0, Math.min(MAX_CHARGES, charges)));
    }

    public static int getSelection(ItemStack stack) {
        return stack != null && stack.hasTagCompound() ? stack.getTagCompound().getInteger(TAG_SELECTION) : 0;
    }

    public static int getRotation(ItemStack stack) {
        return stack != null && stack.hasTagCompound() ? stack.getTagCompound().getInteger(TAG_ROTATION) & 3 : 0;
    }

    public static boolean isManualRotation(ItemStack stack) {
        return stack != null && stack.hasTagCompound()
                && stack.getTagCompound().getBoolean(TAG_MANUAL_ROTATION);
    }

    public static boolean isLayered(ItemStack stack) {
        return stack != null && stack.hasTagCompound() && stack.getTagCompound().getBoolean(TAG_LAYERED);
    }

    public static int getHeightOverride(ItemStack stack) {
        int value = stack != null && stack.hasTagCompound()
                && stack.getTagCompound().hasKey(TAG_HEIGHT_OVERRIDE)
                ? stack.getTagCompound().getInteger(TAG_HEIGHT_OVERRIDE)
                : HEIGHT_AUTO;
        return normalizeHeightOverride(value);
    }

    public static int normalizeHeightOverride(int value) {
        return value == HEIGHT_FULL_BLOCK || value == HEIGHT_SLAB || value == HEIGHT_ROAD_COVER
                ? value : HEIGHT_AUTO;
    }

    public static int nextHeightOverride(int value) {
        if (value == HEIGHT_AUTO) {
            return HEIGHT_FULL_BLOCK;
        }
        if (value == HEIGHT_FULL_BLOCK) {
            return HEIGHT_SLAB;
        }
        if (value == HEIGHT_SLAB) {
            return HEIGHT_ROAD_COVER;
        }
        return HEIGHT_AUTO;
    }

    public static String getHeightOverrideName(int value) {
        if (value == HEIGHT_FULL_BLOCK) {
            return "Full Block";
        }
        if (value == HEIGHT_SLAB) {
            return "Slab";
        }
        if (value == HEIGHT_ROAD_COVER) {
            return "Road Cover / Rail";
        }
        return "Auto";
    }

    public static int getGuiCategory(ItemStack stack) {
        return stack != null && stack.hasTagCompound()
                ? stack.getTagCompound().getInteger(TAG_GUI_CATEGORY) : -1;
    }

    public static int getGuiPage(ItemStack stack) {
        return stack != null && stack.hasTagCompound()
                ? stack.getTagCompound().getInteger(TAG_GUI_PAGE) : 0;
    }

    public static void setSettings(ItemStack stack, int selection, int rotation, boolean manualRotation,
                                   boolean layered, int heightOverride,
                                   int guiCategory, int guiPage) {
        NBTTagCompound tag = getTag(stack);
        tag.setInteger(TAG_SELECTION, selection);
        tag.setInteger(TAG_ROTATION, rotation & 3);
        tag.setBoolean(TAG_MANUAL_ROTATION, manualRotation);
        tag.setBoolean(TAG_LAYERED, layered);
        tag.setInteger(TAG_HEIGHT_OVERRIDE, normalizeHeightOverride(heightOverride));
        tag.setInteger(TAG_GUI_CATEGORY, guiCategory);
        tag.setInteger(TAG_GUI_PAGE, Math.max(0, guiPage));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (world.isRemote) {
            FoxBlocks.proxy.openRoadPaintApplicatorGui(player);
        }
        return stack;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z,
                             int side, float hitX, float hitY, float hitZ) {
        Block clicked = world.getBlock(x, y, z);
        if (!clicked.isReplaceable(world, x, y, z))
        {
            switch (side)
            {
                case 0:
                    --y;
                    break;
                case 1:
                    ++y;
                    break;
                case 2:
                    --z;
                    break;
                case 3:
                    ++z;
                    break;
                case 4:
                    --x;
                    break;
                case 5:
                    ++x;
                    break;
                default:
                    break;
            }
        }

        if (!player.canPlayerEdit(x, y, z, side, stack) || !world.isAirBlock(x, y, z))
        {
            return false;
        }

        RoadPaintCatalog.Entry entry = RoadPaintCatalog.get(getSelection(stack));
        if (entry == null || (!player.capabilities.isCreativeMode && getCharges(stack) <= 0)) {
            if (!world.isRemote && getCharges(stack) <= 0) {
                player.addChatMessage(new ChatComponentTranslation("message.roadPaintApplicator.empty"));
            }
            return false;
        }

        boolean layered = isLayered(stack);
        Block below = world.getBlock(x, y - 1, z);
        if (RoadPaintPlacement.isRoadPaint(below) && !layered)
        {
            return false;
        }

        if (world.isRemote)
        {
            return true;
        }

        boolean placed = false;
        RoadPaintPlacement.setStackingAllowed(layered);
        try {
            if (entry.block.canPlaceBlockAt(world, x, y, z)
                    && world.setBlock(x, y, z, entry.block, entry.metadata, 3))
            {
                if (entry.dynamic)
                {
                    // Dynamic paints own their orientation and neighbor-connection logic.
                    entry.block.onBlockPlacedBy(world, x, y, z, player, null);
                    TileRPB placedTile = (TileRPB) world.getTileEntity(x, y, z);
                    if (placedTile != null)
                    {
                        placedTile.setHeightOverride(getHeightOverride(stack));
                    }
                }
                else if (entry.block instanceof ScrollRoadPaintBlock)
                {
                    ScrollRoadPaintBlock roadPaint = (ScrollRoadPaintBlock) entry.block;
                    int placementRotation = isManualRotation(stack)
                            ? getRotation(stack)
                            : MathHelper.floor_double((player.rotationYaw / 90.0F) + 2.5D) & 3;
                    world.setTileEntity(x, y, z, new TileRPB(
                            placementRotation,
                            roadPaint.color,
                            entry.getShape(),
                            roadPaint.offset,
                            new ItemStack(Item.getItemFromBlock(entry.block), 1, entry.metadata)));
                    TileRPB placedTile = (TileRPB) world.getTileEntity(x, y, z);
                    if (placedTile != null)
                    {
                        placedTile.setHeightOverride(getHeightOverride(stack));
                    }
                }
                world.markBlockForUpdate(x, y, z);
                world.playSoundEffect(
                        x + 0.5D,
                        y + 0.5D,
                        z + 0.5D,
                        entry.block.stepSound.func_150496_b(),
                        (entry.block.stepSound.getVolume() + 1.0F) / 2.0F,
                        entry.block.stepSound.getPitch() * 0.8F);
                placed = true;
            }
        }
        finally
        {
            RoadPaintPlacement.setStackingAllowed(false);
        }

        if (placed && !player.capabilities.isCreativeMode)
        {
            setCharges(stack, getCharges(stack) - 1);
        }
        return placed;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advanced)
    {
        RoadPaintCatalog.Entry entry = RoadPaintCatalog.get(getSelection(stack));
        lines.add(player.capabilities.isCreativeMode
                ? "Paint: Creative"
                : "Paint: " + getCharges(stack) + " / " + MAX_CHARGES);
        lines.add("Pattern: " + (entry == null ? "None" : entry.getDisplayName()));
        lines.add("Rotation: " + (isManualRotation(stack)
                ? "Manual (" + (getRotation(stack) * 90) + " degrees)" : "Automatic"));
        int heightOverride = getHeightOverride(stack);
        lines.add("Surface Height: " + getHeightOverrideName(heightOverride));
        lines.add("Mode: " + (isLayered(stack) ? "Layered" : "Protected"));
        lines.add("Right-click air to configure");
    }
}
