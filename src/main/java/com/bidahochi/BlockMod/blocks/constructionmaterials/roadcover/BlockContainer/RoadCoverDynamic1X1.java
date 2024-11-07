package com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.BlockContainer;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.TileEntity.TileRoadCoverDynamic1X1;
import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.TileEntity.TileRoadCoverDynamic1X1;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
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

public class RoadCoverDynamic1X1 extends BlockContainer
{
    public RoadCoverDynamic1X1(Material material)
    {
        super(material);
        setBlockName("roadcover_dynamic_1x1");
        setHardness(2F);
        setResistance(4.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeStone);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRoadRail);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileRoadCoverDynamic1X1(meta);
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

    /*@Override //actual collision stuff you change
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1F, 0.5F);
    }*/

    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) 
    {
        //cover if tile isn't a thing
        if(world == null || !(world.getTileEntity(x,y,z) instanceof TileRoadCoverDynamic1X1)){
            super.setBlockBoundsBasedOnState(world,x,y,z);
            return;
        }
        //return based on tile data
        switch(((TileRoadCoverDynamic1X1)world.getTileEntity(x,y,z)).dir)
        {
            case 0:
            case 1:
            case 2:
            case 3: {this.setBlockBounds(0F, 0.0F, 0.0F, 1F, 0.06F, 1F); return;}
        }

        //fallback if rotation wasn't understood
        super.setBlockBoundsBasedOnState(world,x,y,z);
        return;
    }

    @Override //this doesn't need changing but it needs inclusion
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB hitboxSelf, List hitboxesOther, Entity collidingEntity)
    {
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
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        //super.onBlockPlacedBy(world, x, y, z, entity, stack);
        //force tile spawn manually and override any existing tile at the space
        TileRoadCoverDynamic1X1 tile = new TileRoadCoverDynamic1X1(MathHelper.floor_double((entity.rotationYaw / 90.0F) + 2.5D) & 3);
        Block block = world.getBlock(x, y - 1, z);
        int blockID = Block.getIdFromBlock(block);
        tile.setRoadCoverMaterial(blockID);
        tile.roadCoverMetadata = world.getBlockMetadata(x, y - 1, z);
        world.setTileEntity(x, + 1,z, tile);
    }

    private IIcon texture;

    @Override
    public IIcon getIcon(int i, int j) {
        return texture;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        texture = iconRegister.registerIcon(FoxBlocks.MODID+ ":constructionmaterials/tarmac/tarmac_dynamic");
    }
}
