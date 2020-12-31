package com.bidahochi.BlockMod.blocks.essentiallymemes;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Although extends Block {

    public Although(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Although");
        setHardness(25.0F);
        setResistance(30.0F);
        setHarvestLevel("hoe", 3);
        setStepSound(soundTypeCloth);
        setLightLevel(1.5F);
        setBlockTextureName(FoxBlocks.MODID+":although");
    }
    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}
