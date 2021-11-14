package com.bidahochi.BlockMod.blocks.constructionmaterials;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.render.models.ModelBreakerBox;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
    public class RenderBreakerBox extends TileEntitySpecialRenderer {
        private ResourceLocation texture = new ResourceLocation(FoxBlocks.MODID, "textures/blocks/constructionmaterials/breakerbox/breakerbox.png");
        private ModelBreakerBox breakerBox = new ModelBreakerBox();

        @Override
        public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
            if(!(tileEntity instanceof TileBreakerBox)){return;}
            GL11.glPushMatrix();
            Tessellator.bindTexture(texture);
            GL11.glTranslated(x + 0.25, y, z + 0.5);
            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glRotatef(90F, 0F, 1F, 0F);
           // GL11.glTranslated(x + 0.25, y - 1, z + 0.5);
            //GL11.glTranslated(x, y - 1, z);
            //GL11.glTranslated(5, 0 , 0);
            int dir = ((TileBreakerBox)tileEntity).dir;
            //System.out.println(dir);
            switch(dir) {
                case 0:{//west // north
                    //GL11.glRotated(180,0,0,1);
                    GL11.glRotated(180,0,1,0);
                   // GL11.glTranslated(-0.5,0,0.0);//to be centered
                    GL11.glTranslated(-0.0,0,-0.25);
                    break;
                }
                case 3: {//south? //west
                    //-GL11.glRotatef(180F, 1F, 0F, 0F);
                    //GL11.glRotatef(0F, 1F, 0F, 1F);
                    //GL11.glRotated(180,0,1,0);
                    GL11.glRotated(90,0,1,0);
                   // GL11.glTranslated(-0.25,0,0.25);//to be centered
                    GL11.glTranslated(-0.25,0,0.0);
                    break;
                }
                case 1: {//north //east
                    //-GL11.glRotatef(180F, 1F, 0F, 1F);
                    //GL11.glRotatef(0F, 1F, 0F, 1F);
                    //GL11.glRotated(180,0,0,1);
                    GL11.glRotated(270,0,1,0);
                    //GL11.glTranslated(-0.25,0,-0.25);//to be centered
                    GL11.glTranslated(0.25,0,-0.0);
                    break;
                }
                case 2: {//east //south
                    //-GL11.glRotatef(180, 1, 0, 0);
                   // GL11.glRotatef(90, 0, 0, 1);
                   // GL11.glRotatef(180, 1F, 0F, 0F);
                    //-GL11.glRotatef(180, -1F, 0F, 0F);
                    //GL11.glRotatef(0F, 1F, 0F, 1F);
                    GL11.glRotated(180,0,1,0);
                    GL11.glRotated(180,0,1,0);
                    //GL11.glRotated(90,0,0,1);
                    //GL11.glTranslated(0,0,0);//to be centered
                    GL11.glTranslated(0.0,0,0.25);
                    break;
                }
            }

            //GL11.glTranslated(-5, 0 , 0);
            breakerBox.render(null, 0, 0, 0, 0, 0, 0.0625f);
            GL11.glPopMatrix();
        }
    }