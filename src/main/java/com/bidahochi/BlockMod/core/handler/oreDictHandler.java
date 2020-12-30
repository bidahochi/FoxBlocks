package com.bidahochi.BlockMod.core.handler;

/**
 *  oreDictHandler by -hariesh
 *
 *  This file gives your blocks OreDictionary compatibility!
 *
 *  Register your blocks to oredict to make them work with machines and other mods!
 *
 *  Use Format:
 *      OreDictionary.registerOre("oreDictTag", new ItemStack(BlockIDs.blockname.block) );
 *
 *  Note: If your block has metadata use new ItemStack(BlockIDs.blockname.block, 1, metadata) at the end instead for it to work
 *
 *  Any questions just ping me or dm me on the discord!
 *
 *  -hariesh
 *
 */

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class oreDictHandler {

    public static void registerOreDict() {

        FoxBlocks.blockLogger.info("oreDict compatibility pre Init at com.bidahochi.BlockMod.core.handler.oreDictHandler");


        OreDictionary.registerOre("oreAluminium", new ItemStack(BlockIDs.bauxiteOre.block) );
        OreDictionary.registerOre("gravel", new ItemStack(BlockIDs.peagravel.block) );


        FoxBlocks.blockLogger.info("oreDict compatibility Post Init at com.bidahochi.BlockMod.core.handler.oreDictHandler");

    }
}
