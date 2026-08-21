package com.bidahochi.BlockMod.blocks.props.configurable.client;

import com.bidahochi.BlockMod.render.tmt.ModelBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Client-side factory for a definition's model ID. The model registry caches and
 * reuses a successfully returned model, so implementations must not depend on
 * per-prop mutable render state.
 */
@SideOnly(Side.CLIENT)
public interface IConfigurablePropModelFactory
{
    /**
     * Creates the model instance cached by the client registry.
     *
     * @return non-null model safe to share across every prop instance
     */
    public ModelBase createModel();
}
