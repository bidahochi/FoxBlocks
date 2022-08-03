package com.bidahochi.BlockMod.blocks.stones;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import com.bidahochi.BlockMod.core.handler.ItemIDs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;


public class Taconite extends Block {

    public Taconite(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Taconite");
        setHardness(3F);
        setResistance(4.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypePiston);
        setBlockTextureName(FoxBlocks.MODID+":stones/taconite_ore");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);

    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, new ItemStack(ItemIDs.taconiteCrushed.item));
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
}
