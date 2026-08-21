package com.bidahochi.BlockMod.blocks.props.configurable.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/** Stores the relative controller location for one invisible multiblock part. */
public class TileConfigurablePropPart extends TileEntity
{

    private int controllerOffsetX;
    private int controllerOffsetY;
    private int controllerOffsetZ;

    /**
     * Stores and synchronizes the signed world-cell offset from this part to its
     * controller. Adding these values to the part coordinates locates the owner.
     *
     * @param x signed controller X coordinate minus this part's X coordinate
     * @param y signed controller Y coordinate minus this part's Y coordinate
     * @param z signed controller Z coordinate minus this part's Z coordinate
     */
    public void setControllerOffset(int x, int y, int z)
    {
        controllerOffsetX = x;
        controllerOffsetY = y;
        controllerOffsetZ = z;
        markDirty();
        if (worldObj != null)
        {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

    /**
     * Resolves the owning controller.
     *
     * @return owning controller, or {@code null} when its cell is unloaded or invalid
     */
    public TileConfigurablePropController getController()
    {
        if (worldObj == null)
        {
            return null;
        }
        int controllerX = xCoord + controllerOffsetX;
        int controllerY = yCoord + controllerOffsetY;
        int controllerZ = zCoord + controllerOffsetZ;
        if (worldObj.blockExists(controllerX, controllerY, controllerZ) == false)
        {
            return null;
        }
        TileEntity tile = worldObj.getTileEntity(
                controllerX,
                controllerY,
                controllerZ
        );
        return tile instanceof TileConfigurablePropController
                ? (TileConfigurablePropController) tile
                : null;
    }

    /**
     * Tests whether this part currently resolves to the supplied controller.
     * Structure cleanup uses this explicit relationship so one damaged prop
     * cannot remove a shared part that has since been linked to another prop.
     *
     * @param controller prospective owning controller
     * @return {@code true} when this part resolves to that exact tile instance
     */
    public boolean isOwnedBy(TileConfigurablePropController controller)
    {
        return controller != null && getController() == controller;
    }

    /** {@inheritDoc} */
    @Override
    public boolean canUpdate()
    {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setInteger("ControllerOffsetX", controllerOffsetX);
        tag.setInteger("ControllerOffsetY", controllerOffsetY);
        tag.setInteger("ControllerOffsetZ", controllerOffsetZ);
    }

    /** {@inheritDoc} */
    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        controllerOffsetX = tag.getInteger("ControllerOffsetX");
        controllerOffsetY = tag.getInteger("ControllerOffsetY");
        controllerOffsetZ = tag.getInteger("ControllerOffsetZ");
    }

    /** {@inheritDoc} */
    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    /** {@inheritDoc} */
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        readFromNBT(packet.func_148857_g());
    }
}
