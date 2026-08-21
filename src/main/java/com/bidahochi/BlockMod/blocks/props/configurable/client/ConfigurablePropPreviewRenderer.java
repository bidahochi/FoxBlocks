package com.bidahochi.BlockMod.blocks.props.configurable.client;

import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import com.bidahochi.BlockMod.customization.data.AppearanceData;
import com.bidahochi.BlockMod.customization.registry.AppearanceTextureRegistry;
import com.bidahochi.BlockMod.customization.registry.CustomizationRegistry;
import com.bidahochi.BlockMod.customization.registry.SkinDefinition;
import com.bidahochi.BlockMod.render.tmt.ModelBase;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/** Renders an isolated configurable-prop preview inside the customization GUI. */
@SideOnly(Side.CLIENT)
public final class ConfigurablePropPreviewRenderer
{

    /**
     * Renders a GUI preview while preserving the caller's lightmap state. Missing
     * definitions, appearances, skins, and models produce no rendered output.
     *
     * @param definition definition whose registered model should be rendered
     * @param appearance validated appearance used to select textures and colors
     * @param centerX horizontal GUI coordinate for the model origin
     * @param centerY vertical GUI coordinate for the model origin
     * @param scale GUI preview scale in pixels per model unit
     * @param yaw GUI preview rotation in degrees, selected manually or supplied by the screen
     * @param modelFlipped whether to show the authored mirrored variant
     */
    public void renderPreview(
            ConfigurablePropDefinition definition,
            AppearanceData appearance,
            int centerX,
            int centerY,
            float scale,
            float yaw,
            boolean modelFlipped
    )
    {
        if (definition == null || appearance == null)
        {
            return;
        }
        SkinDefinition skin = CustomizationRegistry.getSkin(appearance.getSkinId());
        if (skin == null)
        {
            skin = CustomizationRegistry.getSkin(definition.getDefaultSkinId());
        }
        if (skin == null)
        {
            return;
        }
        ModelBase model = ConfigurablePropModelRegistry.getModel(definition.getModelId());
        if (model == null)
        {
            return;
        }

        boolean lightmapEnabled = isLightmapEnabled();
        GL11.glPushMatrix();
        try
        {
            ResourceLocation texture = AppearanceTextureRegistry.resolveTexture(
                    definition.getId(),
                    appearance,
                    skin.getTexture()
            );
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glTranslated(centerX, centerY, 80.0D);
            GL11.glScalef(scale, -scale, scale);
            ConfigurablePropModelRenderHelper.renderModel(
                    definition,
                    model,
                    RotationAmount.fromDegrees(yaw + definition.getGuiPreviewYawOffset()),
                    modelFlipped,
                    appearance,
                    texture
            );
        }
        finally
        {
            restoreLightmap(lightmapEnabled);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glPopMatrix();
        }
    }

    /** Reads the texture-enable flag from Minecraft's lightmap texture unit. */
    private boolean isLightmapEnabled()
    {
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        boolean enabled = GL11.glIsEnabled(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return enabled;
    }

    /** Restores the lightmap enable state captured before preview rendering. */
    private void restoreLightmap(boolean enabled)
    {
        if (enabled)
        {
            Minecraft.getMinecraft().entityRenderer.enableLightmap(0.0D);
        }
        else
        {
            Minecraft.getMinecraft().entityRenderer.disableLightmap(0.0D);
        }
    }

}
