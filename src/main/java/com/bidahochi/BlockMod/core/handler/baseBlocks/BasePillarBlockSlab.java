package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BasePillarBlockSlab extends BaseAbstractSlab
{
    public BasePillarBlockSlab(Boolean isDoubleSlab, BlockProperty blockProperty, Block singleSlab, int blockNumberStartingIndex)
    {
        super(isDoubleSlab, blockProperty, singleSlab, blockNumberStartingIndex);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        textures = new IIcon[amountOfSubBlocks * 3];
        for (int i = 0 ; i < amountOfSubBlocks; i++)
        {
            if (i == 0 && FirstBlockHasNoIndex)
            {
                this.textures[(i * 3)] = reg.registerIcon(this.textureName + "_Bottom_" + i);
                this.textures[(i * 3) + 1] = reg.registerIcon(this.textureName + "_Top_" + i);
                this.textures[(i * 3) + 2] = reg.registerIcon(this.textureName + "_Side_" + i);
            }
            else
            {
                this.textures[(i * 3)] = reg.registerIcon(this.textureName + "_Bottom_" + i);
                this.textures[(i * 3) + 1] = reg.registerIcon(this.textureName + "_Top_" + i);
                this.textures[(i * 3) + 2] = reg.registerIcon(this.textureName + "_Side_" + i);
            }
        }
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if (meta > amountOfSubBlocks - 1)
        {
            meta = 0;
        }

        switch (side)
        {
            case 0: // Bottom
                return this.textures[(meta * 3)];
            case 1: // Top
                return this.textures[(meta * 3) + 1];
            default:
            {
                // Side
                return this.textures[(meta * 3) + 2];
            }
        }
    }
}
