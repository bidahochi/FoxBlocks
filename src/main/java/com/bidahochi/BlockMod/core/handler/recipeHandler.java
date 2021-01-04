package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

/***************************************
 *
 *  recipeHandler  by -hariesh
 *
 *  For any recipe that involved unique blocks from the mod or minecraft use BlockIDs or Blocks
 *
 *  For any recipe that involved generic items such as dye, ingots, or other, please use OreDictionary ArrayStacks by
 *  making an ArrayList from line 40 onwards using format:
 *          ArrayList<ItemStack> nameOfItem = OreDictionary.getOres("oreDictTag");
 *
 *  Please stick to formatting and Proper Naming Conventions for ease of code!
 *
 *
 *  How to do Recipies:
 *
 *  For Shapeless Recipies what you are doing is saying the block output (block your crafting) and a list of items that can make it
 *
 *  Use format:
 *      GameRegistry.AddShapelessRecipe(new ItemStack(BlockIDs.<insertBlockForCrafting>.block, 1), {Start list of blocks that make up recipe, using Blocks.## or New ItemStack(BlockIDs.##.block, 1) or OreDictList); }
 *
 *  For Shaped Recipies, what you are to do is set where each block should be and what block they are
 *
 *  Crafting Grid:
 *      {ABC}
 *      {DEF}
 *      {GHI}
 *
 *  Imagine where the items for recipe should go in that grid on the table and use this format:
 *      GameRegistry.AddRecipe(new ItemStack(BlockIDs.<insertBlockForCrafting>.block, 1), "ABC", "DEF", "GHI", Character.valueOf('<insert position here>'), {new ItemStack(BlockIDs.blockname.block, 1)/Blocks.Blockname} );
 *
 *      Note: Add a
 *          Character.valueOf('#'), {new ItemStack(BlockIDs.blockname.block, 1)/Blocks.Blockname}
 *      for each item in the grid.
 *
 *      Note: For the empty spots in the grid use a spacebar " " instead of a character to represent no block needed
 *
 *      Note: You can use any Character in the grid, etc X, or S or whatever, but its easier to use the format above but I wont judge!
 *
 *  If you have any further Questions, just DM or Ping me and I can help you through!
 *
 *   -hariesh
 *
 ****************************/

public class recipeHandler {

    private static ArrayList<ItemStack> multiNameOreDict(String ... names){
        ArrayList<ItemStack> entries = new ArrayList<ItemStack>();
        for (String name : names){
            entries.addAll(OreDictionary.getOres(name));
        }
        return entries;
    }

