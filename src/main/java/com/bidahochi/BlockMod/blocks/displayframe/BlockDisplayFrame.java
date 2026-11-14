package com.bidahochi.BlockMod.blocks.displayframe;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/** A mounted frame whose item and frame geometry are rendered with the chunk. */
public final class BlockDisplayFrame extends BlockContainer
{
    /** Distance from the edge of the block to the outer rim, in blocks. */
    public static final float EDGE = 2.0F / 16.0F;
    /** Distance from the support to the front of the rim, in blocks. */
    public static final float DEPTH = 1.0F / 16.0F;
    // Lower metadata bits store the face. The next bit marks legacy floating frames.
    private static final int FACING_MASK = 7;
    private static final int STANDALONE_FLAG = 8;
    /** Registered block used by item placement and crafting. */
    public static BlockDisplayFrame instance;
    /** Client render handler ID assigned during registration. */
    public static int renderId;

    private BlockDisplayFrame()
    {
        super(Material.wood);
        setBlockName("display_frame");
        setBlockTextureName("minecraft:itemframe_background");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabVanillaPlus);
        setHardness(0.25F);
        setStepSound(soundTypeWood);
        setLightOpacity(0);
    }

    /** Registers the block, its item form, and its saved tile entity. */
    public static void register()
    {
        instance = new BlockDisplayFrame();
        GameRegistry.registerBlock(instance, ItemBlockDisplayFrame.class, "display_frame");
        GameRegistry.registerTileEntity(TileDisplayFrame.class, "foxblocks:display_frame");
    }

    /** Creates the tile that stores the frame's item and display mode. */
    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileDisplayFrame();
    }

    /** Keeps neighboring block faces visible around the thin frame. */
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    /** Uses the frame's chunk renderer in place of full cube geometry. */
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /** Keeps the frame from acting as a solid cube for neighboring blocks. */
    @Override
    public boolean isNormalCube(IBlockAccess world, int x, int y, int z)
    {
        return false;
    }

    /** Returns the ID of the chunk renderer registered on the client. */
    @Override
    public int getRenderType()
    {
        return renderId;
    }

    /** Lets players and mobs walk through the frame. */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }

    /** Positions the selection box against the supporting face, or in the center for old floating frames. */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        int metadata = world.getBlockMetadata(x, y, z);
        if (isStandalone(metadata))
        {
            ForgeDirection face = ForgeDirection.getOrientation(getFacing(metadata));
            float middleMin = 0.5F - DEPTH / 2;
            float middleMax = 0.5F + DEPTH / 2;
            boolean thinX = face.offsetX != 0;
            boolean thinY = face.offsetY != 0;
            boolean thinZ = face.offsetZ != 0;
            float outerMax = 1 - EDGE;
            setBlockBounds(thinX ? middleMin : EDGE, thinY ? middleMin : EDGE, thinZ ? middleMin : EDGE,
                    thinX ? middleMax : outerMax, thinY ? middleMax : outerMax, thinZ ? middleMax : outerMax);
            return;
        }
        switch (getFacing(metadata))
        {
            case 0:
                setBlockBounds(EDGE, 1 - DEPTH, EDGE, 1 - EDGE, 1, 1 - EDGE);
                break;
            case 1:
                setBlockBounds(EDGE, 0, EDGE, 1 - EDGE, DEPTH, 1 - EDGE);
                break;
            case 2:
                setBlockBounds(EDGE, EDGE, 1 - DEPTH, 1 - EDGE, 1 - EDGE, 1);
                break;
            case 4:
                setBlockBounds(1 - DEPTH, EDGE, EDGE, 1, 1 - EDGE, 1 - EDGE);
                break;
            case 5:
                setBlockBounds(0, EDGE, EDGE, DEPTH, 1 - EDGE, 1 - EDGE);
                break;
            default:
                setBlockBounds(EDGE, EDGE, 0, 1 - EDGE, 1 - EDGE, DEPTH);
                break;
        }
    }

    /** Extracts the Forge face index from saved block metadata. */
    public static int getFacing(int metadata)
    {
        return metadata & FACING_MASK;
    }

    /** Identifies a floating frame from a save made before standalone placement was removed. */
    public static boolean isStandalone(int metadata)
    {
        return (metadata & STANDALONE_FLAG) != 0;
    }

    /** Requires a mount on the selected face in addition to normal block placement rules. */
    @Override
    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
    {
        return super.canPlaceBlockOnSide(world, x, y, z, side) && hasSupport(world, x, y, z, side, false);
    }

    /** Saves the selected mounting face as block metadata. */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side,
                             float hitX, float hitY, float hitZ, int metadata)
    {
        return side;
    }

    /** Drops a mounted frame when its backing block no longer supports it. */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
    {
        if (world.isRemote)
        {
            return;
        }
        int metadata = world.getBlockMetadata(x, y, z);
        if (isStandalone(metadata))
        {
            return;
        }
        int facing = getFacing(metadata);
        if (hasSupport(world, x, y, z, facing, true) == false)
        {
            dropBlockAsItem(world, x, y, z, metadata, 0);
            world.setBlockToAir(x, y, z);
        }
    }

    /** Drops the default frame item without using the mounting face as item damage. */
    @Override
    public int damageDropped(int metadata)
    {
        return 0;
    }

    /** Checks the backing block, deferring removal across unloaded chunk boundaries. */
    private boolean hasSupport(World world, int x, int y, int z, int side, boolean allowUnloaded)
    {
        if (side < 0 || side > 5)
        {
            return false;
        }
        ForgeDirection face = ForgeDirection.getOrientation(side);
        int supportX = x - face.offsetX;
        int supportY = y - face.offsetY;
        int supportZ = z - face.offsetZ;
        if (allowUnloaded && supportY >= 0 && supportY < world.getHeight()
                && world.blockExists(supportX, supportY, supportZ) == false)
        {
            return true;
        }
        Block support = world.getBlock(supportX, supportY, supportZ);
        if (support == this)
        {
            return false;
        }
        // Vanilla hanging frames accept solid materials even when the side is only partially filled.
        boolean solidWallMaterial = face.offsetY == 0 && support.getMaterial().isSolid();
        return solidWallMaterial || world.isSideSolid(supportX, supportY, supportZ, face);
    }

    /** Handles item insertion, retrieval, and rotation after the server allows block use. */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
                                    int side, float hitX, float hitY, float hitZ)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        ItemStack held = player.getHeldItem();
        if ((tile instanceof TileDisplayFrame) == false
                || player.canPlayerEdit(x, y, z, side, held) == false)
        {
            return false;
        }

        TileDisplayFrame frame = (TileDisplayFrame) tile;
        ItemStack displayed = frame.getDisplayedItem();
        if (displayed == null && held == null)
        {
            return false;
        }
        if (world.isRemote)
        {
            return true;
        }

        // Forge checks RIGHT_CLICK_BLOCK before activation. Keep the world edit check
        // here too, since callers can invoke activation directly.
        if (world.canMineBlock(player, x, y, z) == false)
        {
            return true;
        }

        if (displayed == null)
        {
            frame.setDisplayedItem(held);
            if (player.capabilities.isCreativeMode == false)
            {
                held.stackSize--;
                if (held.stackSize == 0)
                {
                    player.setCurrentItemOrArmor(0, null);
                }
            }
        }
        else if (player.isSneaking() && held == null)
        {
            ItemStack removed = displayed.copy();
            frame.setDisplayedItem(null);
            boolean stored = player.inventory.addItemStackToInventory(removed);
            if (stored == false && removed.stackSize > 0)
            {
                player.dropPlayerItemWithRandomChoice(removed, false);
            }
        }
        else
        {
            frame.rotate();
        }
        return true;
    }

    /** Drops the displayed item on the server before removing the frame's tile. */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block oldBlock, int metadata)
    {
        if (world.isRemote == false)
        {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile instanceof TileDisplayFrame)
            {
                ItemStack stack = ((TileDisplayFrame) tile).getDisplayedItem();
                if (stack != null)
                {
                    dropBlockAsItem(world, x, y, z, stack.copy());
                }
            }
        }
        super.breakBlock(world, x, y, z, oldBlock, metadata);
    }
}
