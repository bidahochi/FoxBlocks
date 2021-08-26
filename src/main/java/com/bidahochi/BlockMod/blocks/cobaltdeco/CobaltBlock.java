package com.bidahochi.BlockMod.blocks.cobaltdeco;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.baseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/*public class CobaltBlock extends baseBlock {

    public CobaltBlock(Material material) {
        super(material, "cobaltBlock", 10F, 8.5F, "pickaxe", 2, soundTypeStone, FoxBlocks.MODID+":cobalt_block");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
    }

}*/
public class CobaltBlock extends Block {

    public CobaltBlock(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("cobaltBlock");
        setHardness(10F);
        setResistance(8.5F);
        setHarvestLevel("pickaxe", 2);
        setStepSound(soundTypeStone);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/cobalt_block");
    }
    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}