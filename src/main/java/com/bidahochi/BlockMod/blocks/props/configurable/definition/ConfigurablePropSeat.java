package com.bidahochi.BlockMod.blocks.props.configurable.definition;

import com.bidahochi.BlockMod.common.rotation.RotationAmount;

/**
 * One named sitting position authored in controller-local block coordinates.
 */
public final class ConfigurablePropSeat
{

    private final String id;
    private final double localX;
    private final double localY;
    private final double localZ;
    private final float yawOffset;

    /**
     * Creates a seat authored relative to the unrotated controller origin.
     *
     * @param id stable seat ID, such as {@code left} or {@code right}
     * @param localX horizontal X offset in blocks before prop rotation
     * @param localY vertical offset in blocks from the controller origin
     * @param localZ horizontal Z offset in blocks before prop rotation
     * @param yawOffset rider-facing adjustment in degrees after prop rotation
     */
    public ConfigurablePropSeat(
            String id,
            double localX,
            double localY,
            double localZ,
            float yawOffset
    )
    {
        this.id = id;
        this.localX = localX;
        this.localY = localY;
        this.localZ = localZ;
        this.yawOffset = yawOffset;
    }

    /**
     * Returns the stable seat ID used to distinguish multiple anchors.
     *
     * @return normalized seat identifier
     */
    public String getId()
    {
        return id;
    }

    /**
     * Returns the rotated X offset from the controller origin.
     *
     * @param rotation placed prop rotation, or {@code null} for no rotation
     * @return world-axis X offset in blocks
     */
    public double getControllerOffsetX(RotationAmount rotation)
    {
        return rotation != null ? rotation.rotateX(localX, localZ) : localX;
    }

    /**
     * Returns the vertical offset from the controller origin.
     *
     * @return signed upward displacement in blocks
     */
    public double getControllerOffsetY()
    {
        return localY;
    }

    /**
     * Returns the rotated Z offset from the controller origin.
     *
     * @param rotation placed prop rotation, or {@code null} for no rotation
     * @return world-axis Z offset in blocks
     */
    public double getControllerOffsetZ(RotationAmount rotation)
    {
        return rotation != null ? rotation.rotateZ(localX, localZ) : localZ;
    }

    /**
     * Returns the seat entity's world yaw after applying the prop rotation.
     *
     * @param rotation placed prop rotation, or {@code null} for zero degrees
     * @return rider yaw in degrees
     */
    public float getWorldYaw(RotationAmount rotation)
    {
        return (rotation != null ? rotation.toDegrees() : 0.0F) + yawOffset;
    }
}
