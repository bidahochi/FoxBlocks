package com.bidahochi.BlockMod.core.handler;

import net.minecraft.item.Item;

public enum ItemIDs {

    test("test","test","test"),
    jarate("jarate","jarate","Jarate!"),
    gypsumDust("gypsumDust", "gypsumdust", "GypsumDust"),
    enrichedClay("enrichedClay","enrichedClay","enrichedClay"),
    ceramic("ceramic","ceramic","ceramic"),
    cobaltIngot("cobalt_ingot","cobalt_ingot","cobalt_ingot"),
    lowDensityCompound("compound", "lowdensitycompound", "lowdensitycompound"),
    ;

    public Item item;
    public String className;
    public String iconName;
    public String itemName;

    ItemIDs(String itemClassName, String iconName, String itemName) {
        this.className = itemClassName;
		this.iconName = iconName;
		this.itemName = itemName;
    }
}
