package com.bidahochi.BlockMod.blocks.roadpaints;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

public class ScrollingItemBlock extends ItemBlockWithMetadata {

    private final Block block;

    public ScrollingItemBlock(Block block) {
        super(block, block);
        this.block = block;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata)
    {
        return this.block.getIcon(2, metadata);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int metadata = itemStack.getItemDamage();
        return String.format("%s.%d", this.block.getUnlocalizedName(), metadata);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List flavorText, boolean par4)
    {
        flavorText.add("\u00a77" + "Shift+Scroll to");
        flavorText.add("\u00a77" + "Cycle Between Blocks");
    }
}
