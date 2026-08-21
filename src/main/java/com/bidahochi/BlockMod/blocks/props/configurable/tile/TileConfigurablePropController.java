package com.bidahochi.BlockMod.blocks.props.configurable.tile;

import com.bidahochi.BlockMod.blocks.props.configurable.ConfigurablePropSystem;
import com.bidahochi.BlockMod.blocks.props.configurable.data.ConfigurablePropHeightMode;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropLightDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropRegistry;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropStructure;
import com.bidahochi.BlockMod.blocks.props.configurable.data.PropPlacementOffset;
import com.bidahochi.BlockMod.blocks.props.configurable.height.ConfigurablePropHeightHelper;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteractionRegistry;
import com.bidahochi.BlockMod.blocks.props.configurable.lighting.ConfigurablePropLightRelightHelper;
import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import com.bidahochi.BlockMod.customization.data.AppearanceData;
import com.bidahochi.BlockMod.customization.registry.CustomizationProfile;
import com.bidahochi.BlockMod.customization.registry.CustomizationRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Owns persistent state shared by every placed prop, including appearance,
 * structure, rotation, placement offset, lighting, and interaction behavior data.
 * Storage and processing responsibilities belong to focused subclasses.
 */
public class TileConfigurablePropController extends TileEntity
{

    /** Persistent behavior key for a stateful fixture's current lit state. */
    private static final String LIGHT_LIT_KEY = "LightLit";

    private String definitionId = "";
    private AppearanceData appearance = AppearanceData.defaultAppearance();
    private RotationAmount rotation = RotationAmount.fromAngleUnits(0);
    private boolean manualPlacementRotation;
    private PropPlacementOffset placementOffset = PropPlacementOffset.zero();
    private ConfigurablePropHeightMode heightMode = ConfigurablePropHeightMode.MANUAL;
    private boolean modelFlipped;
    private NBTTagCompound behaviorData = new NBTTagCompound();
    private boolean destroying;

    /**
     * Creates an unconfigured controller for Minecraft's reflective tile loading.
     * Saved NBT supplies the definition before gameplay resumes.
     */
    public TileConfigurablePropController()
    {
    }

    /**
     * Creates a newly placed controller with its behavior definition available
     * before Minecraft decides whether the tile belongs in the update list.
     *
     * @param initialDefinitionId stable definition identifier assigned by the block
     */
    public TileConfigurablePropController(String initialDefinitionId)
    {
        definitionId = initialDefinitionId != null ? initialDefinitionId : "";
    }

    /**
     * Returns the controller's current validated appearance snapshot.
     *
     * @return immutable appearance data used for rendering and synchronization
     */
    public AppearanceData getAppearance()
    {
        return appearance;
    }

    /**
     * Returns the registry ID of the definition represented by this controller.
     *
     * @return stable definition identifier, or an empty string when unconfigured
     */
    public String getDefinitionId()
    {
        return definitionId;
    }

    /**
     * Resolves the current definition.
     *
     * @return registered definition, or {@code null} when its ID is unknown
     */
    public ConfigurablePropDefinition getDefinition()
    {
        return ConfigurablePropRegistry.getDefinition(definitionId);
    }

    /**
     * Rebinds this tile to a definition, notifying specialized subclasses and
     * applying definition-controlled appearance and height defaults. A storage
     * subclass may resize its slots, so callers should only rebind an empty or
     * newly created controller.
     *
     * @param definitionId stable registered definition identifier, or null to clear it
     */
    public void setDefinitionId(String definitionId)
    {
        ConfigurablePropDefinition previousDefinition = getDefinition();
        if (previousDefinition != null)
        {
            rotation = previousDefinition.normalizeManualPlacementRotation(rotation);
        }
        List<int[]> previousEmitterOffsets = getLightEmitterOffsets(rotation);
        this.definitionId = definitionId != null ? definitionId : "";
        ConfigurablePropDefinition definition = getDefinition();
        if (definition != null)
        {
            rotation = definition.normalizeManualPlacementRotation(rotation);
        }
        onDefinitionChanged(definition);
        if (definition != null
                && (appearance == null
                || AppearanceData.DEFAULT_SKIN_ID.equals(appearance.getSkinId())))
        {
            appearance = ConfigurablePropSystem.getDefaultAppearance(definitionId);
        }
        if (definition != null && definition.isAutoHeightAdjustmentEnabled())
        {
            heightMode = ConfigurablePropHeightMode.AUTO;
        }
        else
        {
            heightMode = ConfigurablePropHeightMode.MANUAL;
        }
        sync();
        refreshLightEmission(previousEmitterOffsets);
        refreshLightEmission();
    }

