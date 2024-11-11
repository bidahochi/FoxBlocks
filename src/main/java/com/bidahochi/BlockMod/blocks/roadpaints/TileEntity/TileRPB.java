package com.bidahochi.BlockMod.blocks.roadpaints.TileEntity;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import com.bidahochi.BlockMod.render.models.ModelRPBOffsetExtendedDiagonal;
import com.bidahochi.BlockMod.render.models.Modelrpb_full;
import com.bidahochi.BlockMod.render.models.Modelrpb_full_diag;
import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.Vec3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;

public class TileRPB extends BaseTileEntity {

    public String color;
    public String shape;
    public String offset;

    public ResourceLocation texture2;
    public ModelConverter model;
    public TileRPB(int dir, String color, String shape, String offset) {
        super(dir);
        this.dir = dir;
        this.color = color;
        this.shape = shape;
        this.offset = offset;
        getTextureAndModel(this);
    }

    public TileRPB() {

    }
    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-2, zCoord-1, xCoord+1, yCoord, zCoord+1);
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setInteger("direction", dir);
        if (color != null) {
            tag.setString("color", color);
        }
        if (shape != null) {
            tag.setString("shape", shape);
        }
        if (offset!= null) {
            tag.setString("offset", offset);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        dir = tag.getInteger("direction");
        color = tag.getString("color");
        shape = tag.getString("shape");
        offset = tag.getString("offset");
        getTextureAndModel(this);
        if(worldObj != null && worldObj.isRemote)
        {
            markDirty();
        }
    }

    public int getDir() {
        return dir;
    }

    public void getTextureAndModel(TileEntity tile) {
        if (tile instanceof TileRPB) {
            String color = ((TileRPB) tile).color;
            String lineOffset = ((TileRPB) tile).offset;
            String shape = ((TileRPB) tile).shape;
            color = color.toLowerCase();
            lineOffset = lineOffset.toLowerCase();
            shape = shape.toLowerCase();
            StringBuilder sb = new StringBuilder();
            sb.append(color);
            sb.append("/");
            sb.append(lineOffset);
            sb.append("/");
            sb.append(shape);
            sb.append(".png");
            setTexture2(sb.toString());
            if (shape.toLowerCase().contains("diagonal") && shape.toLowerCase().contains("offset")) {
                setModel(new Modelrpb_full_diag());
            }
            else if (shape.toLowerCase().contains("diagonal_extended")) {
                setModel(new ModelRPBOffsetExtendedDiagonal());
                if (!shape.contains("2")) {
                    setOffset(new Vec3f(8.0f, 0, 0));
                }
            }
            else if (shape.toLowerCase().contains("diagonal") || shape.toLowerCase().contains("dplus")) {
                setModel(new Modelrpb_full_diag());
            }
            else {
                setModel(new Modelrpb_full());
            }
        }
    }

    public void setModel(ModelConverter model)
    {
        this.model = model;
    }

    public void setOffset(Vec3f pos) {
        this.model.translateAll(pos.xCoord,pos.yCoord,pos.zCoord);
    }
    public void setTexture2(String nameOfTexture)
    {
        texture2 =  new ResourceLocation(FoxBlocks.MODID, "textures/blocks/roadpaints/" + nameOfTexture);
    }
}
