package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.centered_yellow;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.BaseRoadPaintBlockContainer;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.centered_yellow.TileRpb_cy_dtr;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Rpb_cy_dtr extends BaseRoadPaintBlockContainer
{
    public Rpb_cy_dtr(Material p_i45394_1_)
    {
        super(p_i45394_1_);
        setBlockName("rpb_cy_dtr");
        setNameOfIcon("rpb_cy_dtr_icon");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileRpb_cy_dtr();
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        super.onBlockPlacedBy(world, x, y, z, entity, stack);
        //force tile spawn manually and override any existing tile at the space
        world.setTileEntity(x,y,z, new TileRpb_cy_dtr(getDir(entity)));
    }
}
