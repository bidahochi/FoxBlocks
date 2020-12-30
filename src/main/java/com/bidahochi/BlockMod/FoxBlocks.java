package com.bidahochi.BlockMod;

import com.bidahochi.BlockMod.EnumBlocks.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
    public void preInit()
    {
        //Initalize bloccs.
        blockLogger.info("FoxBlocks starting with it's big floofy tail");
        foxBlocksCreativeTab = new CreativeTabs("FoxBlocks") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(EnumBlocks.bauxiteOre.leBlock);
            }

            public String getTranslatedTabLabel() {
                return "FoxBlocks";
            }

        };

        //BlockProperties.registerBlocks();
        registerBlocks();
        registerRecipe();
    }


    public void registerBlocks() {
        EnumBlocks.bauxiteOre.leBlock = new BauxiteOre(Material.rock).setHardness(1F).setStepSound(Block.soundTypeMetal);
        EnumBlocks.bauxiteOre.bloccName = "Bauxite Ore";
        EnumBlocks.rawConcrete.leBlock = new RawConcrete(Material.rock);
        EnumBlocks.rawConcrete.bloccName = "Raw Concrete";
        EnumBlocks.peagravel_snow.leBlock = new SnowyPeaGravel(Material.sand);
        EnumBlocks.peagravel_snow.bloccName = "Snowy Pea Gravel";
        EnumBlocks.peagravel.leBlock = new PeaGravel(Material.sand);
        EnumBlocks.peagravel.bloccName = "Pea Gravel";
        EnumBlocks.although.leBlock = new Although(Material.clay).setLightLevel(3F).setStepSound(Block.soundTypeAnvil).setResistance(4F).setHardness(2F);
        EnumBlocks.although.bloccName = "Although";
        EnumBlocks.metalSiding_White.leBlock = new MetalSiding_White(Material.iron);
        EnumBlocks.metalSiding_White.bloccName = "White Metal Siding";
        EnumBlocks.metalSiding_LightGrey.leBlock = new MetalSiding_LightGrey(Material.iron);
        EnumBlocks.metalSiding_LightGrey.bloccName = "Light Grey Metal Siding";
        EnumBlocks.metalSiding_Grey.leBlock = new MetalSiding_Grey(Material.iron);
        EnumBlocks.metalSiding_Grey.bloccName = "Grey Metal Siding";
        EnumBlocks.metalSiding_Black.leBlock = new MetalSiding_Black(Material.iron);
        EnumBlocks.metalSiding_Black.bloccName = "Black Metal Siding";
        EnumBlocks.BlockmetalSiding.leBlock = new BlockmetalSiding();
        EnumBlocks.BlockmetalSiding.bloccName = "Metal Siding";


        for (EnumBlocks blocc : EnumBlocks.values()) {
            blocc.leBlock.setCreativeTab(foxBlocksCreativeTab);
            if (blocc.leItemBlock != null) {
                GameRegistry.registerBlock(blocc.leBlock, blocc.leItemBlock.getClass(), blocc.bloccName);
            } else {
                GameRegistry.registerBlock(blocc.leBlock, blocc.bloccName);
            }
        }

    }

    public void registerRecipe() {
        GameRegistry.addShapelessRecipe(new ItemStack(EnumBlocks.peagravel.leBlock, 1), Blocks.gravel);
        GameRegistry.addShapelessRecipe(new ItemStack(EnumBlocks.peagravel_snow.leBlock, 1),  new ItemStack(EnumBlocks.peagravel.leBlock, 1), Items.snowball, new ItemStack(EnumBlocks.peagravel.leBlock, 1));
    }

}
