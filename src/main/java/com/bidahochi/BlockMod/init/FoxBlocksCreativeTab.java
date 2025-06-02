package com.bidahochi.BlockMod.init;

import net.minecraft.creativetab.CreativeTabs;

public abstract class FoxBlocksCreativeTab extends CreativeTabs
{
    public FoxBlocksCreativeTab(String lable)
    {
        super(lable);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
