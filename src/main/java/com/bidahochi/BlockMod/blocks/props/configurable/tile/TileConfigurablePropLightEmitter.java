package com.bidahochi.BlockMod.blocks.props.configurable.tile;

import com.bidahochi.BlockMod.blocks.props.configurable.lighting.ConfigurablePropLightRelightHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

/**
 * Caches derived emission for one authored multiblock light cell. The controller
 * remains authoritative; the cache lets Minecraft query light without resolving
 * another tile and remains usable while the controller's chunk is unavailable.
 */
public final class TileConfigurablePropLightEmitter extends TileConfigurablePropPart
{

    private int emittedLightLevel;

    /**
     * Returns the cached vanilla block-light level.
     *
     * @return emitted light from 0 through 15
     */
    public int getEmittedLightLevel()
    {
        return emittedLightLevel;
    }

    /**
     * Updates, synchronizes, and relights this derived emitter cache.
     *
     * @param lightLevel requested vanilla block-light level; clamped from 0 to 15
     */
    public void setEmittedLightLevel(int lightLevel)
    {
        int clampedLightLevel = Math.max(0, Math.min(15, lightLevel));
        if (emittedLightLevel == clampedLightLevel)
        {
            return;
        }
        emittedLightLevel = clampedLightLevel;
        markDirty();
        if (worldObj != null)
        {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            ConfigurablePropLightRelightHelper.request(worldObj, xCoord, yCoord, zCoord);
        }
    }

    /**
     * Reconciles the cached level with an available controller and requests one
     * light recalculation. A missing controller leaves the last saved level.
     */
    public void refreshLightEmission()
    {
        TileConfigurablePropController controller = getController();
        if (controller != null)
        {
            int controllerLightLevel = controller.getLightLevelAtRelativeOffset(
                    xCoord - controller.xCoord,
                    yCoord - controller.yCoord,
                    zCoord - controller.zCoord
            );
            if (emittedLightLevel != controllerLightLevel)
            {
                setEmittedLightLevel(controllerLightLevel);
                return;
            }
        }
        ConfigurablePropLightRelightHelper.request(worldObj, xCoord, yCoord, zCoord);
    }

    /** {@inheritDoc} */
    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setInteger("EmittedLightLevel", emittedLightLevel);
    }

    /** {@inheritDoc} */
    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        emittedLightLevel = Math.max(0, Math.min(15, tag.getInteger("EmittedLightLevel")));
    }

    /** Applies synchronized cache state before recalculating client block light. */
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        readFromNBT(packet.func_148857_g());
        ConfigurablePropLightRelightHelper.request(worldObj, xCoord, yCoord, zCoord);
    }
}
