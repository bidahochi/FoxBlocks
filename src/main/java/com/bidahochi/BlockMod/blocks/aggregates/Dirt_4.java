package com.bidahochi.BlockMod.blocks.aggregates;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Dirt_4 extends Block {

    public Dirt_4(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Dirt_4");
        setHardness(0.5F);
        setResistance(0.1F);
        setHarvestLevel("shovel", 1);
        setStepSound(soundTypeGravel);
        setBlockTextureName(FoxBlocks.MODID+":aggregates/dirt_4");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTab);
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }

}
