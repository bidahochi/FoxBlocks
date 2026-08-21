package com.bidahochi.BlockMod.blocks.props.configurable.definition;

import com.bidahochi.BlockMod.common.rotation.RotationAmount;

/** Maps one named inventory range to one local cell of a prop structure. */
public final class ConfigurablePropCompartment
{

    private final String id;
    private final String inventoryName;
    private final int size;
    private final int startSlot;
    private final int localX;
    private final int localY;
    private final int localZ;

    ConfigurablePropCompartment(
            String id,
            String inventoryName,
            int size,
            int startSlot,
            int localX,
            int localY,
            int localZ
    )
    {
        this.id = id;
        this.inventoryName = inventoryName;
        this.size = size;
        this.startSlot = startSlot;
        this.localX = localX;
        this.localY = localY;
        this.localZ = localZ;
    }

    /**
     * Returns the stable compartment ID.
     *
     * @return identifier used by behavior and GUI code
     */
    public String getId()
    {
        return id;
    }

    /**
     * Returns the localized inventory title key.
     *
     * @return inventory localization key
     */
    public String getInventoryName()
    {
        return inventoryName;
    }

    /**
     * Returns the number of inventory slots owned by this compartment.
     *
     * @return positive slot count
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Returns this compartment's first slot in the controller's combined inventory.
     *
     * @return zero-based global start slot
     */
    public int getStartSlot()
    {
        return startSlot;
    }

    /**
     * Tests whether a clicked structure cell addresses this compartment after
     * applying the placed prop's rotation.
     *
     * @param relativeX world-X cell offset from the controller
     * @param relativeY world-Y cell offset from the controller
     * @param relativeZ world-Z cell offset from the controller
     * @param rotation placed prop rotation used to transform the authored cell
     * @return {@code true} when the relative cell opens this compartment
     */
    public boolean occupiesRelativeOffset(
            int relativeX,
            int relativeY,
            int relativeZ,
            RotationAmount rotation
    )
    {
        int[] rotated = ConfigurablePropStructure.rotateOffset(localX, localY, localZ, rotation);
        return rotated[0] == relativeX
                && rotated[1] == relativeY
                && rotated[2] == relativeZ;
    }
}
