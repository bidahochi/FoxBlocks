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

/**
 *  Multi textures on a single block
 *
 *  -hariesh
 *
 */
public class tile2x2 extends Block {

    public IIcon[] textures = new IIcon[16];

    public tile2x2(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Tile 2x2");
        setHardness(1.3F);
        setResistance(3.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeGlass);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/2by2tiles/tile8");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
    }
    public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < 16 ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }
    public IIcon getIcon ( int side, int meta){
        if (meta > 15 ) meta = 0;
        return this.textures[meta];
    }
    public int damageDropped( int oldmeta){
        return oldmeta;
    }
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < 16; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
