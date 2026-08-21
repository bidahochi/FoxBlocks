package com.bidahochi.BlockMod.blocks.props.configurable.definition;

/**
 * Selects the persistent tile capability required by a configurable prop.
 * Definitions should use the least capable type that satisfies their behavior.
 */
public enum ConfigurablePropControllerType
{

    /** Appearance, placement, structure, interaction, and lighting state only. */
    BASIC(false),

    /** Adds persistent inventory and independently addressable compartments. */
    STORAGE(true),

    /** Adds storage plus the lifecycle hooks required by processing machines. */
    PROCESSOR(true);

    private final boolean inventorySupported;

    /**
     * Creates one capability descriptor.
     *
     * @param inventorySupported whether the corresponding tile implements inventory storage
     */
    private ConfigurablePropControllerType(boolean inventorySupported)
    {
        this.inventorySupported = inventorySupported;
    }

    /**
     * Tests whether this controller type may own flat or compartment inventory.
     *
     * @return {@code true} for storage and processor controllers
     */
    public boolean supportsInventory()
    {
        return inventorySupported;
    }
}
