package com.bidahochi.BlockMod.blocks.props.configurable.interaction;

import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropStorage;
import net.minecraft.item.ItemStack;

/**
 * Adds storage-specific slot validation to a configurable-prop interaction.
 * Basic prop interactions do not expose inventory methods they cannot use.
 */
public abstract class ConfigurablePropStorageInteraction extends ConfigurablePropInteraction
{

    /**
     * Validates insertion into the storage tile's combined compartment inventory.
     *
     * @param storage storage controller that owns the inventory
     * @param slot combined controller slot index
     * @param stack candidate stack being inserted
     * @return {@code true} when the stack may occupy the slot
     */
    public boolean isItemValidForSlot(
            TileConfigurablePropStorage storage,
            int slot,
            ItemStack stack
    )
    {
        return true;
    }
}
