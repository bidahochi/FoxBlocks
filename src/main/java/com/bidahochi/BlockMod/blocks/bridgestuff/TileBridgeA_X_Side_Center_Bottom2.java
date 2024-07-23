package com.bidahochi.BlockMod.blocks.bridgestuff;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileBridgeA_X_Side_Center_Bottom2 extends BaseTileEntity
{
    public TileBridgeA_X_Side_Center_Bottom2(int dir)
    {
        super(dir);
    }

    public TileBridgeA_X_Side_Center_Bottom2()
    {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-5, zCoord-1, xCoord + 6, yCoord + 1, zCoord + 1);
    }
}
