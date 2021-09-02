package com.bidahochi.BlockMod.blocks.constructionmaterials;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BreakerBox2 extends BlockContainer {
    public BreakerBox2(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("breakerBox2");
        setHardness(2F);
        setResistance(4.0F);
        setHarvestLevel("pickaxe", 2);
        setStepSound(soundTypeMetal);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabFactory);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileBreakerBox2();
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
        return createNewTileEntity(world, meta);
    }
   /* @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
        dir = MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) & 3;
    }*/

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

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack){
        super.onBlockPlacedBy(world, x, y, z, entity, stack);
        //force tile spawn manually and override any existing tile at the space
        world.setTileEntity(x,y,z, new TileBreakerBox2(MathHelper.floor_double((entity.rotationYaw / 90.0F) + 2.5D) & 3));
    }
}
