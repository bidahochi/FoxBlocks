package com.bidahochi.BlockMod.blocks.scrolling;

import net.minecraft.item.ItemStack;

/** An item that cycles modes on the held stack. */
public interface IFoxBlocksScrollingItem
{
    /**
     * Cycles through the item's supported modes, wrapping at either end.
     *
     * @param stack the selected stack to update in place on the server
     * @param forward true for the next mode, false for the previous mode
     */
    public void cycleMode(ItemStack stack, boolean forward);
}
