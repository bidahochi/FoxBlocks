package com.bidahochi.BlockMod.blocks.props.configurable.content;

import com.bidahochi.BlockMod.customization.data.AppearanceData;
import com.bidahochi.BlockMod.customization.registry.CustomizationProfile;
import com.bidahochi.BlockMod.customization.registry.CustomizationRegistry;
import com.bidahochi.BlockMod.customization.registry.CustomizationTrait;
import com.bidahochi.BlockMod.customization.registry.CustomizationTraitOption;
import com.bidahochi.BlockMod.customization.registry.SkinDefinition;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Builds and registers one skin-aware customization profile from an ordered
 * list of concise skin declarations. Conventional declarations derive their
 * IDs, localization keys, and texture paths from the profile and pattern.
 * Declaration methods throw {@link IllegalStateException} after successful
 * registration freezes the catalog.
 */
public final class ConfigurablePropSkinCatalog
{

    private static final String SKIN_PLACEHOLDER = "{skin}";

    /** Distinguishes the required fallback skin from optional alternatives. */
    private enum SkinRole
    {
        DEFAULT,
        ALTERNATE
    }

    private final String profileId;
    private final String resourceDomain;
    private final String texturePattern;
    private final String displayNameKeyBase;
    private final List<SkinDefinition> skins = new ArrayList<SkinDefinition>();
    private final List<CustomizationTrait> additionalTraits =
            new ArrayList<CustomizationTrait>();

    private String defaultSkinId;
    private boolean registered;

    /** Creates an unpublished catalog using explicit registry and texture conventions. */
    private ConfigurablePropSkinCatalog(
            String profileId,
            String resourceDomain,
            String texturePattern
    )
    {
        this.profileId = requireValue(profileId, "profile ID").toLowerCase(Locale.ROOT);
        this.resourceDomain = requireValue(
                resourceDomain,
                "resource domain"
        ).toLowerCase(Locale.ROOT);
        this.texturePattern = requireValue(texturePattern, "texture pattern");
        this.displayNameKeyBase = "skin." + this.profileId.replace(':', '.');
    }

    /** Creates an empty catalog whose conventional skins use a texture pattern. */
    static ConfigurablePropSkinCatalog create(
            String profileId,
            String resourceDomain,
            String texturePattern
    )
    {
        return new ConfigurablePropSkinCatalog(profileId, resourceDomain, texturePattern);
    }

    /** Creates a complete one-skin catalog whose skin ID equals its profile ID. */
    static ConfigurablePropSkinCatalog createSingle(
            String profileId,
            String resourceDomain,
            String texturePath
    )
    {
        ConfigurablePropSkinCatalog catalog =
                new ConfigurablePropSkinCatalog(profileId, resourceDomain, texturePath);
        return catalog.addCustomSkin(
                catalog.profileId,
                catalog.displayNameKeyBase,
                texturePath,
                SkinRole.DEFAULT
        );
    }

    /**
     * Adds the required default skin using catalog-generated IDs, localization,
     * and the texture pattern.
     *
     * @param variant normalized token replacing {@code {skin}}
     * @return this unpublished catalog for chained declarations
     */
    public ConfigurablePropSkinCatalog defaultSkin(String variant)
    {
        return addConventionalSkin(
                variant,
                SkinRole.DEFAULT
        );
    }

    /**
     * Adds an alternate skin using the catalog naming conventions.
     *
     * @param variant normalized token replacing {@code {skin}}
     * @return this unpublished catalog for chained declarations
     */
    public ConfigurablePropSkinCatalog skin(String variant)
    {
        return addConventionalSkin(
                variant,
                SkinRole.ALTERNATE
        );
    }

    /**
     * Adds the required default skin with explicit registry and resource data.
     *
     * @param skinId stable skin ID persisted in appearance data
     * @param displayNameKey localization key shown in the GUI
     * @param texturePath texture path within the catalog's resource domain
     * @return this unpublished catalog for chained declarations
     */
    public ConfigurablePropSkinCatalog defaultCustomSkin(
            String skinId,
            String displayNameKey,
            String texturePath
    )
    {
        return addCustomSkin(
                skinId,
                displayNameKey,
                texturePath,
                SkinRole.DEFAULT
        );
    }

    /**
     * Adds an alternate skin with explicit registry and resource data.
     *
     * @param skinId stable skin ID persisted in appearance data
     * @param displayNameKey localization key shown in the GUI
     * @param texturePath texture path within the catalog's resource domain
     * @return this unpublished catalog for chained declarations
     */
    public ConfigurablePropSkinCatalog customSkin(
            String skinId,
            String displayNameKey,
            String texturePath
    )
    {
        return addCustomSkin(
                skinId,
                displayNameKey,
                texturePath,
                SkinRole.ALTERNATE
        );
    }