    /**
     * Resolves the customization schema assigned by the current prop definition.
     *
     * @return registered customization profile, or {@code null} when the
     *         controller has no known definition or profile
     */
    public CustomizationProfile getCustomizationProfile()
    {
        ConfigurablePropDefinition definition = getDefinition();
        return definition != null
                ? CustomizationRegistry.getProfile(definition.getCustomizationProfileId())
                : null;
    }

    /**
     * Checks whether a player is close enough to use this controller and whether
     * the controller still occupies its expected world position.
     *
     * @param player player requesting customization access
     * @return {@code true} when the controller is currently usable by the player
     */
    public boolean canPlayerCustomize(EntityPlayer player)
    {
        return isUseableByPlayer(player);
    }

    /**
     * Validates untrusted appearance data against the active definition and
     * profile, applies the validated result, and synchronizes it to clients.
     * Player-originated callers must first authorize {@code player} with
     * {@link #canPlayerCustomize(EntityPlayer)}; trusted placement and migration
     * code may pass {@code null} while restoring already-owned appearance data.
     *
     * @param player player submitting the request, or {@code null} for trusted
     *        internal restoration
     * @param requested untrusted appearance data supplied by the caller
     */
    public void applyAppearance(EntityPlayer player, AppearanceData requested)
    {
        ConfigurablePropDefinition definition = getDefinition();
        if (definition != null)
        {
            appearance = validateAppearance(definition, requested);
            sync();
        }
    }

    /**
     * Returns the prop's normalized horizontal rotation.
     *
     * @return horizontal rotation amount represented in normalized degrees
     */
    public RotationAmount getRotation()
    {
        return rotation;
    }

    /**
     * Records whether the placed item selected its stored angle manually. This
     * flag is retained only so a broken prop can recreate the same item setting.
     *
     * @param manualPlacementRotation whether the source item used manual rotation
     */
    public void setManualPlacementRotation(boolean manualPlacementRotation)
    {
        this.manualPlacementRotation = manualPlacementRotation;
        markDirty();
    }

    /**
     * Replaces the prop's horizontal rotation and synchronizes the change. For a
     * light-emitting prop, the old and new emitter cells are relit immediately.
     *
     * @param rotation horizontal rotation to apply, or {@code null} for zero rotation
     */
    public void setRotation(RotationAmount rotation)
    {
        ConfigurablePropDefinition definition = getDefinition();
        RotationAmount normalizedRotation = definition != null
                ? definition.normalizeManualPlacementRotation(rotation)
                : rotation != null ? rotation : RotationAmount.fromAngleUnits(0);
        if (definition == null || definition.hasLight() == false)
        {
            this.rotation = normalizedRotation;
            sync();
            return;
        }
        List<int[]> previousEmitterOffsets = getLightEmitterOffsets(this.rotation);
        this.rotation = normalizedRotation;
        sync();
        refreshLightEmission(previousEmitterOffsets);
        refreshLightEmission();
    }

    /**
     * Returns newly allocated world-axis offsets for this rotation. Callers may
     * safely modify the returned arrays without changing the definition.
     *
     * @return mutable list of mutable controller-relative X, Y, and Z arrays
     */
    public List<int[]> getPartOffsets()
    {
        return ConfigurablePropStructure.getPartOffsets(getDefinition(), rotation);
    }

    /**
     * Returns the model's local translation from its normal placement origin.
     *
     * @return immutable right, up, and forward placement offset
     */
    public PropPlacementOffset getPlacementOffset()
    {
        return placementOffset;
    }

