package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.IScrollRoadPaintBlock;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import com.bidahochi.BlockMod.network.PacketRPBSelect;
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
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onMouseEvent(MouseEvent event) {
        // We only want to process wheel events
        if (event.button < 0 && event.dwheel != 0) {
            EntityPlayer entityPlayer = Minecraft.getMinecraft().thePlayer;
            if (entityPlayer != null && entityPlayer.isSneaking()) {
                ItemStack itemStack = entityPlayer.getHeldItem();
                if (itemStack != null && itemStack.getItem() instanceof ItemBlock &&
                        Block.getBlockFromItem(itemStack.getItem()) instanceof IScrollRoadPaintBlock) {
                    if (System.currentTimeMillis() - lastScroll < 300) { //limit how fast you can scroll through the items
                        event.setCanceled(true);
                        return;
                    }
                    PacketHandler.sendPacketToServer(new PacketRPBSelect(entityPlayer.inventory.currentItem, event.dwheel > 0));
                    lastScroll = System.currentTimeMillis();
                    event.setCanceled(true);
                }
            }
        }
    }
}
