package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer;

import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRPB;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RPBWhite extends BaseRoadPaintBlockContainer
{


    public RPBWhite(Material p_i45394_1_)
    {
        super(p_i45394_1_);
        setBlockName("rpb_cw");
        setNameOfIcon("rpb_cw");
        offset = "center";
        color = "white";
    }
}
