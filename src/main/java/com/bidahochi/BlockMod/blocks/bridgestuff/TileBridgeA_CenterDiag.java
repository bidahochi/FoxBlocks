package com.bidahochi.BlockMod.blocks.bridgestuff;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileBridgeA_CenterDiag extends BaseTileEntity
{
    public TileBridgeA_CenterDiag(int dir)
    {
        super(dir);
    }

    public TileBridgeA_CenterDiag()
    {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-5, zCoord-1, xCoord + 1, yCoord + 1, zCoord + 1);
    }
    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 16384.0D;
    }
}
