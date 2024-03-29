package com.bidahochi.BlockMod.blocks.cobaltdeco;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class CobaltPanel2 extends Block {

    public IIcon[] textures = new IIcon[7];


    public CobaltPanel2(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("cobaltPanel2");
        setHardness(2.0F);
        setResistance(2.5F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeStone);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/cobaltdeco/cobalt_panel2");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
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