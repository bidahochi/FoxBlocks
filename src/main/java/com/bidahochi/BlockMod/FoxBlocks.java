package com.bidahochi.BlockMod;

import com.bidahochi.BlockMod.core.CommonProxy;
import com.bidahochi.BlockMod.core.handler.*;
import com.bidahochi.BlockMod.entities.EntityChair;
import com.bidahochi.BlockMod.init.FoxBlocksCreativeTab;
import com.bidahochi.BlockMod.plugins.fmp.ForgeMultiPart;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;


@Mod(modid = FoxBlocks.MODID, version = FoxBlocks.VERSION, name = FoxBlocks.NAME, dependencies = "after:ForgeMultipart")
public class FoxBlocks
{
    public static final String MODID = "foxblocks";
    public static final String NAME = "FoxBlocks";
    public static final String VERSION = "1.4.6";
    public static CreativeTabs foxBlocksCreativeTab;
    public static CreativeTabs foxBlocksCreativeTabRock;
    public static CreativeTabs foxBlocksCreativeTabHome;
    public static CreativeTabs foxBlocksCreativeTabFactory;
    public static CreativeTabs foxBlocksCreativeTabRoadRail;
    public static CreativeTabs foxBlocksCreativeTabProperProps;
    public static CreativeTabs foxBlocksCreativeTabItems;
    public static CreativeTabs foxBlocksCreativeTabVanillaPlus;
    public static CreativeTabs foxBlocksCreativeTabExtraBlockShapes;
    public static Logger blockLogger = LogManager.getLogger("FoxBlocks");
    public static FMLEventChannel channel;
    public static boolean isForgeMultiPartLoaded = false;

    public static File configDirectory;
    /* Foxblocks proxy files */
    @SidedProxy(clientSide = "com.bidahochi.BlockMod.core.ClientProxy", serverSide = "com.bidahochi.BlockMod.core.CommonProxy")
    public static CommonProxy proxy;

    private static BlockRegisterReturnCache blockRegisterReturnCache;

