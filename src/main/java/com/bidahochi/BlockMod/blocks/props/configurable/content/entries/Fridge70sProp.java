package com.bidahochi.BlockMod.blocks.props.configurable.content.entries;

import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropCatalogEntry;
import com.bidahochi.BlockMod.blocks.props.configurable.content.IConfigurablePropContentEntry;
import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropContentHelper;
import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropIds;
import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropSkinCatalog;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropBlockProperties;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropControllerType;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition.ModelFlipAxis;
import com.bidahochi.BlockMod.common.rotation.RotationSnap;

/** Registers the two-block 1970s refrigerator with a separate upper freezer. */
public final class Fridge70sProp implements IConfigurablePropContentEntry
{

    private static final String ID = "foxblocks:fridge_70s";
    private static final String PROFILE = ID;
    private static final String MODEL = "fridge_70s_tall";
    private static final String TEXTURE_ROOT =
            "textures/blocks/props/configurable/appliances/fridge_70s/";

    private static final ConfigurablePropSkinCatalog SKINS =
            ConfigurablePropContentHelper.skinCatalog(
                    PROFILE,
                    TEXTURE_ROOT + "fridge_70s_texture_{skin}.png"
            )
                    .defaultSkin("coolmint")
                    .skin("coolmint_noised")
                    .skin("girlyblue")
                    .skin("girlyblue_noised")
                    .skin("newbeige")
                    .skin("newbeige_noised");

    private final ConfigurablePropCatalogEntry entry = new ConfigurablePropCatalogEntry(
            "configurableProp70sFridge",
            "configurable_prop_70s_fridge",
            "props/configurable/appliances/fridge_70s/fridgeasset",
            new ConfigurablePropDefinition(
                    ID,
                    PROFILE,
                    SKINS.getDefaultSkinId(),
                    "container.foxblocks.fridge_70s",
                    MODEL,
                    ConfigurablePropIds.INTERACTION_FRIDGE_STORAGE,
                    RotationSnap.FOUR,
                    0,
                    1,
                    2,
                    1
                    )
                    .withControllerType(ConfigurablePropControllerType.STORAGE)
                    .withManualPlacementRotation()
                    .withCompartment(
                            "fridge",
                            "container.foxblocks.fridge_70s",
                            27,
                            0,
                            0,
                            0
                    )
                    .withCompartment(
                            "freezer",
                            "container.foxblocks.fridge_70s.freezer",
                            9,
                            0,
                            1,
                            0
                    )
                    .withBlockProperties(
                            ConfigurablePropBlockProperties.metal()
                                    .withHarvestTool("pickaxe", 1)
                    )
                    .withModelOffset(0.5D, 0.625D, 0.5D)
                    .withGuiPreviewScale(2.2F)
                    .withModelYawOffset(90.0F)
                    .withModelFlipEnabled()
                    .withModelFlipAxis(ModelFlipAxis.Z)
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
