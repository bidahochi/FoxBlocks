package com.bidahochi.BlockMod.core.handler;

import net.minecraft.block.Block;

public interface IFoxBlockIDs
{
    Block GetBlock();

    boolean hasItemBlock();

    Class getItemBlockClass();

    byte GetMaxMetaData();

    String GetBlockName();

}
