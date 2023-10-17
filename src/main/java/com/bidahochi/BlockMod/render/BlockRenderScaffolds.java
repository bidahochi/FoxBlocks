package com.bidahochi.BlockMod.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class BlockRenderScaffolds implements ISimpleBlockRenderingHandler {

    public int renderID;

    public BlockRenderScaffolds(int renderId) {
        this.renderID = renderId;

    }
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        Tessellator tes = Tessellator.instance;
        GL11.glPushMatrix();
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tes.startDrawingQuads();
        tes.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture!=null?renderer.overrideBlockTexture: renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
        tes.draw();
        tes.startDrawingQuads();
        tes.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture!=null?renderer.overrideBlockTexture: renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        tes.draw();
        tes.startDrawingQuads();
        tes.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture!=null?renderer.overrideBlockTexture: renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
        tes.draw();
        tes.startDrawingQuads();
        tes.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture!=null?renderer.overrideBlockTexture: renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
        tes.draw();
        tes.startDrawingQuads();
        tes.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture!=null?renderer.overrideBlockTexture: renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
        tes.draw();
        tes.startDrawingQuads();
        tes.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture!=null?renderer.overrideBlockTexture: renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
        tes.draw();
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        renderer.setRenderBoundsFromBlock(block);
        float f = .015625f;
        float f1 = 0;
        renderer.renderFromInside=true;
        renderer.renderMinX+=block.shouldSideBeRendered(world,x-1,y,z,4)?f:f1;
        renderer.renderMinY+=block.shouldSideBeRendered(world,x,y-1,z,0)?f:f1;
        renderer.renderMinZ+=block.shouldSideBeRendered(world,x,y,z-1,2)?f:f1;
        renderer.renderMaxX-=block.shouldSideBeRendered(world,x+1,y,z,5)?f:f1;
        renderer.renderMaxY-=block.shouldSideBeRendered(world,x,y+1,z,1)?f:f1;
        renderer.renderMaxZ-=block.shouldSideBeRendered(world,x,y,z+1,3)?f:f1;
        renderer.renderStandardBlock(block, x, y, z);
        renderer.renderMinX-=block.shouldSideBeRendered(world,x-1,y,z,4)?f:f1;
        renderer.renderMinY-=block.shouldSideBeRendered(world,x,y-1,z,0)?f:f1;
        renderer.renderMinZ-=block.shouldSideBeRendered(world,x,y,z-1,2)?f:f1;
        renderer.renderMaxX+=block.shouldSideBeRendered(world,x+1,y,z,5)?f:f1;
        renderer.renderMaxY+=block.shouldSideBeRendered(world,x,y+1,z,1)?f:f1;
        renderer.renderMaxZ+=block.shouldSideBeRendered(world,x,y,z+1,3)?f:f1;
        renderer.renderFromInside=false;
        return renderer.renderStandardBlock(block, x, y, z);
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return renderID;
    }
}
