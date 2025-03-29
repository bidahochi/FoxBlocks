package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.offset.Scrolling;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import net.minecraft.block.material.Material;

import static com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes.*;

public class srpb_whiteOffset extends ScrollRoadPaintBlock
{
    public srpb_whiteOffset()
    {
        super(Material.rock);
        setBlockName("srpb_whiteOffset");
        offset = "offset";
        color = "white";

        shapeTextures.put(straight, straight.shortName);
        //shapeTextures.put(turn, turn.shortName);
    }
}
