package com.bidahochi.BlockMod.items.BaseItems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class BaseItemBlock_1XTile extends ItemBlockWithMetadata {
    public BaseItemBlock_1XTile(Block block)
    {
        super(block, block);
    }

    public String getUnlocalizedName(ItemStack item)
    {
        return this.getUnlocalizedName() + (this.getUnlocalizedName().contains("_1XTile") ? "" : "_1XTile") + "_" + item.getItemDamage();
    }
}
