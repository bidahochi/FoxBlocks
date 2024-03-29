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

public class RustBeam extends Block {

    public IIcon[] textures = new IIcon[6];

    public RustBeam(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("rustBeam");
        setBlockTextureName(FoxBlocks.MODID+":metals/rustbeams/rustbeam");
        setStepSound(soundTypeMetal);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabFactory);
        setHardness(2F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 2);
    }

    public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < 6 ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }

    public IIcon getIcon (int side, int meta){
        if (meta > 5 ) meta = 0;
        return this.textures[meta];
    }

    public int damageDropped( int oldmeta){
        return oldmeta;
    }

    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < 6; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}


