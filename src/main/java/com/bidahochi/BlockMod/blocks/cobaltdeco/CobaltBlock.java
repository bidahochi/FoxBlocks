package com.bidahochi.BlockMod.blocks.cobaltdeco;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.BaseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CobaltBlock extends BaseBlock {

    public CobaltBlock(Material material) {
        super("cobaltBlock", 10F, 8.5F, "pickaxe", 2, material, soundTypeStone, FoxBlocks.MODID + ":constructionmaterials/cobaltdeco/cobalt_block");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
    }

}