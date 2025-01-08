package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.center;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.HashMap;

import static com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes.*;

public class SRPBYellowCenter extends ScrollRoadPaintBlock {

    public SRPBYellowCenter(Material mat) {
        super(mat);
        setBlockName("srpb_cy");
        offset = "center";
        color = "yellow";

        shapeTextures.put(straight, straight.shortName);
        shapeTextures.put(turn, turn.shortName);
        shapeTextures.put(tIntersection, tIntersection.shortName);
        shapeTextures.put(plus, tIntersection.shortName);
        shapeTextures.put(diagonal, diagonal.shortName);
        shapeTextures.put(diagonalTurnLeft, diagonalTurnLeft.shortName);
        shapeTextures.put(diagonalTurnRight, diagonalTurnRight.shortName);
        shapeTextures.put(yIntersection, yIntersection.shortName);
        shapeTextures.put(diagonalPlus, diagonalPlus.shortName);
    }
}
