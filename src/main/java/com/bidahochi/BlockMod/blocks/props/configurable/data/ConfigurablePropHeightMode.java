package com.bidahochi.BlockMod.blocks.props.configurable.data;

/** Selects manual placement height or automatic support-block compensation. */
public enum ConfigurablePropHeightMode
{
    /** Detects the support block and applies definition-authored compensation. */
    AUTO("auto"),
    /** Uses only the player's explicitly selected vertical placement offset. */
    MANUAL("manual");

    private final String id;

    ConfigurablePropHeightMode(String id)
    {
        this.id = id;
    }

    /**
     * Returns the stable serialized mode identifier.
     *
     * @return lowercase identifier stored in item and tile data
     */
    public String getId()
    {
        return id;
    }

    /**
     * Parses a serialized mode identifier.
     *
     * @param modeId serialized identifier read from item or tile data
     * @return matching mode, or {@link #MANUAL} for null and unknown identifiers
     */
    public static ConfigurablePropHeightMode fromId(String modeId)
    {
        if (AUTO.id.equals(modeId))
        {
            return AUTO;
        }
        return MANUAL;
    }
}
