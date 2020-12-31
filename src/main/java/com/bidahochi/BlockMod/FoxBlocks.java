package com.bidahochi.BlockMod;


import com.bidahochi.BlockMod.core.handler.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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

        blockHandler.initBlockRegister();
        itemHandler.initItemRegister();
        recipeHandler.initBlockRecipes();
        oreDictHandler.registerOreDict();
        GameRegistry.registerWorldGenerator(new oreGenerationHandler(), 0);
    }


}
