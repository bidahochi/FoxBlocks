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


        for (ItemStack dyeblack : dyeBlack) {
            GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.metalSiding.block, 1,0),  Blocks.iron_block, dyeblack);
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,3), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyeblack);

        }

        for (ItemStack dyegray : dyeGray)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,11), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyegray);
        }

        for (ItemStack dyelightblue : dyeLightBlue)
        {
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
        }

        for (ItemStack dyered : dyeRed)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,6), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyered);
            for (ItemStack dyelime : dyeLime)
            {
                GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,13), "AAA", "AEA", "ABA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyelime, Character.valueOf('B'), dyered);
            }
        }

        for (ItemStack dyeyellow : dyeYellow)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,7), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyeyellow);
            GameRegistry.addShapelessRecipe(new ItemStack(ItemIDs.jarate.item, 1,0),  Items.water_bucket, dyeyellow);
        }

        for (ItemStack dyegreen : dyeGreen)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,8), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyegreen);
        }

        for (ItemStack dyecyan : dyeCyan)
        {
            GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,9), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), dyecyan);
        }

        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel.block, 1), Blocks.gravel);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockIDs.peagravel_snow.block, 1),  new ItemStack(BlockIDs.peagravel.block, 1), Items.snowball, new ItemStack(BlockIDs.peagravel.block, 1));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,0), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Items.redstone);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,1), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Blocks.leaves);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,2), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Items.apple);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,4), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), new ItemStack(Blocks.grass,1,2));
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,12), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), ItemIDs.jarate.item);
        GameRegistry.addRecipe(new ItemStack(BlockIDs.wallPaper.block, 4,15), "AAA", "AEA", "AAA", Character.valueOf('A'), Items.paper, Character.valueOf('E'), Items.ender_eye);

        FoxBlocks.blockLogger.info("BlockRecipe Post Init at com.bidahochi.BlockMod.core.handler.recipeHandler");


    }
}
