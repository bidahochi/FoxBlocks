package com.bidahochi.BlockMod.blocks.stones;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class LayeredConcrete extends Block {

    public IIcon [] textures = new IIcon[6];

    public LayeredConcrete(Material p_i45394_1_) {
        super(p_i45394_1_);

        setHardness(2.0F);
        setResistance(12.5F);
        setHarvestLevel("pickaxe", 1);
        setBlockName(BlockIDs.layeredConcrete.blockName);
        setBlockTextureName(FoxBlocks.MODID+":stones/layercrete/Layered_concrete");
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
