package com.bidahochi.BlockMod.blocks.displayframe;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.Objects;

/** Stores the displayed item, its rotation, and the frame's selected display mode. */
public final class TileDisplayFrame extends TileEntity
{
    /** Number of 45-degree positions in one full turn. */
    public static final int ROTATION_STEPS = 8;
    private ItemStack displayedItem;
    private int rotation;
    private DisplayStyle style = DisplayStyle.MOUNTED;

    /** Frame state changes in response to interactions and does not need tile ticks. */
    @Override
    public boolean canUpdate()
    {
        return false;
    }

    /** Returns the shared stack for read-only rendering, or null when the frame is empty. */
    public ItemStack getDisplayedItem()
    {
        return displayedItem;
    }

    /** Returns the item's rotation in 45-degree steps. */
    public int getRotation()
    {
        return rotation;
    }

    /** Returns whether an occupied frame hides the rim and backing. */
    public boolean isItemOnly()
    {
        return style == DisplayStyle.ITEM_ONLY || style == DisplayStyle.LABELED_ITEM_ONLY;
    }

    /** Returns whether the frame displays the item as a flat sprite. */
    public boolean isFlat()
    {
        return style == DisplayStyle.FLAT;
    }

    /** Returns whether an occupied frame adds a localized item nameplate. */
    public boolean isLabeled()
    {
        return style == DisplayStyle.LABELED || style == DisplayStyle.LABELED_ITEM_ONLY;
    }

    /** Sets and synchronizes the non-null display style selected when placing a frame. */
    public void setDisplayStyle(DisplayStyle style)
    {
        this.style = Objects.requireNonNull(style, "style");
        changed();
    }

    /** Stores a copy of one item, resets its rotation, and syncs the block to the client. */
    public void setDisplayedItem(ItemStack stack)
    {
        ItemStack copy = stack == null ? null : stack.copy();
        if (copy != null)
        {
            copy.stackSize = 1;
        }
        rotation = 0;
        displayedItem = copy;
        changed();
    }

    /** Advances the displayed item 45 degrees and syncs the block to the client. */
    public void rotate()
    {
        rotation = (rotation + 1) % ROTATION_STEPS;
        changed();
    }

    private void changed()
    {
        if (worldObj != null)
        {
            markDirty();
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

    /** Saves the item, rotation, and mode for world storage and client sync. */
    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        ItemStack stack = displayedItem;
        if (stack != null)
        {
            NBTTagCompound itemTag = new NBTTagCompound();
            stack.writeToNBT(itemTag);
            tag.setTag("Item", itemTag);
        }
        else
        {
            tag.removeTag("Item");
        }
        tag.setByte("Rotation", (byte) rotation);
        tag.setBoolean("ItemOnly", isItemOnly());
        tag.setBoolean("Flat", isFlat());
        tag.setBoolean("Labeled", isLabeled());
    }

    /** Loads saved frame data and normalizes the rotation to a 45-degree step index. */
    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        rotation = Math.floorMod(tag.getByte("Rotation"), ROTATION_STEPS);
        boolean labeled = tag.getBoolean("Labeled");
        style = DisplayStyle.MOUNTED;
        if (tag.getBoolean("ItemOnly"))
        {
            style = labeled ? DisplayStyle.LABELED_ITEM_ONLY : DisplayStyle.ITEM_ONLY;
        }
        else if (tag.getBoolean("Flat"))
        {
            style = DisplayStyle.FLAT;
        }
        else if (labeled)
        {
            style = DisplayStyle.LABELED;
        }
        ItemStack loadedItem = null;
        if (tag.hasKey("Item", 10))
        {
            NBTTagCompound itemTag = tag.getCompoundTag("Item");
            loadedItem = ItemStack.loadItemStackFromNBT(itemTag);
        }
        displayedItem = loadedItem;
    }

    /** Sends the complete frame state for new viewers and block updates. */
    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
    }

    /** Applies the server state and invalidates the cached chunk geometry at the frame. */
    @Override
    public void onDataPacket(NetworkManager network, S35PacketUpdateTileEntity packet)
    {
        readFromNBT(packet.func_148857_g());
        worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
    }

    /** The display styles available when placing a frame. */
    public enum DisplayStyle
    {
        /** Shows the rim, backing, and standard item render. */
        MOUNTED,
        /** Hides the rim and backing while an item is present. */
        ITEM_ONLY,
        /** Shows the item as a flat sprite. */
        FLAT,
        /** Adds a nameplate to the standard mounted frame. */
        LABELED,
        /** Shows the item and its nameplate while hiding the occupied frame's rim and backing. */
        LABELED_ITEM_ONLY
    }
}
