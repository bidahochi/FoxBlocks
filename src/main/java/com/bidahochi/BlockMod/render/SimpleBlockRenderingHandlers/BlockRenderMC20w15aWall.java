package com.bidahochi.BlockMod.render.SimpleBlockRenderingHandlers;

import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseBlockWall;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class BlockRenderMC20w15aWall implements ISimpleBlockRenderingHandler
{
    public int renderID;

    public BlockRenderMC20w15aWall(int renderId)
    {
        this.renderID = renderId;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int i1, RenderBlocks renderBlocks)
    {
        float f = 0.3F;
        float f1 = 0.7F;

        renderBlocks.setRenderBounds(f, 0.0D, f, f1, 1.0D, f1);
        renderInvBlock(block, metadata, renderBlocks);

        f = 0.325F;
        f1 = 0.675F;
        float f2 = 0F;
        float f3 = 0.8F;
        // float f4 = 0.0F;
        // float f5 = 1.0F;
        float f6 = 0.0F;
        float f7 = 1.5F;

        renderBlocks.setRenderBounds(f - 0.001, f2, f6, f1 - 0.001, f3, 5 * (double) f7 / 8);
        renderInvBlock(block, metadata, renderBlocks);
    }

    public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
        Tessellator var14 = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        var14.startDrawingQuads();
        var14.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, m));
        var14.draw();
        var14.startDrawingQuads();
        var14.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, m));
        var14.draw();
        var14.startDrawingQuads();
        var14.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, m));
        var14.draw();
        var14.startDrawingQuads();
        var14.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, m));
        var14.draw();
        var14.startDrawingQuads();
        var14.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, m));
        var14.draw();
        var14.startDrawingQuads();
        var14.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, m));
        var14.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iBlockAccess, int x, int y, int z, Block block, int i3, RenderBlocks renderBlocks)
    {
        BaseBlockWall wallBlock = (BaseBlockWall) block;

        boolean flag0 = wallBlock.canConnectWallTo(renderBlocks.blockAccess, x - 1, y, z);
        boolean flag1 = wallBlock.canConnectWallTo(renderBlocks.blockAccess, x + 1, y, z);
        boolean flag2 = wallBlock.canConnectWallTo(renderBlocks.blockAccess, x, y, z - 1);
        boolean flag3 = wallBlock.canConnectWallTo(renderBlocks.blockAccess, x, y, z + 1);
        boolean flag4 = flag2 && flag3 && !flag0 && !flag1;
        boolean flag5 = !flag2 && !flag3 && flag0 && flag1;
        boolean isBlockAboveAir = renderBlocks.blockAccess.isAirBlock(x, y + 1, z);

        // These up flags help us tell if we should raise the wall to meet the block above it
        boolean flagUp = wallBlock.canConnectWallTo(renderBlocks.blockAccess, x, y + 1, z);

        boolean flag0Up = wallBlock.canConnectWallTo(renderBlocks.blockAccess, x - 1, y + 1, z);
        boolean flag1Up = wallBlock.canConnectWallTo(renderBlocks.blockAccess, x + 1, y + 1, z);
        boolean flag2Up = wallBlock.canConnectWallTo(renderBlocks.blockAccess, x, y + 1, z - 1);
        boolean flag3Up = wallBlock.canConnectWallTo(renderBlocks.blockAccess, x, y + 1, z + 1);
        boolean flag4Up = flag2Up && flag3Up;
        boolean flag5Up = flag0Up && flag1Up;

        if ((flag4 && flag4Up || flag5 && flag5Up) && flagUp) {
            if (flag4) {
                renderBlocks.setRenderBounds(0.3125D, 0.0D, 0.0D, 0.6875D, 1.0D, 1.0D);
                renderBlocks.renderStandardBlock(wallBlock, x, y, z);
            } else {
                renderBlocks.setRenderBounds(0.0D, 0.0D, 0.3125D, 1.0D, 1.0D, 0.6875D);
                renderBlocks.renderStandardBlock(wallBlock, x, y, z);
            }
        } else if ((flag4 || flag5) && isBlockAboveAir) {
            if (flag4) {
                renderBlocks.setRenderBounds(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 1.0D);
                renderBlocks.renderStandardBlock(wallBlock, x, y, z);
            } else {
                renderBlocks.setRenderBounds(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
                renderBlocks.renderStandardBlock(wallBlock, x, y, z);
            }
        } else {
            renderBlocks.setRenderBounds(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
            renderBlocks.renderStandardBlock(wallBlock, x, y, z);

            if (flag0) {
                if (flagUp && flag0Up) {
                    renderBlocks.setRenderBounds(0.0D, 0.0D, 0.3125D, 0.25D, 1.0D, 0.6875D);
                } else {
                    renderBlocks.setRenderBounds(0.0D, 0.0D, 0.3125D, 0.25D, 0.8125D, 0.6875D);
                }
                renderBlocks.renderStandardBlock(wallBlock, x, y, z);
            }

            if (flag1) {
                if (flagUp && flag1Up) {
                    renderBlocks.setRenderBounds(0.75D, 0.0D, 0.3125D, 1.0D, 1.0D, 0.6875D);
                } else {
                    renderBlocks.setRenderBounds(0.75D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
                }
                renderBlocks.renderStandardBlock(wallBlock, x, y, z);
            }

            if (flag2) {
                if (flagUp && flag2Up) {
                    renderBlocks.setRenderBounds(0.3125D, 0.0D, 0.0D, 0.6875D, 1.0D, 0.25D);
                } else {
                    renderBlocks.setRenderBounds(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 0.25D);
                }
                renderBlocks.renderStandardBlock(wallBlock, x, y, z);
            }

            if (flag3) {
                if (flagUp && flag3Up) {
                    renderBlocks.setRenderBounds(0.3125D, 0.0D, 0.75D, 0.6875D, 1.0D, 1.0D);
                } else {
                    renderBlocks.setRenderBounds(0.3125D, 0.0D, 0.75D, 0.6875D, 0.8125D, 1.0D);
                }
                renderBlocks.renderStandardBlock(wallBlock, x, y, z);
            }
        }

        wallBlock.setBlockBoundsBasedOnState(renderBlocks.blockAccess, x, y, z);
        return true;
    }



    @Override
    public boolean shouldRender3DInInventory(int i)
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return renderID;
    }
}
