package com.bidahochi.BlockMod.network;

import com.bidahochi.BlockMod.core.handler.ItemIDs;
import com.bidahochi.BlockMod.items.ItemRoadPaintApplicator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import java.io.IOException;

public class PacketRoadPaintApplicatorRefill implements IFoxBlocksPacket {
    private int slot;

    public PacketRoadPaintApplicatorRefill() {
    }

    public PacketRoadPaintApplicatorRefill(int slot) {
        this.slot = slot;
    }

    @Override
    public void processData(EntityPlayer player, ByteBufInputStream input) throws IOException {
        int requestedSlot = input.readInt();
        if (requestedSlot != player.inventory.currentItem) {
            return;
        }
        ItemStack applicator = player.inventory.getStackInSlot(requestedSlot);
        if (applicator == null || !(applicator.getItem() instanceof ItemRoadPaintApplicator)
                || ItemRoadPaintApplicator.getCharges(applicator) >= ItemRoadPaintApplicator.MAX_CHARGES) {
            return;
        }

        for (int i = 0; i < player.inventory.mainInventory.length; i++) {
            ItemStack candidate = player.inventory.mainInventory[i];
            if (candidate != null && candidate.getItem() == ItemIDs.paintCompound.item) {
                ItemRoadPaintApplicator.setCharges(applicator,
                        ItemRoadPaintApplicator.getCharges(applicator)
                                + ItemRoadPaintApplicator.PAINT_COMPOUND_CHARGES);
                if (!player.capabilities.isCreativeMode && --candidate.stackSize <= 0) {
                    player.inventory.mainInventory[i] = null;
                }
                player.inventory.markDirty();
                if (player instanceof EntityPlayerMP) {
                    ((EntityPlayerMP) player).inventoryContainer.detectAndSendChanges();
                }
                return;
            }
        }
    }

    @Override
    public void appendData(ByteBuf buffer) throws IOException {
        buffer.writeInt(slot);
    }
}
