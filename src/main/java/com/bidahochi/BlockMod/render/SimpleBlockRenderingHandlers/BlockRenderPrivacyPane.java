package com.bidahochi.BlockMod.render.SimpleBlockRenderingHandlers;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.src.FMLRenderAccessLibrary;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class BlockRenderPrivacyPane implements ISimpleBlockRenderingHandler
{

    public int renderID;

    public BlockRenderPrivacyPane(int renderId)
    {
        this.renderID = renderId;

    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        Tessellator tes = Tessellator.instance;
        GL11.glPushMatrix();
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tes.startDrawingQuads();
        tes.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture != null ? renderer.overrideBlockTexture : renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
        tes.draw();
        tes.startDrawingQuads();
        tes.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture != null ? renderer.overrideBlockTexture : renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        tes.draw();
        tes.startDrawingQuads();
        tes.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture != null ? renderer.overrideBlockTexture : renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
        tes.draw();
        tes.startDrawingQuads();
        tes.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture != null ? renderer.overrideBlockTexture : renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
        tes.draw();
        tes.startDrawingQuads();
        tes.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture != null ? renderer.overrideBlockTexture : renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
        tes.draw();
        tes.startDrawingQuads();
        tes.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.overrideBlockTexture != null ? renderer.overrideBlockTexture : renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
        tes.draw();
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        int l = blockAccess.getHeight();
        BlockPane blockPane = (BlockPane) block;
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(blockPane.getMixedBrightnessForBlock(blockAccess, x, y, z));
        //int i1 = 16777215;
        int i1 = blockPane.colorMultiplier(blockAccess, x, y, z);
        float f = (float) (i1 >> 16 & 255) / 255.0F;//was i1
        float f1 = (float) (i1 >> 8 & 255) / 255.0F;//was i1
        float f2 = (float) (i1 & 255) / 255.0F;//was i1
        // using >> indicates shifting the BITS of the number over by the number to the rights amount (signed right shift operator)
        //aka if x = -4 then doing x >> 1 moves the number 1 bit over, making -2
            float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
            float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
            float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
            f = f3;
            f1 = f4;
            f2 = f5;

        tessellator.setColorOpaque_F(f, f1, f2);
        boolean flag5 = blockPane instanceof BlockStainedGlassPane;
        IIcon iicon;
        IIcon iicon1;
        if (renderer.hasOverrideBlockTexture()) {
            iicon = renderer.overrideBlockTexture;
            iicon1 = renderer.overrideBlockTexture;
        } else {
            int j1 = blockAccess.getBlockMetadata(x, y, z);
            iicon = renderer.getBlockIconFromSideAndMetadata(blockPane, 0, j1);
            iicon1 = flag5 ? ((BlockStainedGlassPane)blockPane).func_150104_b(j1) : ((BlockPane)blockPane).func_150097_e();
        }
        //tessellator.setBrightness(200);

        double d22 = (double)iicon.getMinU();
        double d0 = (double)iicon.getInterpolatedU(7.0D);
        double d1 = (double)iicon.getInterpolatedU(9.0D);
        double d2 = (double)iicon.getMaxU();
        double d3 = (double)iicon.getMinV();
        double d4 = (double)iicon.getMaxV();
        double d5 = (double)iicon1.getInterpolatedU(7.0D);
        double d6 = (double)iicon1.getInterpolatedU(9.0D);
        double d7 = (double)iicon1.getMinV();
        double d8 = (double)iicon1.getMaxV();
        double d9 = (double)iicon1.getInterpolatedV(7.0D);
        double d10 = (double)iicon1.getInterpolatedV(9.0D);
        double d11 = (double)x;
        double d12 = (double)(x + 1);
        double d13 = (double)z;
        double d14 = (double)(z + 1);
        double d15 = (double)x + 0.5D - 0.0625D;
        double d16 = (double)x + 0.5D + 0.0625D;
        double d17 = (double)z + 0.5D - 0.0625D;
        double d18 = (double)z + 0.5D + 0.0625D;
        boolean flag = ((BlockPane)blockPane).canPaneConnectTo(blockAccess, x, y, z - 1, ForgeDirection.NORTH);
        boolean flag1 = ((BlockPane)blockPane).canPaneConnectTo(blockAccess, x, y, z + 1, ForgeDirection.SOUTH);
        boolean flag2 = ((BlockPane)blockPane).canPaneConnectTo(blockAccess, x - 1, y, z, ForgeDirection.WEST);
        boolean flag3 = ((BlockPane)blockPane).canPaneConnectTo(blockAccess, x + 1, y, z, ForgeDirection.EAST);
        double d19 = 0.001D;
        double d20 = 0.999D;
        double d21 = 0.001D;
        boolean flag4 = !flag && !flag1 && !flag2 && !flag3;
        if (!flag2 && !flag4) {
            if (!flag && !flag1) {
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d0, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d1, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d1, d3);
            }
        } else if (flag2 && flag3) {
            if (!flag) {
                tessellator.addVertexWithUV(d12, (double)y + 0.999D, d17, d2, d3);
                tessellator.addVertexWithUV(d12, (double)y + 0.001D, d17, d2, d4);
                tessellator.addVertexWithUV(d11, (double)y + 0.001D, d17, d22, d4);
                tessellator.addVertexWithUV(d11, (double)y + 0.999D, d17, d22, d3);
            } else {
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d0, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d11, (double)y + 0.001D, d17, d22, d4);
                tessellator.addVertexWithUV(d11, (double)y + 0.999D, d17, d22, d3);
                tessellator.addVertexWithUV(d12, (double)y + 0.999D, d17, d2, d3);
                tessellator.addVertexWithUV(d12, (double)y + 0.001D, d17, d2, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d1, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d1, d3);
            }

            if (!flag1) {
                tessellator.addVertexWithUV(d11, (double)y + 0.999D, d18, d22, d3);
                tessellator.addVertexWithUV(d11, (double)y + 0.001D, d18, d22, d4);
                tessellator.addVertexWithUV(d12, (double)y + 0.001D, d18, d2, d4);
                tessellator.addVertexWithUV(d12, (double)y + 0.999D, d18, d2, d3);
            } else {
                tessellator.addVertexWithUV(d11, (double)y + 0.999D, d18, d22, d3);
                tessellator.addVertexWithUV(d11, (double)y + 0.001D, d18, d22, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d0, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d0, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d1, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d1, d4);
                tessellator.addVertexWithUV(d12, (double)y + 0.001D, d18, d2, d4);
                tessellator.addVertexWithUV(d12, (double)y + 0.999D, d18, d2, d3);
            }

            tessellator.addVertexWithUV(d11, (double)y + 0.999D, d18, d6, d7);
            tessellator.addVertexWithUV(d12, (double)y + 0.999D, d18, d6, d8);
            tessellator.addVertexWithUV(d12, (double)y + 0.999D, d17, d5, d8);
            tessellator.addVertexWithUV(d11, (double)y + 0.999D, d17, d5, d7);
            tessellator.addVertexWithUV(d12, (double)y + 0.001D, d18, d5, d8);
            tessellator.addVertexWithUV(d11, (double)y + 0.001D, d18, d5, d7);
            tessellator.addVertexWithUV(d11, (double)y + 0.001D, d17, d6, d7);
            tessellator.addVertexWithUV(d12, (double)y + 0.001D, d17, d6, d8);
        } else {
            if (!flag && !flag4) {
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d1, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d1, d4);
                tessellator.addVertexWithUV(d11, (double)y + 0.001D, d17, d22, d4);
                tessellator.addVertexWithUV(d11, (double)y + 0.999D, d17, d22, d3);
            } else {
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d0, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d11, (double)y + 0.001D, d17, d22, d4);
                tessellator.addVertexWithUV(d11, (double)y + 0.999D, d17, d22, d3);
            }

            if (!flag1 && !flag4) {
                tessellator.addVertexWithUV(d11, (double)y + 0.999D, d18, d22, d3);
                tessellator.addVertexWithUV(d11, (double)y + 0.001D, d18, d22, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d1, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d1, d3);
            } else {
                tessellator.addVertexWithUV(d11, (double)y + 0.999D, d18, d22, d3);
                tessellator.addVertexWithUV(d11, (double)y + 0.001D, d18, d22, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d0, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d0, d3);
            }

            tessellator.addVertexWithUV(d11, (double)y + 0.999D, d18, d6, d7);
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d6, d9);
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d5, d9);
            tessellator.addVertexWithUV(d11, (double)y + 0.999D, d17, d5, d7);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d5, d9);
            tessellator.addVertexWithUV(d11, (double)y + 0.001D, d18, d5, d7);
            tessellator.addVertexWithUV(d11, (double)y + 0.001D, d17, d6, d7);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d6, d9);
        }

        if ((flag3 || flag4) && !flag2) {
            if (!flag1 && !flag4) {
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d0, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d0, d4);
                tessellator.addVertexWithUV(d12, (double)y + 0.001D, d18, d2, d4);
                tessellator.addVertexWithUV(d12, (double)y + 0.999D, d18, d2, d3);
            } else {
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d1, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d1, d4);
                tessellator.addVertexWithUV(d12, (double)y + 0.001D, d18, d2, d4);
                tessellator.addVertexWithUV(d12, (double)y + 0.999D, d18, d2, d3);
            }

            if (!flag && !flag4) {
                tessellator.addVertexWithUV(d12, (double)y + 0.999D, d17, d2, d3);
                tessellator.addVertexWithUV(d12, (double)y + 0.001D, d17, d2, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d0, d3);
            } else {
                tessellator.addVertexWithUV(d12, (double)y + 0.999D, d17, d2, d3);
                tessellator.addVertexWithUV(d12, (double)y + 0.001D, d17, d2, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d1, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d1, d3);
            }

            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d6, d10);
            tessellator.addVertexWithUV(d12, (double)y + 0.999D, d18, d6, d7);
            tessellator.addVertexWithUV(d12, (double)y + 0.999D, d17, d5, d7);
            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d5, d10);
            tessellator.addVertexWithUV(d12, (double)y + 0.001D, d18, d5, d8);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d5, d10);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d6, d10);
            tessellator.addVertexWithUV(d12, (double)y + 0.001D, d17, d6, d8);
        } else if (!flag3 && !flag && !flag1) {
            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d0, d3);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d0, d4);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d1, d4);
            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d1, d3);
        }

        if (!flag && !flag4) {
            if (!flag3 && !flag2) {
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d1, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d1, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d0, d3);
            }
        } else if (flag && flag1) {
            if (!flag2) {
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d13, d22, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d13, d22, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d14, d2, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d14, d2, d3);
            } else {
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d13, d22, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d13, d22, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d0, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d1, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d1, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d14, d2, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d14, d2, d3);
            }

            if (!flag3) {
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d14, d2, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d14, d2, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d13, d22, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d13, d22, d3);
            } else {
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d0, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d13, d22, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d13, d22, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d14, d2, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d14, d2, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d1, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d1, d3);
            }

            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d13, d6, d7);
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d13, d5, d7);
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d14, d5, d8);
            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d14, d6, d8);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d13, d5, d7);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d13, d6, d7);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d14, d6, d8);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d14, d5, d8);
        } else {
            if (!flag2 && !flag4) {
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d13, d22, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d13, d22, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d1, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d1, d3);
            } else {
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d13, d22, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d13, d22, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d0, d3);
            }

            if (!flag3 && !flag4) {
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d1, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d1, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d13, d22, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d13, d22, d3);
            } else {
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d0, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d13, d22, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d13, d22, d3);
            }

            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d13, d6, d7);
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d13, d5, d7);
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d5, d9);
            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d6, d9);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d13, d5, d7);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d13, d6, d7);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d6, d9);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d5, d9);
        }

        if ((flag1 || flag4) && !flag) {
            if (!flag2 && !flag4) {
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d0, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d14, d2, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d14, d2, d3);
            } else {
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d1, d3);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d1, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.001D, d14, d2, d4);
                tessellator.addVertexWithUV(d15, (double)y + 0.999D, d14, d2, d3);
            }

            if (!flag3 && !flag4) {
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d14, d2, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d14, d2, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d0, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d0, d3);
            } else {
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d14, d2, d3);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d14, d2, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d1, d4);
                tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d1, d3);
            }

            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d6, d10);
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d5, d10);
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d14, d5, d8);
            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d14, d6, d8);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d5, d10);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d6, d10);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d14, d6, d8);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d14, d5, d8);
        } else if (!flag1 && !flag3 && !flag2) {
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d0, d3);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d0, d4);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d1, d4);
            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d1, d3);
        }

        tessellator.addVertexWithUV(d16, (double)y + 0.999D, d17, d6, d9);
        tessellator.addVertexWithUV(d15, (double)y + 0.999D, d17, d5, d9);
        tessellator.addVertexWithUV(d15, (double)y + 0.999D, d18, d5, d10);
        tessellator.addVertexWithUV(d16, (double)y + 0.999D, d18, d6, d10);
        tessellator.addVertexWithUV(d15, (double)y + 0.001D, d17, d5, d9);
        tessellator.addVertexWithUV(d16, (double)y + 0.001D, d17, d6, d9);
        tessellator.addVertexWithUV(d16, (double)y + 0.001D, d18, d6, d10);
        tessellator.addVertexWithUV(d15, (double)y + 0.001D, d18, d5, d10);
        if (flag4) {
            tessellator.addVertexWithUV(d11, (double)y + 0.999D, d17, d0, d3);
            tessellator.addVertexWithUV(d11, (double)y + 0.001D, d17, d0, d4);
            tessellator.addVertexWithUV(d11, (double)y + 0.001D, d18, d1, d4);
            tessellator.addVertexWithUV(d11, (double)y + 0.999D, d18, d1, d3);
            tessellator.addVertexWithUV(d12, (double)y + 0.999D, d18, d0, d3);
            tessellator.addVertexWithUV(d12, (double)y + 0.001D, d18, d0, d4);
            tessellator.addVertexWithUV(d12, (double)y + 0.001D, d17, d1, d4);
            tessellator.addVertexWithUV(d12, (double)y + 0.999D, d17, d1, d3);
            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d13, d1, d3);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d13, d1, d4);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d13, d0, d4);
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d13, d0, d3);
            tessellator.addVertexWithUV(d15, (double)y + 0.999D, d14, d0, d3);
            tessellator.addVertexWithUV(d15, (double)y + 0.001D, d14, d0, d4);
            tessellator.addVertexWithUV(d16, (double)y + 0.001D, d14, d1, d4);
            tessellator.addVertexWithUV(d16, (double)y + 0.999D, d14, d1, d3);
        }

        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return false;
    }

    @Override
    public int getRenderId()
    {
        return renderID;
    }
}
