package com.bidahochi.BlockMod.blocks.props.configurable.block;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.props.configurable.ConfigurablePropSystem;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropBlockProperties;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropControllerType;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropRegistry;
import com.bidahochi.BlockMod.blocks.props.configurable.data.PropPlacementOffset;
import com.bidahochi.BlockMod.blocks.props.configurable.item.ItemBlockConfigurableProp;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteractionRegistry;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropLightEmitter;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropPart;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropProcessor;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropStorage;
import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import com.bidahochi.BlockMod.common.rotation.RotationSnap;
import com.bidahochi.BlockMod.customization.data.AppearanceData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Locale;

/**
 * Hosts the authoritative tile for one placed prop and owns placement,
 * interaction forwarding, selection, collision, and structure completion.
 */
public class BlockConfigurablePropController extends BlockContainer
{

    private final String definitionId;
    private final String iconResourceDomain;
    private final String iconPath;
    private final boolean lightCapable;
    private IIcon icon;

    /**
     * Creates a wood-like controller with the default prop icon.
     *
     * @param definitionId stable registered definition identifier represented by the block
     */
    public BlockConfigurablePropController(String definitionId)
    {
        this(definitionId, FoxBlocks.MODID, "props/soda_machine", ConfigurablePropBlockProperties.wood());
    }

    /**
     * Creates a wood-like controller with an icon in the FoxBlocks resource domain.
     *
     * @param definitionId stable registered definition identifier represented by the block
     * @param iconPath block icon path relative to {@code textures/blocks}
     */
    public BlockConfigurablePropController(String definitionId, String iconPath)
    {
        this(definitionId, FoxBlocks.MODID, iconPath, ConfigurablePropBlockProperties.wood());
    }

    /**
     * Creates a controller using explicit icon and physical block properties.
     * Light capability is inferred from the definition already in the registry.
     *
     * @param definitionId stable registered definition identifier represented by the block
     * @param iconResourceDomain resource domain containing the block icon
     * @param iconPath block icon path relative to {@code textures/blocks}
     * @param properties physical material, hardness, sound, and harvest properties
     */
    public BlockConfigurablePropController(
            String definitionId,
            String iconResourceDomain,
            String iconPath,
            ConfigurablePropBlockProperties properties
    )
    {
        this(
                definitionId,
                iconResourceDomain,
                iconPath,
                properties,
                hasRegisteredLight(definitionId)
        );
    }

    /**
     * Creates a controller with an explicit immutable light-capability fast path.
     * Use this overload during normal catalog registration so props that can never
     * emit light avoid tile lookups in Minecraft's light query.
     *
     * @param definitionId stable registered definition identifier represented by the block
     * @param iconResourceDomain resource domain containing the block icon
     * @param iconPath block icon path relative to {@code textures/blocks}
     * @param properties physical material, hardness, sound, and harvest properties
     * @param lightCapable {@code true} only when the definition contains authored light data
     */
    public BlockConfigurablePropController(
            String definitionId,
            String iconResourceDomain,
            String iconPath,
            ConfigurablePropBlockProperties properties,
            boolean lightCapable
    )
    {
        super((properties != null ? properties : ConfigurablePropBlockProperties.wood()).getMaterial());
        ConfigurablePropBlockProperties blockProperties =
                properties != null ? properties : ConfigurablePropBlockProperties.wood();
        this.definitionId = definitionId;
        this.iconResourceDomain = iconResourceDomain != null && iconResourceDomain.trim().length() > 0
                ? iconResourceDomain.trim().toLowerCase(Locale.ROOT)
                : FoxBlocks.MODID;
        this.iconPath = iconPath;
        this.lightCapable = lightCapable;
        setHardness(blockProperties.getHardness());
        setResistance(blockProperties.getResistance());
        setStepSound(blockProperties.getStepSound());
        if (blockProperties.hasHarvestTool())
        {
            setHarvestLevel(blockProperties.getHarvestTool(), blockProperties.getHarvestLevel());
        }
    }

