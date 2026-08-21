package com.bidahochi.BlockMod.blocks.props.configurable.content;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;

import java.util.Locale;

/** Holds stable block-registration metadata for one configurable prop definition. */
public final class ConfigurablePropCatalogEntry
{

    private final String resourceDomain;
    private final String blockName;
    private final String registryName;
    private final String iconPath;
    private final ConfigurablePropDefinition definition;

    /**
     * Creates registration metadata using the FoxBlocks resource domain.
     *
     * @param blockName unlocalized block name passed to {@code setBlockName}
     * @param registryName stable GameRegistry name; changing it breaks worlds
     * @param iconPath block icon path without the resource-domain prefix
     * @param definition runtime behavior, structure, and rendering definition
     * @throws IllegalArgumentException when required metadata is missing
     */
    public ConfigurablePropCatalogEntry(
            String blockName,
            String registryName,
            String iconPath,
            ConfigurablePropDefinition definition
    )
    {
        this(FoxBlocks.MODID, blockName, registryName, iconPath, definition);
    }

    /**
     * Creates registration metadata for content whose assets belong to an
     * explicit resource domain.
     *
     * @param resourceDomain asset namespace, normalized to lower case; blank uses FoxBlocks
     * @param blockName unlocalized block name passed to {@code setBlockName}
     * @param registryName stable GameRegistry name; changing it breaks worlds
     * @param iconPath block icon path within {@code resourceDomain}
     * @param definition runtime behavior, structure, and rendering definition
     * @throws IllegalArgumentException when required metadata is missing
     */
    public ConfigurablePropCatalogEntry(
            String resourceDomain,
            String blockName,
            String registryName,
            String iconPath,
            ConfigurablePropDefinition definition
    )
    {
        this.resourceDomain = resourceDomain != null && resourceDomain.trim().length() > 0
                ? resourceDomain.trim().toLowerCase(Locale.ROOT)
                : FoxBlocks.MODID;
        this.blockName = requireText(blockName, "block name");
        this.registryName = requireText(registryName, "registry name");
        this.iconPath = requireText(iconPath, "icon path");
        if (definition == null)
        {
            throw new IllegalArgumentException("Configurable prop definition cannot be null.");
        }
        this.definition = definition;
    }

    /** Returns the resource domain that owns the block and icon. */
    public String getResourceDomain()
    {
        return resourceDomain;
    }

    /** Returns the unlocalized Minecraft block name. */
    public String getBlockName()
    {
        return blockName;
    }

    /** Returns the GameRegistry block identifier. */
    public String getRegistryName()
    {
        return registryName;
    }

    /** Returns the block icon path within the resource domain. */
    public String getIconPath()
    {
        return iconPath;
    }

    /** Returns the runtime definition supplied by this catalog entry. */
    public ConfigurablePropDefinition getDefinition()
    {
        return definition;
    }

    /** Requires nonblank registration metadata while preserving caller-selected case. */
    private static String requireText(String value, String role)
    {
        if (value == null || value.trim().length() == 0)
        {
            throw new IllegalArgumentException("Configurable prop " + role + " cannot be empty.");
        }
        return value.trim();
    }
}
