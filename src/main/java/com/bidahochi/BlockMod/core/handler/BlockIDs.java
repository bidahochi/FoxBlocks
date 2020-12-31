package com.bidahochi.BlockMod.core.handler;

/***************************
 *
 *  BlockIDs by -hariesh
 *
 *  This Folder is to register Blocks to FOXBLOCKS
 *  MAKE SURE YOU REGISTER BLOCKS TO MINECRAFT IN blockHandler at com.bidahochi.BlockMod.core.handler;
 *
 *  This file allows you to set if the block has an itemBlockversion, where it is and the name of the block!
 *
 *  Under BlockIDs{} use this format:
 *
 *  blockname(false,null,"finalblockname"),
 *
 *  The finalblockname will stop you from having to write an en_US.lang file for the block as it will be already written through this file!
 *
 *  This file is also used to pull into many other files, dont screw this one up!
 *
 *  Any questions just ping or dm me on the discord!
 *
 *  -hariesh
 *
 ****************************/

import com.bidahochi.BlockMod.blocks.constructionmaterials.ItemBlockdryWall;
import com.bidahochi.BlockMod.blocks.constructionmaterials.ItemBlockfiberGlass;
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
    metalSiding_Black(false,null, "metal block"),
    //BlockmetalSiding(false,null,"metalsiding"),
    testblock(false,null,"Test Block"),
    dryWall(true,ItemBlockdryWall.class,"Dry Wall"),
    brownTile(false, null, "Brown Tile"),
    fiberGlass(true, ItemBlockfiberGlass.class, "Fiber Glass")
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
