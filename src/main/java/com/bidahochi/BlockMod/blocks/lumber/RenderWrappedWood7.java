package com.bidahochi.BlockMod.blocks.lumber;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.render.models.Modelwrappedwood;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
    public class RenderWrappedWood7 extends TileEntitySpecialRenderer {
        private final ResourceLocation texture = new ResourceLocation(FoxBlocks.MODID, "textures/blocks/lumber/wrappedwood/WrappedWood3_Thick_n_Thin_Straps.png");
        private final Modelwrappedwood model = new Modelwrappedwood();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        if(!(tileEntity instanceof TileWrappedWood7)){return;}
        GL11.glPushMatrix();
        Tessellator.bindTexture(texture);

        GL11.glTranslated(x + 0.5, y + 0.62, z + 0.5);
        GL11.glRotatef(180F, 1F, 0F, 0F);
        GL11.glRotatef(90F, 0F, 1F, 0F);

        int dir = ((TileWrappedWood7)tileEntity).dir;
        //System.out.println(dir);
        switch(dir) {
            case 0:{//west // north
                GL11.glRotated(180,0,1,0);
                //GL11.glTranslated(-0.05,0,-0.3);
                break;
            }
            case 3: {//south? //west
                GL11.glRotated(90,0,1,0);
                // GL11.glTranslated(-0.25,0,0.0);
                break;
            }
            case 1: {//north //east
                GL11.glRotated(270,0,1,0);
                //  GL11.glTranslated(0.25,0,-0.1);
                break;
            }
            case 2: {//east //south
                GL11.glRotated(180,0,1,0);
                GL11.glRotated(180,0,1,0);
                // GL11.glTranslated(0.05,0,0.2);
                break;
            }
        }
        model.render(null, 0, 0, 0, 0, 0, 0.0625f);
        GL11.glPopMatrix();
    }
    }