package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.offset.SmartPaints;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.RoadPaintBlockOffsetInsideDiagonal;
import net.minecraft.block.material.Material;

public class RPBWhiteOffsetInsideDiagonal extends RoadPaintBlockOffsetInsideDiagonal {


    public RPBWhiteOffsetInsideDiagonal(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("rpb_owd"); //road paint block offset yellow
        setNameOfIcon("rpb_owd");
        offset = "offset";
        color = "white";
    }
}
