package com.bidahochi.BlockMod.blocks.props.configurable.client;

import com.bidahochi.BlockMod.render.tmt.ModelBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Resolves stable model identifiers to lazily created, shared client model
 * instances. Each configurable prop definition selects one primary model.
 */
@SideOnly(Side.CLIENT)
public final class ConfigurablePropModelRegistry
{

    private static final Map<String, IConfigurablePropModelFactory> FACTORIES =
            new LinkedHashMap<String, IConfigurablePropModelFactory>();
    private static final Map<String, ModelBase> MODELS =
            new LinkedHashMap<String, ModelBase>();

    /** Prevents construction of this static utility class. */
    private ConfigurablePropModelRegistry()
    {
    }

    /**
     * Registers a lazy model factory under the identifier used by prop definitions.
     * A successfully created model is cached and shared by every rendered instance,
     * so the created model must not retain per-prop mutable state. A factory that
     * returns {@code null} is not cached and fails that lookup.
     *
     * @param modelId stable client-side model identifier
     * @param factory factory used to create the shared model on first access
     * @throws IllegalArgumentException when either argument is missing or the ID
     *         has already been registered
     */
    public static void register(String modelId, IConfigurablePropModelFactory factory)
    {
        if (modelId == null || modelId.length() == 0)
        {
            throw new IllegalArgumentException("Configurable prop model ID cannot be empty.");
        }
        if (factory == null)
        {
            throw new IllegalArgumentException("Configurable prop model factory cannot be null.");
        }
        if (FACTORIES.containsKey(modelId))
        {
            throw new IllegalArgumentException("Duplicate configurable prop model ID: " + modelId);
        }
        FACTORIES.put(modelId, factory);
    }

    /**
     * Returns the shared model for an identifier, creating it on first access.
     *
     * @param modelId stable model identifier from a prop definition
     * @return shared model instance, or {@code null} when no factory is registered
     * @throws IllegalStateException when the registered factory returns {@code null}
     */
    public static ModelBase getModel(String modelId)
    {
        return getRegistered(modelId);
    }

    /** Resolves and caches a registered factory's shared model on first use. */
    private static ModelBase getRegistered(String modelId)
    {
        if (modelId == null || modelId.length() == 0)
        {
            return null;
        }
        if (MODELS.containsKey(modelId))
        {
            return MODELS.get(modelId);
        }

        IConfigurablePropModelFactory factory = FACTORIES.get(modelId);
        if (factory == null)
        {
            return null;
        }

        ModelBase model = factory.createModel();
        if (model == null)
        {
            throw new IllegalStateException(
                    "Configurable prop model factory returned null: " + modelId
            );
        }
        MODELS.put(modelId, model);
        return model;
    }
}
