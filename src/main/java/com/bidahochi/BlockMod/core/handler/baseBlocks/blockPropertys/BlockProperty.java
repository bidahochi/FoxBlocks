package com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseBlock;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseBlockSlab;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseFallingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 Class meant to be used for Block Initialization to quickly share block details between Block, Slab, Stair
 */
public class BlockProperty
{
    public final Material TheMaterial;
    public final String BlockName;
    public final float BlockHardness;
    public final float BlockResistance;
    public final String ToolClass;
    public final int HarvestLevel;
    public final Block.SoundType SoundType;
    public final String TexturePath;
    public final CreativeTabs CreativeTab;
    public final int TotalTextureCount;
    public boolean FirstBlockHasNoIndex = false;
    public float lightLevel;
    public boolean blockHasSideTextures = false;

    protected Block singleSlab;
    protected Block singleSecondarySlab;
    protected Block block;

    public BlockProperty(BlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab)
    {
        BlockName = block.blockName;
        TheMaterial = material;
        BlockHardness = blockHardness;
        BlockResistance = blockResistance;
        ToolClass = toolClass;
        HarvestLevel = harvestLevel;
        SoundType = soundType;
        TotalTextureCount = totalTextureCount;
        TexturePath = FoxBlocks.MODID + ":" + texturePath;
        CreativeTab = creativeTab;
    }

    public BlockProperty(BlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab, boolean firstBlockHasNoIndex)
    {
        this (block, material, blockHardness, blockResistance, toolClass, harvestLevel, soundType, totalTextureCount, texturePath, creativeTab);
        FirstBlockHasNoIndex = firstBlockHasNoIndex;
    }

    public Block getNewBlock()
    {
        block = new BaseBlock(this);
        return block;
    }

    public Block getNewSingleSlab()
    {
        singleSlab = new BaseBlockSlab(false, this, null, 0);
        return singleSlab;
    }

    public Block getNewDoubleSlab()
    {
        if (singleSlab == null)
        {
            getNewSingleSlab();
        }

        return new BaseBlockSlab(true, this, singleSlab, 0);
    }

    public Block getSecondNewSingleSlab()
    {

        if (singleSecondarySlab == null)
        {
            singleSecondarySlab = new BaseBlockSlab(false, this, null, 8);
        }

        return singleSecondarySlab;
    }

    public Block getSecondNewDoubleSlab()
    {
        if (singleSecondarySlab == null)
        {
            getSecondNewSingleSlab();
        }

        return new BaseBlockSlab(true, this, singleSecondarySlab, 8);
    }
}
