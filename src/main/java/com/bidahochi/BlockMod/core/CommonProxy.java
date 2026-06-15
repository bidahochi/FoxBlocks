package com.bidahochi.BlockMod.core;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.MouseEventListener;
import com.bidahochi.BlockMod.core.handler.PacketHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.entity.player.EntityPlayer;

public class CommonProxy {

    public void registerMouseEventHandler() {
        MinecraftForge.EVENT_BUS.register(new MouseEventListener());
        FoxBlocks.channel.register(new PacketHandler());
    }

    public void openRoadPaintApplicatorGui(EntityPlayer player) {
    }
}
