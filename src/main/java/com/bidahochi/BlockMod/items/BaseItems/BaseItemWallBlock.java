package com.bidahochi.BlockMod.items.BaseItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class BaseItemWallBlock extends ItemBlockWithMetadata
{
    public BaseItemWallBlock(Block block)
    {
        super(block, block);
    }

    public String getUnlocalizedName(ItemStack item)
    {
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
    {
        list.add("\u00a77" + EnumChatFormatting.GREEN + "Modern Minecraft Styled Wall");
    }
}
