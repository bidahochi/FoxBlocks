package com.bidahochi.BlockMod.core.handler;

import net.minecraft.item.Item;

public enum ItemIDs {

    test("test","test","test");

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
