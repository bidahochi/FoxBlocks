package com.bidahochi.BlockMod.blocks.metals;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class WornVent2 extends Block {

    public WornVent2(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("WornVent2");
        setHardness(1F);
        setResistance(2.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeMetal);
        setBlockTextureName(FoxBlocks.MODID+":metals/worn_vent_2");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabFactory);
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }

}
