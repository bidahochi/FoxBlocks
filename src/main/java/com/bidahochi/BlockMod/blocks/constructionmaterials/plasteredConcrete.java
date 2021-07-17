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

public class plasteredConcrete extends Block {

    public IIcon[] textures = new IIcon[16];

    public plasteredConcrete(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("plasteredConcrete");
        setHardness(1.5F);
        setResistance(2.5F);
        setHarvestLevel("pickaxe", 2);
        setStepSound(soundTypeStone);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/plasteredconcrete/plasteredConcrete");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
    }
    public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < 9 ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }
    public IIcon getIcon ( int side, int meta){
        if (meta > 8 ) meta = 0;
        return this.textures[meta];
    }
    public int damageDropped( int oldmeta){
        return oldmeta;
    }
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < 9; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
