package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.offset.SmartPaints;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.RoadPaintBlockOffsetInsideStraight;
import net.minecraft.block.material.Material;

public class RPBWhiteOffsetInsideStraight extends RoadPaintBlockOffsetInsideStraight {


    public RPBWhiteOffsetInsideStraight(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("rpb_ows"); //road paint block offset yellow
        setNameOfIcon("rpb_ows");
        offset = "offset";
        color = "white";
    }
}