    /**
     * Clamps and synchronizes the model's local placement translation.
     *
     * @param placementOffset requested local right, up, and forward offset; null means zero
     */
    public void setPlacementOffset(PropPlacementOffset placementOffset)
    {
        ConfigurablePropDefinition definition = getDefinition();
        this.placementOffset = definition != null
                ? definition.clampPlacementOffset(placementOffset)
                : placementOffset != null ? placementOffset : PropPlacementOffset.zero();
        sync();
    }

    /**
     * Returns the active mode, forcing manual mode when the definition disables auto-height.
     *
     * @return effective non-null height mode
     */
    public ConfigurablePropHeightMode getHeightMode()
    {
        ConfigurablePropDefinition definition = getDefinition();
        return definition != null && definition.isAutoHeightAdjustmentEnabled()
                ? heightMode
                : ConfigurablePropHeightMode.MANUAL;
    }

    /**
     * Applies a supported height mode and synchronizes the normalized result.
     * Definitions without auto-height support always resolve to manual mode.
     *
     * @param heightMode requested mode; null selects the definition's supported default
     */
    public void setHeightMode(ConfigurablePropHeightMode heightMode)
    {
        ConfigurablePropDefinition definition = getDefinition();
        this.heightMode = definition != null && definition.isAutoHeightAdjustmentEnabled()
                ? (heightMode != null ? heightMode : ConfigurablePropHeightMode.AUTO)
                : ConfigurablePropHeightMode.MANUAL;
        sync();
    }

    /**
     * Tests whether model mirroring is both enabled by the definition and selected.
     *
     * @return {@code true} when this instance should render mirrored
     */
    public boolean isModelFlipped()
    {
        ConfigurablePropDefinition definition = getDefinition();
        return definition != null && definition.isModelFlipEnabled() && modelFlipped;
    }

    /**
     * Applies model mirroring only when supported and synchronizes the tile.
     *
     * @param flipped whether the instance requests the definition-authored mirror
     */
    public void setModelFlipped(boolean flipped)
    {
        ConfigurablePropDefinition definition = getDefinition();
        modelFlipped = definition != null && definition.isModelFlipEnabled() && flipped;
        sync();
    }

    /**
     * Returns the placement offset's X component after rotation into world axes.
     *
     * @return signed world-X translation in blocks
     */
    public double getWorldOffsetX()
    {
        return rotation.rotateX(
                placementOffset.getRightBlocks(),
                placementOffset.getForwardBlocks()
        );
    }

    /**
     * Returns the vertical placement offset including optional support correction.
     *
     * @return signed world-Y translation in blocks
     */
    public double getWorldOffsetY()
    {
        ConfigurablePropDefinition definition = getDefinition();
        if (definition != null
                && definition.isAutoHeightAdjustmentEnabled()
                && getHeightMode() == ConfigurablePropHeightMode.AUTO)
        {
            return ConfigurablePropHeightHelper.getAutoHeightOffset(
                    definition,
                    worldObj,
                    xCoord,
                    yCoord,
                    zCoord
            ) + placementOffset.getUpBlocks();
        }
        return placementOffset.getUpBlocks();
    }

    /**
     * Returns the placement offset's Z component after rotation into world axes.
     *
     * @return signed world-Z translation in blocks
     */
    public double getWorldOffsetZ()
    {
        return rotation.rotateZ(
                placementOffset.getRightBlocks(),
                placementOffset.getForwardBlocks()
        );
    }

    /**
     * Returns the mutable behavior state owned by this controller. Interactions
     * may edit the returned compound and must call {@link #markBehaviorDirty()}
     * after a complete logical update so the tile is saved and synchronized.
     *
     * @return mutable behavior compound owned by this tile
     */
    public NBTTagCompound getBehaviorData()
    {
        return behaviorData;
    }

    /**
     * Persists mutations made through {@link #getBehaviorData()} without sending
     * a full rendering packet. Processing progress may call this frequently;
     * visible state transitions must use a focused synchronization operation.
     */
    public void markBehaviorDirty()
    {
        super.markDirty();
    }

