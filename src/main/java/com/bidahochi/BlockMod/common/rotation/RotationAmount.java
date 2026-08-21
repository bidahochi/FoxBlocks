package com.bidahochi.BlockMod.common.rotation;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;

/**
 * Immutable horizontal angle stored as a deterministic fixed-point fraction of
 * one complete turn. Definitions choose placement snapping separately, so a
 * saved angle remains valid if a prop later permits finer rotation.
 */
public final class RotationAmount
{

    /** Persistent tag holding the normalized fixed-point angle. */
    public static final String NBT_KEY = "RotationAmount";
    /** Number of fixed-point units in one complete turn. */
    public static final int UNITS_PER_TURN = 65536;
    /** Number of fixed-point units in one cardinal quarter turn. */
    public static final int UNITS_PER_QUARTER_TURN = UNITS_PER_TURN / 4;
    private final int angleUnits;

    /** Creates a normalized fixed-point angle value. */
    private RotationAmount(int angleUnits)
    {
        this.angleUnits = normalizeUnits(angleUnits);
    }

    /**
     * Creates and normalizes an angle from fixed-point rotation units.
     *
     * @param angleUnits signed units where 65,536 represents one complete turn
     * @return normalized angle in the range from zero to one turn
     */
    public static RotationAmount fromAngleUnits(int angleUnits)
    {
        return new RotationAmount(angleUnits);
    }

    /**
     * Creates an angle from degrees, rounded to the nearest fixed-point unit.
     *
     * @param degrees signed angle; values outside one turn are wrapped
     * @return normalized fixed-point angle
     */
    public static RotationAmount fromDegrees(double degrees)
    {
        double normalizedDegrees = degrees % 360.0D;
        if (normalizedDegrees < 0.0D)
        {
            normalizedDegrees += 360.0D;
        }
        return fromAngleUnits((int) Math.round(
                normalizedDegrees * UNITS_PER_TURN / 360.0D
        ));
    }

    /**
     * Creates a placement angle from an entity's yaw and a definition's snap
     * policy.
     *
     * @param placer entity supplying placement yaw, or {@code null} for zero
     * @param rotationSnap snap policy, or {@code null} for locked zero rotation
     * @return snapped or continuous normalized angle
     */
    public static RotationAmount fromPlacement(
            EntityLivingBase placer,
            RotationSnap rotationSnap
    )
    {
        if (placer == null || rotationSnap == null || rotationSnap.isLocked())
        {
            return fromAngleUnits(0);
        }
        return fromYaw(placer.rotationYaw, rotationSnap);
    }

    /**
     * Creates a rotation directly from Minecraft yaw.
     *
     * @param yaw signed yaw in degrees
     * @param rotationSnap snap policy, or {@code null} for locked zero rotation
     * @return snapped or continuous normalized angle
     */
    public static RotationAmount fromYaw(double yaw, RotationSnap rotationSnap)
    {
        if (rotationSnap == null || rotationSnap.isLocked())
        {
            return fromAngleUnits(0);
        }
        if (rotationSnap.isContinuous())
        {
            return fromDegrees(yaw);
        }

        int directionCount = rotationSnap.getDirectionCount();
        int snappedDirection = MathHelper.floor_double(
                (yaw * directionCount / 360.0D) + 0.5D
        );
        return fromAngleUnits(
                snappedDirection * rotationSnap.getAngleUnitsPerDirection()
        );
    }

    /**
     * Converts the historical zero-through-three quarter-turn representation.
     *
     * @param legacyRotation historical direction index; only its lowest two bits are used
     * @return equivalent fixed-point angle
     */
    public static RotationAmount fromLegacyQuarterTurns(int legacyRotation)
    {
        return fromAngleUnits((legacyRotation & 3) * UNITS_PER_QUARTER_TURN);
    }

    /**
     * Reads the stored fixed-point angle.
     *
     * @param tag containing {@link #NBT_KEY}, or {@code null}
     * @return stored normalized angle, or zero degrees when absent
     */
    public static RotationAmount readFromNBT(NBTTagCompound tag)
    {
        if (tag == null)
        {
            return fromAngleUnits(0);
        }
        if (tag.hasKey(NBT_KEY))
        {
            return fromAngleUnits(tag.getInteger(NBT_KEY));
        }
        return fromAngleUnits(0);
    }

    /**
     * Writes this angle using {@link #NBT_KEY}.
     *
     * @param tag destination item or tile compound
     */
    public void writeToNBT(NBTTagCompound tag)
    {
        tag.setInteger(NBT_KEY, angleUnits);
    }

    /**
     * Returns the normalized fixed-point angle.
     *
     * @return angle from 0 inclusive to {@link #UNITS_PER_TURN} exclusive
     */
    public int getAngleUnits()
    {
        return angleUnits;
    }

    /**
     * Converts this angle to degrees.
     *
     * @return angle from 0 inclusive to 360 exclusive
     */
    public float toDegrees()
    {
        return angleUnits * 360.0F / UNITS_PER_TURN;
    }

    /**
     * Returns a new angle with an additional degree adjustment.
     *
     * @param degrees signed adjustment in degrees
     * @return normalized adjusted angle
     */
    public RotationAmount plusDegrees(double degrees)
    {
        int additionalUnits = (int) Math.round(
                degrees * UNITS_PER_TURN / 360.0D
        );
        return fromAngleUnits(angleUnits + additionalUnits);
    }

    /**
     * Tests whether this angle lies exactly on a cardinal quarter turn.
     *
     * @return {@code true} for 0, 90, 180, or 270 degrees
     */
    public boolean isCardinal()
    {
        return angleUnits % UNITS_PER_QUARTER_TURN == 0;
    }

    /**
     * Returns the exact cardinal quarter-turn index.
     *
     * @return direction index from 0 through 3
     * @throws IllegalStateException when this angle is not cardinal
     */
    public int getCardinalQuarterTurns()
    {
        if (isCardinal() == false)
        {
            throw new IllegalStateException(
                    "Rotation is not cardinal: " + toDegrees() + " degrees"
            );
        }
        return angleUnits / UNITS_PER_QUARTER_TURN;
    }

    /**
     * Rotates a horizontal local coordinate and returns its world-X component.
     *
     * @param x local X coordinate
     * @param z local Z coordinate paired with {@code x}
     * @return rotated X component in the same unit as the inputs
     */
    public double rotateX(double x, double z)
    {
        double angle = Math.toRadians(toDegrees());
        return x * Math.cos(angle) - z * Math.sin(angle);
    }

    /**
     * Rotates a horizontal local coordinate and returns its world-Z component.
     *
     * @param x local X coordinate paired with {@code z}
     * @param z local Z coordinate
     * @return rotated Z component in the same unit as the inputs
     */
    public double rotateZ(double x, double z)
    {
        double angle = Math.toRadians(toDegrees());
        return x * Math.sin(angle) + z * Math.cos(angle);
    }

    /** Wraps fixed-point units into the range for one complete turn. */
    private static int normalizeUnits(int angleUnits)
    {
        int normalizedUnits = angleUnits % UNITS_PER_TURN;
        return normalizedUnits < 0
                ? normalizedUnits + UNITS_PER_TURN
                : normalizedUnits;
    }
}
