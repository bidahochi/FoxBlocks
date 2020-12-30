package com.bidahochi.BlockMod.blocks.stones;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BauxiteOre extends Block {

    public BauxiteOre(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Bauxite Ore");
        setHardness(1F);
        setStepSound(Block.soundTypeMetal);
        setBlockTextureName(FoxBlocks.MODID+":bauxite_ore");

    }
}
