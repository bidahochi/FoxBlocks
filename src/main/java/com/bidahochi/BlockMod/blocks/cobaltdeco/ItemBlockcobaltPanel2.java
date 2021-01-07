package com.bidahochi.BlockMod.blocks.cobaltdeco;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockcobaltPanel2 extends ItemBlockWithMetadata {
    public ItemBlockcobaltPanel2(Block p_i45326_1_) {
        super(p_i45326_1_, p_i45326_1_);
    }

    public String getUnlocalizedName(ItemStack item) {
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }
}
