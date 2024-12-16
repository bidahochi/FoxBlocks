package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer;

import com.bidahochi.BlockMod.blocks.roadpaints.RoadDirections;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRPB;
import com.bidahochi.BlockMod.render.tmt.Vec3f;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

import java.util.LinkedList;

public class RoadPaintBlockCenter extends BaseRoadPaintBlockContainer{
    public RoadPaintBlockCenter(Material mat) {
        super(mat);
    }

    @Override
    public void updateTile(World world, int x, int y, int z, EntityLivingBase entity) {
        //get all of the surrounding blocks that are road lines
        LinkedList<RoadDirections> directions = new LinkedList<>();
        LinkedList<Vec3f> blocks = new LinkedList<>();
        for (int i = -1; i < 2; i++) { //x
            for (int j = -1; j < 2; j++) { //y
                for (int k = -1; k < 2; k++) { //z
                    if (world.getBlock(x + i, y + j, z + k) instanceof RoadPaintBlockCenter &&
                    ((RoadPaintBlockCenter) world.getBlock(x + i, y + j, z + k)).color.equalsIgnoreCase(color)) {
                        blocks.add(new Vec3f(i, j, k));
                        if (i < 0) {
                            if (k < 0 && !directions.contains(RoadDirections.NORTHWEST)) {
                                directions.add(RoadDirections.NORTHWEST);
                            } else if (k > 0 && !directions.contains(RoadDirections.SOUTHWEST)) {
                                directions.add(RoadDirections.SOUTHWEST);
                            } else if (k == 0 && !directions.contains(RoadDirections.WEST)) {
                                directions.add(RoadDirections.WEST);
                            }
                        } else if (i == 0) {
                            if (k < 0 && !directions.contains(RoadDirections.NORTH)) {
                                directions.add(RoadDirections.NORTH);
                            } else if (k > 0 && !directions.contains(RoadDirections.SOUTH)) {
                                directions.add(RoadDirections.SOUTH);
                            }
                        } else {
                            if (k < 0 && !directions.contains(RoadDirections.NORTHEAST)) { //NE
                                directions.add(RoadDirections.NORTHEAST);
                            } else if (k == 0 && !directions.contains(RoadDirections.EAST)) { //E
                                directions.add(RoadDirections.EAST);
                            } else if (k > 0 && !directions.contains(RoadDirections.SOUTHEAST)) { //SE
                                directions.add(RoadDirections.SOUTHEAST);
                            }
                        }
                    }
                }
            }
        }
        //plus
        if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x, y, z, new TileRPB(0, color, "plus", offset));
        }
        else if (directions.contains(RoadDirections.NORTHEAST) && directions.contains(RoadDirections.NORTHWEST) &&
        directions.contains(RoadDirections.SOUTHEAST) && directions.contains(RoadDirections.SOUTHWEST)) {
            world.setTileEntity(x, y, z, new TileRPB(0, color, "dplus", offset));
        }
        //T
        else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.SOUTH)) {
            world.setTileEntity(x, y, z, new TileRPB(3, color, "t", offset));
        } else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.WEST) && directions.contains(RoadDirections.SOUTH)) {
            world.setTileEntity(x, y, z, new TileRPB(1, color, "t", offset));
        } else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x, y, z, new TileRPB(2, color, "t", offset));
        } else if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x, y, z, new TileRPB(0, color, "t", offset));
        }

        else if (directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.NORTHWEST)) {
            world.setTileEntity(x, y, z, new TileRPB(0, color, "y", offset));
        } else if (directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.SOUTHWEST)) {
            world.setTileEntity(x, y, z, new TileRPB(3, color, "y", offset));
        } else if (directions.contains(RoadDirections.WEST) && directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.SOUTHEAST)) {
            world.setTileEntity(x, y, z, new TileRPB(2, color, "y", offset));
        } else if (directions.contains(RoadDirections.WEST) && directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.NORTHEAST)) {
            world.setTileEntity(x, y, z, new TileRPB(1, color, "y", offset));
        }

        //90-turns
        else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.EAST)) {
            world.setTileEntity(x, y, z, new TileRPB(3, color, "turn", offset));
        } else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x, y, z, new TileRPB(2, color, "turn", offset));
        } else if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.EAST)) {
            world.setTileEntity(x, y, z, new TileRPB(0, color, "turn", offset));
        } else if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x, y, z, new TileRPB(1, color, "turn", offset));
        }
        //45 turns
        else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.SOUTHEAST) && !directions.contains(RoadDirections.SOUTH)) {
            world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal_right", offset));
        } else if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.SOUTHWEST) && !directions.contains(RoadDirections.SOUTH)) {
            world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal_left", offset));
        } else if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.NORTHEAST) && !directions.contains(RoadDirections.NORTH)) {
            world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal_left", offset));
        } else if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.NORTHWEST) && !directions.contains(RoadDirections.NORTH)) {
            world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal_right", offset));
        } else if (directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.NORTHWEST) && !directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal_left", offset));
        } else if (directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.SOUTHWEST) && !directions.contains(RoadDirections.WEST)) {
            world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal_right", offset));
        } else if (directions.contains(RoadDirections.WEST) && directions.contains(RoadDirections.NORTHEAST) && !directions.contains(RoadDirections.EAST)) {
            world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal_right", offset));
        } else if (directions.contains(RoadDirections.WEST) && directions.contains(RoadDirections.SOUTHEAST) && !directions.contains(RoadDirections.EAST)) {
            world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal_left", offset));
        }
        //straights
        else if (((directions.contains(RoadDirections.NORTH) || directions.contains(RoadDirections.SOUTH)) && directions.size() == 1) || (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.SOUTH))) {
            world.setTileEntity(x, y, z, new TileRPB(2, color, "straight", offset));
        } else if (((directions.contains(RoadDirections.EAST) || directions.contains(RoadDirections.WEST)) && directions.size() == 1) || (directions.contains(RoadDirections.EAST) && directions.contains(RoadDirections.WEST))) {
            world.setTileEntity(x, y, z, new TileRPB(3, color, "straight", offset));
        } else if (((directions.contains(RoadDirections.NORTHEAST) || directions.contains(RoadDirections.SOUTHWEST)) && directions.size() == 1) || (directions.contains(RoadDirections.NORTHEAST) && directions.contains(RoadDirections.SOUTHWEST))) {
            world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal", offset));
        } else if (((directions.contains(RoadDirections.NORTHWEST) || directions.contains(RoadDirections.SOUTHEAST)) && directions.size() == 1) || (directions.contains(RoadDirections.NORTHWEST) && directions.contains(RoadDirections.SOUTHEAST))) {
            world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal", offset));
        } else if (directions.contains(RoadDirections.WEST) || directions.contains(RoadDirections.EAST)) {
            world.setTileEntity(x, y, z, new TileRPB(1, color, "straight", offset));
        } else if (directions.contains(RoadDirections.NORTH) || directions.contains(RoadDirections.SOUTH)) {
            world.setTileEntity(x, y, z, new TileRPB(0, color, "straight", offset));
        } else {
            world.setTileEntity(x, y, z, new TileRPB(getDir(entity), color, "straight", offset));
        }
    }

}
