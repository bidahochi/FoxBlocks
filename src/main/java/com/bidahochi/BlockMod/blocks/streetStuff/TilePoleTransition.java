package com.bidahochi.BlockMod.blocks.streetStuff;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TilePoleTransition extends BaseTileEntity
{
    public TilePoleTransition(int dir)
    {
        super(dir);
    }

    public TilePoleTransition()
    { }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w
        if (dir==0){// north
            return AxisAlignedBB.getBoundingBox(xCoord-2, yCoord-1, zCoord-1, xCoord+1, yCoord+1, zCoord+1);
        }else if(dir==1){//east
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-1, zCoord-2, xCoord+1, yCoord+1, zCoord+1);
        }else if(dir==2){//south
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-1, zCoord-1, xCoord+2, yCoord+1, zCoord+1);
        }else{//west
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-1, zCoord-1, xCoord+1, yCoord+1, zCoord+2);
        }
    }
}
