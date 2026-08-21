package com.bidahochi.BlockMod.blocks.props.configurable.block;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropBlockProperties;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropPart;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents an invisible non-controller cell of a multiblock prop and forwards
 * gameplay operations to its owning controller.
 */
public class BlockConfigurablePropPart extends BlockContainer
{

    private IIcon icon;

    /** Creates the invisible, non-dropping cell used by multiblock props. */
    public BlockConfigurablePropPart()
    {
        this(ConfigurablePropBlockProperties.wood());
    }

    /**
     * Creates an invisible structure cell with a material-family fallback.
     * Coordinate-aware properties still delegate to the owning controller.
     *
     * @param properties physical profile used for material, sound, and orphan fallback
     */
    public BlockConfigurablePropPart(ConfigurablePropBlockProperties properties)
    {
        super(properties != null ? properties.getMaterial() : Material.wood);
        ConfigurablePropBlockProperties fallback = properties != null
                ? properties
                : ConfigurablePropBlockProperties.wood();
        setHardness(fallback.getHardness());
        setResistance(fallback.getResistance());
        setStepSound(fallback.getStepSound());
        if (fallback.hasHarvestTool())
        {
            setHarvestLevel(fallback.getHarvestTool(), fallback.getHarvestLevel());
        }
    }

