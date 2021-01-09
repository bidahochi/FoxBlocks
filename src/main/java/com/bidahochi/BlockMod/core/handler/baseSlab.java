package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class baseSlab extends BlockSlab {

    public baseSlab(boolean p_i45410_1_, Material p_i45410_2_, String name, float hardness, float blockResistance , SoundType stepSound, String harvestTool, int harvestLevel, float lightValue, String textureName, CreativeTabs creativeTabs) {
        super(p_i45410_1_, p_i45410_2_);
        setBlockName(name);
        setHardness(hardness);
        setBlockTextureName(FoxBlocks.MODID +":"+textureName);
        setStepSound(stepSound);
        setHarvestLevel(harvestTool, harvestLevel);
        setResistance(blockResistance);
        setLightLevel(lightValue);
        setCreativeTab(creativeTabs);
    }

    @Override
    public String func_150002_b(int p_150002_1_) {
        return null;
    }
}