    /**
     * Returns the effective lit state, including the definition default when a
     * manually controlled fixture has not stored a state yet.
     *
     * @return {@code true} when authored emitters currently produce light
     */
    public boolean isLightLit()
    {
        ConfigurablePropDefinition definition = getDefinition();
        ConfigurablePropLightDefinition light = definition != null
                ? definition.getLightDefinition()
                : null;
        if (light == null)
        {
            return false;
        }
        if (light.getControlMode() == ConfigurablePropLightDefinition.ControlMode.FIXED)
        {
            return light.isLitByDefault();
        }
        return behaviorData.hasKey(LIGHT_LIT_KEY)
                ? behaviorData.getBoolean(LIGHT_LIT_KEY)
                : light.isLitByDefault();
    }

    /**
     * Changes a stateful fixture, synchronizes it, and recalculates every block
     * light emitter. Fixed fixtures and client-side callers are rejected.
     *
     * @param lit requested emitted-light state
     * @return {@code true} when authoritative state changed
     */
    public boolean setLightLit(boolean lit)
    {
        ConfigurablePropDefinition definition = getDefinition();
        ConfigurablePropLightDefinition light = definition != null
                ? definition.getLightDefinition()
                : null;
        if ((worldObj != null && worldObj.isRemote)
                || light == null
                || light.getControlMode() == ConfigurablePropLightDefinition.ControlMode.FIXED
                || isLightLit() == lit)
        {
            return false;
        }
        behaviorData.setBoolean(LIGHT_LIT_KEY, lit);
        sync();
        refreshLightEmission();
        return true;
    }

    /**
     * Toggles a manually controlled fixture.
     *
     * @return {@code true} when authoritative light state changed
     */
    public boolean toggleLight()
    {
        return setLightLit(isLightLit() == false);
    }

    /**
     * Returns the light level emitted by one rotated controller-relative cell.
     *
     * @param relativeX cell's world-axis X offset from the controller
     * @param relativeY cell's world-axis Y offset from the controller
     * @param relativeZ cell's world-axis Z offset from the controller
     * @return emitted block-light level from {@code 0} to {@code 15}
     */
    public int getLightLevelAtRelativeOffset(int relativeX, int relativeY, int relativeZ)
    {
        ConfigurablePropDefinition definition = getDefinition();
        ConfigurablePropLightDefinition light = definition != null
                ? definition.getLightDefinition()
                : null;
        if (light == null || isLightLit() == false)
        {
            return 0;
        }
        return light.emitsAtRelativeOffset(relativeX, relativeY, relativeZ, rotation)
                ? light.getLightLevel()
                : 0;
    }

    /**
     * Tests whether a rotated structure cell is an authored light emitter.
     *
     * @param relativeX cell's world-axis X offset from the controller
     * @param relativeY cell's world-axis Y offset from the controller
     * @param relativeZ cell's world-axis Z offset from the controller
     * @return {@code true} when the definition assigns an emitter to the cell
     */
    public boolean isLightEmitterAtRelativeOffset(int relativeX, int relativeY, int relativeZ)
    {
        ConfigurablePropDefinition definition = getDefinition();
        ConfigurablePropLightDefinition light = definition != null
                ? definition.getLightDefinition()
                : null;
        return light != null
                && light.emitsAtRelativeOffset(relativeX, relativeY, relativeZ, rotation);
    }

    /** Requests block-light recalculation at every currently rotated emitter cell. */
    public void refreshLightEmission()
    {
        refreshLightEmission(getLightEmitterOffsets(rotation));
    }

