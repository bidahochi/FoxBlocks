package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.items.jarate;
import com.bidahochi.BlockMod.items.test;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class itemHandler {

    public static void initItemRegister(){

        FoxBlocks.blockLogger.info("ItemRegister Pre Init at com.bidahochi.BlockMod.core.handler.itemHandler");

        ItemIDs.test.item = new test();
        ItemIDs.jarate.item = new jarate();

        for (ItemIDs items : ItemIDs.values()) {
            items.item.setUnlocalizedName(FoxBlocks.MODID + ":" + items.itemName);
            GameRegistry.registerItem(items.item, items.name());
            items.item.setCreativeTab(FoxBlocks.foxBlocksCreativeTab);
        }
    }
}
