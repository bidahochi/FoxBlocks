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
import com.bidahochi.BlockMod.core.handler.BlockProperties;
import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.constructionmaterials.*;
import com.bidahochi.BlockMod.blocks.constructionmaterials.fiberGlass;
import com.bidahochi.BlockMod.blocks.hell.darkEmberStone;
import com.bidahochi.BlockMod.blocks.hell.emberStone;
import com.bidahochi.BlockMod.blocks.hell.emberStoneStair;
import com.bidahochi.BlockMod.blocks.metals.*;
import com.bidahochi.BlockMod.blocks.essentiallymemes.*;
import com.bidahochi.BlockMod.blocks.aggregates.*;
import com.bidahochi.BlockMod.blocks.stones.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class blockHandler {
    public static CreativeTabs foxBlocksCreativeTab;

    public static void initBlockRegister(){

        FoxBlocks.blockLogger.info("BlockRegister Pre Init at com.bidahochi.BlockMod.core.handler.blockHandler");


        //ores
        BlockIDs.bauxiteOre.block = new BauxiteOre(Material.rock);
        BlockIDs.cobaltOre.block = new cobaltOre(Material.rock);

        BlockIDs.rawConcrete.block = new RawConcrete(Material.rock);
        BlockIDs.peagravel_snow.block = new SnowyPeaGravel(Material.sand);
        BlockIDs.peagravel.block = new PeaGravel(Material.sand);
        BlockIDs.peagravel_shit.block = new PeaGravelDirty(Material.sand);
        BlockIDs.gravel_shit.block = new GravelDirty(Material.sand);

        BlockIDs.although.block = new Although(Material.clay);
        BlockIDs.testblock.block = new testBlock(Material.iron);
        BlockIDs.tHanos.block = new tHanos(Material.sponge);

        BlockIDs.dryWall.block = new dryWall(Material.clay);
        BlockIDs.wallPaper.block = new wallPaper(Material.cloth);
        BlockIDs.unfinishedDrywall.block = new unfinishedDrywall(Material.clay);
        //BlockIDs.brownTile.block = new BrownTile(Material.rock);
        BlockIDs.fiberGlass.block = new fiberGlass(Material.glass);
        BlockIDs.fireBrick.block = new fireBrick(Material.rock);
        BlockIDs.emberStone.block = new emberStone(Material.rock);
        BlockIDs.darkEmberStone.block = new darkEmberStone(Material.rock);
        //BlockIDs.testPane.block = new testPane(BlockIDs.testPane.blockName, Material.iron, true);
        //BlockIDs.testSlab.block = new testSlab(false, Material.iron);
        //BlockIDs.testStair.block = new testStair(BlockIDs.bauxiteOre.block, 0);
        BlockIDs.blockLavaBucket.block = new blockLavaBucket(Material.iron);

        BlockIDs.soapStone.block = new SoapStone(Material.rock);
        BlockIDs.soapStoneMagmatic.block = new soapStoneMagmatic(Material.rock);
        BlockIDs.soapStoneDeco.block = new soapStoneDeco(Material.rock);
        BlockIDs.soapStoneEmerald.block = new soapStoneEmerald(Material.rock);

        BlockIDs.metalSiding.block = new metalSiding(Material.iron);
        BlockIDs.metalSiding2.block = new metalSiding2(Material.iron);
        BlockIDs.pannelBlack.block = new pannelBlack(Material.iron);
        BlockIDs.pannelWhite.block = new pannelWhite(Material.iron);
        BlockIDs.pannelExtra.block = new pannelExtra(Material.iron);
        BlockIDs.rustBeam.block = new rustBeam(Material.iron);

        BlockIDs.harieshHead.block = new harieshHead(Material.dragonEgg);
        BlockIDs.layeredConcrete.block = new LayeredConcrete(Material.rock);
        BlockIDs.smoothCrete.block = new Smoothcrete(Material.rock);
        BlockIDs.gypsum.block = new Gypsum(Material.rock);

        BlockIDs.emberStoneStair.block = new baseStair(BlockIDs.emberStone.block, 0,"EmberStone Stair",2F,2F,Block.soundTypeStone,"pickaxe",2,0, FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.darkEmberStoneStair.block = new baseStair(BlockIDs.darkEmberStone.block, 0,"Dark EmberStone Stair",2F, 2F,Block.soundTypeStone, "pickaxe",2, 0, FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.soapStoneStair.block = new baseStair(BlockIDs.soapStone.block, 0, "Soapstone Stair", 7F, 15F, Block.soundTypeStone, "pickaxe", 1, 0, FoxBlocks.foxBlocksCreativeTabRock);

        BlockIDs.emberStoneSlab.block = new baseSlab(false, Material.rock,BlockIDs.emberStoneSlab.blockName, 2F,2F,Block.soundTypeStone,"pickaxe",2,0,"hell/emberStone", FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.darkEmberStoneSlab.block = new baseSlab(false, Material.rock,"Dark EmberStone Slab", 2F,2F,Block.soundTypeStone,"pickaxe",2,0,"hell/darkEmberStone", FoxBlocks.foxBlocksCreativeTabRock);
        BlockIDs.soapStoneSlab.block = new baseSlab(false, Material.rock, "Soapstone Slab", 7F, 15F, Block.soundTypeStone, "pickaxe", 1, 0, "stones/soapstone", FoxBlocks.foxBlocksCreativeTabRock);

        BlockIDs.tile4.block = new tile4(Material.rock);
        BlockIDs.tile2x2.block = new tile2x2(Material.rock);
        BlockIDs.tile2x2smooth.block = new tile2x2smooth(Material.rock);
        BlockIDs.diamondTile.block = new diamondTile(Material.rock);

        //cobalt deco blocks
        BlockIDs.cobaltBlock.block = new cobaltBlock(Material.rock);
        BlockIDs.cobaltPanel.block = new cobaltPanel(Material.rock);
        BlockIDs.cobaltPanel2.block = new cobaltPanel2(Material.rock);
        BlockIDs.cobaltBrick.block = new cobaltBrick(Material.rock);
        BlockIDs.largeCobaltBrick.block = new largeCobaltBrick(Material.rock);
        BlockIDs.blue.block = new baseBlock("Blue Block",1F,1F,"pickaxe",0,Material.glass, Block.soundTypeGlass, "colour/blue");
        BlockIDs.green.block = new baseBlock("Green Block",1F,1F,"pickaxe",0,Material.glass, Block.soundTypeGlass, "colour/green");

        BlockIDs.widePlank.block = new widePlank(Material.wood);
        BlockIDs.widePlank2.block = new widePlank2(Material.wood);

        for (BlockIDs block : BlockIDs.values()) {

            if (!block.hasItemBlock) {
                GameRegistry.registerBlock(block.block, block.blockName);
            } else {
                GameRegistry.registerBlock(block.block, block.itemBlockClass, block.blockName);

            }

        }

        FoxBlocks.blockLogger.info("BlockRegister Post Init at com.bidahochi.BlockMod.core.handler.blockHandler");

    }


    //The code below is not active. Do not touch unless you know how to fix and your fix works! -hariesh
    public static void blockpropertyregister() {


        for (BlockProperties blockReg : BlockProperties.values()) {
            String nameOfBlock = blockReg.blockName;
            Block blockOfReg = blockReg.block;
            BlockProperties.valueOf(nameOfBlock).block = new baseBlock(blockReg.blockName,blockReg.hardness,blockReg.resistance,blockReg.harvestTool,blockReg.harvestLevel,blockReg.material,blockReg.sound,blockReg.textureLocation);
        }

        for (BlockProperties blockReg : BlockProperties.values()){
            GameRegistry.registerBlock(blockReg.block, blockReg.blockName);
        }
    }
}
