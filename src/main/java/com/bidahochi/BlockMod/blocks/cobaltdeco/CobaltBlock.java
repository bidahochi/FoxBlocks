package com.bidahochi.BlockMod.blocks.cobaltdeco;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.baseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CobaltBlock extends baseBlock {

    public CobaltBlock(Material material) {
        super(material, "cobaltBlock", 10F, 8.5F, "pickaxe", 2, soundTypeStone, FoxBlocks.MODID+":cobalt_block");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
    }

}