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

/**
 *  Multi textures on a single block
 *
 *  -hariesh
 *
 */
public class dryWall extends Block {

    public IIcon[] textures = new IIcon[7];

    public dryWall(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("dryWall");
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/drywall/drywall");
    }

    public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < 7 ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }

    public IIcon getIcon ( int side, int meta){
        if (meta > 6 ) meta = 0;
        return this.textures[meta];
    }

    public int damageDropped( int oldmeta){
        return oldmeta;
    }

    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < 7; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
