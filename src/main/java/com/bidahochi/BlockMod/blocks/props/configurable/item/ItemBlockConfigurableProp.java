package com.bidahochi.BlockMod.blocks.props.configurable.item;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.props.configurable.ConfigurablePropSystem;
import com.bidahochi.BlockMod.blocks.props.configurable.block.BlockConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.data.ConfigurablePropHeightMode;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropStructure;
import com.bidahochi.BlockMod.blocks.props.configurable.data.PropPlacementOffset;
import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import com.bidahochi.BlockMod.common.rotation.RotationSnap;
import com.bidahochi.BlockMod.customization.data.AppearanceData;
import com.bidahochi.BlockMod.customization.data.CustomizationNumberParser;
import com.bidahochi.BlockMod.customization.registry.CustomizationProfile;
import com.bidahochi.BlockMod.customization.registry.CustomizationRegistry;
import com.bidahochi.BlockMod.customization.registry.CustomizationTrait;
import com.bidahochi.BlockMod.customization.registry.CustomizationTraitOption;
import com.bidahochi.BlockMod.customization.registry.SkinDefinition;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;

import java.util.List;

/**
 * Carries a prop's validated appearance and placement options before placing its
 * definition-specific controller block.
 */
public class ItemBlockConfigurableProp extends ItemBlock
{

    /**
     * Creates the configurable item form for one registered controller block.
     *
     * @param block definition-specific configurable controller block
     */
    public ItemBlockConfigurableProp(Block block)
    {
        super(block);
        setMaxStackSize(1);
    }

    /**
     * Defers placement mutation to the logical server so a protection-event
     * cancellation cannot temporarily consume the client stack or display a
     * predicted controller and gag structure. The client still reports a
     * successful use while it waits for the authoritative world update.
     *
     * @param stack configurable prop stack being used
     * @param player player attempting placement
     * @param world client or server world receiving the use
     * @param x clicked block x-coordinate
     * @param y clicked block y-coordinate
     * @param z clicked block z-coordinate
     * @param side clicked block side
     * @param hitX fractional hit position along X
     * @param hitY fractional hit position along Y
     * @param hitZ fractional hit position along Z
     * @return {@code true} for client acknowledgement or the server placement result
     */
    @Override
    public boolean onItemUse(
            ItemStack stack,
            EntityPlayer player,
            World world,
            int x,
            int y,
            int z,
            int side,
            float hitX,
            float hitY,
            float hitZ
    )
    {
        if (world.isRemote)
        {
            return true;
        }
        return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (world.isRemote == false)
        {
            player.openGui(
                    FoxBlocks.instance,
                    ConfigurablePropSystem.GUI_CUSTOMIZATION,
                    world,
                    player.inventory.currentItem,
                    0,
                    0
            );
        }
        return stack;
    }

    /**
     * Returns the definition supplied by this item's controller block.
     *
     * @return registered definition, or {@code null} when registration is incomplete
     */
    public ConfigurablePropDefinition getConfigurablePropDefinition()
    {
        return ((BlockConfigurablePropController) field_150939_a).getDefinition();
    }

