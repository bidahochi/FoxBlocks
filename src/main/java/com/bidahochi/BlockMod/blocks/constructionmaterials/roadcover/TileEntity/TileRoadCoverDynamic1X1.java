package com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.TileEntity;

import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

public class TileRoadCoverDynamic1X1 extends BaseTileEntity
{
    public int roadCoverMaterial;
    public int roadCoverMetadata;

    public TileRoadCoverDynamic1X1(int dir)
    {
        super(dir);
    }

    public TileRoadCoverDynamic1X1()
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
        int ecks =0;
        int zee =0;
        int why =0;

        switch(dir)
        {

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
