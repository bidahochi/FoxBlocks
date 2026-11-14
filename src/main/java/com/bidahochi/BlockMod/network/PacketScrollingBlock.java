package com.bidahochi.BlockMod.network;

import com.bidahochi.BlockMod.blocks.bridgestuff.BlockContainer.BridgeA_Center;
import com.bidahochi.BlockMod.blocks.bridgestuff.BlockContainer.BridgeA_CenterDiag;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.IScrollRoadPaintBlock;
import com.bidahochi.BlockMod.blocks.scrolling.IFoxBlocksScrollingBlock;
import com.bidahochi.BlockMod.blocks.scrolling.IFoxBlocksScrollingItem;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import com.bidahochi.BlockMod.core.handler.IFoxBlockIDs;
import com.bidahochi.BlockMod.core.register.ScrollBlockRegistry;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
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

    /** Applies a scroll request to an item in the player's inventory. */
    @Override
    public void processData(EntityPlayer entityPlayer, ByteBufInputStream bbis) throws IOException
    {
        // Forge sends the backing array, so a valid request can include trailing padding.
        int minimumPayloadBytes = Integer.BYTES + 1;
        if (bbis.available() < minimumPayloadBytes)
        {
            return;
        }
        int slot = bbis.readInt();
        int direction = bbis.readUnsignedByte();
        boolean incDmg = direction != 0;
        if (slot < 0 || slot >= entityPlayer.inventory.mainInventory.length)
        {
            return;
        }
        ItemStack itemStack = entityPlayer.inventory.getStackInSlot(slot);

        if (itemStack == null)
        {
            return;
        }

        if (itemStack.getItem() instanceof IFoxBlocksScrollingItem)
        {
            scrollItemMode(entityPlayer, itemStack, slot, direction);
            return;
        }

        Block block = Block.getBlockFromItem(itemStack.getItem());

        if (block instanceof IFoxBlocksScrollingBlock)
        {
            IFoxBlocksScrollingBlock theBlock = (IFoxBlocksScrollingBlock)block;

            LinkedList<Block> list = ScrollBlockRegistry.get(theBlock.getScrollListID());
            entityPlayer.inventory.setInventorySlotContents(slot, new ItemStack(shift(list, list.indexOf(block), incDmg), itemStack.stackSize));
        }
    }

    /** Updates the selected item on the server and sends its new mode to the client. */
    private static void scrollItemMode(EntityPlayer player, ItemStack stack, int slot, int direction)
    {
        if ((player instanceof EntityPlayerMP) == false || player.isSneaking() == false)
        {
            return;
        }
        boolean selectedHotbarSlot = slot < InventoryPlayer.getHotbarSize() && slot == player.inventory.currentItem;
        if (selectedHotbarSlot == false || stack.stackSize <= 0 || direction > 1)
        {
            return;
        }

        IFoxBlocksScrollingItem item = (IFoxBlocksScrollingItem) stack.getItem();
        boolean forward = direction == 1;
        item.cycleMode(stack, forward);
        player.inventory.markDirty();
        player.inventoryContainer.detectAndSendChanges();
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
