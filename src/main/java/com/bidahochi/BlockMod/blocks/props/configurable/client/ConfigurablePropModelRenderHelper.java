package com.bidahochi.BlockMod.blocks.props.configurable.client;

import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import com.bidahochi.BlockMod.common.rotation.client.RotationRenderHelper;
import com.bidahochi.BlockMod.customization.data.AppearanceData;
import com.bidahochi.BlockMod.customization.registry.AppearanceTextureRegistry;
import com.bidahochi.BlockMod.render.tmt.ModelBase;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;

/** Applies shared transforms, texture groups, color properties, and flip state to prop models. */
@SideOnly(Side.CLIENT)
public final class ConfigurablePropModelRenderHelper
{

    /** Prevents construction of this static utility class. */
    private ConfigurablePropModelRenderHelper()
    {
    }

    /**
     * Renders a model with canonical rotation, configured flip, optional
     * property-driven group colors, and independently selected group textures.
     *
     * @param definition definition supplying transform and render-target bindings
     * @param model shared model instance to render without retaining per-prop state
     * @param rotation horizontal world rotation
     * @param modelFlipped whether the placed instance requests an authored mirror
     * @param appearance validated trait values used for colors and texture rules
     * @param baseTexture fallback texture when no appearance rule matches
     */
    public static void renderModel(
            ConfigurablePropDefinition definition,
            ModelBase model,
            RotationAmount rotation,
            boolean modelFlipped,
            AppearanceData appearance,
            ResourceLocation baseTexture
    )
    {
        renderModel(
                definition,
                model,
                rotation,
                modelFlipped,
                appearance,
                baseTexture,
                1.0F
        );
    }

    /**
     * Renders a model with caller-selected opacity while retaining all normal
     * appearance texture and color-property behavior.
     *
     * @param definition definition supplying transform and render-target bindings
     * @param model shared model instance to render without retaining per-prop state
     * @param rotation horizontal world rotation
     * @param modelFlipped whether the placed instance requests an authored mirror
     * @param appearance validated trait values used for colors and texture rules
     * @param baseTexture fallback texture when no appearance rule matches
     * @param opacity requested alpha from {@code 0.0} to {@code 1.0}; values are clamped
     */
    public static void renderModel(
            ConfigurablePropDefinition definition,
            ModelBase model,
            RotationAmount rotation,
            boolean modelFlipped,
            AppearanceData appearance,
            ResourceLocation baseTexture,
            float opacity
    )
    {
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
        RotationRenderHelper.rotateY(rotation, 0.0F, false);
        GL11.glRotatef(definition.getModelYawOffset(), 0.0F, 1.0F, 0.0F);
        boolean flipped = modelFlipped && definition.isModelFlipEnabled();
        boolean cullEnabled = flipped && GL11.glIsEnabled(GL11.GL_CULL_FACE);
        if (flipped)
        {
            if (definition.getModelFlipAxis() == ConfigurablePropDefinition.ModelFlipAxis.Z)
            {
                GL11.glScalef(1.0F, 1.0F, -1.0F);
            }
            else
            {
                GL11.glScalef(-1.0F, 1.0F, 1.0F);
            }
            if (cullEnabled)
            {
                GL11.glDisable(GL11.GL_CULL_FACE);
            }
        }
        try
        {
            if (model instanceof IConfigurablePropGroupedModel)
            {
                IConfigurablePropGroupedModel groupedModel =
                        (IConfigurablePropGroupedModel) model;
                for (String groupId : groupedModel.getTextureGroups())
                {
                    applyColor(definition, groupId, appearance, opacity);
                    Tessellator.bindTexture(AppearanceTextureRegistry.resolveGroupTexture(
                            definition.getId(),
                            groupId,
                            appearance,
                            baseTexture
                    ));
                    groupedModel.renderTextureGroup(groupId, 0.0625F);
                }
            }
            else
            {
                applyColor(definition, null, appearance, opacity);
                Tessellator.bindTexture(baseTexture);
                model.render(null, 0, 0, 0, 0, 0, 0.0625F);
            }
        }
        finally
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if (cullEnabled)
            {
                GL11.glEnable(GL11.GL_CULL_FACE);
            }
        }
    }

    /** Applies a render target's configured color property, or neutral white. */
    private static void applyColor(
            ConfigurablePropDefinition definition,
            String groupId,
            AppearanceData appearance,
            float opacity
    )
    {
        String colorTraitId = definition.getColorTraitId(groupId);
        int color = colorTraitId != null
                ? appearance.getIntegerTrait(colorTraitId, 0xFFFFFFFF)
                : 0xFFFFFFFF;
        GL11.glColor4f(
                ((color >> 16) & 255) / 255.0F,
                ((color >> 8) & 255) / 255.0F,
                (color & 255) / 255.0F,
                Math.max(0.0F, Math.min(1.0F, opacity))
        );
    }
}
