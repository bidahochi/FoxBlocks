package com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.centered_yellow;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileRpb_cy_dtr extends BaseTileEntity
{
    public TileRpb_cy_dtr(int dir)
    {
        super(dir);
    }

    public TileRpb_cy_dtr()
    {

    }
    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-2, zCoord-1, xCoord+1, yCoord, zCoord+1);
    }
}
