package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.center;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes;
import net.minecraft.block.material.Material;

import java.util.HashMap;

public class SRPBYellowCenter extends ScrollRoadPaintBlock {

    public SRPBYellowCenter(Material mat) {
        super(mat);
        setBlockName("srpb_cy");
        offset = "center";
        color = "yellow";
        shapeTextures.put(EnumRoadShapes.straight, "straight");
        shapeTextures.put(EnumRoadShapes.turn, "turn");
        shapeTextures.put(EnumRoadShapes.tIntersection, "t");
        shapeTextures.put(EnumRoadShapes.plus, "plus");
        shapeTextures.put(EnumRoadShapes.diagonal, "diagonal");
        shapeTextures.put(EnumRoadShapes.diagonalTurnLeft, "diagonal_left");
        shapeTextures.put(EnumRoadShapes.diagonalTurnRight, "diagonal_right");
        shapeTextures.put(EnumRoadShapes.yIntersection, "y");
        shapeTextures.put(EnumRoadShapes.diagonalPlus, "dplus");
    }
}
