package com.bidahochi.BlockMod.blocks.props.configurable.definition;

import com.bidahochi.BlockMod.blocks.props.configurable.data.PropPlacementOffset;
import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import com.bidahochi.BlockMod.common.rotation.RotationSnap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Required data plus optional tuning knobs for one configurable prop type.
 *
 * Keep required gameplay identity, behavior, rotation support, inventory size,
 * and multiblock dimensions in the constructor. Chainable configuration methods
 * add optional rendering, placement, interaction, collision, and inventory data.
 * Registration freezes the completed definition so cached block and tile
 * properties cannot later diverge from registry validation. Every chainable
 * configuration method throws {@link IllegalStateException} after registration
 * freezes the definition.
 */
public final class ConfigurablePropDefinition
{

    /** Maximum slots addressable by the supported six-row storage layouts. */
    private static final int MAX_STORAGE_SLOTS = 54;

    /** Internal binding key used when one color property applies to every render target. */
    private static final String WHOLE_MODEL_COLOR_TARGET = "";

    private final String id;
    private final String customizationProfileId;
    private final String defaultSkinId;
    private final String inventoryName;
    private final String modelId;
    private final String interactionId;
    private final RotationSnap rotationSnap;
    private final int inventorySize;
    private final int width;
    private final int height;
    private final int depth;
    private final List<ConfigurablePropCompartment> compartments =
            new ArrayList<ConfigurablePropCompartment>();
    private final List<ConfigurablePropSeat> seats =
            new ArrayList<ConfigurablePropSeat>();
    /** Optional normalized render-target-to-color-property bindings. */
    private final Map<String, String> colorTraitIdsByRenderTarget =
            new LinkedHashMap<String, String>();
    private ConfigurablePropBlockProperties blockProperties =
            ConfigurablePropBlockProperties.wood();
    private double modelOffsetX = 0.5D;
    private double modelOffsetY = 0.5D;
    private double modelOffsetZ = 0.5D;
    private PropPlacementOffset defaultPlacementOffset = PropPlacementOffset.zero();
    private int placementOffsetRangeHundredths = PropPlacementOffset.MAX_HUNDREDTHS;
    private float guiPreviewScale = 1.0F;
    private float modelYawOffset;
    private float guiPreviewYawOffset;
    private float placementYawOffsetDegrees;
    private boolean modelFlipEnabled;
    private ModelFlipAxis modelFlipAxis = ModelFlipAxis.X;
    private int renderBoundsHorizontalRadius = -1;
    private int renderBoundsHeightBlocks = -1;
    private boolean entityCollisionEnabled = true;
    private boolean autoHeightAdjustmentEnabled;
    private boolean manualPlacementRotationEnabled;
    private double autoHeightSlabOffset = 0.5D;
    private double autoHeightRoadCoverRailOffset = 0.95D;
    private ConfigurablePropLightDefinition lightDefinition;
    private ConfigurablePropControllerType controllerType = ConfigurablePropControllerType.BASIC;
    private boolean registrationFrozen;

