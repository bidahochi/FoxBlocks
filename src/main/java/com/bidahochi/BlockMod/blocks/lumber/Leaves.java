package com.bidahochi.BlockMod.blocks.lumber;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class Leaves extends Block
{
    public static final String[] typesleaves = new String[] {"douglasfir", "sitkaspruce", "redcedar"};
    private IIcon[] leavestexture = new IIcon[typesleaves.length];
    //public IIcon[] textures = new IIcon[3];

    //TODO: Fuck leaves honestly this shit can go to hell
    //made them a regular block because i can


    public Leaves(Material p_i45394_1_){
        super(p_i45394_1_);
        //super(Material.leaves, false);

        setHardness(0.2F);
        setLightOpacity(2);
        setBlockName("leaves");
        setBlockTextureName(FoxBlocks.MODID+":lumber/leaves");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
        setStepSound(Block.soundTypeGrass);

    }
    @Override
    public Block setLightOpacity(int p_149713_1_) {
        return super.setLightOpacity(1);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }



    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        Block block = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_);

        if (true)
        {
            if (p_149646_1_.getBlockMetadata(p_149646_2_, p_149646_3_, p_149646_4_) != p_149646_1_.getBlockMetadata(p_149646_2_ - Facing.offsetsXForSide[p_149646_5_], p_149646_3_ - Facing.offsetsYForSide[p_149646_5_], p_149646_4_ - Facing.offsetsZForSide[p_149646_5_]))
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }

        return !false && block == this ? false : super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
    }

    /*public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < 3 ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }*/
    public IIcon getIcon (int side, int meta){
        if (meta > 2 ) meta = 0;
        return this.leavestexture[meta];
    }
    public int damageDropped( int oldmeta){
        return oldmeta;
    }
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < 3; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
        leavestexture = new IIcon[typesleaves.length];

        for (int i = 0; i < this.leavestexture.length; ++i)
        {
            this.leavestexture[i] = ir.registerIcon(this.getTextureName() + "_" + typesleaves[i]);
        }
    }
/*
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