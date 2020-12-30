package com.bidahochi.BlockMod.core.handler;

/********************
 *
 *  blockHander  by -hariesh
 *
 *  This file allows you to register your blocks to the mod without cluttering up Foxblocks.java
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



import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.metals.*;
import com.bidahochi.BlockMod.blocks.essentiallymemes.*;
import com.bidahochi.BlockMod.blocks.aggregates.*;
import com.bidahochi.BlockMod.blocks.stones.*;
import com.bidahochi.BlockMod.BlockIDs;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class blockHandler {
    public static CreativeTabs foxBlocksCreativeTab;

    public static void initBlockRegister(){

        BlockIDs.bauxiteOre.block = new BauxiteOre(Material.rock);
        BlockIDs.rawConcrete.block = new RawConcrete(Material.rock);
        BlockIDs.peagravel_snow.block = new SnowyPeaGravel(Material.sand);
        BlockIDs.peagravel.block = new PeaGravel(Material.sand);
        BlockIDs.although.block = new Although(Material.clay);
        BlockIDs.metalSiding_White.block = new MetalSiding_White(Material.iron);
        BlockIDs.metalSiding_LightGrey.block = new MetalSiding_LightGrey(Material.iron);
        BlockIDs.metalSiding_Grey.block = new MetalSiding_Grey(Material.iron);
        BlockIDs.metalSiding_Black.block = new MetalSiding_Black(Material.iron);
        //BlockIDs.BlockmetalSiding.block = new BlockmetalSiding();

        for (BlockIDs block : BlockIDs.values()) {
            if (block.hasItemBlock == false) {
                GameRegistry.registerBlock(block.block, block.blockName);
                block.block.setCreativeTab(FoxBlocks.foxBlocksCreativeTab);
            } else {
                GameRegistry.registerBlock(block.block, block.itemBlockClass, block.blockName);
                block.block.setCreativeTab(FoxBlocks.foxBlocksCreativeTab);

            }
        }

    }
}
