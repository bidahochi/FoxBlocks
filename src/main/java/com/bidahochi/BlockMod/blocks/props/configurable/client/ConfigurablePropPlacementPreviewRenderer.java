package com.bidahochi.BlockMod.blocks.props.configurable.client;

import com.bidahochi.BlockMod.blocks.props.configurable.data.ConfigurablePropHeightMode;
import com.bidahochi.BlockMod.blocks.props.configurable.data.PropPlacementOffset;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.height.ConfigurablePropHeightHelper;
import com.bidahochi.BlockMod.blocks.props.configurable.item.ItemBlockConfigurableProp;
import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import com.bidahochi.BlockMod.customization.data.AppearanceData;
import com.bidahochi.BlockMod.customization.registry.AppearanceTextureRegistry;
import com.bidahochi.BlockMod.customization.registry.CustomizationRegistry;
import com.bidahochi.BlockMod.customization.registry.SkinDefinition;
import com.bidahochi.BlockMod.render.tmt.ModelBase;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/** Renders a depth-correct screen-door ghost at a prop's prospective position. */
@SideOnly(Side.CLIENT)
public final class ConfigurablePropPlacementPreviewRenderer
{

    /** Y coordinate where vanilla ItemBlock rejects placement of a solid block. */
    private static final int SOLID_BLOCK_PLACEMENT_CEILING = 255;
    /** Fifty-percent screen-door mask used for valid placements. */
    private static final ByteBuffer VALID_STIPPLE = createStipplePattern(0xAA, 0x55);
    /** Twenty-five-percent screen-door mask used for obstructed placements. */
    private static final ByteBuffer BLOCKED_STIPPLE = createStipplePattern(0x88, 0x22);
    /** Texture-combiner color used to mark an obstructed placement. */
    private static final FloatBuffer BLOCKED_TEXTURE_COLOR =
            createTextureColor(1.0F, 0.1F, 0.1F, 1.0F);

    /**
     * Draws a depth-correct placement ghost without replacing the normal highlight.
     * Valid placements use a neutral screen-door overlay; blocked placements use red.
     *
     * @param event Forge highlight event containing the target, player, and partial tick
     */
    @SubscribeEvent
    public void onDrawBlockHighlight(DrawBlockHighlightEvent event)
    {
        if (event.currentItem == null
                || (event.currentItem.getItem() instanceof ItemBlockConfigurableProp) == false
                || event.target == null
                || event.target.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK)
        {
            return;
        }

        ItemBlockConfigurableProp item =
                (ItemBlockConfigurableProp) event.currentItem.getItem();
        ConfigurablePropDefinition definition = item.getConfigurablePropDefinition();
        if (definition == null)
        {
            return;
        }

        int[] controllerPosition = getControllerPosition(event.player.worldObj, event.target);
        RotationAmount rotation = item.getPlacementRotation(event.currentItem, event.player);
        boolean valid = canPlaceAt(
                item,
                event.currentItem,
                event.player.worldObj,
                event.target.sideHit,
                event.player,
                controllerPosition,
                rotation
        );
        renderPreview(
                item,
                event.currentItem,
                event.player.worldObj,
                definition,
                controllerPosition,
                rotation,
                valid
        );
    }

    /** Resolves the controller cell using the same replaceable-block rule as ItemBlock. */
    private int[] getControllerPosition(World world, MovingObjectPosition target)
    {
        int x = target.blockX;
        int y = target.blockY;
        int z = target.blockZ;
        Block targetedBlock = world.getBlock(x, y, z);
        if (targetedBlock == Blocks.snow_layer && world.getBlockMetadata(x, y, z) < 1)
        {
            return new int[] {x, y, z};
        }
        if (targetedBlock.isReplaceable(world, x, y, z) == false)
        {
            x += Facing.offsetsXForSide[target.sideHit];
            y += Facing.offsetsYForSide[target.sideHit];
            z += Facing.offsetsZForSide[target.sideHit];
        }
        return new int[] {x, y, z};
    }

    /** Checks the controller cell and every rotated secondary structure cell. */
    private boolean canPlaceAt(
            ItemBlockConfigurableProp item,
            ItemStack stack,
            World world,
            int side,
            net.minecraft.entity.player.EntityPlayer player,
            int[] controllerPosition,
            RotationAmount rotation
    )
    {
        int x = controllerPosition[0];
        int y = controllerPosition[1];
        int z = controllerPosition[2];
        Block controllerBlock = Block.getBlockFromItem(stack.getItem());
        return y >= 0
                && y < world.getHeight()
                && (y != SOLID_BLOCK_PLACEMENT_CEILING
                        || controllerBlock.getMaterial().isSolid() == false)
                && player.canPlayerEdit(x, y, z, side, stack)
                && world.canPlaceEntityOnSide(
                        controllerBlock,
                        x,
                        y,
                        z,
                        false,
                        side,
                        player,
                        stack
                )
                && item.canPlaceStructureAt(
                        world,
                        x,
                        y,
                        z,
                        rotation,
                        player,
                        side,
                        stack
                );
    }

