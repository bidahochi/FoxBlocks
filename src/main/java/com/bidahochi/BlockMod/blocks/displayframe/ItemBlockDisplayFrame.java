package com.bidahochi.BlockMod.blocks.displayframe;

import com.bidahochi.BlockMod.blocks.displayframe.TileDisplayFrame.DisplayStyle;
import com.bidahochi.BlockMod.blocks.scrolling.IFoxBlocksScrollingItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

/** Places mounted Display Frames with the display mode selected on the item. */
public final class ItemBlockDisplayFrame extends ItemBlock implements IFoxBlocksScrollingItem
{
    private static final int MOUNTED = 0;
    // ID 1 belonged to Standalone. Keep it mapped to the default for old stacks.
    private static final int ITEM_ONLY = 2;
    private static final int FLAT = 3;
    private static final int LABELED = 4;
    private static final int LABELED_ITEM_ONLY = 5;

    /** Creates the item form of the registered Display Frame block. */
    public ItemBlockDisplayFrame(Block block)
    {
        super(block);
        setHasSubtypes(true);
    }

    /** Cycles the display modes, treating unknown IDs as Mounted. */
    @Override
    public void cycleMode(ItemStack stack, boolean forward)
    {
        switch (stack.getItemDamage())
        {
            case ITEM_ONLY:
                stack.setItemDamage(forward ? FLAT : MOUNTED);
                break;
            case FLAT:
                stack.setItemDamage(forward ? LABELED : ITEM_ONLY);
                break;
            case LABELED:
                stack.setItemDamage(forward ? LABELED_ITEM_ONLY : FLAT);
                break;
            case LABELED_ITEM_ONLY:
                stack.setItemDamage(forward ? MOUNTED : LABELED);
                break;
            default:
                stack.setItemDamage(forward ? ITEM_ONLY : LABELED_ITEM_ONLY);
                break;
        }
    }

    /** Uses a mode-specific translation key for the held frame. */
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        String name = super.getUnlocalizedName(stack);
        switch (stack.getItemDamage())
        {
            case ITEM_ONLY:
                return name + ".item_only";
            case FLAT:
                return name + ".flat";
            case LABELED:
                return name + ".labeled";
            case LABELED_ITEM_ONLY:
                return name + ".labeled_item_only";
            default:
                return name;
        }
    }

    /** Describes how to switch modes before placing the frame. */
    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advanced)
    {
        lines.add(StatCollector.translateToLocal("tile.display_frame.scroll"));
    }

    /** Places one frame after checking edit permission at both the clicked block and the destination. */
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z,
                             int side, float hitX, float hitY, float hitZ)
    {
        ForgeDirection facing = ForgeDirection.getOrientation(side);
        if (stack.stackSize <= 0 || facing == ForgeDirection.UNKNOWN)
        {
            return false;
        }
        if (canEdit(world, player, stack, x, y, z, side) == false)
        {
            return false;
        }

        BlockDisplayFrame frame = (BlockDisplayFrame) field_150939_a;
        Block clicked = world.getBlock(x, y, z);
        if (clicked.isReplaceable(world, x, y, z) == false)
        {
            x += facing.offsetX;
            y += facing.offsetY;
            z += facing.offsetZ;
        }
        if (canEdit(world, player, stack, x, y, z, side) == false
                || frame.canPlaceBlockOnSide(world, x, y, z, side) == false)
        {
            return false;
        }

        boolean placed = placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, side);
        if (placed == false)
        {
            return false;
        }
        int mode = stack.getItemDamage();
        DisplayStyle style;
        switch (mode)
        {
            case ITEM_ONLY:
                style = DisplayStyle.ITEM_ONLY;
                break;
            case FLAT:
                style = DisplayStyle.FLAT;
                break;
            case LABELED:
                style = DisplayStyle.LABELED;
                break;
            case LABELED_ITEM_ONLY:
                style = DisplayStyle.LABELED_ITEM_ONLY;
                break;
            default:
                style = DisplayStyle.MOUNTED;
                break;
        }
        if (style != DisplayStyle.MOUNTED)
        {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile instanceof TileDisplayFrame)
            {
                ((TileDisplayFrame) tile).setDisplayStyle(style);
            }
        }
        String placementSound = frame.stepSound.func_150496_b();
        float placementVolume = (frame.stepSound.getVolume() + 1.0F) / 2.0F;
        float placementPitch = frame.stepSound.getPitch() * 0.8F;
        world.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, placementSound, placementVolume, placementPitch);
        if (player.capabilities.isCreativeMode == false)
        {
            --stack.stackSize;
        }
        return true;
    }

    private static boolean canEdit(World world, EntityPlayer player, ItemStack stack, int x, int y, int z, int side)
    {
        boolean withinWorldHeight = y >= 0 && y < world.getHeight();
        return withinWorldHeight && world.blockExists(x, y, z)
                && world.canMineBlock(player, x, y, z) && player.canPlayerEdit(x, y, z, side, stack);
    }
}
