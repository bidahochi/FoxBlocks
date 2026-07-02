package com.bidahochi.BlockMod.blocks.props;

import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileClearanceCone1 extends BaseTileEntity
{
    public TileClearanceCone1(int dir)
    {
        super(dir);
    }

    public TileClearanceCone1()
    { }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w. first set of coords are negative, 2nd set are positive.
        return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-1, zCoord-1, xCoord+1, yCoord, zCoord+1);
    }
}
