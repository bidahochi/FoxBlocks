package com.bidahochi.BlockMod.blocks.props.configurable.definition;

import com.bidahochi.BlockMod.common.rotation.RotationAmount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Describes optional block-light emission owned by a configurable prop. Light
 * emitters use unrotated local structure cells so a tall fixture can illuminate
 * from its bulb cell while retaining one controller-owned state.
 */
public final class ConfigurablePropLightDefinition
{

    private static final int MAX_EMITTER_CELLS = 16;

    private final int lightLevel;
    private final boolean litByDefault;
    private final ControlMode controlMode;
    private final List<EmitterCell> emitterCells;

    /**
     * Creates a fixture whose controller state is always lit.
     *
     * @param lightLevel vanilla block-light level from 1 through 15
     * @param localX emitter cell X in the unrotated structure footprint
     * @param localY emitter cell Y in the unrotated structure footprint
     * @param localZ emitter cell Z in the unrotated structure footprint
     * @return immutable light definition with one emitter
     */
    public static ConfigurablePropLightDefinition alwaysOn(
            int lightLevel,
            int localX,
            int localY,
            int localZ
    )
    {
        return new ConfigurablePropLightDefinition(
                lightLevel,
                true,
                ControlMode.FIXED,
                Collections.singletonList(new EmitterCell(localX, localY, localZ))
        );
    }

    /**
     * Creates a fixture whose controller-owned state may be toggled by an
     * interaction such as {@code foxblocks:light}.
     *
     * @param lightLevel vanilla block-light level from 1 through 15
     * @param litByDefault initial state for a newly placed controller
     * @param localX emitter cell X in the unrotated structure footprint
     * @param localY emitter cell Y in the unrotated structure footprint
     * @param localZ emitter cell Z in the unrotated structure footprint
     * @return immutable manually controlled light definition
     */
    public static ConfigurablePropLightDefinition manuallyControlled(
            int lightLevel,
            boolean litByDefault,
            int localX,
            int localY,
            int localZ
    )
    {
        return new ConfigurablePropLightDefinition(
                lightLevel,
                litByDefault,
                ControlMode.MANUAL,
                Collections.singletonList(new EmitterCell(localX, localY, localZ))
        );
    }

    /** Validates and stores a complete immutable light capability. */
    private ConfigurablePropLightDefinition(
            int lightLevel,
            boolean litByDefault,
            ControlMode controlMode,
            List<EmitterCell> emitterCells
    )
    {
        if (lightLevel < 1 || lightLevel > 15)
        {
            throw new IllegalArgumentException(
                    "Configurable prop light level must be 1 through 15."
            );
        }
        if (controlMode == null)
        {
            throw new IllegalArgumentException(
                    "Configurable prop light control mode cannot be null."
            );
        }
        if (emitterCells == null || emitterCells.isEmpty())
        {
            throw new IllegalArgumentException(
                    "Configurable prop light requires an emitter cell."
            );
        }
        if (emitterCells.size() > MAX_EMITTER_CELLS)
        {
            throw new IllegalArgumentException(
                    "Configurable prop light supports at most "
                            + MAX_EMITTER_CELLS
                            + " emitter cells."
            );
        }
        this.lightLevel = lightLevel;
        this.litByDefault = litByDefault;
        this.controlMode = controlMode;
        this.emitterCells = Collections.unmodifiableList(
                new ArrayList<EmitterCell>(emitterCells)
        );
    }

    /**
     * Returns a copy that also emits from one occupied structure cell. Duplicate
     * coordinates return this instance, and more than 16 unique emitters fail.
     *
     * @param localX emitter cell X in the unrotated structure footprint
     * @param localY emitter cell Y in the unrotated structure footprint
     * @param localZ emitter cell Z in the unrotated structure footprint
     * @return this definition or an immutable copy containing the new emitter
     */
    public ConfigurablePropLightDefinition withAdditionalEmitter(
            int localX,
            int localY,
            int localZ
    )
    {
        EmitterCell additionalEmitter = new EmitterCell(localX, localY, localZ);
        if (emitterCells.contains(additionalEmitter))
        {
            return this;
        }
        List<EmitterCell> expandedEmitters = new ArrayList<EmitterCell>(emitterCells);
        expandedEmitters.add(additionalEmitter);
        return new ConfigurablePropLightDefinition(
                lightLevel,
                litByDefault,
                controlMode,
                expandedEmitters
        );
    }

