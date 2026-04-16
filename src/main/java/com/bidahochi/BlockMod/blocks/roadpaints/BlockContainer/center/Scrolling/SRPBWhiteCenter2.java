package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.center.Scrolling;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import net.minecraft.block.material.Material;

import static com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes.*;

public class SRPBWhiteCenter2 extends ScrollRoadPaintBlock {

    public SRPBWhiteCenter2(Material mat) {
        super(mat);
        setBlockName("srpb_cw2");
        offset = "center2";
        color = "white";

        shapeTextures.put(straight, straight.shortName);
        shapeTextures.put(turn, turn.shortName);
        shapeTextures.put(tIntersection, tIntersection.shortName);
        shapeTextures.put(plus, plus.shortName);
        shapeTextures.put(diagonal, diagonal.shortName);
        shapeTextures.put(diagonalTurnLeft, diagonalTurnLeft.shortName);
        shapeTextures.put(diagonalTurnRight, diagonalTurnRight.shortName);
        shapeTextures.put(yIntersection, yIntersection.shortName);
        shapeTextures.put(diagonalPlus, diagonalPlus.shortName);
    }
}
