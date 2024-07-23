package com.bidahochi.BlockMod.blocks.overhead;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileOverhead_pole_switch_6 extends BaseTileEntity
{
    public TileOverhead_pole_switch_6(int dir)
    {
        super(dir);
    }

    public TileOverhead_pole_switch_6()
    {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w
        if (dir==0){// north
            return AxisAlignedBB.getBoundingBox(xCoord-6, yCoord, zCoord-7, xCoord + 1, yCoord + 5, zCoord);
        }else if(dir==1){//east
            return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord-6, xCoord+7, yCoord + 5, zCoord + 1);
        }else if(dir==2){//south
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord, zCoord, xCoord + 6, yCoord + 5, zCoord + 7);
        }else{//west
            return AxisAlignedBB.getBoundingBox(xCoord-7, yCoord, zCoord-1, xCoord, yCoord + 5, zCoord + 6);
        }
    }

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 16384.0D;
    }
}
