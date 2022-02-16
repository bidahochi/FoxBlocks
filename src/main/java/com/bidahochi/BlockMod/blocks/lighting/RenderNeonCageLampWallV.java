package com.bidahochi.BlockMod.blocks.lighting;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.render.models.ModelNeonCageLight;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
    public class RenderNeonCageLampWallV extends TileEntitySpecialRenderer {
        private ResourceLocation texture = new ResourceLocation(FoxBlocks.MODID, "textures/blocks/lighting/NeonCageLight.png");
        private ModelNeonCageLight model2 = new ModelNeonCageLight();

        @Override
        public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
            if(!(tileEntity instanceof TileNeonCageLampWallV)){return;}
            GL11.glPushMatrix();
            Tessellator.bindTexture(texture);
            //GL11.glTranslated(x + 0.25, y + 0.62, z + 0.45);
            //GL11.glTranslated(x + 0.0, y + 0.62, z + 0.0);

            GL11.glTranslated(x + 0.5, y + 0.52, z + 0.5);

            //GL11.glRotatef(180F, 0F, 1F, 0F);
            //GL11.glRotatef(90F, 0F, 1F, 0F);
            //GL11.glRotatef(-90F, 0F, 0F, 1F);
            GL11.glRotatef(90F, 1F, 0F, 0F);
            int dir = ((TileNeonCageLampWallV)tileEntity).dir;
            //System.out.println(dir);
            switch(dir) {
                case 0:{// north
                    //GL11.glRotated(180,0,0,1);
                    GL11.glTranslated(0.0,-0.12,0.0);
                    break;
                }
                case 3: {//west
                    GL11.glRotated(270,0,0,1);
                    GL11.glTranslated(0.0,-0.12,0.0);
                    break;
                }
                case 1: {//east
                    GL11.glRotated(90,0,0,1);
                    GL11.glTranslated(0.0,-0.12,0.0);
                    break;
                }
                case 2: {//south
                    GL11.glRotated(-180,1,0,0);
                    GL11.glTranslated(0.0,-0.12,0.0);
                    break;
                }
            }
            model2.render(null, 0, 0, 0, 0, 0, 0.0625f);
            GL11.glPopMatrix();
        }
    }