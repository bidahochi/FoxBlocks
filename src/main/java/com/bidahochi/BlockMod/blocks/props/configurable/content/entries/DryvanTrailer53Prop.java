package com.bidahochi.BlockMod.blocks.props.configurable.content.entries;

import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropCatalogEntry;
import com.bidahochi.BlockMod.blocks.props.configurable.content.IConfigurablePropContentEntry;
import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropContentHelper;
import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropSkinCatalog;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropBlockProperties;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.common.rotation.RotationSnap;

/** Registers the migrated 53-foot dry-van trailer configurable prop. */
public final class DryvanTrailer53Prop implements IConfigurablePropContentEntry
{

    /** Stable definition ID shared with converted legacy tiles. */
    public static final String ID = "foxblocks:dryvan_trailer_53ft";
    private static final String PROFILE = ID;
    /** Stable default skin ID shared with converted legacy tiles. */
    public static final String SKIN = PROFILE;
    private static final String MODEL = "dryvan_trailer_53ft";
    private static final ConfigurablePropSkinCatalog SKINS =
            ConfigurablePropContentHelper.singleSkinCatalog(
                    PROFILE,
                    "textures/blocks/props/53ft_dryvan_2.png"
            );

    private final ConfigurablePropCatalogEntry entry = new ConfigurablePropCatalogEntry(
            "propTrailerDryvan1",
            "propTrailerDryvan1",
            "props/propTrailerDryvan1",
            createDefinition(ID)
    );

    /** {@inheritDoc} */
    @Override
    public ConfigurablePropCatalogEntry getCatalogEntry()
    {
        return entry;
    }

    /**
     * Builds the trailer definition registered by this catalog entry. Legacy
     * tile adapters share its stable ID and skin constants.
     *
     * @param id stable definition identifier assigned to the returned definition
     * @return fully configured dry-van trailer definition
     */
    public static ConfigurablePropDefinition createDefinition(String id)
    {
        return new ConfigurablePropDefinition(
                id,
                PROFILE,
                SKINS.getDefaultSkinId(),
                "container.foxblocks.dryvan_trailer_53ft",
                MODEL,
                "",
                RotationSnap.SIXTEEN,
                0,
                1,
                1,
                1
        )
                .withManualPlacementRotation()
                .withBlockProperties(ConfigurablePropBlockProperties.wood()
                        .withResistance(4.0F)
                        .withHarvestTool("pickaxe", 0))
                .withModelOffset(0.5D, 0.625D, 0.5D)
                .withGuiPreviewScale(0.7F)
                .withModelYawOffset(270.0F)
                .withGuiPreviewYawOffset(90.0F)
                // Preserves the old dryvan's player-facing placement baseline.
                .withPlacementYawOffset(180.0F)
                .withRenderBounds(6, 2)
                .withEntityCollision(false)
                .withAutoHeightAdjustment();
    }

    /** {@inheritDoc} */
    @Override
    public void registerCustomization()
    {
        SKINS.register();
    }
}
