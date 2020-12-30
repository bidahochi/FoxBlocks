package com.bidahochi.BlockMod.blocks.essentiallymemes;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class Although extends Block {

    public Although(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Although");
        setLightLevel(3F);
        setStepSound(Block.soundTypeAnvil);
        setResistance(4F);
        setHardness(2F);
        setBlockTextureName(FoxBlocks.MODID+":although");

    }
}
