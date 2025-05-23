package com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys;

import com.bidahochi.BlockMod.core.handler.BlockIDs;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseBlock;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseBlockSlab;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BasePillarBlock;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BasePillarBlockSlab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PillarBlockProperty extends BlockProperty
{
    public PillarBlockProperty(BlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab)
    {
        super(block, material, blockHardness, blockResistance, toolClass, harvestLevel, soundType, totalTextureCount, texturePath, creativeTab);
    }

    public PillarBlockProperty(BlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab, boolean firstBlockHasNoIndex)
    {
        super(block, material, blockHardness, blockResistance, toolClass, harvestLevel, soundType, totalTextureCount, texturePath, creativeTab, firstBlockHasNoIndex);
    }

    @Override
    public Block getNewBlock()
    {
        block = new BasePillarBlock(this);
        return block;
    }

    @Override
    public Block getNewSingleSlab()
    {
        singleSlab = new BasePillarBlockSlab(false, this, null, 0);
        return singleSlab;
    }

    @Override
    public Block getNewDoubleSlab()
    {
        if (singleSlab == null)
        {
            getNewSingleSlab();
        }

        return new BasePillarBlockSlab(true, this, singleSlab, 0);
    }

    @Override
    public Block getSecondNewSingleSlab()
    {

        if (singleSecondarySlab == null)
        {
            singleSecondarySlab = new BasePillarBlockSlab(false, this, null, 8);
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

        return new BasePillarBlockSlab(true, this, singleSecondarySlab, 8);
    }
}
