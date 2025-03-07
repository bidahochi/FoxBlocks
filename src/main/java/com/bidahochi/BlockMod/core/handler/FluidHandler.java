package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.blocks.fluid.BaseFluid;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import static com.bidahochi.BlockMod.FoxBlocks.foxBlocksCreativeTabFactory;

public class FluidHandler
{
    public static void initFluidRegister(FMLInitializationEvent e)
    {
        buildNewFluid(FluidIDs.liquid_tbea.blockName, Material.water, foxBlocksCreativeTabFactory, "fluids/tbea/liquid_tbea");
    }

    private static void buildNewFluid(String nameOfFluid, Material material, CreativeTabs creativeTabs, String texturePath)
    {
        Fluid fluid = new Fluid(nameOfFluid);
        FluidRegistry.registerFluid(fluid);

        BaseFluid baseFluid = new BaseFluid(nameOfFluid, fluid, material, creativeTabs, texturePath);
        Block block = baseFluid;
        baseFluid.setFluid(fluid);
        GameRegistry.registerBlock(baseFluid, nameOfFluid);
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(new FluidStack(fluid, 1000), new ItemStack(block), new ItemStack(Items.bucket)));
    }
}