    /** Builds world-axis emitter offsets for one orientation. */
    private List<int[]> getLightEmitterOffsets(RotationAmount emitterRotation)
    {
        ConfigurablePropDefinition definition = getDefinition();
        ConfigurablePropLightDefinition light = definition != null
                ? definition.getLightDefinition()
                : null;
        if (light == null)
        {
            return Collections.emptyList();
        }
        List<int[]> offsets = new ArrayList<int[]>(light.getEmitterCells().size());
        for (ConfigurablePropLightDefinition.EmitterCell emitter : light.getEmitterCells())
        {
            offsets.add(ConfigurablePropStructure.rotateOffset(
                    emitter.getLocalX(),
                    emitter.getLocalY(),
                    emitter.getLocalZ(),
                    emitterRotation
            ));
        }
        return offsets;
    }

    /** Recalculates block light at controller-relative emitter offsets. */
    private void refreshLightEmission(List<int[]> emitterOffsets)
    {
        if (worldObj == null)
        {
            return;
        }
        for (int[] emitterOffset : emitterOffsets)
        {
            int emitterX = xCoord + emitterOffset[0];
            int emitterY = yCoord + emitterOffset[1];
            int emitterZ = zCoord + emitterOffset[2];
            if (emitterOffset[0] == 0
                    && emitterOffset[1] == 0
                    && emitterOffset[2] == 0)
            {
                ConfigurablePropLightRelightHelper.request(
                        worldObj,
                        emitterX,
                        emitterY,
                        emitterZ
                );
                continue;
            }
            if (worldObj.blockExists(emitterX, emitterY, emitterZ) == false)
            {
                continue;
            }
            TileEntity emitterTile = worldObj.getTileEntity(emitterX, emitterY, emitterZ);
            if (emitterTile instanceof TileConfigurablePropLightEmitter)
            {
                ((TileConfigurablePropLightEmitter) emitterTile).setEmittedLightLevel(
                        getLightLevelAtRelativeOffset(
                                emitterOffset[0],
                                emitterOffset[1],
                                emitterOffset[2]
                        )
                );
            }
        }
    }

    /**
     * Resolves the definition's specialized interaction for subclasses that own
     * additional behavior capabilities.
     *
     * @return registered interaction, or {@code null} when none is assigned
     */
    protected final ConfigurablePropInteraction getInteraction()
    {
        ConfigurablePropDefinition definition = getDefinition();
        return definition != null
                ? ConfigurablePropInteractionRegistry.getInteraction(definition.getInteractionId())
                : null;
    }

    /**
     * Creates the controller block item carrying this prop's visual settings.
     *
     * @return configured prop stack, or {@code null} when no block mapping exists
     */
    public ItemStack createConfiguredDropStack()
    {
        net.minecraft.block.Block configurablePropBlock = ConfigurablePropRegistry.getBlock(definitionId);
        if (configurablePropBlock == null)
        {
            return null;
        }

        ItemStack configurableProp = new ItemStack(configurablePropBlock);
        NBTTagCompound itemTag = new NBTTagCompound();
        NBTTagCompound appearanceTag = new NBTTagCompound();
        appearance.writeToNBT(appearanceTag);
        itemTag.setTag("Appearance", appearanceTag);
        NBTTagCompound offsetTag = new NBTTagCompound();
        placementOffset.writeToNBT(offsetTag);
        itemTag.setTag("PlacementOffset", offsetTag);
        itemTag.setString("HeightMode", getHeightMode().getId());
        if (isModelFlipped())
        {
            itemTag.setBoolean("ModelFlipped", true);
        }
        ConfigurablePropDefinition definition = getDefinition();
        if (definition != null
                && definition.isManualPlacementRotationEnabled()
                && manualPlacementRotation)
        {
            NBTTagCompound manualRotationTag = new NBTTagCompound();
            rotation.writeToNBT(manualRotationTag);
            itemTag.setTag("ManualPlacementRotation", manualRotationTag);
            itemTag.setBoolean("UseManualPlacementRotation", true);
        }
        configurableProp.setTagCompound(itemTag);
        return configurableProp;
    }

