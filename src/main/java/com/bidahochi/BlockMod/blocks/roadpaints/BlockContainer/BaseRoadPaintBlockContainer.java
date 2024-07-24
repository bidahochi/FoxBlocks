package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public abstract class BaseRoadPaintBlockContainer extends BlockContainer
{
    private String nameOfIcon;

    public void setNameOfIcon(String nameOfIcon)
    {
        this.nameOfIcon = nameOfIcon;
    }

    public BaseRoadPaintBlockContainer(Material p_i45394_1_)
    {
        super(p_i45394_1_);
        setHardness(2F);
        setResistance(4.0F);
        setHarvestLevel("pickaxe", 2);
        setStepSound(soundTypeStone);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRoadRail);
    }

    @Override
    public TileEntity createTileEntity(World world, int meta)
    {
        return createNewTileEntity(world, meta);
    }

    @Override
    public boolean canCollideCheck(int p_149678_1_, boolean p_149678_2_)
    {
        return true;
    }

    @Override //entity collision, this doesn't need changing, but needs inclusion
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
    }

    @Override //actual collision stuff you change
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 1F);
    }

    @Override
    public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_)
    {

    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    private IIcon texture;

    @Override
    public IIcon getIcon(int i, int j)
    {
        return texture;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        texture = iconRegister.registerIcon(FoxBlocks.MODID + ":roadpaints/rp_icon/" + nameOfIcon);
    }

    // Helper to get the Direction
    protected int getDir(EntityLivingBase entity)
    {
        return MathHelper.floor_double((entity.rotationYaw / 90.0F) + 2.5D) & 3;
    }
}
