package com.bidahochi.BlockMod.blocks.stones;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class DeadGrass extends Block {

    public IIcon [] textures = new IIcon[6];

    public DeadGrass(Material p_i45394_1_) {
        super(p_i45394_1_);

        setHardness(0.5F);
        setResistance(0.1F);
        setHarvestLevel("shovel", 0);
        setBlockName(BlockIDs.deadGrass.blockName);
        setBlockTextureName(FoxBlocks.MODID+":aggregates/grasses/dead_grass");
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
