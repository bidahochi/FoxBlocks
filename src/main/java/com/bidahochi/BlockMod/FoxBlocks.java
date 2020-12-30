package com.bidahochi.BlockMod;

import com.bidahochi.BlockMod.blocks.metals.*;
import com.bidahochi.BlockMod.blocks.essentiallymemes.*;
import com.bidahochi.BlockMod.blocks.aggregates.*;
import com.bidahochi.BlockMod.blocks.stones.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import com.bidahochi.BlockMod.core.handler.recipeHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import com.bidahochi.BlockMod.BlockIDs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = FoxBlocks.MODID, version = FoxBlocks.VERSION, name = FoxBlocks.NAME)
public class FoxBlocks
{
    public static final String MODID = "foxblocks";
    public static final String NAME = "FoxBlocks";
    public static final String VERSION = "1.1";
    public static CreativeTabs foxBlocksCreativeTab;
    public static Logger blockLogger = LogManager.getLogger("FoxBlocks");

    @EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        //Initalize bloccs.
        blockLogger.info("FoxBlocks starting with it's big floofy tail");
        foxBlocksCreativeTab = new CreativeTabs("FoxBlocks") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(BlockIDs.bauxiteOre.block);
            }

            public String getTranslatedTabLabel() {
                return "FoxBlocks";
            }

        };

        //BlockProperties.registerBlocks();
        registerBlocks();
        recipeHandler.initBlockRecipes();
    }

    public void registerBlocks() {
        BlockIDs.bauxiteOre.block = new BauxiteOre(Material.rock).setHardness(1F).setStepSound(Block.soundTypeMetal);
        BlockIDs.rawConcrete.block = new RawConcrete(Material.rock);
        BlockIDs.peagravel_snow.block = new SnowyPeaGravel(Material.sand);
        BlockIDs.peagravel.block = new PeaGravel(Material.sand);
        BlockIDs.although.block = new Although(Material.clay).setLightLevel(3F).setStepSound(Block.soundTypeAnvil).setResistance(4F).setHardness(2F);
        BlockIDs.metalSiding_White.block = new MetalSiding_White(Material.iron);
        BlockIDs.metalSiding_LightGrey.block = new MetalSiding_LightGrey(Material.iron);
        BlockIDs.metalSiding_Grey.block = new MetalSiding_Grey(Material.iron);
        BlockIDs.metalSiding_Black.block = new MetalSiding_Black(Material.iron);
        //BlockIDs.BlockmetalSiding.block = new BlockmetalSiding();

        /*
        for (BlockIDs blocc : BlockIDs.values()) {
            blocc.block.setCreativeTab(foxBlocksCreativeTab);
            if (blocc.leItemBlock != null) {
                GameRegistry.registerBlock(blocc.block, blocc.leItemBlock.getClass(), blocc.bloccName);
            } else {
                GameRegistry.registerBlock(blocc.block, blocc.bloccName);
            }
        }

         */


        for (BlockIDs block : BlockIDs.values()) {
            if (block.hasItemBlock == false) {
                GameRegistry.registerBlock(block.block, block.blockName);
                block.block.setCreativeTab(foxBlocksCreativeTab);
            } else {
                GameRegistry.registerBlock(block.block, block.itemBlockClass, block.blockName);
                block.block.setCreativeTab(foxBlocksCreativeTab);

            }
        }

        /*
        GameRegistry.registerBlock(BlockIDs.bauxiteOre.block, BlockIDs.bauxiteOre.blockName);
        BlockIDs.bauxiteOre.block.setCreativeTab(foxBlocksCreativeTab);

         */
    }

    public void registerRecipe() {
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel.block, 1), Blocks.gravel);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel_snow.block, 1),  new ItemStack(BlockIDs.peagravel.block, 1), Items.snowball, new ItemStack(BlockIDs.peagravel.block, 1));
    }

}
