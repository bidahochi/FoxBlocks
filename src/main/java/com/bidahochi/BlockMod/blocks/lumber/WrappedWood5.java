package com.bidahochi.BlockMod.blocks.lumber;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class WrappedWood5 extends BlockContainer {
    public WrappedWood5(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("WrappedWood5");
        setHardness(2F);
        setResistance(5.0F);
        setHarvestLevel("axe", 0);
        setStepSound(soundTypeWood);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabFactory);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileWrappedWood5();
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
        return createNewTileEntity(world, meta);
    }

    @Override
    public boolean canCollideCheck(int p_149678_1_, boolean p_149678_2_){
       return true;
   }

    @Override //entity collision, this doesn't need changing, but needs inclusion
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
    }

    /*@Override //actual collision stuff you change
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1F, 0.5F);
    }*/

    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        //cover if tile isn't a thing
        if(world == null || !(world.getTileEntity(x,y,z) instanceof TileWrappedWood5)){
            super.setBlockBoundsBasedOnState(world,x,y,z);
            return;
        }
        //return based on tile data
        switch(((TileWrappedWood5)world.getTileEntity(x,y,z)).dir){
            case 0:{this.setBlockBounds(0F, 0.0F, 0.0F, 1.0F, 1F, 1F); return;}//north
            //case 1:{this.setBlockBounds(0.5F, 0.0F, 0.25F, 1.0F, 1F, 0.75F); return;}//east
            //case 2:{this.setBlockBounds(0.25F, 0.0F, 0.5F, 0.75F, 1F, 1F); return;}//south
            //case 3:{this.setBlockBounds(0.0F, 0.0F, 0.25F, 0.5F, 1F, 0.75F); return;}//west
        }

        //fallback if rotation wasn't understood
        super.setBlockBoundsBasedOnState(world,x,y,z);
    }

    @Override //this doesn't need changing but it needs inclusion
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB hitboxSelf, List hitboxesOther, Entity collidingEntity) {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        super.addCollisionBoxesToList(world, x, y, z, hitboxSelf, hitboxesOther, collidingEntity);
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

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack){
        super.onBlockPlacedBy(world, x, y, z, entity, stack);
        //force tile spawn manually and override any existing tile at the space
        world.setTileEntity(x,y,z, new TileWrappedWood5(MathHelper.floor_double((entity.rotationYaw / 90.0F) + 2.5D) & 3));
    }

    private IIcon texture;

    @Override
    public IIcon getIcon(int i, int j) {
        return texture;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        texture = iconRegister.registerIcon(FoxBlocks.MODID+ ":wrappedwood5");
    }
}
