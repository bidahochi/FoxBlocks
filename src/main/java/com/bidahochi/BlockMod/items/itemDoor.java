package com.bidahochi.BlockMod.items;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.BlockHandler;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import static com.bidahochi.BlockMod.items.doorA1item.placeDoorBlock;

public class itemDoor extends Item {

    private Material doorMaterial;

    public itemDoor(Material material)
    {
        this.doorMaterial = material;
        this.maxStackSize = 1;
        this.setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);

    }

    /*public void setDoorBlock(Block doorAblock) {
        this.doorAblock = doorAblock;
    }
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int itemInt4, float itemFloat1, float itemFloat2, float itemFloat3)
    {
        if (itemInt4 != 1)
        {
            return false;
        }
        else
        {
            y++;
            Block block;
            /** Here you can define your doors, just make more if statements for each nea door (use the unlocalised name)
             *
            if (this.getUnlocalizedName() == "doorA"){
                block = BlockIDs.doorA.block;
            }

            else {*/
                block = BlockIDs.doorA.block;
          // }




            if (player.canPlayerEdit(x, y, z, itemInt4, item) && player.canPlayerEdit(x, y + 1, z, itemInt4, item))
            {
                if (!block.canPlaceBlockAt(world, x, y, z))//null pointer??
                {
                    return false;
                }
                else
                {
                    int i1 = MathHelper.floor_double((double)((player.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                    placeDoorBlock(world, x, y, z, i1, block);
                    --item.stackSize;
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }

    public static void placeDoorBlock(World world, int x, int y, int z, int meta, Block block)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (meta == 0)
        {
            b1 = 1;
        }

        if (meta == 1)
        {
            b0 = -1;
        }

        if (meta == 2)
        {
            b1 = -1;
        }

        if (meta == 3)
        {
            b0 = 1;
        }

        int i1 = (world.getBlock(x - b0, y, z - b1).isNormalCube() ? 1 : 0) + (world.getBlock(x - b0, y + 1, z - b1).isNormalCube() ? 1 : 0);
        int j1 = (world.getBlock(x + b0, y, z + b1).isNormalCube() ? 1 : 0) + (world.getBlock(x + b0, y + 1, z + b1).isNormalCube() ? 1 : 0);
        boolean flag = world.getBlock(x - b0, y, z - b1) == block || world.getBlock(x - b0, y + 1, z - b1) == block;
        boolean flag1 = world.getBlock(x + b0, y, z + b1) == block || world.getBlock(x + b0, y + 1, z + b1) == block;
        boolean flag2 = false;

        if (flag && !flag1)
        {
            flag2 = true;
        }
        else if (j1 > i1)
        {
            flag2 = true;
        }

        world.setBlock(x, y, z, block, meta, 2);
        world.setBlock(x, y + 1, z, block, 8 | (flag2 ? 1 : 0), 2);
        world.notifyBlocksOfNeighborChange(x, y, z, block);
        world.notifyBlocksOfNeighborChange(x, y + 1, z, block);
    }
}
