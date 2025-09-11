package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer;

import com.bidahochi.BlockMod.blocks.roadpaints.RoadDirections;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRPB;
import com.bidahochi.BlockMod.render.tmt.Vec3f;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.LinkedList;

public class RoadPaintBlockOffsetInsideDiagonal extends BaseRoadPaintBlockContainer {
    public RoadPaintBlockOffsetInsideDiagonal(Material mat) {
        super(mat);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        world.setTileEntity(x, y, z, new TileRPB(getDir(entity), color, "diagonal_extended", offset));
        updateTile(world, x, y, z, entity);
    }

    @Override
    public LinkedList<Vec3f> getSurrounding(World world, int x, int y, int z) {
        LinkedList<Vec3f> blocks = new LinkedList<>();
        for (int i = -1; i < 2; i++) { //x
            for (int j = -1; j < 2; j++) { //y
                for (int k = -1; k < 2; k++) { //z
                    if (world.getBlock(x + i, y + j, z + k) instanceof RoadPaintBlockOffsetInsideDiagonal) {
                        blocks.add(new Vec3f(i, j, k));
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
                    if (world.getBlock(x + i, y + j, z + k) instanceof RoadPaintBlockOffsetInsideDiagonal &&
                    ((RoadPaintBlockOffsetInsideDiagonal) world.getBlock(x + i, y + j, z + k)).color.equalsIgnoreCase(color)) {
                        //blocks.add(new Vec3f(i, j, k));
                        if (i < 0) {
                            if (k < 0 && !directions.contains(RoadDirections.NORTHWEST)) {
                                directions.add(RoadDirections.NORTHWEST);
                                directionMap.put(RoadDirections.NORTHWEST, ((TileRPB) world.getTileEntity(x + i, y + j, z + k)).getDir());
                            } else if (k > 0 && !directions.contains(RoadDirections.SOUTHWEST)) {
                                directions.add(RoadDirections.SOUTHWEST);
                                directionMap.put(RoadDirections.SOUTHWEST, ((TileRPB) world.getTileEntity(x + i, y + j, z + k)).getDir());
                            } else if (k == 0 && !directions.contains(RoadDirections.WEST)) {
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
                            if (k < 0 && !directions.contains(RoadDirections.NORTHEAST)) { //NE
                                directions.add(RoadDirections.NORTHEAST);
                                directionMap.put(RoadDirections.NORTHEAST, ((TileRPB) world.getTileEntity(x + i, y + j, z + k)).getDir());
                            } else if (k == 0 && !directions.contains(RoadDirections.EAST)) { //E
                                directions.add(RoadDirections.EAST);
                                directionMap.put(RoadDirections.EAST, ((TileRPB) world.getTileEntity(x + i, y + j, z + k)).getDir());
                            } else if (k > 0 && !directions.contains(RoadDirections.SOUTHEAST)) { //SE
                                directions.add(RoadDirections.SOUTHEAST);
                                directionMap.put(RoadDirections.SOUTHEAST, ((TileRPB) world.getTileEntity(x + i, y + j, z + k)).getDir());
                            }
                        }
                    }
                }
            }
        }
        if (entity.isSneaking()) {
            if (directions.contains(RoadDirections.NORTH)) {
                if (getDir(entity) == 2) {
                    world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal", offset));
                    return;
                }
                if (getDir(entity) == 1) {
                    world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal2", offset));
                    return;
                }
                if (getDir(entity) == 3) {
                    world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal", offset));
                    return;
                }
            }
            if (directions.contains(RoadDirections.SOUTH)) {
                if (getDir(entity) == 0) {
                    world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal2", offset));
                    return;
                }
            }
            if (directions.contains(RoadDirections.EAST)) {
                if (getDir(entity) == 1) {
                    world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal", offset));
                    return;
                }
                if (getDir(entity) == 0) {
                    world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal", offset));
                    return;
                }
                if (getDir(entity) == 2) {
                    world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal2", offset));
                    return;
                }
            }
            if (directions.contains(RoadDirections.WEST)) {
                if (getDir(entity) == 1) {
                    world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal", offset));
                    return;
                }
                if (getDir(entity) == 0) {
                    world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal2", offset));
                    return;
                }
            }
            world.setTileEntity(x, y, z, new TileRPB(getDir(entity)+1>3?((getDir(entity)+1)%3) :getDir(entity)+1, color, "diagonal_extended2", offset));
        }
        else {
            if (directions.contains(RoadDirections.NORTH)) {
                if (getDir(entity) == 2) {
                    world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal2", offset));
                    return;
                }
                if (getDir(entity) == 1) {
                    world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal", offset));
                    return;
                }
                if (getDir(entity) == 3) {
                    world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal2", offset));
                    return;
                }
            }
            if (directions.contains(RoadDirections.SOUTH)) {
                if (getDir(entity) == 0) {
                    world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal2", offset));
                    return;
                }
            }
            if (directions.contains(RoadDirections.EAST)) {
                if (getDir(entity) == 3 || getDir(entity) == 1) {
                    world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal2", offset));
                    return;
                }
                if (getDir(entity) == 2) {
                    world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal", offset));
                    return;
                }
            }
            if (directions.contains(RoadDirections.WEST)) {
                if (getDir(entity) == 1) {
                    world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal2", offset));
                    return;
                }
                if (getDir(entity) == 0) {
                    world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal", offset));
                    return;
                }
            }
            world.setTileEntity(x, y, z, new TileRPB(getDir(entity)-1<0?3:getDir(entity)-1, color, "diagonal_extended", offset));
        }







        //the following code is the dynamic line placement which was too buggy to be used. Its ~70% there, but that last 30% is a real deal-breaker.
        //may revisit it in the future.
/*        //diagonal
        if (directions.contains(RoadDirections.NORTHWEST) && directions.contains(RoadDirections.SOUTHEAST)) {
            if ((directionMap.get(RoadDirections.NORTHWEST) == 2 || directionMap.get(RoadDirections.NORTHWEST) == 3)
                    && (directionMap.get(RoadDirections.SOUTHEAST) == 3 || directionMap.get(RoadDirections.SOUTHEAST) == 2)) {
                if (getDir(entity) == 2) {
                    world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal_extended2", offset));
                    return;
                }
                else if (getDir(entity) == 3) {
                    world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal_extended", offset));
                    return;
                }
            }
            else if ((directionMap.get(RoadDirections.NORTHWEST) == 0 || directionMap.get(RoadDirections.NORTHWEST) == 1)
                    && (directionMap.get(RoadDirections.SOUTHEAST) == 1 || directionMap.get(RoadDirections.SOUTHEAST) == 0)) {
                if (getDir(entity) == 0) {
                    world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal_extended2", offset));
                    return;
                }
                else if (getDir(entity) == 1) {
                    world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal_extended", offset));
                    return;
                }
            }
            else if (directionMap.get(RoadDirections.NORTHWEST) == 2
                    && (directionMap.get(RoadDirections.SOUTHEAST) == 1) || directionMap.get(RoadDirections.SOUTHEAST) == 0) {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal", offset));
                return;
            }
        }

        if (directions.contains(RoadDirections.NORTHEAST) && directions.contains(RoadDirections.SOUTHWEST)) {
            if ((directionMap.get(RoadDirections.NORTHEAST) == 3 || directionMap.get(RoadDirections.NORTHEAST) == 0)
                    && (directionMap.get(RoadDirections.SOUTHWEST) == 0 || directionMap.get(RoadDirections.SOUTHWEST) == 3)) {
                if (getDir(entity) == 3) {
                    world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal_extended2", offset));
                    return;
                }
                if (getDir(entity) == 0) {
                    world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal_extended", offset));
                    return;
                }
            }
            if ((directionMap.get(RoadDirections.NORTHEAST) == 1) || (directionMap.get(RoadDirections.NORTHEAST) == 2)
            && (directionMap.get(RoadDirections.SOUTHWEST) == 1 || directionMap.get(RoadDirections.SOUTHWEST) == 2)) {
                if (getDir(entity) == 1) {
                    world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal_extended2", offset));
                    return;
                }
                if (getDir(entity) == 2) {
                    world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal_extended", offset));
                    return;
                }
            }
            if (directionMap.get(RoadDirections.SOUTHWEST) == 2 && directionMap.get(RoadDirections.NORTHEAST) == 0) {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal_extended2", offset));
                return;
            }
        }

        if (directions.contains(RoadDirections.NORTHWEST) && directions.contains(RoadDirections.SOUTH)) {
            if ((directionMap.get(RoadDirections.NORTHWEST) == 1 || (directionMap.get(RoadDirections.NORTHWEST) == 3)) && directionMap.get(RoadDirections.SOUTH) == 0) {
                world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal_extended2", offset));
                return;
            }
        }
        if (directions.contains(RoadDirections.NORTHWEST) && directions.contains(RoadDirections.EAST)) {
            if (directionMap.get(RoadDirections.NORTHWEST) == 0 && directionMap.get(RoadDirections.EAST) == 1) {
                world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal_extended", offset));
                return;
            }
            if (directionMap.get(RoadDirections.NORTHWEST) == 3 && directionMap.get(RoadDirections.EAST) == 1) {
                world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal", offset));
                return;
            }
        }

        if (directions.contains(RoadDirections.NORTHEAST) && directions.contains(RoadDirections.SOUTH)) {
            if (directionMap.get(RoadDirections.NORTHEAST) == 1 && directionMap.get(RoadDirections.SOUTH) == 2) {
                world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal_extended", offset));
                return;
            }
            if (directionMap.get(RoadDirections.NORTHEAST) == 0 && directionMap.get(RoadDirections.SOUTH) == 2) {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal", offset));
                return;

            }
        }
        if (directions.contains(RoadDirections.NORTHEAST) && directions.contains(RoadDirections.WEST)) {
            if (directionMap.get(RoadDirections.NORTHEAST) == 2 && directionMap.get(RoadDirections.WEST) == 1) {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal_extended2", offset));
                return;
            }
        }

        if (directions.contains(RoadDirections.SOUTHWEST) && directions.contains(RoadDirections.NORTH)) {
            if (directionMap.get(RoadDirections.SOUTHWEST) == 3 && directionMap.get(RoadDirections.NORTH) == 0) {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal_extended", offset));
                return;
            }
            if (directionMap.get(RoadDirections.SOUTHWEST) == 2 && directionMap.get(RoadDirections.NORTH) == 0) {
                world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal", offset));
                return;
            }
        }
        if (directions.contains(RoadDirections.SOUTHWEST) && directions.contains(RoadDirections.EAST)) {
            if (directionMap.get(RoadDirections.SOUTHWEST) == 0 && directionMap.get(RoadDirections.EAST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal_extended2", offset));
                return;
            }
        }

        if (directions.contains(RoadDirections.SOUTHEAST) && directions.contains(RoadDirections.NORTH)) {
            if (directionMap.get(RoadDirections.SOUTHEAST) == 3 && directionMap.get(RoadDirections.NORTH) == 2) { //#!# add 2 to SOUTHEAST
                world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal_extended2", offset));
                return;
            }
        }
        if (directions.contains(RoadDirections.SOUTHEAST) && directions.contains(RoadDirections.WEST)) {
            if (directionMap.get(RoadDirections.SOUTHEAST) == 2 && directionMap.get(RoadDirections.WEST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal_extended", offset));
                return;
            }
            if (directionMap.get(RoadDirections.SOUTHEAST) == 1 && directionMap.get(RoadDirections.WEST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal", offset));
                return;
            }
            if (directionMap.get(RoadDirections.SOUTHEAST) == 1 && directionMap.get(RoadDirections.WEST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal", offset));
                return;
            }
        }

        //straight to 45 transition



        //90-turns
        if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.EAST)) {
            if (directionMap.get(RoadDirections.NORTH) == 0 && directionMap.get(RoadDirections.EAST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(0, color, "turn2", offset));
            }
            else if (directionMap.get(RoadDirections.NORTH) == 1 && directionMap.get(RoadDirections.EAST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "diagonal2", offset));
            }
            else {
                world.setTileEntity(x, y, z, new TileRPB(1, color, "turn", offset));
            }
            return;
        }
        if (directions.contains(RoadDirections.NORTH) && directions.contains(RoadDirections.WEST)) {
            if (directionMap.get(RoadDirections.NORTH) == 2 && directionMap.get(RoadDirections.WEST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "turn2", offset));
            }
            else if (directionMap.get(RoadDirections.NORTH) == 1 && directionMap.get(RoadDirections.WEST) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "diagonal2", offset));
            }
            else {
                world.setTileEntity(x, y, z, new TileRPB(0, color, "turn", offset));
            }
            return;
        }
        if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.EAST)) {
            if (directionMap.get(RoadDirections.SOUTH) == 0 && directionMap.get(RoadDirections.EAST) == 1) {
                world.setTileEntity(x, y, z, new TileRPB(1, color, "turn2", offset));
            }
            else if (directionMap.get(RoadDirections.SOUTH) == 0 && directionMap.get(RoadDirections.EAST) == 2) {
                world.setTileEntity(x, y, z, new TileRPB(0, color, "diagonal2", offset));
            }
            else {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "turn", offset));
            }
            return;
        }
        if (directions.contains(RoadDirections.SOUTH) && directions.contains(RoadDirections.WEST)) {
            if (directionMap.get(RoadDirections.SOUTH) == 2 && directionMap.get(RoadDirections.WEST) == 1) {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "turn2", offset));
            }
            else if (directionMap.get(RoadDirections.SOUTH) == 3 && directionMap.get(RoadDirections.WEST) == 1){
                    world.setTileEntity(x, y, z, new TileRPB(1, color, "diagonal2", offset));
            }
            else {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "turn", offset));
            }
            return;
        }

        //straights
        if (directions.contains(RoadDirections.EAST) || directions.contains(RoadDirections.WEST)) {
            if (getDir(entity) == 3) {
                world.setTileEntity(x, y, z, new TileRPB(3, color, "straight", offset));
                return;
            } else if (getDir(entity) == 1) {
                world.setTileEntity(x, y, z, new TileRPB(1, color, "straight", offset));
                return;
            }
        }
        if (directions.contains(RoadDirections.NORTH) || directions.contains(RoadDirections.SOUTH)) {
            if (getDir(entity) == 2) {
                world.setTileEntity(x, y, z, new TileRPB(2, color, "straight", offset));
            } else if (getDir(entity) == 0) {
                world.setTileEntity(x, y, z, new TileRPB(0, color, "straight", offset));
            }
        }
        else {
            world.setTileEntity(x, y, z, new TileRPB(getDir(entity), color, "straight", offset));
        }*/
    }
}
