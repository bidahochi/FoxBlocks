package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer;

import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRPB;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RPBYellow extends BaseRoadPaintBlockContainer
{


    public RPBYellow(Material p_i45394_1_)
    {
        super(p_i45394_1_);
        setBlockName("rpb_cy");
        setNameOfIcon("rpb_cy");
        offset = "center";
        color = "yellow";
    }
}
