package com.bidahochi.BlockMod.blocks.roadpaints.TileEntitySpecialRenderer;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseTileEntity;
import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * RPB - Road Paint Bloc
 * XX - Position of line, Color of line (ex, CY is Centered, Yellow)
 * X - Line Shape (ex, R - Right Angle, S - Straight, T - Tee Junction, ect)
 */
public class BaseRoadPaintTileEntitySpecialRenderer extends TileEntitySpecialRenderer
{
    private ResourceLocation texture2;
    private ModelConverter model;

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        GL11.glPushMatrix();
        Tessellator.bindTexture(texture2);
        GL11.glTranslated(x + 0.5, y + 0.625, z + 0.5);
        GL11.glRotatef(180F, 1F, 0F, 0F);
        GL11.glRotatef(90F, 0F, 1F, 0F);
        int dir = ((BaseTileEntity)tileEntity).dir;
        switch(dir) {
            case 0:{// north
                GL11.glRotated(180,0,1,0);
                break;
            }
            case 3: {//west
                GL11.glRotated(90,0,1,0);
                break;
            }
            case 1: {//east
                GL11.glRotated(270,0,1,0);
                break;
            }
            case 2: {//south
                GL11.glRotated(180,0,1,0);
                GL11.glRotated(180,0,1,0);
                break;
            }
        }
        Block block = tileEntity.getWorldObj().getBlock(tileEntity.xCoord,tileEntity.yCoord-1,tileEntity.zCoord);
        if(block instanceof BlockSlab &&  ((BlockSlab)block).renderAsNormalBlock() == false)
        {
            GL11.glTranslatef(0, 0.5f, 0);
        }
        model.render(null, 0, 0, 0, 0, 0, 0.0625f);
        GL11.glPopMatrix();
    }

    public void setModel(ModelConverter model)
    {
        this.model = model;
    }

    public void setTexture2(String nameOfTexture)
    {
        texture2 =  new ResourceLocation(FoxBlocks.MODID, "textures/blocks/roadpaints/" + nameOfTexture);
    }
}
