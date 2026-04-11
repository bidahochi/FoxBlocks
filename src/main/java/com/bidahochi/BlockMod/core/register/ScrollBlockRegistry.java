package com.bidahochi.BlockMod.core.register;

import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Collections;
import java.util.function.Supplier;

public class ScrollBlockRegistry
{
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
