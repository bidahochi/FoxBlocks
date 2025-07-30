package com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys;

import com.bidahochi.BlockMod.core.handler.BlockIDs;
import com.bidahochi.BlockMod.core.handler.IFoxBlockIDs;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseBlockGrass;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseFallingBlockSlab;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BasePillarBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GrassBlockProperty extends PillarBlockProperty
{
    public GrassBlockProperty(IFoxBlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab)
    {
        super(block, material, blockHardness, blockResistance, toolClass, harvestLevel, soundType, totalTextureCount, texturePath, creativeTab);
    }

    public GrassBlockProperty(IFoxBlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab, boolean firstBlockHasNoIndex)
    {
        super(block, material, blockHardness, blockResistance, toolClass, harvestLevel, soundType, totalTextureCount, texturePath, creativeTab, firstBlockHasNoIndex);
    }

    @Override
    public Block getNewBlock()
    {
        block = new BaseBlockGrass(this);
        return block;
    }

    @Override
    public boolean IsWallBlockAllowed()
    {
        return false;
    }
}
