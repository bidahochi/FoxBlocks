package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.fluid.BaseFluid;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import static com.bidahochi.BlockMod.FoxBlocks.foxBlocksCreativeTabFactory;

public class FluidHandler
{
    public static void initFluidRegister(FMLInitializationEvent e)
    {
        buildNewFluid(FluidIDs.liquid_tbea.blockName, Material.water, foxBlocksCreativeTabFactory, "fluids/tbea/liquid_tbea");
    }

    private static void buildNewFluid(String nameOfFluid, Material material, CreativeTabs creativeTabs, String texturePath)
    {
        Fluid fluid = new Fluid(FoxBlocks.MODID + "." + nameOfFluid);
        FluidRegistry.registerFluid(fluid);
        BaseFluid baseFluid = new BaseFluid(FoxBlocks.MODID + "." + nameOfFluid, fluid, material, creativeTabs, texturePath);
        baseFluid.setFluid(fluid);
        GameRegistry.registerBlock(baseFluid, nameOfFluid);
    }
}
