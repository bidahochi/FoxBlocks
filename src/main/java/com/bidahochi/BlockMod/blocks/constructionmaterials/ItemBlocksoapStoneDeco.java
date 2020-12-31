package com.bidahochi.BlockMod.blocks.constructionmaterials;
/**
 *
 *
 *  thats mamaluigi to you mario!
 *
 */

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlocksoapStoneDeco extends ItemBlockWithMetadata {

    public ItemBlocksoapStoneDeco(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName( ItemStack item){
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }
}
