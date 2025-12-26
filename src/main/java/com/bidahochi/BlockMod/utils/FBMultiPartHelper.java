package com.bidahochi.BlockMod.utils;

import codechicken.multipart.BlockMultipart;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class FBMultiPartHelper
{
    public static boolean BlockInstanceOfBlockMultipart(Block block)
    {
        return block instanceof codechicken.multipart.BlockMultipart;
    }

    public static boolean isBlockSolid(Block block, TileEntity tile)
    {
        return ((BlockMultipart)block).isBlockSolid(tile.getWorldObj(), tile.xCoord,tile.yCoord-1,tile.zCoord, 1);
    }
}
