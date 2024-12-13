package com.bidahochi.BlockMod.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import net.minecraft.entity.player.EntityPlayer;

import java.io.IOException;

public interface IFoxBlocksPacket {

    public void processData(EntityPlayer entityPlayer, ByteBufInputStream bbis) throws IOException;

    public void appendData(ByteBuf buffer) throws IOException;

}
