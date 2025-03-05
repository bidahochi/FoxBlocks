package com.bidahochi.BlockMod.core.util;

import com.bidahochi.BlockMod.entities.EntityChair;
import com.bidahochi.BlockMod.render.tmt.Vec3d;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class ChairUtility
{
    public static boolean sitOnBlock(World world, Vec3d pos, EntityPlayer player, Vec3d offset) {

        if(!world.isRemote && !player.isSneaking() && !checkForExistingSeat(world, pos.xCoord, pos.yCoord, pos.zCoord, player)) {
            EntityChair seat = new EntityChair(world, Vec3.createVectorHelper(pos.xCoord,pos.yCoord,pos.zCoord), offset);
            world.spawnEntityInWorld(seat);
            player.mountEntity(seat);
        }
        return true;
    }

    public static boolean sitOnBlockWithRotationOffset(World world, Vec3d pos, EntityPlayer player, Vec3d offset, int metadata) {
        if(!world.isRemote && !player.isSneaking() && !checkForExistingSeat(world, pos.xCoord, pos.yCoord, pos.zCoord, player)) {
            EntityChair seat = new EntityChair(world, Vec3.createVectorHelper(pos.xCoord,pos.yCoord,pos.zCoord), offset, metadata);
            world.spawnEntityInWorld(seat);
            player.mountEntity(seat);
        }
        return true;
    }

    private static boolean checkForExistingSeat(World world, double x, double y, double z, EntityPlayer player) {
        if(!world.isRemote) {
            List<EntityChair> seats = world.getEntitiesWithinAABB(EntityChair.class, AxisAlignedBB.getBoundingBox(x-5, y-5, z-5, x + 5.0D, y + 5.0D, z + 5.0D));
            for(EntityChair seat : seats) {
                if(seat.posX == x && seat.posY == y && seat.posZ == z) {
                    if(seat.riddenByEntity == null) {
                        player.mountEntity(seat);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSomeoneSitting(World world, double x, double y, double z) {
        if(!world.isRemote) {
            List<EntityChair> seats = world.getEntitiesWithinAABB(EntityChair.class, AxisAlignedBB.getBoundingBox(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D));
            for(EntityChair seat : seats) {
                if(seat.blockPos.xCoord == x && seat.blockPos.yCoord == y && seat.blockPos.zCoord == z) {
                    return seat.riddenByEntity != null;
                }
            }
        }
        return false;
    }
}
