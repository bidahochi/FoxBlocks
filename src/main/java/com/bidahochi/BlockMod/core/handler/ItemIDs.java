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
    rust("rust", "rust", "rust"),
    aragoniteClump("aragoniteClump", "aragoniteClump", "aragoniteClump"),
    ironRod("ironRod", "ironRod", "ironRod"),
    ironSlice("ironSlice", "ironSlice", "ironSlice"),
    computerizedCircuit("computerizedCircuit", "computerizedCircuit", "computerizedCircuit"),
    throwablePoo("throwablePoo","throwablepoo","throwablepoo"),

    record_piss2("record_piss2", "record_piss", "record_piss"),
    record_rodney("record_rodney", "record_rodney", "record_rodney"),
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
