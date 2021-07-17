package com.bidahochi.BlockMod;


import com.bidahochi.BlockMod.core.handler.*;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = FoxBlocks.MODID, version = FoxBlocks.VERSION, name = FoxBlocks.NAME)
public class FoxBlocks
{
    public static final String MODID = "foxblocks";
    public static final String NAME = "FoxBlocks";
    public static final String VERSION = "1.0.4";
    public static CreativeTabs foxBlocksCreativeTab;
    public static CreativeTabs foxBlocksCreativeTabRock;
    public static CreativeTabs foxBlocksCreativeTabHome;
    public static CreativeTabs foxBlocksCreativeTabFactory;
    public static CreativeTabs foxBlocksCreativeTabItems;
    public static Logger blockLogger = LogManager.getLogger("FoxBlocks");

    @EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        //Initalize blocc tabs.
        blockLogger.info("FoxBlocks starting with it's big floofy tail");

        foxBlocksCreativeTabRock = new CreativeTabs("FoxBlocks - Rock Hard") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(BlockIDs.fireBrick.block); }
            public String getTranslatedTabLabel() { return "FoxBlocks - Rock Hard"; }};

        foxBlocksCreativeTabHome = new CreativeTabs("FoxBlocks - Happy Homes") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(BlockIDs.tile2x2.block); }
            public String getTranslatedTabLabel() { return "FoxBlocks - Happy Homes"; }};

        foxBlocksCreativeTabFactory = new CreativeTabs("FoxBlocks - Fox Factory") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(BlockIDs.metalSiding.block); }
            public String getTranslatedTabLabel() { return "FoxBlocks - Fox Factory"; }};

        foxBlocksCreativeTabItems = new CreativeTabs("FoxBlocks - Obligatory Items Tab") {
            public Item getTabIconItem() {
                return  ItemIDs.jarate.item; }
            public String getTranslatedTabLabel() { return "FoxBlocks - Obligatory Items Tab"; }};

        foxBlocksCreativeTab = new CreativeTabs("FoxBlocks - Unsorted") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(BlockIDs.tHanos.block); }
            public String getTranslatedTabLabel() {
                return "FoxBlocks - Unsorted";
                }
        };

        //registration os things that run things
        blockHandler.initBlockRegister();
        //blockHandler.blockpropertyregister(); //this is the enum registering (ask -hariesh for info)
        itemHandler.initItemRegister();
        recipeHandler.initBlockRecipes();
        oreDictHandler.registerOreDict();

        GameRegistry.registerWorldGenerator(new oreGenerationHandler(), 0);
        GameRegistry.registerWorldGenerator(new oreGenerationHandler2(), 10);

        GameRegistry.registerWorldGenerator(new OreGen(BlockIDs.soapStoneEmerald.block, 0,255,15,7,13).setFiller(BlockIDs.soapStone.block).setBiomes(null).setHeightOffset(0).setDimensions(null), 7);
        //GameRegistry.registerWorldGenerator(new OreGen(BlockIDs.soapStoneEmerald.block, 0, 200, 25, 2,10).setFiller(BlockIDs.soapStone.block).setBiomes(null).setHeightOffset(0).setDimensions(null),7);
        //GameRegistry.registerWorldGenerator(new OreGen(BlockIDs.soapStoneMagmatic.block, 0, 200, 25, 5,2).setFiller(BlockIDs.soapStone.block).setBiomes(null).setHeightOffset(0).setDimensions(null),7);
        //GameRegistry.registerWorldGenerator(new OreGen(BlockIDs.soapStoneMagmatic.block, 0, 200, 15, 7,13).setFiller(BlockIDs.soapStone.block).setBiomes(null).setHeightOffset(0).setDimensions(null),7);
        //GameRegistry.registerWorldGenerator(new OreGen(Blocks.air, 0, 200, 25, 32,1).setFiller(BlockIDs.soapStone.block).setBiomes(null).setHeightOffset(0).setDimensions(null),7);
    }
}
