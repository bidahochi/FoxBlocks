package com.bidahochi.BlockMod.blocks.essentiallymemes;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockBooBlox extends ItemBlockWithMetadata {

    public ItemBlockBooBlox(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName( ItemStack item){
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }
}
