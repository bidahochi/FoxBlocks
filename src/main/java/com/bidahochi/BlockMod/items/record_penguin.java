package com.bidahochi.BlockMod.items;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

public class record_penguin extends ItemRecord {
    public record_penguin(String par0Str) {
        super(par0Str);
        setMaxStackSize(1);
        setUnlocalizedName("record_penguin");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabItems);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(FoxBlocks.MODID.toLowerCase() + ":record_penguin");
    }

    @Override
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(FoxBlocks.MODID + ":" + name);
    }
}
