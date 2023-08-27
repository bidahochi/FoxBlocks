package com.bidahochi.BlockMod.blocks.metals;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class WornVent1 extends Block {

    public WornVent1(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("WornVent1");
        setHardness(1F);
        setResistance(2.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeMetal);
        setBlockTextureName(FoxBlocks.MODID+":metals/worn_vent");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabFactory);
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }

    //transparency go brr

    @Override
    public Block setLightOpacity(int p_149713_1_) {
        return super.setLightOpacity(1);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }



    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        Block block = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_);

        if (true)
        {
            if (p_149646_1_.getBlockMetadata(p_149646_2_, p_149646_3_, p_149646_4_) != p_149646_1_.getBlockMetadata(p_149646_2_ - Facing.offsetsXForSide[p_149646_5_], p_149646_3_ - Facing.offsetsYForSide[p_149646_5_], p_149646_4_ - Facing.offsetsZForSide[p_149646_5_]))
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }

        return !false && block == this ? false : super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
    }
}
