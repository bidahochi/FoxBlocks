package com.bidahochi.BlockMod.blocks.roadpaints.TileEntity;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.BlockContainer.*;
import com.bidahochi.BlockMod.render.models.ModelRPBOffsetExtendedDiagonal;
import com.bidahochi.BlockMod.render.models.Modelrpb_full;
import com.bidahochi.BlockMod.render.models.Modelrpb_full_diag;
import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.Vec3f;
import com.bidahochi.BlockMod.utils.FBMultiPartHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileRPB extends BaseTileEntity
{

    public final float evaluateYOffset()
    {

        Block block = worldObj.getBlock(xCoord,yCoord-1, zCoord);
        if((block instanceof BlockSlab && block.isNormalCube() == false)
                || (FoxBlocks.isForgeMultiPartLoaded && FBMultiPartHelper.BlockInstanceOfBlockMultipart(block) && FBMultiPartHelper.isBlockSolid(block, this) == false))
        {
            return 0.5F;
        }
        else if (block instanceof RoadCover0
                || block instanceof RoadCover1
                || block instanceof RoadCover2
                || block instanceof RoadCover3
                || block instanceof RoadCover4
                || block instanceof RoadCover5
                || block instanceof RoadCover6
                || block instanceof RoadCoverDynamic1X1 || block instanceof RoadCoverDynamic1X2 || block instanceof RoadCoverDynamic1X3
                || block.getUnlocalizedName().contains("tcRail"))
        {
            return 0.93F;
        }

        return 0;
    }

    public String color;
    public String shape;
    public String offset;

    public ResourceLocation texture2;
    public ModelConverter model;

    public TileRPB(int dir, String color, String shape, String offset, ItemStack stack) {//looking for shortName?
        super(dir);
        if (shape.equalsIgnoreCase("diagonal")) {
            this.dir = (dir + 1) & 3;
        }
        else if (shape.equalsIgnoreCase("diagonal_left")) {
            this.dir = (dir + 2) & 3;
        }
        else if (shape.equalsIgnoreCase("diagonal_right")) {
            this.dir = (dir + 2) & 3;
        }
        else if (shape.equalsIgnoreCase("t")) {
            this.dir = (dir + 1) & 3;
        }
        else if (shape.equalsIgnoreCase("dt1") || shape.equalsIgnoreCase("dt2") || shape.equalsIgnoreCase("dt3") || shape.equalsIgnoreCase("dt4")
        || shape.equalsIgnoreCase("dt5") || shape.equalsIgnoreCase("dt6") || shape.equalsIgnoreCase("dt7") || shape.equalsIgnoreCase("dt8")) {
            this.dir = (dir + 1) & 3;
        }
        else {
            this.dir = dir;
        }
        this.color = color;
        this.shape = shape;
        this.offset = offset;
        this.blockMetadata = stack.getItemDamage();
        getTextureAndModel(this);
    }

    public TileRPB(int dir, String color, String shape, String offset) {
        super(dir);
        if (shape.equalsIgnoreCase("diagonal")) {
            this.dir = (dir + 1) & 3;
        }
        else if (shape.equalsIgnoreCase("diagonal_left")) {
            this.dir = (dir + 2) & 3;
        }
        else if (shape.equalsIgnoreCase("diagonal_right")) {
            this.dir = (dir + 2) & 3;
        }
        else if (shape.equalsIgnoreCase("t")) {
            this.dir = (dir + 1) & 3;
        }
        else if (shape.equalsIgnoreCase("dt1") || shape.equalsIgnoreCase("dt2") || shape.equalsIgnoreCase("dt3") || shape.equalsIgnoreCase("dt4")
                || shape.equalsIgnoreCase("dt5") || shape.equalsIgnoreCase("dt6") || shape.equalsIgnoreCase("dt7") || shape.equalsIgnoreCase("dt8")) {
            this.dir = (dir + 1) & 3;
        }
        else {
            this.dir = dir;
        }
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

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
        return 16384.0D;
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

    public void getTextureAndModel(TileEntity tile)
    {
        if (tile instanceof TileRPB)
        {
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

    @Override
    public boolean canUpdate()
    {
        return false;
    }
}
