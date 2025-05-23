package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BaseBlockSlab extends BaseAbstractSlab
{
    public BaseBlockSlab(Boolean isDoubleSlab, BlockProperty blockProperty, Block singleSlab, int blockNumberStartingIndex)
    {
        super(isDoubleSlab, blockProperty, singleSlab, blockNumberStartingIndex);
    }

    public void registerBlockIcons(IIconRegister reg)
    {
        textures = new IIcon[8];
        for (int i = 0 ; i < amountOfSubBlocks; i++)
        {
            if (i == 0 && FirstBlockHasNoIndex)
            {
                this.textures[i] = reg.registerIcon(this.textureName);
            }
            else
            {
                this.textures[i] = reg.registerIcon(this.textureName + "_" + (i + BlockNumberStartingIndex));
            }
        }
    }

    /************
     * TEXTURES
     ************/

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.textures[meta & 7];
    }
}
