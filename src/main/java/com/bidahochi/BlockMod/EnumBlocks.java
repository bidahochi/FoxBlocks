package com.bidahochi.BlockMod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public enum EnumBlocks {

    bauxiteOre(),
    rawConcrete(),
    peagravel_snow(),
    peagravel(),
    although(),
    metalSiding_White(),
    metalSiding_LightGrey(),
    metalSiding_Grey(),
    metalSiding_Black(),
    //BlockmetalSiding(),
    ;

    public Block leBlock;
    public ItemBlock leItemBlock;
    public String bloccName;


    EnumBlocks() {
    }

    EnumBlocks(Block leBlock, String bloccName) {
        this.leBlock = leBlock;
        this.bloccName = bloccName;
    }

    EnumBlocks(Block leBlock, String bloccName, ItemBlock leItemBlock) {
        this.leBlock = leBlock;
        this.bloccName = bloccName;
        this.leItemBlock = leItemBlock;

    }
}
