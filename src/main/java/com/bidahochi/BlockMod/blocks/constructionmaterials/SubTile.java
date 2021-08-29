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

public class SubTile extends Block {

    public IIcon[] textures = new IIcon[16];

    public SubTile(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("SubTile");
        setHardness(2F);
        setResistance(3.2F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeStone);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/subtile/subtile");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabFactory);
    }
    public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < 5 ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }
    public IIcon getIcon ( int side, int meta){
        if (meta > 4 ) meta = 0;
        return this.textures[meta];
    }
    public int damageDropped( int oldmeta){
        return oldmeta;
    }
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < 5; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
