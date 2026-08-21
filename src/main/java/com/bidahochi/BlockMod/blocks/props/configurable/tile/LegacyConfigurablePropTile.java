package com.bidahochi.BlockMod.blocks.props.configurable.tile;

import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import com.bidahochi.BlockMod.customization.data.AppearanceData;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import net.minecraft.nbt.NBTTagCompound;

/** Adapts existing prop tile classes to the shared configurable controller contract. */
public abstract class LegacyConfigurablePropTile extends TileConfigurablePropController
{

    /** Historical quarter-turn direction retained for old block and renderer code. */
    public int dir;
    private final String legacyDefinitionId;
    private final String legacySkinId;

    /**
     * Creates an adapter whose old fields are translated during NBT loading.
     *
     * @param legacyDefinitionId shared definition represented by the old tile class
     * @param legacySkinId fallback skin used when old NBT has no appearance data
     */
    protected LegacyConfigurablePropTile(String legacyDefinitionId, String legacySkinId)
    {
        this.legacyDefinitionId = legacyDefinitionId;
        this.legacySkinId = legacySkinId;
    }

    /**
     * Creates an adapter and immediately applies a legacy quarter-turn facing.
     *
     * @param legacyDefinitionId shared definition represented by the old tile class
     * @param legacySkinId fallback skin used when old NBT has no appearance data
     * @param direction historical clockwise quarter-turn value
     */
    protected LegacyConfigurablePropTile(
            String legacyDefinitionId,
            String legacySkinId,
            int direction
    )
    {
        this(legacyDefinitionId, legacySkinId);
        dir = direction;
        applyLegacyDefaults(direction);
    }

    /** {@inheritDoc} */
    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        boolean hasNewDefinition = tag != null
                && tag.hasKey("DefinitionId")
                && tag.getString("DefinitionId").length() > 0;
        boolean hasFacingRelativeOffset = hasFacingRelativePlacementOffset(tag);
        super.readFromNBT(tag);
        if (hasNewDefinition == false)
        {
            dir = tag != null && tag.hasKey("direction")
                    ? tag.getInteger("direction")
                    : dir;
            applyLegacyDefaults(dir);
        }
        else if (hasFacingRelativeOffset == false)
        {
            dir = toLegacyQuarterTurns(getRotation());
            ConfigurablePropDefinition definition = getDefinition();
            if (definition != null)
            {
                setPlacementOffset(definition.getDefaultPlacementOffset());
            }
        }
        else
        {
            dir = toLegacyQuarterTurns(getRotation());
        }
    }

    /** Writes both rotation formats so legacy consumers retain the migrated facing. */
    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setInteger("direction", toLegacyQuarterTurns(getRotation()));
    }

    /** Keeps the compatibility-facing field aligned with stored angle changes. */
    @Override
    public void setRotation(RotationAmount rotation)
    {
        super.setRotation(rotation);
        dir = toLegacyQuarterTurns(getRotation());
    }

    /**
     * Distinguishes current facing-relative offset data from the short-lived
     * world-axis format so old saves can be converted exactly once.
     */
    private boolean hasFacingRelativePlacementOffset(NBTTagCompound tag)
    {
        if (tag == null || tag.hasKey("PlacementOffset") == false)
        {
            return false;
        }
        NBTTagCompound offset = tag.getCompoundTag("PlacementOffset");
        return offset.hasKey("Right")
                && offset.hasKey("Up")
                && offset.hasKey("Forward");
    }

    /** Initializes shared appearance and rotation from historical tile fields. */
    private void applyLegacyDefaults(int direction)
    {
        setDefinitionId(legacyDefinitionId);
        ConfigurablePropDefinition definition = getDefinition();
        if (definition != null)
        {
            setPlacementOffset(definition.getDefaultPlacementOffset());
        }
        setRotation(RotationAmount.fromLegacyQuarterTurns(direction));
        applyAppearance(
                null,
                AppearanceData.defaultAppearance().withTrait(
                        AppearanceData.TRAIT_SKIN,
                        legacySkinId
                )
        );
    }

    /** Converts a stored facing angle to the nearest legacy quarter turn. */
    private int toLegacyQuarterTurns(RotationAmount rotation)
    {
        int roundedQuarterTurn = Math.round(rotation.toDegrees() / 90.0F);
        int normalizedQuarterTurn = roundedQuarterTurn % 4;
        return normalizedQuarterTurn < 0
                ? normalizedQuarterTurn + 4
                : normalizedQuarterTurn;
    }
}