    /**
     * Returns the rotation this item would use if placed by an entity now.
     *
     * @param stack configurable prop stack carrying an optional manual angle
     * @param placer entity supplying placement yaw when automatic mode is active
     * @return manual angle or snapped automatic angle including placement correction
     */
    public RotationAmount getPlacementRotation(ItemStack stack, EntityLivingBase placer)
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        if (isManualPlacementRotation(stack))
        {
            return getManualPlacementRotation(stack);
        }
        RotationAmount rotation = RotationAmount.fromPlacement(
                placer,
                definition != null ? definition.getRotationSnap() : RotationSnap.FOUR
        );
        return definition != null
                ? rotation.plusDegrees(definition.getPlacementYawOffsetDegrees())
                : rotation;
    }

    /**
     * Tests whether this item uses its stored angle instead of player-facing
     * automatic placement.
     *
     * @param stack configurable prop item stack, or {@code null}
     * @return {@code true} when the definition and item both enable manual mode
     */
    public boolean isManualPlacementRotation(ItemStack stack)
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        return definition != null
                && definition.isManualPlacementRotationEnabled()
                && stack != null
                && stack.hasTagCompound()
                && stack.getTagCompound().getBoolean("UseManualPlacementRotation");
    }

    /**
     * Reads and validates the item's stored manual placement angle.
     *
     * @param stack configurable prop item stack, or {@code null}
     * @return normalized angle safe for the current definition
     */
    public RotationAmount getManualPlacementRotation(ItemStack stack)
    {
        RotationAmount requested = stack != null
                && stack.hasTagCompound()
                && stack.getTagCompound().hasKey("ManualPlacementRotation")
                ? RotationAmount.readFromNBT(
                        stack.getTagCompound().getCompoundTag("ManualPlacementRotation")
                )
                : RotationAmount.fromAngleUnits(0);
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        return definition != null
                ? definition.normalizeManualPlacementRotation(requested)
                : requested;
    }

    /**
     * Validates and persists the optional manual placement angle. Unsupported
     * definitions always retain automatic placement.
     *
     * @param stack configurable prop item to mutate
     * @param useManualRotation whether placement should use the stored angle
     * @param requestedRotation requested angle, or {@code null} for zero degrees
     */
    public void setManualPlacementRotation(
            ItemStack stack,
            boolean useManualRotation,
            RotationAmount requestedRotation
    )
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        if (stack == null
                || definition == null
                || definition.isManualPlacementRotationEnabled() == false)
        {
            return;
        }
        if (stack.hasTagCompound() == false)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        RotationAmount rotation = definition.normalizeManualPlacementRotation(requestedRotation);
        NBTTagCompound rotationTag = new NBTTagCompound();
        rotation.writeToNBT(rotationTag);
        stack.getTagCompound().setTag("ManualPlacementRotation", rotationTag);
        stack.getTagCompound().setBoolean("UseManualPlacementRotation", useManualRotation);
    }

    /**
     * Returns whether every secondary structure cell is available and editable
     * at the prospective controller position and rotation. Entity collision is
     * checked for each cell using the shared structure-part block.
     *
     * @param world world receiving the structure
     * @param controllerX prospective controller world X
     * @param controllerY prospective controller world Y
     * @param controllerZ prospective controller world Z
     * @param rotation prospective placed rotation
     * @param player player attempting to place the structure
     * @param side side used for the original placement interaction
     * @param stack configurable prop stack being placed
     * @return {@code true} when every non-controller cell can be edited and occupied
     */
    public boolean canPlaceStructureAt(
            World world,
            int controllerX,
            int controllerY,
            int controllerZ,
            RotationAmount rotation,
            EntityPlayer player,
            int side,
            ItemStack stack
    )
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        if (definition == null || definition.isMultiblock() == false)
        {
            return true;
        }
        for (int[] offset : ConfigurablePropStructure.getPartOffsets(definition, rotation))
        {
            int partX = controllerX + offset[0];
            int partY = controllerY + offset[1];
            int partZ = controllerZ + offset[2];
            boolean lightEmitter = definition.hasLight()
                    && definition.getLightDefinition().emitsAtRelativeOffset(
                            offset[0],
                            offset[1],
                            offset[2],
                            rotation
                    );
            Block partBlock = ConfigurablePropSystem.getStructurePartBlock(
                    definition,
                    lightEmitter
            );
            if (partY < 0 || partY >= world.getHeight()
                    || world.getBlock(partX, partY, partZ)
                    .isReplaceable(world, partX, partY, partZ) == false
                    || player.canPlayerEdit(partX, partY, partZ, side, stack) == false
                    || world.canPlaceEntityOnSide(
                            partBlock,
                            partX,
                            partY,
                            partZ,
                            false,
                            side,
                            player,
                            stack
                    ) == false)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Reads and profile-validates item appearance.
     *
     * @param stack configurable prop item stack, or {@code null}
     * @return valid immutable appearance using definition defaults when absent
     */
    public AppearanceData getAppearance(ItemStack stack)
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        AppearanceData fallback = definition != null
                ? ConfigurablePropSystem.getDefaultAppearance(definition.getId())
                : AppearanceData.defaultAppearance();
        if (stack == null
                || stack.hasTagCompound() == false
                || stack.getTagCompound().hasKey("Appearance") == false)
        {
            return fallback;
        }
        CustomizationProfile profile = definition != null
                ? CustomizationRegistry.getProfile(definition.getCustomizationProfileId())
                : null;
        AppearanceData stored = AppearanceData.readFromNBT(
                stack.getTagCompound().getCompoundTag("Appearance")
        );
        return profile != null
                ? CustomizationRegistry.validateAppearance(profile, stored)
                : fallback;
    }

    /**
     * Validates requested appearance before replacing item NBT.
     *
     * @param stack configurable prop item to mutate
     * @param requested untrusted requested appearance
     */
    public void setAppearance(ItemStack stack, AppearanceData requested)
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        CustomizationProfile profile = definition != null
                ? CustomizationRegistry.getProfile(definition.getCustomizationProfileId())
                : null;
        if (stack == null || profile == null)
        {
            return;
        }
        AppearanceData appearance = CustomizationRegistry.validateAppearance(profile, requested);
        if (stack.hasTagCompound() == false)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound appearanceTag = new NBTTagCompound();
        appearance.writeToNBT(appearanceTag);
        stack.getTagCompound().setTag("Appearance", appearanceTag);
    }

    /**
     * Reads the local-axis placement offset and clamps it to all active limits.
     *
     * @param stack configurable prop item stack, or {@code null}
     * @return normalized offset, using the definition default when absent
     */
    public PropPlacementOffset getPlacementOffset(ItemStack stack)
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        if (stack == null
                || stack.hasTagCompound() == false
                || stack.getTagCompound().hasKey("PlacementOffset") == false)
        {
            return definition != null
                    ? definition.getDefaultPlacementOffset()
                    : PropPlacementOffset.zero();
        }
        PropPlacementOffset offset = PropPlacementOffset.readFromNBT(
                stack.getTagCompound().getCompoundTag("PlacementOffset")
        );
        return definition != null ? definition.clampPlacementOffset(offset) : offset;
    }

    /**
     * Clamps and persists a local-axis placement offset on the item.
     *
     * @param stack configurable prop item to mutate
     * @param offset requested offset, or {@code null} for zero
     */
    public void setPlacementOffset(ItemStack stack, PropPlacementOffset offset)
    {
        if (stack == null)
        {
            return;
        }
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        if (stack.hasTagCompound() == false)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound offsetTag = new NBTTagCompound();
        (definition != null
                ? definition.clampPlacementOffset(offset)
                : offset != null ? offset : PropPlacementOffset.zero()).writeToNBT(offsetTag);
        stack.getTagCompound().setTag("PlacementOffset", offsetTag);
    }

    /**
     * Reads the supported support-height mode.
     *
     * @param stack configurable prop item stack, or {@code null}
     * @return stored mode, automatic default, or manual when unsupported
     */
    public ConfigurablePropHeightMode getHeightMode(ItemStack stack)
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        if (definition == null || definition.isAutoHeightAdjustmentEnabled() == false)
        {
            return ConfigurablePropHeightMode.MANUAL;
        }
        if (stack == null
                || stack.hasTagCompound() == false
                || stack.getTagCompound().hasKey("HeightMode") == false)
        {
            return ConfigurablePropHeightMode.AUTO;
        }
        return ConfigurablePropHeightMode.fromId(stack.getTagCompound().getString("HeightMode"));
    }

    /**
     * Persists height mode only when the definition supports automatic adjustment.
     *
     * @param stack configurable prop item to mutate
     * @param mode requested mode; {@code null} selects automatic
     */
    public void setHeightMode(ItemStack stack, ConfigurablePropHeightMode mode)
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        if (stack == null || definition == null || definition.isAutoHeightAdjustmentEnabled() == false)
        {
            return;
        }
        if (stack.hasTagCompound() == false)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.getTagCompound().setString(
                "HeightMode",
                (mode != null ? mode : ConfigurablePropHeightMode.AUTO).getId()
        );
    }

    /**
     * Returns the stored mirror choice only when the definition exposes mirroring.
     *
     * @param stack configurable prop item stack, or {@code null}
     * @return whether the model should render mirrored
     */
    public boolean isModelFlipped(ItemStack stack)
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        return definition != null
                && definition.isModelFlipEnabled()
                && stack != null
                && stack.hasTagCompound()
                && stack.getTagCompound().getBoolean("ModelFlipped");
    }

    /**
     * Persists a mirror choice only when the definition exposes mirroring.
     *
     * @param stack configurable prop item to mutate
     * @param flipped requested mirror state
     */
    public void setModelFlipped(ItemStack stack, boolean flipped)
    {
        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        if (stack == null || definition == null || definition.isModelFlipEnabled() == false)
        {
            return;
        }
        if (stack.hasTagCompound() == false)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.getTagCompound().setBoolean("ModelFlipped", flipped);
    }

    /** {@inheritDoc} */
    @Override
    public void addInformation(
            ItemStack stack,
            EntityPlayer player,
            List lines,
            boolean advanced
    )
    {
        lines.add(
                ""
                        + EnumChatFormatting.GOLD
                        + EnumChatFormatting.BOLD
                        + translate("headingPrefix")
                        + EnumChatFormatting.RESET
                        + " "
                        + translate("heading")
        );
        lines.add(
                EnumChatFormatting.GRAY
                        + translate("usePrefix")
                        + " "
                        + translate("configure")
        );
        lines.add(
                EnumChatFormatting.GRAY
                        + translate("persistencePrefix")
                        + " "
                        + translate("persistent")
        );

        ConfigurablePropDefinition definition = getConfigurablePropDefinition();
        CustomizationProfile profile = definition != null
                ? CustomizationRegistry.getProfile(definition.getCustomizationProfileId())
                : null;
        lines.add(
                EnumChatFormatting.DARK_GRAY
                        + translate("currentPrefix")
                        + " "
                        + translate("current")
        );
        if (profile != null)
        {
            AppearanceData appearance = getAppearance(stack);
            for (CustomizationTrait trait : profile.getTraits())
            {
                String value = appearance.getTrait(trait.getId(), trait.getDefaultValue());
                lines.add(
                        EnumChatFormatting.DARK_GRAY
                                + "- "
                                + StatCollector.translateToLocal(trait.getDisplayNameKey())
                                + ": "
                                + EnumChatFormatting.WHITE
                                + getTraitValueName(trait, value)
                );
            }
        }
        PropPlacementOffset offset = getPlacementOffset(stack);
        lines.add(
                EnumChatFormatting.DARK_GRAY
                        + "- "
                        + translate("offset")
                        + ": "
                        + EnumChatFormatting.WHITE
                        + "Right "
                        + formatOffset(offset.getRightBlocks())
                        + ", "
                        + "Up "
                        + formatOffset(offset.getUpBlocks())
                        + ", "
                        + "Forward "
                        + formatOffset(offset.getForwardBlocks())
                        + " blocks"
        );
        if (definition != null && definition.isAutoHeightAdjustmentEnabled())
        {
            lines.add(
                    EnumChatFormatting.DARK_GRAY
                            + "- "
                            + translate("height")
                            + ": "
                            + EnumChatFormatting.WHITE
                            + translate(getHeightMode(stack) == ConfigurablePropHeightMode.AUTO
                            ? "heightAuto"
                            : "heightManual")
            );
        }
        if (definition != null && definition.isModelFlipEnabled())
        {
            lines.add(
                    EnumChatFormatting.DARK_GRAY
                            + "- "
                            + translate("flip")
                            + ": "
                            + EnumChatFormatting.WHITE
                            + translate(isModelFlipped(stack) ? "flipped" : "normal")
            );
        }
        if (definition != null && definition.isManualPlacementRotationEnabled())
        {
            lines.add(
                    EnumChatFormatting.DARK_GRAY
                            + "- "
                            + translate("rotation")
                            + ": "
                            + EnumChatFormatting.WHITE
                            + (isManualPlacementRotation(stack)
                            ? formatDegrees(getManualPlacementRotation(stack).toDegrees())
                            : translate("rotationAutomatic"))
            );
        }
    }

    /** Resolves skin display keys before falling back to the trait option label. */
    private String getTraitValueName(CustomizationTrait trait, String value)
    {
        if (trait.getKind() == CustomizationTrait.Kind.COLOR)
        {
            return formatRgb(parseColor(value));
        }
        if (trait.getKind() == CustomizationTrait.Kind.SKIN)
        {
            SkinDefinition skin = CustomizationRegistry.getSkin(value);
            return skin != null
                    ? StatCollector.translateToLocal(skin.getDisplayNameKey())
                    : value;
        }
        CustomizationTraitOption option = trait.findOption(value);
        return option != null
                ? StatCollector.translateToLocal(option.getDisplayNameKey())
                : value;
    }

    /** Parses a packed color, returning opaque white when the stored value is invalid. */
    private int parseColor(String value)
    {
        return CustomizationNumberParser.parseInteger(value, 0xFFFFFFFF);
    }

    /** Formats a packed color for human-readable tooltip text. */
    private String formatRgb(int color)
    {
        return "RGB "
                + ((color >> 16) & 255)
                + ", "
                + ((color >> 8) & 255)
                + ", "
                + (color & 255);
    }

    /** Resolves a configurable-prop tooltip translation by suffix. */
    private String translate(String suffix)
    {
        return StatCollector.translateToLocal("tooltip.foxblocks.configurableProp." + suffix);
    }

    /** Formats a block offset with the precision exposed by the tooltip. */
    private String formatOffset(double value)
    {
        return String.format("%.2f", value);
    }

    /** Formats a normalized placement angle for the item tooltip. */
    private String formatDegrees(double value)
    {
        return String.format("%.2f degrees", value);
    }

    /** {@inheritDoc} */
    @Override
    public boolean placeBlockAt(
            ItemStack stack,
            EntityPlayer player,
            World world,
            int x,
            int y,
            int z,
            int side,
            float hitX,
            float hitY,
            float hitZ,
            int metadata
    )
    {
        BlockConfigurablePropController configurableProp = (BlockConfigurablePropController) field_150939_a;
        ConfigurablePropDefinition definition = configurableProp.getDefinition();
        RotationAmount rotation = getPlacementRotation(stack, player);
        if (definition == null || definition.isMultiblock() == false)
        {
            return super.placeBlockAt(
                    stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata
            );
        }
        if (canPlaceStructureAt(
                world,
                x,
                y,
                z,
                rotation,
                player,
                side,
                stack
        ) == false)
        {
            return false;
        }

        if (super.placeBlockAt(
                stack,
                player,
                world,
                x,
                y,
                z,
                side,
                hitX,
                hitY,
                hitZ,
                metadata
        ) == false)
        {
            return false;
        }

        if (configurableProp.completeStructure(world, x, y, z) == false)
        {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile instanceof TileConfigurablePropController)
            {
                ((TileConfigurablePropController) tile).cancelPlacement();
            }
            else
            {
                world.setBlockToAir(x, y, z);
            }
            return false;
        }
        return true;
    }

}
