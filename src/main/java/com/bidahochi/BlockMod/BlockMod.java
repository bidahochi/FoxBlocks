package com.bidahochi.BlockMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = BlockMod.MODID, version = BlockMod.VERSION)
public class BlockMod
{
    public static final String MODID = "BlockMod";
    public static final String VERSION = "1.0";
    public static CreativeTabs blockModTab;
    public static Logger blockLogger = LogManager.getLogger("BlockMod");
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        blockLogger.info("Block Mod Starting");
        GameRegistry.registerBlock(new BauxiteOre(Material.rock), ItemBlockBauxiteOre.class, "Bauxite Ore");
        blockModTab = new BlockModTab(CreativeTabs.getNextID(),"Block Mod");
    }
}
