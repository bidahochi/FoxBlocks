package com.bidahochi.BlockMod.blocks.props.configurable.content;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.customization.registry.AppearanceTextureDefinition;
import com.bidahochi.BlockMod.customization.registry.AppearanceTextureRegistry;
import com.bidahochi.BlockMod.customization.registry.CustomizationProfile;
import com.bidahochi.BlockMod.customization.registry.CustomizationRegistry;
import com.bidahochi.BlockMod.customization.registry.CustomizationTrait;
import com.bidahochi.BlockMod.customization.registry.CustomizationTraitOption;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Convenience API for declaring skins, profiles, traits, and texture-selection
 * rules used by configurable props. Overloads without a resource domain assume
 * FoxBlocks; add-ons should use domain-aware overloads for their own assets.
 */
public final class ConfigurablePropContentHelper
{

    /** Prevents construction of this static utility class. */
    private ConfigurablePropContentHelper()
    {
    }

    /**
     * Creates a FoxBlocks skin catalog using {@code {skin}} as its variant token.
     *
     * @param profileId stable profile and generated-skin ID prefix
     * @param texturePattern texture path containing a {@code {skin}} token
     * @return unregistered catalog ready for skin and trait declarations
     */
    public static ConfigurablePropSkinCatalog skinCatalog(
            String profileId,
            String texturePattern
    )
    {
        return skinCatalog(FoxBlocks.MODID, profileId, texturePattern);
    }

    /**
     * Creates a skin catalog whose textures belong to an explicit asset domain.
     *
     * @param resourceDomain asset namespace; blank uses FoxBlocks
     * @param profileId stable profile and generated-skin ID prefix
     * @param texturePattern texture path containing a {@code {skin}} token
     * @return unregistered catalog ready for skin and trait declarations
     */
    public static ConfigurablePropSkinCatalog skinCatalog(
            String resourceDomain,
            String profileId,
            String texturePattern
    )
    {
        return ConfigurablePropSkinCatalog.create(
                profileId,
                normalizeResourceDomain(resourceDomain),
                texturePattern
        );
    }

    /**
     * Creates a one-skin FoxBlocks catalog whose skin ID equals its profile ID.
     *
     * @param profileId stable profile and skin ID
     * @param texturePath complete texture path inside FoxBlocks assets
     * @return unregistered single-skin catalog
     */
    public static ConfigurablePropSkinCatalog singleSkinCatalog(
            String profileId,
            String texturePath
    )
    {
        return singleSkinCatalog(FoxBlocks.MODID, profileId, texturePath);
    }

    /**
     * Creates a one-skin catalog whose texture belongs to an explicit domain.
     *
     * @param resourceDomain asset namespace; blank uses FoxBlocks
     * @param profileId stable profile and skin ID
     * @param texturePath complete texture path inside the domain
     * @return unregistered single-skin catalog
     */
    public static ConfigurablePropSkinCatalog singleSkinCatalog(
            String resourceDomain,
            String profileId,
            String texturePath
    )
    {
        return ConfigurablePropSkinCatalog.createSingle(
                profileId,
                normalizeResourceDomain(resourceDomain),
                texturePath
        );
    }

    /**
     * Creates a discrete non-texture choice trait.
     *
     * @param id stable trait ID stored in appearance data
     * @param translationSuffix suffix for the standard trait localization key
     * @param values one or more stable values; the first becomes the default
     * @return discrete choice trait
     */
    public static CustomizationTrait choiceTrait(
            String id,
            String translationSuffix,
            String... values
    )
    {
        requireValues("choice trait", values);
        return new CustomizationTrait(
                id,
                "gui.foxblocks.propAppearance.trait." + translationSuffix,
                CustomizationTrait.Kind.CHOICE,
                values[0],
                createOptions("gui.foxblocks.propAppearance.option.", values)
        );
    }

    /**
     * Creates a trait intended to select manually authored texture variants.
     *
     * @param id stable trait ID stored in appearance data
     * @param translationSuffix suffix for the standard trait localization key
     * @param values one or more stable values; the first becomes the default
     * @return texture-selection trait
     */
    public static CustomizationTrait textureTrait(
            String id,
            String translationSuffix,
            String... values
    )
    {
        requireValues("texture trait", values);
        return new CustomizationTrait(
                id,
                "gui.foxblocks.propAppearance.trait." + translationSuffix,
                CustomizationTrait.Kind.TEXTURE,
                values[0],
                createOptions("gui.foxblocks.propAppearance.option.", values)
        );
    }

    /**
     * Registers a FoxBlocks texture selected by one exact trait value.
     *
     * @param configurablePropId definition ID used as the texture target
     * @param traitId required appearance trait ID
     * @param traitValue exact required trait value
     * @param texturePath replacement texture path
     */
    public static void registerTexture(
            String configurablePropId,
            String traitId,
            String traitValue,
            String texturePath
    )
    {
        registerTexture(FoxBlocks.MODID, configurablePropId, traitId, traitValue, texturePath);
    }

