package com.bidahochi.BlockMod.blocks.props;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileWaysideWarningSignRed extends BaseTileEntity
{
    public TileWaysideWarningSignRed(int dir)
    {
        super(dir);
    }

    public TileWaysideWarningSignRed()
    {

    }
}
