package com.bidahochi.BlockMod.core.handler;

/***************************
 *
 *  BlockIDs
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
 *  IT IS HIGHLY IMPORTANT THAT MaxMetatData is correct this can cause game crashing in the creative menu if wrong when not in a Dev Environment
 *
 ****************************/

import com.bidahochi.BlockMod.blocks.aggregates.ItemBlockFakeSnow;
import com.bidahochi.BlockMod.blocks.cobaltdeco.ItemBlockcobaltPanel;
import com.bidahochi.BlockMod.blocks.cobaltdeco.ItemBlockcobaltPanel2;
import com.bidahochi.BlockMod.blocks.constructionmaterials.*;
import com.bidahochi.BlockMod.blocks.essentiallymemes.ItemBlockBooBlox;
import com.bidahochi.BlockMod.blocks.lumber.*;
import com.bidahochi.BlockMod.blocks.metals.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public enum BlockIDs
{
    //ores
    bauxiteOre(false,null, "Bauxite"),
    cobaltOre(false,null,"CobaltOre"),
    aragoniteOre(false, null, "AragoniteOre"),
    gypsum(false,null,"gypsum"),
    taconite(false,null,"taconite"),
    hematite(false,null,"hematite"),

    //raw
    peagravel_snow(false,null, "peagravelsnow"),
    peagravel(false,null, "peagravel"),
    peagravel_shit(false, null, "Dirty Pea Gravel"),
    peagravel_volcanic(false, null, "Volcanic Cinder Peagravel"),
    peagravel_redrock(false, null, "Red Rock Peagravel"),
    gravel_volcanic(false, null, "Volcanic Cinder Gravel"),
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
    concreteBrick(true, ItemBlockconcreteBrick.class, "concreteBrick", 6),
    concreteFlooring(true, ItemBlockconcreteFloor.class, "concreteFloor", 4),
    plasteredConcrete(true, ItemBlockplasteredConcrete.class, "plasteredConcrete", 8),

    //stones
    soapStone(false, null, "Soapstone"), // Raw Soapstone
    soapStoneDeco(true, ItemBlocksoapStoneDeco.class, "Soapstone Deco", 4), // Soapstone Bricks
    soapStoneMagmatic(false, null, "Magmatic Soapstone"),
    soapStoneEmerald(false, null, "Emerald Soapstone Ore"),
    redrock(false, null, "Redrock"),

    jolietLimestoneRaw(false, null, "jolietlimestoneraw"),
    limestone(false, null, "limestone"),

    //bricks
    fireBrick(false, null, "fireBrick"),
    mortarBrick(true, ItemBlockmortarBrick.class, "mortarBrick", 8), // 8
    creamCity(true, ItemBlockCreamCity.class, "creamcity"),
    jolietLimestone(true, ItemBlockJolietLimestone.class, "jolietlimestone", 2), // Limestone Bricks
    redrockDeco(true, ItemBlockRedrockDeco.class, "RedrockDeco", 3), // 3

    // region Cobalt
    cobaltBlock(false,null,"cobaltBlock"),
    cobaltPanel(true, ItemBlockcobaltPanel.class,"cobaltPanel", 15), // ?
    cobaltPanel2(true, ItemBlockcobaltPanel2.class,"cobaltPanel2", 6), // Ma
    cobaltBrick(false,null,"cobaltBrick"), // Small Cobalt Bricks
    largeCobaltBrick(false,null,"largeCobaltBrick"), // Large Cobalt Bricks
    // endregion Cobalt

    // region tiles
    tile4(true, ItemBlocktile4.class,"tile4", 15), // Purple 4x4 Tile
    tile2x2(true, ItemBlockTile2x2.class, "Tile 2x2", 15), // Thanos Chin Purple 2x2 Tile
    tile2x2smooth(true, ItemBlockTile2x2Smooth.class, "Tile 2x2 Smooth", 15), // Purple 2x2 Bubble Tile
    diamondTile(true, ItemBlockdiamondTile.class,"Diamond Tile", 15), // Purple Diamond Tile
    subTile(true, ItemBlockSubTile.class,"SubTile", 4), // Terrain Tile (2x2 Light)
    terrocottaTiles(true, ItemBlockTerrocottaTiles.class, "TerrocottaTiles", 15), // Purple Terrocotta Tiles
    // endregion Titles

    //region fun
    although(false,null, "alothi"),
    testblock(false,null,"Test Block"),
    tHanos(false,null,"T Hanos"),
    booBlox(true, ItemBlockBooBlox.class, "BooBlox", 5),
    blockLavaBucket(false, null, "BlockOLavaBucket"),
    // THIS IS ACTUALLY RIGGS
    harieshHead(false,ItemBlockmetalSiding.class, "-hariesh"), //why does this have itemblockmetalsiding yet is false anyway?
    foxglass(false,null,"foxglass"),
    blue(false,null,"Blue"),
    green(false,null,"Green"),
    fofblock(false, null, "fofblock"),
    pingascube(false, null ,"pingascube"),
    invisiblock(false, null, "invisiblock"),
    //endregion fun

    //region lumber
    widePlank(true, ItemBlockwidePlank.class, "widePlank", 15),
    widePlank2(true, ItemBlockwidePlank2.class, "widePlank2", 15),
    widePlank3(true, ItemBlockwidePlank3.class, "widePlank3", 11),
    amtrak(true, ItemBlockAmtrak.class, "amshak", 2),
    logs(true, ItemBlockLogs.class, "logs", 2),
    leaves(true, ItemBlockLeaves.class, "leaves", 2),
    plywood(true, ItemBlockPlywood.class, "plywood", 7),
    woodchips(false, null, "woodchips"),
    wrappedwood1(false, null, "wrappedwood1"),
    wrappedwood2(false, null, "wrappedwood2"),
    wrappedwood3(false, null, "wrappedwood3"),
    wrappedwood4(false, null, "wrappedwood4"),
    wrappedwood5(false, null, "wrappedwood5"),
    wrappedwood6(false, null, "wrappedwood6"),
    wrappedwood7(false, null, "wrappedwood7"),

    unwrappedwood1(false, null, "unwrappedwood1"),
    unwrappedwood2(false, null, "unwrappedwood2"),
    unwrappedwood3(false, null, "unwrappedwood3"),
    unwrappedwood4(false, null, "unwrappedwood4"),
    unwrappedwood5(false, null, "unwrappedwood5"),
    unwrappedwood6(false, null, "unwrappedwood6"),
    unwrappedwood7(false, null, "unwrappedwood7"),
    unwrappedwood8(false, null, "unwrappedwood8"),
    unwrappedwood9(false, null, "unwrappedwood9"),


    //other building mats
    dryWall(true,ItemBlockdryWall.class,"Dry Wall", 15),
    wallPaper(true, ItemBlockwallPaper.class,"wallPaper", 15),
    unfinishedDrywall(false,null,"unfinishedDrywall"),
    fiberGlass(true, ItemBlockfiberGlass.class, "Fiber Glass", 2),

    originStuff(true, ItemBlockOriginStuff.class, "OriginStuff", 2),

    glassAssorted(true, ItemBlockGlassAssorted.class, "glassAssorted", 3),

    //region Roads
    tarmac(true, ItemBlockTarmac.class, "tarmac", 13),
    roadcover_tarmac0(false, null, "roadcover_tarmac_0"),
    roadcover_tarmac1(false, null, "roadcover_tarmac_1"),
    roadcover_tarmac2(false, null, "roadcover_tarmac_2"),
    roadcover_tarmac3(false, null, "roadcover_tarmac_3"),
    roadcover_tarmac4(false, null, "roadcover_tarmac_4"),
    roadcover_tarmac5(false, null, "roadcover_tarmac_5"),
    roadcover_tarmac6(false, null, "roadcover_tarmac_6"),
    //endregion Roads

    //region Metals
    metalSiding(true, ItemBlockmetalSiding.class, "Metal Siding", 15), // Vertical
    metalSiding2(true, ItemBlockmetalSiding2.class, "Metal Siding2", 15), // Horizontal
    pannelBlack(true, ItemBlockpannelBlack.class, "pannelBlack", 15), // Black Panel Edgeless #15
    pannelWhite(true, ItemBlockpannelWhite.class, "pannelWhite", 15), // White Panel Edgeless #15
    pannelExtra(true, ItemBlockpannelExtra.class, "pannelExtra", 4),
    rustBeam(true, ItemBlockrustBeam.class, "rustBeam", 5),
    labwallDark(true, ItemBlocklabwallDark.class, "labwallDark", 3),
    labwallLight(true, ItemBlocklabwallLight.class, "labwallLight", 3),
    wornVent(false, null, "WornVent1"),
    wornVent2(false, null, "WornVent2"),
    scaffold(false, null, "Scaffold"),
    scaffold2(false, null, "Scaffold2"),
    classicMetals(false, null, "ClassicIron"),
    classicGold(false, null, "ClassicGold"),
    //endregion Metals

    //region Hell
    darkEmberStone(false, null, "Dark Ember Stone"),
    emberStone(false,null,"Ember Stone"),
    //endregion Hell

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
    waysideWarningSignGreen(false, null, "waysideWarningSignGreen"),
    waysideWarningSignRed(false, null, "waysideWarningSignRed"),
    waysideWarningSignYellow(false, null, "waysideWarningSignYellow"),
    waysideWarningSignYellowRed(false, null, "waysideWarningSignYellowRed"),

    coil_centered(false, null, "Coil_centered"),
    coil_pair(false,null,"coil_pair"),

    toilet(false, null, "toilet"),

    //lighting
    neonCageLightRoof(false, null, "neonCageLightRoof"),
    neonCageLightWallV(false, null, "neonCageLightWallV"),
    neonCageLightWallH(false, null, "neonCageLightWallH"),
    ExteriorLightSquare(false, null, "ExteriorLightSquare"),
    ExteriorLightSquare2(false, null, "ExteriorLightSquare2"),

    //modular bridges
    bridgeA_Center(false, null, "bridgeA_Center"),
    bridgeA_X_Side_Top(false, null, "bridgeA_X_Side_Top"),
    bridgeA_X_Side_Bottom(false, null, "bridgeA_X_Side_Bottom"),
    bridgeA_X_Side_Top2(false, null, "bridgeA_X_Side_Top2"),
    bridgeA_X_Side_Bottom2(false, null, "bridgeA_X_Side_Bottom2"),
    bridgeA_Side_Top(false, null, "bridgeA_Side_Top"),
    bridgeA_Side_Bottom(false, null, "bridgeA_Side_Bottom"),

    //overhead wires
    overhead_pole_curve_3(false, null, "overhead_pole_curve_3"),
    overhead_pole_curve_3alt(false, null, "overhead_pole_curve_3alt"),
    overhead_pole_curve_5(false, null, "overhead_pole_curve_5"),
    overhead_pole_curve_5alt(false, null, "overhead_pole_curve_5alt"),
    overhead_pole_curve_10(false, null, "overhead_pole_curve_10"),
    overhead_pole_curve_10alt(false, null, "overhead_pole_curve_10alt"),
    overhead_pole_curve_16(false, null, "overhead_pole_curve_16"),
    overhead_pole_curve_16alt(false, null, "overhead_pole_curve_16alt"),
    overhead_pole_scurve_8(false, null, "overhead_pole_scurve_8"),
    overhead_pole_scurve_8alt(false, null, "overhead_pole_scurve_8alt"),
    overhead_pole_scurve_12(false, null, "overhead_pole_scurve_12"),
    overhead_pole_scurve_12alt(false, null, "overhead_pole_scurve_12alt"),
    overhead_pole_scurve_16(false, null, "overhead_pole_scurve_16"),
    overhead_pole_scurve_16alt(false, null, "overhead_pole_scurve_16alt"),
    overhead_pole_slope_6(false, null, "overhead_pole_slope_6"),
    overhead_pole_slope_6alt(false, null, "overhead_pole_slope_6alt"),
    overhead_pole_slope_12(false, null, "overhead_pole_slope_12"),
    overhead_pole_slope_12alt(false, null, "overhead_pole_slope_12alt"),
    overhead_pole_slope_18(false, null, "overhead_pole_slope_18"),
    overhead_pole_slope_18alt(false, null, "overhead_pole_slope_18alt"),
    overhead_pole_straight_6(false, null, "overhead_pole_straight_6"),
    overhead_pole_switch_6(false, null, "overhead_pole_switch_6"),
    overhead_pole_switch_6alt(false, null, "overhead_pole_switch_6alt"),
    overhead_pole_switch_parallel(false, null, "overhead_pole_switch_parallel"),
    overhead_pole_switch_parallelalt(false, null, "overhead_pole_switch_parallelalt"),
    overhead_pole(false, null, "overhead_pole"),
    overhead_pole_end(false, null, "overhead_pole_end"),
    overhead_hanger_end(false, null, "overhead_hanger_end"),

    overhead_hanger_curve_3(false, null, "overhead_hanger_curve_3"),
    overhead_hanger_curve_5(false, null, "overhead_hanger_curve_5"),
    overhead_hanger_curve_10(false, null, "overhead_hanger_curve_10"),
    overhead_hanger_curve_16(false, null, "overhead_hanger_curve_16"),
    overhead_hanger_scurve_8(false, null, "overhead_hanger_scurve_8"),
    overhead_hanger_scurve_8alt(false, null, "overhead_hanger_scurve_8alt"),
    overhead_hanger_scurve_12(false, null, "overhead_hanger_scurve_12"),
    overhead_hanger_scurve_12alt(false, null, "overhead_hanger_scurve_12alt"),
    overhead_hanger_scurve_16(false, null, "overhead_hanger_scurve_16"),
    overhead_hanger_scurve_16alt(false, null, "overhead_hanger_scurve_16alt"),
    overhead_hanger_slope_6(false, null, "overhead_hanger_slope_6"),
    overhead_hanger_slope_12(false, null, "overhead_hanger_slope_12"),
    overhead_hanger_slope_18(false, null, "overhead_hanger_slope_18"),
    overhead_hanger_straight_6(false, null, "overhead_hanger_straight_6"),
    overhead_hanger_switch_6(false, null, "overhead_hanger_switch_6"),
    overhead_hanger_switch_6alt(false, null, "overhead_hanger_switch_6alt"),
    overhead_hanger_switch_parallel(false, null, "overhead_hanger_switch_parallel"),
    overhead_hanger_switch_parallelalt(false, null, "overhead_hanger_switch_parallelalt"),

    overhead_npole_straight_1(false, null, "overhead_npole_straight_1"),
    overhead_npole_straight_3(false, null, "overhead_npole_straight_3"),
    overhead_npole_straight_6(false, null, "overhead_npole_straight_6"),
    overhead_npole_slope_6(false, null, "overhead_npole_slope_6"),
    overhead_npole_slope_12(false, null, "overhead_npole_slope_12"),
    overhead_npole_slope_18(false, null, "overhead_npole_slope_18"),
    overhead_npole_x(false, null, "overhead_npole_x"),

    //doors
    doorA(true, null, "doorAblock", -1),//office door red
    doorB(true, null, "doorBblock", -1),//office door brown
    doorC(true, null, "doorCblock", -1),//metal door
    doorD(true, null, "doorDblock", -1),//glados door
    doorE(true, null, "doorEblock", -1),//stall door

    //modular stall parts
    stallPart_T(false, null, "stallPart_T"),
    stallPart_Straight(false, null, "stallPart_Straight"),
    stallPart_Edge1(false, null, "stallPart_Edge1"),
    stallPart_Edge2(false, null, "stallPart_Edge2"),
    stallPart_TB(false, null, "stallPart_TB"),
    stallPart_StraightB(false, null, "stallPart_StraightB"),
    stallPart_Edge1B(false, null, "stallPart_Edge1B"),
    stallPart_Edge2B(false, null, "stallPart_Edge2B"),

    //roadpaints - "2" versions are for slabs - centered, yellow
    rpb_cy_s(false, null, "rpb_cy_s"),
    rpb_cy_r(false, null, "rpb_cy_r"),
    rpb_cy_t(false, null, "rpb_cy_t"),
    rpb_cy_x(false, null, "rpb_cy_x"),
    rpb_cy_d(false, null, "rpb_cy_d"),
    rpb_cy_dtl(false, null, "rpb_cy_dtl"),
    rpb_cy_dtr(false, null, "rpb_cy_dtr"),

    rpb_cy_s2(false, null, "rpb_cy_s2"),
    rpb_cy_r2(false, null, "rpb_cy_r2"),
    rpb_cy_t2(false, null, "rpb_cy_t2"),
    rpb_cy_x2(false, null, "rpb_cy_x2"),
    rpb_cy_d2(false, null, "rpb_cy_d2"),
    rpb_cy_dtl2(false, null, "rpb_cy_dtl2"),
    rpb_cy_dtr2(false, null, "rpb_cy_dtr2"),

    ;


    public Block block;
    public boolean hasItemBlock;
    public Class itemBlockClass;
    public String blockName;
    /** MaxMetaData for Multipart
     * -1 Disables the use of Multipart on the block
     * 0 Enabled the use of multipart on the block and will allow for only the base block to use Multipart
     */
    public byte MaxMetadata;

    /**
     * Construct a BlockID that has metaData
     * @param hasItemBlock
     * @param itemBlockClass Class
     * @param blockName name of the block
     * @param maxMetadata how many blocks with the same baseID should be generated for Forge Multipart
     */
    BlockIDs(boolean hasItemBlock, Class<? extends ItemBlock> itemBlockClass, String blockName, int maxMetadata) {
        this.hasItemBlock = hasItemBlock;
        this.itemBlockClass = itemBlockClass;
        this.blockName = blockName;
        this.MaxMetadata = ((byte) maxMetadata);
    }

    /**
     * Construct a BlockID that does not have metaData
     * @param hasItemBlock
     * @param itemBlockClass
     * @param blockName
     */
    BlockIDs(boolean hasItemBlock, Class<? extends ItemBlock> itemBlockClass, String blockName) {
        this.hasItemBlock = hasItemBlock;
        this.itemBlockClass = itemBlockClass;
        this.blockName = blockName;
        this.MaxMetadata = 0;
    }
}
