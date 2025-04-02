package com.bidahochi.BlockMod.items;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class SittingStairTileBlock extends net.minecraft.item.ItemBlockWithMetadata
{
    public SittingStairTileBlock(Block block)
    {
        super(block, block);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(FoxBlocks.MODID.toLowerCase() + ":sittingStairTile");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List flavorText, boolean par4)
    {
        flavorText.add("\u00a77" + "Place on top of a block");
        flavorText.add("\u00a77" + "to sit on a stair.");
    }
}
