package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.details.Scrolling;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import net.minecraft.block.material.Material;

import static com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes.*;

public class SRPBDetailsWhite1 extends ScrollRoadPaintBlock
{

    public SRPBDetailsWhite1(Material mat) {
        super(mat);
        setBlockName("srpb_dw1");
        offset = "detail";
        color = "white";

        shapeTextures.put(detail1, detail1.shortName);
        shapeTextures.put(detail2, detail2.shortName);
        shapeTextures.put(detail3, detail3.shortName);
        shapeTextures.put(detail4, detail4.shortName);
        shapeTextures.put(detail5, detail5.shortName);
        shapeTextures.put(detail6, detail6.shortName);
        shapeTextures.put(detail7, detail7.shortName);
        //shapeTextures.put(detail8, detail8.shortName);

    }
}
