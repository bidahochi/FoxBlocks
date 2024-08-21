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
    public class RenderUnWrappedWood8 extends TileEntitySpecialRenderer {
        private ResourceLocation texture = new ResourceLocation(FoxBlocks.MODID, "textures/blocks/lumber/unwrappedwood/UnwrappedWood_redwood.png");
        private Modelwrappedwood model = new Modelwrappedwood();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        if(!(tileEntity instanceof TileUnWrappedWood8)){return;}
        GL11.glPushMatrix();
        Tessellator.bindTexture(texture);

        GL11.glTranslated(x + 0.5, y + 0.62, z + 0.5);
        GL11.glRotatef(180F, 1F, 0F, 0F);
        GL11.glRotatef(90F, 0F, 1F, 0F);

        int dir = ((TileUnWrappedWood8)tileEntity).dir;
        //System.out.println(dir);
        switch(dir) {
            case 0:{//west // north
                GL11.glRotated(180,0,1,0);
                break;
            }
            case 3: {//south? //west
                GL11.glRotated(90,0,1,0);
                break;
            }
            case 1: {//north //east
                GL11.glRotated(270,0,1,0);
                break;
            }
            case 2: {//east //south
                GL11.glRotated(180,0,1,0);
                GL11.glRotated(180,0,1,0);
                break;
            }
        }
        model.render(null, 0, 0, 0, 0, 0, 0.0625f);
        GL11.glPopMatrix();
    }
    }