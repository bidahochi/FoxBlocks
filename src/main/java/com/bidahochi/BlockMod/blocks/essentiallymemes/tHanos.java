package com.bidahochi.BlockMod.blocks.essentiallymemes;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class tHanos extends Block {

    public tHanos(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("T Hanos");
        setHardness(1.0F);
        setResistance(69.0F);
        setHarvestLevel("shovel", 2);
        setStepSound(soundTypeCloth);
        setBlockTextureName(FoxBlocks.MODID+":thanos");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTab);
    }
    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}
