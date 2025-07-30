package com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys;

import net.minecraft.block.Block;

public interface IBlockProperty
{
    public Block getNewBlock();

    public Block getNewSingleSlab();

    public Block getNewDoubleSlab();

    public Block getSecondNewSingleSlab();

    public Block getSecondNewDoubleSlab();

    public boolean IsWallBlockAllowed();

    /**
     * Used to set the resourceFolderName for a block property
     * this is used for external compatability by other mods.
     * @param setResourceFolderName resource folder mod name default is FoxBlocks
     */
    public void setResourceFolderName(String setResourceFolderName);
}
