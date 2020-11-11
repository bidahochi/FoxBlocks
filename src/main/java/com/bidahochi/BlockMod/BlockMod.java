package com.bidahochi.BlockMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = BlockMod.MODID, version = BlockMod.VERSION)
public class BlockMod
{
    public static final String MODID = "BlockMod";
    public static final String VERSION = "1.0";
    public static final CreativeTabs foxBlocksCreativeTab = new CreativeTabs("FoxBlocks") {//best to have mod id in name so that it is YOUR tab
        public Item getTabIconItem() {
            return  Item.getItemFromBlock(bauxiteOre); //returns item or block you want as the icon though for block you need  to use Item.getItemFromBlock(block)
        }

        public String getTranslatedTabLabel() {
            return "test tab"; //name of the tab you want to display when hovering
        }
    };
    public static Logger blockLogger = LogManager.getLogger("BlockMod");
    public static BauxiteOre bauxiteOre = new BauxiteOre(Material.rock);
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        blockLogger.info("Block Mod Starting");
        GameRegistry.registerBlock(bauxiteOre, ItemBlockBauxiteOre.class, "Bauxite Ore");


    }
}
