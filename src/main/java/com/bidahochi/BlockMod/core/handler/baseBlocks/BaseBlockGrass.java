package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BaseBlockGrass extends BasePillarBlock
{
    public BaseBlockGrass(BlockProperty blockProperty)
    {
        super(blockProperty);
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
    {
        return true;
    }
}
