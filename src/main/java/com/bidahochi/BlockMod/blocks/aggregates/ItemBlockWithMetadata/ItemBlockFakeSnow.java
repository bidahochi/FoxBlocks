package com.bidahochi.BlockMod.blocks.aggregates.ItemBlockWithMetadata;

import com.bidahochi.BlockMod.items.BaseItems.BaseItemBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemBlockFakeSnow extends BaseItemBlock
{
    public ItemBlockFakeSnow(Block block) {
        super(block);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("\u00a77" + EnumChatFormatting.ITALIC + "Trust me, there's always a need for Fake Snow");
    }
}
