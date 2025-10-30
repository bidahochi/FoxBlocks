package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.baseBlocks.vanillaBlockConvertions.VanillaBlockProperty;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Map;

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

public class RecipeHandler {

    private static ArrayList<ItemStack> multiNameOreDict(String ... names){
        ArrayList<ItemStack> entries = new ArrayList<ItemStack>();
        for (String name : names){
            entries.addAll(OreDictionary.getOres(name));
        }
        return entries;
    }

    public static void initBlockRecipes(BlockRegisterReturnCache blockRegisterReturnCache) {

        //FoxBlocks.blockLogger.info("BlockRecipe's Pre Init at com.bidahochi.BlockMod.core.handler.recipeHandler");


        ArrayList<ItemStack> iron = OreDictionary.getOres("ingotIron");//does this work?

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
        ArrayList<ItemStack> log = OreDictionary.getOres("logWood");
        ArrayList<ItemStack> plank = OreDictionary.getOres("plankWood");

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
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 8,0), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Items.redstone);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 8,1), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Blocks.leaves);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 8,2), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Items.apple);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 8,4), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), new ItemStack(Blocks.grass,1,2));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 8,12), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), ItemIDs.jarate.item);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 8,15), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Items.ender_pearl);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unfinishedDrywall.block, 4), "BBA", "BBA", "AAA", Character.valueOf('B'), ItemIDs.gypsumDust.item, Character.valueOf('A'), Items.paper);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaperBackrooms.block, 8,0), "AAA", "AEA", "AAA", 'A', Items.paper, 'E', Items.bone);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.wallPaperBackrooms.block, 4,0), new ItemStack(BlockIDs.wallPaperBackrooms.block, 1, 1), new ItemStack(BlockIDs.wallPaperBackrooms.block, 1, 1), new ItemStack(BlockIDs.wallPaperBackrooms.block, 1, 1), new ItemStack(BlockIDs.wallPaperBackrooms.block, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.wallPaperBackrooms.block, 4,1), new ItemStack(BlockIDs.wallPaperBackrooms.block, 1, 0), new ItemStack(BlockIDs.wallPaperBackrooms.block, 1, 0), new ItemStack(BlockIDs.wallPaperBackrooms.block, 1, 0), new ItemStack(BlockIDs.wallPaperBackrooms.block, 1, 0));

        //aggregates
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel.block, 1), Blocks.gravel);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel_snow.block, 2), new ItemStack(BlockIDs.peagravel.block, 1), Items.snowball, new ItemStack(BlockIDs.peagravel.block, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel_shit.block, 2), new ItemStack(BlockIDs.peagravel.block, 1), Blocks.dirt);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.gravel_shit.block, 2), Blocks.gravel, Blocks.dirt);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.specialDirt.block, 2), Blocks.dirt, Blocks.dirt);
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.dirt, 2),  new ItemStack(BlockIDs.specialDirt.block, 1), new ItemStack(BlockIDs.specialDirt.block, 2));
        for (ItemStack dyeblack : dyeBlack){
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravelBallast.block, 2), BlockIDs.peagravel.block, BlockIDs.peagravel.block, dyeblack);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.peagravelBallast.block, 8), "AAA", "ABA", "AAA", 'A', BlockIDs.peagravel.block, 'B', dyeblack);
        }
        for (ItemStack dyewhite : dyeWhite) {
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravelWhitestone.block, 2), BlockIDs.peagravel.block, BlockIDs.peagravel.block, dyewhite);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.peagravelWhitestone.block, 8), "AAA", "ABA", "AAA", 'A', BlockIDs.peagravel.block, 'B', dyewhite);
        }
        //GameRegistry.addSmelting(BlockIDs.peagravel_volcanic.block, new ItemStack(BlockIDs.peagravel.block,1),1F);//this was backwards lol oops
        GameRegistry.addSmelting(BlockIDs.peagravel.block, new ItemStack(BlockIDs.peagravel_volcanic.block,1),1F);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.gravel_volcanic.block, 2), new ItemStack(BlockIDs.peagravel_volcanic.block, 1), new ItemStack(BlockIDs.peagravel_volcanic.block, 1));
        //GameRegistry.addSmelting(BlockIDs.gravel_volcanic.block, Blocks.gravel,1F);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel_redrock.block, 8), new ItemStack(BlockIDs.redrock.block, 1), new ItemStack(BlockIDs.redrock.block, 1, 1), new ItemStack(BlockIDs.redrock.block, 1, 1), new ItemStack(BlockIDs.redrock.block, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.dirt_3.block, 6), " V ", "AAA", "AAA", 'A', Blocks.dirt, 'V', new ItemStack(ItemIDs.enrichedClay.item));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.dirt_4.block, 4), BlockIDs.dirt_3.block, BlockIDs.dirt_3.block, BlockIDs.dirt_3.block, BlockIDs.dirt_3.block);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.creamCityClay.block, 3), "   ", " A ", "AVA", 'A', Blocks.sand, 'V', new ItemStack(ItemIDs.enrichedClay.item));



        //sheet metal sidings - oredictionary plateIron doesnt seem to work, please look into
        //apparently the plateiron recipe works on servers but not singleplayer?
        for (ItemStack plateiron : plateIron) {
            for (ItemStack dyewhite : dyeWhite) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 8, 3), " I ", "IDI", " I ", Character.valueOf('I'), plateiron, Character.valueOf('D'), dyewhite); }
            for (ItemStack dyelightgray : dyeLightGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 8, 2), " I ", "IDI", " I ", Character.valueOf('I'), plateiron, Character.valueOf('D'), dyelightgray); }
            for (ItemStack dyegray : dyeGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 8, 1), " I ", "IDI", " I ", Character.valueOf('I'), plateiron, Character.valueOf('D'), dyegray); }
            for (ItemStack dyeblack : dyeBlack) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 8, 0), " I ", "IDI", " I ", Character.valueOf('I'), plateiron, Character.valueOf('D'), dyeblack); }
        }
        for (ItemStack dyewhite : dyeWhite) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 3), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyewhite);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 3), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyewhite);}
        for (ItemStack dyelightgray : dyeLightGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 2), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyelightgray);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 2), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyelightgray);}
        for (ItemStack dyegray : dyeGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 1), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyegray);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 1), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyegray); }
        for (ItemStack dyeblack : dyeBlack) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 0), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyeblack);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 0), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyeblack); }
        for (ItemStack dyebrown : dyeBrown) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 4), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyebrown);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 4), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyebrown); }
        for (ItemStack dyered : dyeRed) { GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 5), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyered);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 5), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyered); }
        for (ItemStack dyeorange : dyeOrange) {GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 6), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyeorange);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 6), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyeorange); }
        for (ItemStack dyeyellow : dyeYellow) {GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 7), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyeyellow);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 7), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyeyellow); }
        for (ItemStack dyelime : dyeLime) {GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 8), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyelime);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 8), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyelime); }
        for (ItemStack dyegreen : dyeGreen){GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 9), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyegreen);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 9), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyegreen); }
        for (ItemStack dyelightblue : dyeLightBlue){GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 10), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyelightblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 10), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyelightblue); }
        for (ItemStack dyeblue : dyeBlue){GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 11), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyeblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 11), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyeblue); }
        for (ItemStack dyecyan : dyeCyan){GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 12), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyecyan);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 12), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyecyan); }
        for (ItemStack dyepink : dyePink){GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 13), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyepink);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 13), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyepink); }
        for (ItemStack dyemagenta : dyeMagenta){GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 14), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyemagenta);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 14), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyemagenta); }
        for (ItemStack dyepurple : dyePurple){GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding.block, 4, 15), " I ", "IDI", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyepurple);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.metalSiding2.block, 8, 15), "I I", " D ", "I I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('D'), dyepurple); }

        //soapstone bs - CUSTOM CRAFTING TABLE WITH MULTIPLE OUTPUTS WHENNN aaaaa
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.soapStoneDeco.block, 2, 0), BlockIDs.soapStone.block, BlockIDs.soapStone.block);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.soapStoneDeco.block, 2, 1), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 0), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.soapStoneDeco.block, 2, 2), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 1), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.soapStoneDeco.block, 2, 3), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 2), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.soapStoneDeco.block, 2, 4), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 3), new ItemStack(BlockIDs.soapStoneDeco.block, 1, 3));
        //GameRegistry.addRecipe(new ItemStack(BlockIDs.soapStoneStair.block, 6), "  S", " SS", "SSS", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block));
        //GameRegistry.addRecipe(new ItemStack(BlockIDs.soapStoneSlab.block, 6), "   ", "   ", "SSS", Character.valueOf('S'), new ItemStack(BlockIDs.soapStone.block));

        //redrocks of colorado or something idk
        for (ItemStack dyee : dyeRed) {//recipe to craft redrock stone for thoes who dont want to go find it naturally
        GameRegistry.addRecipe(new ItemStack(BlockIDs.redrock.block, 8), "FVF", "VDV", "FVF", 'F', BlockIDs.soapStone.block, 'V', Blocks.stone, 'D', dyee);
        }
        GameRegistry.addRecipe(new ItemStack(BlockIDs.redrockDeco.block,4, 0), " R ", "RBR", " R ", 'R', BlockIDs.redrock.block, 'B', new ItemStack(ItemIDs.bolsterChisel.item));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.redrockDeco.block, 2, 1), BlockIDs.redrock.block, BlockIDs.redrock.block);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.redrockDeco.block, 2, 2), new ItemStack(BlockIDs.redrockDeco.block, 1, 1), new ItemStack(BlockIDs.redrockDeco.block, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.redrockDeco.block, 2, 3), new ItemStack(BlockIDs.redrockDeco.block, 1, 2), new ItemStack(BlockIDs.redrockDeco.block, 1, 2));


        //other things various misc
        for (ItemStack dyeyellow : dyeYellow){ GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.jarate.item, 1,0),  Items.water_bucket, dyeyellow);}
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.gypsumDust.item, 8), BlockIDs.gypsum.block);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.fireBrick.block, 4), "SBS", "BAB", "SBS", Character.valueOf('S'), Blocks.sand, Character.valueOf('B'), Items.brick, Character.valueOf('A'), new ItemStack(ItemIDs.aragoniteClump.item,1));
        //for (ItemStack dyebrown : dyeBrown){ GameRegistry.addRecipe(new ItemStack(BlockIDs.brownTile.block, 2), "SSB", "   ", "   ", Character.valueOf('S'), BlockIDs.soapStone.block, Character.valueOf('B'), dyebrown); }
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.blockOfPlayerHead.block,1), Items.diamond_pickaxe, Items.diamond_axe, Items.diamond_hoe, Items.diamond_sword, Items.diamond_shovel);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.blockLavaBucket.block, 1), Items.lava_bucket,Items.lava_bucket,Items.lava_bucket,Items.lava_bucket);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.rust.item, 4), Items.water_bucket, Items.iron_ingot);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.rust.item, 16), Items.water_bucket, new ItemStack(ItemIDs.ironSlice.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.bucket_of_lean.item, 1), Items.water_bucket, Items.milk_bucket, new ItemStack(ItemIDs.leanDust.item), new ItemStack(ItemIDs.leanDust.item));
        for (ItemStack loggy : log) {
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.woodchips.block, 16), loggy, loggy, new ItemStack(ItemIDs.bolsterChisel.item));
        }
        for (ItemStack planky : plank) {
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.woodchips.block, 8), planky, planky, new ItemStack(ItemIDs.bolsterChisel.item));
        }

        //wrapped wood n shit
        for (ItemStack logg : plank) {
            for (ItemStack dye : dyeWhite) {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wrappedwood1.block, 4), "PPP", "SWS", " D ", 'P', new ItemStack(Items.paper), 'S', new ItemStack(ItemIDs.straps.item), 'W', logg, 'D', dye);
            }
            for (ItemStack dye : dyeRed) {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wrappedwood2.block, 4), "PPP", "SWS", " D ", 'P', new ItemStack(Items.paper), 'S', new ItemStack(ItemIDs.straps.item), 'W', logg, 'D', dye);
            }
            for (ItemStack dye : dyeBlue) {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wrappedwood3.block, 4), "PPP", "SWS", " D ", 'P', new ItemStack(Items.paper), 'S', new ItemStack(ItemIDs.straps.item), 'W', logg, 'D', dye);
            }
            for (ItemStack dye : dyeOrange) {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wrappedwood4.block, 4), "PPP", "SWS", " D ", 'P', new ItemStack(Items.paper), 'S', new ItemStack(ItemIDs.straps.item), 'W', logg, 'D', dye);
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wrappedwood5.block, 4), "PPP", "SWS", "D D", 'P', new ItemStack(Items.paper), 'S', new ItemStack(ItemIDs.straps.item), 'W', logg, 'D', dye);
            }
            for (ItemStack dye : dyeGreen) {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wrappedwood6.block, 4), "PPP", "SWS", " D ", 'P', new ItemStack(Items.paper), 'S', new ItemStack(ItemIDs.straps.item), 'W', logg, 'D', dye);
            }
            for (ItemStack dye : dyeLightBlue) {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wrappedwood7.block, 4), "PPP", "SWS", " D ", 'P', new ItemStack(Items.paper), 'S', new ItemStack(ItemIDs.straps.item), 'W', logg, 'D', dye);
            }
        }
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unwrappedwood1.block, 4), "   ", "SWS", "   ", 'S', new ItemStack(ItemIDs.straps.item), 'W', new ItemStack(Blocks.planks, 1, 0));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unwrappedwood2.block, 4), "   ", "SWS", "   ", 'S', new ItemStack(ItemIDs.straps.item), 'W', new ItemStack(Blocks.planks, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unwrappedwood3.block, 4), "   ", "SWS", "   ", 'S', new ItemStack(ItemIDs.straps.item), 'W', new ItemStack(Blocks.planks, 1, 2));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unwrappedwood4.block, 4), "   ", "SWS", "   ", 'S', new ItemStack(ItemIDs.straps.item), 'W', new ItemStack(Blocks.planks, 1, 3));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unwrappedwood5.block, 4), "   ", "SWS", "   ", 'S', new ItemStack(ItemIDs.straps.item), 'W', new ItemStack(Blocks.planks, 1, 4));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unwrappedwood6.block, 4), "   ", "SWS", "   ", 'S', new ItemStack(ItemIDs.straps.item), 'W', new ItemStack(Blocks.planks, 1, 5));
        //make it so if BOP is installed we can use their wood?
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.unwrappedwood7.block, 1), new ItemStack(BlockIDs.unwrappedwood1.block));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.unwrappedwood8.block, 1), new ItemStack(BlockIDs.unwrappedwood7.block));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.unwrappedwood9.block, 1), new ItemStack(BlockIDs.unwrappedwood8.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unwrappedwood10.block, 4), "   ", "SWS", "   ", 'S', new ItemStack(ItemIDs.straps.item), 'W', new ItemStack(BlockIDs.planks1.block, 1, 0));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unwrappedwood11.block, 4), "   ", "SWS", "   ", 'S', new ItemStack(ItemIDs.straps.item), 'W', new ItemStack(BlockIDs.planks1.block, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.unwrappedwood12.block, 4), "   ", "SWS", "   ", 'S', new ItemStack(ItemIDs.straps.item), 'W', new ItemStack(BlockIDs.planks1.block, 1, 2));

        //todo add uncrafting recipes for wrapped and unwrapped woods at somepoint

        //Privacy Fences
        GameRegistry.addRecipe(new ItemStack(BlockIDs.PFencing.block, 6, 0), "   ", "PFP", "   ", 'P', new ItemStack(Blocks.planks, 1, 0), 'F', Blocks.fence);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.PFencing.block, 6, 1), "   ", "PFP", "   ", 'P', new ItemStack(Blocks.planks, 1, 1), 'F', Blocks.fence);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.PFencing.block, 6, 2), "   ", "PFP", "   ", 'P', new ItemStack(Blocks.planks, 1, 2), 'F', Blocks.fence);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.PFencing.block, 6, 3), "   ", "PFP", "   ", 'P', new ItemStack(Blocks.planks, 1, 5), 'F', Blocks.fence);

        //lightbulbs
        GameRegistry.addRecipe(new ItemStack(ItemIDs.bulb.item, 10), "   "," G "," A ", 'G', Blocks.glowstone, 'A', new ItemStack(ItemIDs.aragoniteClump.item,1));
        GameRegistry.addRecipe(new ItemStack(ItemIDs.bulbLong.item, 1), "  B"," B ","B  ", 'B', new ItemStack(ItemIDs.bulb.item,1));

        //fibregloss
        GameRegistry.addRecipe(new ItemStack(BlockIDs.fiberGlass.block, 6, 2), "WGW", "GWG", "WGW", Character.valueOf('W'), Blocks.wool, Character.valueOf('G'), Blocks.glass_pane);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.fiberGlass.block, 2, 0), " W ", "FWF", " W ", Character.valueOf('W'), Blocks.planks, Character.valueOf('F'), BlockIDs.fiberGlass.block);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.fiberGlass.block, 2, 1), " F ", "WWW", " F ", Character.valueOf('W'), Blocks.planks, Character.valueOf('F'), BlockIDs.fiberGlass.block);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.fiberGlass.block, 1, 2), new ItemStack(BlockIDs.fiberGlass.block, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.fiberGlass.block, 1, 1), new ItemStack(BlockIDs.fiberGlass.block, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.fiberGlass.block, 1, 0), new ItemStack(BlockIDs.fiberGlass.block, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.fiberGlass.block, 1, 0), new ItemStack(BlockIDs.fiberGlass.block, 1, 1));

        //concretes
        GameRegistry.addRecipe(new ItemStack(BlockIDs.Concrete.block, 8), "SGS", "GRG", "SGS", Character.valueOf('S'), Blocks.sand, Character.valueOf('G'), Blocks.gravel, Character.valueOf('R'), new ItemStack(ItemIDs.quicklime.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.Concrete.block, 8), "SGS", "GAG", "SGS", Character.valueOf('S'), Blocks.sand, Character.valueOf('G'), Blocks.gravel, Character.valueOf('A'), new ItemStack(ItemIDs.aragoniteClump.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.layeredConcrete.block, 3), " C ", " C ", " C ", Character.valueOf('C'), BlockIDs.smoothCrete.block);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.smoothCrete.block, 4), new ItemStack(BlockIDs.Concrete.block, 1), new ItemStack(BlockIDs.Concrete.block, 1), new ItemStack(BlockIDs.Concrete.block, 1), new ItemStack(BlockIDs.Concrete.block, 1));

        //hariesh hell blocks
        //GameRegistry.addRecipe(new ItemStack(BlockIDs.emberStoneStair.block,8), "E  ","EE ","EEE", Character.valueOf('E'), new ItemStack(BlockIDs.emberStone.block,1));
        //GameRegistry.addRecipe(new ItemStack(BlockIDs.darkEmberStoneStair.block,8), "E  ","EE ","EEE", Character.valueOf('E'), new ItemStack(BlockIDs.darkEmberStone.block,1));
        GameRegistry.addSmelting(BlockIDs.emberStone.block, new ItemStack(BlockIDs.darkEmberStone.block,1),1F);

        //tiles
        for (ItemStack dyewhite : dyeWhite) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 0), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyewhite);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 0), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyewhite);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,0),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyewhite);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 0), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyewhite);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 0), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyewhite, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyelightgrey : dyeLightGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 1), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyelightgrey);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 1), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyelightgrey);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,1),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyelightgrey);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 1), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyelightgrey);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 1), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyelightgrey, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyegrey : dyeGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 2), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyegrey);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 2), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyegrey);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,2),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyegrey);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 2), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyegrey);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 2), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyegrey, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyeblack : dyeBlack) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 3), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeblack);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 3), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeblack);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,3),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyeblack);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 3), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeblack);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 3), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyeblack, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
         for (ItemStack dyebrown : dyeBrown) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 4), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyebrown);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 4), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyebrown);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,4),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyebrown);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 4), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyebrown);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 4), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyebrown, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
         for (ItemStack dyered : dyeRed) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 5), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyered);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 5), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyered);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,5),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyered);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 5), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyered);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 5), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyered, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyeorange : dyeOrange) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 6), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeorange);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 6), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeorange);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,6),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyeorange);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 6), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeorange);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 6), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyeorange, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyeyellow : dyeYellow) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 7), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeyellow);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 7), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeyellow);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,7),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyeyellow);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 7), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeyellow);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 7), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyeyellow, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyelime : dyeLime) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 8), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyelime);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 8), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyelime);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,8),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyelime);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 8), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyelime);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 8), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyelime, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyegreen : dyeGreen) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 9), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyegreen);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 9), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyegreen);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,9),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyegreen);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 9), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyegreen);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 9), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyegreen, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyelightblue : dyeLightBlue) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 10), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyelightblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 10), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyelightblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,10),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyelightblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 10), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyelightblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 10), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyelightblue, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyeblue : dyeBlue) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 11), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 11), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,11),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyeblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 12), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyeblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 11), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyeblue, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyecyan : dyeCyan) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 12), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyecyan);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 12), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyecyan);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,12),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyecyan);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 11), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyecyan);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 12), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyecyan, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyepink : dyePink) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 13), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyepink);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 13), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyepink);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,13),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyepink);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 13), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyepink);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 13), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyepink, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyemagenta : dyeMagenta) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 14), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyemagenta);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 14), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyemagenta);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,14),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyemagenta);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 14), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyemagenta);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 14), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyemagenta, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));}
        for (ItemStack dyepurple : dyePurple) { GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2.block, 6, 15), " S ", "SDS", " S ", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyepurple);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile4.block, 6, 15), "S S", "SDS", "S S", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyepurple);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.diamondTile.block,4,15),"A A"," B ","A A",Character.valueOf('A'),new ItemStack(ItemIDs.ceramic.item,1),Character.valueOf('B'),dyepurple);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tile2x2smooth.block, 6, 15), "SSS", " D ", "SSS", Character.valueOf('S'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('D'), dyepurple);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.terrocottaTiles.block, 6, 15), "SSS", "EDE", "SSS", 'S', new ItemStack(ItemIDs.ceramic.item, 1), 'D', dyepurple, 'E', new ItemStack(ItemIDs.enrichedClay.item, 1));
        }

        //subtile new recipes
        GameRegistry.addRecipe(new ItemStack(BlockIDs.subTile.block, 6, 0), "C C", "SDS", "C C", Character.valueOf('S'), new ItemStack(ItemIDs.aragoniteClump.item, 1), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item, 1), Character.valueOf('D'), new ItemStack(ItemIDs.ceramic.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.subTile.block, 4, 1), new ItemStack(BlockIDs.subTile.block, 1, 0), new ItemStack(BlockIDs.subTile.block, 1, 0), new ItemStack(BlockIDs.subTile.block, 1, 0), new ItemStack(BlockIDs.subTile.block, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.subTile.block, 4, 2), new ItemStack(BlockIDs.subTile.block, 1, 1), new ItemStack(BlockIDs.subTile.block, 1, 1), new ItemStack(BlockIDs.subTile.block, 1, 1), new ItemStack(BlockIDs.subTile.block, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.subTile.block, 4, 3), new ItemStack(BlockIDs.subTile.block, 1, 2), new ItemStack(BlockIDs.subTile.block, 1, 2), new ItemStack(BlockIDs.subTile.block, 1, 2), new ItemStack(BlockIDs.subTile.block, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.subTile.block, 4, 4), new ItemStack(BlockIDs.subTile.block, 1, 3), new ItemStack(BlockIDs.subTile.block, 1, 3), new ItemStack(BlockIDs.subTile.block, 1, 3), new ItemStack(BlockIDs.subTile.block, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.subTile.block, 4, 0), new ItemStack(BlockIDs.subTile.block, 1, 4), new ItemStack(BlockIDs.subTile.block, 1, 4), new ItemStack(BlockIDs.subTile.block, 1, 4), new ItemStack(BlockIDs.subTile.block, 1, 4));

        //enriched clay recipes
        GameRegistry.addRecipe(new ItemStack(ItemIDs.enrichedClay.item,8,0),"ABA","BCB","ABA",Character.valueOf('A'),new ItemStack(Blocks.dirt),Character.valueOf('B'),new ItemStack(Items.clay_ball),Character.valueOf('C'),new ItemStack(Items.water_bucket));
        GameRegistry.addRecipe(new ItemStack(ItemIDs.enrichedClay.item,8,0),"ABA","BCB","ABA",Character.valueOf('A'),new ItemStack(Blocks.dirt),Character.valueOf('B'),new ItemStack(Items.clay_ball),Character.valueOf('C'),new ItemStack(Blocks.ice));

        //ceramic recipe
        GameRegistry.addSmelting(ItemIDs.enrichedClay.item, new ItemStack(ItemIDs.ceramic.item,1),2F);

        //Cobalt Smelting
        GameRegistry.addSmelting(BlockIDs.cobaltOre.block, new ItemStack(ItemIDs.cobaltIngot.item,1),1F);
        for (ItemStack dye : dyeBlue) {
            GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.cobaltIngot.item,2), Items.iron_ingot, Items.iron_ingot, dye);
        }

        //cobalt deco blocks
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltBlock.block, 1, 0),"AAA","AAA","AAA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltBrick.block, 1, 0),"AA ","AA ","   ",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.largeCobaltBrick.block, 4, 0),"AA ","AA ","   ",Character.valueOf('A'), new ItemStack(BlockIDs.cobaltBrick.block));
        //cobalt panels
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 0),"BBB","AAA","BBB",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 1),"BAB","BAB","BAB",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 2),"BAB","AAA","BAB",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 3),"BAB","AAA","BBB",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 4),"BAB","BAA","BAB",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 5),"BBB","AAA","BAB",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 6),"BAB","AAB","BAB",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 7),"AAA","BBB","BBB",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 8),"BBA","BBA","BBA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 9),"BBB","BBB","AAA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 10),"ABB","ABB","ABB",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 11),"AAA","BBA","BBA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 12),"BBA","BBA","AAA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 13),"ABB","ABB","AAA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 14),"AAA","ABB","ABB",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel.block, 8, 15),"AAA","ABA","AAA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel2.block, 8, 0),"AAA","ABA","ABA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel2.block, 8, 1),"AAA","BBA","AAA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel2.block, 8, 2),"ABA","ABA","AAA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel2.block, 8, 3),"AAA","ABB","AAA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel2.block, 8, 4),"AAA","BBB","AAA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel2.block, 8, 5),"ABA","ABA","ABA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item),Character.valueOf('B'), new ItemStack(BlockIDs.cobaltBlock.block));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.cobaltPanel2.block, 8, 6),"AAA","AAA","AAA",Character.valueOf('A'), new ItemStack(ItemIDs.cobaltIngot.item));

        //p2 themed panneling
        GameRegistry.addSmelting(BlockIDs.soapStone.block, new ItemStack(ItemIDs.lowDensityCompound.item, 4), 2F);
        //white pannels
        for (ItemStack dyewhite : dyeWhite) { GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 0), "LLL", "LDL", "LLL", Character.valueOf('L'), new ItemStack(ItemIDs.lowDensityCompound.item), Character.valueOf('D'), dyewhite); }
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 15), "PPP","P P","PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 1), "PCP", "PCP", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 2), "PPP", "PCP", "PCP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 3), "PCP", "PCP", "PCP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 4), "PCC", "PCC", "PCC", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 5), "CCP", "CCP", "CCP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 6), "PPP", "CCC", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 7), "PPP", "CCC", "CCC", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 8), "CCC", "CCC", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 9), "PPP", "PCC", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 10), "PPP", "CCP", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 11), "PCC", "PCC", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 12), "PPP", "PCC", "PCC", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 13), "CCP", "CCP", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelWhite.block, 8, 14), "PPP", "CCP", "CCP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelExtra.block, 4, 1), "PC ","CP ", "   ", Character.valueOf('P'), new ItemStack(BlockIDs.pannelWhite.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        //blacc pannels
        for (ItemStack dyeblack : dyeBlack) { GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 0), "LLL", "LDL", "LLL", Character.valueOf('L'), new ItemStack(ItemIDs.lowDensityCompound.item), Character.valueOf('D'), dyeblack); }
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 15), "PPP","P P","PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 1), "PCP", "PCP", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 2), "PPP", "PCP", "PCP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 3), "PCP", "PCP", "PCP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 4), "PCC", "PCC", "PCC", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 5), "CCP", "CCP", "CCP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 6), "PPP", "CCC", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 7), "PPP", "CCC", "CCC", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 8), "CCC", "CCC", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 9), "PPP", "PCC", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 10), "PPP", "CCP", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 11), "PCC", "PCC", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 12), "PPP", "PCC", "PCC", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 13), "CCP", "CCP", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelBlack.block, 8, 14), "PPP", "CCP", "CCP", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelExtra.block, 4, 0), "PC ","CP ", "   ", Character.valueOf('P'), new ItemStack(BlockIDs.pannelBlack.block, 15), Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));
        //extras
        for (ItemStack dyewhite : dyeWhite){GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelExtra.block, 4, 3), "DC ","CD ", "   ", Character.valueOf('D'), dyewhite, Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));}
        for (ItemStack dyeyellow : dyeYellow){GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelExtra.block, 4, 2), "DC ","CD ", "   ", Character.valueOf('D'), dyeyellow, Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));}
        for (ItemStack dyered : dyeRed){GameRegistry.addRecipe(new ItemStack(BlockIDs.pannelExtra.block, 4, 4), "DC ","CD ", "   ", Character.valueOf('D'), dyered, Character.valueOf('C'), new ItemStack(ItemIDs.lowDensityCompound.item));}
        //rust beams
        for (ItemStack dyeyellow : dyeYellow) {GameRegistry.addRecipe(new ItemStack(BlockIDs.rustBeam.block, 3, 0), "RDR", "III", "RDR", Character.valueOf('R'), new ItemStack(ItemIDs.rust.item), Character.valueOf('D'), dyeyellow,Character.valueOf('I'), Items.iron_ingot);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.rustBeam.block, 3, 1), "RIR", "DID", "RIR", Character.valueOf('R'), new ItemStack(ItemIDs.rust.item), Character.valueOf('D'), dyeyellow,Character.valueOf('I'), Items.iron_ingot);}
        for (ItemStack dyeblue : dyeBlue) {GameRegistry.addRecipe(new ItemStack(BlockIDs.rustBeam.block, 3, 2), "RDR", "III", "RDR", Character.valueOf('R'), new ItemStack(ItemIDs.rust.item), Character.valueOf('D'), dyeblue,Character.valueOf('I'), Items.iron_ingot);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.rustBeam.block, 3, 3), "RIR", "DID", "RIR", Character.valueOf('R'), new ItemStack(ItemIDs.rust.item), Character.valueOf('D'), dyeblue,Character.valueOf('I'), Items.iron_ingot);}
        for (ItemStack dyered : dyeRed) {GameRegistry.addRecipe(new ItemStack(BlockIDs.rustBeam.block, 3, 4), "RDR", "III", "RDR", Character.valueOf('R'), new ItemStack(ItemIDs.rust.item), Character.valueOf('D'), dyered,Character.valueOf('I'), Items.iron_ingot);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.rustBeam.block, 3, 5), "RIR", "DID", "RIR", Character.valueOf('R'), new ItemStack(ItemIDs.rust.item), Character.valueOf('D'), dyered,Character.valueOf('I'), Items.iron_ingot);}

        //wide planks
        for (ItemStack dyewhite : dyeWhite) { GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 0), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyewhite);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 0), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyewhite);}
        for (ItemStack dyelightgray : dyeLightGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 1), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyelightgray);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 1), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyelightgray);}
        for (ItemStack dyegray : dyeGray) { GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 2), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyegray);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 2), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyegray); }
        for (ItemStack dyeblack : dyeBlack) { GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 3), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyeblack);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 3), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyeblack); }
        for (ItemStack dyebrown : dyeBrown) { GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 4), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyebrown);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 4), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyebrown); }
        for (ItemStack dyered : dyeRed) { GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 5), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyered);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 5), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyered); }
        for (ItemStack dyeorange : dyeOrange) {GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 6), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyeorange);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 6), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyeorange); }
        for (ItemStack dyeyellow : dyeYellow) {GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 7), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyeyellow);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 7), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyeyellow); }
        for (ItemStack dyelime : dyeLime) {GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 8), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyelime);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 8), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyelime); }
        for (ItemStack dyegreen : dyeGreen){GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 9), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyegreen);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 9), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyegreen); }
        for (ItemStack dyelightblue : dyeLightBlue){GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 10), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyelightblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 10), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyelightblue); }
        for (ItemStack dyeblue : dyeBlue){GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 11), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyeblue);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 11), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyeblue); }
        for (ItemStack dyecyan : dyeCyan){GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 12), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyecyan);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 12), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyecyan); }
        for (ItemStack dyepink : dyePink){GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 13), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyepink);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 13), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyepink); }
        for (ItemStack dyemagenta : dyeMagenta){GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 14), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyemagenta);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 14), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyemagenta); }
        for (ItemStack dyepurple : dyePurple){GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank.block, 7, 15), "WWW", "DWD", "WWW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyepurple);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank2.block, 7, 15), "WDW", "WWW", "WDW", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dyepurple); }

        GameRegistry.addSmelting(BlockIDs.aragoniteOre.block, new ItemStack(ItemIDs.aragoniteClump.item, 2), 3F);

        //amtrak wood
        for (ItemStack dye1 : dyeGray){
            GameRegistry.addRecipe(new ItemStack(BlockIDs.amtrak.block, 6, 0), "WDW", "W W", "W W", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dye1);
            for (ItemStack dye2 : dyeBlue){
                GameRegistry.addRecipe(new ItemStack(BlockIDs.amtrak.block, 6, 1), "WDW", "W W", "W2W", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dye1, Character.valueOf('2'), dye2);
                for (ItemStack dye3 : dyeRed){
                    GameRegistry.addRecipe(new ItemStack(BlockIDs.amtrak.block, 6, 2), "WDW", "W3W", "W2W", Character.valueOf('W'), Blocks.planks, Character.valueOf('D'), dye1, Character.valueOf('2'), dye2, Character.valueOf('3'), dye3);
                }
            }
        }

        //crafting items
        GameRegistry.addRecipe(new ItemStack(ItemIDs.ironRod.item, 16), "  I", "AIA", "I  ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('A'), new ItemStack(ItemIDs.aragoniteClump.item, 1));
        GameRegistry.addRecipe(new ItemStack(ItemIDs.ironSlice.item, 16), "IAI", "A A", "IAI", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('A'), new ItemStack(ItemIDs.aragoniteClump.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.woodSealant.item, 16), Items.glass_bottle, Items.water_bucket, new ItemStack(ItemIDs.enrichedClay.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.woodSealant.item, 16), Items.glass_bottle, Blocks.ice, new ItemStack(ItemIDs.enrichedClay.item, 1));
        GameRegistry.addShapedRecipe(new ItemStack(ItemIDs.computerizedCircuit.item, 4), "RAI","CRC","ARI", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('A'), new ItemStack(ItemIDs.aragoniteClump.item, 1), Character.valueOf('C'), new ItemStack(ItemIDs.ceramic.item, 1), Character.valueOf('R'), Items.redstone);
        GameRegistry.addRecipe(new ItemStack(ItemIDs.bolsterChisel.item, 1), "  A", " I ", "I  ", Character.valueOf('A'), Items.iron_ingot, Character.valueOf('I'), new ItemStack(ItemIDs.ironRod.item, 1));

        //breakerboxes
        for (ItemStack dye1 : dyeLightGray){
            for (ItemStack ironoredict : iron){
            GameRegistry.addRecipe(new ItemStack(BlockIDs.breakerBox.block, 1), "IAI", "ICI", "IDI", 'I', ironoredict, 'A',new ItemStack(ItemIDs.aragoniteClump.item, 1), 'D', dye1, 'C', new ItemStack(ItemIDs.computerizedCircuit.item, 1));
            }
        }
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.breakerBox2.block, 1), new ItemStack(BlockIDs.breakerBox.block, 1));

        //signage
        for (ItemStack dye1 : dyeBlue){
            for (ItemStack dye2 : dyeYellow) {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.clampOnSignDerail.block, 1), " PB", "YS ", "S  ", Character.valueOf('P'), new ItemStack(ItemIDs.ironSlice.item), Character.valueOf('S'), new ItemStack(ItemIDs.ironRod.item), Character.valueOf('B'), dye1, Character.valueOf('Y'), dye2);
            }
        }
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.clampOnSignStop1.block, 1), new ItemStack(BlockIDs.clampOnSignDerail.block,1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.clampOnSignStop2.block, 1), new ItemStack(BlockIDs.clampOnSignStop1.block,1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.clampOnSignDerail.block, 1), new ItemStack(BlockIDs.clampOnSignStop2.block,1));
        //wayside warnings
        for (ItemStack dye: dyeGreen) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.waysideWarningSignGreen.block, 1), "DPD", " S ", " S ", Character.valueOf('P'), new ItemStack(ItemIDs.ironSlice.item), Character.valueOf('S'), new ItemStack(ItemIDs.ironRod.item), Character.valueOf('D'), dye);
        }
        for (ItemStack dye: dyeRed) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.waysideWarningSignRed.block, 1), "DPD", " S ", " S ", Character.valueOf('P'), new ItemStack(ItemIDs.ironSlice.item), Character.valueOf('S'), new ItemStack(ItemIDs.ironRod.item), Character.valueOf('D'), dye);
        }
        for (ItemStack dye: dyeYellow) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.waysideWarningSignYellow.block, 1), "DPD", " S ", " S ", Character.valueOf('P'), new ItemStack(ItemIDs.ironSlice.item), Character.valueOf('S'), new ItemStack(ItemIDs.ironRod.item), Character.valueOf('D'), dye);
        }
        for (ItemStack dye: dyeYellow) {
            for (ItemStack dye2: dyeRed) {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.waysideWarningSignYellowRed.block, 1), "DPH", " S ", " S ", Character.valueOf('P'), new ItemStack(ItemIDs.ironSlice.item), Character.valueOf('S'), new ItemStack(ItemIDs.ironRod.item), Character.valueOf('D'), dye, Character.valueOf('H'), dye2);
            }
        }

        //cage lamps
        GameRegistry.addRecipe(new ItemStack(BlockIDs.neonCageLightRoof.block, 1), "SGS", " G ", "SGS", 'S', new ItemStack(ItemIDs.ironRod.item), 'G', new ItemStack(ItemIDs.bulbLong.item));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.neonCageLightWallV.block, 1),  new ItemStack(BlockIDs.neonCageLightRoof.block, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.neonCageLightWallH.block, 1), new ItemStack(BlockIDs.neonCageLightWallV.block, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.neonCageLightRoof.block, 1), new ItemStack(BlockIDs.neonCageLightWallH.block, 1));

        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.ExteriorLightSquare.block, 1), new ItemStack(ItemIDs.ironSlice.item, 1), new ItemStack(ItemIDs.bulb.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.ExteriorLightSquare2.block, 1), new ItemStack(ItemIDs.ironSlice.item, 1), new ItemStack(ItemIDs.bulb.item, 1), new ItemStack(ItemIDs.ironSlice.item, 1));

        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.fakeSnow.block, 4), Blocks.snow, Blocks.snow, Blocks.snow, Blocks.snow);

        //wall plaster
        GameRegistry.addRecipe(new ItemStack(BlockIDs.plasteredConcrete.block, 8, 0), "GAG", "AQA", "GAG", Character.valueOf('G'), new ItemStack(ItemIDs.gypsumDust.item), Character.valueOf('A'), new ItemStack(ItemIDs.aragoniteClump.item), Character.valueOf('Q'), new ItemStack(ItemIDs.quicklime.item));
        for (ItemStack dye : dyeLightBlue) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.plasteredConcrete.block, 8, 1), "PPP", "PDP", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.plasteredConcrete.block, 1, 0), Character.valueOf('D'), dye);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.plasteredConcrete.block, 3, 2), "   ", "D D", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.plasteredConcrete.block, 1, 0), Character.valueOf('D'), dye);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.plasteredConcrete.block, 3, 3), "   ", " D ", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.plasteredConcrete.block, 1, 0), Character.valueOf('D'), dye);
        }//full color, thick, thin
        for (ItemStack dye : dyeRed) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.plasteredConcrete.block, 8, 4), "PPP", "PDP", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.plasteredConcrete.block, 1, 0), Character.valueOf('D'), dye);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.plasteredConcrete.block, 3, 5), "   ", "D D", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.plasteredConcrete.block, 1, 0), Character.valueOf('D'), dye);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.plasteredConcrete.block, 3, 6), "   ", " D ", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.plasteredConcrete.block, 1, 0), Character.valueOf('D'), dye);
        }
        for (ItemStack dye : dyeRed) {
            for (ItemStack dye2 : dyeBrown) {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.plasteredConcrete.block, 7, 7), "PDP", "PPP", "PBP", Character.valueOf('P'), new ItemStack(BlockIDs.plasteredConcrete.block, 1, 0), Character.valueOf('D'), dye, Character.valueOf('B'), dye2);
            }
        }
        for (ItemStack dye : dyeLightGray) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.plasteredConcrete.block, 8, 8), "PPP", "PDP", "PPP", Character.valueOf('P'), new ItemStack(BlockIDs.plasteredConcrete.block, 1, 0), Character.valueOf('D'), dye);
        }

        //tf2 concrete bricks
        for (ItemStack dye : dyeBlue) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.concreteBrick.block, 8, 0), "CCC", "CDC", "CCC", 'C', new ItemStack(BlockIDs.smoothCrete.block), 'D', dye);
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.concreteBrick.block, 4, 2), new ItemStack(BlockIDs.concreteBrick.block, 1, 0), new ItemStack(BlockIDs.concreteBrick.block, 1, 0), new ItemStack(BlockIDs.concreteBrick.block, 1, 0), new ItemStack(BlockIDs.concreteBrick.block, 1, 0), dye);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.concreteBrick.block, 8, 5), "CCC", "CDC", "CCC", 'C', new ItemStack(BlockIDs.concreteBrick.block, 1, 4), 'D', dye);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.concreteBrick.block, 8, 7), "CCC", "CDC", "CCC", 'C', new ItemStack(BlockIDs.concreteBrick.block, 1, 0), 'D', dye);
        }
        for (ItemStack dye : dyeRed) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.concreteBrick.block, 8, 1), "CCC", "CDC", "CCC", 'C', new ItemStack(BlockIDs.smoothCrete.block), 'D', dye);
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.concreteBrick.block, 4, 3), new ItemStack(BlockIDs.concreteBrick.block, 1, 1), new ItemStack(BlockIDs.concreteBrick.block, 1, 1), new ItemStack(BlockIDs.concreteBrick.block, 1, 1), new ItemStack(BlockIDs.concreteBrick.block, 1, 1), dye);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.concreteBrick.block, 8, 6), "CCC", "CDC", "CCC", 'C', new ItemStack(BlockIDs.concreteBrick.block, 1, 4), 'D', dye);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.concreteBrick.block, 8, 8), "CCC", "CDC", "CCC", 'C', new ItemStack(BlockIDs.concreteBrick.block, 1, 1), 'D', dye);
        }
        GameRegistry.addRecipe(new ItemStack(BlockIDs.concreteBrick.block, 8, 4), "CCC", "C C", "CCC", Character.valueOf('C'), new ItemStack(BlockIDs.layeredConcrete.block));

        //kronkcrete floorin
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.concreteFloor.block, 4, 0), new ItemStack(BlockIDs.smoothCrete.block), new ItemStack(BlockIDs.smoothCrete.block), new ItemStack(BlockIDs.smoothCrete.block), new ItemStack(BlockIDs.smoothCrete.block));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.concreteFloor.block, 4, 1), new ItemStack(BlockIDs.smoothCrete.block, 2), new ItemStack(BlockIDs.Concrete.block, 2), new ItemStack(BlockIDs.smoothCrete.block), new ItemStack(BlockIDs.Concrete.block, 2));
        for (ItemStack dye : dyeRed) {
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.concreteFloor.block, 4, 2), new ItemStack(BlockIDs.smoothCrete.block), dye, new ItemStack(BlockIDs.smoothCrete.block), new ItemStack(BlockIDs.smoothCrete.block), new ItemStack(BlockIDs.smoothCrete.block));
        }
        for (ItemStack dye : dyeBlue) {
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.concreteFloor.block, 4, 3), new ItemStack(BlockIDs.smoothCrete.block), dye, new ItemStack(BlockIDs.smoothCrete.block), new ItemStack(BlockIDs.smoothCrete.block), new ItemStack(BlockIDs.smoothCrete.block));
        }
        for (ItemStack dye : dyeGray) {
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.concreteFloor.block, 4, 4), new ItemStack(BlockIDs.smoothCrete.block), dye, new ItemStack(BlockIDs.smoothCrete.block), new ItemStack(BlockIDs.smoothCrete.block), new ItemStack(BlockIDs.smoothCrete.block));
        }

        //labwall
        for (ItemStack dye : dyeWhite) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.labwallLight.block, 8, 0), "SAS", "ADA", "SAS", Character.valueOf('S'), ItemIDs.lowDensityCompound.item, Character.valueOf('A'), ItemIDs.aragoniteClump.item, Character.valueOf('D'), dye);
        }
        GameRegistry.addRecipe(new ItemStack(BlockIDs.labwallLight.block, 4, 1), "L L", "L L", "   ", Character.valueOf('L'), new ItemStack(BlockIDs.labwallLight.block, 1, 0));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.labwallLight.block, 6, 2), "LLL", "   ", "LLL", Character.valueOf('L'), new ItemStack(BlockIDs.labwallLight.block, 1, 0));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.labwallLight.block, 7, 3), "LLL", " V ", "LLL", Character.valueOf('L'), new ItemStack(BlockIDs.labwallLight.block, 1, 0), Character.valueOf('V'), new ItemStack(BlockIDs.labwallLight.block, 1, 1));
        for (ItemStack dye : dyeLightGray) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.labwallDark.block, 8, 0), "SAS", "ADA", "SAS", Character.valueOf('S'), ItemIDs.lowDensityCompound.item, Character.valueOf('A'), ItemIDs.aragoniteClump.item, Character.valueOf('D'), dye);
        }
        GameRegistry.addRecipe(new ItemStack(BlockIDs.labwallDark.block, 6, 1), "LLL", "   ", "LLL", Character.valueOf('L'), new ItemStack(BlockIDs.labwallDark.block, 1, 0));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.labwallDark.block, 6, 2), "L L", "L L", "L L", Character.valueOf('L'), new ItemStack(BlockIDs.labwallDark.block, 1, 0));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.labwallDark.block, 4, 3), "V V", "V V", "   ", Character.valueOf('V'), new ItemStack(BlockIDs.labwallDark.block, 1, 2));

        //glass blocks
        GameRegistry.addRecipe(new ItemStack(BlockIDs.glassAssorted.block, 3, 0), "   ", "GGG", "   ", Character.valueOf('G'), new ItemStack(Blocks.glass));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.glassAssorted.block, 3, 1), " G ", " G ", " G ", Character.valueOf('G'), new ItemStack(Blocks.glass));
        for (ItemStack dye : dyeBrown) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.glassAssorted.block, 8, 2), "GDG", "GGG", "GGG", Character.valueOf('G'), new ItemStack(Blocks.glass), Character.valueOf('D'), dye);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.glassAssorted.block, 8, 3), "GGG", "GGG", "GDG", Character.valueOf('G'), new ItemStack(Blocks.glass), Character.valueOf('D'), dye);
        }

        //wide vanilla planks wide planks
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 0), " P ", " PW", " P ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 0), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 1), " P ", " PW", " P ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 2), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 2), " P ", " PW", " P ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 1), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 3), " P ", " PW", " P ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 3), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 4), " P ", " PW", " P ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 5), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 5), " P ", " PW", " P ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 4), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 6), "   ", "PPP", " W ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 0), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 7), "   ", "PPP", " W ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 2), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 8), "   ", "PPP", " W ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 1), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 9), "   ", "PPP", " W ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 3), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 10), "   ", "PPP", " W ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 5), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 11), "   ", "PPP", " W ", Character.valueOf('P'), new ItemStack(Blocks.planks, 1, 4), Character.valueOf('W'), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 12), " P ", " PW", " P ", 'P', new ItemStack(BlockIDs.planks1.block, 1, 0), 'W', new ItemStack(ItemIDs.woodSealant.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 13), " P ", " PW", " P ", 'P', new ItemStack(BlockIDs.planks1.block, 1, 1), 'W', new ItemStack(ItemIDs.woodSealant.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 14), "   ", "PPP", " W ", 'P', new ItemStack(BlockIDs.planks1.block, 1, 0), 'W', new ItemStack(ItemIDs.woodSealant.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank3.block, 3, 15), "   ", "PPP", " W ", 'P', new ItemStack(BlockIDs.planks1.block, 1, 1), 'W', new ItemStack(ItemIDs.woodSealant.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank4.block, 3, 0), " P ", " PW", " P ", 'P', new ItemStack(BlockIDs.planks1.block, 1, 2), 'W', new ItemStack(ItemIDs.woodSealant.item));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.widePlank4.block, 3, 1), "   ", "PPP", " W ", 'P', new ItemStack(BlockIDs.planks1.block, 1, 2), 'W', new ItemStack(ItemIDs.woodSealant.item));

        //actual wooden planks
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.planks1.block, 4, 0), new ItemStack(BlockIDs.logs.block, 1 ,0));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.planks1.block, 4, 1), new ItemStack(BlockIDs.logs.block, 1 ,1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.planks1.block, 4, 2), new ItemStack(BlockIDs.logs.block, 1 ,2));

        //origin stuff
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.originStuff.block, 2, 0), new ItemStack(ItemIDs.enrichedClay.item), Blocks.cobblestone, Blocks.cobblestone);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.originStuff.block, 2, 1), new ItemStack(ItemIDs.enrichedClay.item), Blocks.mossy_cobblestone, Blocks.mossy_cobblestone);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.originStuff.block, 2, 2), new ItemStack(ItemIDs.enrichedClay.item), Blocks.brick_block, Blocks.brick_block);

        //ore processing
        GameRegistry.addSmelting(BlockIDs.hematite.block, new ItemStack(Items.iron_ingot, 3), 3F);//hematite to ingot
        GameRegistry.addSmelting(BlockIDs.limestone.block, new ItemStack(ItemIDs.quicklime.item, 2), 0F);//limestone to quicklime
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.taconitePellets.item, 2), new ItemStack(ItemIDs.taconiteCrushed.item, 1), Items.clay_ball);// crushed taconite to taconite pellets
        GameRegistry.addSmelting(ItemIDs.taconitePellets.item, new ItemStack(Items.iron_ingot, 1), 2F);//pellets to ingots

        //cream city crap
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.creamCity.block, 8, 0), new ItemStack(BlockIDs.creamCityClay.block), new ItemStack(BlockIDs.creamCityClay.block), new ItemStack(BlockIDs.creamCityClay.block), new ItemStack(BlockIDs.creamCityClay.block));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.creamCity.block, 4, 1), new ItemStack(BlockIDs.creamCity.block, 1, 0), new ItemStack(BlockIDs.creamCity.block, 1, 0), new ItemStack(BlockIDs.creamCity.block, 1, 0), new ItemStack(BlockIDs.creamCity.block, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.creamCity.block, 4, 2), new ItemStack(BlockIDs.creamCity.block, 1, 1), new ItemStack(BlockIDs.creamCity.block, 1, 1), new ItemStack(BlockIDs.creamCity.block, 1, 1), new ItemStack(BlockIDs.creamCity.block, 1, 1));

        //joliet limstoen
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.jolietLimestone.block, 8, 0), new ItemStack(BlockIDs.jolietLimestoneRaw.block), new ItemStack(BlockIDs.jolietLimestoneRaw.block), new ItemStack(BlockIDs.jolietLimestoneRaw.block), new ItemStack(BlockIDs.jolietLimestoneRaw.block));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.jolietLimestone.block, 4, 2), new ItemStack(BlockIDs.jolietLimestone.block, 1, 0), new ItemStack(BlockIDs.jolietLimestone.block, 1, 0), new ItemStack(BlockIDs.jolietLimestone.block, 1, 0), new ItemStack(BlockIDs.jolietLimestone.block, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.jolietLimestone.block, 4, 1), new ItemStack(BlockIDs.jolietLimestone.block, 1, 0), new ItemStack(BlockIDs.jolietLimestone.block, 1, 0), new ItemStack(BlockIDs.jolietLimestone.block, 1, 2), new ItemStack(BlockIDs.jolietLimestone.block, 1, 2));
        //GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.jolietLimestone.block, 8, 3), new ItemStack(BlockIDs.jolietLimestone.block, 1, 2), new ItemStack(BlockIDs.jolietLimestone.block, 1, 2), new ItemStack(BlockIDs.jolietLimestone.block, 1, 2), new ItemStack(BlockIDs.jolietLimestone.block, 1, 2));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.jolietLimestone.block, 8, 3), "BBB", "BMB", "BBB", 'B', new ItemStack(BlockIDs.jolietLimestone.block, 1, 2), 'M', new ItemStack(Blocks.vine));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.jolietLimestone.block, 8, 4), "BBB", "BCB", "BBB", 'B', new ItemStack(BlockIDs.jolietLimestone.block, 1, 2), 'C', new ItemStack(ItemIDs.bolsterChisel.item));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.jolietLimestone.block, 8, 5), new ItemStack(BlockIDs.jolietLimestoneRaw.block), new ItemStack(BlockIDs.jolietLimestoneRaw.block), new ItemStack(BlockIDs.jolietLimestoneRaw.block), new ItemStack(BlockIDs.jolietLimestoneRaw.block), new ItemStack(ItemIDs.bolsterChisel.item));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.jolietLimestone.block, 4, 6), new ItemStack(BlockIDs.jolietLimestone.block, 1, 5), new ItemStack(BlockIDs.jolietLimestone.block, 1, 5), new ItemStack(BlockIDs.jolietLimestone.block, 1, 5), new ItemStack(BlockIDs.jolietLimestone.block, 1, 5), new ItemStack(ItemIDs.bolsterChisel.item));

        //road stuff
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.roadTar.item, 8), new ItemStack(Blocks.gravel), new ItemStack(BlockIDs.Concrete.block),new ItemStack(Blocks.sand),new ItemStack(Items.coal));

        GameRegistry.addRecipe(new ItemStack(BlockIDs.tarmac.block, 16, 0), "TTT", "GGG", "   ", Character.valueOf('G'), new ItemStack(Blocks.gravel), Character.valueOf('T'), new ItemStack(ItemIDs.roadTar.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.tarmac.block, 4, 1), new ItemStack(Blocks.stone), new ItemStack(BlockIDs.tarmac.block, 1, 0),new ItemStack(Blocks.stone), new ItemStack(BlockIDs.tarmac.block, 1, 0));
        for (ItemStack dye : dyeBlack) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tarmac.block, 16, 2), "TTT", "GGG", " D ", Character.valueOf('G'), new ItemStack(Blocks.gravel), Character.valueOf('T'), new ItemStack(ItemIDs.roadTar.item, 1), Character.valueOf('D'), dye); }
        for (ItemStack dye : dyeGray) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tarmac.block, 16, 3), "TTT", "GGG", " D ", Character.valueOf('G'), new ItemStack(Blocks.gravel), Character.valueOf('T'), new ItemStack(ItemIDs.roadTar.item, 1), Character.valueOf('D'), dye); }
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.tarmac.block, 4, 4), new ItemStack(BlockIDs.Concrete.block), new ItemStack(BlockIDs.tarmac.block, 1, 0),new ItemStack(BlockIDs.Concrete.block), new ItemStack(BlockIDs.tarmac.block, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.tarmac.block, 4, 5), new ItemStack(BlockIDs.tarmac.block, 1, 4), new ItemStack(BlockIDs.tarmac.block, 1, 0),new ItemStack(BlockIDs.tarmac.block, 1, 4), new ItemStack(BlockIDs.tarmac.block, 1, 0));
        for (ItemStack dye : dyeLightGray) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tarmac.block, 16, 6), "TTT", "GGG", " D ", Character.valueOf('G'), new ItemStack(Blocks.gravel), Character.valueOf('T'), new ItemStack(ItemIDs.roadTar.item, 1), Character.valueOf('D'), dye); }
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.tarmac.block, 4, 7), new ItemStack(Blocks.dirt), new ItemStack(BlockIDs.specialDirt.block, 1, 0),new ItemStack(Blocks.dirt), new ItemStack(BlockIDs.specialDirt.block, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.tarmac.block, 4, 8), new ItemStack(BlockIDs.specialDirt.block, 1),new ItemStack(Blocks.ice), new ItemStack(BlockIDs.specialDirt.block, 1), new ItemStack(BlockIDs.specialDirt.block, 1), new ItemStack(BlockIDs.specialDirt.block, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.tarmac.block, 4, 8), new ItemStack(BlockIDs.specialDirt.block, 1),new ItemStack(Items.water_bucket), new ItemStack(BlockIDs.specialDirt.block, 1), new ItemStack(BlockIDs.specialDirt.block, 1), new ItemStack(BlockIDs.specialDirt.block, 1));
        for (ItemStack dye : dyeBlue) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tarmac.block, 16, 9), "TTT", "GGG", " D ", Character.valueOf('G'), new ItemStack(Blocks.gravel), Character.valueOf('T'), new ItemStack(ItemIDs.roadTar.item, 1), Character.valueOf('D'), dye); }
        for (ItemStack dye : dyeGreen) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tarmac.block, 16, 10), "TTT", "GGG", " D ", Character.valueOf('G'), new ItemStack(Blocks.gravel), Character.valueOf('T'), new ItemStack(ItemIDs.roadTar.item, 1), Character.valueOf('D'), dye); }
        for (ItemStack dye : dyeRed) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tarmac.block, 16, 11), "TTT", "GGG", " D ", Character.valueOf('G'), new ItemStack(Blocks.gravel), Character.valueOf('T'), new ItemStack(ItemIDs.roadTar.item, 1), Character.valueOf('D'), dye); }
        for (ItemStack dye : dyeWhite) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tarmac.block, 16, 12), "TTT", "GGG", " D ", Character.valueOf('G'), new ItemStack(Blocks.gravel), Character.valueOf('T'), new ItemStack(ItemIDs.roadTar.item, 1), Character.valueOf('D'), dye); }
        for (ItemStack dye : dyeYellow) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.tarmac.block, 16, 13), "TTT", "GGG", " D ", Character.valueOf('G'), new ItemStack(Blocks.gravel), Character.valueOf('T'), new ItemStack(ItemIDs.roadTar.item, 1), Character.valueOf('D'), dye); }

        //mortar brick
        for (ItemStack dye : dyeBrown) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.mortarBrick.block, 16, 0), "BCB", "CDC", "BCB", 'B', new ItemStack(Items.brick), 'D', dye, 'C', new ItemStack(ItemIDs.ceramic.item, 1));
        }
        for (ItemStack dye : dyeGray) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.mortarBrick.block, 16, 1), "BCB", "CDC", "BCB", 'B', new ItemStack(Items.brick), 'D', dye, 'C', new ItemStack(ItemIDs.ceramic.item, 1));
        }
        for (ItemStack dye : dyeLightGray) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.mortarBrick.block, 16, 2), "BCB", "CDC", "BCB", 'B', new ItemStack(Items.brick), 'D', dye, 'C', new ItemStack(ItemIDs.ceramic.item, 1));
        }//these recipes are crap but hey whatever
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick.block, 8, 3), new ItemStack(BlockIDs.mortarBrick.block, 1, 0), new ItemStack(BlockIDs.mortarBrick.block, 1, 0), new ItemStack(BlockIDs.mortarBrick.block, 1, 0), new ItemStack(BlockIDs.mortarBrick.block, 1, 0), new ItemStack(BlockIDs.mortarBrick.block, 1, 0), new ItemStack(BlockIDs.mortarBrick.block, 1, 0), new ItemStack(BlockIDs.mortarBrick.block, 1, 0), new ItemStack(BlockIDs.mortarBrick.block, 1, 0), new ItemStack(ItemIDs.enrichedClay.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick.block, 8, 4), new ItemStack(BlockIDs.mortarBrick.block, 1, 1), new ItemStack(BlockIDs.mortarBrick.block, 1, 1), new ItemStack(BlockIDs.mortarBrick.block, 1, 1), new ItemStack(BlockIDs.mortarBrick.block, 1, 1), new ItemStack(BlockIDs.mortarBrick.block, 1, 1), new ItemStack(BlockIDs.mortarBrick.block, 1, 1), new ItemStack(BlockIDs.mortarBrick.block, 1, 1), new ItemStack(BlockIDs.mortarBrick.block, 1, 1), new ItemStack(ItemIDs.enrichedClay.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick.block, 8, 5), new ItemStack(BlockIDs.mortarBrick.block, 1, 2), new ItemStack(BlockIDs.mortarBrick.block, 1, 2), new ItemStack(BlockIDs.mortarBrick.block, 1, 2), new ItemStack(BlockIDs.mortarBrick.block, 1, 2), new ItemStack(BlockIDs.mortarBrick.block, 1, 2), new ItemStack(BlockIDs.mortarBrick.block, 1, 2), new ItemStack(BlockIDs.mortarBrick.block, 1, 2), new ItemStack(BlockIDs.mortarBrick.block, 1, 2), new ItemStack(ItemIDs.enrichedClay.item, 1));
        for (ItemStack dye : dyeOrange) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.mortarBrick.block, 16, 6), "BCB", "CDC", "BCB", 'B', new ItemStack(Items.brick), 'D', dye, 'C', new ItemStack(ItemIDs.ceramic.item, 1));
        }
        for (ItemStack dye : dyeRed) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.mortarBrick.block, 16, 7), "BCB", "CDC", "BCB", 'B', new ItemStack(Items.brick), 'D', dye, 'C', new ItemStack(ItemIDs.ceramic.item, 1));
        }
        for (ItemStack dye : dyeWhite) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.mortarBrick.block, 16, 8), "BCB", "CDC", "BCB", 'B', new ItemStack(Items.brick), 'D', dye, 'C', new ItemStack(ItemIDs.ceramic.item, 1));
            GameRegistry.addRecipe(new ItemStack(BlockIDs.mortarBrick.block, 8, 11), "BBB", "BWB", "BBB", 'B', new ItemStack(Items.brick), 'W', dye);
        }
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick.block, 4, 9), new ItemStack(Blocks.sandstone), new ItemStack(Blocks.brick_block), new ItemStack(Blocks.sandstone), new ItemStack(Blocks.brick_block));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick.block, 1, 10), new ItemStack(BlockIDs.mortarBrick.block,1,9));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick.block, 1, 12), new ItemStack(BlockIDs.mortarBrick.block,1,11));
        for (ItemStack dye : dyePink) {
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick.block, 4, 13), new ItemStack(Blocks.brick_block), new ItemStack(Blocks.brick_block), new ItemStack(Blocks.brick_block), new ItemStack(Blocks.brick_block), dye);
        }
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick.block, 1, 14), new ItemStack(BlockIDs.mortarBrick.block,1,13));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick.block, 4, 15), new ItemStack(BlockIDs.mortarBrick.block,1,13), new ItemStack(BlockIDs.mortarBrick.block,1,13), new ItemStack(BlockIDs.mortarBrick.block,1,13), new ItemStack(BlockIDs.mortarBrick.block,1,13));

        //GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick2.block, 1, 0), new ItemStack(BlockIDs.mortarBrick.block,1,15));//old recipe
        GameRegistry.addRecipe(new ItemStack(BlockIDs.mortarBrick2.block, 16, 0), "BCB", "CDC", "BCB", 'B', new ItemStack(Items.brick), 'D', new ItemStack(ItemIDs.enrichedClay.item), 'C', new ItemStack(ItemIDs.ceramic.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick2.block, 2, 1), new ItemStack(BlockIDs.mortarBrick2.block,1,0), new ItemStack(BlockIDs.mortarBrick2.block,1,0));
        for (ItemStack dye : dyeWhite) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.mortarBrick2.block, 16, 2), "BCB", "CDC", "BCB", 'B', new ItemStack(Items.brick), 'D', dye, 'C', new ItemStack(ItemIDs.ceramic.item, 1));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick2.block, 2, 3), new ItemStack(BlockIDs.mortarBrick2.block,1,2), new ItemStack(BlockIDs.mortarBrick2.block,1,2));
        for (ItemStack dye : dyeRed) {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.mortarBrick2.block, 16, 4), "BCB", "CDC", "BCB", 'B', new ItemStack(Items.brick), 'D', dye, 'C', new ItemStack(ItemIDs.ceramic.item, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick2.block, 8, 6), new ItemStack(BlockIDs.mortarBrick2.block, 1, 4), new ItemStack(BlockIDs.mortarBrick2.block, 1, 4), new ItemStack(BlockIDs.mortarBrick2.block, 1, 4), new ItemStack(BlockIDs.mortarBrick2.block, 1, 4), new ItemStack(BlockIDs.mortarBrick2.block, 1, 4), new ItemStack(BlockIDs.mortarBrick2.block, 1, 4), new ItemStack(BlockIDs.mortarBrick2.block, 1, 4), new ItemStack(BlockIDs.mortarBrick2.block, 1, 4));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick2.block, 2, 5), new ItemStack(BlockIDs.mortarBrick2.block,1,4), new ItemStack(BlockIDs.mortarBrick2.block,1,4));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.mortarBrick2.block, 2, 7), new ItemStack(BlockIDs.mortarBrick2.block,1,6), new ItemStack(BlockIDs.mortarBrick2.block,1,6));



        //vents
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wornVent.block, 8), "PPP","RRR","PPP", 'P', new ItemStack(ItemIDs.ironSlice.item, 1), 'R', new ItemStack(ItemIDs.ironRod.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.wornVent2.block, 2), new ItemStack(BlockIDs.wornVent.block, 1), new ItemStack(BlockIDs.wornVent.block, 1));

        GameRegistry.addRecipe(new ItemStack(BlockIDs.scaffold.block, 8), "RPR","PRP","RPR", 'P', new ItemStack(ItemIDs.ironSlice.item, 1), 'R', new ItemStack(ItemIDs.ironRod.item, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.scaffold2.block, 8), "RPR","PPP","RPR", 'P', new ItemStack(ItemIDs.ironSlice.item, 1), 'R', new ItemStack(ItemIDs.ironRod.item, 1));

        //doors
        GameRegistry.addRecipe(new ItemStack(ItemIDs.doorA.item, 1), "WW ", "WWS", "WW ", 'W', new ItemStack(Blocks.planks), 'S', new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.doorB.item, 1), new ItemStack(ItemIDs.doorA.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.doorA.item, 1), new ItemStack(ItemIDs.doorB.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.doorC.item, 1),Items.iron_door);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.doorD.item, 1),new ItemStack(ItemIDs.doorC.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.doorE.item, 1),new ItemStack(ItemIDs.doorD.item, 1));

        //plywood
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 8, 0), new ItemStack(Blocks.log, 1, 0), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 8, 2), new ItemStack(Blocks.log, 1, 1), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 8, 1), new ItemStack(Blocks.log, 1, 2), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 8, 3), new ItemStack(Blocks.log, 1, 3), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 8, 5), new ItemStack(Blocks.log2, 1, 0), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 8, 4), new ItemStack(Blocks.log2, 1, 1), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 4, 6), new ItemStack(BlockIDs.plywood.block, 1, 0), new ItemStack(BlockIDs.plywood.block, 1, 0), new ItemStack(BlockIDs.plywood.block, 1, 0), new ItemStack(BlockIDs.plywood.block, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 4, 7), new ItemStack(BlockIDs.plywood.block, 1, 6), new ItemStack(BlockIDs.plywood.block, 1, 6), new ItemStack(BlockIDs.plywood.block, 1, 6), new ItemStack(BlockIDs.plywood.block, 1, 6));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 8, 8), new ItemStack(BlockIDs.logs.block, 1, 0), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 8, 9), new ItemStack(BlockIDs.logs.block, 1, 1), new ItemStack(ItemIDs.woodSealant.item, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.plywood.block, 8, 10), new ItemStack(BlockIDs.logs.block, 1, 2), new ItemStack(ItemIDs.woodSealant.item, 1));

        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 0), new ItemStack(BlockIDs.plywood.block, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 1), new ItemStack(BlockIDs.plywood.block, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 2), new ItemStack(BlockIDs.plywood.block, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 3), new ItemStack(BlockIDs.plywood.block, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 4), new ItemStack(BlockIDs.plywood.block, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 5), new ItemStack(BlockIDs.plywood.block, 1, 5));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 6), new ItemStack(BlockIDs.plywood.block, 1, 6));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 7), new ItemStack(BlockIDs.plywood.block, 1, 7));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 8), new ItemStack(BlockIDs.plywood.block, 1, 8));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 9), new ItemStack(BlockIDs.plywood.block, 1, 9));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(BlockIDs.plywood.block, 1, 10), new ItemStack(BlockIDs.plywood.block, 1, 10));

        //xmas
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.xmasLights1_top_white.block, 6), new ItemStack(ItemIDs.bulb.item,1 ), new ItemStack(ItemIDs.bulb.item,1 ), Items.string, Items.string);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.xmasLights1_bottom_white.block, 2), new ItemStack(BlockIDs.xmasLights1_top_white.block, 1), new ItemStack(BlockIDs.xmasLights1_top_white.block, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.xmasLights1_top_rainbow.block, 2), new ItemStack(BlockIDs.xmasLights1_bottom_white.block, 1), new ItemStack(BlockIDs.xmasLights1_bottom_white.block, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.xmasLights1_bottom_rainbow.block, 2), new ItemStack(BlockIDs.xmasLights1_top_rainbow.block, 1), new ItemStack(BlockIDs.xmasLights1_top_rainbow.block, 1));

        //turfs
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.turf.block, 4), Items.wheat_seeds, Items.wheat_seeds, Blocks.dirt, Blocks.dirt, Blocks.dirt, Blocks.dirt);
        GameRegistry.addShapedRecipe(new ItemStack(BlockIDs.turfsnow.block, 8), "TTT", "TST", "TTT", 'T', new ItemStack(BlockIDs.turf.block, 1), 'S', Items.snowball);

        //green and blue screen blocks
        for (ItemStack dye : dyeLime) {
            GameRegistry.addShapedRecipe(new ItemStack(BlockIDs.green.block, 4), "DAD", "DBD", "   ", 'B', new ItemStack(ItemIDs.bulb.item, 1), 'D', new ItemStack(BlockIDs.unfinishedDrywall.block, 1), 'A', dye); }
        for (ItemStack dye : dyeBlue) {
            GameRegistry.addShapedRecipe(new ItemStack(BlockIDs.blue.block, 4), "DAD", "DBD", "   ", 'B', new ItemStack(ItemIDs.bulb.item, 1), 'D', new ItemStack(BlockIDs.unfinishedDrywall.block, 1), 'A', dye); }

        //fences & panes
        GameRegistry.addShapedRecipe(new ItemStack(BlockIDs.metalFencing.block, 16, 0), "III", "III", "   ", 'I', new ItemStack(ItemIDs.ironRod.item));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.metalFencing.block, 4, 1), new ItemStack(BlockIDs.metalFencing.block, 1, 0), new ItemStack(BlockIDs.metalFencing.block, 1, 0), new ItemStack(BlockIDs.metalFencing.block, 1, 0), new ItemStack(BlockIDs.metalFencing.block, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.metalFencing.block, 4, 2), new ItemStack(BlockIDs.metalFencing.block, 1, 1), new ItemStack(BlockIDs.metalFencing.block, 1, 1), new ItemStack(BlockIDs.metalFencing.block, 1, 1), new ItemStack(BlockIDs.metalFencing.block, 1, 1));

        GameRegistry.addShapedRecipe(new ItemStack(BlockIDs.glassAssortedPane.block, 16, 0), "GGG", "GGG", "   ", 'G', new ItemStack(BlockIDs.glassAssorted.block, 1, 0));

        new SimpleBlockIDGroupRegister(FoxBlocks.MODID).RegisterIFoxBlockIDRecipes(BlockIDs.values(), blockRegisterReturnCache.TempBlockCache);

        // Auto Register Vanilla Converted Slab And Stair Recipes
        for (Map.Entry<Block, VanillaBlockProperty> tempBlock : blockRegisterReturnCache.TempVanillaBlockCache.entrySet())
        {
            Block block = tempBlock.getKey();
            int MaxMetadata = tempBlock.getValue().TotalTextureCount;
            String baseBlockName = tempBlock.getValue().GetBaseBlockName();
            
            // Slabs can only go up to 7 as metadata is used for the bottom and top sate
            if (MaxMetadata < 8)
            {
                Block blockSlab = GameRegistry.findBlock(FoxBlocks.MODID, baseBlockName + "_Slab");
                if (blockSlab == null)
                {
                    blockSlab  = GameRegistry.findBlock(FoxBlocks.MODID, baseBlockName.replace(" ", "") + "_Slab");
                }

                if (blockSlab != null)
                {
                    for (int i = 0; i <= MaxMetadata; i++)
                    {
                        GameRegistry.addShapedRecipe(new ItemStack(blockSlab, 6, i), "   ", "   ", "III", 'I', new ItemStack(block, 1, i));
                        GameRegistry.addShapedRecipe(new ItemStack(blockSlab, 2, i), " X", " I", 'I', new ItemStack(block, 1, i), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
                        GameRegistry.addShapedRecipe(new ItemStack(block, 1, i), "   ", " I ", " I ", 'I', new ItemStack(blockSlab, 1, i));
                    }
                }
            }
            else
            {
                Block blockSlab = GameRegistry.findBlock(FoxBlocks.MODID, baseBlockName + "_Slab");
                if (blockSlab == null)
                {
                    blockSlab  = GameRegistry.findBlock(FoxBlocks.MODID, baseBlockName.replace(" ", "") + "_Slab");
                }

                if (blockSlab != null)
                {
                    for (int i = 0; i <= 7; i++)
                    {
                        GameRegistry.addShapedRecipe(new ItemStack(blockSlab, 6, i), "   ", "   ", "III", 'I', new ItemStack(block, 1, i));
                        GameRegistry.addShapedRecipe(new ItemStack(blockSlab, 2, i), " X", " I", 'I', new ItemStack(block, 1, i), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
                        GameRegistry.addShapedRecipe(new ItemStack(block, 1, i), "   ", " I ", " I ", 'I', new ItemStack(blockSlab, 1, i));
                    }
                }

                Block blockSlabTwo = GameRegistry.findBlock(FoxBlocks.MODID, baseBlockName + "_2_Slab");
                if (blockSlabTwo == null)
                {
                    blockSlabTwo  = GameRegistry.findBlock(FoxBlocks.MODID, baseBlockName.replace(" ", "") + "_2_Slab");
                }

                if (blockSlabTwo != null)
                {
                    for (int i = 0; i <= MaxMetadata - 8; i++)
                    {
                        GameRegistry.addShapedRecipe(new ItemStack(blockSlabTwo, 6, i), "   ", "   ", "III", 'I', new ItemStack(block, 1, i + 8));
                        GameRegistry.addShapedRecipe(new ItemStack(blockSlabTwo, 2, i), " X", " I", 'I', new ItemStack(block, 1, i + 8), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
                        GameRegistry.addShapedRecipe(new ItemStack(block, 1, i + 8), "   ", " I ", " I ", 'I', new ItemStack(blockSlabTwo, 1, i));
                    }
                }
            }

            for (int i = 0; i < MaxMetadata; i++)
            {
                Block blockStair = GameRegistry.findBlock(FoxBlocks.MODID, baseBlockName + "_" + i + "_Stair");
                if (blockStair == null)
                {
                    blockStair = GameRegistry.findBlock(FoxBlocks.MODID, baseBlockName.replace(" ", "") + "_" + i + "_Stair");
                }

                GameRegistry.addShapedRecipe(new ItemStack(blockStair, 6, 0), "B  ", "BB ", "BBB", 'B', new ItemStack(block, 1, i));
                GameRegistry.addShapedRecipe(new ItemStack(blockStair, 1, 0), "  ", "BX", 'B', new ItemStack(block, 1, i), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
            }

            if (block instanceof BlockFalling == false)
            {
                for (int i = 0; i < MaxMetadata; i++)
                {
                    Block blockWall = GameRegistry.findBlock(FoxBlocks.MODID, baseBlockName + "_Wall");

                    GameRegistry.addShapedRecipe(new ItemStack(blockWall, 6, i), "BBB", "BBB", "   ", 'B', new ItemStack(block, 1, i));
                    GameRegistry.addShapedRecipe(new ItemStack(blockWall, 1, i), " X", "B ", 'B', new ItemStack(block, 1, i), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
                }
            }
        }


        FoxBlocks.blockLogger.info("Hi Dad!");
        //FoxBlocks.blockLogger.info("BlockRecipe Post Init at com.bidahochi.BlockMod.core.handler.recipeHandler");
    }
}
