package com.bidahochi.BlockMod.blocks.lumber;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockwidePlank extends ItemBlockWithMetadata {

    public ItemBlockwidePlank(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName( ItemStack item){
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }
}
