package com.bidahochi.BlockMod.blocks.constructionmaterials;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockmortarBrick2 extends ItemBlockWithMetadata {

    public ItemBlockmortarBrick2(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName( ItemStack item){
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }
}