    /** {@inheritDoc} */
    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        ConfigurablePropDefinition definition = ConfigurablePropRegistry.getDefinition(definitionId);
        ConfigurablePropControllerType controllerType = definition != null
                ? definition.getControllerType()
                : ConfigurablePropControllerType.BASIC;
        switch (controllerType)
        {
            case STORAGE:
                return new TileConfigurablePropStorage(definitionId);
            case PROCESSOR:
                return new TileConfigurablePropProcessor(definitionId);
            case BASIC:
            default:
                return new TileConfigurablePropController(definitionId);
        }
    }

    /**
     * Routes an explicitly scheduled machine update to the processor tile. No
     * random ticking is enabled; active processors schedule only their next step.
     *
     * @param world authoritative world containing the controller
     * @param x controller world X coordinate
     * @param y controller world Y coordinate
     * @param z controller world Z coordinate
     * @param random world update random source, unused by deterministic processing
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (world.isRemote)
        {
            return;
        }
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileConfigurablePropProcessor)
        {
            ((TileConfigurablePropProcessor) tile).runScheduledProcessorUpdate();
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public int getRenderType()
    {
        return -1;
    }

    /** {@inheritDoc} */
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        if (lightCapable == false)
        {
            return 0;
        }
        TileEntity tile = world.getTileEntity(x, y, z);
        return tile instanceof TileConfigurablePropController
                ? ((TileConfigurablePropController) tile).getLightLevelAtRelativeOffset(0, 0, 0)
                : 0;
    }

    /** {@inheritDoc} */
    @Override
    public void onBlockPlacedBy(
            World world,
            int x,
            int y,
            int z,
            EntityLivingBase placer,
            ItemStack stack
    )
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if ((tile instanceof TileConfigurablePropController) == false)
        {
            return;
        }

        TileConfigurablePropController controller = (TileConfigurablePropController) tile;
        ConfigurablePropDefinition definition = ConfigurablePropRegistry.getDefinition(definitionId);
        controller.setDefinitionId(definitionId);
        RotationAmount placedRotation;
        if (stack.getItem() instanceof ItemBlockConfigurableProp)
        {
            placedRotation = ((ItemBlockConfigurableProp) stack.getItem())
                    .getPlacementRotation(stack, placer);
        }
        else
        {
            placedRotation = RotationAmount.fromPlacement(
                    placer,
                    definition != null ? definition.getRotationSnap() : RotationSnap.FOUR
            );
            if (definition != null)
            {
                placedRotation = placedRotation.plusDegrees(
                        definition.getPlacementYawOffsetDegrees()
                );
            }
        }
        controller.setRotation(placedRotation);
        if (stack.getItem() instanceof ItemBlockConfigurableProp)
        {
            controller.setManualPlacementRotation(
                    ((ItemBlockConfigurableProp) stack.getItem())
                            .isManualPlacementRotation(stack)
            );
        }
        if (stack.hasTagCompound() && stack.getTagCompound().hasKey("Appearance"))
        {
            AppearanceData appearance = AppearanceData.readFromNBT(
                    stack.getTagCompound().getCompoundTag("Appearance")
            );
            controller.applyAppearance(null, appearance);
        }
        if (stack.hasTagCompound() && stack.getTagCompound().hasKey("PlacementOffset"))
        {
            controller.setPlacementOffset(PropPlacementOffset.readFromNBT(
                    stack.getTagCompound().getCompoundTag("PlacementOffset")
            ));
        }
        else if (definition != null)
        {
            controller.setPlacementOffset(definition.getDefaultPlacementOffset());
        }
        if (definition != null
                && definition.isModelFlipEnabled()
                && stack.hasTagCompound())
        {
            controller.setModelFlipped(stack.getTagCompound().getBoolean("ModelFlipped"));
        }
        if (stack.getItem() instanceof ItemBlockConfigurableProp)
        {
            controller.setHeightMode(((ItemBlockConfigurableProp) stack.getItem()).getHeightMode(stack));
        }
        if (definition != null && definition.hasLight())
        {
            controller.refreshLightEmission();
        }
    }

    /**
     * Claims every required multiblock cell and links its part tile back to the
     * controller, rolling back newly placed parts on the first failure.
     *
     * @param world server world containing the controller
     * @param x controller block X coordinate
     * @param y controller block Y coordinate
     * @param z controller block Z coordinate
     * @return {@code true} when all required cells are linked or none are required
     */
    public boolean completeStructure(World world, int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if ((tile instanceof TileConfigurablePropController) == false)
        {
            return false;
        }

        TileConfigurablePropController controller = (TileConfigurablePropController) tile;
        ConfigurablePropDefinition definition = controller.getDefinition();
        if (definition == null || definition.isMultiblock() == false)
        {
            return true;
        }
        List<int[]> placedOffsets = new ArrayList<int[]>();
        for (int[] offset : controller.getPartOffsets())
        {
            int partX = x + offset[0];
            int partY = y + offset[1];
            int partZ = z + offset[2];
            boolean lightEmitter = definition.hasLight()
                    && controller.isLightEmitterAtRelativeOffset(
                            offset[0],
                            offset[1],
                            offset[2]
                    );
            Block partBlock = ConfigurablePropSystem.getStructurePartBlock(
                    definition,
                    lightEmitter
            );
            if (world.setBlock(
                    partX,
                    partY,
                    partZ,
                    partBlock,
                    0,
                    3
            ) == false)
            {
                removePlacedParts(world, x, y, z, placedOffsets);
                return false;
            }

            TileEntity partTile = world.getTileEntity(partX, partY, partZ);
            if ((partTile instanceof TileConfigurablePropPart) == false)
            {
                removePlacedParts(world, x, y, z, placedOffsets);
                world.setBlockToAir(partX, partY, partZ);
                return false;
            }
            ((TileConfigurablePropPart) partTile).setControllerOffset(
                    -offset[0],
                    -offset[1],
                    -offset[2]
            );
            if (partTile instanceof TileConfigurablePropLightEmitter)
            {
                ((TileConfigurablePropLightEmitter) partTile).setEmittedLightLevel(
                        controller.getLightLevelAtRelativeOffset(
                                offset[0],
                                offset[1],
                                offset[2]
                        )
                );
            }
            world.scheduleBlockUpdate(partX, partY, partZ, partBlock, 2);
            placedOffsets.add(offset);
        }
        if (definition.hasLight())
        {
            controller.refreshLightEmission();
        }
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public boolean onBlockActivated(
            World world,
            int x,
            int y,
            int z,
            EntityPlayer player,
            int side,
            float hitX,
            float hitY,
            float hitZ
    )
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if ((tile instanceof TileConfigurablePropController) == false)
        {
            return false;
        }
        return activateController(
                (TileConfigurablePropController) tile,
                player,
                0,
                0,
                0,
                side,
                hitX,
                hitY,
                hitZ
        );
    }

    /**
     * Removes the controller and its linked structure without deciding whether
     * the configured prop item should drop. Player-harvest eligibility is only
     * available in {@link #removedByPlayer(World, EntityPlayer, int, int, int, boolean)}.
     *
     * @param world world containing the controller
     * @param x controller x-coordinate
     * @param y controller y-coordinate
     * @param z controller z-coordinate
     * @param block block replacing the controller
     * @param metadata controller metadata before removal
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileConfigurablePropController)
        {
            ((TileConfigurablePropController) tile).destroyStructure(false, false);
        }
        super.breakBlock(world, x, y, z, block, metadata);
    }

    /**
     * Removes a controller for a player and drops its configured prop item only
     * when Minecraft has approved the harvest. This prevents creative removal,
     * an unsuitable tool, and non-player replacement from duplicating the prop.
     *
     * @param world world containing the controller
     * @param player player removing the controller
     * @param x controller x-coordinate
     * @param y controller y-coordinate
     * @param z controller z-coordinate
     * @param willHarvest whether Minecraft approved the harvest
     * @return {@code true} when the controller was removed
     */
    @Override
    public boolean removedByPlayer(
            World world,
            EntityPlayer player,
            int x,
            int y,
            int z,
            boolean willHarvest
    )
    {
        ItemStack configuredDrop = null;
        TileEntity tile = world.getTileEntity(x, y, z);
        if (willHarvest && tile instanceof TileConfigurablePropController)
        {
            configuredDrop =
                    ((TileConfigurablePropController) tile).createConfiguredDropStack();
        }

        boolean removed = super.removedByPlayer(world, player, x, y, z, willHarvest);
        if (removed && world.isRemote == false && configuredDrop != null)
        {
            dropBlockAsItem(world, x, y, z, configuredDrop);
        }
        return removed;
    }

    /** {@inheritDoc} */
    @Override
    public ArrayList<ItemStack> getDrops(
            World world,
            int x,
            int y,
            int z,
            int metadata,
            int fortune
    )
    {
        return new ArrayList<ItemStack>();
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack getPickBlock(
            MovingObjectPosition target,
            World world,
            int x,
            int y,
            int z,
            EntityPlayer player
    )
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileConfigurablePropController)
        {
            ItemStack configuredStack =
                    ((TileConfigurablePropController) tile).createConfiguredDropStack();
            if (configuredStack != null)
            {
                return configuredStack;
            }
        }
        return new ItemStack(this);
    }

    /** {@inheritDoc} */
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        icon = register.registerIcon(iconResourceDomain + ":" + iconPath);
    }

    /** {@inheritDoc} */
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        return icon;
    }

    /** {@inheritDoc} */
    @Override
    public void addCollisionBoxesToList(
            World world,
            int x,
            int y,
            int z,
            AxisAlignedBB mask,
            List boxes,
            net.minecraft.entity.Entity entity
    )
    {
        ConfigurablePropDefinition definition = getDefinition();
        if (definition != null && definition.isEntityCollisionEnabled() == false)
        {
            return;
        }
        AxisAlignedBB box = getOffsetBounds(world, x, y, z);
        if (box != null && mask.intersectsWith(box))
        {
            boxes.add(box);
        }
    }

    /** {@inheritDoc} */
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return getOffsetBounds(world, x, y, z);
    }

    /** {@inheritDoc} */
    @Override
    public MovingObjectPosition collisionRayTrace(
            World world,
            int x,
            int y,
            int z,
            Vec3 start,
            Vec3 end
    )
    {
        MovingObjectPosition hit = getOffsetBounds(world, x, y, z)
                .calculateIntercept(start, end);
        return hit != null
                ? new MovingObjectPosition(x, y, z, hit.sideHit, hit.hitVec)
                : null;
    }

    /**
     * Returns the definition bound to this controller block type.
     *
     * @return registered definition, or {@code null} when registration is incomplete
     */
    public ConfigurablePropDefinition getDefinition()
    {
        return ConfigurablePropRegistry.getDefinition(definitionId);
    }

    /**
     * Translates the controller's occupied structure cell by the player's
     * rotated placement offset. The render-only model origin must not move the
     * block face used for placement targeting.
     */
    private AxisAlignedBB getOffsetBounds(World world, int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        TileConfigurablePropController controller = tile instanceof TileConfigurablePropController
                ? (TileConfigurablePropController) tile
                : null;
        double offsetX = controller != null ? controller.getWorldOffsetX() : 0.0D;
        double offsetY = controller != null ? controller.getWorldOffsetY() : 0.0D;
        double offsetZ = controller != null ? controller.getWorldOffsetZ() : 0.0D;
        return AxisAlignedBB.getBoundingBox(
                x + offsetX,
                y + offsetY,
                z + offsetZ,
                x + 1.0D + offsetX,
                y + 1.0D + offsetY,
                z + 1.0D + offsetZ
        );
    }

    /**
     * Routes a controller or linked-part click to the definition-selected behavior.
     *
     * @param controller authoritative controller receiving the interaction
     * @param player player performing the click
     * @param partOffsetX clicked cell's X offset from the controller
     * @param partOffsetY clicked cell's Y offset from the controller
     * @param partOffsetZ clicked cell's Z offset from the controller
     * @param side clicked block face
     * @param hitX face-local hit X coordinate from {@code 0.0} to {@code 1.0}
     * @param hitY face-local hit Y coordinate from {@code 0.0} to {@code 1.0}
     * @param hitZ face-local hit Z coordinate from {@code 0.0} to {@code 1.0}
     * @return {@code true} when registered behavior handled the interaction
     */
    public static boolean activateController(
            TileConfigurablePropController controller,
            EntityPlayer player,
            int partOffsetX,
            int partOffsetY,
            int partOffsetZ,
            int side,
            float hitX,
            float hitY,
            float hitZ
    )
    {
        ConfigurablePropDefinition definition = controller.getDefinition();
        if (definition == null)
        {
            return false;
        }
        ConfigurablePropInteraction interaction = ConfigurablePropInteractionRegistry.getInteraction(
                definition.getInteractionId()
        );
        return interaction != null
                && interaction.onInteractAt(
                        controller,
                        player,
                        partOffsetX,
                        partOffsetY,
                        partOffsetZ,
                        side,
                        hitX,
                        hitY,
                        hitZ
                );
    }

    /** Rolls back only the part offsets successfully written during this placement attempt. */
    private void removePlacedParts(
            World world,
            int x,
            int y,
            int z,
            List<int[]> offsets
    )
    {
        for (int[] offset : offsets)
        {
            world.setBlockToAir(x + offset[0], y + offset[1], z + offset[2]);
        }
    }

    /** Resolves the compatibility constructor's light fast path at block creation. */
    private static boolean hasRegisteredLight(String definitionId)
    {
        ConfigurablePropDefinition definition =
                ConfigurablePropRegistry.getDefinition(definitionId);
        return definition != null && definition.hasLight();
    }
}
