package com.bidahochi.BlockMod.customization.registry;

import net.minecraft.util.ResourceLocation;

import java.util.Locale;

/** Immutable registered base texture with stable identity and display metadata. */
public final class SkinDefinition
{

    private final String id;
    private final String displayNameKey;
    private final ResourceLocation texture;

    /**
     * Creates a validated base skin and its customization-menu metadata.
     *
     * @param id stable registry identifier; it is trimmed and lower-cased
     * @param displayNameKey localization key shown in the customization GUI
     * @param texture base texture resource bound while rendering the skin
     * @throws IllegalArgumentException when any argument is missing
     */
    public SkinDefinition(String id, String displayNameKey, ResourceLocation texture)
    {
        if (id == null || id.trim().length() == 0)
        {
            throw new IllegalArgumentException("Skin ID cannot be empty");
        }
        if (displayNameKey == null || displayNameKey.trim().length() == 0)
        {
            throw new IllegalArgumentException("Skin display name key cannot be empty");
        }
        if (texture == null)
        {
            throw new IllegalArgumentException("Skin texture cannot be null");
        }

        this.id = id.trim().toLowerCase(Locale.ROOT);
        this.displayNameKey = displayNameKey;
        this.texture = texture;
    }

    /** Returns the stable normalized skin ID. */
    public String getId()
    {
        return id;
    }

    /** Returns the localization key displayed for this skin. */
    public String getDisplayNameKey()
    {
        return displayNameKey;
    }

    /** Returns the base texture resource owned by this skin. */
    public ResourceLocation getTexture()
    {
        return texture;
    }
}