    /**
     * Removes owned part cells, drops stored items, and optionally drops or
     * removes the controller. This method is server-authoritative and idempotent.
     *
     * @param dropConfigurableProp whether to drop the configured controller item
     * @param removeController whether to replace the controller block with air
     */
    public void destroyStructure(boolean dropConfigurableProp, boolean removeController)
    {
        if (worldObj == null || destroying)
        {
            return;
        }

        destroying = true;
        if (worldObj.isRemote == false)
        {
            dropCapabilityContents();
            if (dropConfigurableProp)
            {
                ItemStack configurableProp = createConfiguredDropStack();
                if (configurableProp != null)
                {
                    spawnDrop(configurableProp);
                }
            }

            ConfigurablePropDefinition definition = getDefinition();
            if (definition != null && definition.isMultiblock())
            {
                for (int[] offset : getPartOffsets())
                {
                    int partX = xCoord + offset[0];
                    int partY = yCoord + offset[1];
                    int partZ = zCoord + offset[2];
                    if (isOwnedStructurePart(partX, partY, partZ))
                    {
                        worldObj.setBlockToAir(partX, partY, partZ);
                    }
                }
            }
            if (removeController
                    && worldObj.getBlock(xCoord, yCoord, zCoord)
                    == ConfigurablePropRegistry.getBlock(definitionId))
            {
                worldObj.setBlockToAir(xCoord, yCoord, zCoord);
            }
        }
    }

    /** Removes a partially placed structure without producing any drops. */
    public void cancelPlacement()
    {
        if (worldObj == null)
        {
            return;
        }
        destroying = true;
        ConfigurablePropDefinition definition = getDefinition();
        if (definition != null && definition.isMultiblock())
        {
            for (int[] offset : getPartOffsets())
            {
                int partX = xCoord + offset[0];
                int partY = yCoord + offset[1];
                int partZ = zCoord + offset[2];
                if (isOwnedStructurePart(partX, partY, partZ))
                {
                    worldObj.setBlockToAir(partX, partY, partZ);
                }
            }
        }
        if (worldObj.getBlock(xCoord, yCoord, zCoord) == ConfigurablePropRegistry.getBlock(definitionId))
        {
            worldObj.setBlockToAir(xCoord, yCoord, zCoord);
        }
    }

    /**
     * Allows capability subclasses to drop and clear owned contents during
     * authoritative structure destruction. Basic controllers own no contents.
     */
    protected void dropCapabilityContents()
    {
    }

    /**
     * Tests whether a structure cell uses either shared part-block variant and
     * its tile still resolves to this controller. Checking both block and tile
     * ownership prevents damaged or repaired overlapping structures from
     * deleting another controller's part.
     *
     * @param partX candidate world X coordinate
     * @param partY candidate world Y coordinate
     * @param partZ candidate world Z coordinate
     * @return {@code true} when the cell is a removable configurable-prop part
     */
    private boolean isOwnedStructurePart(int partX, int partY, int partZ)
    {
        net.minecraft.block.Block partBlock = worldObj.getBlock(partX, partY, partZ);
        boolean sharedPartBlock = ConfigurablePropSystem.isStructurePartBlock(partBlock);
        if (sharedPartBlock == false)
        {
            return false;
        }
        TileEntity tile = worldObj.getTileEntity(partX, partY, partZ);
        return tile instanceof TileConfigurablePropPart
                && ((TileConfigurablePropPart) tile).isOwnedBy(this);
    }

    /**
     * Spawns one stack at the center of the controller block.
     *
     * @param stack non-null stack to spawn into the controller's world
     */
    protected final void spawnDrop(ItemStack stack)
    {
        worldObj.spawnEntityInWorld(new EntityItem(
                worldObj,
                xCoord + 0.5D,
                yCoord + 0.5D,
                zCoord + 0.5D,
                stack
        ));
    }

