package com.bidahochi.BlockMod.blocks.overhead;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileOverhead_pole_scurve_16 extends BaseTileEntity
{
    public TileOverhead_pole_scurve_16(int dir)
    {
        super(dir);
    }

    public TileOverhead_pole_scurve_16()
    {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w
        if (dir==0){// north
            return AxisAlignedBB.getBoundingBox(xCoord-2, yCoord, zCoord-16, xCoord + 4, yCoord + 5, zCoord+1);
        }else if(dir==1){//east
            return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord-1, xCoord+16, yCoord + 5, zCoord + 4);
        }else if(dir==2){//south
            return AxisAlignedBB.getBoundingBox(xCoord-4, yCoord, zCoord, xCoord + 2, yCoord + 5, zCoord + 16);
        }else{//west
            return AxisAlignedBB.getBoundingBox(xCoord-16, yCoord, zCoord-4, xCoord+1, yCoord + 5, zCoord + 2);
        }
    }

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 16384.0D;
    }
}
