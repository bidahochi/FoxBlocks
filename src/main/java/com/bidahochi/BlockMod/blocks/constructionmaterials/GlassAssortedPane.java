package com.bidahochi.BlockMod.blocks.constructionmaterials;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseBlockPane;

public class GlassAssortedPane extends BaseBlockPane
{
    public GlassAssortedPane() {
        super(net.minecraft.block.material.Material.glass);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/glass/assortedGlass");
        setBlockName("glassAssortedPane");
        amountOfSubBlocks = 4;
    }
}
