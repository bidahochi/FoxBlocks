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
    woodSealant("woodSealant", "woodSealant", "woodSealant"),
    taconiteCrushed("taconiteCrushed", "taconiteCrushed", "taconiteCrushed"),
    taconitePellets("taconitePellets", "taconitePellets", "taconitePellets"),
    quicklime("quicklime","quicklime_1","quicklime"),
    roadTar("roadTar", "roadTar", "roadTar"),
    bulb("bulb", "bulb", "bulb"),
    bulbLong("bulbLong", "bulblong", "bulbLong"),
    bolsterChisel("bolsterChisel", "bolsterChisel", "bolsterChisel"),

    doorA("doorAitem","doorA_icon","doorAitem"),
    doorB("doorBitem","doorB_icon","doorBitem"),
    doorC("doorCitem","doorC_icon","doorCitem"),
    doorD("doorDitem","doorD_icon","doorDitem"),
    doorE("doorEitem","doorE_icon","doorEitem"),

    record_piss2("record_piss2", "record_piss", "record_piss"),
    record_rodney("record_rodney", "record_rodney", "record_rodney"),
    record_penguin("record_rodney", "record_penguin", "record_penguin"),

    bucket_of_tbea("bucket_of_tbea", "bucket_of_tbea","bucket_of_tbea"),
    bucket_of_lean("bucket_of_lean", "bucket_of_lean","bucket_of_lean"),
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
