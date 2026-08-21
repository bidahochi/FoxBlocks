package com.bidahochi.BlockMod.blocks.props.configurable.inventory;

import com.bidahochi.BlockMod.blocks.props.configurable.item.ItemBlockConfigurableProp;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

/** Keeps the customized item slot synchronized while the item-only GUI is open. */
public class ContainerConfigurablePropCustomization extends Container
{

    private final EntityPlayer player;
    private final int slot;

    /**
     * Tracks the player and inventory slot being configured.
     *
     * @param player player whose item is being edited
     * @param slot zero-based player inventory slot containing the item
     */
    public ContainerConfigurablePropCustomization(EntityPlayer player, int slot)
    {
        this.player = player;
        this.slot = slot;
    }

    /** {@inheritDoc} */
    @Override
    public boolean canInteractWith(EntityPlayer ignored)
    {
        if (slot < 0
                || slot >= player.inventory.getSizeInventory()
                || player.inventory.currentItem != slot)
        {
            return false;
        }
        ItemStack stack = player.inventory.getStackInSlot(slot);
        return stack != null && stack.getItem() instanceof ItemBlockConfigurableProp;
    }
}
