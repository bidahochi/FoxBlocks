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

import com.bidahochi.BlockMod.blocks.aggregates.ItemBlockFakeSnow;
import com.bidahochi.BlockMod.blocks.cobaltdeco.ItemBlockcobaltPanel;
import com.bidahochi.BlockMod.blocks.cobaltdeco.ItemBlockcobaltPanel2;
import com.bidahochi.BlockMod.blocks.constructionmaterials.*;
import com.bidahochi.BlockMod.blocks.essentiallymemes.ItemBlockBooBlox;
import com.bidahochi.BlockMod.blocks.metals.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public enum BlockIDs {

    //ores
    bauxiteOre(false,null, "Bauxite"),
    cobaltOre(false,null,"CobaltOre"),
    aragoniteOre(false, null, "AragoniteOre"),
    gypsum(false,null,"gypsum"),

    //raw
    peagravel_snow(false,null, "peagravelsnow"),
    peagravel(false,null, "peagravel"),
    peagravel_shit(false, null, "Dirty Pea Gravel"),
    gravel_shit(false, null, "Dirty Gravel"),
    specialDirt(false, null, "SpecialDirt"),
    peagravelBallast(false,null, "peagravelBallast"),
    peagravelWhitestone(false, null, "Peagravel Whitestone"),
    fakeSnow(true, ItemBlockFakeSnow.class, "FakeSnow"),
    dirt_4(false, null, "Dirt_4"),
    creamCityClay(false, null, "CreamCityClay"),

    //concrete
    rawConcrete(false,null,"Concrete"),
    layeredConcrete(false, null, "Layered Concrete"),
    smoothCrete(false, null, "Smoothcrete"),
    concreteBrick(true, ItemBlockconcreteBrick.class, "concreteBrick"),
    concreteFlooring(true, ItemBlockconcreteFloor.class, "concreteFloor"),
    plasteredConcrete(true, ItemBlockplasteredConcrete.class, "plasteredConcrete"),

    //stones
    soapStone(false, null, "Soapstone"),
    soapStoneDeco(true, ItemBlocksoapStoneDeco.class, "Soapstone Deco"),
    soapStoneMagmatic(false, null, "Magmatic Soapstone"),
    soapStoneEmerald(false, null, "Emerald Soapstone Ore"),

    jolietLimestoneRaw(false, null, "jolietlimestoneraw"),

    //bricks
    fireBrick(false, null, "fireBrick"),
    mortarBrick(true, ItemBlockmortarBrick.class, "mortarBrick"),
    creamCity(true, ItemBlockCreamCity.class, "creamcity"),
    jolietLimestone(true, ItemBlockJolietLimestone.class, "jolietlimestone"),

    cobaltBlock(false,null,"cobaltBlock"),
    cobaltPanel(true, ItemBlockcobaltPanel.class,"cobaltPanel"),
    cobaltPanel2(true, ItemBlockcobaltPanel2.class,"cobaltPanel2"),
    cobaltBrick(false,null,"cobaltBrick"),
    largeCobaltBrick(false,null,"largeCobaltBrick"),

    //tiles
    tile4(true, ItemBlocktile4.class,"tile4"),
    tile2x2(true, ItemBlockTile2x2.class, "Tile 2x2"),
    tile2x2smooth(true, ItemBlockTile2x2Smooth.class, "Tile 2x2 Smooth"),
    diamondTile(true, ItemBlockdiamondTile.class,"Diamond Tile"),
    subTile(true, ItemBlockSubTile.class,"SubTile"),
    terrocottaTiles(true, ItemBlockTerrocottaTiles.class, "TerrocottaTiles"),

    //fun
    although(false,null, "alothi"),
    testblock(false,null,"Test Block"),
    tHanos(false,null,"T Hanos"),
    booBlox(true, ItemBlockBooBlox.class, "BooBlox"),
    blockLavaBucket(false, null, "BlockOLavaBucket"),
    harieshHead(false,ItemBlockmetalSiding.class, "-hariesh"),
    foxglass(false,null,"foxglass"),
    blue(false,null,"Blue"),
    green(false,null,"Green"),

    //woods
    widePlank(true, ItemBlockwidePlank.class, "widePlank"),
    widePlank2(true, ItemBlockwidePlank2.class, "widePlank2"),
    widePlank3(true, ItemBlockwidePlank3.class, "widePlank3"),
    amtrak(true, ItemBlockAmtrak.class, "amshak"),

    //other building mats
    dryWall(true,ItemBlockdryWall.class,"Dry Wall"),
    wallPaper(true, ItemBlockwallPaper.class,"wallPaper"),
    unfinishedDrywall(false,null,"unfinishedDrywall"),
    fiberGlass(true, ItemBlockfiberGlass.class, "Fiber Glass"),

    originStuff(true, ItemBlockOriginStuff.class, "OriginStuff"),

    glassAssorted(true, ItemBlockGlassAssorted.class, "glassAssorted"),

    tarmac(true, ItemBlockTarmac.class, "tarmac"),

    //metals
    metalSiding(true, ItemBlockmetalSiding.class, "Metal Siding"),
    metalSiding2(true, ItemBlockmetalSiding2.class, "Metal Siding2"),
    pannelBlack(true, ItemBlockpannelBlack.class, "pannelBlack"),
    pannelWhite(true, ItemBlockpannelWhite.class, "pannelWhite"),
    pannelExtra(true, ItemBlockpannelExtra.class, "pannelExtra"),
    rustBeam(true, ItemBlockrustBeam.class, "rustBeam"),
    labwallDark(true, ItemBlocklabwallDark.class, "labwallDark"),
    labwallLight(true, ItemBlocklabwallLight.class, "labwallLight"),

    //hell
    darkEmberStone(false, null, "Dark Ember Stone"),
    emberStone(false,null,"Ember Stone"),

    //additional
    emberStoneStair(false,null,"EmberStone Stair"),
    darkEmberStoneStair(false,null,"Dark EmberStone Stair"),
    soapStoneStair(false, null, "Soapstone Stair"),
    //testPane(false, null, "TestPane"),
    //testSlab(false,null,"TestSlab"),
    //testStair(false,null,"TestStair"),
    emberStoneSlab(false,null,"EmberStone Slab"),
    darkEmberStoneSlab(false,null,"Dark EmberStone Slab"),
    soapStoneSlab(false, null, "Soapstone Slab"),

    //props
    breakerBox(false, null, "breakerBox"),
    breakerBox2(false, null, "breakerBox2"),

    clampOnSignDerail(false, null, "clampOnSignDerail"),
    clampOnSignStop1(false, null, "clampOnSignStop1"),
    clampOnSignStop2(false, null, "clampOnSignStop2"),

    //lighting
    neonCageLightRoof(false, null, "neonCageLightRoof"),
    neonCageLightWallV(false, null, "neonCageLightWallV"),
    neonCageLightWallH(false, null, "neonCageLightWallH"),

    //modular bridges
    bridgeA_Center(false, null, "bridgeA_Center"),
    bridgeA_X_Side_Top(false, null, "bridgeA_X_Side_Top"),
    bridgeA_X_Side_Bottom(false, null, "bridgeA_X_Side_Bottom"),
    bridgeA_X_Side_Top2(false, null, "bridgeA_X_Side_Top2"),
    bridgeA_X_Side_Bottom2(false, null, "bridgeA_X_Side_Bottom2"),
    bridgeA_Side_Top(false, null, "bridgeA_Side_Top"),
    bridgeA_Side_Bottom(false, null, "bridgeA_Side_Bottom"),

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
