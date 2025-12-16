package com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys;

import com.bidahochi.BlockMod.core.handler.IFoxBlockIDs;
import com.bidahochi.BlockMod.core.handler.ItemIDs;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class OreBlockProperty extends BlockProperty
{
    public ItemIDs itemDropOverride = null;

    public OreBlockProperty(Block block, float blockResistance, String toolClass, int harvestLevel, int totalTextureCount, String texturePath)
    {
        super(block, blockResistance, toolClass, harvestLevel, totalTextureCount, texturePath);
    }

    public OreBlockProperty(IFoxBlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab)
    {
        super(block, material, blockHardness, blockResistance, toolClass, harvestLevel, soundType, totalTextureCount, texturePath, creativeTab);
    }

    public OreBlockProperty(IFoxBlockIDs block, Material material, float blockHardness, float blockResistance, String toolClass, int harvestLevel, Block.SoundType soundType, int totalTextureCount, String texturePath, CreativeTabs creativeTab, boolean firstBlockHasNoIndex)
    {
        super(block, material, blockHardness, blockResistance, toolClass, harvestLevel, soundType, totalTextureCount, texturePath, creativeTab, firstBlockHasNoIndex);
    }


    @Override
    public Block getNewBlock()
    {
        return new BaseBlock(this)
        {
            @Override
            protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_)
            {
                if (itemDropOverride != null)
                {
                    super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, new ItemStack(itemDropOverride.item));
                }
                else
                {
                    super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
                }

            }

            public int quantityDropped(Random r)
            {
                return 3 + r.nextInt(2);
            }

            private Random rand = new Random();
            @Override // World, meta, fortune
            public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
            {
                if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
                {
                    return 1 + rand.nextInt(5);
                }
                return 0;
            }
        };
    }

    @Override
    public boolean IsWallBlockAllowed()
    {
        return false;
    }

    @Override
    public boolean Is1XTileAllowed()
    {
        return false;
    }
}
