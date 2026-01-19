package com.bidahochi.BlockMod.utils;

import codechicken.multipart.BlockMultipart;
import codechicken.multipart.BlockMultipart$;
import codechicken.multipart.TMultiPart;
import codechicken.multipart.TileMultipart;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class FBMultiPartHelper
{
    public static boolean BlockInstanceOfBlockMultipart(Block block)
    {
        return block instanceof codechicken.multipart.BlockMultipart;
    }

    public static boolean isBlockSolid(Block block, TileEntity tile)
    {
        if (((BlockMultipart)block).isBlockSolid(tile.getWorldObj(), tile.xCoord,tile.yCoord-1,tile.zCoord, 1))
        {
            return true;
        }
        TileMultipart tileMultipart = BlockMultipart$.MODULE$.getTile(tile.getWorldObj(), tile.xCoord, tile.yCoord - 1, tile.zCoord);

        if (tileMultipart == null)
        {
            return true;
        }

        return tileMultipart.isSolid(2) && tileMultipart.isSolid(3) || tileMultipart.isSolid(4) && tileMultipart.isSolid(5);
    }
}
