package com.bidahochi.BlockMod.core;

import com.bidahochi.BlockMod.blocks.props.configurable.client.ClientConfigurablePropRendering;
import com.bidahochi.BlockMod.blocks.roadpaints.gui.GuiRoadPaintApplicator;
import com.bidahochi.BlockMod.core.handler.RoadPaintApplicatorHud;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerMouseEventHandler() {
        super.registerMouseEventHandler();
        MinecraftForge.EVENT_BUS.register(new RoadPaintApplicatorHud());
    }

    @Override
    public void openRoadPaintApplicatorGui(EntityPlayer player) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiRoadPaintApplicator(player));
    }

    @Override
    public void registerConfigurablePropRenderers() {
        ClientConfigurablePropRendering.register();
    }
}
