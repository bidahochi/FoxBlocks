package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.center.Scrolling;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import net.minecraft.block.material.Material;

import static com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes.*;

public class SRPBYellowSingleDoubles extends ScrollRoadPaintBlock {

    public SRPBYellowSingleDoubles(Material mat) {
        super(mat);
        setBlockName("srpb_cysd");
        offset = "center3";
        color = "yellow";

        //i need 10 of these so lets see if this works
        //actually i only need 8 of them
        shapeTextures.put(straight, straight.shortName);//straight
        shapeTextures.put(detail1, detail1.shortName);//diag
        shapeTextures.put(detail2, detail2.shortName);//left turn
        shapeTextures.put(detail3, detail3.shortName);//left diag left
        shapeTextures.put(detail4, detail4.shortName);//left  diag right
        shapeTextures.put(detail5, detail5.shortName);//right turn
        shapeTextures.put(detail6, detail6.shortName);//right diag left
        shapeTextures.put(detail7, detail7.shortName);//right diag right
    }
}
