package com.bidahochi.BlockMod.core.handler.baseBlocks.vanillaBlockConvertions;

import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseFallingBlockSlab;
import net.minecraft.block.Block;

public class VanillaFallingBlockProperty extends VanillaBlockProperty
{
    public VanillaFallingBlockProperty(Block block, String textureName, int totalTextureCount, String toolClass, int harvestLevel)
    {
        super(block, textureName, totalTextureCount, toolClass, harvestLevel);
    }

    public VanillaFallingBlockProperty(Block block, String textureName, String toolClass, int harvestLevel)
    {
        super(block, textureName, toolClass, harvestLevel);
    }

    @Override
    public Block getNewSingleSlab()
    {
        singleSlab = new BaseVanillaFallingBlockSlab(false, this, null, 0);
        return singleSlab;
    }

    @Override
    public Block getNewDoubleSlab()
    {
        if (singleSlab == null)
        {
            getNewSingleSlab();
        }

        return new BaseVanillaFallingBlockSlab(true, this, singleSlab, 0);
    }

    @Override
    public Block getSecondNewSingleSlab()
    {

        if (singleSecondarySlab == null)
        {
            singleSecondarySlab = new BaseVanillaFallingBlockSlab(false, this, null, 8);
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

        return new BaseVanillaFallingBlockSlab(true, this, singleSecondarySlab, 8);
    }
}
