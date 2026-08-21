package com.bidahochi.BlockMod.blocks.props;


import com.bidahochi.BlockMod.blocks.props.configurable.content.entries.SodaMachineProp;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.LegacyConfigurablePropTile;

/** Loads historical soda-machine tiles through the configurable-prop runtime. */
public class TileSoda_machine extends LegacyConfigurablePropTile
{
    /**
     * Creates a converted tile using the historical quarter-turn direction.
     *
     * @param dir clockwise quarter turns from the legacy block orientation
     */
    public TileSoda_machine(int dir)
    {
        super(SodaMachineProp.ID, SodaMachineProp.SKIN, dir);
    }

    /** Creates an empty tile for Minecraft deserialization. */
    public TileSoda_machine()
    {
        super(SodaMachineProp.ID, SodaMachineProp.SKIN);
    }
}