    /** {@inheritDoc} */
    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileConfigurablePropPart();
    }

    /**
     * Removes a newly placed part when a protection system subsequently rejects
     * or removes its controller. Placement schedules this check once; part tiles
     * remain non-ticking during normal gameplay.
     *
     * @param world world containing the candidate part
     * @param x part x-coordinate
     * @param y part y-coordinate
     * @param z part z-coordinate
     * @param random world random source supplied by Minecraft
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (world.isRemote)
        {
            return;
        }
        TileEntity tile = world.getTileEntity(x, y, z);
        if ((tile instanceof TileConfigurablePropPart) == false
                || ((TileConfigurablePropPart) tile).getController() == null)
        {
            world.setBlockToAir(x, y, z);
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

    /**
     * Uses the owning controller's authored hardness so metal, wood, and stone
     * multiblock cells take the same time to break as their controller.
     *
     * @param world world containing the part
     * @param x part x-coordinate
     * @param y part y-coordinate
     * @param z part z-coordinate
     * @return controller hardness, or the safe part fallback when orphaned
     */
    @Override
    public float getBlockHardness(World world, int x, int y, int z)
    {
        TileConfigurablePropController controller = getController(world, x, y, z);
        Block controllerBlock = getControllerBlock(world, controller);
        return controllerBlock != null
                ? controllerBlock.getBlockHardness(
                        world,
                        controller.xCoord,
                        controller.yCoord,
                        controller.zCoord
                )
                : super.getBlockHardness(world, x, y, z);
    }

    /**
     * Delegates player-relative break speed to the controller so its material,
     * harvest tool, and harvest level affect every linked part consistently.
     *
     * @param player player attempting to break the part
     * @param world world containing the part
     * @param x part x-coordinate
     * @param y part y-coordinate
     * @param z part z-coordinate
     * @return controller-relative breaking progress
     */
    @Override
    public float getPlayerRelativeBlockHardness(
            EntityPlayer player,
            World world,
            int x,
            int y,
            int z
    )
    {
        TileConfigurablePropController controller = getController(world, x, y, z);
        Block controllerBlock = getControllerBlock(world, controller);
        return controllerBlock != null
                ? controllerBlock.getPlayerRelativeBlockHardness(
                        player,
                        world,
                        controller.xCoord,
                        controller.yCoord,
                        controller.zCoord
                )
                : super.getPlayerRelativeBlockHardness(player, world, x, y, z);
    }

    /**
     * Delegates coordinate-aware explosion resistance to the owning controller.
     *
     * @param entity entity responsible for the explosion, when present
     * @param world world containing the part
     * @param x part x-coordinate
     * @param y part y-coordinate
     * @param z part z-coordinate
     * @param explosionX explosion origin X
     * @param explosionY explosion origin Y
     * @param explosionZ explosion origin Z
     * @return controller explosion resistance, or the orphan fallback
     */
    @Override
    public float getExplosionResistance(
            Entity entity,
            World world,
            int x,
            int y,
            int z,
            double explosionX,
            double explosionY,
            double explosionZ
    )
    {
        TileConfigurablePropController controller = getController(world, x, y, z);
        Block controllerBlock = getControllerBlock(world, controller);
        return controllerBlock != null
                ? controllerBlock.getExplosionResistance(
                        entity,
                        world,
                        controller.xCoord,
                        controller.yCoord,
                        controller.zCoord,
                        explosionX,
                        explosionY,
                        explosionZ
                )
                : super.getExplosionResistance(
                        entity,
                        world,
                        x,
                        y,
                        z,
                        explosionX,
                        explosionY,
                        explosionZ
                );
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
        if ((tile instanceof TileConfigurablePropPart) == false)
        {
            return false;
        }
        TileConfigurablePropController controller = ((TileConfigurablePropPart) tile).getController();
        if (controller == null)
        {
            return false;
        }

        return BlockConfigurablePropController.activateController(
                controller,
                player,
                x - controller.xCoord,
                y - controller.yCoord,
                z - controller.zCoord,
                side,
                hitX,
                hitY,
                hitZ
        );
    }

    /**
     * Removes the linked structure without deciding whether its configured prop
     * item should drop. Player-harvest eligibility is handled by
     * {@link #removedByPlayer(World, EntityPlayer, int, int, int, boolean)}.
     *
     * @param world world containing the part
     * @param x part x-coordinate
     * @param y part y-coordinate
     * @param z part z-coordinate
     * @param block block replacing the part
     * @param metadata part metadata before removal
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileConfigurablePropPart)
        {
            TileConfigurablePropController controller = ((TileConfigurablePropPart) tile).getController();
            if (controller != null)
            {
                controller.destroyStructure(false, true);
            }
        }
        super.breakBlock(world, x, y, z, block, metadata);
    }

    /**
     * Removes a linked part for a player and drops the configured prop item only
     * when Minecraft's pre-removal harvest check succeeded. The supplied result
     * must be retained because Minecraft damages the held tool before invoking
     * this method, and the tool may have broken on its final durability use.
     * Controller coordinates and item data are captured before the linked
     * structure is dismantled.
     *
     * @param world world containing the part
     * @param player player removing the part
     * @param x part x-coordinate
     * @param y part y-coordinate
     * @param z part z-coordinate
     * @param willHarvest Minecraft's harvest result computed before tool damage
     * @return {@code true} when the part was removed
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
        int dropX = x;
        int dropY = y;
        int dropZ = z;
        TileEntity tile = world.getTileEntity(x, y, z);
        if (player != null
                && player.capabilities.isCreativeMode == false
                && tile instanceof TileConfigurablePropPart)
        {
            TileConfigurablePropController controller =
                    ((TileConfigurablePropPart) tile).getController();
            if (controller != null)
            {
                Block controllerBlock = world.getBlock(
                        controller.xCoord,
                        controller.yCoord,
                        controller.zCoord
                );
                if (controllerBlock instanceof BlockConfigurablePropController
                        && willHarvest)
                {
                    configuredDrop = controller.createConfiguredDropStack();
                    dropX = controller.xCoord;
                    dropY = controller.yCoord;
                    dropZ = controller.zCoord;
                }
            }
        }

        boolean removed = super.removedByPlayer(world, player, x, y, z, willHarvest);
        if (removed && world.isRemote == false && configuredDrop != null)
        {
            dropBlockAsItem(world, dropX, dropY, dropZ, configuredDrop);
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
        if (tile instanceof TileConfigurablePropPart)
        {
            TileConfigurablePropController controller =
                    ((TileConfigurablePropPart) tile).getController();
            if (controller != null)
            {
                return controller.createConfiguredDropStack();
            }
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        icon = register.registerIcon(FoxBlocks.MODID + ":000EMPTY");
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
        TileConfigurablePropController controller = getController(world, x, y, z);
        ConfigurablePropDefinition definition = controller != null
                ? controller.getDefinition()
                : null;
        if (controller != null
                && definition != null
                && definition.isEntityCollisionEnabled() == false)
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
     * Applies the owning controller's rotated placement translation to this
     * occupied structure cell. The render-only model origin is deliberately
     * excluded so top and side placement faces remain aligned to block cells.
     */
    private AxisAlignedBB getOffsetBounds(World world, int x, int y, int z)
    {
        TileConfigurablePropController controller = getController(world, x, y, z);
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
     * Resolves the controller that owns an invisible structure part. A missing
     * controller is a recoverable incomplete-world state and returns null.
     */
    private TileConfigurablePropController getController(World world, int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        return tile instanceof TileConfigurablePropPart
                ? ((TileConfigurablePropPart) tile).getController()
                : null;
    }

    /** Returns the controller block only while the resolved tile still occupies its cell. */
    private Block getControllerBlock(
            World world,
            TileConfigurablePropController controller
    )
    {
        if (controller == null)
        {
            return null;
        }
        Block controllerBlock = world.getBlock(
                controller.xCoord,
                controller.yCoord,
                controller.zCoord
        );
        return controllerBlock instanceof BlockConfigurablePropController
                ? controllerBlock
                : null;
    }
}
