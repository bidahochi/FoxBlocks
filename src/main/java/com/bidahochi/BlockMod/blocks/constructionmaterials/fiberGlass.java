package com.bidahochi.BlockMod.blocks.constructionmaterials;

import net.minecraft.item.Item;
import java.util.List;
import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class fiberGlass extends Block{

    public IIcon[] textures = new IIcon[6];

    public fiberGlass(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("fiberglass");
        setBlockTextureName(FoxBlocks.MODID+":fiberglass/insulation");
    }

    public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < 3 ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }

    public IIcon getIcon ( int side, int meta){
        if (meta > 2 ) meta = 0;
        return this.textures[meta];
    }

    public int damageDropped( int oldmeta){
        return oldmeta;
    }

    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < 3; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}