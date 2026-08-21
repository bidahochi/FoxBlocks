package com.bidahochi.BlockMod.blocks.props.configurable.definition;

import com.bidahochi.BlockMod.common.rotation.RotationAmount;

import java.util.ArrayList;
import java.util.List;

/** Computes cardinally rotated block-cell offsets for rectangular prop structures. */
public final class ConfigurablePropStructure
{

    /** Prevents construction of this static utility class. */
    private ConfigurablePropStructure()
    {
    }

    /**
     * Returns every occupied cell except the controller at local origin. Each
     * array contains the controller-relative X, Y, and Z offset after rotation.
     * The returned list and coordinate arrays are newly allocated and may be
     * modified by the caller.
     *
     * @param definition prop dimensions whose occupied cells are requested
     * @param rotation cardinal placement rotation; {@code null} means zero degrees
     * @return rotated controller-relative offsets, or an empty list for a
     *         {@code null} definition or a one-cell prop
     * @throws IllegalStateException when the supplied rotation is not cardinal
     */
    public static List<int[]> getPartOffsets(
            ConfigurablePropDefinition definition,
            RotationAmount rotation
    )
    {
        List<int[]> offsets = new ArrayList<int[]>();
        if (definition == null)
        {
            return offsets;
        }

        for (int localY = 0; localY < definition.getHeight(); localY++)
        {
            for (int localZ = 0; localZ < definition.getDepth(); localZ++)
            {
                for (int localX = 0; localX < definition.getWidth(); localX++)
                {
                    if (localX == 0 && localY == 0 && localZ == 0)
                    {
                        continue;
                    }
                    offsets.add(rotateOffset(localX, localY, localZ, rotation));
                }
            }
        }
        return offsets;
    }

    /**
     * Rotates a local block-cell offset around the Y axis. Multiblock cells
     * support only the four cardinal rotations.
     *
     * @param x local rightward block offset from the controller
     * @param y local upward block offset from the controller
     * @param z local forward block offset from the controller
     * @param rotation cardinal placement rotation; {@code null} means zero degrees
     * @return a new array containing rotated X, unchanged Y, and rotated Z
     * @throws IllegalStateException when {@code rotation} is non-cardinal
     */
    public static int[] rotateOffset(int x, int y, int z, RotationAmount rotation)
    {
        if (x == 0 && z == 0)
        {
            return new int[] {0, y, 0};
        }

        int quarterTurns = rotation != null ? rotation.getCardinalQuarterTurns() : 0;
        switch (quarterTurns)
        {
            case 0:
                return new int[] {x, y, z};
            case 1:
                return new int[] {-z, y, x};
            case 2:
                return new int[] {-x, y, -z};
            case 3:
                return new int[] {z, y, -x};
            default:
                throw new IllegalStateException(
                        "Unsupported cardinal quarter-turn index: " + quarterTurns
                );
        }
    }
}
