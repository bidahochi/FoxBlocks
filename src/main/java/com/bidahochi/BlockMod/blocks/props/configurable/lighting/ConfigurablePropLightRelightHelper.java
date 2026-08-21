package com.bidahochi.BlockMod.blocks.props.configurable.lighting;

import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

/** Performs one event-driven block-light recalculation for an emitter cell. */
public final class ConfigurablePropLightRelightHelper
{

    /** Prevents construction of this static utility class. */
    private ConfigurablePropLightRelightHelper()
    {
    }

    /**
     * Requests one relight without retaining retry state. Placement, state
     * changes, and chunk-load events provide every supported retry opportunity.
     * The method has no effect on a missing world or unloaded coordinate.
     *
     * @param world world whose block-light data should be recalculated
     * @param x emitter block X coordinate
     * @param y emitter block Y coordinate
     * @param z emitter block Z coordinate
     */
    public static void request(World world, int x, int y, int z)
    {
        if (world == null || world.blockExists(x, y, z) == false)
        {
            return;
        }
        world.updateLightByType(EnumSkyBlock.Block, x, y, z);
    }
}
