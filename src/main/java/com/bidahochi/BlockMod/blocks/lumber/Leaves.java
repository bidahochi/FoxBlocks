package com.bidahochi.BlockMod.blocks.lumber;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class Leaves extends BlockLeavesBase
{
    //public static final String[] typesleaves = new String[] {"douglasfir", "sitkaspruce", "redcedar"};
   // private IIcon[] leavestexture = new IIcon[typesleaves.length];


    //TODO: Fuck leaves honestly this shit can go to hell
    //made them a regular block because FUCK mojanks code



    public Leaves(){
        super(Material.leaves, false);

        setHardness(0.2F);
        setLightOpacity(2);
        setBlockName("leaves");
        setBlockTextureName(FoxBlocks.MODID+":lumber/leaves");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
        setStepSound(Block.soundTypeGrass);

    }
    /*@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
        leavestexture = new IIcon[typesleaves.length];

        for (int i = 0; i < this.leavestexture.length; ++i)
        {
            this.leavestexture[i] = ir.registerIcon(this.getTextureName() + "_" + typesleaves[i]);
        }
    }

    @Override
    public String[] func_150125_e() {
        return typesleaves;
    }
    @Override
    public boolean isOpaqueCube()
    {
        return Blocks.leaves.isOpaqueCube();
    }

    @Override
    public IIcon getIcon(int i, int j)
    {
        return Blocks.leaves.getIcon(i, (j & 2) == 2 ? 0 : j);
        return leavestexture (i, (j & 2) == 2 ? 0 : j);
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.blockIcon;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return Blocks.leaves.shouldSideBeRendered(iblockaccess, i, j, k, l);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabb, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
    }

    @Override
    public boolean isLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }*/
}