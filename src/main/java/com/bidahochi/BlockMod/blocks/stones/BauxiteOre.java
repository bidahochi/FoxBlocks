package com.bidahochi.BlockMod.blocks.stones;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class BauxiteOre extends Block {

    public BauxiteOre(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Bauxite Ore");
        setHardness(3.5F);
        setResistance(6.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypePiston);
        setBlockTextureName(FoxBlocks.MODID+":stones/bauxite_ore");

    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}
