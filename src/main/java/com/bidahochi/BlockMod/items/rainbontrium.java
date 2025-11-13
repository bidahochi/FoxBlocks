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

public class rainbontrium extends Item {
    public rainbontrium() {
        super();
        setMaxStackSize(64);
        setUnlocalizedName("rainbontrium");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabItems);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(FoxBlocks.MODID.toLowerCase() + ":rainbontrium");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        //par3List.add("\u00a77" + EnumChatFormatting.LIGHT_PURPLE + "Highly Volatile");
        par3List.add("\u00a77" + EnumChatFormatting.RED + "H" + EnumChatFormatting.GOLD + "I" + EnumChatFormatting.YELLOW + "G" + EnumChatFormatting.GREEN + "H" + EnumChatFormatting.DARK_GREEN + "L" + EnumChatFormatting.DARK_AQUA + "Y");
        par3List.add("\u00a77" + EnumChatFormatting.AQUA + "V" + EnumChatFormatting.BLUE + "O" + EnumChatFormatting.DARK_BLUE + "L" + EnumChatFormatting.DARK_PURPLE+ "A" + EnumChatFormatting.LIGHT_PURPLE + "T" + EnumChatFormatting.RED + "I" + EnumChatFormatting.GOLD + "L" + EnumChatFormatting.YELLOW + "E");
    }
}
