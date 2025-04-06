package com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.TileEntitySpecialRenderer;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.TileEntity.TileBreakerBox2;
import com.bidahochi.BlockMod.render.models.ModelBreakerBox;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
    public class RenderBreakerBox2 extends TileEntitySpecialRenderer {
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