package com.bidahochi.BlockMod.blocks.props.configurable.content;

/** Central stable identifiers shared by built-in prop definitions and interactions. */
public final class ConfigurablePropIds
{

    /** Interaction ID for props that create seat entities. */
    public static final String INTERACTION_SEAT = "foxblocks:seat";
    /** Interaction ID for unrestricted storage props. */
    public static final String INTERACTION_STORAGE = "foxblocks:storage";
    /** Interaction ID for food-and-drink-only storage props. */
    public static final String INTERACTION_FRIDGE_STORAGE = "foxblocks:fridge_storage";
    /** Interaction ID for manually toggled block-light props. */
    public static final String INTERACTION_LIGHT = "foxblocks:light";
    /** Historical fallback used when content does not provide a specific skin. */
    public static final String FALLBACK_SKIN = "foxblocks:chair_wood";

    /** Prevents construction of this static utility class. */
    private ConfigurablePropIds()
    {
    }
}
