package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class baseBlock extends Block {
    
    public baseBlock(String name, float hardness, float resistance, String harvestTool, int harvestLevel, Material material, Block.SoundType stepSound, String textureLocation) {
        super(material);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTab);
        setBlockName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(harvestTool,harvestLevel);
        setStepSound(stepSound);
        setBlockTextureName(FoxBlocks.MODID+":"+textureLocation);
    }
}
