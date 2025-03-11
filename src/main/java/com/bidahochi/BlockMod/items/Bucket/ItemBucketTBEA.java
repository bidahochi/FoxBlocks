package com.bidahochi.BlockMod.items.Bucket;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemBucketTBEA extends com.bidahochi.BlockMod.items.BaseItems.BaseItemBucket
{
    public ItemBucketTBEA(Block fluidBlock, String iconName)
    {
        super(fluidBlock, iconName);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
    {
        list.add("\u00a77" + EnumChatFormatting.DARK_PURPLE + "Bucket of TBEA the code monkey.");
    }
}
