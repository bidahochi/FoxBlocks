package com.bidahochi.BlockMod.blocks.constructionmaterials;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.render.models.ModelBreakerBox;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileBreakerBox2 extends TileEntity {
    public int dir=0;

    public TileBreakerBox2(int dir) {
        super();
        this.dir = dir;
    }

    public TileBreakerBox2() {}

    @Override
    public boolean shouldRenderInPass(int pass){
        return pass==0;
    }

    @SideOnly(Side.CLIENT)
    public static class RenderBreakerBox2 extends TileEntitySpecialRenderer {
        private ResourceLocation texture = new ResourceLocation(FoxBlocks.MODID, "textures/blocks/constructionmaterials/breakerbox/breakerbox.png");
        private ModelBreakerBox breakerBox = new ModelBreakerBox();

        @Override
        public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
            if(!(tileEntity instanceof TileBreakerBox2)){return;}
            GL11.glPushMatrix();
            Tessellator.bindTexture(texture);
            GL11.glTranslated(x + 0.25, y, z + 0.5);
            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glRotatef(90F, 0F, 1F, 0F);

            int dir = ((TileBreakerBox2)tileEntity).dir;
            //System.out.println(dir);
            switch(dir) {
                case 0:{//north
                    GL11.glRotated(180,0,1,0);
                    GL11.glTranslated(0.375,0,-0.25);
                    break;
                }
                case 3: {//west
                    GL11.glRotated(90,0,1,0);
                    GL11.glTranslated(0.125,0,0.0);
                    break;
                }
                case 1: {//east
                    GL11.glRotated(270,0,1,0);
                    GL11.glTranslated(0.625,0,-0.0);
                    break;
                }
                case 2: {//south
                    GL11.glTranslated(0.375,0,0.25);
                    break;
                }
            }

            //GL11.glTranslated(-5, 0 , 0);
            breakerBox.render(null, 0, 0, 0, 0, 0, 0.0625f);
            GL11.glPopMatrix();
        }
    }
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

    public TileBreakerBox2 setFacing(int direction){
        dir=(byte) direction;
        this.markDirty();
        return this;
    }

}
