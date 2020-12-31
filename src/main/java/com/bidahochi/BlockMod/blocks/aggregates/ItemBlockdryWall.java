package com.bidahochi.BlockMod.blocks.aggregates;
/**
 *  ItemBlock for dryWall
 *
 *  -hariesh
 *
 */

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockdryWall extends ItemBlockWithMetadata {

    public ItemBlockdryWall(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName( ItemStack item){
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }
}
