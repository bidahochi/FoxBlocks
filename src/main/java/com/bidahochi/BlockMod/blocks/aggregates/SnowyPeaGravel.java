package com.bidahochi.BlockMod.blocks.aggregates;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class SnowyPeaGravel extends BlockFalling {

    public SnowyPeaGravel(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Snowy Pea Gravel");

        setBlockTextureName(FoxBlocks.MODID+":peagravel_snow");

    }
}
