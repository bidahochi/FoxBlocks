package com.bidahochi.BlockMod.blocks.roadpaints.TileEntity;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileRpb_cy_s extends BaseTileEntity
{
    public TileRpb_cy_s(int dir)
    {
        super(dir);
    }

    public TileRpb_cy_s()
    {

    }
    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return AxisAlignedBB.getBoundingBox(xCoord, yCoord-2, zCoord, xCoord, yCoord, zCoord);
    }
}
