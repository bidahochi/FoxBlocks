package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.offset.Scrolling;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import net.minecraft.block.material.Material;

import static com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes.*;

public class SRPBYellowOffset extends ScrollRoadPaintBlock
{
    public SRPBYellowOffset()
    {
        super(Material.rock);
        setBlockName("srpb_yellowOffset");
        offset = "offset";
        color = "yellow";

        shapeTextures.put(straight, straight.shortName);
        shapeTextures.put(turn, turn.shortName);
        shapeTextures.put(turn2, turn2.shortName);
        shapeTextures.put(diagonal, diagonal.shortName);
        shapeTextures.put(diagonal2, diagonal2.shortName);
    }
}
