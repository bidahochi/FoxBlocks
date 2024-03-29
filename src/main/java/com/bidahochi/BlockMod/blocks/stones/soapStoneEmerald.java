package com.bidahochi.BlockMod.blocks.stones;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class soapStoneEmerald extends Block {
    public soapStoneEmerald(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Emerald Soapstone Ore");
        setHardness(2.5F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 2);
        setStepSound(soundTypeStone);
        setBlockTextureName(FoxBlocks.MODID+":stones/soapstone_emerald");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
    }
    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, new ItemStack(Items.emerald));
    }

    public void dropXpOnBlockBreak(World p_149657_1_, int p_149657_2_, int p_149657_3_, int p_149657_4_, int p_149657_5_)
    {
        if (!p_149657_1_.isRemote)
        {
            while (p_149657_5_ > 0)
            {
                int i1 = EntityXPOrb.getXPSplit(p_149657_5_);
                p_149657_5_ -= i1;
                p_149657_1_.spawnEntityInWorld(new EntityXPOrb(p_149657_1_, (double)p_149657_2_ + 0.5D, (double)p_149657_3_ + 0.5D, (double)p_149657_4_ + 0.5D, i1));
            }
        }
    }
}
