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



import com.bidahochi.BlockMod.EnumBlocks;
import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.constructionmaterials.*;
import com.bidahochi.BlockMod.blocks.constructionmaterials.fiberGlass;
import com.bidahochi.BlockMod.blocks.hell.darkEmberStone;
import com.bidahochi.BlockMod.blocks.hell.emberStone;
import com.bidahochi.BlockMod.blocks.metals.*;
import com.bidahochi.BlockMod.blocks.essentiallymemes.*;
import com.bidahochi.BlockMod.blocks.aggregates.*;
import com.bidahochi.BlockMod.blocks.stones.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class blockHandler {
    public static CreativeTabs foxBlocksCreativeTab;

    public static void initBlockRegister(){

        FoxBlocks.blockLogger.info("BlockRegister Pre Init at com.bidahochi.BlockMod.core.handler.blockHandler");

        BlockIDs.bauxiteOre.block = new BauxiteOre(Material.rock);
        BlockIDs.rawConcrete.block = new RawConcrete(Material.rock);
        BlockIDs.peagravel_snow.block = new SnowyPeaGravel(Material.sand);
        BlockIDs.peagravel.block = new PeaGravel(Material.sand);
        BlockIDs.although.block = new Although(Material.clay);
        BlockIDs.testblock.block = new testBlock(Material.iron);
        BlockIDs.dryWall.block = new dryWall(Material.clay);
        BlockIDs.wallPaper.block = new wallPaper(Material.cloth);
        BlockIDs.unfinishedDrywall.block = new unfinishedDrywall(Material.clay);
        BlockIDs.brownTile.block = new BrownTile(Material.rock);
        BlockIDs.fiberGlass.block = new fiberGlass(Material.glass);
        BlockIDs.fireBrick.block = new fireBrick(Material.rock);
        BlockIDs.emberStone.block = new emberStone(Material.rock);
        BlockIDs.darkEmberStone.block = new darkEmberStone(Material.rock);
        BlockIDs.testPane.block = new testPane(BlockIDs.testPane.blockName, Material.iron, true);
        BlockIDs.testSlab.block = new testSlab(false, Material.iron);
        BlockIDs.testStair.block = new testStair(BlockIDs.emberStone.block, 0);
        BlockIDs.soapStone.block = new SoapStone(Material.rock);
        BlockIDs.soapStoneMagmatic.block = new soapStoneMagmatic(Material.rock);
        BlockIDs.soapStoneDeco.block = new soapStoneDeco(Material.rock);
        BlockIDs.soapStoneEmerald.block = new soapStoneEmerald(Material.rock);


        for (BlockIDs block : BlockIDs.values()) {
            if (block.hasItemBlock == false) {
                GameRegistry.registerBlock(block.block, block.blockName);
                block.block.setCreativeTab(FoxBlocks.foxBlocksCreativeTab);
            } else {
                GameRegistry.registerBlock(block.block, block.itemBlockClass, block.blockName);
                block.block.setCreativeTab(FoxBlocks.foxBlocksCreativeTab);

            }
        }

        FoxBlocks.blockLogger.info("BlockRegister Post Init at com.bidahochi.BlockMod.core.handler.blockHandler");

    }
}
