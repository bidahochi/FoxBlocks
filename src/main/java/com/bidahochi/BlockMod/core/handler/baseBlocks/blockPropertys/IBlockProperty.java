package com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys;

import net.minecraft.block.Block;

public interface IBlockProperty
{
    public Block getNewBlock();

    public Block getNewSingleSlab();

    public Block getNewDoubleSlab();

    public Block getSecondNewSingleSlab();

    public Block getSecondNewDoubleSlab();
}
