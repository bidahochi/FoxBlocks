package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer;

import com.bidahochi.BlockMod.blocks.roadpaints.RoadDirections;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRPB;
import com.bidahochi.BlockMod.render.tmt.Vec3f;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.LinkedList;

public class RoadPaintBlockOffsetInsideStraight extends BaseRoadPaintBlockContainer {
    public RoadPaintBlockOffsetInsideStraight(Material mat) {
        super(mat);
    }


    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        LinkedList<Vec3f> blocks = getSurrounding(world, x, y, z);
        updateTile(world, x, y, z, entity);
        for (Vec3f offsets : blocks) {
            Block temp = world.getBlock((int) (x + offsets.xCoord), (int) (y + offsets.yCoord), (int) (z + offsets.zCoord));
            if (temp instanceof RoadPaintBlockOffsetInsideStraight) {
                ((RoadPaintBlockOffsetInsideStraight) temp).updateTile(world, (int) (x + offsets.xCoord), (int) (y + offsets.yCoord), (int) (z + offsets.zCoord), entity);
            }
        }
    }

    @Override
    public LinkedList<Vec3f> getSurrounding(World world, int x, int y, int z) {
        LinkedList<Vec3f> blocks = new LinkedList<>();
        for (int i = -1; i < 2; i++) { //x
            for (int j = -1; j < 2; j++) { //y
                for (int k = -1; k < 2; k++) { //z
                    if (i == 0 || k == 0) {
                        if (world.getBlock(x + i, y + j, z + k) instanceof RoadPaintBlockOffsetInsideStraight) {
                            blocks.add(new Vec3f(i, j, k));
                        }
                    }
                }
            }
        }
        return blocks;
    }


    @Override
    public void updateTile(World world, int x, int y, int z, EntityLivingBase entity) {
        //get all the surrounding blocks that are road lines
        LinkedList<RoadDirections> directions = new LinkedList<>();
        HashMap<RoadDirections, Integer> directionMap = new HashMap<RoadDirections, Integer>();
        for (int i = -1; i < 2; i++) { //x
            for (int j = -1; j < 2; j++) { //y
                for (int k = -1; k < 2; k++) { //z
                    if (world.getBlock(x + i, y + j, z + k) instanceof RoadPaintBlockOffsetInsideStraight) {
                        //blocks.add(new Vec3f(i, j, k));
                        if (i < 0) {
                            if (k == 0 && !directions.contains(RoadDirections.WEST)) {
                                directions.add(RoadDirections.WEST);
                                directionMap.put(RoadDirections.WEST, ((TileRPB) world.getTileEntity(x + i, y + j, z + k)).getDir());
                            }
                        } else if (i == 0) {
                            if (k < 0 && !directions.contains(RoadDirections.NORTH)) {
                                directions.add(RoadDirections.NORTH);
                                directionMap.put(RoadDirections.NORTH, ((TileRPB) world.getTileEntity(x + i, y + j, z + k)).getDir());
                            } else if (k > 0 && !directions.contains(RoadDirections.SOUTH)) {
                                directions.add(RoadDirections.SOUTH);
                                directionMap.put(RoadDirections.SOUTH, ((TileRPB) world.getTileEntity(x + i, y + j, z + k)).getDir());
                            }
                        } else {
                            if (k == 0 && !directions.contains(RoadDirections.EAST)) { //E
                                directions.add(RoadDirections.EAST);
                                directionMap.put(RoadDirections.EAST, ((TileRPB) world.getTileEntity(x + i, y + j, z + k)).getDir());
                            }
                        }
                    }
                }
            }
        }
        System.out.println(getDir(entity));
        //turns
        if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.EAST)) {
            if (directionMap.get(RoadDirections.NORTH) == 0 && directionMap.get(RoadDirections.EAST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(0, color, "turn2", offset));
                return;
            }

            if (directionMap.get(RoadDirections.NORTH) == 2 && (directionMap.get(RoadDirections.EAST) == 1 || directionMap.get(RoadDirections.EAST) == 2)) {
                world.setTileEntity(x, y, z, new TileRPB(1, color, "turn", offset));
                return;
            }
        }
        if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.WEST)) {
            if (directionMap.get(RoadDirections.NORTH) == 2 && directionMap.get(RoadDirections.WEST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "turn2", offset));
                return;
            }
            if ((directionMap.get(RoadDirections.NORTH) == 1 || directionMap.get(RoadDirections.NORTH) == 0)
                    && directionMap.get(RoadDirections.WEST) == 1) {
                world.setTileEntity(x, y, z, new TileRPB(0, color, "turn", offset));
                return;
            }
        }
        if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.EAST)) {
            if (directionMap.get(RoadDirections.SOUTH) == 0 && directionMap.get(RoadDirections.EAST) == 1) {
                world.setTileEntity(x, y, z, new TileRPB(1, color, "turn2", offset));
                return;
            }
            if ((directionMap.get(RoadDirections.SOUTH) == 2 || directionMap.get(RoadDirections.SOUTH) == 3) && directionMap.get(RoadDirections.EAST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "turn", offset));
                return;
            }
        }
        if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.WEST)) {
            if (directionMap.get(RoadDirections.SOUTH) == 2 && directionMap.get(RoadDirections.WEST) == 1) {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "turn2", offset));
                return;
            }

            if (directionMap.get(RoadDirections.SOUTH) == 0 && (directionMap.get(RoadDirections.WEST) == 3|| directionMap.get(RoadDirections.WEST) == 0)) {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "turn", offset));
                return;
            }
        }

        //straight
        if (directions.contains(RoadDirections.EAST) || directions.contains(RoadDirections.WEST)) {
            if (getDir(entity) == 1) {
                world.setTileEntity(x, y, z, new TileRPB(1, color, "straight", offset));
                return;
            }
            if (getDir(entity) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "straight", offset));
            }
            else {
                world.setTileEntity(x, y, z, new TileRPB(getDir(entity), color, "straight", offset));
            }
        }
        else if (directions.contains(RoadDirections.NORTH) || directions.contains(RoadDirections.SOUTH)) {
            if (getDir(entity) == 0) {
                world.setTileEntity(x, y, z, new TileRPB(0, color, "straight", offset));
                return;
            }
            if (getDir(entity) == 2) {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "straight", offset));
            }
            else {
                world.setTileEntity(x, y, z, new TileRPB(getDir(entity), color, "straight", offset));
            }
        }
        else {
            world.setTileEntity(x, y, z, new TileRPB(getDir(entity), color, "straight", offset));
        }
    }
}
