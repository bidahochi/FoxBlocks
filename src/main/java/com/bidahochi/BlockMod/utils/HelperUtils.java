package com.bidahochi.BlockMod.utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class HelperUtils
{
    public static <K, V> V getValueByIndex(LinkedHashMap<K, V> map, int index) {
        if (index < 0 || index >= map.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + map.size());
        }

        ArrayList<Map.Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        return entries.get(index).getValue();
    }

    public static <K, V> K getKeyByIndex(LinkedHashMap<K, V> map, int index) {
        if (index < 0 || index >= map.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + map.size());
        }

        ArrayList<Map.Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        return entries.get(index).getKey();
    }

    public static com.bidahochi.BlockMod.core.handler.BlockIDs getBlockFromString(String name) {
        if (name.contains("_DoubleSlab")) {
            name = name.replace("_DoubleSlab","");
        }
        if (name.contains("_Slab")) {
            name = name.replace("_Slab","");
        }
        if (name.contains("_Stair")) {
            name = name.replace("_Stair","");
        }
        if (name.contains("tile.")) {
            name = name.replace("tile.","");
        }
        name = name.replaceAll("[0-9]","");
        for (com.bidahochi.BlockMod.core.handler.BlockIDs block : com.bidahochi.BlockMod.core.handler.BlockIDs.values())
        {
            if (name.equalsIgnoreCase(block.blockName))
            {
                return block;
            }
        }
        return null;
    }

    public static boolean isFence(World worldObj, int x, int y, int z, Block block) {
        int damage = block.getDamageValue(worldObj, x, y, z);
        return block instanceof BlockFence
                || (block.getUnlocalizedName().equalsIgnoreCase("tile.immersiveEngineering.metalDecoration") && damage == 0)
                || (block.getUnlocalizedName().equalsIgnoreCase("tile.immersiveEngineering.woodenDecoration") && damage == 1)
                || block.getUnlocalizedName().equalsIgnoreCase("tile.blockCarpentersBarrier")
                || block.getUnlocalizedName().equalsIgnoreCase("tile.railcraft.post.metal")
                || block.getUnlocalizedName().equalsIgnoreCase("tile.railcraft.post.metal.platform")
                || (block.getUnlocalizedName().equalsIgnoreCase("tile.railcraft.post")) && (damage == 0 || damage == 2 || damage == 4 || damage == 6);
    }
}
