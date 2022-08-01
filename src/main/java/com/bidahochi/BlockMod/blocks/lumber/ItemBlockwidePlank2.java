package com.bidahochi.BlockMod.blocks.lumber;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockwidePlank2 extends ItemBlockWithMetadata {

    public ItemBlockwidePlank2(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName( ItemStack item){
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }
}
