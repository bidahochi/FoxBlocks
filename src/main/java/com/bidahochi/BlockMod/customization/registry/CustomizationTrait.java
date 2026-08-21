package com.bidahochi.BlockMod.customization.registry;

import com.bidahochi.BlockMod.customization.data.CustomizationNumberParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/** Defines one named appearance category, its input kind, default, and allowed options. */
public final class CustomizationTrait
{

    /** Selects validation and GUI behavior without restricting trait IDs. */
    public enum Kind
    {
        /** Selects one registered skin ID. */
        SKIN,
        /** Selects one authored texture-rule value. */
        TEXTURE,
        /** Stores an editable opaque packed RGB value. */
        COLOR,
        /** Selects an arbitrary discrete behavior or appearance value. */
        CHOICE
    }

    private final String id;
    private final String displayNameKey;
    private final Kind kind;
    private final String defaultValue;
    private final List<CustomizationTraitOption> options;

    /**
     * Defines a normalized trait and verifies that its default is an allowed
     * option. Color traits still declare displayable preset options.
     *
     * @param id stable category ID stored in appearance data
     * @param displayNameKey localization key used for the GUI heading
     * @param kind validation and input behavior
     * @param defaultValue serialized fallback value; must match an option
     * @param options nonempty deterministic option list
     */
    public CustomizationTrait(
            String id,
            String displayNameKey,
            Kind kind,
            String defaultValue,
            List<CustomizationTraitOption> options
    )
    {
        if (id == null || id.trim().length() == 0)
        {
            throw new IllegalArgumentException("Customization trait ID cannot be empty");
        }
        if (displayNameKey == null || displayNameKey.trim().length() == 0)
        {
            throw new IllegalArgumentException(
                    "Customization trait display name key cannot be empty"
            );
        }
        if (kind == null)
        {
            throw new IllegalArgumentException("Customization trait kind cannot be null");
        }
        this.id = id.trim().toLowerCase(Locale.ROOT);
        this.displayNameKey = displayNameKey;
        this.kind = kind;
        this.defaultValue = defaultValue != null ? defaultValue : "";
        if (options == null || options.isEmpty())
        {
            throw new IllegalArgumentException("Customization trait must declare options");
        }
        this.options = Collections.unmodifiableList(
                new ArrayList<CustomizationTraitOption>(options)
        );
        Set<String> optionValues = new LinkedHashSet<String>();
        for (CustomizationTraitOption option : this.options)
        {
            if (option == null)
            {
                throw new IllegalArgumentException("Customization trait option cannot be null");
            }
            if (optionValues.add(option.getValue()) == false)
            {
                throw new IllegalArgumentException(
                        "Duplicate option " + option.getValue() + " in trait " + this.id
                );
            }
        }
        if (findOption(this.defaultValue) == null)
        {
            throw new IllegalArgumentException(
                    "Trait " + this.id + " must allow its default value"
            );
        }
    }

    /** Returns the stable normalized trait ID. */
    public String getId()
    {
        return id;
    }

    /** Returns the localization key used for the trait heading. */
    public String getDisplayNameKey()
    {
        return displayNameKey;
    }

    /** Returns the GUI and validation behavior assigned to this trait. */
    public Kind getKind()
    {
        return kind;
    }

    /** Returns the serialized fallback value. */
    public String getDefaultValue()
    {
        return defaultValue;
    }

    /** Returns the immutable options in their deterministic GUI order. */
    public List<CustomizationTraitOption> getOptions()
    {
        return options;
    }

    /**
     * Returns the matching declared option.
     *
     * @param optionValue exact serialized option value
     * @return matching option, or {@code null} when undeclared
     */
    public CustomizationTraitOption findOption(String optionValue)
    {
        for (CustomizationTraitOption option : options)
        {
            if (option.getValue().equals(optionValue))
            {
                return option;
            }
        }
        return null;
    }

    /**
     * Normalizes a requested value according to this trait's kind.
     *
     * @param requestedValue serialized candidate value
     * @return opaque normalized color or allowed discrete value; otherwise the default
     */
    public String validateValue(String requestedValue)
    {
        if (kind == Kind.COLOR)
        {
            return normalizeColor(requestedValue, defaultValue);
        }
        return findOption(requestedValue) != null ? requestedValue : defaultValue;
    }

    /** Normalizes a packed color value and forces an opaque alpha channel. */
    private static String normalizeColor(String value, String fallback)
    {
        int fallbackColor = CustomizationNumberParser.parseColor(fallback, 0xFFFFFFFF);
        int color = CustomizationNumberParser.parseColor(value, fallbackColor);
        return Integer.toString(0xFF000000 | (color & 0x00FFFFFF));
    }
}
