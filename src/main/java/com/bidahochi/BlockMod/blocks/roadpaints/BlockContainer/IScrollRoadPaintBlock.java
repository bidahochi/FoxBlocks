package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer;

import com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes;

import java.util.LinkedHashMap;

public interface IScrollRoadPaintBlock
{
    LinkedHashMap<EnumRoadShapes, String> getShapeTextures();

    void SetCurrentShape(EnumRoadShapes enumRoadShapes);
}
