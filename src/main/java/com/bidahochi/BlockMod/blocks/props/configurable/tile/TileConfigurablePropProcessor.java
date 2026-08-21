package com.bidahochi.BlockMod.blocks.props.configurable.tile;

import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropProcessorInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropRegistry;
import net.minecraft.block.Block;

/**
 * Storage-capable controller for machines whose typed interaction owns a
 * server-authoritative update lifecycle, such as furnaces or blenders.
 */
public class TileConfigurablePropProcessor extends TileConfigurablePropStorage
{

    private static final String ACTIVE_KEY = "ProcessorActive";
    private static final String PROGRESS_TICKS_KEY = "ProcessProgressTicks";
    private static final String DURATION_TICKS_KEY = "ProcessDurationTicks";

    /** Creates an unconfigured processor for Minecraft's reflective tile loading. */
    public TileConfigurablePropProcessor()
    {
    }

    /**
     * Creates a newly placed processor bound to its behavior definition.
     *
     * @param initialDefinitionId stable definition identifier assigned by the block
     */
    public TileConfigurablePropProcessor(String initialDefinitionId)
    {
        super(initialDefinitionId);
    }

    /**
     * Keeps processors out of the permanent tile update list. Active machines
     * use scheduled block updates so idle machines perform no recurring work.
     *
     * @return always {@code false}
     */
    @Override
    public boolean canUpdate()
    {
        return false;
    }

    /**
     * Runs one scheduled, server-authoritative processor step and requests the
     * next step only when the interaction reports that work must continue.
     */
    public void runScheduledProcessorUpdate()
    {
        if (worldObj == null
                || worldObj.isRemote
                || worldObj.blockExists(xCoord, yCoord, zCoord) == false)
        {
            return;
        }
        ConfigurablePropProcessorInteraction processorInteraction = getProcessorInteraction();
        if (processorInteraction == null)
        {
            return;
        }
        if (processorInteraction.shouldProcess(this) == false)
        {
            return;
        }
        if (processorInteraction.onProcessorTick(this))
        {
            requestProcessorUpdate();
        }
    }

    /**
     * Resolves the typed strategy selected by this processor definition.
     *
     * @return shared stateless processor interaction, or {@code null} when absent
     */
    public ConfigurablePropProcessorInteraction getProcessorInteraction()
    {
        ConfigurablePropInteraction interaction = getInteraction();
        return interaction instanceof ConfigurablePropProcessorInteraction
                ? (ConfigurablePropProcessorInteraction) interaction
                : null;
    }

    /**
     * Schedules one processor check for the next world tick. Minecraft deduplicates
     * matching block updates, so repeated inventory changes before that tick do
     * not create a growing update queue.
     */
    public void requestProcessorUpdate()
    {
        if (worldObj == null
                || worldObj.isRemote
                || worldObj.blockExists(xCoord, yCoord, zCoord) == false)
        {
            return;
        }
        Block controllerBlock = ConfigurablePropRegistry.getBlock(getDefinitionId());
        if (controllerBlock == null
                || worldObj.getBlock(xCoord, yCoord, zCoord) != controllerBlock)
        {
            return;
        }
        worldObj.scheduleBlockUpdate(xCoord, yCoord, zCoord, controllerBlock, 1);
    }

    /**
     * Returns whether this machine currently presents an active visual state.
     *
     * @return stored active state, defaulting to {@code false}
     */
    public boolean isProcessorActive()
    {
        return getBehaviorData().getBoolean(ACTIVE_KEY);
    }

    /**
     * Changes the visible active state and synchronizes only when that state
     * transitions. Per-tick progress must use {@link #setProcessProgress}.
     *
     * @param active requested active state
     * @return {@code true} when the stored state changed
     */
    public boolean setProcessorActive(boolean active)
    {
        if (isProcessorActive() == active)
        {
            return false;
        }
        getBehaviorData().setBoolean(ACTIVE_KEY, active);
        sync();
        return true;
    }

    /**
     * Returns completed work for the current recipe.
     *
     * @return non-negative elapsed processing time in ticks
     */
    public int getProcessProgressTicks()
    {
        return Math.max(0, getBehaviorData().getInteger(PROGRESS_TICKS_KEY));
    }

    /**
     * Returns total work required by the current recipe.
     *
     * @return non-negative recipe duration in ticks
     */
    public int getProcessDurationTicks()
    {
        return Math.max(0, getBehaviorData().getInteger(DURATION_TICKS_KEY));
    }

    /**
     * Persists processing progress without broadcasting a full tile update.
     * A custom machine container should send these values only to its viewers.
     *
     * @param progressTicks non-negative completed work in ticks
     * @param durationTicks non-negative total recipe duration in ticks
     */
    public void setProcessProgress(int progressTicks, int durationTicks)
    {
        int normalizedDurationTicks = Math.max(0, durationTicks);
        int normalizedProgressTicks = Math.max(
                0,
                Math.min(progressTicks, normalizedDurationTicks)
        );
        if (getProcessProgressTicks() == normalizedProgressTicks
                && getProcessDurationTicks() == normalizedDurationTicks)
        {
            return;
        }
        getBehaviorData().setInteger(PROGRESS_TICKS_KEY, normalizedProgressTicks);
        getBehaviorData().setInteger(DURATION_TICKS_KEY, normalizedDurationTicks);
        markBehaviorDirty();
    }

    /** Clears persisted progress after completion, cancellation, or recipe replacement. */
    public void clearProcessProgress()
    {
        setProcessProgress(0, 0);
    }

    /** {@inheritDoc} */
    @Override
    protected void onInventoryChanged()
    {
        if (worldObj == null || worldObj.isRemote)
        {
            return;
        }
        ConfigurablePropProcessorInteraction processorInteraction = getProcessorInteraction();
        if (processorInteraction != null)
        {
            processorInteraction.onProcessorInventoryChanged(this);
        }
        requestProcessorUpdate();
    }
}
