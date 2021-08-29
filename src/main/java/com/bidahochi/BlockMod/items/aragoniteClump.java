package com.bidahochi.BlockMod.items;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class aragoniteClump extends Item {
    public aragoniteClump() {
        super();
        setMaxStackSize(32);
        setUnlocalizedName("aragoniteClump");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabItems);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(FoxBlocks.MODID.toLowerCase() + ":aragoniteClump");
    }
}
