package com.bidahochi.BlockMod.items;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class bolsterChisel extends Item
{
    public bolsterChisel()
    {
        super();
        setMaxStackSize(1);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabItems);
        setContainerItem(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(FoxBlocks.MODID.toLowerCase() + ":bolsterchisel");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add("\u00a77" + EnumChatFormatting.GRAY + "Used to Cut FoxBlocks Blocks");
        par3List.add("\u00a77" + EnumChatFormatting.GRAY + "into Slabs, Stairs, & Walls");
    }
}
