package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BasePillarBlock extends BaseAbstractBlock
{
    public IIcon[] texturesTopSideBottom;

    public BasePillarBlock(BlockProperty blockProperty)
    {
        super(blockProperty);
    }

    public void registerBlockIcons(IIconRegister reg)
    {
        texturesTopSideBottom = new IIcon[amountOfSubBlocks * 3];
        for (int i = 0 ; i < amountOfSubBlocks; i++)
        {
            if (i == 0 && FirstBlockHasNoIndex)
            {
                this.texturesTopSideBottom[i] = reg.registerIcon(this.textureName + "_Bottom_" + i);
                this.texturesTopSideBottom[i + 1] = reg.registerIcon(this.textureName + "_Top_" + i);
                this.texturesTopSideBottom[i + 2] = reg.registerIcon(this.textureName + "_Side_" + i);
            }
            else
            {
                this.texturesTopSideBottom[i] = reg.registerIcon(this.textureName + "_Bottom_" + i);
                this.texturesTopSideBottom[i + 1] = reg.registerIcon(this.textureName + "_Top_" + i);
                this.texturesTopSideBottom[i + 2] = reg.registerIcon(this.textureName + "_Side_" + i);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        if (meta > amountOfSubBlocks - 1)
        {
            meta = 0;
        }

        switch (side)
        {
            case 0: // Bottom
                return this.texturesTopSideBottom[meta];
            case 1: // Top
                return this.texturesTopSideBottom[meta + 1];
            default:
            {
                // Side
                return this.texturesTopSideBottom[meta + 2];
            }
        }
    }
}
