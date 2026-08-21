package com.bidahochi.BlockMod.blocks.props.configurable.content;

import com.bidahochi.BlockMod.blocks.props.configurable.content.entries.DryvanTrailer53Prop;
import com.bidahochi.BlockMod.blocks.props.configurable.content.entries.Fridge70sProp;
import com.bidahochi.BlockMod.blocks.props.configurable.content.entries.SodaMachineProp;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropRegistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Collects built-in and add-on prop entries before Minecraft block registration closes. */
public final class ConfigurablePropCatalog
{

    private static final List<IConfigurablePropContentEntry> ENTRIES =
            new ArrayList<IConfigurablePropContentEntry>();

    private static boolean defaultsRegistered;

    /** Prevents construction of this static utility class. */
    private ConfigurablePropCatalog()
    {
    }

    /** Adds the built-in prop entries once. */
    public static void registerDefaults()
    {
        if (defaultsRegistered)
        {
            return;
        }
        defaultsRegistered = true;
        registerEntry(new Fridge70sProp());
        registerEntry(new DryvanTrailer53Prop());
        registerEntry(new SodaMachineProp());
    }

    /**
     * Adds a content entry after checking definition and block registry IDs.
     * Add-on authors should normally call {@code ConfigurablePropApi.registerContent}
     * so lifecycle restrictions are also enforced.
     *
     * @param contentEntry entry supplying customization, definition, and block metadata
     * @throws IllegalArgumentException when the entry is null or duplicates an existing ID
     */
    public static void registerEntry(IConfigurablePropContentEntry contentEntry)
    {
        if (contentEntry == null)
        {
            throw new IllegalArgumentException("Configurable prop content entry cannot be null.");
        }
        ConfigurablePropCatalogEntry entry = contentEntry.getCatalogEntry();
        if (entry == null)
        {
            throw new IllegalArgumentException(
                    "Configurable prop content entry must provide catalog metadata."
            );
        }
        for (IConfigurablePropContentEntry existingEntry : ENTRIES)
        {
            ConfigurablePropCatalogEntry existing = existingEntry.getCatalogEntry();
            if (existing.getDefinition().getId().equals(entry.getDefinition().getId()))
            {
                throw new IllegalArgumentException(
                        "Duplicate configurable prop ID: " + entry.getDefinition().getId()
                );
            }
            if (existing.getRegistryName().equals(entry.getRegistryName()))
            {
                throw new IllegalArgumentException(
                        "Duplicate configurable prop registry name: " + entry.getRegistryName()
                );
            }
        }
        ENTRIES.add(contentEntry);
    }

    /** Returns an unmodifiable view in deterministic registration order. */
    public static List<IConfigurablePropContentEntry> getEntries()
    {
        return Collections.unmodifiableList(ENTRIES);
    }

    /** Publishes every catalog definition to the runtime definition registry. */
    public static void registerDefinitions()
    {
        for (IConfigurablePropContentEntry content : ENTRIES)
        {
            ConfigurablePropRegistry.register(content.getCatalogEntry().getDefinition());
        }
    }

    /** Lets each catalog entry register its skins, traits, and texture rules. */
    public static void registerCustomization()
    {
        for (IConfigurablePropContentEntry content : ENTRIES)
        {
            content.registerCustomization();
        }
    }
}
