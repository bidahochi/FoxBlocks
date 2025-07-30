package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import com.bidahochi.BlockMod.core.handler.baseBlocks.vanillaBlockConvertions.VanillaBlockProperty;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class BlockRegisterReturnCache
{
    public HashMap<IFoxBlockIDs, BlockProperty> TempBlockCache = new HashMap<>();
    public LinkedHashMap<Block, VanillaBlockProperty> TempVanillaBlockCache = new LinkedHashMap<Block, VanillaBlockProperty>();

    public BlockRegisterReturnCache(HashMap<IFoxBlockIDs, BlockProperty> tempBlockCache, LinkedHashMap<Block, VanillaBlockProperty> tempVanillaBlockCache)
    {
        TempBlockCache = tempBlockCache;
        TempVanillaBlockCache = tempVanillaBlockCache;
    }
}
