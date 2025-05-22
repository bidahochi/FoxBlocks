package com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.TileEntitySpecialRenderer;

import com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover.TileEntity.TileRoadCoverDynamic1X1;
import com.bidahochi.BlockMod.render.models.RoadCovers.ModelRoadCoverDynamic1X1;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderDynamicRoadCover1X1 extends TileEntitySpecialRenderer
{
    private ModelRoadCoverDynamic1X1 model1X1 = new ModelRoadCoverDynamic1X1();
    private String[] roadCoverTexture = new String[2];

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    {
        if(!(tileEntity instanceof TileRoadCoverDynamic1X1))
        {
            return;
        }

        TileRoadCoverDynamic1X1 tileRoadCoverDynamic = ((TileRoadCoverDynamic1X1)tileEntity);
        String texture;
        Block block = Block.getBlockById(tileRoadCoverDynamic.getRoadCoverMaterial());
        IIcon icon = block.getIcon(1, tileRoadCoverDynamic.roadCoverMetadata);

        int colour = block.colorMultiplier(tileRoadCoverDynamic.getWorldObj(), tileRoadCoverDynamic.xCoord, tileRoadCoverDynamic.yCoord- 1, tileRoadCoverDynamic.zCoord);
        if (icon != null)
        {
            texture = icon.getIconName();
        }
        else
        {
            texture = "foxblocks:although";
            //colour = 16777215;
        }

        if (texture.contains(":"))
        {
            roadCoverTexture = texture.split(":", 5);
            roadCoverTexture[0] = roadCoverTexture[0].toLowerCase();
        }
        else
        {
            roadCoverTexture[0] = "minecraft";
            roadCoverTexture[1] = texture;
        }

        float r = (float)(colour >> 16 & 255) / 255.0F;
        float g = (float)(colour >> 8 & 255) / 255.0F;
        float b = (float)(colour & 255) / 255.0F;
        //RenderHelper.disableStandardItemLighting();
        GL11.glPushMatrix();


        GL11.glColor4f(r,g,b,1f);
        Tessellator.bindTexture(new ResourceLocation(roadCoverTexture[0],  "textures/blocks/" + roadCoverTexture[1] +".png"));
        GL11.glTranslated(x, y, z);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        //L11.glShadeModel(GL11.GL_SMOOTH);
        /// Enables lighting that make grass colors
        //L11.glEnable(GL11.GL_LIGHTING);
        //L11.glEnable(GL11.GL_LIGHT0);
        ///GL11.glEnable(GL11.GL_LIGHT1);
        //loatBuffer ambientLight = BufferUtils.createFloatBuffer(4);
        //mbientLight.put(0.0f).put(0.0f).put(0.0f).put(1).flip();
        //L11.glLightModel(GL11.GL_LIGHT_MODEL_AMBIENT, ambientLight);
        //L11.glEnable(GL11.GL_COLOR_MATERIAL);
        //L11.glColorMaterial(GL11.GL_FRONT_AND_BACK, GL11.GL_AMBIENT_AND_DIFFUSE);
        //L11.glColorMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE);
        //L11.glColorMaterial (GL11.GL_FRONT, GL11.GL_DIFFUSE);
        //L11.glColorMaterial (GL11.GL_FRONT, GL11.GL_SPECULAR);


        //GL11.glTexEnvi(GL11.GL_TEXTURE_ENV_COLOR, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_REPLACE);
        //render
        GL11.glTranslated(0,0,0);
        model1X1.render(null, 0, 0, 0, 0, 0, 0.0625f);

        GL11.glPopMatrix();
        GL11.glDisable(GL11.GL_BLEND);
        //GL11.glDisable(GL11.GL_LIGHTING);
        //GL11.glDisable(GL11.GL_LIGHT0);
        //GL11.glDisable(GL11.GL_LIGHT1);
        //GL11.glDisable(GL11.GL_COLOR_MATERIAL);
    }
}
