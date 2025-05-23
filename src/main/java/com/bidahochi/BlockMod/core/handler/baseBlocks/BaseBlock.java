package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BaseBlock extends BaseAbstractBlock
{
    public BaseBlock(BlockProperty blockProperty)
    {
        super(blockProperty);
    }

    public void registerBlockIcons(IIconRegister reg)
    {
        textures = new IIcon[amountOfSubBlocks];
        for (int i = 0 ; i < amountOfSubBlocks; i++)
        {
            if (i == 0 && FirstBlockHasNoIndex)
            {
                this.textures[i] = reg.registerIcon(this.textureName);
            }
            else
            {
                this.textures[i] = reg.registerIcon(this.textureName + "_" + i);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta > amountOfSubBlocks - 1)
        {
            FoxBlocks.blockLogger.info("**WARNINGlz MISSING BLOCK DETECTED** TELL MOD AUTHORS BlockName: " + this.getUnlocalizedName() + " META:" + meta);
            return this.textures[0];
        }

        return this.textures[meta];
    }
}
