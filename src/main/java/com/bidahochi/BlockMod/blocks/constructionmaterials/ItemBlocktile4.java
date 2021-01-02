package com.bidahochi.BlockMod.blocks.constructionmaterials;
/**
 *  ItemBlock for dryWall
 *
 *  -hariesh
 *
 */

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlocktile4 extends ItemBlockWithMetadata {

    public ItemBlocktile4(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName( ItemStack item){
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }
}
