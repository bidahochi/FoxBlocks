package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.network.IFoxBlocksPacket;
import com.bidahochi.BlockMod.network.PacketRPBSelect;
import com.bidahochi.BlockMod.network.PacketScrollingBlock;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PacketHandler {

    private final static List<Class> packetCarrier;
    static {
        packetCarrier = new ArrayList<Class>();
        packetCarrier.add(PacketRPBSelect.class);
        packetCarrier.add(PacketScrollingBlock.class);
    }

    @SubscribeEvent
    public void onServerPacket(FMLNetworkEvent.ServerCustomPacketEvent event) throws IOException {
        ByteBufInputStream bbis = new ByteBufInputStream(event.packet.payload());
        EntityPlayer entityPlayer = ((NetHandlerPlayServer) event.handler).playerEntity;
        int packetId = bbis.readInt();
        if (packetId < packetCarrier.size()) {
            try {
                IFoxBlocksPacket packetClass = (IFoxBlocksPacket) packetCarrier.get(packetId).newInstance();
                packetClass.processData(entityPlayer, bbis);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            FoxBlocks.blockLogger.log(Level.WARN, "Encountered out of range packet Id: " + packetId);
        }
        bbis.close();
    }

    public static void sendPacketToServer(IFoxBlocksPacket packet) {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeInt(packetCarrier.indexOf(packet.getClass()));

        try {
            packet.appendData(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FoxBlocks.channel.sendToServer(new FMLProxyPacket(new C17PacketCustomPayload(FoxBlocks.MODID, buffer)));
    }
}
