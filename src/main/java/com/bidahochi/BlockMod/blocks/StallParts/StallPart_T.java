package com.bidahochi.BlockMod.blocks.StallParts;

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

public class StallPart_T extends BlockContainer {
    public StallPart_T(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("stallPart_T");
        setHardness(2F);
        setResistance(4.0F);
        setHarvestLevel("pickaxe", 2);
        setStepSound(soundTypeMetal);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabProperProps);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileStallPart_T();
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

    @Override //actual collision stuff you change
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 1F);
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
        world.setTileEntity(x,y,z, new TileStallPart_T(MathHelper.floor_double((entity.rotationYaw / 90.0F) + 2.5D) & 3));
    }

    private IIcon texture;

    @Override
    public IIcon getIcon(int i, int j) {
        return texture;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        texture = iconRegister.registerIcon(FoxBlocks.MODID + ":props/stallPartsT");
    }
}
