package com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.TileEntity;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileRoadCover1 extends BaseTileEntity
{
    public TileRoadCover1(int dir)
    {
        super(dir);
    }

    public TileRoadCover1()
    {

    }

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
        return 16384.0D;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        int ecks =0;
        int zee =0;
        int why =0;

        switch(dir) {

            case 0:{// north
                zee = -1;
                break;
            }
            case 1: {//east
                ecks = 1;
                break;
            }
            case 2: {//south
                zee = 1;
                break;
            }
            case 3: {//west
                ecks = -1;
                break;
            }
        }
        return AxisAlignedBB.getBoundingBox(xCoord-2+ecks, yCoord-2, zCoord-2+zee, xCoord+2+ecks, yCoord+2, zCoord+2+zee);
    }
}
