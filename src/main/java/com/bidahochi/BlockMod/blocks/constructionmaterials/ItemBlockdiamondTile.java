package com.bidahochi.BlockMod.blocks.constructionmaterials;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockdiamondTile extends ItemBlockWithMetadata {
    public ItemBlockdiamondTile(Block p_i45326_1_) {
        super(p_i45326_1_, p_i45326_1_);
    }

    public String getUnlocalizedName(ItemStack item) {
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }
}
