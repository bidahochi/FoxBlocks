package com.bidahochi.BlockMod.blocks.props.configurable.definition;

import com.bidahochi.BlockMod.customization.registry.CustomizationProfile;
import com.bidahochi.BlockMod.customization.registry.CustomizationRegistry;
import com.bidahochi.BlockMod.customization.registry.CustomizationTrait;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteractionRegistry;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropProcessorInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropStorageInteraction;
import net.minecraft.block.Block;

import java.util.LinkedHashMap;
import java.util.Map;

/** Stores validated prop definitions and their corresponding registered blocks. */
public final class ConfigurablePropRegistry
{

    private static final Map<String, ConfigurablePropDefinition> DEFINITIONS =
            new LinkedHashMap<String, ConfigurablePropDefinition>();
    private static final Map<String, Block> BLOCKS = new LinkedHashMap<String, Block>();

    /** Prevents construction of this static utility class. */
    private ConfigurablePropRegistry()
    {
    }

    /**
     * Registers a complete prop definition under its stable identifier.
     * Registration must occur after the definition's customization profile has
     * been registered when the definition contains color-trait bindings.
     *
     * @param definition fully configured definition to make available
     * @return the same now-frozen definition, allowing registration during field initialization
     * @throws IllegalArgumentException when the definition is {@code null}, its ID is
     *         already registered, or a color binding does not reference a declared
     *         color trait
     */
    public static ConfigurablePropDefinition register(ConfigurablePropDefinition definition)
    {
        if (definition == null)
        {
            throw new IllegalArgumentException("Configurable prop definition cannot be null.");
        }
        if (DEFINITIONS.containsKey(definition.getId()))
        {
            throw new IllegalArgumentException("Duplicate configurable prop ID: " + definition.getId());
        }
        validateControllerType(definition);
        validateInteractionCompatibility(definition);
        validateColorTraitBindings(definition);
        definition.freezeForRegistration();
        DEFINITIONS.put(definition.getId(), definition);
        return definition;
    }

    /**
     * Associates a definition identifier with the block used to place that prop.
     * The mapping is separate from definition registration because Minecraft block
     * construction and content registration have a different lifecycle.
     *
     * @param definitionId stable identifier returned by the prop definition
     * @param block registered Minecraft block that owns the controller tile
     * @throws IllegalArgumentException when either argument is missing or the ID
     *         already has a block mapping
     */
    public static void registerBlock(String definitionId, Block block)
    {
        if (definitionId == null || definitionId.length() == 0 || block == null)
        {
            throw new IllegalArgumentException("Configurable prop block mapping requires an ID and block.");
        }
        if (BLOCKS.containsKey(definitionId))
        {
            throw new IllegalArgumentException(
                    "Duplicate configurable prop block mapping: " + definitionId
            );
        }
        BLOCKS.put(definitionId, block);
    }

    /**
     * Looks up a prop definition by its stable identifier.
     *
     * @param id stable definition identifier
     * @return registered definition, or {@code null} when the identifier is unknown
     */
    public static ConfigurablePropDefinition getDefinition(String id)
    {
        return DEFINITIONS.get(id);
    }

    /**
     * Looks up the Minecraft block associated with a definition.
     *
     * @param definitionId stable definition identifier
     * @return mapped block, or {@code null} when block registration has not occurred
     */
    public static Block getBlock(String definitionId)
    {
        return BLOCKS.get(definitionId);
    }

    /**
     * Ensures inventory definitions select a controller that can persist their slots.
     *
     * @param definition complete definition being admitted to the registry
     * @throws IllegalArgumentException when a basic controller declares inventory
     */
    private static void validateControllerType(ConfigurablePropDefinition definition)
    {
        if (definition.getInventorySize() > 0
                && definition.getControllerType().supportsInventory() == false)
        {
            throw new IllegalArgumentException(
                    "Configurable prop inventory requires a storage or processor controller: "
                            + definition.getId()
            );
        }
    }

    /**
     * Rejects behavior contracts that require capabilities absent from the
     * selected tile type. An empty interaction remains valid for unfinished or
     * externally driven processors.
     *
     * @param definition complete definition being admitted to the registry
     */
    private static void validateInteractionCompatibility(ConfigurablePropDefinition definition)
    {
        String interactionId = definition.getInteractionId();
        if (interactionId.length() == 0)
        {
            return;
        }
        ConfigurablePropInteraction interaction =
                ConfigurablePropInteractionRegistry.getInteraction(interactionId);
        if (interaction == null)
        {
            throw new IllegalArgumentException(
                    "Unknown configurable prop interaction: "
                            + definition.getId() + " -> " + interactionId
            );
        }
        ConfigurablePropControllerType controllerType = definition.getControllerType();
        if (interaction instanceof ConfigurablePropProcessorInteraction
                && controllerType != ConfigurablePropControllerType.PROCESSOR)
        {
            throw new IllegalArgumentException(
                    "Processor interactions require a processor controller: "
                            + definition.getId()
            );
        }
        if (interaction instanceof ConfigurablePropStorageInteraction
                && controllerType.supportsInventory() == false)
        {
            throw new IllegalArgumentException(
                    "Storage interactions require an inventory-capable controller: "
                            + definition.getId()
            );
        }
        if (controllerType == ConfigurablePropControllerType.PROCESSOR
                && (interaction instanceof ConfigurablePropProcessorInteraction) == false)
        {
            throw new IllegalArgumentException(
                    "Processor configurable props require a processor interaction: "
                            + definition.getId()
            );
        }
        if (controllerType == ConfigurablePropControllerType.STORAGE
                && (interaction instanceof ConfigurablePropStorageInteraction) == false)
        {
            throw new IllegalArgumentException(
                    "Storage configurable props require a storage interaction: "
                            + definition.getId()
            );
        }
    }

    /** Ensures every optional render color binding names a declared color property. */
    private static void validateColorTraitBindings(ConfigurablePropDefinition definition)
    {
        if (definition.getColorTraitBindings().isEmpty())
        {
            return;
        }
        CustomizationProfile profile = CustomizationRegistry.getProfile(
                definition.getCustomizationProfileId()
        );
        if (profile == null)
        {
            throw new IllegalArgumentException(
                    "Missing customization profile for color bindings: " + definition.getId()
            );
        }
        for (String traitId : definition.getColorTraitBindings().values())
        {
            CustomizationTrait trait = profile.getTrait(traitId);
            if (trait == null || trait.getKind() != CustomizationTrait.Kind.COLOR)
            {
                throw new IllegalArgumentException(
                        "Configurable prop color binding must name a COLOR trait: "
                                + definition.getId() + " -> " + traitId
                );
            }
        }
    }

}