    /**
     * Registers a domain-specific texture selected by one exact trait value.
     *
     * @param resourceDomain asset namespace for the replacement texture
     * @param configurablePropId definition ID used as the texture target
     * @param traitId required appearance trait ID
     * @param traitValue exact required trait value
     * @param texturePath replacement texture path
     */
    public static void registerTexture(
            String resourceDomain,
            String configurablePropId,
            String traitId,
            String traitValue,
            String texturePath
    )
    {
        Map<String, String> requiredTraits = new LinkedHashMap<String, String>();
        requiredTraits.put(traitId, traitValue);
        registerTexture(resourceDomain, configurablePropId, requiredTraits, texturePath);
    }

    /**
     * Registers a FoxBlocks texture selected by all supplied trait values.
     *
     * @param configurablePropId definition ID used as the texture target
     * @param requiredTraits exact required trait ID/value pairs
     * @param texturePath replacement texture path
     */
    public static void registerTexture(
            String configurablePropId,
            Map<String, String> requiredTraits,
            String texturePath
    )
    {
        registerTexture(FoxBlocks.MODID, configurablePropId, requiredTraits, texturePath);
    }

    /**
     * Registers a domain-specific texture selected by all supplied trait values.
     *
     * @param resourceDomain asset namespace for the replacement texture
     * @param configurablePropId definition ID used as the texture target
     * @param requiredTraits exact required trait ID/value pairs
     * @param texturePath replacement texture path
     */
    public static void registerTexture(
            String resourceDomain,
            String configurablePropId,
            Map<String, String> requiredTraits,
            String texturePath
    )
    {
        AppearanceTextureRegistry.register(new AppearanceTextureDefinition(
                configurablePropId,
                requiredTraits,
                new ResourceLocation(normalizeResourceDomain(resourceDomain), texturePath)
        ));
    }

    /**
     * Registers a profile containing only the categories this prop exposes.
     * Skin-bearing profiles must instead be declared through a
     * {@link ConfigurablePropSkinCatalog} so their skins and profile remain consistent.
     *
     * @param profileId stable profile ID selected by prop definitions
     * @param traits independent trait categories with unique IDs
     */
    public static void registerProfile(
            String profileId,
            CustomizationTrait... traits
    )
    {
        List<CustomizationTrait> profileTraits = traits != null
                ? Arrays.asList(traits)
                : new ArrayList<CustomizationTrait>();
        CustomizationRegistry.registerProfile(new CustomizationProfile(
                profileId,
                profileTraits
        ));
    }

    /**
     * Registers a FoxBlocks texture rule for one independently rendered group.
     *
     * @param configurablePropId definition ID owning the grouped model
     * @param groupId stable model texture-group ID
     * @param traitId required appearance trait ID
     * @param traitValue exact required trait value
     * @param texturePath group replacement texture path
     */
    public static void registerGroupTexture(
            String configurablePropId,
            String groupId,
            String traitId,
            String traitValue,
            String texturePath
    )
    {
        registerGroupTexture(
                FoxBlocks.MODID,
                configurablePropId,
                groupId,
                traitId,
                traitValue,
                texturePath
        );
    }

    /**
     * Registers a domain-specific texture rule for one model group.
     *
     * @param resourceDomain asset namespace for the replacement texture
     * @param configurablePropId definition ID owning the grouped model
     * @param groupId stable model texture-group ID
     * @param traitId required appearance trait ID
     * @param traitValue exact required trait value
     * @param texturePath group replacement texture path
     */
    public static void registerGroupTexture(
            String resourceDomain,
            String configurablePropId,
            String groupId,
            String traitId,
            String traitValue,
            String texturePath
    )
    {
        registerTexture(
                resourceDomain,
                AppearanceTextureRegistry.createGroupTextureTargetId(configurablePropId, groupId),
                traitId,
                traitValue,
                texturePath
        );
    }

    /** Returns a normalized domain or the FoxBlocks domain when omitted. */
    private static String normalizeResourceDomain(String resourceDomain)
    {
        return resourceDomain != null && resourceDomain.trim().length() > 0
                ? resourceDomain.trim().toLowerCase(Locale.ROOT)
                : FoxBlocks.MODID;
    }

    /** Creates one localized discrete trait option. */
    private static CustomizationTraitOption createOption(
            String optionValue,
            String displayNameKey
    )
    {
        return new CustomizationTraitOption(optionValue, displayNameKey);
    }

    /** Derives option localization keys from namespaced values in declaration order. */
    private static List<CustomizationTraitOption> createOptions(
            String keyPrefix,
            String... values
    )
    {
        List<CustomizationTraitOption> options =
                new ArrayList<CustomizationTraitOption>();
        for (String value : values)
        {
            String keyValue = value;
            int separator = keyValue.lastIndexOf(':');
            if (separator >= 0)
            {
                keyValue = keyValue.substring(separator + 1);
            }
            options.add(createOption(value, keyPrefix + keyValue));
        }
        return options;
    }

    /** Rejects empty varargs before callers select their first default value. */
    private static void requireValues(String role, String[] values)
    {
        if (values == null || values.length == 0)
        {
            throw new IllegalArgumentException(
                    "Configurable prop " + role + " requires at least one value."
            );
        }
        for (String value : values)
        {
            if (value == null || value.trim().length() == 0)
            {
                throw new IllegalArgumentException(
                        "Configurable prop " + role + " values cannot be empty."
                );
            }
        }
    }
}
