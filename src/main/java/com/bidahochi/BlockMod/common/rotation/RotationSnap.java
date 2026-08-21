package com.bidahochi.BlockMod.common.rotation;

/** Defines how a prop's placement yaw is snapped before the angle is stored. */
public enum RotationSnap
{
    /** Ignores player yaw and uses only the definition's placement yaw offset. */
    LOCKED(1),
    /** Snaps placement to four cardinal directions at 90-degree intervals. */
    FOUR(4),
    /** Snaps placement to eight directions at 45-degree intervals. */
    EIGHT(8),
    /** Snaps placement to sixteen directions at 22.5-degree intervals. */
    SIXTEEN(16),
    /** Preserves player yaw at {@link RotationAmount} fixed-point precision. */
    CONTINUOUS(0);

    private final int directionCount;

    /** Creates a snap mode with the supplied number of discrete directions. */
    private RotationSnap(int directionCount)
    {
        this.directionCount = directionCount;
    }

    /**
     * Returns the number of discrete placement directions.
     *
     * @return direction count, or zero for continuous yaw
     */
    public int getDirectionCount()
    {
        return directionCount;
    }

    /**
     * Returns the fixed-point interval between directions.
     *
     * @return angle units per direction, or zero for continuous yaw
     */
    public int getAngleUnitsPerDirection()
    {
        return isContinuous() ? 0 : RotationAmount.UNITS_PER_TURN / directionCount;
    }

    /**
     * Tests whether placement ignores player yaw.
     *
     * @return {@code true} only for {@link #LOCKED}
     */
    public boolean isLocked()
    {
        return this == LOCKED;
    }

    /**
     * Tests whether placement preserves player yaw without directional snapping.
     *
     * @return {@code true} only for {@link #CONTINUOUS}
     */
    public boolean isContinuous()
    {
        return this == CONTINUOUS;
    }

    /**
     * Tests whether this mode can rotate horizontal block cells exactly.
     *
     * @return {@code true} for locked or four-direction snapping
     */
    public boolean isCardinalCompatible()
    {
        return isContinuous() == false && directionCount <= FOUR.directionCount;
    }
}
