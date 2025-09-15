package com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.IFoxBlockIDs;
import com.bidahochi.BlockMod.core.handler.baseBlocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.HashMap;
import java.util.Map;

/**
 Class meant to be used for Block Initialization to quickly share block details between Block, Slab, Stair
 */
public class BlockProperty implements IBlockProperty
{
    public final String TileKey = "Tile";
    public final String FenceKey = "Fence";

    /**
     * Used to handle a block that was previously under a different register name that is being converted
     * to register and all block modifications under foxblocks without having to use the block remapper
     * which can cause issues.
     */
    public Map<String, String> blockRegisterNameOverrides = new HashMap<>();

    public String IfExistsGetBlockOverrideName(String blockKey)
    {
        if (blockRegisterNameOverrides.containsKey(blockKey))
        {
            return blockRegisterNameOverrides.get(blockKey);
        }

        return "@~NO~@";
    }

    private String ResourceFolderName = FoxBlocks.MODID;

    public String getResourceFolderName() {
        return ResourceFolderName;
    }

    public boolean is1XTileAllowed = false;

    public boolean isFenceBlockAllowed = false;

    public final Material TheMaterial;
    public final String BlockName;
    public final float BlockHardness;
    public final float BlockResistance;
    public final String ToolClass;
    public final int HarvestLevel;
    public final Block.SoundType SoundType;
    private final String TexturePath;
    private final CreativeTabs CreativeTab;

    public final int TotalTextureCount;
    public boolean FirstBlockHasNoIndex = false;
    public float lightLevel;
    public boolean blockHasSideTextures = false;

    protected Block singleSlab;
    protected Block singleSecondarySlab;

    protected Block block;
    protected Block tile1X;

    protected Block fenceBlock;

    public boolean isVanillaBlock = false;
    /**
     * Used only for converting vanilla blocks
     * @param block
     * @param blockResistance
     * @param toolClass
     * @param harvestLevel
     * @param totalTextureCount
     * @param texturePath
     */
    public BlockProperty(Block block, float blockResistance, String toolClass, int harvestLevel, int totalTextureCount, String texturePath)
    {
        BlockName = block.getUnlocalizedName();
        TheMaterial = block.getMaterial();
        BlockHardness = block.getBlockHardness(null, 0, 0, 0);
        BlockResistance = blockResistance;
        ToolClass = toolClass;
        HarvestLevel = harvestLevel;
        SoundType = block.stepSound;
        TotalTextureCount = totalTextureCount;
        TexturePath = texturePath;
        CreativeTab = block.getCreativeTabToDisplayOn();
        isVanillaBlock = true;
    }

    public BlockProperty(IFoxBlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab)
    {
        BlockName = block.GetBlockName();
        TheMaterial = material;
        BlockHardness = blockHardness;
        BlockResistance = blockResistance;
        ToolClass = toolClass;
        HarvestLevel = harvestLevel;
        SoundType = soundType;
        TotalTextureCount = totalTextureCount;
        TexturePath = texturePath;
        CreativeTab = creativeTab;
    }

    public BlockProperty(IFoxBlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab, boolean firstBlockHasNoIndex)
    {
        this (block, material, blockHardness, blockResistance, toolClass, harvestLevel, soundType, totalTextureCount, texturePath, creativeTab);
        FirstBlockHasNoIndex = firstBlockHasNoIndex;
    }

    /**
     * {@inheritDoc}
     */
    public void setResourceFolderName(String resourceFolderName)
    {
        ResourceFolderName = resourceFolderName;
    }

    public String getFullTexturePath()
    {
         return ResourceFolderName + ":" + TexturePath;
    }

    public Block getNewBlock()
    {
        block = new BaseBlock(this);

        return block;
    }

    public CreativeTabs getCreativeTab()
    {
        return CreativeTab;
    }

    public CreativeTabs getSlabCreativeTab()
    {
        return CreativeTab;
    }

    public CreativeTabs getStairCreativeTab()
    {
        return CreativeTab;
    }

    public CreativeTabs getFenceCreativeTab()
    {
        return CreativeTab;
    }

    public CreativeTabs getExtraBlocksCreativeTab()
    {
        return CreativeTab;
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

    public Block getBlockStair(int metadata)
    {
        return new BaseBlockStair(block, metadata, this);
    }

    public Block getNewBlock1XTile()
    {
        if (tile1X == null)
        {
            tile1X = new BaseBlock1XTile(this);
        }

        return tile1X;
    }

    public Block getNewFenceBLock()
    {
        if (fenceBlock == null)
        {
            fenceBlock = new BaseBlockFence(block, this);
        }

        return fenceBlock;
    }

    public boolean isFenceBlockAllowed()
    {
        return isFenceBlockAllowed;
    }

    public boolean IsWallBlockAllowed()
    {
        return true;
    }

    public boolean Is1XTileAllowed()
    {
        return is1XTileAllowed;
    }
}
