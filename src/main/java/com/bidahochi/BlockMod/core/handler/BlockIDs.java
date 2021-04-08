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

import com.bidahochi.BlockMod.blocks.cobaltdeco.ItemBlockcobaltPanel;
import com.bidahochi.BlockMod.blocks.cobaltdeco.ItemBlockcobaltPanel2;
import com.bidahochi.BlockMod.blocks.constructionmaterials.*;
import com.bidahochi.BlockMod.blocks.metals.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public enum BlockIDs {

    bauxiteOre(false,null, "Bauxite"),
    cobaltOre(false,null,"CobaltOre"),
    rawConcrete(false,null,"Concrete"),
    peagravel_snow(false,null, "peagravelsnow"),
    peagravel(false,null, "peagravel"),
    peagravel_shit(false, null, "Dirty Pea Gravel"),
    gravel_shit(false, null, "Dirty Gravel"),
    although(false,null, "alothi"),
    testblock(false,null,"Test Block"),
    dryWall(true,ItemBlockdryWall.class,"Dry Wall"),
    wallPaper(true, ItemBlockwallPaper.class,"wallPaper"),
    //brownTile(false, null, "Brown Tile"),
    fiberGlass(true, ItemBlockfiberGlass.class, "Fiber Glass"),
    fireBrick(false, null, "fireBrick"),
    darkEmberStone(false, null, "Dark Ember Stone"),
    emberStone(false,null,"Ember Stone"),
    //testPane(false, null, "TestPane"),
    //testSlab(false,null,"TestSlab"),
    blockLavaBucket(false, null, "BlockOLavaBucket"),

    soapStone(false, null, "Soapstone"),
    soapStoneDeco(true, ItemBlocksoapStoneDeco.class, "Soapstone Deco"),
    soapStoneMagmatic(false, null, "Magmatic Soapstone"),
    soapStoneEmerald(false, null, "Emerald Soapstone Ore"),

    unfinishedDrywall(false,null,"unfinishedDrywall"),
    //testStair(false,null,"TestStair"),

    metalSiding(true, ItemBlockmetalSiding.class, "Metal Siding"),
    metalSiding2(true, ItemBlockmetalSiding2.class, "Metal Siding2"),
    pannelBlack(true, ItemBlockpannelBlack.class, "pannelBlack"),
    pannelWhite(true, ItemBlockpannelWhite.class, "pannelWhite"),
    pannelExtra(true, ItemBlockpannelExtra.class, "pannelExtra"),
    rustBeam(true, ItemBlockrustBeam.class, "rustBeam"),

    harieshHead(false,ItemBlockmetalSiding.class, "-hariesh"),
    layeredConcrete(false, null, "Layered Concrete"),
    smoothCrete(false, null, "Smoothcrete"),
    gypsum(false,null,"gypsum"),

    emberStoneStair(false,null,"EmberStone Stair"),
    darkEmberStoneStair(false,null,"Dark EmberStone Stair"),
    soapStoneStair(false, null, "Soapstone Stair"),

    emberStoneSlab(false,null,"EmberStone Slab"),
    darkEmberStoneSlab(false,null,"Dark EmberStone Slab"),
    soapStoneSlab(false, null, "Soapstone Slab"),

    tile4(true, ItemBlocktile4.class,"tile4"),
    tile2x2(true, ItemBlockTile2x2.class, "Tile 2x2"),
    tile2x2smooth(true, ItemBlockTile2x2Smooth.class, "Tile 2x2 Smooth"),
    diamondTile(true, ItemBlockdiamondTile.class,"Diamond Tile"),

    cobaltBlock(false,null,"cobaltBlock"),
    cobaltPanel(true, ItemBlockcobaltPanel.class,"cobaltPanel"),
    cobaltPanel2(true, ItemBlockcobaltPanel2.class,"cobaltPanel2"),
    cobaltBrick(false,null,"cobaltBrick"),
    largeCobaltBrick(false,null,"largeCobaltBrick"),
    blue(false,null,"Blue"),
    green(false,null,"Green"),

    widePlank(true, ItemBlockwidePlank.class, "widePlank"),
    widePlank2(true, ItemBlockwidePlank2.class, "widePlank2"),
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
