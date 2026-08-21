package com.bidahochi.BlockMod.blocks.props.configurable.content;

/**
 * Add-on contract for one configurable prop. Implementations normally keep a
 * single stable {@link ConfigurablePropCatalogEntry} and register every skin,
 * profile, trait, and texture referenced by its definition.
 */
public interface IConfigurablePropContentEntry
{

    /**
     * Returns the block-registration metadata and runtime definition.
     *
     * @return non-null catalog entry retained for the lifetime of registration
     */
    public ConfigurablePropCatalogEntry getCatalogEntry();

    /** Registers all customization content referenced by the definition. */
    public void registerCustomization();
}
