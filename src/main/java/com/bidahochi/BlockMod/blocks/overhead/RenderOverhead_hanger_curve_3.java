package com.bidahochi.BlockMod.blocks.overhead;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.render.models.Overheads.Modelwhanger_3_curve;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
    public class RenderOverhead_hanger_curve_3 extends TileEntitySpecialRenderer {
        private ResourceLocation texture = new ResourceLocation(FoxBlocks.MODID, "textures/blocks/overheadlines/curve_3x3.png");
        private Modelwhanger_3_curve model = new Modelwhanger_3_curve();

        @Override
        public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
            if(!(tileEntity instanceof TileOverhead_hanger_curve_3)){return;}
            GL11.glPushMatrix();
            Tessellator.bindTexture(texture);
            GL11.glTranslated(x + 0.5, y + 0.62, z + 0.5);
            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glRotatef(-90F, 0F, 1F, 0F);
            int dir = ((TileOverhead_hanger_curve_3)tileEntity).dir;
            switch(dir) {
                case 0:{// north
                    GL11.glRotated(180,0,1,0);
                    //GL11.glTranslated(0.75,0,-0.75);
                    break;
                }
                case 3: {//west
                    GL11.glRotated(90,0,1,0);
                    //GL11.glTranslated(0.75,0,-0.75);
                    break;
                }
                case 1: {//east
                    GL11.glRotated(270,0,1,0);
                    //GL11.glTranslated(0.75,0,-0.75);
                    break;
                }
                case 2: {//south
                    GL11.glRotated(180,0,1,0);
                    GL11.glRotated(180,0,1,0);
                    //GL11.glTranslated(0.75,0,-0.75);
                    break;
                }
            }
            model.render(null, 0, 0, 0, 0, 0, 0.0625f);
            GL11.glPopMatrix();
        }
    }