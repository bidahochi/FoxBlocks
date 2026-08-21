package com.bidahochi.BlockMod.blocks.props.configurable.data;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Immutable player-authored offset measured in hundredths of a block along the
 * prop's local right, up, and forward axes. Vertical displacement and the
 * complete horizontal displacement vector remain below one block so the
 * rendered interaction volume always overlaps its physical controller cell.
 */
public final class PropPlacementOffset
{

    /** Global absolute placement limit in hundredths of a block. */
    public static final int MAX_HUNDREDTHS = 99;
    /** Converts one persisted integer unit into block coordinates. */
    public static final double HUNDREDTH_SIZE = 1.0D / 100.0D;

    private final int rightHundredths;
    private final int upHundredths;
    private final int forwardHundredths;

    /**
     * Creates and normalizes a local placement offset. Horizontal values are
     * scaled together when their combined radius exceeds the global limit.
     *
     * @param rightHundredths local right displacement in hundredths of a block
     * @param upHundredths vertical displacement in hundredths of a block
     * @param forwardHundredths local forward displacement in hundredths of a block
     */
    public PropPlacementOffset(int rightHundredths, int upHundredths, int forwardHundredths)
    {
        int clampedRight = clampToRange(rightHundredths, MAX_HUNDREDTHS);
        int clampedForward = clampToRange(forwardHundredths, MAX_HUNDREDTHS);
        double horizontalMagnitude = Math.sqrt(
                clampedRight * clampedRight + clampedForward * clampedForward
        );
        if (horizontalMagnitude > MAX_HUNDREDTHS)
        {
            double horizontalScale = MAX_HUNDREDTHS / horizontalMagnitude;
            clampedRight = (int) Math.round(clampedRight * horizontalScale);
            clampedForward = (int) Math.round(clampedForward * horizontalScale);
            while (clampedRight * clampedRight + clampedForward * clampedForward
                    > MAX_HUNDREDTHS * MAX_HUNDREDTHS)
            {
                if (Math.abs(clampedRight) >= Math.abs(clampedForward))
                {
                    clampedRight -= Integer.signum(clampedRight);
                }
                else
                {
                    clampedForward -= Integer.signum(clampedForward);
                }
            }
        }
        this.rightHundredths = clampedRight;
        this.upHundredths = clampToRange(upHundredths, MAX_HUNDREDTHS);
        this.forwardHundredths = clampedForward;
    }

    /**
     * Returns an offset centered on the controller origin.
     *
     * @return new zero-valued offset
     */
    public static PropPlacementOffset zero()
    {
        return new PropPlacementOffset(0, 0, 0);
    }

    /**
     * Returns the local right-axis offset.
     *
     * @return signed displacement in hundredths of a block
     */
    public int getRightHundredths()
    {
        return rightHundredths;
    }

    /**
     * Returns the vertical offset.
     *
     * @return signed displacement in hundredths of a block
     */
    public int getUpHundredths()
    {
        return upHundredths;
    }

    /**
     * Returns the local forward-axis offset.
     *
     * @return signed displacement in hundredths of a block
     */
    public int getForwardHundredths()
    {
        return forwardHundredths;
    }

    /**
     * Returns the local right-axis offset in render coordinates.
     *
     * @return signed displacement in blocks
     */
    public double getRightBlocks()
    {
        return rightHundredths * HUNDREDTH_SIZE;
    }

    /**
     * Returns the vertical offset in render coordinates.
     *
     * @return signed displacement in blocks
     */
    public double getUpBlocks()
    {
        return upHundredths * HUNDREDTH_SIZE;
    }

    /**
     * Returns the local forward-axis offset in render coordinates.
     *
     * @return signed displacement in blocks
     */
    public double getForwardBlocks()
    {
        return forwardHundredths * HUNDREDTH_SIZE;
    }

    /**
     * Returns a copy additionally limited by a prop definition's per-axis range.
     * The global component and horizontal-radius limits still apply.
     *
     * @param maxHundredths requested non-negative per-axis limit in hundredths
     * @return normalized offset that does not exceed either limit
     */
    public PropPlacementOffset clampedToRange(int maxHundredths)
    {
        int max = Math.max(0, Math.min(MAX_HUNDREDTHS, maxHundredths));
        return new PropPlacementOffset(
                clampToRange(rightHundredths, max),
                clampToRange(upHundredths, max),
                clampToRange(forwardHundredths, max)
        );
    }

    /**
     * Writes normalized local-axis components to a parent compound.
     *
     * @param tag destination compound owned by an item or controller tile
     */
    public void writeToNBT(NBTTagCompound tag)
    {
        tag.setInteger("Right", rightHundredths);
        tag.setInteger("Up", upHundredths);
        tag.setInteger("Forward", forwardHundredths);
    }

    /**
     * Reads and normalizes local-axis components.
     *
     * @param tag stored placement compound, or {@code null} when absent
     * @return normalized stored offset, or {@link #zero()} when absent
     */
    public static PropPlacementOffset readFromNBT(NBTTagCompound tag)
    {
        if (tag == null)
        {
            return zero();
        }
        return new PropPlacementOffset(
                tag.getInteger("Right"),
                tag.getInteger("Up"),
                tag.getInteger("Forward")
        );
    }

    /** Restricts a component to the supplied symmetric positive and negative limit. */
    private static int clampToRange(int value, int max)
    {
        return Math.max(-max, Math.min(max, value));
    }

}
