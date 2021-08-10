package com.bidahochi.BlockMod.blocks.constructionmaterials;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class WallPaper extends Block {

    int varia=16;
    public IIcon[] textures = new IIcon[varia];

    public WallPaper(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("wallPaper");
        setHardness(0.5F);
        setResistance(0.25F);
        setStepSound(soundTypeCloth);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/wallpapers/wallpaper");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
    }

    public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < varia ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }

    public IIcon getIcon ( int side, int meta){
        if (meta > varia-1 ) meta = 0;
        return this.textures[meta];
    }

    public int damageDropped( int oldmeta){
        return oldmeta;
    }

    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < varia; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}