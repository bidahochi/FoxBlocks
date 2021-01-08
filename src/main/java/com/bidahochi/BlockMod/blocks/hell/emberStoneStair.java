package com.bidahochi.BlockMod.blocks.hell;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class emberStoneStair extends BlockStairs {

    public emberStoneStair(Block p_i45428_1_, int p_i45428_2_ ) {
        super(p_i45428_1_, p_i45428_2_);
        setBlockName("Ember Stair");
        setHardness(3F);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}