    /**
     * Returns the emitted vanilla block-light level.
     *
     * @return authored level from 1 through 15
     */
    public int getLightLevel()
    {
        return lightLevel;
    }

    /**
     * Returns the state used until a controlled fixture stores an override.
     *
     * @return authored initial lit state
     */
    public boolean isLitByDefault()
    {
        return litByDefault;
    }

    /**
     * Returns the fixture's supported state-control policy.
     *
     * @return fixed or manually controlled mode
     */
    public ControlMode getControlMode()
    {
        return controlMode;
    }

    /**
     * Returns the immutable unrotated emitter-cell collection.
     *
     * @return immutable cells in authored local coordinates
     */
    public List<EmitterCell> getEmitterCells()
    {
        return emitterCells;
    }

    /**
     * Tests whether a placed structure cell is one of this fixture's emitters.
     * Horizontal multiblock lighting requires a cardinal rotation.
     *
     * @param relativeX world-X cell offset from the placed controller
     * @param relativeY world-Y cell offset from the placed controller
     * @param relativeZ world-Z cell offset from the placed controller
     * @param rotation placed prop rotation
     * @return {@code true} when this relative cell emits block light
     */
    public boolean emitsAtRelativeOffset(
            int relativeX,
            int relativeY,
            int relativeZ,
            RotationAmount rotation
    )
    {
        for (EmitterCell emitterCell : emitterCells)
        {
            if (emitterCell.matchesRotatedOffset(relativeX, relativeY, relativeZ, rotation))
            {
                return true;
            }
        }
        return false;
    }

    /** Defines how a placed fixture's lit state may change. */
    public enum ControlMode
    {
        /** The definition's default state cannot be changed after placement. */
        FIXED,
        /** Server-side interaction may toggle the controller-owned state. */
        MANUAL
    }

    /** Identifies one unrotated occupied structure cell that emits block light. */
    public static final class EmitterCell
    {

        private final int localX;
        private final int localY;
        private final int localZ;

        /** Stores one local structure coordinate for later bounds validation. */
        private EmitterCell(int localX, int localY, int localZ)
        {
            this.localX = localX;
            this.localY = localY;
            this.localZ = localZ;
        }

        /**
         * Returns the local unrotated X structure coordinate.
         *
         * @return local rightward cell offset
         */
        public int getLocalX()
        {
            return localX;
        }

        /**
         * Returns the local vertical structure coordinate.
         *
         * @return local upward cell offset
         */
        public int getLocalY()
        {
            return localY;
        }

        /**
         * Returns the local unrotated Z structure coordinate.
         *
         * @return local forward cell offset
         */
        public int getLocalZ()
        {
            return localZ;
        }

        /** Compares a world-axis relative cell after applying cardinal rotation. */
        private boolean matchesRotatedOffset(
                int relativeX,
                int relativeY,
                int relativeZ,
                RotationAmount rotation
        )
        {
            if (relativeY != localY)
            {
                return false;
            }
            if (localX == 0 && localZ == 0)
            {
                return relativeX == 0 && relativeZ == 0;
            }
            int quarterTurns = rotation != null ? rotation.getCardinalQuarterTurns() : 0;
            switch (quarterTurns)
            {
                case 0:
                    return relativeX == localX && relativeZ == localZ;
                case 1:
                    return relativeX == -localZ && relativeZ == localX;
                case 2:
                    return relativeX == -localX && relativeZ == -localZ;
                case 3:
                    return relativeX == localZ && relativeZ == -localX;
                default:
                    throw new IllegalArgumentException(
                            "Unsupported light-emitter quarter-turn index: " + quarterTurns
                    );
            }
        }

        /** {@inheritDoc} */
        @Override
        public boolean equals(Object other)
        {
            if ((other instanceof EmitterCell) == false)
            {
                return false;
            }
            EmitterCell otherCell = (EmitterCell) other;
            return localX == otherCell.localX
                    && localY == otherCell.localY
                    && localZ == otherCell.localZ;
        }

        /** {@inheritDoc} */
        @Override
        public int hashCode()
        {
            int result = localX;
            result = 31 * result + localY;
            return 31 * result + localZ;
        }
    }
}
