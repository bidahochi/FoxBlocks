package com.bidahochi.BlockMod.blocks.bridgestuff.tileEntity;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileBridgeA_Side_Bottom extends BaseTileEntity
{
    public TileBridgeA_Side_Bottom(int dir)
    {
        super(dir);
    }

    public TileBridgeA_Side_Bottom()
    {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-5, zCoord-1, xCoord + 2, yCoord + 4, zCoord + 2);
    }
    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 16384.0D;
    }
}
