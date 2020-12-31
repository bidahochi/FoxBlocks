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
import com.bidahochi.BlockMod.blocks.constructionmaterials.ItemBlocksoapStoneDeco;
import com.bidahochi.BlockMod.blocks.constructionmaterials.ItemBlockwallPaper;
import com.bidahochi.BlockMod.blocks.metals.ItemBlockmetalSiding;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public enum BlockIDs {

    bauxiteOre(false,null, "Bauxite"),
    rawConcrete(false,null,"Concrete"),
    peagravel_snow(false,null, "peagravelsnow"),
    peagravel(false,null, "peagravel"),
    although(false,null, "alothi"),
    testblock(false,null,"Test Block"),
    dryWall(true,ItemBlockdryWall.class,"Dry Wall"),
    wallPaper(true, ItemBlockwallPaper.class,"wallPaper"),
    brownTile(false, null, "Brown Tile"),
    fiberGlass(true, ItemBlockfiberGlass.class, "Fiber Glass"),
    fireBrick(false, null, "fireBrick"),
    darkEmberStone(false, null, "Dark Ember Stone"),
    emberStone(false,null,"Ember Stone"),
    testPane(false, null, "TestPane"),
    testSlab(false,null,"TestSlab"),
    soapStone(false, null, "Soapstone"),
    soapStoneDeco(true, ItemBlocksoapStoneDeco.class, "Soapstone Deco"),
    soapStoneMagmatic(false, null, "Magmatic Soapstone"),
    soapStoneEmerald(false, null, "Emerald Soapstone Ore"),
    unfinishedDrywall(false,null,"unfinishedDrywall"),
    testStair(false,null,"TestStair"),
    metalSiding(true, ItemBlockmetalSiding.class, "Metal Siding"),
    harieshHead(false,ItemBlockmetalSiding.class, "-hariesh"),
    layeredConcrete(false, null, "Layered Concrete"),
    gypsum(false,null,"gypsum"),
    emberStoneStair(false,null,"EmberStone Stair"),
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
