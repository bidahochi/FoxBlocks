package com.bidahochi.BlockMod.blocks.overhead;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileOverhead_pole_scurve_8 extends BaseTileEntity
{
    public TileOverhead_pole_scurve_8(int dir)
    {
        super(dir);
    }

    public TileOverhead_pole_scurve_8()
    {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w
        if (dir==0){// north
            return AxisAlignedBB.getBoundingBox(xCoord-2, yCoord, zCoord-8, xCoord + 2, yCoord + 5, zCoord+1);
        }else if(dir==1){//east
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord, zCoord-1, xCoord+8, yCoord + 5, zCoord + 3);
        }else if(dir==2){//south
            return AxisAlignedBB.getBoundingBox(xCoord-2, yCoord, zCoord, xCoord + 2, yCoord + 5, zCoord + 8);
        }else{//west
            return AxisAlignedBB.getBoundingBox(xCoord-8, yCoord, zCoord-2, xCoord+1, yCoord + 5, zCoord + 2);
        }

    }

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 16384.0D;
    }
}
