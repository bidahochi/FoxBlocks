package com.bidahochi.BlockMod.network;

import com.bidahochi.BlockMod.blocks.roadpaints.RoadPaintCatalog;
import com.bidahochi.BlockMod.items.ItemRoadPaintApplicator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import java.io.IOException;

public class PacketRoadPaintApplicatorSettings implements IFoxBlocksPacket {
    private int slot;
    private int selection;
    private int rotation;
    private boolean manualRotation;
    private boolean layered;
    private int heightOverride;
    private int guiCategory;
    private int guiPage;

    public PacketRoadPaintApplicatorSettings() {
    }

    public PacketRoadPaintApplicatorSettings(int slot, int selection, int rotation,
                                             boolean manualRotation, boolean layered,
                                             int heightOverride, int guiCategory, int guiPage) {
        this.slot = slot;
        this.selection = selection;
        this.rotation = rotation;
        this.manualRotation = manualRotation;
        this.layered = layered;
        this.heightOverride = heightOverride;
        this.guiCategory = guiCategory;
        this.guiPage = guiPage;
    }

    @Override
    public void processData(EntityPlayer player, ByteBufInputStream input) throws IOException {
        int requestedSlot = input.readInt();
        int requestedSelection = input.readInt();
        int requestedRotation = input.readInt();
        boolean requestedManualRotation = input.readBoolean();
        boolean requestedLayered = input.readBoolean();
        int requestedHeightOverride = input.readInt();
        int requestedCategory = input.readInt();
        int requestedPage = input.readInt();
        if (requestedSlot != player.inventory.currentItem
                || RoadPaintCatalog.get(requestedSelection) == null
                || requestedCategory < 0
                || requestedCategory >= RoadPaintCatalog.Category.values().length
                || ItemRoadPaintApplicator.normalizeHeightOverride(requestedHeightOverride)
                != requestedHeightOverride
                || requestedPage < 0) {
            return;
        }
        ItemStack stack = player.inventory.getStackInSlot(requestedSlot);
        if (stack != null && stack.getItem() instanceof ItemRoadPaintApplicator) {
            ItemRoadPaintApplicator.setSettings(stack, requestedSelection, requestedRotation,
                    requestedManualRotation, requestedLayered, requestedHeightOverride,
                    requestedCategory, requestedPage);
            if (player instanceof EntityPlayerMP) {
                ((EntityPlayerMP) player).inventoryContainer.detectAndSendChanges();
            }
        }
    }

    @Override
    public void appendData(ByteBuf buffer) throws IOException {
        buffer.writeInt(slot);
        buffer.writeInt(selection);
        buffer.writeInt(rotation);
        buffer.writeBoolean(manualRotation);
        buffer.writeBoolean(layered);
        buffer.writeInt(heightOverride);
        buffer.writeInt(guiCategory);
        buffer.writeInt(guiPage);
    }
}
