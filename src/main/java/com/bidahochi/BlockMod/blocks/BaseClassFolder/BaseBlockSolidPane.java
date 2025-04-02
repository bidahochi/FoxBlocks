package com.bidahochi.BlockMod.blocks.BaseClassFolder;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BaseBlockSolidPane extends BaseBlockPane
{
    protected BaseBlockSolidPane(Material material)
    {
        super(material);
    }

    @Override
    public Block setLightOpacity(int p_149713_1_) {
        return super.setLightOpacity(0);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
}
