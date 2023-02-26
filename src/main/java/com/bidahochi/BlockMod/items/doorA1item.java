package com.bidahochi.BlockMod.items;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class doorA1item extends Item {

    //private Material doorMaterial;
    //private static final String __OBFID = "CL_00000020";
    public Block doorAblock;

    public doorA1item(Material mats)
    {
        //this.doorMaterial = mats;
        this.maxStackSize = 1;
        this.setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
        this.setUnlocalizedName("doorA");
        this.setTextureName("doorA");
    }

    public void setDoorBlock(Block doorBlock) {
        this.doorAblock = doorBlock;
    }
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack itemstackInt, EntityPlayer itemPlayerInt, World itemWorldInt, int itemInt1, int itemInt2, int itemInt3, int itemInt4, float itemFloat1, float itemFloat2, float itemFloat3)
    {
        if (itemInt4 != 1)
        {
            return false;
        }
        else
        {
            ++itemInt2;
            //Block blockthing = BlockHandler.BlockIDs.doorA.block;
            //public static final Block wooden_door = (Block)Block.blockRegistry.getObject("wooden_door");

            /*if (this.doorMaterial == Material.wood)
            {
                block = Blocks.wooden_door;
            }*/

            if (itemPlayerInt.canPlayerEdit(itemInt1, itemInt2, itemInt3, itemInt4, itemstackInt) && itemPlayerInt.canPlayerEdit(itemInt1, itemInt2 + 1, itemInt3, itemInt4, itemstackInt))
            {
                if (!this.doorAblock.canPlaceBlockAt(itemWorldInt, itemInt1, itemInt2, itemInt3))
                {
                    return false;
                }
                else
                {
                    int i1 = MathHelper.floor_double((double)((itemPlayerInt.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                    placeDoorBlock(itemWorldInt, itemInt1, itemInt2, itemInt3, i1, this.doorAblock);
                    --itemstackInt.stackSize;
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }

    public static void placeDoorBlock(World placeWorld, int placeInt1, int placeInt2, int placeInt3, int placeInt4, Block placeBlocke)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (placeInt4 == 0)
        {
            b1 = 1;
        }

        if (placeInt4 == 1)
        {
            b0 = -1;
        }

        if (placeInt4 == 2)
        {
            b1 = -1;
        }

        if (placeInt4 == 3)
        {
            b0 = 1;
        }

        int i1 = (placeWorld.getBlock(placeInt1 - b0, placeInt2, placeInt3 - b1).isNormalCube() ? 1 : 0) + (placeWorld.getBlock(placeInt1 - b0, placeInt2 + 1, placeInt3 - b1).isNormalCube() ? 1 : 0);
        int j1 = (placeWorld.getBlock(placeInt1 + b0, placeInt2, placeInt3 + b1).isNormalCube() ? 1 : 0) + (placeWorld.getBlock(placeInt1 + b0, placeInt2 + 1, placeInt3 + b1).isNormalCube() ? 1 : 0);
        boolean flag = placeWorld.getBlock(placeInt1 - b0, placeInt2, placeInt3 - b1) == placeBlocke || placeWorld.getBlock(placeInt1 - b0, placeInt2 + 1, placeInt3 - b1) == placeBlocke;
        boolean flag1 = placeWorld.getBlock(placeInt1 + b0, placeInt2, placeInt3 + b1) == placeBlocke || placeWorld.getBlock(placeInt1 + b0, placeInt2 + 1, placeInt3 + b1) == placeBlocke;
        boolean flag2 = false;

        if (flag && !flag1)
        {
            flag2 = true;
        }
        else if (j1 > i1)
        {
            flag2 = true;
        }

        placeWorld.setBlock(placeInt1, placeInt2, placeInt3, placeBlocke, placeInt4, 2);
        placeWorld.setBlock(placeInt1, placeInt2 + 1, placeInt3, placeBlocke, 8 | (flag2 ? 1 : 0), 2);
        placeWorld.notifyBlocksOfNeighborChange(placeInt1, placeInt2, placeInt3, placeBlocke);
        placeWorld.notifyBlocksOfNeighborChange(placeInt1, placeInt2 + 1, placeInt3, placeBlocke);
    }
}
