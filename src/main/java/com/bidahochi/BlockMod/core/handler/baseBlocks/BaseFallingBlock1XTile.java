package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BaseFallingBlock1XTile extends BaseBlock1XTile{
    public BaseFallingBlock1XTile(BlockProperty blockProperty)
    {
        super(blockProperty);
    }

    @Override
    public void onBlockAdded(World world, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
        world.scheduleBlockUpdate(p_149726_2_, p_149726_3_, p_149726_4_, this, this.tickRate(world));
    }

    @Override
    public void onNeighborBlockChange(World world, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block block) {
        world.scheduleBlockUpdate(p_149695_2_, p_149695_3_, p_149695_4_, this, this.tickRate(world));
    }

    public void updateTick(World world, int x, int y, int z, java.util.Random p_149674_5_) {
        if (!world.isRemote) {
            this.func_149830_m(world, x, y, z);
        }

    }

    private void func_149830_m(World world, int x, int y, int z) {
        if (isNextBlockUnoccupied(world, x, y - 1, z) && y >= 0)
        {
            byte b0 = 32;
            if (!false && world.checkChunksExist(x - b0, y - b0, z - b0, x + b0, y + b0, z + b0))
            {
                if (!world.isRemote)
                {
                    EntityFallingBlock entityfallingblock = new EntityFallingBlock(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this, world.getBlockMetadata(x, y, z));
                    this.func_149829_a(entityfallingblock);
                    world.spawnEntityInWorld(entityfallingblock);
                }
            }
            else
            {
                world.setBlockToAir(x, y, z);

                while(isNextBlockUnoccupied(world, x, y - 1, z) && y > 0)
                {
                    --y;
                }

                if (y > 0)
                {
                    world.setBlock(x, y, z, this);
                }
            }
        }
    }


    protected void func_149829_a(EntityFallingBlock p_149829_1_) {
    }

    public int tickRate(World p_149738_1_) {
        return 2;
    }

    public boolean isNextBlockUnoccupied(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        if (block.isAir(world, x, y, z))
        {
            return true;
        }
        else if (block == Blocks.fire)
        {
            return true;
        }
        else
        {
            Material material = block.getMaterial();
            return material == Material.water ? true : material == Material.lava;
        }
    }

    public void func_149828_a(World p_149828_1_, int p_149828_2_, int p_149828_3_, int p_149828_4_, int p_149828_5_)
    {
    }
}
