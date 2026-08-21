package com.bidahochi.BlockMod.customization.registry;

import com.bidahochi.BlockMod.customization.data.AppearanceData;

import java.util.LinkedHashMap;
import java.util.Map;

/** Registers skins and profiles and enforces profile-defined appearance values. */
public final class CustomizationRegistry
{

    private static final Map<String, SkinDefinition> SKINS =
            new LinkedHashMap<String, SkinDefinition>();
    private static final Map<String, CustomizationProfile> PROFILES =
            new LinkedHashMap<String, CustomizationProfile>();

    /** Prevents construction of this static utility class. */
    private CustomizationRegistry()
    {
    }

    /**
     * Registers a skin before any profile that references it.
     *
     * @param skin completed skin definition with a stable unique identifier
     * @return the same skin, allowing registration during field initialization
     * @throws IllegalArgumentException when {@code skin} is {@code null} or its ID
     *         is already registered
     */
    public static SkinDefinition registerSkin(SkinDefinition skin)
    {
        if (skin == null)
        {
            throw new IllegalArgumentException("Skin definition cannot be null.");
        }
        if (SKINS.containsKey(skin.getId()))
        {
            throw new IllegalArgumentException("Duplicate skin ID: " + skin.getId());
        }
        SKINS.put(skin.getId(), skin);
        return skin;
    }

    /**
     * Registers a unique profile after verifying all referenced skins already
     * exist.
     *
     * @param profile completed profile whose traits govern appearance validation
     * @return the same profile, allowing registration during field initialization
     * @throws IllegalArgumentException when {@code profile} is {@code null}, its ID
     *         is already registered, or it references an unregistered skin
     */
    public static CustomizationProfile registerProfile(CustomizationProfile profile)
    {
        if (profile == null)
        {
            throw new IllegalArgumentException("Customization profile cannot be null.");
        }
        if (PROFILES.containsKey(profile.getId()))
        {
            throw new IllegalArgumentException("Duplicate customization profile ID: " + profile.getId());
        }

        for (String skinId : profile.getAllowedSkinIds())
        {
            if (SKINS.containsKey(skinId) == false)
            {
                throw new IllegalArgumentException(
                        "Profile " + profile.getId() + " references unknown skin " + skinId
                );
            }
        }

        PROFILES.put(profile.getId(), profile);
        return profile;
    }

    /**
     * Looks up a skin by its stable identifier.
     *
     * @param id stable skin identifier
     * @return registered skin, or {@code null} when the identifier is unknown
     */
    public static SkinDefinition getSkin(String id)
    {
        return SKINS.get(id);
    }

    /**
     * Looks up a customization profile by its stable identifier.
     *
     * @param id stable profile identifier
     * @return registered profile, or {@code null} when the identifier is unknown
     */
    public static CustomizationProfile getProfile(String id)
    {
        return PROFILES.get(id);
    }

    /**
     * Filters requested data to the profile's declared traits and replaces
     * invalid values with each trait's validated default.
     *
     * @param profile schema defining the permitted traits, options, and defaults
     * @param requested untrusted appearance data; {@code null} requests defaults
     * @return a new immutable appearance containing only validated profile traits
     * @throws IllegalArgumentException when {@code profile} is {@code null}
     */
    public static AppearanceData validateAppearance(
            CustomizationProfile profile,
            AppearanceData requested
    )
    {
        if (profile == null)
        {
            throw new IllegalArgumentException("Customization profile cannot be null");
        }

        AppearanceData value = requested != null
                ? requested
                : AppearanceData.defaultAppearance();

        Map<String, String> validated = new LinkedHashMap<String, String>();
        for (CustomizationTrait trait : profile.getTraits())
        {
            String requestedValue = value.getTrait(trait.getId(), trait.getDefaultValue());
            String traitValue = trait.validateValue(requestedValue);
            if (trait.getKind() == CustomizationTrait.Kind.SKIN
                    && (profile.allowsSkin(traitValue) == false
                    || SKINS.containsKey(traitValue) == false))
            {
                String profileFallback = profile.getDefaultSkinId();
                traitValue = profileFallback.length() > 0
                        && profile.allowsSkin(profileFallback)
                        && SKINS.containsKey(profileFallback)
                        ? profileFallback
                        : trait.getDefaultValue();
            }
            validated.put(trait.getId(), traitValue);
        }
        return new AppearanceData(validated);
    }
}
