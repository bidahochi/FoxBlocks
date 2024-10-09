package com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover;

import com.bidahochi.BlockMod.render.models.ModelRoadCover;
import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RenderDynamicRoadCover extends TileEntitySpecialRenderer
{
    private ModelRoadCoverDynamic model = new ModelRoadCoverDynamic();
    private String[] roadCoverTexture = new String[2];

    public class ModelRoadCoverDynamic extends ModelConverter //Same as Filename
    {
        int textureX = 16;
        int textureY = 16;

        public ModelRoadCoverDynamic() //Same as Filename
        {
            bodyModel = new ModelRendererTurbo[2];
            bodyModel[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 0
            bodyModel[0].addBox(0F, 0F, 0F, 16, 1, 16, 0F); // Box 0
            bodyModel[0].setRotationPoint(-8F, 9F, -8F);
            bodyModel[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 1
            bodyModel[1].addBox(0F, 0F, 0F, 16, 1, 16, 0F); // Box 1
            bodyModel[1].setRotationPoint(8F, 9F, -8F);

            translateAll(0F, 0F, 0F);


            flipAll();
        }
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    {
        if(!(tileEntity instanceof TileRoadCoverDynamic))
        {
            return;
        }

        TileRoadCoverDynamic tileRoadCoverDynamic = ((TileRoadCoverDynamic)tileEntity);
        String texture;
        Block block = Block.getBlockById(tileRoadCoverDynamic.getRoadCoverMaterial());
        IIcon icon = block.getIcon(1, tileRoadCoverDynamic.roadCoverMetadata);



        int colour = block.colorMultiplier(tileRoadCoverDynamic.getWorldObj(), tileRoadCoverDynamic.xCoord, tileRoadCoverDynamic.yCoord- 1, tileRoadCoverDynamic.zCoord);

        System.out.println(colour + "colour");
        if (icon != null) {
            texture = icon.getIconName();
        }
        else {
            texture = "tc:ballast_test";
            colour = 16777215;
        }

        if (texture.contains(":")) {
            roadCoverTexture = texture.split(":", 5);
        }
        else {
            roadCoverTexture[0] = "minecraft";
            roadCoverTexture[1] = texture;
        }



        float r = (float)(colour >> 16 & 255) / 255.0F;
        float g = (float)(colour >> 8 & 255) / 255.0F;
        float b = (float)(colour & 255) / 255.0F;
        GL11.glPushMatrix();
        GL11.glColor4f(r,g,b,1f);
        Tessellator.bindTexture(new ResourceLocation(roadCoverTexture[0],  "textures/blocks/" + roadCoverTexture[1] +".png"));
        GL11.glTranslated(x + 0.25, y + 0.625, z + 0.5);
        GL11.glRotatef(180F, 1F, 0F, 0F);
        GL11.glRotatef(90F, 0F, 1F, 0F);
        // GL11.glTranslated(x + 0.25, y - 1, z + 0.5);
        //GL11.glTranslated(x, y - 1, z);
        //GL11.glTranslated(5, 0 , 0);
        //System.out.println(dir);
        switch(tileRoadCoverDynamic.dir) {
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
        GL11.glEnable(GL11.GL_BLEND);

        //render
        model.render(null, 0, 0, 0, 0, 0, 0.0625f);
        GL11.glPopMatrix();


    }
}