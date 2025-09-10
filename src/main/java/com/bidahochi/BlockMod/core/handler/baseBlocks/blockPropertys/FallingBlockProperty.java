package com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys;

import com.bidahochi.BlockMod.core.handler.BlockIDs;
import com.bidahochi.BlockMod.core.handler.IFoxBlockIDs;
import com.bidahochi.BlockMod.core.handler.baseBlocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class FallingBlockProperty extends BlockProperty
{
    public FallingBlockProperty(IFoxBlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab)
    {
        super(block, material, blockHardness, blockResistance, toolClass, harvestLevel, soundType, totalTextureCount, texturePath, creativeTab);
    }

    public FallingBlockProperty(IFoxBlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab, boolean firstBlockHasNoIndex)
    {
        super(block, material, blockHardness, blockResistance, toolClass, harvestLevel, soundType, totalTextureCount, texturePath, creativeTab, firstBlockHasNoIndex);
    }

    @Override
    public Block getNewBlock()
    {
        block = new BaseFallingBlock(this);
        return block;
    }

    @Override
    public Block getNewSingleSlab()
    {
        singleSlab = new BaseFallingBlockSlab(false, this, null, 0);
        return singleSlab;
    }

    @Override
    public Block getNewDoubleSlab()
    {
        if (singleSlab == null)
        {
            getNewSingleSlab();
        }

        return new BaseFallingBlockSlab(true, this, singleSlab, 0);
    }

    @Override
    public Block getSecondNewSingleSlab()
    {

        if (singleSecondarySlab == null)
        {
            singleSecondarySlab = new BaseFallingBlockSlab(false, this, null, 8);
        }

        return singleSecondarySlab;
    }

    @Override
    public Block getSecondNewDoubleSlab()
    {
        if (singleSecondarySlab == null)
        {
            getSecondNewSingleSlab();
        }

        return new BaseFallingBlockSlab(true, this, singleSecondarySlab, 8);
    }

    @Override
    public Block getBlockStair(int metadata)
    {
        return new BaseFallingBlockStair(block, metadata, this);
    }

    @Override
    public Block getNewBlock1XTile()
    {
        tile1X = new BaseFallingBlock1XTile(this);

        return tile1X;
    }

    @Override
    public boolean IsWallBlockAllowed()
    {
        return false;
    }
}
