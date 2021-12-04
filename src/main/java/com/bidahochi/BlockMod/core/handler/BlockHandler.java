package com.bidahochi.BlockMod.core.handler;

/********************
 *
 *  blockHander  by -hariesh
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
 *
 *  -hariesh
 *
 ********************/


import com.bidahochi.BlockMod.blocks.cobaltdeco.*;
import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.constructionmaterials.*;
import com.bidahochi.BlockMod.blocks.constructionmaterials.FiberGlass;
import com.bidahochi.BlockMod.blocks.hell.DarkEmberStone;
import com.bidahochi.BlockMod.blocks.hell.EmberStone;
import com.bidahochi.BlockMod.blocks.metals.*;
import com.bidahochi.BlockMod.blocks.essentiallymemes.*;
import com.bidahochi.BlockMod.blocks.aggregates.*;
import com.bidahochi.BlockMod.blocks.stones.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class BlockHandler {
    public static CreativeTabs foxBlocksCreativeTab;

    public static void initBlockRegister(FMLInitializationEvent e){

        FoxBlocks.blockLogger.info("BlockRegister Pre Init at com.bidahochi.BlockMod.core.handler.blockHandler");


        //ores
        BlockIDs.bauxiteOre.block = new BauxiteOre(Material.rock);
        BlockIDs.cobaltOre.block = new CobaltOre(Material.rock);
        BlockIDs.placeholderOre.block = new PlaceholderOre(Material.rock);

        BlockIDs.rawConcrete.block = new RawConcrete(Material.rock);
        BlockIDs.peagravel_snow.block = new SnowyPeaGravel(Material.sand);
        BlockIDs.peagravel.block = new PeaGravel(Material.sand);
        BlockIDs.peagravel_shit.block = new PeaGravelDirty(Material.sand);
        BlockIDs.gravel_shit.block = new GravelDirty(Material.sand);
        BlockIDs.specialDirt.block = new SpecialDirt(Material.ground);
        BlockIDs.peagravelBallast.block = new PeaGravelBallast(Material.sand);
        BlockIDs.peagravelWhitestone.block = new PeaGravelWhitestone(Material.sand);

        BlockIDs.although.block = new Although(Material.clay);
        BlockIDs.testblock.block = new TestBlock(Material.iron);
        BlockIDs.tHanos.block = new Thanos(Material.sponge);

        BlockIDs.dryWall.block = new DryWall(Material.clay);
        BlockIDs.wallPaper.block = new WallPaper(Material.cloth);
        BlockIDs.unfinishedDrywall.block = new UnfinishedDrywall(Material.clay);
        //BlockIDs.brownTile.block = new BrownTile(Material.rock);
        BlockIDs.fiberGlass.block = new FiberGlass(Material.glass);
        BlockIDs.fireBrick.block = new FireBrick(Material.rock);
        BlockIDs.emberStone.block = new EmberStone(Material.rock);
        BlockIDs.darkEmberStone.block = new DarkEmberStone(Material.rock);
        //BlockIDs.testPane.block = new testPane(BlockIDs.testPane.blockName, Material.iron, true);
        //BlockIDs.testSlab.block = new testSlab(false, Material.iron);
        //BlockIDs.testStair.block = new testStair(BlockIDs.bauxiteOre.block, 0);
        BlockIDs.blockLavaBucket.block = new BlockLavaBucket(Material.iron);

        BlockIDs.soapStone.block = new SoapStone(Material.rock);
        BlockIDs.soapStoneMagmatic.block = new soapStoneMagmatic(Material.rock);
        BlockIDs.soapStoneDeco.block = new SoapStoneDeco(Material.rock);
        BlockIDs.soapStoneEmerald.block = new soapStoneEmerald(Material.rock);

        BlockIDs.metalSiding.block = new MetalSiding(Material.iron);
        BlockIDs.metalSiding2.block = new MetalSiding2(Material.iron);
        BlockIDs.pannelBlack.block = new PannelBlack(Material.iron);
        BlockIDs.pannelWhite.block = new PannelWhite(Material.iron);
        BlockIDs.pannelExtra.block = new PannelExtra(Material.iron);
        BlockIDs.rustBeam.block = new RustBeam(Material.iron);

        BlockIDs.harieshHead.block = new HarieshHead(Material.dragonEgg);
        BlockIDs.layeredConcrete.block = new LayeredConcrete(Material.rock);
        BlockIDs.smoothCrete.block = new Smoothcrete(Material.rock);
        BlockIDs.gypsum.block = new Gypsum(Material.rock);

        BlockIDs.emberStoneStair.block = new BaseStair(BlockIDs.emberStone.block, 0,"EmberStone Stair",2F,2F,Block.soundTypeStone,"pickaxe",2,0, FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.darkEmberStoneStair.block = new BaseStair(BlockIDs.darkEmberStone.block, 0,"Dark EmberStone Stair",2F, 2F,Block.soundTypeStone, "pickaxe",2, 0, FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.soapStoneStair.block = new BaseStair(BlockIDs.soapStone.block, 0, "Soapstone Stair", 7F, 15F, Block.soundTypeStone, "pickaxe", 1, 0, FoxBlocks.foxBlocksCreativeTabRock);

        BlockIDs.emberStoneSlab.block = new BaseSlab(false, Material.rock,BlockIDs.emberStoneSlab.blockName, 2F,2F,Block.soundTypeStone,"pickaxe",2,0,"hell/emberStone", FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.darkEmberStoneSlab.block = new BaseSlab(false, Material.rock,"Dark EmberStone Slab", 2F,2F,Block.soundTypeStone,"pickaxe",2,0,"hell/darkEmberStone", FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.soapStoneSlab.block = new BaseSlab(false, Material.rock, "Soapstone Slab", 7F, 15F, Block.soundTypeStone, "pickaxe", 1, 0, "stones/soapstone", FoxBlocks.foxBlocksCreativeTabRock);

        BlockIDs.tile4.block = new Tile4(Material.rock);
        BlockIDs.tile2x2.block = new Tile2x2(Material.rock);
        BlockIDs.tile2x2smooth.block = new Tile2x2smooth(Material.rock);
        BlockIDs.diamondTile.block = new DiamondTile(Material.rock);
        BlockIDs.subTile.block = new SubTile(Material.rock);

        //cobalt deco blocks
        BlockIDs.cobaltBlock.block = new CobaltBlock(Material.rock);
        BlockIDs.cobaltPanel.block = new CobaltPanel(Material.rock);
        BlockIDs.cobaltPanel2.block = new CobaltPanel2(Material.rock);
        BlockIDs.cobaltBrick.block = new CobaltBrick(Material.rock);
        BlockIDs.largeCobaltBrick.block = new LargeCobaltBrick(Material.rock);
        BlockIDs.blue.block = new BaseBlock(Material.glass, "Blue Block", 1F, 1F, "pickaxe", 0, Block.soundTypeGlass, "colour/blue");
        BlockIDs.green.block = new BaseBlock(Material.glass, "Green Block", 1F, 1F, "pickaxe", 0, Block.soundTypeGlass, "colour/green");

        BlockIDs.widePlank.block = new WidePlank(Material.wood);
        BlockIDs.widePlank2.block = new WidePlank2(Material.wood);
        BlockIDs.widePlank3.block = new WidePlank3(Material.wood);
        BlockIDs.amtrak.block = new Amtrak(Material.wood);

        BlockIDs.concreteBrick.block = new ConcreteBrick(Material.rock);
        BlockIDs.concreteFlooring.block = new ConcreteFloor(Material.rock);
        BlockIDs.plasteredConcrete.block = new PlasteredConcrete(Material.rock);
        BlockIDs.labwallDark.block = new LabwallDark(Material.rock);
        BlockIDs.labwallLight.block = new LabwallLight(Material.rock);
        BlockIDs.breakerBox.block = new BreakerBox(Material.rock);
        BlockIDs.breakerBox2.block = new BreakerBox2(Material.rock);

        GameRegistry.registerTileEntity(TileBreakerBox.class, "breakerbox.tile");
        GameRegistry.registerTileEntity(TileBreakerBox2.class, "breakerbox2.tile");

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

        FoxBlocks.blockLogger.info("BlockRegister Post Init at com.bidahochi.BlockMod.core.handler.blockHandler");

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
