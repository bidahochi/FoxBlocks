package com.bidahochi.BlockMod.network;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.io.IOException;

public class PacketRPBSelect implements IFoxBlocksPacket {

    private int slot = 0;
    private boolean posNeg = false;

    public PacketRPBSelect() {}

    public PacketRPBSelect(int slot, boolean posNeg) {
        this.slot = slot;
        this.posNeg = posNeg;
    }

    @Override
    public void processData(EntityPlayer entityPlayer, ByteBufInputStream bbis) throws IOException {
        int slot = bbis.readInt();
        boolean incDmg = bbis.readBoolean();
        ItemStack itemStack = entityPlayer.inventory.getStackInSlot(slot);

        if (itemStack != null && Block.getBlockFromItem(itemStack.getItem()) instanceof ScrollRoadPaintBlock) {

            int maxDmg = EnumRoadShapes.values().length - 1;
            int itemDmg = itemStack.getItemDamage();
            itemDmg += incDmg ? 1 : -1;
            if (itemDmg > maxDmg) {
                itemDmg = 0;
            } else if (itemDmg < 0) {
                itemDmg = maxDmg;
            }
            EnumRoadShapes key = EnumRoadShapes.values()[itemDmg];
            while (!((ScrollRoadPaintBlock)(Block.getBlockFromItem(itemStack.getItem()))).getShapeTextures().containsKey(key)) {
                itemDmg += incDmg ? 1 : -1;
                if (itemDmg > maxDmg) {
                    itemDmg = 0;
                } else if (itemDmg < 0) {
                    itemDmg = maxDmg;
                }
                key = EnumRoadShapes.values()[itemDmg];
            }
            itemStack.setItemDamage(itemDmg);
            ((ScrollRoadPaintBlock) Block.getBlockFromItem(itemStack.getItem())).currentShape = key;
        }
    }
    @Override
    public void appendData(ByteBuf buffer) throws IOException {
        buffer.writeInt(slot);
        buffer.writeBoolean(posNeg);
    }
}
