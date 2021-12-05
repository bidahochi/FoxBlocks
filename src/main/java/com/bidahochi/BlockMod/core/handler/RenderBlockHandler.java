package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.blocks.constructionmaterials.RenderBreakerBox;
import com.bidahochi.BlockMod.blocks.constructionmaterials.RenderBreakerBox2;
import com.bidahochi.BlockMod.blocks.constructionmaterials.TileBreakerBox;
import com.bidahochi.BlockMod.blocks.constructionmaterials.TileBreakerBox2;
import com.bidahochi.BlockMod.blocks.lighting.RenderNeonCageLampRoof;
import com.bidahochi.BlockMod.blocks.lighting.TileNeonCageLampRoof;
import com.bidahochi.BlockMod.blocks.props.*;
import cpw.mods.fml.client.registry.ClientRegistry;

public class RenderBlockHandler {
    public static void initializeCustomModels() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileBreakerBox.class, new RenderBreakerBox());
        ClientRegistry.bindTileEntitySpecialRenderer(TileBreakerBox2.class, new RenderBreakerBox2());

        ClientRegistry.bindTileEntitySpecialRenderer(TileClampOnSignDerail.class, new RenderClampOnSignDerail());
        ClientRegistry.bindTileEntitySpecialRenderer(TileClampOnSignStop1.class, new RenderClampOnSignStop1());
        ClientRegistry.bindTileEntitySpecialRenderer(TileClampOnSignStop2.class, new RenderClampOnSignStop2());

        ClientRegistry.bindTileEntitySpecialRenderer(TileNeonCageLampRoof.class, new RenderNeonCageLampRoof());
    }
}
