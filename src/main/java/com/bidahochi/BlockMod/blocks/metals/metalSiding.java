package com.bidahochi.BlockMod.blocks.metals;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class metalSiding extends Block {

    public IIcon[] textures = new IIcon[16];

    public metalSiding(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("metalSiding");
        setBlockTextureName(FoxBlocks.MODID+":metals/metalsiding/metalsiding");
        setStepSound(soundTypeMetal);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabFactory);
    }


    public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < 16 ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }

    public IIcon getIcon (int side, int meta){
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


