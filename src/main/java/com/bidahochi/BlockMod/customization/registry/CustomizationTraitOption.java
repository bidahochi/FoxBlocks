package com.bidahochi.BlockMod.customization.registry;

/** Immutable stored value and localized label for one trait option. */
public final class CustomizationTraitOption
{

    private final String value;
    private final String displayNameKey;

    /**
     * Creates one selectable value for a choice-like customization trait.
     *
     * @param optionValue stable value serialized into appearance data
     * @param displayNameKey localization key shown in the customization GUI
     * @throws IllegalArgumentException when either value is empty
     */
    public CustomizationTraitOption(String optionValue, String displayNameKey)
    {
        if (optionValue == null || optionValue.length() == 0)
        {
            throw new IllegalArgumentException("Trait option value cannot be empty");
        }
        if (displayNameKey == null || displayNameKey.length() == 0)
        {
            throw new IllegalArgumentException("Trait option display name key cannot be empty");
        }
        this.value = optionValue;
        this.displayNameKey = displayNameKey;
    }

    /** Returns the stable serialized option value. */
    public String getValue()
    {
        return value;
    }

    /** Returns the localization key displayed for this option. */
    public String getDisplayNameKey()
    {
        return displayNameKey;
    }
}
