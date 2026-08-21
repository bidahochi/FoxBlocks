package com.bidahochi.BlockMod.blocks.props.configurable.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/** Connects configurable-prop storage slots with the interacting player's inventory. */
public class ContainerConfigurablePropStorage extends Container
{

    private final IInventory storage;

    /**
     * Builds storage and player slots for a controller or compartment view.
     *
     * @param playerInventory interacting player's inventory
     * @param storage controller or compartment inventory exposed by the prop
     */
    public ContainerConfigurablePropStorage(InventoryPlayer playerInventory, IInventory storage)
    {
        this.storage = storage;
        int storageRows = (storage.getSizeInventory() + 8) / 9;
        int playerInventoryY = 31 + storageRows * 18;
        int hotbarY = 89 + storageRows * 18;

        for (int slot = 0; slot < storage.getSizeInventory(); slot++)
        {
            addSlotToContainer(new ValidatedStorageSlot(
                    storage,
                    slot,
                    8 + (slot % 9) * 18,
                    18 + (slot / 9) * 18
            ));
        }

        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 9; column++)
            {
                addSlotToContainer(new Slot(
                        playerInventory,
                        column + row * 9 + 9,
                        8 + column * 18,
                        playerInventoryY + row * 18
                ));
            }
        }
        for (int column = 0; column < 9; column++)
        {
            addSlotToContainer(new Slot(
                    playerInventory,
                    column,
                    8 + column * 18,
                    hotbarY
            ));
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return storage.isUseableByPlayer(player);
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index)
    {
        ItemStack result = null;
        Slot slot = (Slot) inventorySlots.get(index);
        if (slot == null || slot.getHasStack() == false)
        {
            return null;
        }

        ItemStack stack = slot.getStack();
        result = stack.copy();
        int configurablePropSlots = storage.getSizeInventory();
        if (index < configurablePropSlots)
        {
            if (mergeItemStack(stack, configurablePropSlots, inventorySlots.size(), true) == false)
            {
                return null;
            }
        }
        else if (mergeIntoStorage(stack, configurablePropSlots) == false)
        {
            return null;
        }

        if (stack.stackSize == 0)
        {
            slot.putStack(null);
        }
        else
        {
            slot.onSlotChanged();
        }
        return result;
    }

    /**
     * Merges a shift-clicked player stack into storage while consulting every
     * destination slot's insertion policy. Minecraft 1.7.10's base merge helper
     * does not call {@link Slot#isItemValid(ItemStack)}.
     *
     * @param sourceStack player stack being transferred
     * @param storageSlotCount number of leading container slots owned by storage
     * @return {@code true} when at least one item entered storage
     */
    private boolean mergeIntoStorage(ItemStack sourceStack, int storageSlotCount)
    {
        boolean changed = false;
        if (sourceStack.isStackable())
        {
            for (int slotIndex = 0;
                 slotIndex < storageSlotCount && sourceStack.stackSize > 0;
                 slotIndex++)
            {
                Slot storageSlot = (Slot) inventorySlots.get(slotIndex);
                ItemStack storedStack = storageSlot.getStack();
                if (storedStack != null
                        && storageSlot.isItemValid(sourceStack)
                        && storedStack.getItem() == sourceStack.getItem()
                        && storedStack.getItemDamage() == sourceStack.getItemDamage()
                        && ItemStack.areItemStackTagsEqual(storedStack, sourceStack))
                {
                    int stackLimit = Math.min(
                            storageSlot.getSlotStackLimit(),
                            storedStack.getMaxStackSize()
                    );
                    int transferable = Math.min(
                            sourceStack.stackSize,
                            stackLimit - storedStack.stackSize
                    );
                    if (transferable > 0)
                    {
                        storedStack.stackSize += transferable;
                        sourceStack.stackSize -= transferable;
                        storageSlot.onSlotChanged();
                        changed = true;
                    }
                }
            }
        }

        for (int slotIndex = 0;
             slotIndex < storageSlotCount && sourceStack.stackSize > 0;
             slotIndex++)
        {
            Slot storageSlot = (Slot) inventorySlots.get(slotIndex);
            if (storageSlot.getStack() == null && storageSlot.isItemValid(sourceStack))
            {
                int transferable = Math.min(
                        sourceStack.stackSize,
                        Math.min(
                                storageSlot.getSlotStackLimit(),
                                sourceStack.getMaxStackSize()
                        )
                );
                ItemStack insertedStack = sourceStack.copy();
                insertedStack.stackSize = transferable;
                storageSlot.putStack(insertedStack);
                sourceStack.stackSize -= transferable;
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Applies the backing inventory's insertion policy to clicks and shift-click
     * transfers. Minecraft 1.7.10's base {@link Slot} accepts every item and
     * does not delegate this check to {@link IInventory}.
     */
    private static final class ValidatedStorageSlot extends Slot
    {

        private final IInventory storage;
        private final int storageSlot;

        /**
         * Creates a displayed storage slot that enforces its inventory filter.
         *
         * @param storage filtered inventory shown by the container
         * @param storageSlot slot index within the filtered inventory
         * @param x horizontal slot position in the GUI
         * @param y vertical slot position in the GUI
         */
        private ValidatedStorageSlot(
                IInventory storage,
                int storageSlot,
                int x,
                int y
        )
        {
            super(storage, storageSlot, x, y);
            this.storage = storage;
            this.storageSlot = storageSlot;
        }

        /** {@inheritDoc} */
        @Override
        public boolean isItemValid(ItemStack stack)
        {
            return storage.isItemValidForSlot(storageSlot, stack);
        }

        /** {@inheritDoc} */
        @Override
        public void putStack(ItemStack stack)
        {
            if (stack == null || isItemValid(stack))
            {
                super.putStack(stack);
            }
        }
    }

}
