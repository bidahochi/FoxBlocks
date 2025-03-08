package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import com.bidahochi.BlockMod.core.util.ChairUtility;
import com.bidahochi.BlockMod.render.tmt.Vec3d;
import com.bidahochi.BlockMod.render.tmt.Vec3f;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BaseBlockSittable extends BlockContainer
{
    public Vec3f[] seatPos = null;

    public BaseBlockSittable(Material material){
        super(material);
    }

    @Override
    public TileEntity createTileEntity(World world, int meta)
    {
        return createNewTileEntity(world, meta);
    }

    @Override
    public boolean onBlockActivated(World world, int hitX, int hitY, int hitZ, EntityPlayer player, int sideHit, float vecX, float vecY, float vecZ)
    {
        if (seatPos != null)
        {
            for (Vec3f vecPos : seatPos)
            {
                if (ChairUtility.isSomeoneSitting(world, hitX + vecPos.xCoord, hitY + vecPos.yCoord, hitZ + vecPos.zCoord) == false)
                {
                    ChairUtility.sitOnBlockWithRotationOffset(world, new Vec3d(hitX, hitY, hitZ), player, vecPos.toVec3D(), ((BaseTileEntity) world.getTileEntity(hitX, hitY, hitZ)).getFacing());
                    return true;
                }
            }
        }
        return false;
    }

    public void setSeatPos(Vec3f[] seatPos)
    {
        this.seatPos = seatPos;
    }
}
