package com.bidahochi.BlockMod.blocks.props.configurable.client;

import com.bidahochi.BlockMod.blocks.props.configurable.model.ModelCubert70sFridge2BlockTall;
import com.bidahochi.BlockMod.render.models.ModelPropTrailerDryvan;
import com.bidahochi.BlockMod.render.models.Modelsoda_machine;
import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/** Registers built-in model factories after the client environment is available. */
@SideOnly(Side.CLIENT)
public final class ConfigurablePropClientModels
{

    private static boolean registered;

    /** Prevents construction of this static utility class. */
    private ConfigurablePropClientModels()
    {
    }

    /** Registers every built-in definition-facing model ID once. */
    public static void registerDefaults()
    {
        if (registered)
        {
            return;
        }
        registered = true;

        register("fridge_70s_tall", new IConfigurablePropModelFactory()
        {
            /** {@inheritDoc} */
            @Override
            public ModelConverter createModel()
            {
                return new ModelCubert70sFridge2BlockTall();
            }
        });
        register("dryvan_trailer_53ft", new IConfigurablePropModelFactory()
        {
            /** {@inheritDoc} */
            @Override
            public ModelConverter createModel()
            {
                return new ModelPropTrailerDryvan();
            }
        });
        register("soda_machine", new IConfigurablePropModelFactory()
        {
            /** {@inheritDoc} */
            @Override
            public ModelConverter createModel()
            {
                return new Modelsoda_machine();
            }
        });
    }

    /** Delegates a built-in model factory to the shared client registry. */
    private static void register(String modelId, IConfigurablePropModelFactory factory)
    {
        ConfigurablePropModelRegistry.register(modelId, factory);
    }
}
