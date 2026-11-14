package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.IScrollRoadPaintBlock;
import com.bidahochi.BlockMod.blocks.scrolling.IFoxBlocksScrollingBlock;
import com.bidahochi.BlockMod.blocks.scrolling.IFoxBlocksScrollingItem;
import com.bidahochi.BlockMod.network.PacketRPBSelect;
import com.bidahochi.BlockMod.network.PacketScrollingBlock;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.MouseEvent;

public class MouseEventListener {

    /**
     * Grabs mouse scroll events for slope selection.
     */

    public long lastScroll = 0;

    /** Routes sneak-scroll on supported held items without changing the selected hotbar slot. */
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onMouseEvent(MouseEvent event)
    {
        // We only want to process wheel events
        if (event.button < 0 && event.dwheel != 0)
        {
            EntityPlayer entityPlayer = Minecraft.getMinecraft().thePlayer;
            if (entityPlayer != null && entityPlayer.isSneaking())
            {
                ItemStack itemStack = entityPlayer.getHeldItem();
                if (itemStack != null)
                {
                    boolean scrollItem = itemStack.getItem() instanceof IFoxBlocksScrollingItem;
                    Block block = null;
                    if (scrollItem == false && itemStack.getItem() instanceof ItemBlock)
                    {
                        block = Block.getBlockFromItem(itemStack.getItem());
                    }
                    if (block instanceof IScrollRoadPaintBlock)
                    {
                        if (System.currentTimeMillis() - lastScroll < 300)
                        { //limit how fast you can scroll through the items
                            event.setCanceled(true);
                            return;
                        }
                        PacketHandler.sendPacketToServer(new PacketRPBSelect(entityPlayer.inventory.currentItem, event.dwheel > 0));
                        lastScroll = System.currentTimeMillis();
                        event.setCanceled(true);
                    }

                    if (scrollItem || block instanceof IFoxBlocksScrollingBlock)
                    {
                        if (System.currentTimeMillis() - lastScroll < 300)
                        {
                            event.setCanceled(true);
                            return;
                        }

                        int selectedSlot = entityPlayer.inventory.currentItem;
                        boolean forward = event.dwheel > 0;
                        PacketScrollingBlock packet = new PacketScrollingBlock(selectedSlot, forward);
                        PacketHandler.sendPacketToServer(packet);

                        lastScroll = System.currentTimeMillis();
                        event.setCanceled(true);
                    }
                }
            }
        }
    }
}
