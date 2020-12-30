package com.bidahochi.BlockMod.blocks.essentiallymemes;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class testBlock extends Block {

    public IIcon [] textures = new IIcon[6];

    public testBlock(Material p_i45394_1_) {
        super(p_i45394_1_);

        setBlockName("testblock");
        setBlockTextureName(FoxBlocks.MODID+":testblock");
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
