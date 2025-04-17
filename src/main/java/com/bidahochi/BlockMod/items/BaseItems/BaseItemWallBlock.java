package com.bidahochi.BlockMod.items.BaseItems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;

public class BaseItemWallBlock extends ItemBlockWithMetadata
{
    public BaseItemWallBlock(Block block)
    {
        super(block, block);
    }
}
