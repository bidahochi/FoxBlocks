package com.bidahochi.BlockMod.blocks.props.configurable.height;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.utils.FBMultiPartHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Locale;

/** Resolves optional support-block height compensation for placed props. */
public final class ConfigurablePropHeightHelper
{

    /** Prevents construction of this static utility class. */
    private ConfigurablePropHeightHelper()
    {
    }

    /**
     * Returns the definition's support-specific vertical correction for the
     * block directly below a controller.
     *
     * @param definition prop definition containing optional support offsets
     * @param world world containing the proposed controller position
     * @param x controller block X coordinate
     * @param y controller block Y coordinate
     * @param z controller block Z coordinate
     * @return vertical correction in blocks, or {@code 0.0} when automatic
     *         adjustment is disabled or the support type is not recognized
     */
    public static double getAutoHeightOffset(
            ConfigurablePropDefinition definition,
            World world,
            int x,
            int y,
            int z
    )
    {
        if (definition == null || definition.isAutoHeightAdjustmentEnabled() == false || world == null)
        {
            return 0.0D;
        }

        int supportY = y - 1;
        Block supportBlock = world.getBlock(x, supportY, z);
        if (supportBlock == null)
        {
            return 0.0D;
        }
        if (isRoadCoverOrRail(supportBlock))
        {
            return definition.getAutoHeightRoadCoverRailOffset();
        }
        if (isSlabOrNonSolidMultipart(world, supportBlock, x, supportY, z))
        {
            return definition.getAutoHeightSlabOffset();
        }
        return 0.0D;
    }

    /**
     * Detects supports whose occupied top surface is half a block above their
     * block origin, including Forge Multipart containers.
     */
    private static boolean isSlabOrNonSolidMultipart(
            World world,
            Block supportBlock,
            int supportX,
            int supportY,
            int supportZ
    )
    {
        if (supportBlock instanceof BlockSlab && supportBlock.isNormalCube() == false)
        {
            return true;
        }
        if (FoxBlocks.isForgeMultiPartLoaded == false
                || FBMultiPartHelper.BlockInstanceOfBlockMultipart(supportBlock) == false)
        {
            return false;
        }
        TileEntity supportTile = world.getTileEntity(supportX, supportY, supportZ);
        return FBMultiPartHelper.isBlockSolid(supportBlock, supportTile) == false;
    }

    /** Detects thin road-cover and rail supports that use the smaller lift offset. */
    private static boolean isRoadCoverOrRail(Block supportBlock)
    {
        String blockName = supportBlock.getUnlocalizedName();
        String className = supportBlock.getClass().getName();
        String combined = ((blockName != null ? blockName : "")
                + " "
                + (className != null ? className : "")).toLowerCase(Locale.ROOT);
        return combined.contains("roadcover")
                || combined.contains("tcrail")
                || combined.contains("rail");
    }
}
