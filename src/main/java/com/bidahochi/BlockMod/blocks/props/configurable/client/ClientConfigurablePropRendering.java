package com.bidahochi.BlockMod.blocks.props.configurable.client;

import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropProcessor;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropStorage;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.MinecraftForge;

/** Registers client-only models, rendering, and adjusted prop targeting. */
@SideOnly(Side.CLIENT)
public final class ClientConfigurablePropRendering
{

    /** Prevents construction of this static utility class. */
    private ClientConfigurablePropRendering()
    {
    }

    /** Installs client model factories, renderers, and offset-target correction. */
    public static void register()
    {
        ConfigurablePropClientModels.registerDefaults();
        RenderConfigurableProp renderer = new RenderConfigurableProp();
        ClientRegistry.bindTileEntitySpecialRenderer(
                TileConfigurablePropController.class,
                renderer
        );
        ClientRegistry.bindTileEntitySpecialRenderer(
                TileConfigurablePropStorage.class,
                renderer
        );
        ClientRegistry.bindTileEntitySpecialRenderer(
                TileConfigurablePropProcessor.class,
                renderer
        );
        ClientConfigurablePropTargeting targeting = new ClientConfigurablePropTargeting();
        MinecraftForge.EVENT_BUS.register(targeting);
        FMLCommonHandler.instance().bus().register(targeting);
        MinecraftForge.EVENT_BUS.register(new ConfigurablePropPlacementPreviewRenderer());
    }
}
