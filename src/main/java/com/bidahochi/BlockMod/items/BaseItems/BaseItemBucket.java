package com.bidahochi.BlockMod.items.BaseItems;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

import java.util.List;

public class BaseItemBucket extends ItemBucket
{
    private String iconName;

    public BaseItemBucket(Block fluidBlock, String iconName)
    {
        super(fluidBlock);
        this.iconName = iconName;
        this.setMaxStackSize(1);
        setContainerItem(Items.bucket);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(FoxBlocks.MODID.toLowerCase() + ":" + iconName);
    }
}
