package com.bidahochi.BlockMod;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockModTab extends CreativeTabs {
    public BlockModTab(int p_i1853_1_, String p_i1853_2_) {
        super(p_i1853_1_, p_i1853_2_);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(new BauxiteOre(Material.rock));
    }

}
