package com.bidahochi.BlockMod.blocks.props.configurable.interaction;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/** Maps stable interaction identifiers to reusable prop behavior implementations. */
public final class ConfigurablePropInteractionRegistry
{

    private static final Map<String, ConfigurablePropInteraction> INTERACTIONS =
            new LinkedHashMap<String, ConfigurablePropInteraction>();

    /** Prevents construction of this static utility class. */
    private ConfigurablePropInteractionRegistry()
    {
    }

    /**
     * Registers reusable server-authoritative behavior under a stable identifier.
     * Prop definitions refer to this identifier rather than directly constructing
     * behavior objects.
     *
     * @param interactionId stable identifier stored by prop definitions
     * @param interaction behavior implementation shared by matching props
     * @throws IllegalArgumentException when either argument is missing or the ID
     *         has already been registered
     */
    public static void register(String interactionId, ConfigurablePropInteraction interaction)
    {
        String normalizedInteractionId = normalizeInteractionId(interactionId);
        if (normalizedInteractionId.length() == 0 || interaction == null)
        {
            throw new IllegalArgumentException(
                    "Configurable prop interaction ID and behavior are required."
            );
        }
        if (INTERACTIONS.containsKey(normalizedInteractionId))
        {
            throw new IllegalArgumentException(
                    "Duplicate configurable prop interaction ID: " + normalizedInteractionId
            );
        }
        INTERACTIONS.put(normalizedInteractionId, interaction);
    }

    /**
     * Resolves reusable behavior for a definition.
     *
     * @param interactionId stable behavior identifier
     * @return registered behavior, or {@code null} for an empty or unknown identifier
     */
    public static ConfigurablePropInteraction getInteraction(String interactionId)
    {
        return INTERACTIONS.get(normalizeInteractionId(interactionId));
    }

    /** Normalizes an interaction ID once at the registry boundary. */
    private static String normalizeInteractionId(String interactionId)
    {
        return interactionId != null
                ? interactionId.trim().toLowerCase(Locale.ROOT)
                : "";
    }
}
