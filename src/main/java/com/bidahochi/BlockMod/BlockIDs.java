package com.bidahochi.BlockMod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public enum BlockIDs {

    bauxiteOre(false,null, "Bauxite"),
    rawConcrete(false,null,"Concrete"),
    peagravel_snow(false,null, "peagravelsnow"),
    peagravel(false,null, "peagravel"),
    although(false,null, "alothi"),
    metalSiding_White(false,null, "metalwhite"),
    metalSiding_LightGrey(false,null, "metalgray"),
    metalSiding_Grey(false,null, "metalgraygary"),
    metalSiding_Black(false,null, "metal bloack"),
    //BlockmetalSiding(false,null,"metalsiding"),
    ;

    public Block block;
    public boolean hasItemBlock;
    public Class itemBlockClass;
    public String blockName;


    BlockIDs(boolean hasItemBlock, Class<? extends ItemBlock> itemBlockClass, String blockName) {
        this.hasItemBlock = hasItemBlock;
        this.itemBlockClass = itemBlockClass;
        this.blockName = blockName;
    }
}
