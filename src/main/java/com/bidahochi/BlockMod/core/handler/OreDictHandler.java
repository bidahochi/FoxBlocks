package com.bidahochi.BlockMod.core.handler;

/**
 *
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

public class OreDictHandler {

    public static void registerOreDict() {

        FoxBlocks.blockLogger.info("oreDict compatibility pre Init at com.bidahochi.BlockMod.core.handler.oreDictHandler");

        OreDictionary.registerOre("oreAluminium", new ItemStack(BlockIDs.bauxiteOre.block) );
        //OreDictionary.registerOre("oreCobalt", new ItemStack(BlockIDs.cobaltOre.block) );//bUt ItS nOt BaLaNcEd EnOuGh To HaVe
        OreDictionary.registerOre("gravel", new ItemStack(BlockIDs.peagravel.block) );
        OreDictionary.registerOre("oreEmerald", new ItemStack(BlockIDs.soapStoneEmerald.block));
        OreDictionary.registerOre("stone", new ItemStack(BlockIDs.soapStone.block));
        OreDictionary.registerOre("cropNetherWart", new ItemStack(BlockIDs.harieshHead.block));
        OreDictionary.registerOre("concrete", new ItemStack(BlockIDs.rawConcrete.block));
        OreDictionary.registerOre("concrete", new ItemStack(BlockIDs.layeredConcrete.block));
        OreDictionary.registerOre("concrete", new ItemStack(BlockIDs.smoothCrete.block));
        OreDictionary.registerOre("gypsumDust", new ItemStack(ItemIDs.gypsumDust.item));
        OreDictionary.registerOre("ceramic", new ItemStack(ItemIDs.ceramic.item));
        OreDictionary.registerOre("oreVietnam", new ItemStack(BlockIDs.tHanos.block));
        OreDictionary.registerOre("oreAragonite", new ItemStack(BlockIDs.placeholderOre.block));
        OreDictionary.registerOre("rodIron", new ItemStack(ItemIDs.ironRod.item));
        OreDictionary.registerOre("plateIron", new ItemStack(ItemIDs.ironSlice.item));
        OreDictionary.registerOre("circuitBasic", new ItemStack(ItemIDs.computerizedCircuit.item));
        OreDictionary.registerOre("drywallUnfinished", new ItemStack(BlockIDs.unfinishedDrywall.block));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block));

        FoxBlocks.blockLogger.info("oreDict compatibility Post Init at com.bidahochi.BlockMod.core.handler.oreDictHandler");

    }
}
