package com.bidahochi.BlockMod.core;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.MouseEventListener;
import com.bidahochi.BlockMod.core.handler.PacketHandler;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

    public void registerMouseEventHandler() {
        MinecraftForge.EVENT_BUS.register(new MouseEventListener());
        FoxBlocks.channel.register(new PacketHandler());
    }
}
