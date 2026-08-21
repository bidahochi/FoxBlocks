package com.bidahochi.BlockMod.blocks.props.configurable.inventory;

import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropCompartment;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

/** Presents a bounded named slot range of a controller as an independent inventory. */
public final class ConfigurablePropCompartmentInventory implements IInventory
{

    private final TileConfigurablePropStorage controller;
    private final ConfigurablePropCompartment compartment;

    /**
     * Creates a local-slot view over one controller compartment. All operations
     * are forwarded into the compartment's range in the controller inventory.
     *
     * @param controller controller that owns the combined inventory
     * @param compartment immutable slot-range definition exposed by this view
     */
    public ConfigurablePropCompartmentInventory(
            TileConfigurablePropStorage controller,
            ConfigurablePropCompartment compartment
    )
    {
        this.controller = controller;
        this.compartment = compartment;
    }

    /** Maps a validated compartment-local slot to the controller's combined range. */
    private int globalSlot(int slot)
    {
        return compartment.getStartSlot() + slot;
    }

    /** {@inheritDoc} */
    @Override
    public int getSizeInventory()
    {
        return compartment.getSize();
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack getStackInSlot(int slot)
    {
        if (isValidLocalSlot(slot) == false)
        {
            return null;
        }
        return controller.getStackInSlot(globalSlot(slot));
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        if (isValidLocalSlot(slot) == false)
        {
            return null;
        }
        return controller.decrStackSize(globalSlot(slot), amount);
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (isValidLocalSlot(slot) == false)
        {
            return null;
        }
        return controller.getStackInSlotOnClosing(globalSlot(slot));
    }

    /** {@inheritDoc} */
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        if (isValidLocalSlot(slot) == false)
        {
            return;
        }
        if (stack != null && isItemValidForSlot(slot, stack) == false)
        {
            return;
        }
        controller.setInventorySlotContents(globalSlot(slot), stack);
    }

    /** {@inheritDoc} */
    @Override
    public String getInventoryName()
    {
        return compartment.getInventoryName();
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public int getInventoryStackLimit()
    {
        return controller.getInventoryStackLimit();
    }

    /** {@inheritDoc} */
    @Override
    public void markDirty()
    {
        controller.markDirty();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return controller.isUseableByPlayer(player);
    }

    /** {@inheritDoc} */
    @Override
    public void openInventory()
    {
        controller.openInventory();
    }

    /** {@inheritDoc} */
    @Override
    public void closeInventory()
    {
        controller.closeInventory();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        if (isValidLocalSlot(slot) == false)
        {
            return false;
        }
        return controller.isItemValidForSlot(globalSlot(slot), stack);
    }

    /**
     * Prevents a local index from escaping into an adjacent compartment.
     *
     * @param slot compartment-local slot index
     * @return {@code true} when the index belongs to this compartment
     */
    private boolean isValidLocalSlot(int slot)
    {
        return slot >= 0 && slot < compartment.getSize();
    }
}
