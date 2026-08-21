package com.bidahochi.BlockMod.api.configurableprops;

import com.bidahochi.BlockMod.blocks.props.configurable.ConfigurablePropSystem;
import com.bidahochi.BlockMod.blocks.props.configurable.content.IConfigurablePropContentEntry;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteraction;

/**
 * Public registration entry point for add-ons that contribute configurable
 * furniture. Call these methods from the add-on's pre-initialization phase,
 * before FoxBlocks closes configurable-prop registration during initialization.
 */
public final class ConfigurablePropApi
{

    /** Prevents construction of this static utility class. */
    private ConfigurablePropApi()
    {
    }

    /**
     * Registers one add-on-owned prop, including its definition and block
     * metadata. The content entry registers its customization dependencies when
     * FoxBlocks processes the catalog.
     *
     * @param content complete content entry to register; must not be {@code null}
     * @throws IllegalArgumentException if the entry is invalid or duplicates registered content
     * @throws IllegalStateException if registration has already closed
     */
    public static void registerContent(IConfigurablePropContentEntry content)
    {
        ConfigurablePropSystem.registerContent(content);
    }

    /**
     * Registers a reusable server-authoritative behavior before any definition
     * that selects it is used.
     *
     * @param interactionId stable namespaced ID stored by prop definitions
     * @param interaction behavior implementation selected by that ID
     * @throws IllegalArgumentException if either argument is invalid or already registered
     * @throws IllegalStateException if registration has already closed
     */
    public static void registerInteraction(
            String interactionId,
            ConfigurablePropInteraction interaction
    )
    {
        ConfigurablePropSystem.registerInteraction(interactionId, interaction);
    }
}
