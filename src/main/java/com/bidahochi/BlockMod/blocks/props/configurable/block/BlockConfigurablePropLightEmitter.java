package com.bidahochi.BlockMod.blocks.props.configurable.block;

import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropBlockProperties;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropLightEmitter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/** Invisible multiblock part whose non-ticking tile caches one emitted light level. */
public final class BlockConfigurablePropLightEmitter extends BlockConfigurablePropPart
{

    /** Creates a wood-family light-emitter part. */
    public BlockConfigurablePropLightEmitter()
    {
        super();
    }

    /**
     * Creates a light-emitter part using the supplied physical material family.
     *
     * @param properties material, sound, and orphan physical fallback
     */
    public BlockConfigurablePropLightEmitter(ConfigurablePropBlockProperties properties)
    {
        super(properties);
    }

    /** {@inheritDoc} */
    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileConfigurablePropLightEmitter();
    }

    /** {@inheritDoc} */
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        return tile instanceof TileConfigurablePropLightEmitter
                ? ((TileConfigurablePropLightEmitter) tile).getEmittedLightLevel()
                : 0;
    }

}
