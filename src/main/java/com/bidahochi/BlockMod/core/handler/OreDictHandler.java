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

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {

    public static void registerOreDict() {

        //FoxBlocks.blockLogger.info("oreDict compatibility pre Init at com.bidahochi.BlockMod.core.handler.oreDictHandler");

        OreDictionary.registerOre("oreAluminium", new ItemStack(BlockIDs.bauxiteOre.block) );
        //OreDictionary.registerOre("oreCobalt", new ItemStack(BlockIDs.cobaltOre.block) );//bUt ItS nOt BaLaNcEd EnOuGh To HaVe
        OreDictionary.registerOre("gravel", new ItemStack(BlockIDs.peagravel.block) );
        OreDictionary.registerOre("oreEmerald", new ItemStack(BlockIDs.soapStoneEmerald.block));
        //OreDictionary.registerOre("stone", new ItemStack(BlockIDs.soapStone.block)); //honestly breaks more than it fixes. dont enable, future me
        OreDictionary.registerOre("cropNetherWart", new ItemStack(BlockIDs.blockOfPlayerHead.block));
        OreDictionary.registerOre("concrete", new ItemStack(BlockIDs.Concrete.block));
        OreDictionary.registerOre("concrete", new ItemStack(BlockIDs.layeredConcrete.block));
        OreDictionary.registerOre("concrete", new ItemStack(BlockIDs.smoothCrete.block));
        OreDictionary.registerOre("concrete", new ItemStack(BlockIDs.concreteBrick.block));
        OreDictionary.registerOre("concrete", new ItemStack(BlockIDs.concreteFloor.block));
        OreDictionary.registerOre("gypsumDust", new ItemStack(ItemIDs.gypsumDust.item));
        OreDictionary.registerOre("ceramic", new ItemStack(ItemIDs.ceramic.item));
        OreDictionary.registerOre("oreVietnam", new ItemStack(BlockIDs.tHanos.block));
        OreDictionary.registerOre("oreAragonite", new ItemStack(BlockIDs.aragoniteOre.block));
        OreDictionary.registerOre("rodIron", new ItemStack(ItemIDs.ironRod.item));
        OreDictionary.registerOre("plateIron", new ItemStack(ItemIDs.ironSlice.item));
        OreDictionary.registerOre("circuitBasic", new ItemStack(ItemIDs.computerizedCircuit.item));
        OreDictionary.registerOre("ingotRainbontrium", new ItemStack(ItemIDs.rainbontrium.item));

        OreDictionary.registerOre("drywallUnfinished", new ItemStack(BlockIDs.unfinishedDrywall.block));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 0));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 1));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 2));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 3));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 4));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 5));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 6));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 7));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 8));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 9));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 10));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 11));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 12));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 13));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 14));
        OreDictionary.registerOre("drywallFinished", new ItemStack(BlockIDs.dryWall.block, 15));

        OreDictionary.registerOre("logWood", new ItemStack(BlockIDs.logs.block));
        OreDictionary.registerOre("plankWood", new ItemStack(BlockIDs.planks1.block));
        OreDictionary.registerOre("plankWood", new ItemStack(BlockIDs.widePlank.block));
        OreDictionary.registerOre("plankWood", new ItemStack(BlockIDs.widePlank2.block));
        OreDictionary.registerOre("plankWood", new ItemStack(BlockIDs.widePlank3.block));
        OreDictionary.registerOre("plankWood", new ItemStack(BlockIDs.widePlank4.block));

        OreDictionary.registerOre("oreHematite", new ItemStack(BlockIDs.hematite.block));
        OreDictionary.registerOre("oreTaconite", new ItemStack(BlockIDs.taconite.block));
        OreDictionary.registerOre("oreCrushedTaconite", new ItemStack(ItemIDs.taconiteCrushed.item));
        OreDictionary.registerOre("dustTaconite", new ItemStack(ItemIDs.taconitePellets.item));

        //FoxBlocks.blockLogger.info("oreDict compatibility Post Init at com.bidahochi.BlockMod.core.handler.oreDictHandler");

    }
}
