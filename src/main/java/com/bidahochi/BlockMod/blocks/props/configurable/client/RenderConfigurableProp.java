package com.bidahochi.BlockMod.blocks.props.configurable.client;

import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import com.bidahochi.BlockMod.customization.registry.CustomizationRegistry;
import com.bidahochi.BlockMod.customization.registry.SkinDefinition;
import com.bidahochi.BlockMod.customization.registry.AppearanceTextureRegistry;
import com.bidahochi.BlockMod.render.tmt.ModelBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/** Renders the controller tile using its validated definition and appearance. */
@SideOnly(Side.CLIENT)
public class RenderConfigurableProp extends TileEntitySpecialRenderer
{

    /** {@inheritDoc} */
    @Override
    public void renderTileEntityAt(
            TileEntity tileEntity,
            double x,
            double y,
            double z,
            float partialTick
    )
    {
        if ((tileEntity instanceof TileConfigurablePropController) == false)
        {
            return;
        }

        TileConfigurablePropController tile = (TileConfigurablePropController) tileEntity;
        ConfigurablePropDefinition definition = tile.getDefinition();
        if (definition == null)
        {
            return;
        }
        SkinDefinition skin = CustomizationRegistry.getSkin(tile.getAppearance().getSkinId());
        if (skin == null)
        {
            skin = CustomizationRegistry.getSkin(definition.getDefaultSkinId());
        }
        if (skin == null)
        {
            return;
        }
        ResourceLocation texture = AppearanceTextureRegistry.resolveTexture(
                tile.getDefinitionId(),
                tile.getAppearance(),
                skin.getTexture()
        );
        ModelBase model = ConfigurablePropModelRegistry.getModel(definition.getModelId());
        if (model == null)
        {
            return;
        }

        GL11.glPushMatrix();
        try
        {
            GL11.glTranslated(
                    x + definition.getModelOffsetX() + tile.getWorldOffsetX(),
                    y + definition.getModelOffsetY() + tile.getWorldOffsetY(),
                    z + definition.getModelOffsetZ() + tile.getWorldOffsetZ()
            );
            ConfigurablePropModelRenderHelper.renderModel(
                    definition,
                    model,
                    tile.getRotation(),
                    tile.isModelFlipped(),
                    tile.getAppearance(),
                    texture
            );
        }
        finally
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
        }
    }

}
