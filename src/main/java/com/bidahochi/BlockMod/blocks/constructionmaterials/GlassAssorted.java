package com.bidahochi.BlockMod.blocks.constructionmaterials;

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

public class GlassAssorted extends Block {

    public IIcon[] textures = new IIcon[16];

    public GlassAssorted(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/glass/assortedGlass");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
        setBlockName("glassAssorted");
        setHardness(0.4F);
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

    public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < 4 ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }
    public IIcon getIcon (int side, int meta){
        if (meta > 3 ) meta = 0;
        return this.textures[meta];
    }
    public int damageDropped( int oldmeta){
        return oldmeta;
    }
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < 4; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

}
