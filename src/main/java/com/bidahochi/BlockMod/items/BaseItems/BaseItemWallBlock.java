package com.bidahochi.BlockMod.items.BaseItems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

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
}
