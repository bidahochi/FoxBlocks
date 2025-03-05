package com.bidahochi.BlockMod.items.BaseItems;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBucket;

public class BaseItemBucket extends ItemBucket
{
    private String iconName;

    public BaseItemBucket(Block fluidBlock, String iconName)
    {
        super(fluidBlock);
        this.iconName = iconName;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(FoxBlocks.MODID.toLowerCase() + ":" + iconName);
    }
}