    /**
     * Adds an independent appearance category after the generated skin selector.
     *
     * @param trait non-skin trait with an ID unique inside this profile
     * @return this unpublished catalog for chained declarations
     */
    public ConfigurablePropSkinCatalog trait(CustomizationTrait trait)
    {
        ensureMutable();
        if (trait == null)
        {
            throw new IllegalArgumentException("Customization trait cannot be null");
        }
        if (AppearanceData.TRAIT_SKIN.equals(trait.getId()))
        {
            throw new IllegalArgumentException(
                    "Skin catalogs generate their own skin selector trait"
            );
        }
        for (CustomizationTrait existing : additionalTraits)
        {
            if (existing.getId().equals(trait.getId()))
            {
                throw new IllegalArgumentException(
                        "Duplicate trait " + trait.getId() + " in profile " + profileId
                );
            }
        }
        additionalTraits.add(trait);
        return this;
    }

    /** Returns the declared default skin ID for the owning prop definition. */
    public String getDefaultSkinId()
    {
        if (defaultSkinId == null)
        {
            throw new IllegalStateException(
                    "Skin catalog has no default skin: " + profileId
            );
        }
        return defaultSkinId;
    }

    /**
     * Publishes every declared skin and the derived profile exactly once. The
     * catalog becomes immutable after successful registration.
     *
     * @throws IllegalStateException when no default exists or the catalog was already registered
     * @throws IllegalArgumentException when a global skin or profile ID is duplicate
     */
    public void register()
    {
        ensureMutable();
        String selectedDefaultSkinId = getDefaultSkinId();

        Set<String> skinIds = new LinkedHashSet<String>();
        List<CustomizationTraitOption> skinOptions =
                new ArrayList<CustomizationTraitOption>();
        for (SkinDefinition skin : skins)
        {
            skinIds.add(skin.getId());
            skinOptions.add(new CustomizationTraitOption(
                    skin.getId(),
                    skin.getDisplayNameKey()
            ));
        }

        List<CustomizationTrait> traits = new ArrayList<CustomizationTrait>();
        traits.add(new CustomizationTrait(
                AppearanceData.TRAIT_SKIN,
                "gui.foxblocks.propAppearance.trait.skin",
                CustomizationTrait.Kind.SKIN,
                selectedDefaultSkinId,
                skinOptions
        ));
        traits.addAll(additionalTraits);

        CustomizationProfile profile = new CustomizationProfile(
                profileId,
                selectedDefaultSkinId,
                skinIds,
                traits
        );
        if (CustomizationRegistry.getProfile(profileId) != null)
        {
            throw new IllegalArgumentException(
                    "Duplicate customization profile ID: " + profileId
            );
        }
        for (SkinDefinition skin : skins)
        {
            if (CustomizationRegistry.getSkin(skin.getId()) != null)
            {
                throw new IllegalArgumentException(
                        "Duplicate skin ID: " + skin.getId()
                );
            }
        }
        for (SkinDefinition skin : skins)
        {
            CustomizationRegistry.registerSkin(skin);
        }
        CustomizationRegistry.registerProfile(profile);
        registered = true;
    }

    /** Derives one skin's stable metadata from its normalized variant token. */
    private ConfigurablePropSkinCatalog addConventionalSkin(
            String variant,
            SkinRole role
    )
    {
        String normalizedVariant = requireValue(variant, "skin variant")
                .toLowerCase(Locale.ROOT);
        if (texturePattern.contains(SKIN_PLACEHOLDER) == false)
        {
            throw new IllegalStateException(
                    "Skin texture pattern must contain " + SKIN_PLACEHOLDER
            );
        }
        return addCustomSkin(
                profileId + "_" + normalizedVariant,
                displayNameKeyBase + "_" + normalizedVariant,
                texturePattern.replace(SKIN_PLACEHOLDER, normalizedVariant),
                role
        );
    }

    /**
     * Validates and appends one explicit skin. Global registries remain untouched
     * until {@link #register()} is called.
     */
    private ConfigurablePropSkinCatalog addCustomSkin(
            String skinId,
            String displayNameKey,
            String texturePath,
            SkinRole role
    )
    {
        ensureMutable();
        SkinDefinition skin = new SkinDefinition(
                skinId,
                displayNameKey,
                new ResourceLocation(resourceDomain, texturePath)
        );
        for (SkinDefinition existing : skins)
        {
            if (existing.getId().equals(skin.getId()))
            {
                throw new IllegalArgumentException(
                        "Duplicate skin " + skin.getId() + " in profile " + profileId
                );
            }
        }
        if (role == SkinRole.DEFAULT && defaultSkinId != null)
        {
            throw new IllegalStateException(
                    "Skin catalog already has a default skin: " + profileId
            );
        }

        skins.add(skin);
        if (role == SkinRole.DEFAULT)
        {
            defaultSkinId = skin.getId();
        }
        return this;
    }

    /** Rejects configuration changes after this catalog publishes global state. */
    private void ensureMutable()
    {
        if (registered)
        {
            throw new IllegalStateException(
                    "Skin catalog is already registered: " + profileId
            );
        }
    }

    /** Requires a nonblank catalog value and returns its trimmed representation. */
    private static String requireValue(String value, String name)
    {
        if (value == null || value.trim().length() == 0)
        {
            throw new IllegalArgumentException("Skin catalog " + name + " cannot be empty");
        }
        return value.trim();
    }
}
