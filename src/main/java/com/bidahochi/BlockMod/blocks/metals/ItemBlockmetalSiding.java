package com.bidahochi.BlockMod.blocks.metals;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockmetalSiding extends ItemBlockWithMetadata {

    public ItemBlockmetalSiding(Block block) {
        super(block, block);
    }
    public String getUnlocalizedName( ItemStack item){
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }

}