    /** Marks persistent state dirty and requests a block update when attached to a world. */
    protected final void sync()
    {
        super.markDirty();
        if (worldObj != null)
        {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

    /**
     * Keeps shared controllers out of Minecraft's per-tick tile list. Processor
     * controllers receive work through explicit scheduled block updates instead.
     *
     * @return always {@code false} for the shared event-driven controller
     */
    @Override
    public boolean canUpdate()
    {
        return false;
    }

    /**
     * Checks whether this controller remains present and within normal block-use
     * range of a player. Storage subclasses also use this for container access.
     *
     * @param player player attempting to use the controller
     * @return {@code true} when the player can still reach this tile
     */
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return worldObj != null
                && worldObj.getTileEntity(xCoord, yCoord, zCoord) == this
                && player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
    }

    /**
     * Allows a capability subclass to resize or reset definition-controlled state.
     * The constructor does not invoke this overridable hook; subclass constructors
     * must initialize their own state after the superclass constructor returns.
     *
     * @param definition newly resolved definition, or {@code null} when unknown
     */
    protected void onDefinitionChanged(ConfigurablePropDefinition definition)
    {
    }

    /**
     * Writes subclass-owned persistent capability data into the controller tag.
     *
     * @param tag root controller tag receiving capability data
     */
    protected void writeCapabilityDataToNBT(NBTTagCompound tag)
    {
    }

    /**
     * Restores subclass-owned persistent capability data after shared state has
     * resolved the saved definition.
     *
     * @param tag root controller tag containing capability data
     * @param definition saved definition, or {@code null} when unavailable
     */
    protected void readCapabilityDataFromNBT(
            NBTTagCompound tag,
            ConfigurablePropDefinition definition
    )
    {
    }

    /** {@inheritDoc} */
    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setString("DefinitionId", definitionId);
        rotation.writeToNBT(tag);

        NBTTagCompound appearanceTag = new NBTTagCompound();
        appearance.writeToNBT(appearanceTag);
        tag.setTag("Appearance", appearanceTag);
        NBTTagCompound offsetTag = new NBTTagCompound();
        placementOffset.writeToNBT(offsetTag);
        tag.setTag("PlacementOffset", offsetTag);
        tag.setString("HeightMode", getHeightMode().getId());
        tag.setBoolean("ModelFlipped", isModelFlipped());
        tag.setBoolean("ManualPlacementRotation", manualPlacementRotation);
        tag.setTag("BehaviorData", behaviorData);
        writeCapabilityDataToNBT(tag);
    }

