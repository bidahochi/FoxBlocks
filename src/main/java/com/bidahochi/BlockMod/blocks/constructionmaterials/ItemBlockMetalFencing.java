package com.bidahochi.BlockMod.blocks.constructionmaterials;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockMetalFencing extends ItemBlockWithMetadata {

    public ItemBlockMetalFencing(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName( ItemStack item){
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }
}
