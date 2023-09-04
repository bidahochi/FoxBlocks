package com.bidahochi.BlockMod.blocks.metals;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import com.bidahochi.BlockMod.core.handler.RenderBlockHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;


public class Scaffold2 extends Block {

    public Scaffold2(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Scaffold2");
        setHardness(3F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeMetal);
        setBlockTextureName(FoxBlocks.MODID + ":metals/scaffold_transparent_thiccer");
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
    public int getRenderBlockPass() {
        return 0;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side){
        return true;
    }

    @Override
    public int getRenderType() {
        return RenderBlockHandler.scaffoldRenderId;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
    {
       /* if (world.getBlock(x, y, z)==this){
            return true;
        }
        return super.shouldSideBeRendered(world, x, y, z, side);*/
        Block block = world.getBlock(x, y, z);

        if (true)
        {
            if (world.getBlockMetadata(x, y, z) != world.getBlockMetadata(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]))
            {
                if (block != BlockIDs.scaffold.block){
                    return false;
                }


            //}

            //if (block == this)
           // {
                //return true;// false renders like glass, true renders like IE but inverted lol
            }//TODO make this render correct like IE scaffold
        }

        return (block != this) && super.shouldSideBeRendered(world, x, y, z, side);
    }
}
