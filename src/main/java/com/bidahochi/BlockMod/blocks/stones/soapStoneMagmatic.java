package com.bidahochi.BlockMod.blocks.stones;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class soapStoneMagmatic extends Block {

    public soapStoneMagmatic(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Magmatic Soapstone");
        setHardness(5F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeStone);
        setLightLevel(0.5F);
        setBlockTextureName(FoxBlocks.MODID+":stones/soapstone_magmatic");
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}