    @EventHandler
    public void preInit(FMLPreInitializationEvent PreEvent){
        channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(MODID);
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
        configDirectory = PreEvent.getModConfigurationDirectory();
        ConfigHandler.init(new File(PreEvent.getModConfigurationDirectory(), NAME + ".cfg"));

        foxBlocksCreativeTabRock = new FoxBlocksCreativeTab("FoxBlocks - Rock Hard") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(BlockIDs.fireBrick.block); }
            public String getTranslatedTabLabel() { return "FoxBlocks - Rock Hard"; }};

        foxBlocksCreativeTabHome = new FoxBlocksCreativeTab("FoxBlocks - Happy Homes") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(BlockIDs.tile2x2.block); }
            public String getTranslatedTabLabel() { return "FoxBlocks - Happy Homes"; }};

        foxBlocksCreativeTabFactory = new FoxBlocksCreativeTab("FoxBlocks - Fox Factory") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(BlockIDs.metalSiding.block); }
            public String getTranslatedTabLabel() { return "FoxBlocks - Fox Factory"; }};

        foxBlocksCreativeTabItems = new FoxBlocksCreativeTab("FoxBlocks - Obligatory Items Tab") {
            public Item getTabIconItem() {
                return  ItemIDs.jarate.item; }
            public String getTranslatedTabLabel() { return "FoxBlocks - Obligatory Items Tab"; }};

        foxBlocksCreativeTabRoadRail = new FoxBlocksCreativeTab("FoxBlocks - Roads 'n' Rails") {
            public Item getTabIconItem() {
                return   Item.getItemFromBlock(BlockIDs.srpb_cy2.block); }
            public String getTranslatedTabLabel() { return "FoxBlocks - Roads 'n' Rails"; }};

        foxBlocksCreativeTabProperProps = new FoxBlocksCreativeTab("FoxBlocks - Proper Props") {
            public Item getTabIconItem() {
                return   Item.getItemFromBlock(BlockIDs.xmasLights1_top_rainbow.block); }
            public String getTranslatedTabLabel() { return "FoxBlocks - Proper Props"; }};

        foxBlocksCreativeTab = new FoxBlocksCreativeTab("FoxBlocks - Unsorted") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(BlockIDs.tHanos.block); }
            public String getTranslatedTabLabel() {
                return "FoxBlocks - Unsorted";
            }
        };

        foxBlocksCreativeTabVanillaPlus = new FoxBlocksCreativeTab("FoxBlocks - Vanilla+") {
            public Item getTabIconItem() {
                return  ItemIDs.bucket_of_tbea.item; }
            public String getTranslatedTabLabel() {
                return "FoxBlocks - Vanilla+";
            }
        };

        foxBlocksCreativeTabExtraBlockShapes = new FoxBlocksCreativeTab("FoxBlocks - Blocks+") {
            public Item getTabIconItem() {
                return  Item.getItemFromBlock(BlockIDs.dryWall.block); }
            public String getTranslatedTabLabel() {
                return "FoxBlocks - Blocks+";
            }
        };

        BlockHandler blockHandler = new BlockHandler();
        blockRegisterReturnCache = blockHandler.initBlockRegister(PreEvent);
        FluidHandler.initFluidRegister(PreEvent);
        ItemHandler.initItemRegister();
        OreDictHandler.registerOreDict();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //Initalize blocc tabs.
        blockLogger.info("FoxBlocks starting with it's big floofy tail");

        GameRegistry.registerWorldGenerator(new OreGenerationHandler(), 0);
        GameRegistry.registerWorldGenerator(new OreGenerationHandler2(), 10);

        proxy.registerMouseEventHandler();
        //GameRegistry.registerWorldGenerator(new OreGen(BlockIDs.soapStoneEmerald.block, 0,255,15,7,13).setFiller(BlockIDs.soapStone.block).setBiomes(null).setHeightOffset(0).setDimensions(null), 7);
        //GameRegistry.registerWorldGenerator(new OreGen(BlockIDs.soapStoneEmerald.block, 0, 200, 25, 2,10).setFiller(BlockIDs.soapStone.block).setBiomes(null).setHeightOffset(0).setDimensions(null),7);
        //GameRegistry.registerWorldGenerator(new OreGen(BlockIDs.soapStoneMagmatic.block, 0, 200, 25, 5,2).setFiller(BlockIDs.soapStone.block).setBiomes(null).setHeightOffset(0).setDimensions(null),7);
        //GameRegistry.registerWorldGenerator(new OreGen(BlockIDs.soapStoneMagmatic.block, 0, 200, 15, 7,13).setFiller(BlockIDs.soapStone.block).setBiomes(null).setHeightOffset(0).setDimensions(null),7);
        //GameRegistry.registerWorldGenerator(new OreGen(Blocks.air, 0, 200, 25, 32,1).setFiller(BlockIDs.soapStone.block).setBiomes(null).setHeightOffset(0).setDimensions(null),7);
        //do these even need to still exist?
        //MinecraftForge.EVENT_BUS.register(ReMappingHandler.class);
        EntityRegistry.registerModEntity(EntityChair.class, "EntityChair", 0, MODID, 80, 1, false);
        if (Loader.isModLoaded("ForgeMultipart"))
        {
            ForgeMultiPart.registerBlocks(BlockIDs.values());
            isForgeMultiPartLoaded = true;
        }

    }

    @EventHandler
    public void PostLoad(FMLPostInitializationEvent PostLoad)
    {
        RecipeHandler.initBlockRecipes(blockRegisterReturnCache);
        blockRegisterReturnCache = null;
    }

    @EventHandler
    public void missingMappings(FMLMissingMappingsEvent event)
    {
        MissingBlockHandler.initMissingBlock(event.get());
    }
}
