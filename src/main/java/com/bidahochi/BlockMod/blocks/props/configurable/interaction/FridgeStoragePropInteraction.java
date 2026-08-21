package com.bidahochi.BlockMod.blocks.props.configurable.interaction;

import com.bidahochi.BlockMod.core.handler.ItemIDs;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropStorage;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;

/** Restricts generic prop storage to recognized food and drink items. */
public final class FridgeStoragePropInteraction extends StoragePropInteraction
{

    /** {@inheritDoc} */
    @Override
    public boolean isItemValidForSlot(
            TileConfigurablePropStorage storage,
            int slot,
            ItemStack stack
    )
    {
        return isFoodOrDrink(stack);
    }

    /** Applies item-type and use-action checks without guessing from display names. */
    private boolean isFoodOrDrink(ItemStack stack)
    {
        if (stack == null || stack.getItem() == null)
        {
            return false;
        }

        Item item = stack.getItem();
        if (item instanceof ItemFood
                || item instanceof ItemPotion
                || item.getItemUseAction(stack) == EnumAction.drink)
        {
            return true;
        }
        if (item == Items.milk_bucket || item == Items.water_bucket || item == Items.potionitem)
        {
            return true;
        }
        if (ItemIDs.bucket_of_lean.item != null && item == ItemIDs.bucket_of_lean.item)
        {
            return true;
        }
        return false;
    }
}
