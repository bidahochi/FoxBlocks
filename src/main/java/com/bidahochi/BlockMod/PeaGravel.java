package com.bidahochi.BlockMod;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class PeaGravel extends BlockFalling {

    protected PeaGravel(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Pea Gravel");
        setLightLevel(1F);
        setBlockTextureName(FoxBlocks.MODID+":peagravel_generic");
    }
}
