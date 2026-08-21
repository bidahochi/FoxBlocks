package com.bidahochi.BlockMod.customization.registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/** Immutable ordered trait schema used to validate one family of customizable props. */
public final class CustomizationProfile
{

    private final String id;
    private final String defaultSkinId;
    private final Set<String> allowedSkinIds;
    private final List<CustomizationTrait> traits;

    /**
     * Creates a trait-only profile. The prop definition supplies the renderer's
     * base skin, so profiles that do not expose a skin chooser need no skin data.
     *
     * @param id stable registry identifier; it is trimmed and lower-cased
     * @param traits ordered trait schema used by validation and the customization GUI
     * @throws IllegalArgumentException when the ID is empty or trait IDs repeat
     */
    public CustomizationProfile(String id, List<CustomizationTrait> traits)
    {
        this(id, "", Collections.<String>emptySet(), traits);
    }

    /**
     * Creates a skin-aware profile with a deterministic ordered trait schema.
     * Input collections are copied, so later caller changes do not affect the
     * profile.
     *
     * @param id stable registry identifier; it is trimmed and lower-cased
     * @param defaultSkinId fallback skin, or an empty string when none is required
     * @param allowedSkinIds permitted registered skin IDs; an empty set permits any skin
     * @param traits ordered trait schema used by validation and the customization GUI
     * @throws IllegalArgumentException when the ID is empty, a skin ID or trait is
     *         invalid, the default skin is not allowed, or trait IDs repeat
     */
    public CustomizationProfile(
            String id,
            String defaultSkinId,
            Set<String> allowedSkinIds,
            List<CustomizationTrait> traits
    )
    {
        this.id = requireId(id, "profile");
        this.defaultSkinId = normalizeOptionalId(defaultSkinId);
        Set<String> normalizedSkinIds = new LinkedHashSet<String>();
        if (allowedSkinIds != null)
        {
            for (String allowedSkinId : allowedSkinIds)
            {
                String normalizedSkinId = normalizeOptionalId(allowedSkinId);
                if (normalizedSkinId.length() == 0)
                {
                    throw new IllegalArgumentException(
                            "Customization profile allowed skin ID cannot be empty"
                    );
                }
                normalizedSkinIds.add(normalizedSkinId);
            }
        }
        this.allowedSkinIds = Collections.unmodifiableSet(normalizedSkinIds);
        this.traits = Collections.unmodifiableList(
                traits != null
                        ? new ArrayList<CustomizationTrait>(traits)
                        : new ArrayList<CustomizationTrait>()
        );
        if (this.defaultSkinId.length() > 0
                && this.allowedSkinIds.contains(this.defaultSkinId) == false)
        {
            throw new IllegalArgumentException(
                    "Customization profile must allow its default skin: " + this.defaultSkinId
            );
        }
        Set<String> traitIds = new LinkedHashSet<String>();
        for (CustomizationTrait trait : this.traits)
        {
            if (trait == null)
            {
                throw new IllegalArgumentException("Customization profile trait cannot be null");
            }
            if (traitIds.add(trait.getId()) == false)
            {
                throw new IllegalArgumentException("Duplicate trait ID: " + trait.getId());
            }
        }
    }

    /** Returns the stable normalized profile ID. */
    public String getId()
    {
        return id;
    }

    /** Returns the registered fallback skin ID, or an empty string for trait-only profiles. */
    public String getDefaultSkinId()
    {
        return defaultSkinId;
    }

    /** Returns the immutable ordered set used for server-side skin validation. */
    public Set<String> getAllowedSkinIds()
    {
        return allowedSkinIds;
    }

    /** Returns the immutable trait schema in GUI display order. */
    public List<CustomizationTrait> getTraits()
    {
        return traits;
    }

    /**
     * Finds a declared trait by its stable identifier.
     *
     * @param id trait identifier to locate
     * @return declared trait, or {@code null} when the profile does not contain it
     */
    public CustomizationTrait getTrait(String id)
    {
        for (CustomizationTrait trait : traits)
        {
            if (trait.getId().equals(id))
            {
                return trait;
            }
        }
        return null;
    }

    /**
     * Tests whether a skin identifier is permitted by this profile.
     *
     * @param skinId registered skin identifier to test
     * @return {@code true} when explicitly allowed or when the allowed set is empty
     */
    public boolean allowsSkin(String skinId)
    {
        return allowedSkinIds.isEmpty() || allowedSkinIds.contains(skinId);
    }

    /** Requires and normalizes a registry-facing profile identifier. */
    private static String requireId(String value, String type)
    {
        if (value == null || value.trim().length() == 0)
        {
            throw new IllegalArgumentException("Customization " + type + " ID cannot be empty");
        }
        return value.trim().toLowerCase(Locale.ROOT);
    }

    /** Normalizes an optional identifier while preserving absence as an empty string. */
    private static String normalizeOptionalId(String value)
    {
        return value != null ? value.trim().toLowerCase(Locale.ROOT) : "";
    }
}
