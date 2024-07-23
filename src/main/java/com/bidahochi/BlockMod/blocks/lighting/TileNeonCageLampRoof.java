package com.bidahochi.BlockMod.blocks.lighting;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileNeonCageLampRoof extends BaseTileEntity
{
    public TileNeonCageLampRoof(int dir)
    {
        super(dir);
    }

    public TileNeonCageLampRoof()
    {

    }
}
