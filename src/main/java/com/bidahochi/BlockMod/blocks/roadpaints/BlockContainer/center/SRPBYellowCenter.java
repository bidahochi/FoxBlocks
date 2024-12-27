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

public class SRPBYellowCenter extends ScrollRoadPaintBlock {

    public SRPBYellowCenter(Material mat) {
        super(mat);
        setBlockName("srpb_cy");
        offset = "center";
        color = "yellow";

        for (EnumRoadShapes shape: EnumRoadShapes.values())
        {
            shapeTextures.put(shape, shape.shortName);
        }
    }
}
