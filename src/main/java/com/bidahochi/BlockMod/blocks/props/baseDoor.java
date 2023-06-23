package com.bidahochi.BlockMod.blocks.props;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.ItemIDs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class baseDoor extends BlockDoor {
    @SideOnly(Side.CLIENT)
    public IIcon[] iiconA;
    @SideOnly(Side.CLIENT)
    public IIcon[] iiconB;
    public Item doorAitem;

    public baseDoor(Material mat) {
        super(mat);
        float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }


    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.iiconB[0];
    }


    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        if (p_149673_5_ != 1 && p_149673_5_ != 0)
        {
            int i1 = this.func_150012_g(p_149673_1_, p_149673_2_, p_149673_3_, p_149673_4_);
            int j1 = i1 & 3;
            boolean flag = (i1 & 4) != 0;
            boolean flag1 = false;
            boolean flag2 = (i1 & 8) != 0;

            if (flag)
            {
                if (j1 == 0 && p_149673_5_ == 2)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && p_149673_5_ == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && p_149673_5_ == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && p_149673_5_ == 4)
                {
                    flag1 = !flag1;
                }
            }
            else
            {
                if (j1 == 0 && p_149673_5_ == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && p_149673_5_ == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && p_149673_5_ == 4)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && p_149673_5_ == 2)
                {
                    flag1 = !flag1;
                }

                if ((i1 & 16) != 0)
                {
                    flag1 = !flag1;
                }
            }

            return flag2 ? this.iiconA[flag1?1:0] : this.iiconB[flag1?1:0];
        }
        else
        {
            return this.iiconB[0];
        }
    }


    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister doorIcons)
    {
        this.iiconA = new IIcon[2];
        this.iiconB = new IIcon[2];
        this.iiconA[0] = doorIcons.registerIcon(this.getTextureName() + "_upper");
        this.iiconB[0] = doorIcons.registerIcon(this.getTextureName() + "_lower");
        this.iiconA[1] = new IconFlipped(this.iiconA[0], true, false);
        this.iiconB[1] = new IconFlipped(this.iiconB[0], true, false);
    }

    @Override
    public Item getItemDropped(int itemDropped, Random p_149650_2_, int p_149650_3_)
    {
        Item droppedItem;
        if (this.getUnlocalizedName() == "doorA"){
        droppedItem = ItemIDs.doorA.item;
        }
        else {
        droppedItem = ItemIDs.doorB.item;
        }
        return (itemDropped & 8) != 0 ? null : droppedItem;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        Item pickblock;
        if (this.getUnlocalizedName() == "doorA"){
        pickblock = ItemIDs.doorA.item;
        }
        else {
        pickblock = ItemIDs.doorB.item;
        }
        return new ItemStack(pickblock);
    }

}
