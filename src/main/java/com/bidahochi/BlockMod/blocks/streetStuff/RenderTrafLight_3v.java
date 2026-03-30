package com.bidahochi.BlockMod.blocks.streetStuff;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.render.models.Street.ModeltrafLight_3v;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import com.bidahochi.BlockMod.render.tmt.Vec3f;
import com.bidahochi.BlockMod.utils.HelperUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
    public class RenderTrafLight_3v extends TileEntitySpecialRenderer {
        private ResourceLocation texture2 = new ResourceLocation(FoxBlocks.MODID, "textures/blocks/streetstuff/trafLight_3v_black.png");
        private ModeltrafLight_3v model = new ModeltrafLight_3v();

        @Override
        public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
            if(!(tileEntity instanceof TileTrafLight_3v)){return;}
            GL11.glPushMatrix();
            Tessellator.bindTexture(texture2);
            GL11.glTranslated(x + 0.5, y + 0.62, z + 0.5);
            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glRotatef(90F, 0F, 1F, 0F);
            int dir = ((TileTrafLight_3v)tileEntity).dir;
            Block block = tileEntity.getWorldObj().getBlock(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord-1);
            Vec3f blockPos = new Vec3f(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord-1);
            switch(dir) {
                case 0:{//north
                    GL11.glRotated(180,0,1,0);
                    break;
                }
                case 3: {//west
                    block = tileEntity.getWorldObj().getBlock(tileEntity.xCoord-1, tileEntity.yCoord, tileEntity.zCoord);
                    blockPos = new Vec3f(tileEntity.xCoord-1, tileEntity.yCoord, tileEntity.zCoord);
                    GL11.glRotated(90,0,1,0);
                    break;
                }
                case 1: {//east
                    block = tileEntity.getWorldObj().getBlock(tileEntity.xCoord+1, tileEntity.yCoord, tileEntity.zCoord);
                    blockPos = new Vec3f(tileEntity.xCoord+1, tileEntity.yCoord, tileEntity.zCoord);
                    GL11.glRotated(270,0,1,0);
                    break;
                }
                case 2: {//south
                    block = tileEntity.getWorldObj().getBlock(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord+1);
                    blockPos = new Vec3f(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord+1);
                    GL11.glRotated(180,0,1,0);
                    GL11.glRotated(180,0,1,0);
                    break;
                }
            }
            if (HelperUtils.isFence(tileEntity.getWorldObj(), (int) blockPos.xCoord, (int) blockPos.yCoord, (int) blockPos.zCoord, block)) {
                GL11.glTranslatef(0.375f, 0, 0);
            }
            if (block instanceof BlockWall) {
                GL11.glTranslatef(0.25f,0,0);
            }
            if (block instanceof Pole || block instanceof PoleHorizontal || block instanceof PoleTransition) {//foxblock pole parts mwahaha
                GL11.glTranslatef(0.435f,0,0);
                if (block instanceof Pole || block instanceof PoleTransition){
                    GL11.glTranslatef(0,0.25f,0);
                }
            }
            if (block instanceof PoleDiag || block instanceof PoleTransitionDiag || block instanceof PoleHorizontalDiag) {//diagonal poles
                GL11.glTranslatef(0.435f,0,0);
                if (block instanceof PoleDiag || block instanceof PoleTransitionDiag){
                    GL11.glTranslatef(0,0.25f,0);
                }
            }

            model.render(null, 0, 0, 0, 0, 0, 0.0625f);
            GL11.glPopMatrix();
        }
    }