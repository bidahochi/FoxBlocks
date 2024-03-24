package com.bidahochi.BlockMod.blocks.overhead;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.render.models.Overheads.Modelwpole_12_s_curve;
import com.bidahochi.BlockMod.render.models.Overheads.Modelwpole_8_s_curve;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
    public class RenderOverhead_pole_scurve_12 extends TileEntitySpecialRenderer {
        private ResourceLocation texture = new ResourceLocation(FoxBlocks.MODID, "textures/blocks/overheadlines/scurve_3x12.png");
        private Modelwpole_12_s_curve model = new Modelwpole_12_s_curve();

        @Override
        public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
            if(!(tileEntity instanceof TileOverhead_pole_scurve_12)){return;}
            GL11.glPushMatrix();
            Tessellator.bindTexture(texture);
            GL11.glTranslated(x + 0.5, y + 0.62, z + 0.5);
            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glRotatef(-90F, 0F, 1F, 0F);
            int dir = ((TileOverhead_pole_scurve_12)tileEntity).dir;
            switch(dir) {
                case 0:{// north
                    GL11.glRotated(180,0,1,0);
                    //GL11.glTranslated(2,0,-2);
                    break;
                }
                case 3: {//west
                    GL11.glRotated(90,0,1,0);
                    //GL11.glTranslated(2,0,-2);
                    break;
                }
                case 1: {//east
                    GL11.glRotated(270,0,1,0);
                    //GL11.glTranslated(2,0,-2);
                    break;
                }
                case 2: {//south
                    GL11.glRotated(180,0,1,0);
                    GL11.glRotated(180,0,1,0);
                    //GL11.glTranslated(2,0,-2);
                    break;
                }
            }
            model.render(null, 0, 0, 0, 0, 0, 0.0625f);
            GL11.glPopMatrix();
        }
    }