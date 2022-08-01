package com.bidahochi.BlockMod.blocks.lumber;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;
import java.util.Random;

public class Logs extends BlockLog
{
    public static final String[] types = new String[] {"douglasfir", "sitkaspruce", "redcedar"};
    private IIcon[] logOutsides;
    private IIcon[] logInsides;

    public Logs(Material p_i45394_1_){

        setHardness(2.0F);
        setResistance(6F);
        setHarvestLevel("axe", 0);
        setBlockName("logs");
        setBlockTextureName(FoxBlocks.MODID+":lumber/logs");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
        this.logOutsides = new IIcon[types.length];
        this.logInsides = new IIcon[types.length];

        for (int i = 0; i < this.logOutsides.length; ++i)
        {
            this.logOutsides[i] = ir.registerIcon(this.getTextureName() + "_" + types[i]);
            this.logInsides[i] = ir.registerIcon(this.getTextureName() + "_" + types[i] + "_top");
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabb, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
    }

    /*@SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int ti)
    {
        return this.logInsides[ti % this.logInsides.length];
    }*/
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_)
    {
        return this.logOutsides[p_150163_1_ % this.logOutsides.length];
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return this.logInsides[p_150161_1_ % this.logInsides.length];
    }
}