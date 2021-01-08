package com.bidahochi.BlockMod.blocks.hell;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class darkEmberStone extends Block {

    public darkEmberStone(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Dark Ember Stone");
        setHardness(3.0F);
        setResistance(30.0F);
        setHarvestLevel("pickaxe", 3);
        setStepSound(soundTypeStone);
        setBlockTextureName(FoxBlocks.MODID+":hell/darkEmberStone");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
    }
    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}

