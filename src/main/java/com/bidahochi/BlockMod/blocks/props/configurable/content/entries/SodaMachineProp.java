package com.bidahochi.BlockMod.blocks.props.configurable.content.entries;

import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropCatalogEntry;
import com.bidahochi.BlockMod.blocks.props.configurable.content.IConfigurablePropContentEntry;
import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropContentHelper;
import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropSkinCatalog;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropBlockProperties;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropControllerType;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.common.rotation.RotationSnap;

/** Registers the migrated soda-machine configurable prop. */
public final class SodaMachineProp implements IConfigurablePropContentEntry
{

    /** Stable definition ID shared with converted legacy tiles. */
    public static final String ID = "foxblocks:soda_machine";
    private static final String PROFILE = ID;
    /** Stable default skin ID shared with converted legacy tiles. */
    public static final String SKIN = PROFILE;
    private static final String MODEL = "soda_machine";
    private static final ConfigurablePropSkinCatalog SKINS =
            ConfigurablePropContentHelper.singleSkinCatalog(
                    PROFILE,
                    "textures/blocks/props/soda_machine1.png"
            );

    private final ConfigurablePropCatalogEntry entry = new ConfigurablePropCatalogEntry(
            "soda_machine",
            "soda_machine",
            "props/soda_machine",
            new ConfigurablePropDefinition(
                    ID,
                    PROFILE,
                    SKINS.getDefaultSkinId(),
                    "container.foxblocks.soda_machine",
                    MODEL,
                    "",
                    RotationSnap.SIXTEEN,
                    0,
                    1,
                    1,
                    1
            )
                    .withControllerType(ConfigurablePropControllerType.PROCESSOR)
                    .withManualPlacementRotation()
                    .withBlockProperties(ConfigurablePropBlockProperties.stone()
                            .withHarvestTool("pickaxe", 1))
                    .withModelOffset(0.5D, 0.62D, 0.5D)
                    .withModelYawOffset(270.0F)
                    .withGuiPreviewYawOffset(180.0F)
                    // Preserves the old soda machine's player-facing placement baseline.
                    .withPlacementYawOffset(180.0F)
    );

    /** {@inheritDoc} */
    @Override
    public ConfigurablePropCatalogEntry getCatalogEntry()
    {
        return entry;
    }

    /** {@inheritDoc} */
    @Override
    public void registerCustomization()
    {
        SKINS.register();
    }
}
