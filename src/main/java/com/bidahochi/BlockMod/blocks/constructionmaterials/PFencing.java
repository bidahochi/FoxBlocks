package com.bidahochi.BlockMod.blocks.constructionmaterials;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseBlockPane;
import net.minecraft.block.material.Material;

public class PFencing extends BaseBlockPane
{
    public PFencing() {
        super(Material.iron);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/pfence/pfence");
        setBlockName("PFencing");
        amountOfSubBlocks = 4;
        setStepSound(soundTypeWood);
    }

    @Override
    public int getRenderType() {
        return 18;
    }
}