    /**
     * Creates the required definition data shared by item, block, tile, renderer,
     * interaction, and add-on registration code.
     *
     * @param id stable namespaced definition ID persisted by controller tiles
     * @param customizationProfileId registered profile controlling valid appearance traits
     * @param defaultSkinId registered skin used when appearance data is absent
     * @param inventoryName localization key for a non-compartment inventory title
     * @param modelId client model registry ID
     * @param interactionId registered behavior ID, or an empty string for no interaction
     * @param rotationSnap placement snapping policy; saved rotations are not re-snapped
     * @param inventorySize flat inventory slots from 0 through 54, or zero when
     *        compartments supply storage
     * @param width unrotated structure width along local X, in block cells
     * @param height structure height along local Y, in block cells
     * @param depth unrotated structure depth along local Z, in block cells
     * @throws IllegalArgumentException when identity, dimensions, inventory size, or rotation are invalid
     */
    public ConfigurablePropDefinition(
            String id,
            String customizationProfileId,
            String defaultSkinId,
            String inventoryName,
            String modelId,
            String interactionId,
            RotationSnap rotationSnap,
            int inventorySize,
            int width,
            int height,
            int depth
    )
    {
        if (inventorySize < 0 || inventorySize > MAX_STORAGE_SLOTS)
        {
            throw new IllegalArgumentException(
                    "Flat configurable prop inventory size must be 0 through 54."
            );
        }
        if (width < 1 || height < 1 || depth < 1)
        {
            throw new IllegalArgumentException("Configurable prop dimensions must be at least one block.");
        }
        this.id = requireId(id, "definition");
        this.customizationProfileId = requireId(customizationProfileId, "customization profile");
        this.defaultSkinId = requireId(defaultSkinId, "default skin");
        this.inventoryName = inventoryName != null ? inventoryName : "";
        this.modelId = requireId(modelId, "model");
        this.interactionId = interactionId != null
                ? interactionId.trim().toLowerCase(Locale.ROOT)
                : "";
        if (rotationSnap == null)
        {
            throw new IllegalArgumentException("Configurable prop rotation snap cannot be null.");
        }
        if ((width > 1 || depth > 1) && rotationSnap.isCardinalCompatible() == false)
        {
            throw new IllegalArgumentException(
                    "Horizontal multiblock props require cardinal rotation: " + id
            );
        }
        this.rotationSnap = rotationSnap;
        this.inventorySize = inventorySize;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    /**
     * Corrects the model's untouched origin before any player placement offset,
     * using the same block-space values a model author would pass to
     * GL11.glTranslated(x + offsetX, y + offsetY, z + offsetZ). Keep this as
     * double precision; these values are artist-tuned, not player UI units.
     *
     * @param offsetX model-origin X translation in blocks
     * @param offsetY model-origin Y translation in blocks
     * @param offsetZ model-origin Z translation in blocks
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withModelOffset(
            double offsetX,
            double offsetY,
            double offsetZ
    )
    {
        requireMutable();
        modelOffsetX = offsetX;
        modelOffsetY = offsetY;
        modelOffsetZ = offsetZ;
        return this;
    }

    /**
     * Sets the player-adjustable facing-relative placement offset used when no
     * item/save offset exists yet. Values are stored as hundredths of a block:
     * right, up, and forward.
     *
     * @param placementOffset normalized default, or {@code null} for zero
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withDefaultPlacementOffset(
            PropPlacementOffset placementOffset
    )
    {
        requireMutable();
        defaultPlacementOffset = placementOffset != null
                ? placementOffset
                : PropPlacementOffset.zero();
        return this;
    }

    /**
     * Sets the maximum facing-relative player offset per axis in blocks, capped
     * by the global sub-block limit of 0.99 blocks.
     *
     * @param blocks non-negative per-axis range in blocks; the absolute value is used
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withPlacementOffsetRange(double blocks)
    {
        requireMutable();
        placementOffsetRangeHundredths = Math.max(
                0,
                Math.min(
                        PropPlacementOffset.MAX_HUNDREDTHS,
                        (int) Math.round(Math.abs(blocks) * 100.0D)
                )
        );
        defaultPlacementOffset = defaultPlacementOffset.clampedToRange(
                placementOffsetRangeHundredths
        );
        return this;
    }

    /**
     * Sets fixed block-level behavior for this registered prop block. These
     * properties are not appearance traits or tile data; they are applied once
     * when the controller block is constructed.
     *
     * @param value immutable block properties, or {@code null} for wood defaults
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withBlockProperties(
            ConfigurablePropBlockProperties value
    )
    {
        requireMutable();
        blockProperties = value != null ? value : ConfigurablePropBlockProperties.wood();
        return this;
    }

    /**
     * Changes only the item customization preview size. World rendering,
     * collision, selection, and placement stay unchanged.
     *
     * @param scale positive preview scale; non-positive values restore 1.0
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withGuiPreviewScale(float scale)
    {
        requireMutable();
        guiPreviewScale = scale > 0.0F ? scale : 1.0F;
        return this;
    }

    /**
     * Corrects a model authored facing the wrong base direction. This applies to
     * both placed rendering and the GUI preview because both use the shared model
     * render helper.
     *
     * @param degrees signed model-space yaw correction in degrees
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withModelYawOffset(float degrees)
    {
        requireMutable();
        modelYawOffset = degrees;
        return this;
    }

    /**
     * Adjusts only the GUI preview starting face before the shared preview display
     * angle is applied. Use this when the placed model is already correct.
     *
     * @param degrees signed GUI-only yaw adjustment in degrees
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withGuiPreviewYawOffset(float degrees)
    {
        requireMutable();
        guiPreviewYawOffset = degrees;
        return this;
    }

    /**
     * Offsets only newly placed prop rotation. Use this when legacy-loaded tiles
     * already face correctly but direct item placement has a different baseline.
     *
     * @param degrees signed placement adjustment in degrees
     * @return this definition for chained configuration
     * @throws IllegalArgumentException when a horizontal multiblock adjustment is not cardinal
     */
    public ConfigurablePropDefinition withPlacementYawOffset(float degrees)
    {
        requireMutable();
        if (hasHorizontalFootprint()
                && RotationAmount.fromDegrees(degrees).isCardinal() == false)
        {
            throw new IllegalArgumentException(
                    "Horizontal multiblock placement yaw offsets must be cardinal: " + id
            );
        }
        placementYawOffsetDegrees = degrees;
        return this;
    }

    /**
     * Allows item customization to mirror the model left-to-right. This is for
     * alternate handedness, such as a prop whose details should be able to swap
     * from one side to the other without needing a second model class.
     *
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withModelFlipEnabled()
    {
        requireMutable();
        modelFlipEnabled = true;
        return this;
    }

    /**
     * Chooses the local horizontal axis used by the model flip. Use Z when a
     * local-X mirror turns the model around instead of only swapping handedness.
     *
     * @param axis local mirror axis, or {@code null} for X
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withModelFlipAxis(ModelFlipAxis axis)
    {
        requireMutable();
        modelFlipAxis = axis != null ? axis : ModelFlipAxis.X;
        return this;
    }

    /**
     * Exposes automatic-versus-manual placement rotation in the item
     * customization GUI. Manual values are stored as exact rotation amounts;
     * horizontal multiblock footprints are normalized to a cardinal angle.
     *
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withManualPlacementRotation()
    {
        requireMutable();
        manualPlacementRotationEnabled = true;
        return this;
    }

    /**
     * Normalizes an untrusted manual placement angle for this footprint.
     * Horizontal multiblocks remain cardinal because their occupied cells do
     * not support arbitrary-angle rotation.
     *
     * @param requested requested angle, or {@code null} for zero degrees
     * @return normalized angle safe for this definition's structure
     */
    public RotationAmount normalizeManualPlacementRotation(RotationAmount requested)
    {
        RotationAmount normalized = requested != null
                ? requested
                : RotationAmount.fromAngleUnits(0);
        if ((width > 1 || depth > 1) && normalized.isCardinal() == false)
        {
            return RotationAmount.fromYaw(normalized.toDegrees(), RotationSnap.FOUR);
        }
        return normalized;
    }

    /**
     * Selects the tile capability used for newly placed instances of this prop.
     * An inventory-capable type must be selected for flat or compartment
     * inventory, while processor is reserved for machines with an update lifecycle.
     *
     * @param value required controller capability, or {@code null} for basic
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withControllerType(ConfigurablePropControllerType value)
    {
        requireMutable();
        controllerType = value != null ? value : ConfigurablePropControllerType.BASIC;
        return this;
    }

    /**
     * Colors the complete model from the named appearance trait. Definitions
     * without this optional binding always render their authored texture colors.
     *
     * @param colorTraitId registered color-trait ID whose value is an RGB integer
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withModelColorTrait(String colorTraitId)
    {
        requireMutable();
        colorTraitIdsByRenderTarget.put(
                WHOLE_MODEL_COLOR_TARGET,
                requireId(colorTraitId, "model color trait")
        );
        return this;
    }

    /**
     * Colors only one named model group from the named appearance trait. An
     * exact group binding takes precedence over a complete-model binding.
     *
     * @param groupId stable group ID exposed by {@code IConfigurablePropGroupedModel}
     * @param colorTraitId registered color-trait ID whose value is an RGB integer
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withGroupColorTrait(
            String groupId,
            String colorTraitId
    )
    {
        requireMutable();
        colorTraitIdsByRenderTarget.put(
                requireId(groupId, "model group"),
                requireId(colorTraitId, "model group color trait")
        );
        return this;
    }

    /**
     * Expands the client render bounding box for large visual props whose model
     * extends past their controller block.
     *
     * @param horizontalRadius horizontal radius around the controller, in blocks
     * @param heightBlocks vertical render extent above the controller, in blocks
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withRenderBounds(
            int horizontalRadius,
            int heightBlocks
    )
    {
        requireMutable();
        renderBoundsHorizontalRadius = Math.max(1, horizontalRadius);
        renderBoundsHeightBlocks = Math.max(1, heightBlocks);
        return this;
    }

    /**
     * Controls entity collision boxes. Selection and ray tracing still use the
     * controller bounds so decorative props remain removable.
     *
     * @param enabled whether entities collide with controller and part cells
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withEntityCollision(boolean enabled)
    {
        requireMutable();
        entityCollisionEnabled = enabled;
        return this;
    }

    /**
     * Enables the item GUI height-mode toggle. Auto mode lifts this prop when
     * placed on thinner support blocks such as slabs, road covers, and rails.
     *
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withAutoHeightAdjustment()
    {
        requireMutable();
        return withAutoHeightAdjustment(0.5D, 0.95D);
    }

    /**
     * Enables auto height adjustment with custom lift values for prop types
     * whose model needs different support-block compensation.
     *
     * @param slabOffset vertical lift in blocks for slabs and thin multipart supports
     * @param roadCoverRailOffset vertical lift in blocks for road covers and rails
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withAutoHeightAdjustment(
            double slabOffset,
            double roadCoverRailOffset
    )
    {
        requireMutable();
        autoHeightAdjustmentEnabled = true;
        autoHeightSlabOffset = slabOffset;
        autoHeightRoadCoverRailOffset = roadCoverRailOffset;
        return this;
    }

    /**
     * Adds block-light emission and validates every emitter against this prop's
     * occupied local structure cells. Runtime lit state remains controller-owned.
     *
     * @param light immutable light capability; must not be {@code null}
     * @return this definition for chained configuration
     * @throws IllegalArgumentException when the capability is absent or an emitter is outside the structure
     */
    public ConfigurablePropDefinition withLight(ConfigurablePropLightDefinition light)
    {
        requireMutable();
        if (light == null)
        {
            throw new IllegalArgumentException(
                    "Configurable prop light definition cannot be null: " + id
            );
        }
        for (ConfigurablePropLightDefinition.EmitterCell emitter : light.getEmitterCells())
        {
            if (emitter.getLocalX() < 0 || emitter.getLocalX() >= width
                    || emitter.getLocalY() < 0 || emitter.getLocalY() >= height
                    || emitter.getLocalZ() < 0 || emitter.getLocalZ() >= depth)
            {
                throw new IllegalArgumentException(
                        "Configurable prop light emitter is outside the structure: " + id
                );
            }
        }
        lightDefinition = light;
        return this;
    }

    /**
     * Assigns a separately opened inventory to one local structure cell. When
     * at least one compartment is declared, compartment sizes replace the
     * constructor's flat-inventory size.
     *
     * @param id stable compartment ID used for persistence and lookup
     * @param compartmentInventoryName localization key for this compartment's GUI title
     * @param size number of slots from 1 through 54
     * @param localX unrotated structure-cell X coordinate
     * @param localY structure-cell Y coordinate
     * @param localZ unrotated structure-cell Z coordinate
     * @return this definition for chained configuration
     * @throws IllegalArgumentException when the ID, size, cell, or cell ownership is invalid
     */
    public ConfigurablePropDefinition withCompartment(
            String id,
            String compartmentInventoryName,
            int size,
            int localX,
            int localY,
            int localZ
    )
    {
        requireMutable();
        String normalizedId = id != null ? id.trim().toLowerCase(Locale.ROOT) : "";
        if (normalizedId.length() == 0)
        {
            throw new IllegalArgumentException("Configurable prop compartment ID cannot be empty.");
        }
        if (size < 1 || size > MAX_STORAGE_SLOTS)
        {
            throw new IllegalArgumentException("Configurable prop compartment size must be 1 through 54.");
        }
        if (localX < 0 || localX >= width
                || localY < 0 || localY >= height
                || localZ < 0 || localZ >= depth)
        {
            throw new IllegalArgumentException("Configurable prop compartment cell is outside the structure.");
        }
        for (ConfigurablePropCompartment compartment : compartments)
        {
            if (compartment.getId().equals(normalizedId))
            {
                throw new IllegalArgumentException("Duplicate configurable prop compartment ID: " + normalizedId);
            }
            if (compartment.occupiesRelativeOffset(
                    localX,
                    localY,
                    localZ,
                    RotationAmount.fromAngleUnits(0)
            ))
            {
                throw new IllegalArgumentException("A configurable prop compartment already uses that cell.");
            }
        }
        int startSlot = 0;
        for (ConfigurablePropCompartment compartment : compartments)
        {
            startSlot += compartment.getSize();
        }
        compartments.add(new ConfigurablePropCompartment(
                normalizedId,
                compartmentInventoryName,
                size,
                startSlot,
                localX,
                localY,
                localZ
        ));
        return this;
    }

    /**
     * Adds a named sitting position in controller-local block coordinates.
     * A couch can, for example, declare seat_left and seat_right independently.
     *
     * @param id stable seat ID used to distinguish multiple riders
     * @param localX local X offset from the controller, in blocks
     * @param localY local Y offset from the controller, in blocks
     * @param localZ local Z offset from the controller, in blocks
     * @return this definition for chained configuration
     */
    public ConfigurablePropDefinition withSeat(
            String id,
            double localX,
            double localY,
            double localZ
    )
    {
        requireMutable();
        return withSeat(id, localX, localY, localZ, 0.0F);
    }

    /**
     * Adds a named sitting position with an additional model-local yaw offset.
     *
     * @param id stable seat ID used to distinguish multiple riders
     * @param localX local X offset from the controller, in blocks
     * @param localY local Y offset from the controller, in blocks
     * @param localZ local Z offset from the controller, in blocks
     * @param yawOffset rider-facing adjustment after prop rotation, in degrees
     * @return this definition for chained configuration
     * @throws IllegalArgumentException when the ID is duplicate/blank or a numeric value is not finite
     */
    public ConfigurablePropDefinition withSeat(
            String id,
            double localX,
            double localY,
            double localZ,
            float yawOffset
    )
    {
        requireMutable();
        String normalizedId = id != null ? id.trim().toLowerCase(Locale.ROOT) : "";
        if (normalizedId.length() == 0)
        {
            throw new IllegalArgumentException("Configurable prop seat ID cannot be empty.");
        }
        if (Double.isNaN(localX) || Double.isInfinite(localX)
                || Double.isNaN(localY) || Double.isInfinite(localY)
                || Double.isNaN(localZ) || Double.isInfinite(localZ)
                || Float.isNaN(yawOffset) || Float.isInfinite(yawOffset))
        {
            throw new IllegalArgumentException("Configurable prop seat values must be finite.");
        }
        for (ConfigurablePropSeat seat : seats)
        {
            if (seat.getId().equals(normalizedId))
            {
                throw new IllegalArgumentException("Duplicate configurable prop seat ID: " + normalizedId);
            }
        }
        seats.add(new ConfigurablePropSeat(
                normalizedId,
                localX,
                localY,
                localZ,
                yawOffset
        ));
        return this;
    }

    /**
     * Returns the stable configurable-prop definition ID.
     *
     * @return normalized registry and persistence identifier
     */
    public String getId()
    {
        return id;
    }

    /**
     * Returns the profile used to validate appearance traits.
     *
     * @return registered customization profile identifier
     */
    public String getCustomizationProfileId()
    {
        return customizationProfileId;
    }

    /**
     * Returns the skin used when stored appearance has no valid selection.
     *
     * @return registered fallback skin identifier
     */
    public String getDefaultSkinId()
    {
        return defaultSkinId;
    }

    /**
     * Returns the localization key for the combined inventory title.
     *
     * @return inventory localization key
     */
    public String getInventoryName()
    {
        return inventoryName;
    }

    /**
     * Returns the client registry ID of the prop's primary model.
     *
     * @return registered client model identifier
     */
    public String getModelId()
    {
        return modelId;
    }

    /**
     * Returns the interaction registry ID.
     *
     * @return registered behavior identifier, or an empty string for decorative props
     */
    public String getInteractionId()
    {
        return interactionId;
    }

    /**
     * Returns the persistent tile capability selected for this prop.
     *
     * @return non-null controller type used by the owning block's tile factory
     */
    public ConfigurablePropControllerType getControllerType()
    {
        return controllerType;
    }

    /**
     * Returns the placement-yaw snapping policy.
     *
     * @return non-null rotation snap policy
     */
    public RotationSnap getRotationSnap()
    {
        return rotationSnap;
    }

    /**
     * Returns the combined compartment capacity, or the flat inventory size.
     *
     * @return total controller slot count
     */
    public int getInventorySize()
    {
        if (compartments.isEmpty())
        {
            return inventorySize;
        }
        int size = 0;
        for (ConfigurablePropCompartment compartment : compartments)
        {
            size += compartment.getSize();
        }
        return size;
    }

    /**
     * Returns an unmodifiable view of compartments in their stable slot order.
     *
     * @return unmodifiable ordered compartment list
     */
    public List<ConfigurablePropCompartment> getCompartments()
    {
        return Collections.unmodifiableList(compartments);
    }

    /**
     * Returns an unmodifiable view of authored seat anchors.
     *
     * @return unmodifiable ordered seat list
     */
    public List<ConfigurablePropSeat> getSeats()
    {
        return Collections.unmodifiableList(seats);
    }

    /**
     * Tests whether at least one independently addressable seat is declared.
     *
     * @return {@code true} when the seat list is not empty
     */
    public boolean hasSeats()
    {
        return seats.isEmpty() == false;
    }

    /**
     * Returns a compartment by its stable normalized ID.
     *
     * @param id lower-case compartment ID, or {@code null}
     * @return matching compartment, or {@code null} when not declared
     */
    public ConfigurablePropCompartment getCompartment(String id)
    {
        if (id == null)
        {
            return null;
        }
        for (ConfigurablePropCompartment compartment : compartments)
        {
            if (compartment.getId().equals(id))
            {
                return compartment;
            }
        }
        return null;
    }

    /**
     * Resolves the compartment addressed by a clicked placed-structure cell.
     *
     * @param relativeX world-X cell offset from the controller
     * @param relativeY world-Y cell offset from the controller
     * @param relativeZ world-Z cell offset from the controller
     * @param rotation placed prop rotation
     * @return occupying compartment, or {@code null} when the cell has no compartment
     */
    public ConfigurablePropCompartment getCompartmentAtRelativeOffset(
            int relativeX,
            int relativeY,
            int relativeZ,
            RotationAmount rotation
    )
    {
        for (ConfigurablePropCompartment compartment : compartments)
        {
            if (compartment.occupiesRelativeOffset(
                    relativeX,
                    relativeY,
                    relativeZ,
                    rotation
            ))
            {
                return compartment;
            }
        }
        return null;
    }

    /**
     * Tests whether this definition divides storage into named compartments.
     *
     * @return {@code true} when at least one compartment is declared
     */
    public boolean hasCompartments()
    {
        return compartments.isEmpty() == false;
    }

    /**
     * Returns the unrotated structure width.
     *
     * @return positive local-X cell count in blocks
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Returns the structure height.
     *
     * @return positive local-Y cell count in blocks
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Returns the unrotated structure depth.
     *
     * @return positive local-Z cell count in blocks
     */
    public int getDepth()
    {
        return depth;
    }

    /**
     * Returns the physical properties applied to the controller block.
     *
     * @return immutable block property set
     */
    public ConfigurablePropBlockProperties getBlockProperties()
    {
        return blockProperties;
    }

    /**
     * Returns the optional block-light capability.
     *
     * @return immutable light definition, or {@code null} when absent
     */
    public ConfigurablePropLightDefinition getLightDefinition()
    {
        return lightDefinition;
    }

    /**
     * Tests whether this prop declares at least one block-light emitter.
     *
     * @return {@code true} when a light definition is present
     */
    public boolean hasLight()
    {
        return lightDefinition != null;
    }

    /**
     * Returns the fixed model-origin X translation.
     *
     * @return signed X translation in blocks
     */
    public double getModelOffsetX()
    {
        return modelOffsetX;
    }

    /**
     * Returns the fixed model-origin Y translation.
     *
     * @return signed Y translation in blocks
     */
    public double getModelOffsetY()
    {
        return modelOffsetY;
    }

    /**
     * Returns the fixed model-origin Z translation.
     *
     * @return signed Z translation in blocks
     */
    public double getModelOffsetZ()
    {
        return modelOffsetZ;
    }

    /**
     * Returns the definition default clamped to the permitted local-axis range.
     *
     * @return normalized immutable default placement offset
     */
    public PropPlacementOffset getDefaultPlacementOffset()
    {
        return defaultPlacementOffset.clampedToRange(placementOffsetRangeHundredths);
    }

    /**
     * Limits a requested placement translation to this definition and the
     * global sub-block constraints.
     *
     * @param placementOffset requested offset, or {@code null} for zero
     * @return normalized permitted offset
     */
    public PropPlacementOffset clampPlacementOffset(PropPlacementOffset placementOffset)
    {
        return (placementOffset != null
                ? placementOffset
                : PropPlacementOffset.zero()).clampedToRange(
                placementOffsetRangeHundredths
        );
    }

    /**
     * Returns the multiplicative model scale used by the customization preview.
     *
     * @return positive GUI preview scale
     */
    public float getGuiPreviewScale()
    {
        return guiPreviewScale;
    }

    /**
     * Returns the fixed model yaw correction.
     *
     * @return signed model correction in degrees
     */
    public float getModelYawOffset()
    {
        return modelYawOffset;
    }

    /**
     * Returns the additional preview-only yaw correction.
     *
     * @return signed preview correction in degrees
     */
    public float getGuiPreviewYawOffset()
    {
        return guiPreviewYawOffset;
    }

    /**
     * Returns the additional new-placement yaw.
     *
     * @return signed placement correction in degrees
     */
    public float getPlacementYawOffsetDegrees()
    {
        return placementYawOffsetDegrees;
    }

    /**
     * Tests whether item customization exposes a manual degree override.
     *
     * @return {@code true} when players may select a placement angle manually
     */
    public boolean isManualPlacementRotationEnabled()
    {
        return manualPlacementRotationEnabled;
    }

    /**
     * Tests whether item customization may mirror the model.
     *
     * @return {@code true} when the flip control is enabled
     */
    public boolean isModelFlipEnabled()
    {
        return modelFlipEnabled;
    }

    /**
     * Returns the local horizontal axis used when mirroring the model.
     *
     * @return non-null authored flip axis
     */
    public ModelFlipAxis getModelFlipAxis()
    {
        return modelFlipAxis;
    }

    /**
     * Returns the color trait bound to a render group, falls back to the optional
     * complete-model binding, or returns {@code null} when that target is not colored.
     *
     * @param groupId stable model group ID, or {@code null} for the complete model
     * @return bound color-trait ID, or {@code null} when no color property is configured
     */
    public String getColorTraitId(String groupId)
    {
        String normalizedGroupId = groupId != null
                ? groupId.trim().toLowerCase(Locale.ROOT)
                : WHOLE_MODEL_COLOR_TARGET;
        String colorTraitId = colorTraitIdsByRenderTarget.get(normalizedGroupId);
        return colorTraitId != null
                ? colorTraitId
                : colorTraitIdsByRenderTarget.get(WHOLE_MODEL_COLOR_TARGET);
    }

    /**
     * Returns an unmodifiable view of render-target-to-color-trait bindings.
     *
     * @return unmodifiable target ID to trait ID map
     */
    public Map<String, String> getColorTraitBindings()
    {
        return Collections.unmodifiableMap(colorTraitIdsByRenderTarget);
    }

    /**
     * Returns the tile render radius in horizontal blocks, including fallback sizing.
     *
     * @return positive horizontal render radius in blocks
     */
    public int getRenderBoundsHorizontalRadius()
    {
        return renderBoundsHorizontalRadius > 0
                ? renderBoundsHorizontalRadius
                : Math.max(width, depth);
    }

    /**
     * Returns the tile render height in blocks, including fallback sizing.
     *
     * @return positive vertical render extent in blocks
     */
    public int getRenderBoundsHeightBlocks()
    {
        return renderBoundsHeightBlocks > 0 ? renderBoundsHeightBlocks : height;
    }

    /**
     * Tests whether entities collide with the prop's occupancy bounds.
     *
     * @return {@code true} when entity collision is enabled
     */
    public boolean isEntityCollisionEnabled()
    {
        return entityCollisionEnabled;
    }

    /**
     * Tests whether placement height may adjust for supported surfaces.
     *
     * @return {@code true} when automatic support compensation is enabled
     */
    public boolean isAutoHeightAdjustmentEnabled()
    {
        return autoHeightAdjustmentEnabled;
    }

    /**
     * Returns the automatic vertical lift for slab-like supports.
     *
     * @return signed vertical adjustment in blocks
     */
    public double getAutoHeightSlabOffset()
    {
        return autoHeightSlabOffset;
    }

    /**
     * Returns the automatic vertical lift for road covers and rails.
     *
     * @return signed vertical adjustment in blocks
     */
    public double getAutoHeightRoadCoverRailOffset()
    {
        return autoHeightRoadCoverRailOffset;
    }

    /** Local model axis mirrored by the optional appearance flip control. */
    public enum ModelFlipAxis
    {
        /** Mirrors local X coordinates. */
        X,
        /** Mirrors local Z coordinates. */
        Z
    }

    /**
     * Tests whether the prop occupies more than its controller block.
     *
     * @return {@code true} when any structure dimension exceeds one cell
     */
    public boolean isMultiblock()
    {
        return width > 1 || height > 1 || depth > 1;
    }

    /** Returns whether structure cells extend along either horizontal axis. */
    private boolean hasHorizontalFootprint()
    {
        return width > 1 || depth > 1;
    }

    /** Prevents builder-style mutation after registry validation has completed. */
    private void requireMutable()
    {
        if (registrationFrozen)
        {
            throw new IllegalStateException(
                    "Registered configurable prop definitions cannot be modified: " + id
            );
        }
    }

    /**
     * Freezes this definition after registry validation. Package visibility keeps
     * lifecycle control inside the definition registry.
     */
    void freezeForRegistration()
    {
        registrationFrozen = true;
    }

    /**
     * Normalizes a stable registry-facing identifier and rejects incomplete
     * definitions before they can enter block, model, or persistence registries.
     */
    private static String requireId(String value, String role)
    {
        if (value == null || value.trim().length() == 0)
        {
            throw new IllegalArgumentException("Configurable prop " + role + " ID cannot be empty.");
        }
        return value.trim().toLowerCase(Locale.ROOT);
    }
}
