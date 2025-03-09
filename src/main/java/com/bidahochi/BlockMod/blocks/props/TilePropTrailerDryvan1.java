package com.bidahochi.BlockMod.blocks.props;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TilePropTrailerDryvan1 extends BaseTileEntity
{
    public TilePropTrailerDryvan1(int dir)
    {
        super(dir);
    }

    public TilePropTrailerDryvan1()
    {

    }
    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w. first set of coords are negative, 2nd set are positive.
        if (dir==0){// north
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord, zCoord-2, xCoord+1, yCoord+2, zCoord+5);
        }else if(dir==1){//east
            return AxisAlignedBB.getBoundingBox(xCoord-5, yCoord, zCoord-1, xCoord+2, yCoord+2, zCoord+1);
        }else if(dir==2){//south
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord, zCoord-5, xCoord+1, yCoord+2, zCoord+2);
        }else{//west
            return AxisAlignedBB.getBoundingBox(xCoord-5, yCoord, zCoord-1, xCoord+5, yCoord+2, zCoord+1);
        }
    }

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 16384.0D;
    }
}
