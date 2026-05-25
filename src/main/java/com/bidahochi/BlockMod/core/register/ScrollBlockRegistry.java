package com.bidahochi.BlockMod.core.register;

import com.bidahochi.BlockMod.core.handler.IFoxBlockIDs;
import net.minecraft.block.Block;

import java.util.*;
import java.util.function.Supplier;

public class ScrollBlockRegistry
{
    private static final Map<Block, String> SCROLL_LIST_METADATA = new HashMap<>();

    public static void register(IFoxBlockIDs foxBlockIDs, String metaData)
    {
        if (SCROLL_LIST_METADATA.containsKey(foxBlockIDs.GetBlock()))
        {
            throw new IllegalArgumentException("Scroll list foxBlockID already registered: " + foxBlockIDs);
        }

        SCROLL_LIST_METADATA.put(foxBlockIDs.GetBlock(), metaData);
    }

    private static final Map<Integer, Supplier<LinkedList<Block>>> SCROLL_LISTS = new HashMap<>();

    public static void register(int id, Supplier<LinkedList<Block>> supplier)
    {
        if (SCROLL_LISTS.containsKey(id)) {
            throw new IllegalArgumentException("Scroll list ID already registered: " + id);
        }

        SCROLL_LISTS.put(id, supplier);
    }

    public static LinkedList<Block> get(int id)
    {
        Supplier<LinkedList<Block>> supplier = SCROLL_LISTS.get(id);
        return supplier != null ? supplier.get() : null;
    }

    // Optional helper for cleaner registration
    public static Supplier<LinkedList<Block>> of(Block... blocks)
    {
        return () -> {
            LinkedList<Block> list = new LinkedList<>();
            Collections.addAll(list, blocks);
            return list;
        };
    }
}
