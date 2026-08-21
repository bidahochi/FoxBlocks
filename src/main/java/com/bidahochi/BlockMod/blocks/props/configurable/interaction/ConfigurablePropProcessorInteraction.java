package com.bidahochi.BlockMod.blocks.props.configurable.interaction;

import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropProcessor;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Defines stateless machine behavior for a processor controller. Recipe,
 * progress, fuel, and active state belong to the supplied tile rather than this
 * registry-shared strategy instance.
 */
public abstract class ConfigurablePropProcessorInteraction
        extends ConfigurablePropStorageInteraction
{

    /** Describes how a processor slot participates in machine recipes. */
    public enum SlotRole
    {
        /** Ordinary storage without processing restrictions. */
        GENERAL,
        /** Primary material consumed by a recipe. */
        INPUT,
        /** One of several materials consumed together by a recipe. */
        INGREDIENT,
        /** Energy-bearing material consumed while processing. */
        FUEL,
        /** Machine-produced result that rejects external insertion. */
        OUTPUT
    }

    /**
     * Returns the processing role assigned to one combined inventory slot.
     * Implementations should return a stable role for each valid slot.
     *
     * @param processor processor that owns the slot
     * @param slot combined inventory slot index
     * @return non-null role, defaulting to general storage
     */
    public SlotRole getSlotRole(TileConfigurablePropProcessor processor, int slot)
    {
        return SlotRole.GENERAL;
    }

    /**
     * Validates external insertion while protecting output-only slots. Override
     * this method for ingredient or fuel filters and preserve the output rule.
     *
     * @param processor processor receiving the candidate stack
     * @param slot combined inventory slot index
     * @param stack candidate stack
     * @return {@code true} when the stack may be inserted
     */
    public boolean canInsertItem(
            TileConfigurablePropProcessor processor,
            int slot,
            ItemStack stack
    )
    {
        SlotRole slotRole = getSlotRole(processor, slot);
        return slotRole != null && slotRole != SlotRole.OUTPUT;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isItemValidForSlot(
            TileConfigurablePropStorage storage,
            int slot,
            ItemStack stack
    )
    {
        if ((storage instanceof TileConfigurablePropProcessor) == false)
        {
            return false;
        }
        return canInsertItem((TileConfigurablePropProcessor) storage, slot, stack);
    }

    /**
     * Tests the processor's current state before running machine work. This is
     * the hot idle path and should avoid allocation, world scans, and mutation.
     *
     * @param processor server-side processor being considered for work
     * @return {@code true} when {@link #onProcessorTick} should run this tick
     */
    public abstract boolean shouldProcess(TileConfigurablePropProcessor processor);

    /**
     * Performs one server-authoritative machine update after
     * {@link #shouldProcess} returned {@code true}. Implementations should use
     * {@code markBehaviorDirty()} for persistent progress and synchronize only
     * visible state transitions such as active state or emitted light.
     *
     * @param processor processor whose inventory and behavior state may change
     * @return {@code true} when another processing update is required next tick
     */
    public abstract boolean onProcessorTick(TileConfigurablePropProcessor processor);

    /**
     * Creates the server container for this machine's purpose-built GUI.
     * Returning {@code null} means the interaction does not expose a machine GUI.
     *
     * @param player player opening the machine
     * @param processor authoritative processor controller
     * @return server container object, or {@code null} when unsupported
     */
    public Object createServerGuiElement(
            EntityPlayer player,
            TileConfigurablePropProcessor processor
    )
    {
        return null;
    }

    /**
     * Creates the client screen matching {@link #createServerGuiElement}. Keep
     * client-only class references inside an overriding method body so dedicated
     * servers can load the shared interaction contract safely.
     *
     * @param player player opening the machine
     * @param processor synchronized client processor
     * @return client GUI object, or {@code null} when unsupported
     */
    public Object createClientGuiElement(
            EntityPlayer player,
            TileConfigurablePropProcessor processor
    )
    {
        return null;
    }

    /**
     * Notifies event-driven recipe logic that an inventory operation completed.
     * Implementations may invalidate cached matching state but must not mutate
     * inventory here; perform resulting inventory work in the scheduled update
     * to avoid recursive change notifications. The default does nothing because
     * the next cheap idle check can inspect inventory directly.
     *
     * @param processor processor whose stored items changed
     */
    public void onProcessorInventoryChanged(TileConfigurablePropProcessor processor)
    {
    }
}
