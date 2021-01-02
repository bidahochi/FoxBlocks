package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class baseStair extends BlockStairs{

    protected baseStair(Block p_i45428_1_, int p_i45428_2_, String name, float hardness, float blockResistance ,SoundType stepSound, String harvestTool, int harvestLevel, float lightValue) {
        super(p_i45428_1_, p_i45428_2_);
        setBlockName(name);
        setHardness(hardness);
        setStepSound(stepSound);
        setHarvestLevel(harvestTool, harvestLevel);
        setResistance(blockResistance);
        setLightLevel(lightValue);
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}
