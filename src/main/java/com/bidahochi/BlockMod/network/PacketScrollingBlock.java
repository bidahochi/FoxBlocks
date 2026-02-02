package com.bidahochi.BlockMod.network;

import com.bidahochi.BlockMod.blocks.bridgestuff.BlockContainer.BridgeA_Center;
import com.bidahochi.BlockMod.blocks.bridgestuff.BlockContainer.BridgeA_CenterDiag;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.IScrollRoadPaintBlock;
import com.bidahochi.BlockMod.blocks.scrolling.IFoxBlocksScrollingBlock;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import com.bidahochi.BlockMod.core.handler.IFoxBlockIDs;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class PacketScrollingBlock implements IFoxBlocksPacket
{
    private int slot = 0;
    private boolean posNeg = false;

    public PacketScrollingBlock()
    {

    }

    public PacketScrollingBlock(int slot, boolean posNeg) {
        this.slot = slot;
        this.posNeg = posNeg;
    }

    @Override
    public void processData(EntityPlayer entityPlayer, ByteBufInputStream bbis) throws IOException
    {
        int slot = bbis.readInt();
        boolean incDmg = bbis.readBoolean();
        ItemStack itemStack = entityPlayer.inventory.getStackInSlot(slot);

        if (itemStack == null)
        {
            return;
        }

        Block block = Block.getBlockFromItem(itemStack.getItem());

        if (block instanceof IFoxBlocksScrollingBlock)
        {
            IFoxBlocksScrollingBlock theBlock = (IFoxBlocksScrollingBlock)block;
            switch (theBlock.getScrollListID())
            {
                case 0:
                {
                    LinkedList<Block> list = new LinkedList<>();
                    list.add(BlockIDs.bridgeA_Center.GetBlock());
                    list.add(BlockIDs.bridgeA_CenterDiag.GetBlock());

                    entityPlayer.inventory.setInventorySlotContents(slot, new ItemStack(shift(list, list.indexOf(block), incDmg), itemStack.stackSize));
                }
                break;
                case 1:
                {
                    LinkedList<Block> list = new LinkedList<>();
                    list.add(BlockIDs.bridgeA_Side_Bottom.GetBlock());
                    list.add(BlockIDs.bridgeA_Side_BottomDiag.GetBlock());
                    list.add(BlockIDs.bridgeA_Side_Top.GetBlock());
                    list.add(BlockIDs.bridgeA_Side_TopDiag.GetBlock());

                    entityPlayer.inventory.setInventorySlotContents(slot, new ItemStack(shift(list, list.indexOf(block), incDmg), itemStack.stackSize));
                }
                break;
                case 2:
                {
                    LinkedList<Block> list = new LinkedList<>();
                    list.add(BlockIDs.bridgeA_X_Side_Bottom.GetBlock());
                    list.add(BlockIDs.bridgeA_X_Side_Bottom2.GetBlock());
                    list.add(BlockIDs.bridgeA_X_Side_BottomDiag.GetBlock());
                    list.add(BlockIDs.bridgeA_X_Side_Top.GetBlock());
                    list.add(BlockIDs.bridgeA_X_Side_Top2.GetBlock());
                    list.add(BlockIDs.bridgeA_X_Side_TopDiag.GetBlock());

                    entityPlayer.inventory.setInventorySlotContents(slot, new ItemStack(shift(list, list.indexOf(block), incDmg), itemStack.stackSize));
                }
                break;
            }


        }
    }

    private Block shift(LinkedList<Block> list, int currentPos, boolean incDmg)
    {
        if (incDmg)
        {
            if (list.size() > currentPos + 1)
            {
                return list.get(currentPos + 1);
            }
            else
            {
                return list.get(0);
            }
        }
        else
        {
            if (currentPos - 1 >= 0)
            {
                return list.get(currentPos - 1);
            }
            else
            {
                return list.get(list.size()-1);
            }
        }
    }

    @Override
    public void appendData(ByteBuf buffer) throws IOException {
        buffer.writeInt(slot);
        buffer.writeBoolean(posNeg);
    }
}
