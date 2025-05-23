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
import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.constructionmaterials.*;
import com.bidahochi.BlockMod.blocks.StallParts.*;
import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.BlockContainer.*;
import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.TileEntity.*;
import com.bidahochi.BlockMod.blocks.lighting.*;
import com.bidahochi.BlockMod.blocks.lumber.*;
import com.bidahochi.BlockMod.blocks.metals.*;
import com.bidahochi.BlockMod.blocks.essentiallymemes.*;
import com.bidahochi.BlockMod.blocks.overhead.*;
import com.bidahochi.BlockMod.blocks.props.*;
import com.bidahochi.BlockMod.blocks.props.BlockContainer.SittingFloorTile;
import com.bidahochi.BlockMod.blocks.props.BlockContainer.SittingStairTile;
import com.bidahochi.BlockMod.blocks.props.TileEntity.TileSittingFloorTile;
import com.bidahochi.BlockMod.blocks.props.TileEntity.TileSittingStairTile;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.center.Scrolling.SRPBWhiteCenter;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.details.Scrolling.SRPBDetailsWhite1;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.center.Scrolling.SRPBYellowCenter2;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.center.SmartPaints.RPBWhiteCenter;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.center.SmartPaints.RPBYellowCenter;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.center.SmartPaints.RPBYellowCenter2;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.center.Scrolling.SRPBYellowCenter;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.offset.Scrolling.SRPBYellowOffset;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.offset.SmartPaints.RPBWhiteOffsetInsideDiagonal;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.offset.SmartPaints.RPBWhiteOffsetInsideStraight;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.offset.SmartPaints.RPBYellowOffsetInsideDiagonal;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.offset.SmartPaints.RPBYellowOffsetInsideStraight;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.offset.Scrolling.SRPBWhiteOffset;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRPB;
import com.bidahochi.BlockMod.blocks.stones.*;

import com.bidahochi.BlockMod.core.handler.baseBlocks.*;
import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.*;
import com.bidahochi.BlockMod.items.BaseItems.BaseItemBlock;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.HashMap;

import static com.bidahochi.BlockMod.FoxBlocks.*;
import static net.minecraft.block.Block.*;

public class BlockHandler {

    public static void initBlockRegister(FMLInitializationEvent e)
    {
        //FoxBlocks.blockLogger.info("BlockRegister Pre Init at com.bidahochi.BlockMod.core.handler.blockHandler");
        /**
         * This HashMap is used to temporary hold block data
         * that is only needed for block Registration
         * when generating Slabs, And Stairs.
         */
        HashMap<BlockIDs, BlockProperty> tempBlockCache = new HashMap<>();
        final String PICKAXE = "pickaxe";
        final String SHOVEL = "shovel";
        final String AXE = "AXE";

        //ores
        BlockIDs.bauxiteOre.block = new BauxiteOre(Material.rock);
        BlockIDs.cobaltOre.block = new CobaltOre(Material.rock);
        BlockIDs.aragoniteOre.block = new AragoniteOre(Material.rock);
        BlockIDs.gypsum.block = new Gypsum(Material.rock);
        BlockIDs.taconite.block = new Taconite(Material.rock);
        BlockIDs.hematite.block = new Hematite(Material.rock);

        //raw
        { // peagravel_snow
            BlockProperty property = new FallingBlockProperty(BlockIDs.peagravel_snow, Material.sand, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/peagravel_snow", foxBlocksCreativeTabRock, true);
            BlockIDs.peagravel_snow.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.peagravel_snow, property);
        }
        { // peagravel
            BlockProperty property = new FallingBlockProperty(BlockIDs.peagravel, Material.sand, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/peagravel_generic", foxBlocksCreativeTabRock, true);
            BlockIDs.peagravel.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.peagravel, property);
        }
        { // peagravel_shit
            BlockProperty property = new FallingBlockProperty(BlockIDs.peagravel_shit, Material.sand, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/peagravel_dirty", foxBlocksCreativeTabRock, true);
            BlockIDs.peagravel_shit.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.peagravel_shit, property);
        }
        { // peagravel_volcanic
            BlockProperty property = new FallingBlockProperty(BlockIDs.peagravel_volcanic, Material.sand, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/peagravel_volcanic", foxBlocksCreativeTabRock, true);
            BlockIDs.peagravel_volcanic.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.peagravel_volcanic, property);
        }
        { // peagravel_redrock
            BlockProperty property = new FallingBlockProperty(BlockIDs.peagravel_redrock, Material.rock, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/peagravel_red_rock", foxBlocksCreativeTabRock, true);
            BlockIDs.peagravel_redrock.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.peagravel_redrock, property);
        }
        { // gravel_volcanic
            BlockProperty property = new FallingBlockProperty(BlockIDs.gravel_volcanic, Material.rock, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/gravel_volcanic", foxBlocksCreativeTabRock, true);
            BlockIDs.gravel_volcanic.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.gravel_volcanic, property);
        }
        { // gravel_shit
            BlockProperty property = new FallingBlockProperty(BlockIDs.gravel_shit, Material.sand, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/gravel_dirty", foxBlocksCreativeTabRock, true);
            BlockIDs.gravel_shit.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.gravel_shit, property);

        }
        { // specialDirt
            BlockProperty property = new BlockProperty(BlockIDs.specialDirt, Material.ground, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/specialDirt", foxBlocksCreativeTab, true);
            BlockIDs.specialDirt.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.specialDirt, property);
        }
        { // deadGrass
            BlockProperty property = new BlockProperty(BlockIDs.deadGrass, Material.grass, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGrass, 1,"aggregates/grasses/dead_grass", foxBlocksCreativeTabRock, false);
            property.blockHasSideTextures = true;
            BlockIDs.deadGrass.block = new DeadGrass(property.TheMaterial);
        }
        { // deadGrass2
            BlockProperty property = new BlockProperty(BlockIDs.deadGrass2, Material.grass, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGrass, 1,"aggregates/grasses/dead_grass2", foxBlocksCreativeTabRock, false);
            property.blockHasSideTextures = true;
            BlockIDs.deadGrass2.block = new DeadGrass2(property.TheMaterial);
        }
        { // turf
            BlockProperty property = new BlockProperty(BlockIDs.turf, Material.grass, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGrass, 1,"aggregates/grasses/turf", foxBlocksCreativeTabRock, false);
            property.blockHasSideTextures = true;
            BlockIDs.turf.block = new Turf(property.TheMaterial);
        }

        { // peagravelBallast
            BlockProperty property = new FallingBlockProperty(BlockIDs.peagravelBallast, Material.sand, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/peagravel_tc_ballast", foxBlocksCreativeTabRock, true);
            BlockIDs.peagravelBallast.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.peagravelBallast, property);
        }
        { // peagravelWhitestone
            BlockProperty property = new FallingBlockProperty(BlockIDs.peagravelWhitestone, Material.sand, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/peagravel_whitestone", foxBlocksCreativeTabRock, true);
            BlockIDs.peagravelWhitestone.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.peagravelWhitestone, property);
        }

        { // fakeSnow
            BlockProperty property = new BlockProperty(BlockIDs.fakeSnow, Material.ground, 0.5F, 0.1F,
                    SHOVEL, 0,
                    soundTypeSnow, 1,"aggregates/fakesnows", foxBlocksCreativeTab, true);
            BlockIDs.fakeSnow.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.fakeSnow, property);
        }

