package com.bidahochi.BlockMod.blocks.lighting;


import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileExteriorLightSquare2 extends BaseTileEntity
{
    public TileExteriorLightSquare2(int dir)
    {
        super(dir);
    }

    public TileExteriorLightSquare2()
    {

    }
}
