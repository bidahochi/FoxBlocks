package com.bidahochi.BlockMod.blocks.aggregates;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PeaGravel extends BlockFalling {

    public PeaGravel(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Pea Gravel");
        setHardness(0.5F);
        setResistance(0.1F);
        setHarvestLevel("shovel", 0);
        setStepSound(soundTypeGravel);
        setBlockTextureName(FoxBlocks.MODID+":peagravel_generic");
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }

}
