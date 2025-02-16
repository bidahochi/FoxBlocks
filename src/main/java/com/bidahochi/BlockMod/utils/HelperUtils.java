package com.bidahochi.BlockMod.utils;

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
}
