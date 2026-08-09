package com.bidahochi.BlockMod.blocks.streetStuff;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileHwyBarrier extends BaseTileEntity
{
    public TileHwyBarrier(int dir)
    {
        super(dir);
    }

    public TileHwyBarrier()
    { }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w. first set of coords are negative, 2nd set are positive.
        if (dir==0){// north
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-1, zCoord-1, xCoord+1, yCoord+1, zCoord+1);
        }else if(dir==1){//east
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-1, zCoord-1, xCoord+1, yCoord+1, zCoord+1);
        }else if(dir==2){//south
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-1, zCoord-1, xCoord+1, yCoord+1, zCoord+1);
        }else{//west
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-1, zCoord-1, xCoord+1, yCoord+1, zCoord+1);
        }
    }
}
