package com.bidahochi.BlockMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = FoxBlocks.MODID, version = FoxBlocks.VERSION, name = FoxBlocks.NAME)
public class FoxBlocks
{
    public static final String MODID = "foxblocks";
    public static final String NAME = "FoxBlocks";
    public static final String VERSION = "1.0";
    public static CreativeTabs foxBlocksCreativeTab;
    public static Logger blockLogger = LogManager.getLogger("FoxBlocks");
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
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

registerBlocks();
    }

    public void registerBlocks() {
        EnumBlocks.bauxiteOre.leBlock = new BauxiteOre(Material.rock);
        EnumBlocks.bauxiteOre.bloccName = "Bauxite Ore";
        EnumBlocks.rawConcrete.leBlock = new RawConcrete(Material.rock);
        EnumBlocks.rawConcrete.bloccName = "Raw Concrete";
        EnumBlocks.peagravel_snow.leBlock = new SnowyPeaGravel(Material.sand);
        EnumBlocks.peagravel_snow.bloccName = "Snowy Pea Gravel";
        EnumBlocks.peagravel.leBlock = new PeaGravel(Material.sand);
        EnumBlocks.peagravel.bloccName = "Pea Gravel";

        //Leave this part alone. Put your blocks in the above part. :D
        for (EnumBlocks blocc : EnumBlocks.values()) {
            blocc.leBlock.setCreativeTab(foxBlocksCreativeTab);
            if (blocc.leItemBlock != null) {
                GameRegistry.registerBlock(blocc.leBlock, blocc.leItemBlock.getClass(), blocc.bloccName);
            } else {
                GameRegistry.registerBlock(blocc.leBlock, blocc.bloccName);
            }
        }
    }
}
