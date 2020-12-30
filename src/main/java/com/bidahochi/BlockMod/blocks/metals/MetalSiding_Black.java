package com.bidahochi.BlockMod.blocks.metals;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.Explosion;


public class MetalSiding_Black extends Block {

    public MetalSiding_Black(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("MetalSiding_Black");

        setBlockTextureName(FoxBlocks.MODID+":MetalSiding_Black");

    }
   /* public Block.SoundType soundTypeMetal = new Block.SoundType("stone", 1.0F, 1.5F);

    @Override
    public Block setStepSound(Block.SoundType p_149672_1_) {
        this.stepSound = Stone;
        return this;
    }*/
}
