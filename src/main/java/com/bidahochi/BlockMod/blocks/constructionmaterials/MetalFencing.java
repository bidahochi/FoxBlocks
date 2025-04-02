package com.bidahochi.BlockMod.blocks.constructionmaterials;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseBlockPane;
import net.minecraft.block.material.Material;

public class MetalFencing extends BaseBlockPane
{
    public MetalFencing() {
        super(net.minecraft.block.material.Material.iron);
        setBlockTextureName(FoxBlocks.MODID+":metals/metal_fence");
        setBlockName("metalFencing");
        amountOfSubBlocks = 3;
        setStepSound(soundTypeMetal);
    }

    @Override
    public int getRenderType() {
        return 18;
    }
}
