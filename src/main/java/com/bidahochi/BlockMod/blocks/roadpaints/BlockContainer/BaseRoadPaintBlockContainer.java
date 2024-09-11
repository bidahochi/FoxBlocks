package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRPB;
import com.bidahochi.BlockMod.render.tmt.Vec3f;
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

import java.util.LinkedList;
import java.util.List;

public abstract class BaseRoadPaintBlockContainer extends BlockContainer
{
    private String nameOfIcon;
    public String offset;
    public String color;
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
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileRPB();
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
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.1F, 1F);
    }

    @Override
    public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_)
    {

    }
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        super.onBlockPlacedBy(world, x, y, z, entity, stack);
        world.setTileEntity(x, y, z, new TileRPB(2, color,"straight",offset));
        LinkedList<Vec3f> blocks = getSurrounding(world, x, y, z);
        for (Vec3f offsets: blocks) {
            Block temp = world.getBlock((int) (x+ offsets.xCoord), (int) (y+offsets.yCoord), (int) (z+offsets.zCoord));
            if (temp instanceof BaseRoadPaintBlockContainer) {
                ((BaseRoadPaintBlockContainer) temp).updateTile(world,(int) (x+ offsets.xCoord), (int) (y+offsets.yCoord), (int) (z+offsets.zCoord), entity);
            }
        }
        updateTile(world,x,y,z, entity);

    }

    public LinkedList<Vec3f> getSurrounding(World world, int x, int y, int z) {
        LinkedList<Vec3f> blocks = new LinkedList<>();
        for (int i=-1;i<2;i++) { //x
            for (int j = -1; j < 2; j++) { //y
                for (int k = -1; k < 2; k++) { //z
                    if (world.getBlock(x + i, y + j, z + k) instanceof BaseRoadPaintBlockContainer) {
                        blocks.add(new Vec3f(i, j, k));
                    }
                }
            }
        }
        return blocks;
    }
    public void updateTile(World world, int x, int y, int z, EntityLivingBase entity) {
        //get all of the surrounding blocks that are road lines
        LinkedList<RoadDirections> directions = new LinkedList<>();
        LinkedList<Vec3f> blocks = new LinkedList<>();
        for (int i=-1;i<2;i++) { //x
            for (int j=-1;j<2;j++) { //y
                for (int k=-1;k<2;k++) { //z
                    if (world.getBlock(x+i,y+j,z+k) instanceof BaseRoadPaintBlockContainer) {
                        blocks.add(new Vec3f(i,j,k));
                        if (i<0) {
                            if (k < 0 && !directions.contains(RoadDirections.NORTHWEST)) {
                                directions.add(RoadDirections.NORTHWEST);
                            }
                            else if (k > 0 && !directions.contains(RoadDirections.SOUTHWEST)) {
                                directions.add(RoadDirections.SOUTHWEST);
                            }
                            else if (k == 0 && !directions.contains(RoadDirections.WEST)){
                                directions.add(RoadDirections.WEST);
                            }
                        }
                        else if (i==0) {
                            if (k<0 && !directions.contains(RoadDirections.NORTH)) {
                                directions.add(RoadDirections.NORTH);
                            }
                            else if (k>0 && !directions.contains(RoadDirections.SOUTH)) {
                                directions.add(RoadDirections.SOUTH);
                            }
                        }
                        else {
                            if (k<0 && !directions.contains(RoadDirections.NORTHEAST)) { //NE
                                directions.add(RoadDirections.NORTHEAST);
                            }
                            else if (k==0 && !directions.contains(RoadDirections.EAST)) { //E
                                directions.add(RoadDirections.EAST);
                            }
                            else if (k>0 && !directions.contains(RoadDirections.SOUTHEAST)) { //SE
                                directions.add(RoadDirections.SOUTHEAST);
                            }
                        }
                    }
                }
            }
        }
        //plus
        if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x,y,z, new TileRPB(0, color,"plus",offset));
        }
        //T
        else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.SOUTH)) {
            world.setTileEntity(x,y,z, new TileRPB(0, color,"t",offset));
        }
        else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.WEST) && directions.contains(RoadDirections.SOUTH)) {
            world.setTileEntity(x,y,z, new TileRPB(2, color,"t",offset));
        }
        else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x,y,z, new TileRPB(3, color,"t",offset));
        }
        else if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x,y,z, new TileRPB(1, color,"t",offset));
        }
        //90-turns
        else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.EAST)) {
            world.setTileEntity(x,y,z, new TileRPB(3, color,"turn",offset));
        }
        else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x,y,z, new TileRPB(2, color,"turn",offset));
        }
        else if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.EAST)) {
            world.setTileEntity(x,y,z, new TileRPB(0, color,"turn",offset));
        }
        else if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x,y,z, new TileRPB(1, color,"turn",offset));
        }
        //45 turns
        else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.SOUTHEAST) && !directions.contains(RoadDirections.SOUTH)) {
            world.setTileEntity(x,y,z, new TileRPB(0, color,"diagonal_right",offset));
        }
        else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.SOUTHWEST) && !directions.contains(RoadDirections.SOUTH)) {
            world.setTileEntity(x,y,z, new TileRPB(0, color,"diagonal_left",offset));
        }
        else if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.NORTHEAST) && !directions.contains(RoadDirections.NORTH)) {
            world.setTileEntity(x,y,z, new TileRPB(2, color,"diagonal_left",offset));
        }
        else if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.NORTHWEST) && !directions.contains(RoadDirections.NORTH)) {
            world.setTileEntity(x,y,z, new TileRPB(2, color,"diagonal_right",offset));
        }
        else if (directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.NORTHWEST) && !directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x,y,z, new TileRPB(1, color,"diagonal_left",offset));
        }
        else if (directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.SOUTHWEST) && !directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x,y,z, new TileRPB(1, color,"diagonal_right",offset));
        }
        else if (directions.contains(RoadDirections.WEST) && directions.contains(RoadDirections.NORTHEAST) && !directions.contains(RoadDirections.EAST)) {
            world.setTileEntity(x,y,z, new TileRPB(3, color,"diagonal_right",offset));
        }
        else if (directions.contains(RoadDirections.WEST) && directions.contains(RoadDirections.SOUTHEAST) && !directions.contains(RoadDirections.EAST)) {
            world.setTileEntity(x,y,z, new TileRPB(3, color,"diagonal_left",offset));
        }
        //straights
        else if (((directions.contains(RoadDirections.NORTH) || directions.contains(RoadDirections.SOUTH)) && directions.size()==1) || (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.SOUTH))) {
            world.setTileEntity(x,y,z, new TileRPB(2, color,"straight",offset));
        }
        else if (((directions.contains(RoadDirections.EAST) || directions.contains(RoadDirections.WEST)) && directions.size()==1) || (directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.WEST))) {
            world.setTileEntity(x,y,z, new TileRPB(3, color,"straight",offset));
        }
        else if (((directions.contains(RoadDirections.NORTHEAST) || directions.contains(RoadDirections.SOUTHWEST)) && directions.size()==1) || (directions.contains(RoadDirections.NORTHEAST) && directions.contains(RoadDirections.SOUTHWEST))) {
            world.setTileEntity(x,y,z, new TileRPB(1, color,"diagonal",offset));
        }
        else if (((directions.contains(RoadDirections.NORTHWEST) || directions.contains(RoadDirections.SOUTHEAST)) && directions.size()==1) || (directions.contains(RoadDirections.NORTHWEST) && directions.contains(RoadDirections.SOUTHEAST))) {
            world.setTileEntity(x,y,z, new TileRPB(2, color,"diagonal",offset));
        }
        else if (directions.contains(RoadDirections.WEST) || directions.contains(RoadDirections.EAST)) {
            world.setTileEntity(x,y,z, new TileRPB(1, color,"straight",offset));
        }
        else {
            world.setTileEntity(x,y,z, new TileRPB(getDir(entity), color,"straight",offset));
        }
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

enum RoadDirections {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    NORTHEAST,
    NORTHWEST,
    SOUTHEAST,
    SOUTHWEST
}
