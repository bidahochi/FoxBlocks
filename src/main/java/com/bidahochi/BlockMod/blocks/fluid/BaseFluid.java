package com.bidahochi.BlockMod.blocks.fluid;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import java.util.List;

public class BaseFluid extends BlockFluidClassic
{
    boolean alpha;
    public IIcon stillIcon;
    public IIcon flowIcon;
    boolean overwriteFluidIcons = true;
    private Fluid fluid = null;

    /**
     *
     * @param name
     * @param fluid
     * @param material
     * @param creativeTabs
     * @param texturePath
     * @param alpha
     */
    public BaseFluid(String name, Fluid fluid, Material material, CreativeTabs creativeTabs, String texturePath, boolean alpha)
    {
        this(name, fluid, material, creativeTabs, texturePath);
        this.alpha = alpha;
    }

    /**
     *
     * @param name
     * @param fluid
     * @param material
     * @param creativeTabs
     * @param texturePath
     */
    public BaseFluid(String name, Fluid fluid, Material material, CreativeTabs creativeTabs, String texturePath)
    {
        super(fluid, material);
        setBlockTextureName(texturePath);
        setBlockName("fluid." + name);
        setCreativeTab(creativeTabs);
    }

    @Override
    public int getRenderBlockPass ()
    {
        return alpha ? 1 : 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int meta)
    {
        if (side == 0 || side == 1)
        {
            return stillIcon;
        }

        return flowIcon;
    }

    @Override
    public void registerBlockIcons (IIconRegister iconRegister)
    {
        stillIcon = iconRegister.registerIcon(FoxBlocks.MODID + ":" + this.textureName);
        flowIcon = iconRegister.registerIcon(FoxBlocks.MODID + ":" + this.textureName + "_flow");

        if (overwriteFluidIcons)
        {
            this.getFluid().setIcons(stillIcon, flowIcon);
        }

        if (this.getFluid().getBlock() != this && fluid != null)
        {
            fluid.setIcons(stillIcon, flowIcon);
        }

    }

    public void setFluid(Fluid fluid) {
        this.fluid = fluid;
    }
}
