package com.bidahochi.BlockMod.blocks.props.configurable;

import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropLightEmitter;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropProcessor;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.world.ChunkEvent;

/**
 * Reconciles event-driven configurable-prop state after a chunk has completed
 * tile loading. Processor recovery belongs here rather than in tile validation,
 * where querying the world can recursively request the chunk being loaded.
 */
public final class ConfigurablePropChunkLoadHandler
{

    private static final int LIGHT_NEIGHBOR_CHUNK_RADIUS = 1;

    /**
     * Restarts saved processors in the newly loaded chunk and refreshes lighting
     * in that chunk plus already loaded immediate neighbors.
     *
     * @param event Forge event fired after the chunk's tiles have loaded
     */
    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event)
    {
        if (event.world.isRemote == false)
        {
            resumeChunkProcessors(event.getChunk());
        }
        refreshAffectedLighting(event.world, event.getChunk());
    }

    /** Schedules one recovery check for each saved processor in the loaded chunk. */
    private void resumeChunkProcessors(Chunk chunk)
    {
        for (Object tileObject : chunk.chunkTileEntityMap.values())
        {
            if (tileObject instanceof TileConfigurablePropProcessor)
            {
                ((TileConfigurablePropProcessor) tileObject).requestProcessorUpdate();
            }
        }
    }

    /** Refreshes the loaded chunk and only neighbors already present in memory. */
    private void refreshAffectedLighting(World world, Chunk loadedChunk)
    {
        IChunkProvider chunkProvider = world.getChunkProvider();
        for (int chunkOffsetX = -LIGHT_NEIGHBOR_CHUNK_RADIUS;
                chunkOffsetX <= LIGHT_NEIGHBOR_CHUNK_RADIUS;
                chunkOffsetX++)
        {
            for (int chunkOffsetZ = -LIGHT_NEIGHBOR_CHUNK_RADIUS;
                    chunkOffsetZ <= LIGHT_NEIGHBOR_CHUNK_RADIUS;
                    chunkOffsetZ++)
            {
                int chunkX = loadedChunk.xPosition + chunkOffsetX;
                int chunkZ = loadedChunk.zPosition + chunkOffsetZ;
                if (chunkProvider.chunkExists(chunkX, chunkZ))
                {
                    refreshChunkLighting(chunkProvider.provideChunk(chunkX, chunkZ));
                }
            }
        }
    }

    /** Refreshes only configurable-prop lighting tiles already present in a chunk. */
    private void refreshChunkLighting(Chunk chunk)
    {
        for (Object tileObject : chunk.chunkTileEntityMap.values())
        {
            if (tileObject instanceof TileConfigurablePropLightEmitter)
            {
                ((TileConfigurablePropLightEmitter) tileObject).refreshLightEmission();
            }
            else if (tileObject instanceof TileConfigurablePropController)
            {
                ((TileConfigurablePropController) tileObject).refreshLightEmission();
            }
        }
    }
}