    public static void initBlockRecipes() {

        FoxBlocks.blockLogger.info("BlockRecipe's Pre Init at com.bidahochi.BlockMod.core.handler.recipeHandler");


        ArrayList<ItemStack> iron = OreDictionary.getOres("ingotIron");

        ArrayList<ItemStack> dyeBlack = OreDictionary.getOres("dyeBlack");
        ArrayList<ItemStack> dyeRed = OreDictionary.getOres("dyeRed");
        ArrayList<ItemStack> dyeGreen = OreDictionary.getOres("dyeGreen");
        ArrayList<ItemStack> dyeBrown = OreDictionary.getOres("dyeBrown");
        ArrayList<ItemStack> dyeBlue = OreDictionary.getOres("dyeBlue");
        ArrayList<ItemStack> dyePurple = OreDictionary.getOres("dyePurple");
        ArrayList<ItemStack> dyeCyan = OreDictionary.getOres("dyeCyan");
        ArrayList<ItemStack> dyeLightGray = OreDictionary.getOres("dyeLightGray");
        ArrayList<ItemStack> dyeGray = OreDictionary.getOres("dyeGray");
        ArrayList<ItemStack> dyePink = OreDictionary.getOres("dyePink");
        ArrayList<ItemStack> dyeLime = OreDictionary.getOres("dyeLime");
        ArrayList<ItemStack> dyeYellow = OreDictionary.getOres("dyeYellow");
        ArrayList<ItemStack> dyeLightBlue = OreDictionary.getOres("dyeLightBlue");
        ArrayList<ItemStack> dyeMagenta = OreDictionary.getOres("dyeMagenta");
        ArrayList<ItemStack> dyeOrange = OreDictionary.getOres("dyeOrange");
        ArrayList<ItemStack> dyeWhite = OreDictionary.getOres("dyeWhite");
        ArrayList<ItemStack> plateIron = OreDictionary.getOres("plateIron");

        //Wallpapers and Drywalls
        for (ItemStack dyeblack : dyeBlack) {
            //GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.metalSiding.block, 1,0),  Blocks.iron_block, dyeblack); -keep this
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,3), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyeblack);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,3), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyeblack);
        }
        for (ItemStack dyewhite : dyeWhite)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,0), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyewhite);

        }
        for (ItemStack dyegray : dyeGray)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,11), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyegray);
        }
        for (ItemStack dyelightblue : dyeLightBlue)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,10), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyelightblue);
            for (ItemStack dyeblue : dyeBlue)
            {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4, 14), "AAA", "AEA", "ABA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyeblue, Character.valueOf('B'), dyelightblue);
            }
            for (ItemStack dyepink : dyePink)
            {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,10), "AAA", "AEA", "ABA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyelightblue, Character.valueOf('B'), dyepink);
            }
        }
        for (ItemStack dyeblue : dyeBlue)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,5), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyeblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,11), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyeblue);
        }
        for (ItemStack dyered : dyeRed)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,6), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyered);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,5), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyered);
            for (ItemStack dyelime : dyeLime)
            {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,13), "AAA", "AEA", "ABA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyelime, Character.valueOf('B'), dyered);
            }
        }
        for (ItemStack dyeyellow : dyeYellow)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,7), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyeyellow);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,7), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyeyellow);
        }
        for (ItemStack dyegreen : dyeGreen)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,8), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyegreen);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,9), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyegreen);
        }
        for (ItemStack dyecyan : dyeCyan)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,9), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyecyan);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,12), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyecyan);
        }
        for (ItemStack dyeorange : dyeOrange)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,6), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyeorange);
        }
        for (ItemStack dyemagenta : dyeMagenta)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,14), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyemagenta);
        }
        for (ItemStack dyelime : dyeLime)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,8), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyelime);
        }
        for (ItemStack dyepink : dyePink)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,13), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyepink);
        }
        for (ItemStack dyegray : dyeGray)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,2), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyegray);
        }
        for (ItemStack dyelightgray : dyeLightGray)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,1), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyelightgray);
        }
        for (ItemStack dyepurple : dyePurple)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,15), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyepurple);
        }
        for (ItemStack dyebrown : dyeBrown)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.dryWall.block, 8,4), "AAA", "AEA", "AAA", Character.valueOf('A'), BlockIDs.unfinishedDrywall.block, Character.valueOf('E'), dyebrown);
        }
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,0), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Items.redstone);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,1), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Blocks.leaves);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,2), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Items.apple);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,4), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), new ItemStack(Blocks.grass,1,2));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,12), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), ItemIDs.jarate.item);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,15), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Items.ender_eye);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unfinishedDrywall.block, 4), "BBA", "BBA", "AAA", Character.valueOf('B'), ItemIDs.gypsumDust.item, Character.valueOf('A'), Items.paper);

        //aggregates
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel.block, 1), Blocks.gravel);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel_snow.block, 2), new ItemStack(BlockIDs.peagravel.block, 1), Items.snowball, new ItemStack(BlockIDs.peagravel.block, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel_shit.block, 2), new ItemStack(BlockIDs.peagravel.block, 1), Blocks.dirt);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.gravel_shit.block, 2), new ItemStack(BlockIDs.gravel_shit.block, 1), Blocks.dirt);

        //sheet metal sidings - oredictionary plateIron doesnt seem to work, please look into
        for (ItemStack plateiron : plateIron) {
            for (ItemStack dyewhite : dyeWhite) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 3), " I ", "IDI", " I ", Character.valueOf('I'), plateiron, Character.valueOf('D'), dyewhite); }
            for (ItemStack dyelightgray : dyeLightGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 2), " I ", "IDI", " I ", Character.valueOf('I'), plateiron, Character.valueOf('D'), dyelightgray); }
            for (ItemStack dyegray : dyeGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 1), " I ", "IDI", " I ", Character.valueOf('I'), plateiron, Character.valueOf('D'), dyegray); }
            for (ItemStack dyeblack : dyeBlack) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 0), " I ", "IDI", " I ", Character.valueOf('I'), plateiron, Character.valueOf('D'), dyeblack); }
        }
        for (ItemStack dyewhite : dyeWhite) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 3), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyewhite); }
        for (ItemStack dyelightgray : dyeLightGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 2), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyelightgray); }
        for (ItemStack dyegray : dyeGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 1), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyegray); }
        for (ItemStack dyeblack : dyeBlack) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 0), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyeblack); }

        //soapstone bs - CUSTOM CRAFTING TABLE WITH MULTIPLE OUTPUTS WHENNN aaaaa
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.soapStoneDeco.block, 2, 0), BlockIDs.soapStone.block, BlockIDs.soapStone.block);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.soapStoneDeco.block, 2, 1), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 0), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.soapStoneDeco.block, 2, 2), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 1), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.soapStoneDeco.block, 2, 3), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 2), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 2));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.soapStoneStair.block, 6), "  S", " SS", "SSS", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.soapStoneSlab.block, 6), "   ", "   ", "SSS", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block));

        //other things
        for (ItemStack dyeyellow : dyeYellow){ GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.jarate.item, 1,0),  Items.water_bucket, dyeyellow);}
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.gypsumDust.item, 8), BlockIDs.gypsum.block);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.fireBrick.block, 4), "SBS", "BSB", "SBS", Character.valueOf('S'), Blocks.sand, Character.valueOf('B'), Items.brick);
        //for (ItemStack dyebrown : dyeBrown){ GameRegistry.addRecipe(new ItemStack(BlockIDs.brownTile.block, 2), "SSB", "   ", "   ", Character.valueOf('S'), BlockIDs.soapStone.block, Character.valueOf('B'), dyebrown); }
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.harieshHead.block,1), Items.diamond_pickaxe, Items.diamond_axe, Items.diamond_hoe, Items.diamond_sword, Items.diamond_shovel);

        //fibregloss
        GameRegistry.addRecipe(new ItemStack(BlockIDs.fiberGlass.block, 6, 2), "WGW", "GWG", "WGW", Character.valueOf('W'), Blocks.wool, Character.valueOf('G'), Blocks.glass_pane);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.fiberGlass.block, 2, 0), " F ", "WWW", " F ", Character.valueOf('W'), Blocks.planks, Character.valueOf('F'), BlockIDs.fiberGlass.block);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.fiberGlass.block, 2, 1), " W ", "FWF", " W ", Character.valueOf('W'), Blocks.planks, Character.valueOf('F'), BlockIDs.fiberGlass.block);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.fiberGlass.block, 1, 2), new ItemStack(BlockIDs.fiberGlass.block, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.fiberGlass.block, 1, 1), new ItemStack(BlockIDs.fiberGlass.block, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.fiberGlass.block, 1, 0), new ItemStack(BlockIDs.fiberGlass.block, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.fiberGlass.block, 1, 0), new ItemStack(BlockIDs.fiberGlass.block, 1, 1));

        //concretes
        GameRegistry.addRecipe(new ItemStack(BlockIDs.rawConcrete.block, 8), "SGS", "GRG", "SGS", Character.valueOf('S'), Blocks.sand, Character.valueOf('G'), Blocks.gravel, Character.valueOf('R'), Blocks.stone);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.layeredConcrete.block, 3), " C ", " C ", " C ", Character.valueOf('C'), BlockIDs.smoothCrete.block);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.smoothCrete.block, 4), new ItemStack(BlockIDs.rawConcrete.block, 1), new ItemStack(BlockIDs.rawConcrete.block, 1), new ItemStack(BlockIDs.rawConcrete.block, 1), new ItemStack(BlockIDs.rawConcrete.block, 1));

        //hariesh hell blocks
        GameRegistry.addRecipe(new ItemStack(BlockIDs.emberStoneSlab.block,6), "   ","   ","EEE",Character.valueOf('E'), new ItemStack(BlockIDs.emberStone.block,1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.emberStoneStair.block,8), "E  ","EE ","EEE", Character.valueOf('E'), new ItemStack(BlockIDs.emberStone.block,1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.darkEmberStoneSlab.block,6), "   ","   ","EEE",Character.valueOf('E'), new ItemStack(BlockIDs.darkEmberStone.block,1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.darkEmberStoneStair.block,8), "E  ","EE ","EEE", Character.valueOf('E'), new ItemStack(BlockIDs.darkEmberStone.block,1));
        GameRegistry.addSmelting(BlockIDs.emberStone.block, new ItemStack(BlockIDs.darkEmberStone.block,1),1F);

        //tiles
        for (ItemStack dyewhite : dyeWhite) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 0), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyewhite);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 0), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyewhite);}
        for (ItemStack dyelightgrey : dyeLightGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 1), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyelightgrey);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 8), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyelightgrey);}
        for (ItemStack dyegrey : dyeGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 2), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyegrey);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 7), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyegrey);}
        for (ItemStack dyeblack : dyeBlack) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 3), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyeblack);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 15), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyeblack);}
        for (ItemStack dyebrown : dyeBrown) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 4), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyebrown);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 12), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyebrown);}
        for (ItemStack dyered : dyeRed) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 5), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyered);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 14), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyered);}
        for (ItemStack dyeorange : dyeOrange) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 6), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyeorange);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 1), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyeorange);}
        for (ItemStack dyeyellow : dyeYellow) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 7), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyeyellow);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 4), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyeyellow);}
        for (ItemStack dyelime : dyeLime) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 8), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyelime);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 5), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyelime);}
        for (ItemStack dyegreen : dyeGreen) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 9), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyegreen);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 13), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyegreen);}
        for (ItemStack dyelightblue : dyeLightBlue) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 10), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyelightblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 3), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyelightblue);}
        for (ItemStack dyeblue : dyeBlue) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 11), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyeblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 11), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyeblue);}
        for (ItemStack dyecyan : dyeCyan) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 12), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyecyan);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 9), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyecyan);}
        for (ItemStack dyepink : dyePink) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 13), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyepink);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 6), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyepink);}
        for (ItemStack dyemagenta : dyeMagenta) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 14), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyemagenta);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 2), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyemagenta);}
        for (ItemStack dyepurple : dyePurple) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 15), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyepurple);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 10), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block, 1), Character.valueOf('D'), dyepurple);}

        FoxBlocks.blockLogger.info("Hi Mom!");
        FoxBlocks.blockLogger.info("BlockRecipe Post Init at com.bidahochi.BlockMod.core.handler.recipeHandler");
    }
}