    /** {@inheritDoc} */
    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        definitionId = tag.getString("DefinitionId");
        rotation = RotationAmount.readFromNBT(tag);
        ConfigurablePropDefinition readDefinition = getDefinition();
        if (readDefinition != null)
        {
            rotation = readDefinition.normalizeManualPlacementRotation(rotation);
        }
        AppearanceData storedAppearance = tag.hasKey("Appearance")
                ? AppearanceData.readFromNBT(tag.getCompoundTag("Appearance"))
                : AppearanceData.defaultAppearance();
        appearance = validateAppearance(readDefinition, storedAppearance);
        placementOffset = tag.hasKey("PlacementOffset")
                ? PropPlacementOffset.readFromNBT(tag.getCompoundTag("PlacementOffset"))
                : readDefinition != null
                ? readDefinition.getDefaultPlacementOffset()
                : PropPlacementOffset.zero();
        if (readDefinition != null)
        {
            placementOffset = readDefinition.clampPlacementOffset(placementOffset);
        }
        heightMode = readDefinition != null && readDefinition.isAutoHeightAdjustmentEnabled()
                ? readHeightMode(tag)
                : ConfigurablePropHeightMode.MANUAL;
        modelFlipped = readDefinition != null
                && readDefinition.isModelFlipEnabled()
                && tag.getBoolean("ModelFlipped");
        manualPlacementRotation = readDefinition != null
                && readDefinition.isManualPlacementRotationEnabled()
                && tag.getBoolean("ManualPlacementRotation");
        behaviorData = tag.hasKey("BehaviorData")
                ? tag.getCompoundTag("BehaviorData")
                : new NBTTagCompound();
        readCapabilityDataFromNBT(tag, readDefinition);
    }

    /** {@inheritDoc} */
    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("DefinitionId", definitionId);
        rotation.writeToNBT(tag);
        NBTTagCompound appearanceTag = new NBTTagCompound();
        appearance.writeToNBT(appearanceTag);
        tag.setTag("Appearance", appearanceTag);
        NBTTagCompound offsetTag = new NBTTagCompound();
        placementOffset.writeToNBT(offsetTag);
        tag.setTag("PlacementOffset", offsetTag);
        tag.setString("HeightMode", getHeightMode().getId());
        tag.setBoolean("ModelFlipped", isModelFlipped());
        tag.setTag("BehaviorData", behaviorData);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    /** {@inheritDoc} */
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        List<int[]> previousEmitterOffsets = getLightEmitterOffsets(rotation);
        NBTTagCompound tag = packet.func_148857_g();
        definitionId = tag.getString("DefinitionId");
        ConfigurablePropDefinition definition = getDefinition();
        onDefinitionChanged(definition);
        rotation = RotationAmount.readFromNBT(tag);
        if (definition != null)
        {
            rotation = definition.normalizeManualPlacementRotation(rotation);
        }
        appearance = validateAppearance(
                definition,
                AppearanceData.readFromNBT(tag.getCompoundTag("Appearance"))
        );
        heightMode = definition != null && definition.isAutoHeightAdjustmentEnabled()
                ? readHeightMode(tag)
                : ConfigurablePropHeightMode.MANUAL;
        placementOffset = tag.hasKey("PlacementOffset")
                ? PropPlacementOffset.readFromNBT(tag.getCompoundTag("PlacementOffset"))
                : definition != null
                ? definition.getDefaultPlacementOffset()
                : PropPlacementOffset.zero();
        if (definition != null)
        {
            placementOffset = definition.clampPlacementOffset(placementOffset);
        }
        modelFlipped = definition != null
                && definition.isModelFlipEnabled()
                && tag.getBoolean("ModelFlipped");
        behaviorData = tag.hasKey("BehaviorData")
                ? tag.getCompoundTag("BehaviorData")
                : new NBTTagCompound();
        refreshLightEmission(previousEmitterOffsets);
        refreshLightEmission();
    }

    /**
     * Applies the profile belonging to a definition at every serialized or
     * network boundary. Missing optional content degrades to an empty appearance
     * so the renderer can use the definition's base texture fallback.
     */
    private AppearanceData validateAppearance(
            ConfigurablePropDefinition definition,
            AppearanceData requested
    )
    {
        if (definition == null)
        {
            return AppearanceData.defaultAppearance();
        }
        CustomizationProfile profile = CustomizationRegistry.getProfile(
                definition.getCustomizationProfileId()
        );
        return profile != null
                ? CustomizationRegistry.validateAppearance(profile, requested)
                : AppearanceData.defaultAppearance();
    }

    /** {@inheritDoc} */
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        ConfigurablePropDefinition definition = getDefinition();
        int horizontal = definition != null
                ? definition.getRenderBoundsHorizontalRadius()
                : 1;
        int height = definition != null ? definition.getRenderBoundsHeightBlocks() : 1;
        double modelOffsetX = definition != null ? definition.getModelOffsetX() - 0.5D : 0.0D;
        double modelOffsetY = definition != null ? definition.getModelOffsetY() - 0.5D : 0.0D;
        double modelOffsetZ = definition != null ? definition.getModelOffsetZ() - 0.5D : 0.0D;
        return AxisAlignedBB.getBoundingBox(
                xCoord - horizontal + modelOffsetX + getWorldOffsetX(),
                yCoord + modelOffsetY + getWorldOffsetY(),
                zCoord - horizontal + modelOffsetZ + getWorldOffsetZ(),
                xCoord + horizontal + 1 + modelOffsetX + getWorldOffsetX(),
                yCoord + height + modelOffsetY + getWorldOffsetY(),
                zCoord + horizontal + 1 + modelOffsetZ + getWorldOffsetZ()
        );
    }

    /** Reads the persisted mode, defaulting older auto-height saves to automatic mode. */
    private ConfigurablePropHeightMode readHeightMode(NBTTagCompound tag)
    {
        return tag != null && tag.hasKey("HeightMode")
                ? ConfigurablePropHeightMode.fromId(tag.getString("HeightMode"))
                : ConfigurablePropHeightMode.AUTO;
    }
}
