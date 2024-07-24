package com.bidahochi.BlockMod.core.handler;

/********************
 *
 *  blockHander
 *
 *  This file allows you to register your blocks to MINECRAFT without cluttering up Foxblocks.java
 *  MAKE SURE YOU REGISTER THEM TO FOXBLOCKS IN BlockIDs.java  in com.bidahochi.BlockMod.core.handler;
 *
 *  This file is ONLY for registering blocks to the mod. Do not try to add properties like hardness here
 *
 *  You can set hardness and other properties in the block class file directly. just do set### under the main class in the block file
 *
 *  Use Format:
 *      BlockIDs.blockname.block = new BlockName(materialOfBlock);
 *
 *  Any Questions feel free to DM me or Ping Me in discord!
 ********************/

import com.bidahochi.BlockMod.blocks.bridgestuff.*;
import com.bidahochi.BlockMod.blocks.cobaltdeco.*;
import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.constructionmaterials.*;
import com.bidahochi.BlockMod.blocks.StallParts.*;
import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.*;
import com.bidahochi.BlockMod.blocks.hell.*;
import com.bidahochi.BlockMod.blocks.lighting.*;
import com.bidahochi.BlockMod.blocks.lumber.*;
import com.bidahochi.BlockMod.blocks.metals.*;
import com.bidahochi.BlockMod.blocks.essentiallymemes.*;
import com.bidahochi.BlockMod.blocks.aggregates.*;
import com.bidahochi.BlockMod.blocks.overhead.*;
import com.bidahochi.BlockMod.blocks.props.*;
import com.bidahochi.BlockMod.blocks.roadpaints.*;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.Rpb_cy_r;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.Rpb_cy_r2;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.Rpb_cy_s;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.Rpb_cy_s2;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRpb_cy_r;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRpb_cy_r2;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRpb_cy_s;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRpb_cy_s2;
import com.bidahochi.BlockMod.blocks.stones.*;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockHandler {
    public static CreativeTabs foxBlocksCreativeTab;

    public static void initBlockRegister(FMLInitializationEvent e){

        //FoxBlocks.blockLogger.info("BlockRegister Pre Init at com.bidahochi.BlockMod.core.handler.blockHandler");


        //ores
        BlockIDs.bauxiteOre.block = new BauxiteOre(Material.rock);
        BlockIDs.cobaltOre.block = new CobaltOre(Material.rock);
        BlockIDs.aragoniteOre.block = new AragoniteOre(Material.rock);
        BlockIDs.gypsum.block = new Gypsum(Material.rock);
        BlockIDs.taconite.block = new Taconite(Material.rock);
        BlockIDs.hematite.block = new Hematite(Material.rock);

        //raw
        BlockIDs.peagravel_snow.block = new SnowyPeaGravel(Material.sand);
        BlockIDs.peagravel.block = new PeaGravel(Material.sand);
        BlockIDs.peagravel_shit.block = new PeaGravelDirty(Material.sand);
        BlockIDs.peagravel_volcanic.block = new PeaGravelVolcanic(Material.rock);
        BlockIDs.peagravel_redrock.block = new PeaGravelRedRock(Material.rock);
        BlockIDs.gravel_volcanic.block = new GravelVolcanic(Material.rock);
        BlockIDs.gravel_shit.block = new GravelDirty(Material.sand);
        BlockIDs.specialDirt.block = new SpecialDirt(Material.ground);
        BlockIDs.peagravelBallast.block = new PeaGravelBallast(Material.sand);
        BlockIDs.peagravelWhitestone.block = new PeaGravelWhitestone(Material.sand);
        BlockIDs.fakeSnow.block = new FakeSnow(Material.ground);
        BlockIDs.dirt_4.block = new Dirt_4(Material.sand);
        BlockIDs.creamCityClay.block = new CreamCityClay(Material.clay);

        //concretes
        BlockIDs.rawConcrete.block = new RawConcrete(Material.rock);
        BlockIDs.layeredConcrete.block = new LayeredConcrete(Material.rock);
        BlockIDs.smoothCrete.block = new Smoothcrete(Material.rock);
        BlockIDs.concreteBrick.block = new ConcreteBrick(Material.rock);
        BlockIDs.concreteFlooring.block = new ConcreteFloor(Material.rock);
        BlockIDs.plasteredConcrete.block = new PlasteredConcrete(Material.rock);

        //stones
        BlockIDs.soapStone.block = new SoapStone(Material.rock);
        BlockIDs.soapStoneMagmatic.block = new soapStoneMagmatic(Material.rock);
        BlockIDs.soapStoneDeco.block = new SoapStoneDeco(Material.rock);
        BlockIDs.soapStoneEmerald.block = new soapStoneEmerald(Material.rock);
        BlockIDs.redrock.block = new RedRock(Material.rock);

        BlockIDs.jolietLimestoneRaw.block = new JolietLimestoneRaw(Material.rock);
        BlockIDs.limestone.block = new Limestone(Material.rock);

        //bricks
        BlockIDs.fireBrick.block = new FireBrick(Material.rock);
        BlockIDs.mortarBrick.block = new MortarBrick(Material.rock);
        BlockIDs.creamCity.block = new CreamCity(Material.rock);
        BlockIDs.jolietLimestone.block = new JolietLimestone(Material.rock);
        BlockIDs.redrockDeco.block = new RedrockDeco(Material.rock);

        BlockIDs.cobaltBlock.block = new CobaltBlock(Material.rock);
        BlockIDs.cobaltPanel.block = new CobaltPanel(Material.rock);
        BlockIDs.cobaltPanel2.block = new CobaltPanel2(Material.rock);
        BlockIDs.cobaltBrick.block = new CobaltBrick(Material.rock);
        BlockIDs.largeCobaltBrick.block = new LargeCobaltBrick(Material.rock);

        //tiles
        BlockIDs.tile4.block = new Tile4(Material.rock);
        BlockIDs.tile2x2.block = new Tile2x2(Material.rock);
        BlockIDs.tile2x2smooth.block = new Tile2x2smooth(Material.rock);
        BlockIDs.diamondTile.block = new DiamondTile(Material.rock);
        BlockIDs.subTile.block = new SubTile(Material.rock);
        BlockIDs.terrocottaTiles.block = new TerrocottaTiles(Material.rock);

        //fun
        BlockIDs.although.block = new Although(Material.clay);
        BlockIDs.testblock.block = new TestBlock(Material.iron);
        BlockIDs.tHanos.block = new Thanos(Material.sponge);
        BlockIDs.booBlox.block = new BooBlox(Material.cloth);
        BlockIDs.blockLavaBucket.block = new BlockLavaBucket(Material.iron);
        BlockIDs.harieshHead.block = new HarieshHead(Material.gourd);
        BlockIDs.foxglass.block = new foxglass(Material.glass);
        BlockIDs.blue.block = new BaseBlock(Material.glass, "Blue Block", 1F, 1F, "pickaxe", 0, Block.soundTypeGlass, "colour/blue");
        BlockIDs.green.block = new BaseBlock(Material.glass, "Green Block", 1F, 1F, "pickaxe", 0, Block.soundTypeGlass, "colour/green");
        BlockIDs.fofblock.block = new Fofblock(Material.cake);
        BlockIDs.pingascube.block = new Pingascube(Material.glass);
        BlockIDs.invisiblock.block = new Invisiblock(Material.wood);

        //lumber
        BlockIDs.widePlank.block = new WidePlank(Material.wood);
        BlockIDs.widePlank2.block = new WidePlank2(Material.wood);
        BlockIDs.widePlank3.block = new WidePlank3(Material.wood);
        BlockIDs.amtrak.block = new Amtrak(Material.wood);
        BlockIDs.logs.block = new Logs(Material.wood);
        BlockIDs.leaves.block = new Leaves(Material.leaves);
        BlockIDs.plywood.block = new Plywood(Material.wood);
        BlockIDs.woodchips.block = new Woodchips(Material.wood);
        BlockIDs.wrappedwood1.block = new WrappedWood1(Material.wood);
        BlockIDs.wrappedwood2.block = new WrappedWood2(Material.wood);
        BlockIDs.wrappedwood3.block = new WrappedWood3(Material.wood);
        BlockIDs.wrappedwood4.block = new WrappedWood4(Material.wood);
        BlockIDs.wrappedwood5.block = new WrappedWood5(Material.wood);
        BlockIDs.wrappedwood6.block = new WrappedWood6(Material.wood);

        //other building materials
        BlockIDs.dryWall.block = new DryWall(Material.clay);
        BlockIDs.wallPaper.block = new WallPaper(Material.cloth);
        BlockIDs.unfinishedDrywall.block = new UnfinishedDrywall(Material.clay);
        BlockIDs.fiberGlass.block = new FiberGlass(Material.glass);

        BlockIDs.originStuff.block = new OriginStuff(Material.rock);

        BlockIDs.glassAssorted.block = new GlassAssorted(Material.glass);

        BlockIDs.tarmac.block = new Tarmac(Material.rock);
        BlockIDs.roadcover_tarmac0.block = new RoadCover0(Material.rock);
        BlockIDs.roadcover_tarmac1.block = new RoadCover1(Material.rock);
        BlockIDs.roadcover_tarmac2.block = new RoadCover2(Material.rock);
        BlockIDs.roadcover_tarmac3.block = new RoadCover3(Material.rock);
        BlockIDs.roadcover_tarmac4.block = new RoadCover4(Material.rock);
        BlockIDs.roadcover_tarmac5.block = new RoadCover5(Material.rock);
        BlockIDs.roadcover_tarmac6.block = new RoadCover6(Material.rock);

        //metals
        BlockIDs.metalSiding.block = new MetalSiding(Material.iron);
        BlockIDs.metalSiding2.block = new MetalSiding2(Material.iron);
        BlockIDs.pannelBlack.block = new PannelBlack(Material.iron);
        BlockIDs.pannelWhite.block = new PannelWhite(Material.iron);
        BlockIDs.pannelExtra.block = new PannelExtra(Material.iron);
        BlockIDs.rustBeam.block = new RustBeam(Material.iron);
        BlockIDs.labwallDark.block = new LabwallDark(Material.rock);
        BlockIDs.labwallLight.block = new LabwallLight(Material.rock);
        BlockIDs.wornVent.block = new WornVent1(Material.iron);
        BlockIDs.wornVent2.block = new WornVent2(Material.iron);
        BlockIDs.scaffold.block = new Scaffold(Material.iron);
        BlockIDs.scaffold2.block = new Scaffold2(Material.iron);
        BlockIDs.classicMetals.block = new ClassicMetals(Material.iron);
        BlockIDs.classicGold.block = new ClassicGold(Material.iron);

        //hekk
        BlockIDs.emberStone.block = new EmberStone(Material.rock);
        BlockIDs.darkEmberStone.block = new DarkEmberStone(Material.rock);

        //additional
        BlockIDs.emberStoneStair.block = new BaseStair(BlockIDs.emberStone.block, 0,"EmberStone Stair",2F,2F,Block.soundTypeStone,"pickaxe",2,0, FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.darkEmberStoneStair.block = new BaseStair(BlockIDs.darkEmberStone.block, 0,"Dark EmberStone Stair",2F, 2F,Block.soundTypeStone, "pickaxe",2, 0, FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.soapStoneStair.block = new BaseStair(BlockIDs.soapStone.block, 0, "Soapstone Stair", 7F, 15F, Block.soundTypeStone, "pickaxe", 1, 0, FoxBlocks.foxBlocksCreativeTabRock);
        //BlockIDs.testPane.block = new testPane(BlockIDs.testPane.blockName, Material.iron, true);
        //BlockIDs.testSlab.block = new testSlab(false, Material.iron);
        //BlockIDs.testStair.block = new testStair(BlockIDs.bauxiteOre.block, 0);
        BlockIDs.emberStoneSlab.block = new BaseSlab(false, Material.rock,BlockIDs.emberStoneSlab.blockName, 2F,2F,Block.soundTypeStone,"pickaxe",2,0,"hell/emberStone", FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.darkEmberStoneSlab.block = new BaseSlab(false, Material.rock,"Dark EmberStone Slab", 2F,2F,Block.soundTypeStone,"pickaxe",2,0,"hell/darkEmberStone", FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.soapStoneSlab.block = new BaseSlab(false, Material.rock, "Soapstone Slab", 7F, 15F, Block.soundTypeStone, "pickaxe", 1, 0, "stones/soapstone", FoxBlocks.foxBlocksCreativeTabRock);

        //props
        BlockIDs.breakerBox.block = new BreakerBox(Material.iron);
        BlockIDs.breakerBox2.block = new BreakerBox2(Material.iron);

        BlockIDs.clampOnSignDerail.block = new ClampOnSignDerail(Material.iron);
        BlockIDs.clampOnSignStop1.block = new ClampOnSignStop1(Material.iron);
        BlockIDs.clampOnSignStop2.block = new ClampOnSignStop2(Material.iron);
        BlockIDs.waysideWarningSignGreen.block = new WaysideWarningSignGreen(Material.iron);
        BlockIDs.waysideWarningSignRed.block = new WaysideWarningSignRed(Material.iron);
        BlockIDs.waysideWarningSignYellow.block = new WaysideWarningSignYellow(Material.iron);
        BlockIDs.waysideWarningSignYellowRed.block = new WaysideWarningSignYellowRed(Material.iron);

        BlockIDs.toilet.block = new Toilet(Material.iron);

        //lighting
        BlockIDs.neonCageLightRoof.block = new NeonCageLampRoof(Material.iron);
        BlockIDs.neonCageLightWallV.block = new NeonCageLampWallV(Material.iron);
        BlockIDs.neonCageLightWallH.block = new NeonCageLampWallH(Material.iron);
        BlockIDs.ExteriorLightSquare.block = new ExteriorLightSquare(Material.iron);
        BlockIDs.ExteriorLightSquare2.block = new ExteriorLightSquare2(Material.iron);

        //modular bridge
        BlockIDs.bridgeA_Center.block = new BridgeA_Center(Material.wood);
        BlockIDs.bridgeA_X_Side_Top.block = new BridgeA_X_Side_top(Material.wood);
        BlockIDs.bridgeA_X_Side_Bottom.block = new BridgeA_X_Side_Bottom(Material.wood);
        BlockIDs.bridgeA_X_Side_Top2.block = new BridgeA_X_Side_Top2(Material.wood);
        BlockIDs.bridgeA_X_Side_Bottom2.block = new BridgeA_X_Side_Bottom2(Material.wood);
        BlockIDs.bridgeA_Side_Top.block = new BridgeA_Side_Top(Material.wood);
        BlockIDs.bridgeA_Side_Bottom.block = new BridgeA_Side_Bottom(Material.wood);

        //overhead wires
        BlockIDs.overhead_pole_curve_3.block = new Overhead_pole_curve_3(Material.wood);
        BlockIDs.overhead_pole_curve_3alt.block = new Overhead_pole_curve_3alt(Material.wood);
        BlockIDs.overhead_pole_curve_5.block = new Overhead_pole_curve_5(Material.wood);
        BlockIDs.overhead_pole_curve_5alt.block = new Overhead_pole_curve_5alt(Material.wood);
        BlockIDs.overhead_pole_curve_10.block = new Overhead_pole_curve_10(Material.wood);
        BlockIDs.overhead_pole_curve_10alt.block = new Overhead_pole_curve_10alt(Material.wood);
        BlockIDs.overhead_pole_curve_16.block = new Overhead_pole_curve_16(Material.wood);
        BlockIDs.overhead_pole_curve_16alt.block = new Overhead_pole_curve_16alt(Material.wood);
        BlockIDs.overhead_pole_scurve_8.block = new Overhead_pole_scurve_8(Material.wood);
        BlockIDs.overhead_pole_scurve_8alt.block = new Overhead_pole_scurve_8alt(Material.wood);
        BlockIDs.overhead_pole_scurve_12.block = new Overhead_pole_scurve_12(Material.wood);
        BlockIDs.overhead_pole_scurve_12alt.block = new Overhead_pole_scurve_12alt(Material.wood);
        BlockIDs.overhead_pole_scurve_16.block = new Overhead_pole_scurve_16(Material.wood);
        BlockIDs.overhead_pole_scurve_16alt.block = new Overhead_pole_scurve_16alt(Material.wood);
        BlockIDs.overhead_pole_slope_6.block = new Overhead_pole_slope_6(Material.wood);
        BlockIDs.overhead_pole_slope_6alt.block = new Overhead_pole_slope_6alt(Material.wood);
        BlockIDs.overhead_pole_slope_12.block = new Overhead_pole_slope_12(Material.wood);
        BlockIDs.overhead_pole_slope_12alt.block = new Overhead_pole_slope_12alt(Material.wood);
        BlockIDs.overhead_pole_slope_18.block = new Overhead_pole_slope_18(Material.wood);
        BlockIDs.overhead_pole_slope_18alt.block = new Overhead_pole_slope_18alt(Material.wood);
        BlockIDs.overhead_pole_straight_6.block = new Overhead_pole_straight_6(Material.wood);
        BlockIDs.overhead_pole_switch_6.block = new Overhead_pole_switch_6(Material.wood);
        BlockIDs.overhead_pole_switch_6alt.block = new Overhead_pole_switch_6alt(Material.wood);
        BlockIDs.overhead_pole_switch_parallel.block = new Overhead_pole_switch_parallel(Material.wood);
        BlockIDs.overhead_pole_switch_parallelalt.block = new Overhead_pole_switch_parallelalt(Material.wood);
        BlockIDs.overhead_pole.block = new Overhead_pole(Material.wood);
        BlockIDs.overhead_pole_end.block = new Overhead_pole_end(Material.wood);
        BlockIDs.overhead_hanger_end.block = new Overhead_hanger_end(Material.wood);

        BlockIDs.overhead_hanger_curve_3.block = new Overhead_hanger_curve_3(Material.wood);
        BlockIDs.overhead_hanger_curve_5.block = new Overhead_hanger_curve_5(Material.wood);
        BlockIDs.overhead_hanger_curve_10.block = new Overhead_hanger_curve_10(Material.wood);
        BlockIDs.overhead_hanger_curve_16.block = new Overhead_hanger_curve_16(Material.wood);
        BlockIDs.overhead_hanger_scurve_8.block = new Overhead_hanger_scurve_8(Material.wood);
        BlockIDs.overhead_hanger_scurve_8alt.block = new Overhead_hanger_scurve_8alt(Material.wood);
        BlockIDs.overhead_hanger_scurve_12.block = new Overhead_hanger_scurve_12(Material.wood);
        BlockIDs.overhead_hanger_scurve_12alt.block = new Overhead_hanger_scurve_12alt(Material.wood);
        BlockIDs.overhead_hanger_scurve_16.block = new Overhead_hanger_scurve_16(Material.wood);
        BlockIDs.overhead_hanger_scurve_16alt.block = new Overhead_hanger_scurve_16alt(Material.wood);
        BlockIDs.overhead_hanger_slope_6.block = new Overhead_hanger_slope_6(Material.wood);
        BlockIDs.overhead_hanger_slope_12.block = new Overhead_hanger_slope_12(Material.wood);
        BlockIDs.overhead_hanger_slope_18.block = new Overhead_hanger_slope_18(Material.wood);
        BlockIDs.overhead_hanger_straight_6.block = new Overhead_hanger_straight_6(Material.wood);
        BlockIDs.overhead_hanger_switch_6.block = new Overhead_hanger_switch_6(Material.wood);
        BlockIDs.overhead_hanger_switch_6alt.block = new Overhead_hanger_switch_6alt(Material.wood);
        BlockIDs.overhead_hanger_switch_parallel.block = new Overhead_hanger_switch_parallel(Material.wood);
        BlockIDs.overhead_hanger_switch_parallelalt.block = new Overhead_hanger_switch_parallelalt(Material.wood);

        BlockIDs.overhead_npole_straight_1.block = new Overhead_npole_straight_1(Material.wood);
        BlockIDs.overhead_npole_straight_3.block = new Overhead_npole_straight_3(Material.wood);
        BlockIDs.overhead_npole_straight_6.block = new Overhead_npole_straight_6(Material.wood);
        BlockIDs.overhead_npole_slope_6.block = new Overhead_npole_slope_6(Material.wood);
        BlockIDs.overhead_npole_slope_12.block = new Overhead_npole_slope_12(Material.wood);
        BlockIDs.overhead_npole_slope_18.block = new Overhead_npole_slope_18(Material.wood);
        BlockIDs.overhead_npole_x.block = new Overhead_npole_x(Material.wood);

        //doors
        BlockIDs.doorA.block = new baseDoor(Material.wood).setBlockName("doorA").setHardness(3F).setStepSound(Block.soundTypeWood).setBlockTextureName(FoxBlocks.MODID+":door_a").setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
        BlockIDs.doorB.block = new baseDoor(Material.wood).setBlockName("doorB").setHardness(3F).setStepSound(Block.soundTypeWood).setBlockTextureName(FoxBlocks.MODID+":door_b").setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
        BlockIDs.doorC.block = new baseDoor(Material.wood).setBlockName("doorC").setHardness(3F).setStepSound(Block.soundTypeMetal).setBlockTextureName(FoxBlocks.MODID+":door_c").setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
        BlockIDs.doorD.block = new baseDoor(Material.wood).setBlockName("doorD").setHardness(3F).setStepSound(Block.soundTypeMetal).setBlockTextureName(FoxBlocks.MODID+":door_d").setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
        BlockIDs.doorE.block = new baseDoor(Material.wood).setBlockName("doorD").setHardness(3F).setStepSound(Block.soundTypeMetal).setBlockTextureName(FoxBlocks.MODID+":door_e").setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);

        //modular stall parts
        BlockIDs.stallPart_T.block = new StallPart_T(Material.iron);
        BlockIDs.stallPart_Straight.block = new StallPart_Straight(Material.iron);
        BlockIDs.stallPart_Edge1.block = new StallPart_Edge1(Material.iron);
        BlockIDs.stallPart_Edge2.block = new StallPart_Edge2(Material.iron);
        BlockIDs.stallPart_TB.block = new StallPart_TB(Material.iron);
        BlockIDs.stallPart_StraightB.block = new StallPart_StraightB(Material.iron);
        BlockIDs.stallPart_Edge1B.block = new StallPart_Edge1B(Material.iron);
        BlockIDs.stallPart_Edge2B.block = new StallPart_Edge2B(Material.iron);

        //roadpaint blocks
        BlockIDs.rpb_cy_s.block = new Rpb_cy_s(Material.rock);
        BlockIDs.rpb_cy_r.block = new Rpb_cy_r(Material.rock);

        BlockIDs.rpb_cy_s2.block = new Rpb_cy_s2(Material.rock);
        BlockIDs.rpb_cy_r2.block = new Rpb_cy_r2(Material.rock);

        GameRegistry.registerTileEntity(TileBreakerBox.class, "breakerbox.tile");
        GameRegistry.registerTileEntity(TileBreakerBox2.class, "breakerbox2.tile");
        GameRegistry.registerTileEntity(TileClampOnSignDerail.class, "clampOnSignDerail.tile");
        GameRegistry.registerTileEntity(TileClampOnSignStop1.class, "clampOnSignStop1.tile");
        GameRegistry.registerTileEntity(TileClampOnSignStop2.class, "clampOnSignStop2.tile");
        GameRegistry.registerTileEntity(TileWaysideWarningSignGreen.class, "waysideWarningSignGreen.tile");
        GameRegistry.registerTileEntity(TileWaysideWarningSignRed.class, "waysideWarningSignRed.tile");
        GameRegistry.registerTileEntity(TileWaysideWarningSignYellow.class, "waysideWarningSignYellow.tile");
        GameRegistry.registerTileEntity(TileWaysideWarningSignYellowRed.class, "waysideWarningSignYellowRed.tile");

        GameRegistry.registerTileEntity(TileToilet.class, "toilet.tile");

        GameRegistry.registerTileEntity(TileNeonCageLampRoof.class, "neonCageLightRoof.tile");
        GameRegistry.registerTileEntity(TileNeonCageLampWallV.class, "neonCageLightWallV.tile");
        GameRegistry.registerTileEntity(TileNeonCageLampWallH.class, "neonCageLightWallH.tile");
        GameRegistry.registerTileEntity(TileExteriorLightSquare.class, "ExteriorLightSquare.tile");
        GameRegistry.registerTileEntity(TileExteriorLightSquare2.class, "ExteriorLightSquare2.tile");

        GameRegistry.registerTileEntity(TileBridgeA_Center.class, "bridgeA_Center.tile");
        GameRegistry.registerTileEntity(TileBridgeA_X_Side_Center_Top.class, "bridgeA_X_Side_Center_Top.tile");
        GameRegistry.registerTileEntity(TileBridgeA_X_Side_Center_Bottom.class, "bridgeA_X_Side_Center_Bottom.tile");
        GameRegistry.registerTileEntity(TileBridgeA_X_Side_Center_Top2.class, "bridgeA_X_Side_Center_Top2.tile");
        GameRegistry.registerTileEntity(TileBridgeA_X_Side_Center_Bottom2.class, "bridgeA_X_Side_Center_Bottom2.tile");
        GameRegistry.registerTileEntity(TileBridgeA_Side_Top.class, "bridgeA_Side_Top.tile");
        GameRegistry.registerTileEntity(TileBridgeA_Side_Bottom.class, "bridgeA_Side_Bottom.tile");

        GameRegistry.registerTileEntity(TileRoadCover0.class, "roadcover0.tile");
        GameRegistry.registerTileEntity(TileRoadCover1.class, "roadcover1.tile");
        GameRegistry.registerTileEntity(TileRoadCover2.class, "roadcover2.tile");
        GameRegistry.registerTileEntity(TileRoadCover3.class, "roadcover3.tile");
        GameRegistry.registerTileEntity(TileRoadCover4.class, "roadcover4.tile");
        GameRegistry.registerTileEntity(TileRoadCover5.class, "roadcover5.tile");
        GameRegistry.registerTileEntity(TileRoadCover6.class, "roadcover6.tile");

        GameRegistry.registerTileEntity(TileWrappedWood1.class, "wrappedwood1.tile");
        GameRegistry.registerTileEntity(TileWrappedWood2.class, "wrappedwood2.tile");
        GameRegistry.registerTileEntity(TileWrappedWood3.class, "wrappedwood3.tile");
        GameRegistry.registerTileEntity(TileWrappedWood4.class, "wrappedwood4.tile");
        GameRegistry.registerTileEntity(TileWrappedWood5.class, "wrappedwood5.tile");
        GameRegistry.registerTileEntity(TileWrappedWood6.class, "wrappedwood6.tile");

        //overheads
        GameRegistry.registerTileEntity(TileOverhead_pole_curve_3.class, "overhead_pole_curve_3.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_curve_3alt.class, "overhead_pole_curve_3alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_curve_5.class, "overhead_pole_curve_5.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_curve_5alt.class, "overhead_pole_curve_5alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_curve_10.class, "overhead_pole_curve_10.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_curve_10alt.class, "overhead_pole_curve_10alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_curve_16.class, "overhead_pole_curve_16.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_curve_16alt.class, "overhead_pole_curve_16alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_scurve_8.class, "overhead_pole_scurve_8.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_scurve_8alt.class, "overhead_pole_scurve_8alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_scurve_12.class, "overhead_pole_scurve_12.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_scurve_12alt.class, "overhead_pole_scurve_12alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_scurve_16.class, "overhead_pole_scurve_16.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_scurve_16alt.class, "overhead_pole_scurve_16alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_slope_6.class, "overhead_pole_slope_6.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_slope_6alt.class, "overhead_pole_slope_6alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_slope_12.class, "overhead_pole_slope_12.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_slope_12alt.class, "overhead_pole_slope_12alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_slope_18.class, "overhead_pole_slope_18.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_slope_18alt.class, "overhead_pole_slope_18alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_straight_6.class, "overhead_pole_straight_6.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_switch_6.class, "overhead_pole_switch_6.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_switch_6alt.class, "overhead_pole_switch_6alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_switch_parallel.class, "overhead_pole_switch_parallel.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_switch_parallelalt.class, "overhead_pole_switch_parallelalt.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole.class, "overhead_pole.tile");
        GameRegistry.registerTileEntity(TileOverhead_pole_end.class, "overhead_pole_end.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_end.class, "overhead_hanger_end.tile");

        GameRegistry.registerTileEntity(TileOverhead_hanger_curve_3.class, "overhead_hanger_curve_3.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_curve_5.class, "overhead_hanger_curve_5.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_curve_10.class, "overhead_hanger_curve_10.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_curve_16.class, "overhead_hanger_curve_16.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_scurve_8.class, "overhead_hanger_scurve_8.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_scurve_8alt.class, "overhead_hanger_scurve_8alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_scurve_12.class, "overhead_hanger_scurve_12.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_scurve_12alt.class, "overhead_hanger_scurve_12alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_scurve_16.class, "overhead_hanger_scurve_16.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_scurve_16alt.class, "overhead_hanger_scurve_16alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_slope_6.class, "overhead_hanger_slope_6.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_slope_12.class, "overhead_hanger_slope_12.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_slope_18.class, "overhead_hanger_slope_18.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_straight_6.class, "overhead_hanger_straight_6.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_switch_6.class, "overhead_hanger_switch_6.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_switch_6alt.class, "overhead_hanger_switch_6alt.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_switch_parallel.class, "overhead_hanger_switch_parallel.tile");
        GameRegistry.registerTileEntity(TileOverhead_hanger_switch_parallelalt.class, "overhead_hanger_switch_parallelalt.tile");

        GameRegistry.registerTileEntity(TileOverhead_npole_straight_1.class, "overhead_npole_straight_1.tile");
        GameRegistry.registerTileEntity(TileOverhead_npole_straight_3.class, "overhead_npole_straight_3.tile");
        GameRegistry.registerTileEntity(TileOverhead_npole_straight_6.class, "overhead_npole_straight_6.tile");
        GameRegistry.registerTileEntity(TileOverhead_npole_slope_6.class, "overhead_npole_slope_6.tile");
        GameRegistry.registerTileEntity(TileOverhead_npole_slope_12.class, "overhead_npole_slope_12.tile");
        GameRegistry.registerTileEntity(TileOverhead_npole_slope_18.class, "overhead_npole_slope_18.tile");
        GameRegistry.registerTileEntity(TileOverhead_npole_x.class, "overhead_npole_x.tile");

        GameRegistry.registerTileEntity(TileStallPart_T.class, "stallPart_T.tile");
        GameRegistry.registerTileEntity(TileStallPart_Straight.class, "stallPart_Straight.tile");
        GameRegistry.registerTileEntity(TileStallPart_Edge1.class, "stallPart_Edge1.tile");
        GameRegistry.registerTileEntity(TileStallPart_Edge2.class, "stallPart_Edge2.tile");
        GameRegistry.registerTileEntity(TileStallPart_TB.class, "stallPart_TB.tile");
        GameRegistry.registerTileEntity(TileStallPart_StraightB.class, "stallPart_StraightB.tile");
        GameRegistry.registerTileEntity(TileStallPart_Edge1B.class, "stallPart_Edge1B.tile");
        GameRegistry.registerTileEntity(TileStallPart_Edge2B.class, "stallPart_Edge2B.tile");

        GameRegistry.registerTileEntity(TileRpb_cy_s.class, "rpb_cy_s.tile");
        GameRegistry.registerTileEntity(TileRpb_cy_r.class, "rpb_cy_r.tile");

        GameRegistry.registerTileEntity(TileRpb_cy_s2.class, "rpb_cy_s2.tile");
        GameRegistry.registerTileEntity(TileRpb_cy_r2.class, "rpb_cy_r2.tile");



        for (BlockIDs block : BlockIDs.values()) {

            if (!block.hasItemBlock) {
                GameRegistry.registerBlock(block.block, block.blockName);
            } else {
                GameRegistry.registerBlock(block.block, block.itemBlockClass, block.blockName);
            }
        }

        if(e.getSide().isClient()) {
            RenderBlockHandler.initializeCustomModels();

        }

        //FoxBlocks.blockLogger.info("BlockRegister Post Init at com.bidahochi.BlockMod.core.handler.blockHandler");
    }

    //The code below is not active. Do not touch unless you know how to fix and your fix works! -hariesh
    public static void blockpropertyregister() {


        for (BlockProperties blockReg : BlockProperties.values()) {
            String nameOfBlock = blockReg.blockName;
            Block blockOfReg = blockReg.block;
            BlockProperties.valueOf(nameOfBlock).block = new BaseBlock(blockReg.material, blockReg.blockName, blockReg.hardness, blockReg.resistance, blockReg.harvestTool, blockReg.harvestLevel, blockReg.sound, blockReg.textureLocation);
        }

        for (BlockProperties blockReg : BlockProperties.values()){
            GameRegistry.registerBlock(blockReg.block, blockReg.blockName);
        }
    }

}
