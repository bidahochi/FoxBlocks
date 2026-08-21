package com.bidahochi.BlockMod.blocks.props;


import com.bidahochi.BlockMod.blocks.props.configurable.content.entries.DryvanTrailer53Prop;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.LegacyConfigurablePropTile;

/** Loads historical dryvan tiles through the shared configurable-prop runtime. */
public class TilePropTrailerDryvan1 extends LegacyConfigurablePropTile
{
    /**
     * Creates a converted tile using the historical quarter-turn direction.
     *
     * @param dir clockwise quarter turns from the legacy block orientation
     */
    public TilePropTrailerDryvan1(int dir)
    {
        super(DryvanTrailer53Prop.ID, DryvanTrailer53Prop.SKIN, dir);
    }

    /** Creates an empty tile for Minecraft deserialization. */
    public TilePropTrailerDryvan1()
    {
        super(DryvanTrailer53Prop.ID, DryvanTrailer53Prop.SKIN);
    }

    /** {@inheritDoc} */
    @Override
    public double getMaxRenderDistanceSquared()
    {
        return 16384.0D;
    }
}
