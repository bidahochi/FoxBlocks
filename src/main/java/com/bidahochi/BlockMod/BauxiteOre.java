package com.bidahochi.BlockMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import static com.bidahochi.BlockMod.BlockMod.foxBlocksCreativeTab;

public class BauxiteOre extends Block {
    protected BauxiteOre(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Bauxite Ore");
        setBlockTextureName(BlockMod.MODID+":bauxite_ore");
        setCreativeTab(foxBlocksCreativeTab);
    }
}
