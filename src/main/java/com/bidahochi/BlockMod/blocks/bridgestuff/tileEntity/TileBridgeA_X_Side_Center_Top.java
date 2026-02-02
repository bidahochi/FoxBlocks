package com.bidahochi.BlockMod.blocks.bridgestuff.tileEntity;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileBridgeA_X_Side_Center_Top extends BaseTileEntity
{
    public TileBridgeA_X_Side_Center_Top(int dir)
    {
        super(dir);
    }

    public TileBridgeA_X_Side_Center_Top()
    {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w, first 3 coords are negative 2nd 3 are positive
        if (dir==0){// north
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-5, zCoord-5, xCoord, yCoord, zCoord);
        }else if(dir==1){//east
            return AxisAlignedBB.getBoundingBox(xCoord, yCoord-5, zCoord-1, xCoord+5, yCoord, zCoord);
        }else if(dir==2){//south
            return AxisAlignedBB.getBoundingBox(xCoord, yCoord-5, zCoord, xCoord+1, yCoord, zCoord+5);
        }else{//west
            return AxisAlignedBB.getBoundingBox(xCoord-5, yCoord-5, zCoord, xCoord, yCoord, zCoord+1);
        }

        //return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-5, zCoord-1, xCoord + 4, yCoord + 1, zCoord + 1);
    }

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 16384.0D;
    }
}
