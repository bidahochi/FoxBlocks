package com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.TileEntity;

import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

public class TileRoadCoverDynamic1X3 extends BaseTileEntity
{
    public int roadCoverMaterial;
    public int roadCoverMetadata;

    public TileRoadCoverDynamic1X3(int dir)
    {
        super(dir);
    }

    public TileRoadCoverDynamic1X3()
    {

    }

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
        return 16384.0D;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("roadCoverMetadata", roadCoverMetadata);
        if (roadCoverMaterial  != 0)
        {
            nbt.setInteger("roadCoverMaterial", roadCoverMaterial);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        roadCoverMetadata = nbt.getInteger("roadCoverMetadata");
        roadCoverMaterial = nbt.hasKey("roadCoverMaterial") ? nbt.getInteger("roadCoverMaterial") : 0;
    }

    public void setRoadCoverMaterial(int material)
    {
        this.roadCoverMaterial = material;
    }

    public void setRoadCoverMetadata(int metadata)
    {
        this.roadCoverMetadata = metadata;
    }

    public int getRoadCoverMaterial()
    {
        return roadCoverMaterial == 0 ? 0 : roadCoverMaterial;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        switch(dir)
        {
            case 2:  // north
                return AxisAlignedBB.getBoundingBox(xCoord - 3, yCoord - 3, zCoord - 4, xCoord + 3, yCoord + 3, zCoord);
            case 3:  // east
                return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord - 3, zCoord - 2, xCoord + 5, yCoord + 3, zCoord + 2);
            case 0:  // south
                return AxisAlignedBB.getBoundingBox(xCoord - 3, yCoord - 3, zCoord, xCoord + 3, yCoord + 3, zCoord + 4);
            default: // west
                return AxisAlignedBB.getBoundingBox(xCoord - 5, yCoord - 3, zCoord - 2, xCoord + 3, yCoord + 3, zCoord + 2);
        }
    }
}
