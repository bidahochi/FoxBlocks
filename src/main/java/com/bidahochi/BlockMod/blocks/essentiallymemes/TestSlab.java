package com.bidahochi.BlockMod.blocks.essentiallymemes;

/**
 *
 *  This file is the sourcecode for slab code!
 *
 *  Inside the public slab(boolean <if it is 2 high its true, else 1 high false>, Material <material>)
 *
 *  Writing to blockhanders
 *  Use Format:
 *      BlockIDs.<slab>.block = new <slab>(false, Material.<material>);
 *
 *
 *  Any questions just ping or dm me on the discord!
 *
 *  -hariesh
 *  
 */

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public class TestSlab extends BlockSlab {

    public TestSlab(boolean p_i45410_1_, Material p_i45410_2_) {
        super(p_i45410_1_, p_i45410_2_);
        setBlockName("TestSlab");
        setBlockTextureName(FoxBlocks.MODID+":hell/emberStone");
    }

    @Override
    public String func_150002_b(int p_150002_1_) {
        return null;
    }
}


