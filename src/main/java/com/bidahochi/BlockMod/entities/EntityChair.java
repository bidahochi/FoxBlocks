package com.bidahochi.BlockMod.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityChair extends Entity
{
    public Vec3 blockPos;

    public EntityChair(World world)
    {
        super(world);
        this.noClip = true;
        isAirBorne = true;
        this.height = 0.01f;
        this.width = 0.01f;
    }

    public EntityChair(World world, Vec3 pos, com.bidahochi.BlockMod.render.tmt.Vec3d offset)
    {
        this(world);
        this.blockPos = pos;
        setPosition(pos.xCoord + 0.5D + offset.xCoord, pos.yCoord + offset.yCoord, pos.zCoord + offset.zCoord);
    }

    public EntityChair(World world, Vec3 pos, com.bidahochi.BlockMod.render.tmt.Vec3d offset, int rotation)
    {
        this(world);
        this.blockPos = pos;
        setPostionConsideringRotation(offset, rotation);
    }

    public void setPostionConsideringRotation(com.bidahochi.BlockMod.render.tmt.Vec3d offset, int rotation)
    {
        com.bidahochi.BlockMod.render.tmt.Vec3d rotPos = new com.bidahochi.BlockMod.render.tmt.Vec3d(offset.xCoord, offset.yCoord, offset.zCoord);

        //center our pos
        double posX = blockPos.xCoord < 0 ? blockPos.xCoord + 0.5 : blockPos.xCoord - 0.5;
        double posY = blockPos.yCoord < 0 ? 1 : blockPos.yCoord;
        double posZ = blockPos.zCoord < 0 ? blockPos.zCoord + 0.5 : blockPos.zCoord - 0.5;

        //rotate offset
        switch(rotation) {
            case 2:
                rotPos.xCoord = -offset.zCoord;
                rotPos.zCoord = offset.xCoord;
                break;
            case 0:
                rotPos.xCoord = offset.zCoord;
                rotPos.zCoord = -(offset.xCoord);
                break;
            case 3:
                rotPos.xCoord = -(offset.xCoord);
                rotPos.zCoord = offset.zCoord;
                break;
        }

        //apply offset
        posX += rotPos.xCoord;
        posY += rotPos.yCoord;
        posZ += rotPos.zCoord;

        if (posX > 0)
            posX++;
        if (posZ > 0)
            posZ++;

        setPosition(posX, posY, posZ);
    }

    @Override
    public void onEntityUpdate() 
    {
        if (this.worldObj.isRemote == false) 
        {
            if (this.riddenByEntity == null || this.worldObj.isAirBlock((int)blockPos.xCoord, (int)blockPos.yCoord, (int)blockPos.zCoord)) 
            {
                this.setDead();
            }
        }
    }
    
    @Override
    public double getMountedYOffset() {
        return 0;
    }

    @Override
    protected boolean shouldSetPosAfterLoading() {
        return false;
    }

    @Override
    public boolean isEntityInvulnerable() {
        return true;
    }

    @Override
    public boolean isInvisible() {
        return true;
    }

    @Override
    public void moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {}


    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
        this.setPosition(p_70056_1_, p_70056_3_, p_70056_5_);
        this.setRotation(p_70056_7_, p_70056_8_);
    }

    @Override
    protected void entityInit() {}

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {}

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {}

    @Override
    protected void fall(float p_70069_1_) {}
}
