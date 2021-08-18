package com.bidahochi.BlockMod.blocks.constructionmaterials;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BreakerBox extends BlockContainer {
    int dir;
    public BreakerBox(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("breakerBox");
        setHardness(2F);
        setResistance(4.0F);
        setHarvestLevel("pickaxe", 2);
        setStepSound(soundTypeMetal);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabFactory);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileBreakerBox(dir);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
        dir = MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) & 3;
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public int getRenderType(){
        return -1;
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }
}
