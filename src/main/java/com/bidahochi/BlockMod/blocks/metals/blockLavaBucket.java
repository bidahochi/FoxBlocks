package com.bidahochi.BlockMod.blocks.metals;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class blockLavaBucket extends Block {

    public blockLavaBucket(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("BlockOLavaBucket");
        setHardness(1F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 2);
        setStepSound(soundTypeStone);
        setLightLevel(3F);
        setBlockTextureName(FoxBlocks.MODID+":metals/block_o_lava_bucket");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTab);
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}