        { // dirt_3
            BlockProperty property = new BlockProperty(BlockIDs.dirt_3, Material.sand, 0.5F, 0.1F,
                    SHOVEL, 1,
                    soundTypeGravel, 1,"aggregates/dirt_3", foxBlocksCreativeTab, true);
            BlockIDs.dirt_3.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.dirt_3, property);
        }
        { // dirt_4
            BlockProperty property = new BlockProperty(BlockIDs.dirt_4, Material.sand, 0.5F, 0.1F,
                    SHOVEL, 1,
                    soundTypeGravel, 1,"aggregates/dirt_4", foxBlocksCreativeTab, true);
            BlockIDs.dirt_4.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.dirt_4, property);
        }

        { // creamCityClay
            FallingBlockProperty property = new FallingBlockProperty(BlockIDs.creamCityClay, Material.clay, 0.6F, 0.6F,
                    SHOVEL, 0,
                    soundTypeGravel, 1,"aggregates/CreamCityClay", foxBlocksCreativeTabRock, true);
            BlockIDs.creamCityClay.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.creamCityClay, property);
        }

        //concretes
        { // Raw Concrete
            BlockProperty property = new BlockProperty(BlockIDs.Concrete, Material.rock, 2.0F, 12.5F,
                    PICKAXE, 1,
                    soundTypePiston, 1,"stones/raw_concrete", foxBlocksCreativeTabRock, true);
            BlockIDs.Concrete.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.Concrete, property);
        }

        { // LayeredConcrete
            PillarBlockProperty property = new PillarBlockProperty(BlockIDs.layeredConcrete, Material.rock, 2.0F, 12.5F,
                    PICKAXE, 1,
                    null, 1,"stones/layercrete/Layered_concrete", foxBlocksCreativeTabRock, false);
            property.blockHasSideTextures = true;
            BlockIDs.layeredConcrete.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.layeredConcrete, property);
        }

        { // smoothCrete
            BlockProperty property = new BlockProperty(BlockIDs.smoothCrete, Material.rock, 2F, 12.5F,
                    PICKAXE, 1,
                    soundTypeStone, 1, "stones/layercrete/Layered_concrete_Top_0", foxBlocksCreativeTabRock, true);
            BlockIDs.smoothCrete.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.smoothCrete, property);
        }

        { // ConcreteBrick
            BlockProperty property = new BlockProperty(BlockIDs.concreteBrick, Material.rock, 2F, 4.0F,
                    PICKAXE, 2,
                    soundTypeStone, 9, "constructionmaterials/concretebrick/concreteBrick", foxBlocksCreativeTabRock, false);
            BlockIDs.concreteBrick.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.concreteBrick, property);
        }

        { // ConcreteFloor
            BlockProperty property = new BlockProperty(BlockIDs.concreteFloor, Material.rock, 2F, 6.0F,
                    PICKAXE, 2,
                    soundTypeStone, 5,"constructionmaterials/concretefloor/concreteFloor", foxBlocksCreativeTabRock, false);
            BlockIDs.concreteFloor.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.concreteFloor, property);
        }

        { // plasteredConcrete
            BlockProperty property = new BlockProperty(BlockIDs.plasteredConcrete, Material.rock, 1.5F, 2.5F,
                    PICKAXE, 2,
                    soundTypeStone, 9,"constructionmaterials/plasteredconcrete/plasteredConcrete", foxBlocksCreativeTabRock, false);
            BlockIDs.plasteredConcrete.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.plasteredConcrete, property);
        }

        //stones
        { // soapstone
            BlockProperty property = new BlockProperty(BlockIDs.soapStone, Material.rock, 1.5F, 7.0F,
                    PICKAXE, 1,
                    soundTypeStone, 1,"stones/soapstone", foxBlocksCreativeTabRock, true);
            BlockIDs.soapStone.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.soapStone, property);
        }

        { // soapStoneMagmatic
            BlockIDs.soapStoneMagmatic.block = new soapStoneMagmatic(Material.rock);
        }

        { // soapStoneDeco
            BlockProperty property = new BlockProperty(BlockIDs.soapStoneDeco, Material.rock, 6.5F, 30.0F,
                    PICKAXE, 1,
                    soundTypeStone, 5,"constructionmaterials/soapstonedeco/soapstone_deco", foxBlocksCreativeTabRock, false);
            BlockIDs.soapStoneDeco.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.soapStoneDeco, property);
        }

        { // soapStoneEmerald
            BlockIDs.soapStoneEmerald.block = new soapStoneEmerald(Material.rock);
        }

        { // redrock
            BlockProperty property = new BlockProperty(BlockIDs.redrock, Material.rock, 1.9F, 12.0F,
                    PICKAXE, 1,
                    soundTypeStone, 1,"stones/redrock", foxBlocksCreativeTabRock, true);
            BlockIDs.redrock.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.redrock, property);
        }

        { // jolietLimestoneRaw
            BlockProperty property = new BlockProperty(BlockIDs.jolietLimestoneRaw, Material.rock, 2F, 10F,
                    PICKAXE, 1,
                    soundTypeStone, 1,"stones/RawJolietLimestone", foxBlocksCreativeTabRock, true);
            BlockIDs.jolietLimestoneRaw.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.jolietLimestoneRaw, property);
        }

        { // limestone
            BlockProperty property = new BlockProperty(BlockIDs.limestone, Material.rock, 2F, 5.0F,
                    PICKAXE, 0,
                    soundTypeStone, 1,"stones/limestone", foxBlocksCreativeTabRock, true);
            BlockIDs.limestone.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.limestone, property);
        }

        //bricks
        { // fireBrick
            BlockProperty property = new BlockProperty(BlockIDs.fireBrick, Material.rock, 2.2F, 6.5F,
                    PICKAXE, 1,
                    soundTypeStone, 1,"constructionmaterials/bricks/fireBrick", foxBlocksCreativeTabRock, true);
            BlockIDs.fireBrick.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.fireBrick, property);
        }

        { // mortarBrick
            BlockProperty property = new BlockProperty(BlockIDs.mortarBrick, Material.rock, 2F, 10.0F,
                    PICKAXE, 1,
                    soundTypeStone, 16,"constructionmaterials/mortarBrick/mortarBrick", foxBlocksCreativeTabRock, false);
            BlockIDs.mortarBrick.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.mortarBrick, property);
        }

        { // mortarBrick2
            BlockProperty property = new BlockProperty(BlockIDs.mortarBrick2, Material.rock, 2F, 10.0F,
                    PICKAXE, 1,
                    soundTypeStone, 8,"constructionmaterials/mortarBrick2/mortarBrick", foxBlocksCreativeTabRock, false);
            BlockIDs.mortarBrick2.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.mortarBrick2, property);
        }

        { // creamCity
            BlockProperty property = new BlockProperty(BlockIDs.creamCity, Material.rock, 2F, 12F,
                    PICKAXE, 1,
                    soundTypeStone, 3,"constructionmaterials/creamcity/creamcity", foxBlocksCreativeTabRock, false);
            BlockIDs.creamCity.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.creamCity, property);
        }

        { // jolietLimestone
            BlockProperty property = new BlockProperty(BlockIDs.jolietLimestone, Material.rock, 2F, 13F,
                    PICKAXE, 1,
                    soundTypeStone, 7,"constructionmaterials/joliet/jolietlimestone", foxBlocksCreativeTabRock, false);
            BlockIDs.jolietLimestone.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.jolietLimestone, property);
        }

        { // redrockDeco
            BlockProperty property = new BlockProperty(BlockIDs.redrockDeco, Material.rock, 1.9F, 12F,
                    PICKAXE, 1,
                    soundTypeStone, 4,"constructionmaterials/redrock/redrock", foxBlocksCreativeTabRock, false);
            BlockIDs.redrockDeco.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.redrockDeco, property);
        }

        { // cobaltBlock
            BlockProperty property = new BlockProperty(BlockIDs.cobaltBlock, Material.rock, 10F, 8.5F,
                    PICKAXE, 1,
                    soundTypeStone, 1,"constructionmaterials/cobalt_block", foxBlocksCreativeTabRock, true);
            BlockIDs.cobaltBlock.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.cobaltBlock, property);
        }

        { // cobaltPanel
            BlockProperty property = new BlockProperty(BlockIDs.cobaltPanel, Material.rock, 2.0F, 2.5F,
                    PICKAXE, 1,
                    soundTypeStone, 16,"constructionmaterials/cobaltdeco/cobalt_panel", foxBlocksCreativeTabRock, false);
            BlockIDs.cobaltPanel.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.cobaltPanel, property);
        }

        { // cobaltPanel
            BlockProperty property = new BlockProperty(BlockIDs.cobaltPanel2, Material.rock, 2.0F, 2.5F,
                    PICKAXE, 1,
                    soundTypeStone, 7,"constructionmaterials/cobaltdeco/cobalt_panel2", foxBlocksCreativeTabRock, false);
            BlockIDs.cobaltPanel2.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.cobaltPanel2, property);
        }

        { // cobaltBrick
            BlockProperty property = new BlockProperty(BlockIDs.cobaltBrick, Material.rock, 10F, 8.5F,
                    PICKAXE, 2,
                    soundTypeStone, 1,"constructionmaterials/cobaltdeco/cobalt_brick", foxBlocksCreativeTabRock, true);
            BlockIDs.cobaltBrick.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.cobaltBrick, property);
        }

        { // largeCobaltBrick
            BlockProperty property = new BlockProperty(BlockIDs.largeCobaltBrick, Material.rock, 10F, 8.5F,
                    PICKAXE, 2,
                    soundTypeStone, 1,"constructionmaterials/cobaltdeco/large_cobalt_brick", foxBlocksCreativeTabRock, true);
            BlockIDs.largeCobaltBrick.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.largeCobaltBrick, property);
        }

        //tiles

        { // tile4
            BlockProperty property = new BlockProperty(BlockIDs.tile4, Material.rock, 2.0F, 2.5F,
                    PICKAXE, 0,
                    soundTypeGlass, 16,"constructionmaterials/4by4tiles/tile", foxBlocksCreativeTabHome, false);
            BlockIDs.tile4.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.tile4, property);
        }

        { // tile2x2
            BlockProperty property = new BlockProperty(BlockIDs.tile2x2, Material.rock, 1.3F, 3.0F,
                    PICKAXE, 1,
                    soundTypeGlass, 16,"constructionmaterials/2by2tiles/tile8", foxBlocksCreativeTabHome, false);
            BlockIDs.tile2x2.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.tile2x2, property);
        }

        { // tile2x2smooth
            BlockProperty property = new BlockProperty(BlockIDs.tile2x2smooth, Material.rock, 1.3F, 3.0F,
                    PICKAXE, 1,
                    soundTypeGlass, 16,"constructionmaterials/2by2tileSmooth/tile2smooth", foxBlocksCreativeTabHome, false);
            BlockIDs.tile2x2smooth.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.tile2x2smooth, property);
        }

        { // diamondTile
            BlockProperty property = new BlockProperty(BlockIDs.diamondTile, Material.rock, 2.0F, 2.5F,
                    PICKAXE, 0,
                    soundTypeStone, 16,"constructionmaterials/diamondtile/diamond", foxBlocksCreativeTabHome, false);
            BlockIDs.diamondTile.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.diamondTile, property);
        }

        { // subTile
            BlockProperty property = new BlockProperty(BlockIDs.subTile, Material.rock, 2F, 3.2F,
                    PICKAXE, 1,
                    soundTypeStone, 5,"constructionmaterials/subtile/subtile", foxBlocksCreativeTabFactory, false);
            BlockIDs.subTile.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.subTile, property);
        }

        { // terrocottaTiles
            BlockProperty property = new BlockProperty(BlockIDs.terrocottaTiles, Material.rock, 1.0F, 2.0F,
                    PICKAXE, 1,
                    soundTypeStone, 16,"constructionmaterials/terrocotta/terrocottatiles", foxBlocksCreativeTabHome, false);
            BlockIDs.terrocottaTiles.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.terrocottaTiles, property);
        }

        //fun
        BlockIDs.although.block = new Although(Material.clay);
        BlockIDs.testblock.block = new TestBlock(Material.iron);
        BlockIDs.tHanos.block = new Thanos(Material.sponge);
        BlockIDs.booBlox.block = new BooBlox(Material.cloth);
        BlockIDs.blockLavaBucket.block = new BlockLavaBucket(Material.iron);
        BlockIDs.harieshHead.block = new HarieshHead(Material.gourd);
        BlockIDs.foxglass.block = new foxglass(Material.glass);

        { // blue
            BlockProperty property = new BlockProperty(BlockIDs.blue, Material.glass, 1F, 1F,
                    PICKAXE, 0,
                    soundTypeStone, 1,"colour/blue", foxBlocksCreativeTabRock, true);
            BlockIDs.blue.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.blue, property);
        }

        { // green
            BlockProperty property = new BlockProperty(BlockIDs.green, Material.glass, 1F, 1F,
                    PICKAXE, 0,
                    soundTypeStone, 1,"colour/green", foxBlocksCreativeTabRock, true);
            BlockIDs.green.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.green, property);
        }

        BlockIDs.fofblock.block = new Fofblock(Material.cake);
        BlockIDs.pingascube.block = new Pingascube(Material.glass);
        BlockIDs.invisiblock.block = new Invisiblock(Material.wood);

        //lumber
        { // WidePlank
            BlockProperty property = new BlockProperty(BlockIDs.widePlank, Material.wood, 2F, 5F,
                    AXE, 1,
                    soundTypeWood, 16,"lumber/wideplank/wideplank", foxBlocksCreativeTabHome, false);
            BlockIDs.widePlank.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.widePlank, property);
        }
        { // WidePlank2
            BlockProperty property = new BlockProperty(BlockIDs.widePlank2, Material.wood, 2F, 5F,
                    AXE, 1,
                    soundTypeWood, 16,"lumber/wideplank2/wideplank", foxBlocksCreativeTabHome, false);
            BlockIDs.widePlank2.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.widePlank2, property);
        }
        { // WidePlank3
            BlockProperty property = new BlockProperty(BlockIDs.widePlank3, Material.wood, 2F, 5F,
                    AXE, 1,
                    soundTypeWood, 16,"lumber/wideplank3/wideplank3", foxBlocksCreativeTabHome, false);
            BlockIDs.widePlank3.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.widePlank3, property);
        }
        { // WidePlank4
            BlockProperty property = new BlockProperty(BlockIDs.widePlank4, Material.wood, 2F, 5F,
                    AXE, 1,
                    soundTypeWood, 2,"lumber/wideplank4/wideplank4", foxBlocksCreativeTabHome, false);
            BlockIDs.widePlank4.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.widePlank4, property);
        }
        { // planks1 regular joe schmoe aah wood moment
            BlockProperty property = new BlockProperty(BlockIDs.planks1, Material.wood, 2F, 5F,
                    AXE, 1,
                    soundTypeWood, 3,"lumber/plank/planks", foxBlocksCreativeTabHome, false);
            BlockIDs.planks1.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.planks1, property);
        }

        { // amtrak
            BlockProperty property = new BlockProperty(BlockIDs.amtrak, Material.wood, 1.5F, 1.5F,
                    AXE, 0,
                    soundTypeWood, 3,"constructionmaterials/amshak/amtrak", foxBlocksCreativeTabHome, false);
            BlockIDs.amtrak.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.amtrak, property);
        }

        BlockIDs.logs.block = new Logs(Material.wood);
        BlockIDs.leaves.block = new Leaves(Material.leaves);

        { // plywood
            BlockProperty property = new BlockProperty(BlockIDs.plywood, Material.wood, 1F, 3F,
                    AXE, 0,
                    soundTypeWood, 11,"lumber/plywood/plywood", foxBlocksCreativeTabHome, false);
            BlockIDs.plywood.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.plywood, property);
        }
        BlockIDs.woodchips.block = new Woodchips(Material.wood);

        BlockIDs.wrappedwood1.block = new WrappedWood1(Material.wood);
        BlockIDs.wrappedwood2.block = new WrappedWood2(Material.wood);
        BlockIDs.wrappedwood3.block = new WrappedWood3(Material.wood);
        BlockIDs.wrappedwood4.block = new WrappedWood4(Material.wood);
        BlockIDs.wrappedwood5.block = new WrappedWood5(Material.wood);
        BlockIDs.wrappedwood6.block = new WrappedWood6(Material.wood);
        BlockIDs.wrappedwood7.block = new WrappedWood7(Material.wood);

        BlockIDs.unwrappedwood1.block = new UnWrappedWood1(Material.wood);
        BlockIDs.unwrappedwood2.block = new UnWrappedWood2(Material.wood);
        BlockIDs.unwrappedwood3.block = new UnWrappedWood3(Material.wood);
        BlockIDs.unwrappedwood4.block = new UnWrappedWood4(Material.wood);
        BlockIDs.unwrappedwood5.block = new UnWrappedWood5(Material.wood);
        BlockIDs.unwrappedwood6.block = new UnWrappedWood6(Material.wood);
        BlockIDs.unwrappedwood7.block = new UnWrappedWood7(Material.wood);
        BlockIDs.unwrappedwood8.block = new UnWrappedWood8(Material.wood);
        BlockIDs.unwrappedwood9.block = new UnWrappedWood9(Material.wood);
        BlockIDs.unwrappedwood10.block = new UnWrappedWood10(Material.wood);
        BlockIDs.unwrappedwood11.block = new UnWrappedWood11(Material.wood);
        BlockIDs.unwrappedwood12.block = new UnWrappedWood12(Material.wood);

        BlockIDs.PFencing.block = new PFencing();

        //other building materials
        { // dryWall
            BlockProperty property = new BlockProperty(BlockIDs.dryWall, Material.clay, 2.2F, 6.5F,
                    PICKAXE, 1,
                    soundTypeStone, 16,"constructionmaterials/drywall/drywall", foxBlocksCreativeTabHome, false);
            BlockIDs.dryWall.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.dryWall, property);
        }
        { // wallPaper
            BlockProperty property = new BlockProperty(BlockIDs.wallPaper, Material.cloth, 0.5F, 0.25F,
                    PICKAXE, 1,
                    soundTypeCloth, 16,"constructionmaterials/wallpapers/wallpaper", foxBlocksCreativeTabHome, false);
            BlockIDs.wallPaper.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.wallPaper, property);
        }

        { // unfinishedDrywall
            BlockProperty property = new BlockProperty(BlockIDs.unfinishedDrywall, Material.clay, 2.2F, 6.5F,
                    PICKAXE, 1,
                    soundTypeStone, 1,"constructionmaterials/specialdrywall/unfinishedDrywall", foxBlocksCreativeTabHome, true);
            BlockIDs.unfinishedDrywall.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.unfinishedDrywall, property);
        }

        { // fiberGlass
            BlockProperty property = new BlockProperty(BlockIDs.fiberGlass, Material.glass, 0f, 0f,
                    PICKAXE, 0,
                    soundTypeGlass, 3,"constructionmaterials/fiberglass/insulation", foxBlocksCreativeTabHome, false);
            BlockIDs.fiberGlass.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.fiberGlass, property);
        }

        { // originStuff
            BlockProperty property = new BlockProperty(BlockIDs.originStuff, Material.rock, 2F, 10.0F,
                    PICKAXE, 1,
                    soundTypeStone, 3,"constructionmaterials/origin", foxBlocksCreativeTabRock, false);
            BlockIDs.originStuff.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.originStuff, property);
        }

        BlockIDs.classicwool.block = new ClassicWool(Material.cloth);

        BlockIDs.glassAssorted.block = new GlassAssorted(Material.glass);
        BlockIDs.glassAssortedPane.block = new GlassAssortedPane();

        { // tarmac
            BlockProperty property = new BlockProperty(BlockIDs.tarmac, Material.rock, 2F, 4.0F,
                    PICKAXE, 1,
                    soundTypeStone, 14,"constructionmaterials/tarmac/tarmac", foxBlocksCreativeTabRoadRail, false);
            BlockIDs.tarmac.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.tarmac, property);
        }

        BlockIDs.roadcover_dynamic1x1.block = new RoadCoverDynamic1X1(Material.rock);
        BlockIDs.roadcover_dynamic1x2.block = new RoadCoverDynamic1X2(Material.rock);
        BlockIDs.roadcover_dynamic1x3.block = new RoadCoverDynamic1X3(Material.rock);

        BlockIDs.roadcover_tarmac0.block = new RoadCover0(Material.rock);
        BlockIDs.roadcover_tarmac1.block = new RoadCover1(Material.rock);
        BlockIDs.roadcover_tarmac2.block = new RoadCover2(Material.rock);
        BlockIDs.roadcover_tarmac3.block = new RoadCover3(Material.rock);
        BlockIDs.roadcover_tarmac4.block = new RoadCover4(Material.rock);
        BlockIDs.roadcover_tarmac5.block = new RoadCover5(Material.rock);
        BlockIDs.roadcover_tarmac6.block = new RoadCover6(Material.rock);

        //metals
        { // MetalSiding
            BlockProperty property = new BlockProperty(BlockIDs.metalSiding, Material.iron, 1.5F, 25.0F,
                    PICKAXE, 2,
                    soundTypeMetal, 16,"metals/metalsiding/metalsiding", foxBlocksCreativeTabFactory, false);
            BlockIDs.metalSiding.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.metalSiding, property);
        }
        { // MetalSiding2
            BlockProperty property = new BlockProperty(BlockIDs.metalSiding2, Material.iron, 1.5F, 25.0F,
                    PICKAXE, 2,
                    soundTypeMetal, 16,"metals/metalsiding2/metalsiding", foxBlocksCreativeTabFactory, false);
            BlockIDs.metalSiding2.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.metalSiding2, property);
        }

        { // pannelBlack
            BlockProperty property = new BlockProperty(BlockIDs.pannelBlack, Material.iron, 2F, 15.0F,
                    PICKAXE, 2,
                    soundTypeMetal, 16,"metals/pannels/pannel_black", foxBlocksCreativeTabFactory, false);
            BlockIDs.pannelBlack.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.pannelBlack, property);
        }
        { // pannelWhite
            BlockProperty property = new BlockProperty(BlockIDs.pannelWhite, Material.iron, 2F, 15.0F,
                    PICKAXE, 2,
                    soundTypeMetal, 16,"metals/pannels/pannel_white", foxBlocksCreativeTabFactory, false);
            BlockIDs.pannelWhite.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.pannelWhite, property);
        }
        { // pannelExtra
            BlockProperty property = new BlockProperty(BlockIDs.pannelExtra, Material.iron, 2F, 15.0F,
                    PICKAXE, 2,
                    soundTypeMetal, 5,"metals/pannels/pannel_extra", foxBlocksCreativeTabFactory, false);
            BlockIDs.pannelExtra.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.pannelExtra, property);
        }

        { // rustBeam
            BlockProperty property = new BlockProperty(BlockIDs.rustBeam, Material.iron, 2F, 15.0F,
                    PICKAXE, 2,
                    soundTypeMetal, 6,"metals/rustbeams/rustbeam", foxBlocksCreativeTabFactory, false);
            BlockIDs.rustBeam.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.rustBeam, property);
        }

        { // labwallDark
            BlockProperty property = new BlockProperty(BlockIDs.labwallDark, Material.rock, 2F, 3.0F,
                    PICKAXE, 1,
                    soundTypeStone, 4,"constructionmaterials/labwall/labwall", foxBlocksCreativeTabFactory, false);
            BlockIDs.labwallDark.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.labwallDark, property);
        }

        { // labwallLight
            BlockProperty property = new BlockProperty(BlockIDs.labwallLight, Material.rock, 2F, 3.0F,
                    PICKAXE, 1,
                    soundTypeStone, 4,"constructionmaterials/labwall/labwall_light", foxBlocksCreativeTabFactory, false);
            BlockIDs.labwallLight.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.labwallLight, property);
        }

        { // tf_dev
            BlockProperty property = new BlockProperty(BlockIDs.tf_dev, Material.iron, 6F, 20.0F,
                    PICKAXE, 1,
                    soundTypeMetal, 10,"constructionmaterials/teamfortress/dev_measure", foxBlocksCreativeTabFactory, false);
            BlockIDs.tf_dev.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.tf_dev, property);
        }
        { // tf_brick
            BlockProperty property = new BlockProperty(BlockIDs.tf_brick, Material.rock, 3F, 8F,
                    PICKAXE, 1,
                    soundTypeStone, 12,"constructionmaterials/teamfortress/tf_brick", foxBlocksCreativeTabFactory, false);
            BlockIDs.tf_brick.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.tf_brick, property);
        }
        { // tf_wood
            BlockProperty property = new BlockProperty(BlockIDs.tf_wood, Material.wood, 3F, 8F,
                    PICKAXE, 1,
                    soundTypeWood, 11,"constructionmaterials/teamfortress/tf_wood", foxBlocksCreativeTabFactory, false);
            BlockIDs.tf_wood.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.tf_wood, property);
        }
        { // tf_floor
            BlockProperty property = new BlockProperty(BlockIDs.tf_floor, Material.iron, 3F, 8F,
                    PICKAXE, 1,
                    soundTypeMetal, 11,"constructionmaterials/teamfortress/tf_floor", foxBlocksCreativeTabFactory, false);
            BlockIDs.tf_floor.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.tf_floor, property);
        }

        BlockIDs.wornVent.block = new WornVent1(Material.iron);
        BlockIDs.wornVent2.block = new WornVent2(Material.iron);
        BlockIDs.scaffold.block = new Scaffold(Material.iron);
        BlockIDs.scaffold2.block = new Scaffold2(Material.iron);
        BlockIDs.classicMetals.block = new ClassicMetals(Material.iron);
        BlockIDs.classicGold.block = new ClassicGold(Material.iron);
        BlockIDs.metalFencing.block = new MetalFencing();

        { // emberStone
            BlockProperty property = new BlockProperty(BlockIDs.emberStone, Material.rock, 3.0F, 30.0F,
                    PICKAXE, 3,
                    soundTypeStone, 1,"hell/emberStone", foxBlocksCreativeTabRock, true);
            BlockIDs.emberStone.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.emberStone, property);
        }
        { // darkEmberStone
            BlockProperty property = new BlockProperty(BlockIDs.darkEmberStone, Material.rock, 3.0F, 30.0F,
                    PICKAXE, 3,
                    soundTypeStone, 1,"hell/darkEmberStone", foxBlocksCreativeTabRock, true);
            BlockIDs.darkEmberStone.block = property.getNewBlock();
            tempBlockCache.put(BlockIDs.darkEmberStone, property);
        }

        //additional
        //BlockIDs.emberStoneStair.block = new BaseStair(BlockIDs.emberStone.block, 0,"EmberStone Stair",2F,2F, soundTypeStone,"pickaxe",2,0, foxBlocksCreativeTabRock);
        //BlockIDs.darkEmberStoneStair.block = new BaseStair(BlockIDs.darkEmberStone.block, 0,"Dark EmberStone Stair",2F, 2F, soundTypeStone, "pickaxe",2, 0, foxBlocksCreativeTabRock);
        //BlockIDs.soapStoneStair.block = new BaseStair(BlockIDs.soapStone.block, 0, "Soapstone Stair", 7F, 15F, soundTypeStone, "pickaxe", 1, 0, foxBlocksCreativeTabRock);
        //BlockIDs.emberStoneSlab.block = new BaseSlab(false, Material.rock,BlockIDs.emberStoneSlab.blockName, 2F,2F, soundTypeStone,"pickaxe",2,0,"hell/emberStone", foxBlocksCreativeTabRock);
        //BlockIDs.darkEmberStoneSlab.block = new BaseSlab(false, Material.rock,"Dark EmberStone Slab", 2F,2F, soundTypeStone,"pickaxe",2,0,"hell/darkEmberStone", foxBlocksCreativeTabRock);
        //BlockIDs.soapStoneSlab.block = new BaseSlab(false, Material.rock, "Soapstone Slab", 7F, 15F, soundTypeStone, "pickaxe", 1, 0, "stones/soapstone", foxBlocksCreativeTabRock);

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

        BlockIDs.coil_centered.block = new Coil_centered(Material.iron);
        BlockIDs.coil_pair.block = new Coil_pair(Material.iron);

        BlockIDs.toilet.block = new Toilet(Material.clay);
        BlockIDs.sittingFloorTile.block = new SittingFloorTile(Material.clay);
        BlockIDs.sittingStairTile.block = new SittingStairTile(Material.clay);
        BlockIDs.wall_sink.block = new Wall_sink(Material.clay);

        //lighting
        BlockIDs.neonCageLightRoof.block = new NeonCageLampRoof(Material.iron);
        BlockIDs.neonCageLightWallV.block = new NeonCageLampWallV(Material.iron);
        BlockIDs.neonCageLightWallH.block = new NeonCageLampWallH(Material.iron);
        BlockIDs.ExteriorLightSquare.block = new ExteriorLightSquare(Material.iron);
        BlockIDs.ExteriorLightSquare2.block = new ExteriorLightSquare2(Material.iron);
        BlockIDs.lamp2warm.block = new Lamp2warm(Material.iron);
        BlockIDs.lamp2cold.block = new Lamp2cold(Material.iron);

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
        BlockIDs.doorA.block = new baseDoor(Material.wood).setBlockName("doorA").setHardness(3F).setStepSound(Block.soundTypeWood).setBlockTextureName(FoxBlocks.MODID+":door_a").setCreativeTab(foxBlocksCreativeTabHome);
        BlockIDs.doorB.block = new baseDoor(Material.wood).setBlockName("doorB").setHardness(3F).setStepSound(Block.soundTypeWood).setBlockTextureName(FoxBlocks.MODID+":door_b").setCreativeTab(foxBlocksCreativeTabHome);
        BlockIDs.doorC.block = new baseDoor(Material.wood).setBlockName("doorC").setHardness(3F).setStepSound(Block.soundTypeMetal).setBlockTextureName(FoxBlocks.MODID+":door_c").setCreativeTab(foxBlocksCreativeTabHome);
        BlockIDs.doorD.block = new baseDoor(Material.wood).setBlockName("doorD").setHardness(3F).setStepSound(Block.soundTypeMetal).setBlockTextureName(FoxBlocks.MODID+":door_d").setCreativeTab(foxBlocksCreativeTabHome);
        BlockIDs.doorE.block = new baseDoor(Material.wood).setBlockName("doorD").setHardness(3F).setStepSound(Block.soundTypeMetal).setBlockTextureName(FoxBlocks.MODID+":door_e").setCreativeTab(foxBlocksCreativeTabHome);

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
        //dynamic blocks
        BlockIDs.rpb_cy.block = new RPBYellowCenter(Material.rock);//centered yellow single
        BlockIDs.rpb_cy2.block = new RPBYellowCenter2(Material.rock);//centered yellow double
        BlockIDs.rpb_cw.block = new RPBWhiteCenter(Material.rock);//centered white single
        BlockIDs.rpb_oyd.block = new RPBYellowOffsetInsideDiagonal(Material.rock);
        BlockIDs.rpb_oys.block = new RPBYellowOffsetInsideStraight(Material.rock);
        BlockIDs.rpb_owd.block = new RPBWhiteOffsetInsideDiagonal(Material.rock);
        BlockIDs.rpb_ows.block = new RPBWhiteOffsetInsideStraight(Material.rock);
        //static blocks
        BlockIDs.srpb_whiteOffset.block = new SRPBWhiteOffset();
        BlockIDs.srpb_yellowOffset.block = new SRPBYellowOffset();
        BlockIDs.srpb_cy.block = new SRPBYellowCenter(Material.rock);//centered yellow single
        BlockIDs.srpb_cy2.block = new SRPBYellowCenter2(Material.rock);//centered yellow double
        BlockIDs.srpb_cw.block = new SRPBWhiteCenter(Material.rock);//centered white single
        BlockIDs.srpb_dw1.block = new SRPBDetailsWhite1(Material.rock);//details white 1

        //xmas
        BlockIDs.xmasLights1_top_white.block = new XmasLights1_top_white(Material.circuits);
        BlockIDs.xmasLights1_bottom_white.block = new XmasLights1_bottom_white(Material.circuits);
        BlockIDs.xmasLights1_top_rainbow.block = new XmasLights1_top_rainbow(Material.circuits);
        BlockIDs.xmasLights1_bottom_rainbow.block = new XmasLights1_bottom_rainbow(Material.circuits);

        BlockIDs.propTrailerDryvan1.block = new PropTrailerDryvan1(Material.wood);



        GameRegistry.registerTileEntity(TileBreakerBox.class, "breakerbox.tile");
        GameRegistry.registerTileEntity(TileBreakerBox2.class, "breakerbox2.tile");
        GameRegistry.registerTileEntity(TileClampOnSignDerail.class, "clampOnSignDerail.tile");
        GameRegistry.registerTileEntity(TileClampOnSignStop1.class, "clampOnSignStop1.tile");
        GameRegistry.registerTileEntity(TileClampOnSignStop2.class, "clampOnSignStop2.tile");
        GameRegistry.registerTileEntity(TileWaysideWarningSignGreen.class, "waysideWarningSignGreen.tile");
        GameRegistry.registerTileEntity(TileWaysideWarningSignRed.class, "waysideWarningSignRed.tile");
        GameRegistry.registerTileEntity(TileWaysideWarningSignYellow.class, "waysideWarningSignYellow.tile");
        GameRegistry.registerTileEntity(TileWaysideWarningSignYellowRed.class, "waysideWarningSignYellowRed.tile");

        GameRegistry.registerTileEntity(TileCoil_centered.class, "coil_centered.tile");
        GameRegistry.registerTileEntity(TileCoil_pair.class, "coil_pair.tile");

        GameRegistry.registerTileEntity(TileSittingStairTile.class, "sittingstairtile.tile");
        GameRegistry.registerTileEntity(TileSittingFloorTile.class, "sittingfloorile.tile");
        GameRegistry.registerTileEntity(TileToilet.class, "toilet.tile");
        GameRegistry.registerTileEntity(TileWall_sink.class, "wall_sink.tile");

        GameRegistry.registerTileEntity(TileNeonCageLampRoof.class, "neonCageLightRoof.tile");
        GameRegistry.registerTileEntity(TileNeonCageLampWallV.class, "neonCageLightWallV.tile");
        GameRegistry.registerTileEntity(TileNeonCageLampWallH.class, "neonCageLightWallH.tile");
        GameRegistry.registerTileEntity(TileExteriorLightSquare.class, "ExteriorLightSquare.tile");
        GameRegistry.registerTileEntity(TileExteriorLightSquare2.class, "ExteriorLightSquare2.tile");
        GameRegistry.registerTileEntity(TileLamp2warm.class, "lamp2warm.tile");
        GameRegistry.registerTileEntity(TileLamp2cold.class, "lamp2cold.tile");

        GameRegistry.registerTileEntity(TileBridgeA_Center.class, "bridgeA_Center.tile");
        GameRegistry.registerTileEntity(TileBridgeA_X_Side_Center_Top.class, "bridgeA_X_Side_Center_Top.tile");
        GameRegistry.registerTileEntity(TileBridgeA_X_Side_Center_Bottom.class, "bridgeA_X_Side_Center_Bottom.tile");
        GameRegistry.registerTileEntity(TileBridgeA_X_Side_Center_Top2.class, "bridgeA_X_Side_Center_Top2.tile");
        GameRegistry.registerTileEntity(TileBridgeA_X_Side_Center_Bottom2.class, "bridgeA_X_Side_Center_Bottom2.tile");
        GameRegistry.registerTileEntity(TileBridgeA_Side_Top.class, "bridgeA_Side_Top.tile");
        GameRegistry.registerTileEntity(TileBridgeA_Side_Bottom.class, "bridgeA_Side_Bottom.tile");

        GameRegistry.registerTileEntity(TileRoadCoverDynamic1X1.class, "roadcoverdyanmic1X1.tile");
        GameRegistry.registerTileEntity(TileRoadCoverDynamic1X2.class, "roadcoverdyanmic1X2.tile");
        GameRegistry.registerTileEntity(TileRoadCoverDynamic1X3.class, "roadcoverdyanmic1X3.tile");
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
        GameRegistry.registerTileEntity(TileWrappedWood7.class, "wrappedwood7.tile");

        GameRegistry.registerTileEntity(TileUnWrappedWood1.class, "unwrappedwood1.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood2.class, "unwrappedwood2.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood3.class, "unwrappedwood3.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood4.class, "unwrappedwood4.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood5.class, "unwrappedwood5.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood6.class, "unwrappedwood6.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood7.class, "unwrappedwood7.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood8.class, "unwrappedwood8.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood9.class, "unwrappedwood9.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood10.class, "unwrappedwood10.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood11.class, "unwrappedwood11.tile");
        GameRegistry.registerTileEntity(TileUnWrappedWood12.class, "unwrappedwood12.tile");

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

        //stalls
        GameRegistry.registerTileEntity(TileStallPart_T.class, "stallPart_T.tile");
        GameRegistry.registerTileEntity(TileStallPart_Straight.class, "stallPart_Straight.tile");
        GameRegistry.registerTileEntity(TileStallPart_Edge1.class, "stallPart_Edge1.tile");
        GameRegistry.registerTileEntity(TileStallPart_Edge2.class, "stallPart_Edge2.tile");
        GameRegistry.registerTileEntity(TileStallPart_TB.class, "stallPart_TB.tile");
        GameRegistry.registerTileEntity(TileStallPart_StraightB.class, "stallPart_StraightB.tile");
        GameRegistry.registerTileEntity(TileStallPart_Edge1B.class, "stallPart_Edge1B.tile");
        GameRegistry.registerTileEntity(TileStallPart_Edge2B.class, "stallPart_Edge2B.tile");

        GameRegistry.registerTileEntity(TileRPB.class, "rpb.tile");

        GameRegistry.registerTileEntity(TileXmasLights1_top_white.class, "XmasLights1_top_white");
        GameRegistry.registerTileEntity(TileXmasLights1_bottom_white.class, "XmasLights1_bottom_white");
        GameRegistry.registerTileEntity(TileXmasLights1_top_rainbow.class, "XmasLights1_top_rainbow");
        GameRegistry.registerTileEntity(TileXmasLights1_bottom_rainbow.class, "XmasLights1_bottom_rainbow");

        GameRegistry.registerTileEntity(TilePropTrailerDryvan1.class, "PropTrailerDryvan1");


        for (BlockIDs block : BlockIDs.values())
        {
            if (!block.hasItemBlock)
            {
                System.out.println(block.blockName);
                GameRegistry.registerBlock(block.block, block.blockName);
            }
            else
            {
                System.out.println(block.blockName);
                GameRegistry.registerBlock(block.block, block.itemBlockClass, block.blockName);
            }

            if (block.MaxMetadata > -1
                    && block.hasItemBlock
                    && (BaseItemBlock.class.equals(block.itemBlockClass) || block.itemBlockClass.getClass().isInstance(BaseItemBlock.class.getClass()))
                    && (block.block instanceof BaseBlock || block.block instanceof BasePillarBlock || block.block instanceof BaseFallingBlock))
            {
                BlockProperty blockProperty = tempBlockCache.get(block);
                if (blockProperty != null)
                {
                    GameRegistry.registerBlock(blockProperty.getNewDoubleSlab(), com.bidahochi.BlockMod.items.BaseItems.BaseItemSlab.class, blockProperty.BlockName + "_DoubleSlab");
                    GameRegistry.registerBlock(blockProperty.getNewSingleSlab(), com.bidahochi.BlockMod.items.BaseItems.BaseItemSlab.class, blockProperty.BlockName + "_Slab");

                    if (blockProperty.TotalTextureCount > 8)
                    {
                        GameRegistry.registerBlock(blockProperty.getSecondNewDoubleSlab(), com.bidahochi.BlockMod.items.BaseItems.BaseItemSlab.class, blockProperty.BlockName + "_2_DoubleSlab");
                        GameRegistry.registerBlock(blockProperty.getSecondNewSingleSlab(), com.bidahochi.BlockMod.items.BaseItems.BaseItemSlab.class, blockProperty.BlockName + "_2_Slab");
                    }

                    for(int i = 0; i < blockProperty.TotalTextureCount; i++)
                    {
                        if (block.block instanceof BaseFallingBlock)
                        {
                            GameRegistry.registerBlock(new BaseFallingBlockStair(block.block, i, blockProperty), com.bidahochi.BlockMod.items.BaseItems.BaseItemStairBlock.class, blockProperty.BlockName + "_" + i + "_Stair");
                        }
                        else
                        {
                            GameRegistry.registerBlock(new BaseBlockStair(block.block, i, blockProperty), com.bidahochi.BlockMod.items.BaseItems.BaseItemStairBlock.class, blockProperty.BlockName + "_" + i + "_Stair");
                            GameRegistry.registerBlock(new BaseBlockWall(block.block, i, blockProperty), com.bidahochi.BlockMod.items.BaseItems.BaseItemWallBlock.class, blockProperty.BlockName + "_" + i + "_Wall");
                        }
                    }
                }
            }
        }

        if(e.getSide().isClient())
        {
            RenderBlockHandler.initializeCustomModels();
        }

        //FoxBlocks.blockLogger.info("BlockRegister Post Init at com.bidahochi.BlockMod.core.handler.blockHandler");
    }

    //The code below is not active. Do not touch unless you know how to fix and your fix works! -hariesh
   // public static void blockpropertyregister() {
//
//
   //     for (BlockProperties blockReg : BlockProperties.values()) {
   //         String nameOfBlock = blockReg.blockName;
   //         Block blockOfReg = blockReg.block;
   //         BlockProperties.valueOf(nameOfBlock).block = new LegacyBaseBlock(blockReg.material, blockReg.blockName, blockReg.hardness, blockReg.resistance, blockReg.harvestTool, blockReg.harvestLevel, blockReg.sound, blockReg.textureLocation);
   //     }
//
   //     for (BlockProperties blockReg : BlockProperties.values()){
   //         GameRegistry.registerBlock(blockReg.block, blockReg.blockName);
   //     }
   // }

}
