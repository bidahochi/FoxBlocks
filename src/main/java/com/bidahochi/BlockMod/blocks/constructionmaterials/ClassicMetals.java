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

public class ClassicMetals extends Block {

    public IIcon [] textures = new IIcon[6];
    //public IIcon [] textures2 = new IIcon[6];

    public ClassicMetals(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("ClassicIron");
        setHardness(5.0F);
        setResistance(10.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeMetal);
        setBlockTextureName(FoxBlocks.MODID+":metals/classicmetals/classicmetals");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
    }
    public void registerBlockIcons(IIconRegister reg) {
        for (int i = 0 ; i < 6; i++) {
            this.textures[i] = reg.registerIcon(this.textureName + "_" + i);
        }
    }
    public IIcon getIcon( int side, int meta) {
        return this.textures[side];
    }
}
