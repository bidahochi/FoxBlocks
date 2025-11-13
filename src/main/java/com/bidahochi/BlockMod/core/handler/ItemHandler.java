package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.items.*;
import com.bidahochi.BlockMod.items.Bucket.ItemBucketLEAN;
import com.bidahochi.BlockMod.items.Bucket.ItemBucketTBEA;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class ItemHandler {

    public static void initItemRegister(){

        //FoxBlocks.blockLogger.info("ItemRegister Pre Init at com.bidahochi.BlockMod.core.handler.itemHandler");

        ItemIDs.test.item = new test();
        ItemIDs.jarate.item = new jarate();
        ItemIDs.gypsumDust.item = new gypsumDust();
        ItemIDs.enrichedClay.item = new enrichedClay();
        ItemIDs.ceramic.item = new ceramic();
        ItemIDs.cobaltIngot.item = new cobaltIngot();
        ItemIDs.lowDensityCompound.item = new lowDensityCompound();
        ItemIDs.rust.item = new rust();
        ItemIDs.aragoniteClump.item = new aragoniteClump();
        ItemIDs.ironRod.item = new IronRod();
        ItemIDs.ironSlice.item = new IronSlice();
        ItemIDs.computerizedCircuit.item = new computerizedCircuit();
        ItemIDs.woodSealant.item = new woodSealant();
        ItemIDs.taconiteCrushed.item = new taconiteCrushed();
        ItemIDs.taconitePellets.item = new taconitePellets();
        ItemIDs.quicklime.item = new quicklime();
        ItemIDs.roadTar.item=new roadTar();
        ItemIDs.bulb.item=new bulb();
        ItemIDs.bulbLong.item=new bulbLong();
        ItemIDs.bolsterChisel.item = new bolsterChisel();
        ItemIDs.leanDust.item = new leanDust();
        ItemIDs.straps.item = new straps();
        ItemIDs.rainbontrium.item = new rainbontrium();

        ItemIDs.doorA.item = new itemDoor().setUnlocalizedName("doorA").setTextureName(FoxBlocks.MODID + ":doorA_icon");
        ItemIDs.doorB.item = new itemDoor().setUnlocalizedName("doorB").setTextureName(FoxBlocks.MODID + ":doorB_icon");
        ItemIDs.doorC.item = new itemDoor().setUnlocalizedName("doorC").setTextureName(FoxBlocks.MODID + ":doorC_icon");
        ItemIDs.doorD.item = new itemDoor().setUnlocalizedName("doorD").setTextureName(FoxBlocks.MODID + ":doorD_icon");
        ItemIDs.doorE.item = new itemDoor().setUnlocalizedName("doorE").setTextureName(FoxBlocks.MODID + ":doorE_icon");

        ItemIDs.record_piss2.item = new record_piss2("record_piss");
        ItemIDs.record_rodney.item = new record_rodney("record_rodney");
        ItemIDs.record_penguin.item = new record_penguin("record_penguin");

        { // Creates the bucket and adds the item to the bucket registry so that buckets work on it
            Block tempLiquidBlock = GameRegistry.findBlock(FoxBlocks.MODID, FluidIDs.liquid_tbea.blockName);
            ItemIDs.bucket_of_tbea.item = new ItemBucketTBEA(tempLiquidBlock, ItemIDs.bucket_of_tbea.iconName);
            SetupFluidContainer(FluidIDs.liquid_tbea, ItemIDs.bucket_of_tbea, tempLiquidBlock);
        }
        { // Creates the bucket and adds the item to the bucket registry so that buckets work on it
            Block tempLiquidBlock = GameRegistry.findBlock(FoxBlocks.MODID, FluidIDs.liquid_lean.blockName);
            ItemIDs.bucket_of_lean.item = new ItemBucketLEAN(tempLiquidBlock, ItemIDs.bucket_of_lean.iconName);
            SetupFluidContainer(FluidIDs.liquid_lean, ItemIDs.bucket_of_lean, tempLiquidBlock);
        }

        for (ItemIDs items : ItemIDs.values())
        {
            if ((items.sanitizeItem && ConfigHandler.SanitizeMod) == false ) {
                items.item.setCreativeTab(FoxBlocks.foxBlocksCreativeTabItems);
                items.item.setUnlocalizedName(FoxBlocks.MODID + ":" + items.itemName);
                GameRegistry.registerItem(items.item, items.name());
            }
        }
    }

    private static void SetupFluidContainer(FluidIDs fluidID, ItemIDs bucketItemID, Block tempLiquidBlock)
    {
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(new FluidStack(FluidRegistry.getFluid(FoxBlocks.MODID + "." + fluidID.blockName), 1000), new ItemStack(bucketItemID.item), new ItemStack(Items.bucket)));
        BucketHandler.INSTANCE.buckets.put(tempLiquidBlock, bucketItemID.item);
    }
}
