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

import com.bidahochi.BlockMod.blocks.aggregates.ItemBlockWithMetadata.ItemBlockFakeSnow;
import com.bidahochi.BlockMod.blocks.ItemBlockScrolling;
import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.ItemBlockWithMetadata.ItemRoadCoverDynamic1X1;
import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.ItemBlockWithMetadata.ItemRoadCoverDynamic1X2;
import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.ItemBlockWithMetadata.ItemRoadCoverDynamic1X3;
import com.bidahochi.BlockMod.blocks.roadpaints.ScrollingItemBlock;
import com.bidahochi.BlockMod.items.BaseItems.BaseItemBlock;
import com.bidahochi.BlockMod.items.SittingFloorTileBlock;
import com.bidahochi.BlockMod.items.SittingStairTileBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public enum BlockIDs implements IFoxBlockIDs
{
    //ores
    bauxiteOre(false,null, "Bauxite"),
    cobaltOre(false,null,"CobaltOre"),
    aragoniteOre(false, null, "AragoniteOre"),
    gypsum(false,null,"gypsum"),
    taconite(false,null,"taconite"),
    hematite(false,null,"hematite"),

    //raw
    peagravel_snow(true, BaseItemBlock.class, "peagravelsnow"),
    peagravel(true, BaseItemBlock.class, "peagravel"),
    peagravel_shit(true, BaseItemBlock.class, "Dirty Pea Gravel"),
    peagravel_volcanic(true, BaseItemBlock.class, "Volcanic Cinder Peagravel"),
    peagravel_redrock(true, BaseItemBlock.class, "Red Rock Peagravel"),
    gravel_volcanic(true, BaseItemBlock.class, "Volcanic Cinder Gravel"),
    gravel_shit(true, BaseItemBlock.class, "Dirty Gravel"),
    specialDirt(true, BaseItemBlock.class, "SpecialDirt"),
    slightlyGrowableGrass(true, BaseItemBlock.class, "SlightlyGrowableGrass"),
    deadGrass(true, BaseItemBlock.class, "DeadGrass"),
    deadGrass2(true, BaseItemBlock.class, "DeadGrass2"),
    turf(true, BaseItemBlock.class, "Turf"),
    turfsnow(true, BaseItemBlock.class, "Turfsnow"),
    peagravelBallast(true, BaseItemBlock.class, "peagravelBallast"),
    peagravelWhitestone(true, BaseItemBlock.class, "Peagravel Whitestone"),
    fakeSnow(true, ItemBlockFakeSnow.class, "FakeSnow"),
    dirt_3(true, BaseItemBlock.class, "Dirt_3"),
    dirt_4(true, BaseItemBlock.class, "Dirt_4"),
    creamCityClay(true, BaseItemBlock.class, "CreamCityClay"),

    //concrete
    Concrete(true,BaseItemBlock.class,"Concrete"),

    layeredConcrete(true, BaseItemBlock.class, "Layered Concrete"),

    smoothCrete(true, BaseItemBlock.class, "Smoothcrete"),

    concreteBrick(true, BaseItemBlock.class, "concreteBrick", 8),

    concreteFloor(true, BaseItemBlock.class, "concreteFloor", 4),

    plasteredConcrete(true, BaseItemBlock.class, "plasteredConcrete", 8),

    //stones
    soapStone(true, BaseItemBlock.class, "Soapstone"), // Raw Soapstone
    soapStoneDeco(true, BaseItemBlock.class, "Soapstone Deco", 4), // Soapstone Bricks
    soapStoneMagmatic(false, null, "Magmatic Soapstone"),
    soapStoneEmerald(false, null, "Emerald Soapstone Ore"),
    redrock(true, BaseItemBlock.class, "Redrock"),

    jolietLimestoneRaw(false, null, "jolietlimestoneraw"),
    limestone(false, null, "limestone"),

    //bricks
    fireBrick(true, BaseItemBlock.class, "fireBrick"),
    mortarBrick(true, BaseItemBlock.class, "mortarBrick", 15),
    mortarBrick2(true, BaseItemBlock.class, "mortarBrick2", 7),
    creamCity(true, BaseItemBlock.class, "creamcity", 2),
    jolietLimestone(true, BaseItemBlock.class, "jolietlimestone", 6), // Limestone Bricks
    redrockDeco(true, BaseItemBlock.class, "RedrockDeco", 3), // 3

    // region Cobalt
    cobaltBlock(true,BaseItemBlock.class,"cobaltBlock"),
    cobaltPanel(true, BaseItemBlock.class,"cobaltPanel", 15), // ?
    cobaltPanel2(true, BaseItemBlock.class,"cobaltPanel2", 6), // Ma
    cobaltBrick(true,BaseItemBlock.class,"cobaltBrick"), // Small Cobalt Bricks
    largeCobaltBrick(true,BaseItemBlock.class,"largeCobaltBrick"), // Large Cobalt Bricks
    // endregion Cobalt

    // region tiles
    tile4(true, BaseItemBlock.class,"tile4", 15), // Purple 4x4 Tile
    tile2x2(true, BaseItemBlock.class, "Tile 2x2", 15), // Thanos Chin Purple 2x2 Tile
    tile2x2smooth(true, BaseItemBlock.class, "Tile 2x2 Smooth", 15), // Purple 2x2 Bubble Tile
    diamondTile(true, BaseItemBlock.class,"Diamond Tile", 15), // Purple Diamond Tile
    subTile(true, BaseItemBlock.class,"SubTile", 4), // Terrain Tile (2x2 Light)
    terrocottaTiles(true, BaseItemBlock.class, "TerrocottaTiles", 15), // Purple Terrocotta Tiles
    // endregion Titles

    //region fun
    although(false,null, "alothi"),
    testblock(false,null,"Test Block"),
    tHanos(false,null,"T Hanos"),
    booBlox(true, BaseItemBlock.class, "BooBlox", 5),
    blockLavaBucket(false, null, "BlockOLavaBucket"),
    // THIS IS ACTUALLY RIGGS
    blockOfPlayerHead(true,BaseItemBlock.class, "blockOfPlayerHead"), //why does this have itemblockmetalsiding yet is false anyway?
    foxglass(false,null,"foxglass"),
    blue(true, BaseItemBlock.class,"Blue"),
    green(true, BaseItemBlock.class,"Green"),
    fofblock(true, BaseItemBlock.class, "fofblock"),
    pingascube(false, null ,"pingascube"),
    invisiblock(false, null, "invisiblock"),
    //endregion fun

    //region lumber
    widePlank(true, BaseItemBlock.class, "widePlank", 15),
    widePlank2(true, BaseItemBlock.class, "widePlank2", 15),
    widePlank3(true, BaseItemBlock.class, "widePlank3", 15),
    widePlank4(true, BaseItemBlock.class, "widePlank4", 1),
    planks1(true, BaseItemBlock.class, "planks1", 2),
    amtrak(true, BaseItemBlock.class, "amshak", 2),
    logs(true, BaseItemBlock.class, "logs", 2),
    leaves(true, BaseItemBlock.class, "leaves", 2),
    plywood(true, BaseItemBlock.class, "plywood", 10),
    woodchips(true, BaseItemBlock.class, "woodchips"),

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
    unwrappedwood10(false, null, "unwrappedwood10"),
    unwrappedwood11(false, null, "unwrappedwood11"),
    unwrappedwood12(false, null, "unwrappedwood12"),

    PFencing(true, BaseItemBlock.class, "PFencing", -1),


    //other building mats
    dryWall(true,BaseItemBlock.class,"Dry Wall", 15),
    wallPaper(true, BaseItemBlock.class,"wallPaper", 15),
    wallPaperBackrooms(true, BaseItemBlock.class, "wallPaperBackrooms", 1),
    unfinishedDrywall(true, BaseItemBlock.class,"unfinishedDrywall"),
    fiberGlass(true, BaseItemBlock.class, "Fiber Glass", 2),

    originStuff(true, BaseItemBlock.class, "OriginStuff", 2),

    classicwool(true, BaseItemBlock.class, "Classic Wool", 15),

    glassAssorted(true, BaseItemBlock.class, "glassAssorted", 3),
    glassAssortedPane(true, BaseItemBlock.class, "glassAssortedPane", -1),

    //region Roads
    tarmac(true, BaseItemBlock.class, "tarmac", 13),
    roadcover_dynamic1x1(true, ItemRoadCoverDynamic1X1.class, "roadcover_dynamic1x1", -1),
    roadcover_dynamic1x2(true, ItemRoadCoverDynamic1X2.class, "roadcover_dynamic1x2", -1),
    roadcover_dynamic1x3(true, ItemRoadCoverDynamic1X3.class, "roadcover_dynamic1x3", -1),
    roadcover_tarmac0(false, null, "roadcover_tarmac_0"),
    roadcover_tarmac1(false, null, "roadcover_tarmac_1"),
    roadcover_tarmac2(false, null, "roadcover_tarmac_2"),
    roadcover_tarmac3(false, null, "roadcover_tarmac_3"),
    roadcover_tarmac4(false, null, "roadcover_tarmac_4"),
    roadcover_tarmac5(false, null, "roadcover_tarmac_5"),
    roadcover_tarmac6(false, null, "roadcover_tarmac_6"),
    //endregion Roads

    //region Metals
    metalSiding(true, BaseItemBlock.class, "Metal Siding", 15), // Vertical
    metalSiding2(true, BaseItemBlock.class, "Metal Siding2", 15), // Horizontal
    pannelBlack(true, BaseItemBlock.class, "pannelBlack", 15), // Black Panel Edgeless #15
    pannelWhite(true, BaseItemBlock.class, "pannelWhite", 15), // White Panel Edgeless #15
    pannelExtra(true, BaseItemBlock.class, "pannelExtra", 4),
    rustBeam(true, BaseItemBlock.class, "rustBeam", 5),
    labwallDark(true, BaseItemBlock.class, "labwallDark", 3),
    labwallLight(true, BaseItemBlock.class, "labwallLight", 3),

    tf_dev(true, BaseItemBlock.class, "tf_dev", 9),
    tf_brick(true, BaseItemBlock.class, "tf_brick", 11),
    tf_wood(true, BaseItemBlock.class, "tf_wood", 10),
    tf_floor(true, BaseItemBlock.class, "tf_floor", 10),


    wornVent(false, null, "WornVent1"),
    wornVent2(false, null, "WornVent2"),
    scaffold(false, null, "Scaffold"),
    scaffold2(false, null, "Scaffold2"),
    classicMetals(BaseItemBlock.class, "ClassicIron", 1),
    classicGold(BaseItemBlock.class, "ClassicGold", 1),
    metalFencing(true, BaseItemBlock.class, "metalFencing", -1),
    //endregion Metals

    //region Hell
    darkEmberStone(true,BaseItemBlock.class, "Dark Ember Stone"),
    emberStone(true,BaseItemBlock.class,"Ember Stone"),
    //endregion Hell

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
    sittingStairTile(true, SittingStairTileBlock.class, "sittingstairtile"),
    sittingFloorTile(true, SittingFloorTileBlock.class, "sittingfloortile"),
    wall_sink(false, null, "wall_sink"),

    soda_machine(false, null, "soda_machine"),

    //lighting
    neonCageLightRoof(false, null, "neonCageLightRoof"),
    neonCageLightWallV(false, null, "neonCageLightWallV"),
    neonCageLightWallH(false, null, "neonCageLightWallH"),
    ExteriorLightSquare(false, null, "ExteriorLightSquare"),
    ExteriorLightSquare2(false, null, "ExteriorLightSquare2"),
    lamp2warm(false, null, "lamp2warm"),
    lamp2cold(false, null, "lamp2cold"),

    //modular bridges
    bridgeA_Center(ItemBlockScrolling.class, "bridgeA_Center"),
    bridgeA_CenterDiag(ItemBlockScrolling.class, "bridgeA_CenterDiag"),
    bridgeA_X_Side_Top(ItemBlockScrolling.class, "bridgeA_X_Side_Top"),
    bridgeA_X_Side_TopDiag(ItemBlockScrolling.class, "bridgeA_X_Side_TopDiag"),
    bridgeA_X_Side_Bottom(ItemBlockScrolling.class, "bridgeA_X_Side_Bottom"),
    bridgeA_X_Side_BottomDiag(ItemBlockScrolling.class, "bridgeA_X_Side_BottomDiag"),
    bridgeA_X_Side_Top2(ItemBlockScrolling.class, "bridgeA_X_Side_Top2"),
    bridgeA_X_Side_Bottom2(ItemBlockScrolling.class, "bridgeA_X_Side_Bottom2"),
    bridgeA_Side_Top(ItemBlockScrolling.class, "bridgeA_Side_Top"),
    bridgeA_Side_TopDiag(ItemBlockScrolling.class, "bridgeA_Side_TopDiag"),
    bridgeA_Side_Bottom(ItemBlockScrolling.class, "bridgeA_Side_Bottom"),
    bridgeA_Side_BottomDiag(ItemBlockScrolling.class, "bridgeA_Side_BottomDiag"),

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

    //roadpaints
    //dynamic
    rpb_cy(false, null, "rpb_cy"),//centered yellow single
    rpb_cy2(false, null, "rpb_cy2"),//centered yellow double
    rpb_oyd(false, null, "rpb_oyd"), //offset yellow diagonal
    rpb_oys(false, null, "rpb_oys"),
    rpb_owd(false, null, "rpb_owd"), //offset yellow diagonal
    rpb_ows(false, null, "rpb_ows"),
    rpb_cw(false, null, "rpb_cw"),
    //static
    srpb_cy(true, ScrollingItemBlock.class, "srpb_cy"),//center yellow single
    srpb_cy2(true, ScrollingItemBlock.class, "srpb_cy2"),//center yellow double
    srpb_cw(true, ScrollingItemBlock.class, "srpb_cw"),//center yellow single
    srpb_whiteOffset(true, ScrollingItemBlock.class, "srpb_whiteOffset"),
    srpb_yellowOffset(true, ScrollingItemBlock.class, "srpb_yellowOffset"),
    srpb_dw1(true, ScrollingItemBlock.class, "srpb_dw1"),//details white 1

    //xmas
    xmasLights1_top_white(false, null, "XmasLights1_top_white"),
    xmasLights1_bottom_white(false, null, "XmasLights1_bottom_white"),
    xmasLights1_top_rainbow(false, null, "XmasLights1_top_rainbow"),
    xmasLights1_bottom_rainbow(false, null, "XmasLights1_bottom_rainbow"),

    propTrailerDryvan1(false, null, "propTrailerDryvan1"),
    propTrailerDryvan1a(false, null, "propTrailerDryvan1a"),

    ;

    public Block block;
    public final boolean hasItemBlock;
    public final Class itemBlockClass;
    public final String blockName;
    /** MaxMetaData for Multipart
     * -1 Disables the use of Multipart on the block
     * 0 Enabled the use of multipart on the block and will allow for only the base block to use Multipart
     */
    public final byte MaxMetadata;

    /**
     * Construct a BlockID that has metaData
     * @param itemBlockClass Class
     * @param blockName name of the block
     * @param maxMetadata how many blocks with the same baseID should be generated for Forge Multipart
     */
    BlockIDs(Class<? extends ItemBlock> itemBlockClass, String blockName, int maxMetadata)
    {
        this.hasItemBlock = true;
        this.itemBlockClass = itemBlockClass;
        this.blockName = blockName;
        this.MaxMetadata = ((byte) maxMetadata);
    }

    /**
     * Construct a BlockID that has metaData
     * @param hasItemBlock
     * @param itemBlockClass Class
     * @param blockName name of the block
     * @param maxMetadata how many blocks with the same baseID should be generated for Forge Multipart
     */
    BlockIDs(boolean hasItemBlock, Class<? extends ItemBlock> itemBlockClass, String blockName, int maxMetadata)
    {
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

    BlockIDs(Class<? extends ItemBlock> itemBlockClass, String blockName) {
        this.hasItemBlock = true;
        this.itemBlockClass = itemBlockClass;
        this.blockName = blockName;
        this.MaxMetadata = 0;
    }

    public static <T extends Enum<?>> T searchEnum(Class<T> enumeration,
                                                   String search) {
        for (T each : enumeration.getEnumConstants()) {
            if (each.name().compareToIgnoreCase(search) == 0) {
                return each;
            }
        }
        return null;
    }

    @Override
    public Block GetBlock() {
        return this.block;
    }

    @Override
    public boolean hasItemBlock() {
        return this.hasItemBlock;
    }

    @Override
    public Class getItemBlockClass() {
        return this.itemBlockClass;
    }

    @Override
    public byte GetMaxMetaData() {
        return this.MaxMetadata;
    }

    @Override
    public String GetBlockName() {
        return this.blockName;
    }
}
