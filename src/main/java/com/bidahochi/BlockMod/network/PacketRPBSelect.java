package com.bidahochi.BlockMod.network;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.IScrollRoadPaintBlock;
import com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes;
import com.bidahochi.BlockMod.utils.HelperUtils;
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

        if (itemStack != null && Block.getBlockFromItem(itemStack.getItem()) instanceof IScrollRoadPaintBlock)
        {
            IScrollRoadPaintBlock theBlock = (IScrollRoadPaintBlock)Block.getBlockFromItem(itemStack.getItem());
            int maxDmg = theBlock.getShapeTextures().size() - 1;
            int itemDmg = itemStack.getItemDamage();
            itemDmg += incDmg ? 1 : -1;
            if (itemDmg > maxDmg) {
                itemDmg = 0;
            } else if (itemDmg < 0) {
                itemDmg = maxDmg;
            }
            EnumRoadShapes key = HelperUtils.getKeyByIndex(theBlock.getShapeTextures(), itemDmg);
            while (!theBlock.getShapeTextures().containsKey(key))
            {
                itemDmg += incDmg ? 1 : -1;
                if (itemDmg > maxDmg) {
                    itemDmg = 0;
                } else if (itemDmg < 0) {
                    itemDmg = maxDmg;
                }
                key = HelperUtils.getKeyByIndex(theBlock.getShapeTextures(), itemDmg);
            }
            itemStack.setItemDamage(itemDmg);
            theBlock.SetCurrentShape(key);
        }
    }
    @Override
    public void appendData(ByteBuf buffer) throws IOException {
        buffer.writeInt(slot);
        buffer.writeBoolean(posNeg);
    }
}
