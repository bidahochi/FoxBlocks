package com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileRoadCover0 extends TileEntity {
    public int dir=0;

    public TileRoadCover0(int dir) {
        super();
        this.dir = dir;
    }

    public TileRoadCover0() {}

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

    public TileRoadCover0 setFacing(int direction){
        dir=(byte) direction;
        this.markDirty();
        return this;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //return AxisAlignedBB.getBoundingBox(xCoord-2, yCoord-1, zCoord-1, xCoord + 1, yCoord + 1, zCoord + 1);

        //int xminus = 1;
        //int zminus = 1;
        //int yminus = 1;
        //int xplus = 1;
        //int zplus = 1;
        //int yplus =1;
        //int aa =1;
        int ecks =0;
        int zee =0;
        int why =0;

        //AxisAlignedBB base = super.getRenderBoundingBox();//i have no idea what im doing

        //negative xCoord is negative Z axis in game?
        //
        switch(dir) {

            case 0:{// north
                zee = -1;
                //System.out.println(dir+" north");
                break;
            }
            case 1: {//east
                ecks = 1;
                //System.out.println(dir+" east");
                break;
            }
            case 2: {//south
                zee = 1;
                //System.out.println(dir+" south");
                break;
            }
            case 3: {//west
                ecks = -1;
                //System.out.println(dir+" west");
                break;
            }
        }
        //System.out.println(dir+" WHAT");

        //return AxisAlignedBB.getBoundingBox(xCoord-1+ecks, yCoord-1, zCoord-1+zee, xCoord + 1+ecks, yCoord + 1, zCoord + 1+zee);
        return AxisAlignedBB.getBoundingBox(xCoord-2+ecks, yCoord-2, zCoord-2+zee, xCoord+2+ecks, yCoord+2, zCoord+2+zee);
    }
    /*@SideOnly(Side.CLIENT) //try to get this working someday
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w
        if (dir==0){// north
            return AxisAlignedBB.getBoundingBox(xCoord-0, yCoord-1, zCoord-1, xCoord+0, yCoord+1, zCoord);
        }else if(dir==1){//east
            return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord-3, xCoord+3, yCoord + 5, zCoord + 1);
        }else if(dir==2){//south
            return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord, zCoord, xCoord + 3, yCoord + 5, zCoord + 3);
        }else{//west
            return AxisAlignedBB.getBoundingBox(xCoord-3, yCoord, zCoord-1, xCoord, yCoord + 5, zCoord + 3);
        }
    }*/

}
