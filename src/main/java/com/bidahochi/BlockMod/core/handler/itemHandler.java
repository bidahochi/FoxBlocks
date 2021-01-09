package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.items.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class itemHandler {

    public static void initItemRegister(){

        FoxBlocks.blockLogger.info("ItemRegister Pre Init at com.bidahochi.BlockMod.core.handler.itemHandler");

        ItemIDs.test.item = new test();
        ItemIDs.jarate.item = new jarate();
        ItemIDs.gypsumDust.item = new gypsumDust();
        ItemIDs.enrichedClay.item = new enrichedClay();
        ItemIDs.ceramic.item = new ceramic();
        ItemIDs.cobaltIngot.item = new cobaltIngot();
        ItemIDs.lowDensityCompound.item = new lowDensityCompound();


        for (ItemIDs items : ItemIDs.values()) {
            if (items.item.getCreativeTab() == null){
                items.item.setCreativeTab(FoxBlocks.foxBlocksCreativeTabItems);
            }
            items.item.setUnlocalizedName(FoxBlocks.MODID + ":" + items.itemName);
            GameRegistry.registerItem(items.item, items.name());

        }
    }
}
