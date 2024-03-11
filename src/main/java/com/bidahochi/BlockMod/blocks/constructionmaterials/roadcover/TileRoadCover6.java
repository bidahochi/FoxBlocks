package com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileRoadCover6 extends TileEntity {
    public int dir=0;

    public TileRoadCover6(int dir) {
        super();
        this.dir = dir;
    }

    public TileRoadCover6() {}

    @Override
    public boolean shouldRenderInPass(int pass){ return pass==0; }


    @Override
    public S35PacketUpdateTileEntity getDescriptionPacket() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, nbttagcompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        if(pkt ==null){return;}
        readFromNBT(pkt.func_148857_g());
        markDirty();
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag);
        tag.setInteger("direction", dir);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag){
        super.readFromNBT(tag);
        //System.out.println("WHATTHEFUCK");
        dir = tag.getInteger("direction");
        if(worldObj!=null && worldObj.isRemote) {
            markDirty();
        }
    }

    public TileRoadCover6 setFacing(int direction){
        dir=(byte) direction;
        this.markDirty();
        return this;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        int ecks =0;
        int zee =0;
        int why =0;

        switch(dir) {

            case 0:{// north
                zee = -1;
                break;
            }
            case 1: {//east
                ecks = 1;
                break;
            }
            case 2: {//south
                zee = 1;
                break;
            }
            case 3: {//west
                ecks = -1;
                break;
            }
        }
        return AxisAlignedBB.getBoundingBox(xCoord-2+ecks, yCoord-2, zCoord-2+zee, xCoord+2+ecks, yCoord+2, zCoord+2+zee);
    }

}