    /** Resolves item appearance and draws one camera-relative screen-door model. */
    private void renderPreview(
            ItemBlockConfigurableProp item,
            ItemStack stack,
            World world,
            ConfigurablePropDefinition definition,
            int[] controllerPosition,
            RotationAmount rotation,
            boolean valid
    )
    {
        AppearanceData appearance = item.getAppearance(stack);
        SkinDefinition skin = CustomizationRegistry.getSkin(appearance.getSkinId());
        if (skin == null)
        {
            skin = CustomizationRegistry.getSkin(definition.getDefaultSkinId());
        }
        ModelBase model = ConfigurablePropModelRegistry.getModel(definition.getModelId());
        if (skin == null || model == null)
        {
            return;
        }

        PropPlacementOffset placementOffset = item.getPlacementOffset(stack);
        double offsetX = rotation.rotateX(
                placementOffset.getRightBlocks(),
                placementOffset.getForwardBlocks()
        );
        double offsetY = placementOffset.getUpBlocks();
        if (item.getHeightMode(stack) == ConfigurablePropHeightMode.AUTO)
        {
            offsetY += ConfigurablePropHeightHelper.getAutoHeightOffset(
                    definition,
                    world,
                    controllerPosition[0],
                    controllerPosition[1],
                    controllerPosition[2]
            );
        }
        double offsetZ = rotation.rotateZ(
                placementOffset.getRightBlocks(),
                placementOffset.getForwardBlocks()
        );
        ResourceLocation texture = AppearanceTextureRegistry.resolveTexture(
                definition.getId(),
                appearance,
                skin.getTexture()
        );

        GL11.glPushMatrix();
        GL11.glPushAttrib(
                GL11.GL_ENABLE_BIT
                        | GL11.GL_COLOR_BUFFER_BIT
                        | GL11.GL_CURRENT_BIT
                        | GL11.GL_DEPTH_BUFFER_BIT
                        | GL11.GL_POLYGON_BIT
                        | GL11.GL_POLYGON_STIPPLE_BIT
                        | GL11.GL_TEXTURE_BIT
        );
        try
        {
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDepthFunc(GL11.GL_LEQUAL);
            GL11.glDepthMask(true);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glAlphaFunc(GL11.GL_GREATER, 0.01F);
            if (valid == false)
            {
                configureBlockedTextureColor();
            }
            GL11.glEnable(GL11.GL_POLYGON_STIPPLE);
            ByteBuffer stipple = (valid ? VALID_STIPPLE : BLOCKED_STIPPLE).duplicate();
            stipple.rewind();
            GL11.glPolygonStipple(stipple);
            GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL);
            GL11.glPolygonOffset(-1.0F, -10.0F);
            GL11.glTranslated(
                    controllerPosition[0] + definition.getModelOffsetX() + offsetX
                            - RenderManager.renderPosX,
                    controllerPosition[1] + definition.getModelOffsetY() + offsetY
                            - RenderManager.renderPosY,
                    controllerPosition[2] + definition.getModelOffsetZ() + offsetZ
                            - RenderManager.renderPosZ
            );

            ConfigurablePropModelRenderHelper.renderModel(
                    definition,
                    model,
                    rotation,
                    item.isModelFlipped(stack),
                    appearance,
                    texture,
                    1.0F
            );
        }
        finally
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopAttrib();
            GL11.glPopMatrix();
        }
    }

    /** Creates a repeating 32-by-32 two-row polygon stipple mask. */
    private static ByteBuffer createStipplePattern(int evenRowByte, int oddRowByte)
    {
        ByteBuffer pattern = BufferUtils.createByteBuffer(128);
        for (int row = 0; row < 32; row++)
        {
            byte rowByte = (byte) ((row & 1) == 0 ? evenRowByte : oddRowByte);
            for (int columnByte = 0; columnByte < 4; columnByte++)
            {
                pattern.put(rowByte);
            }
        }
        pattern.flip();
        return pattern;
    }

    /** Configures texture RGB to be multiplied by the blocked-placement red. */
    private static void configureBlockedTextureColor()
    {
        GL11.glTexEnvi(
                GL11.GL_TEXTURE_ENV,
                GL11.GL_TEXTURE_ENV_MODE,
                GL13.GL_COMBINE
        );
        GL11.glTexEnvi(GL11.GL_TEXTURE_ENV, GL13.GL_COMBINE_RGB, GL11.GL_MODULATE);
        GL11.glTexEnvi(GL11.GL_TEXTURE_ENV, GL13.GL_SOURCE0_RGB, GL11.GL_TEXTURE);
        GL11.glTexEnvi(GL11.GL_TEXTURE_ENV, GL13.GL_OPERAND0_RGB, GL11.GL_SRC_COLOR);
        GL11.glTexEnvi(GL11.GL_TEXTURE_ENV, GL13.GL_SOURCE1_RGB, GL13.GL_CONSTANT);
        GL11.glTexEnvi(GL11.GL_TEXTURE_ENV, GL13.GL_OPERAND1_RGB, GL11.GL_SRC_COLOR);
        FloatBuffer blockedColor = BLOCKED_TEXTURE_COLOR.duplicate();
        blockedColor.rewind();
        GL11.glTexEnv(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_COLOR, blockedColor);
    }

    /** Creates a direct RGBA color buffer for fixed-function texture state. */
    private static FloatBuffer createTextureColor(float red, float green, float blue, float alpha)
    {
        FloatBuffer color = BufferUtils.createFloatBuffer(4);
        color.put(red);
        color.put(green);
        color.put(blue);
        color.put(alpha);
        color.flip();
        return color;
    }
}
