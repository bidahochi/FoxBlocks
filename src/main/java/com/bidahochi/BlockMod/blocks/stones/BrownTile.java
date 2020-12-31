package com.bidahochi.BlockMod.blocks.stones;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BrownTile extends Block {

    public BrownTile(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Brown Tile");
        setHardness(1.7F);
        setResistance(7.0F);
        setHarvestLevel("pickaxe", 0);
        setStepSound(soundTypePiston);
        setBlockTextureName(FoxBlocks.MODID+":BrownTile");
    }
    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}
