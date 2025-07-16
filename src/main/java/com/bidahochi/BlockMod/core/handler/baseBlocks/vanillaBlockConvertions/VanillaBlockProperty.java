package com.bidahochi.BlockMod.core.handler.baseBlocks.vanillaBlockConvertions;

import net.minecraft.block.Block;

public class VanillaBlockProperty
{
    public final String ToolClass;
    public final int HarvestLevel;
    public final Block block;
    public final String textureName;

    protected Block singleSlab;
    protected Block singleSecondarySlab;

    public final int TotalTextureCount;

    public String altBlockName;

    public VanillaBlockProperty(Block block, String textureName, int totalTextureCount, String toolClass, int harvestLevel)
    {
        this.block = block;
        TotalTextureCount = totalTextureCount;
        this.ToolClass = toolClass;
        this.HarvestLevel = harvestLevel;
        this.textureName = textureName;
    }

    public VanillaBlockProperty(Block block, String textureName, String toolClass, int harvestLevel)
    {
        this.block = block;
        this.ToolClass = toolClass;
        this.HarvestLevel = harvestLevel;
        this.textureName = textureName;
        TotalTextureCount = 1;
    }

    public void SetAltBlockName(String nameOfBlock)
    {
        altBlockName = nameOfBlock;
    }

    private String[] textures;

    public String[] GetTextures()
    {
        return textures;
    }

    public int TextureCount()
    {
        return TotalTextureCount;
    }

    public Block getNewSingleSlab()
    {
        singleSlab = new BaseVanillaBlockSlab(false, this, null, 0);
        return singleSlab;
    }

    public Block getNewDoubleSlab()
    {
        if (singleSlab == null)
        {
            getNewSingleSlab();
        }

        return new BaseVanillaBlockSlab(true, this, singleSlab, 0);
    }

    public Block getSecondNewSingleSlab()
    {

        if (singleSecondarySlab == null)
        {
            singleSecondarySlab = new BaseVanillaBlockSlab(false, this, null, 8);
        }

        return singleSecondarySlab;
    }

    public Block getSecondNewDoubleSlab()
    {
        if (singleSecondarySlab == null)
        {
            getSecondNewSingleSlab();
        }

        return new BaseVanillaBlockSlab(true, this, singleSecondarySlab, 8);
    }


}
