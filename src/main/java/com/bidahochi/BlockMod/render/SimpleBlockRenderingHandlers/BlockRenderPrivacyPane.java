package com.bidahochi.BlockMod.render.SimpleBlockRenderingHandlers;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class BlockRenderPrivacyPane implements ISimpleBlockRenderingHandler
{

    public int renderID;
    private static final double PANE_MIN = 0.4375D;
    private static final double PANE_MAX = 0.5625D;

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
        renderer.renderFaceYNeg(
                block,
                0.0D,
                0.0D,
                0.0D,
                renderer.overrideBlockTexture != null
                        ? renderer.overrideBlockTexture
                        : renderer.getBlockIconFromSideAndMetadata(block, 0, metadata)
        );
        tes.draw();

        tes.startDrawingQuads();
        tes.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(
                block,
                0.0D,
                0.0D,
                0.0D,
                renderer.overrideBlockTexture != null
                        ? renderer.overrideBlockTexture
                        : renderer.getBlockIconFromSideAndMetadata(block, 1, metadata)
        );
        tes.draw();

        tes.startDrawingQuads();
        tes.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(
                block,
                0.0D,
                0.0D,
                0.0D,
                renderer.overrideBlockTexture != null
                        ? renderer.overrideBlockTexture
                        : renderer.getBlockIconFromSideAndMetadata(block, 2, metadata)
        );
        tes.draw();

        tes.startDrawingQuads();
        tes.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(
                block,
                0.0D,
                0.0D,
                0.0D,
                renderer.overrideBlockTexture != null
                        ? renderer.overrideBlockTexture
                        : renderer.getBlockIconFromSideAndMetadata(block, 3, metadata)
        );
        tes.draw();

        tes.startDrawingQuads();
        tes.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(
                block,
                0.0D,
                0.0D,
                0.0D,
                renderer.overrideBlockTexture != null
                        ? renderer.overrideBlockTexture
                        : renderer.getBlockIconFromSideAndMetadata(block, 4, metadata)
        );
        tes.draw();

        tes.startDrawingQuads();
        tes.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(
                block,
                0.0D,
                0.0D,
                0.0D,
                renderer.overrideBlockTexture != null
                        ? renderer.overrideBlockTexture
                        : renderer.getBlockIconFromSideAndMetadata(block, 5, metadata)
        );
        tes.draw();

        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        if (!(block instanceof BlockPane))
        {
            return false;
        }

        BlockPane pane = (BlockPane) block;

        boolean north = pane.canPaneConnectTo(blockAccess, x, y, z - 1, ForgeDirection.NORTH);
        boolean south = pane.canPaneConnectTo(blockAccess, x, y, z + 1, ForgeDirection.SOUTH);
        boolean west = pane.canPaneConnectTo(blockAccess, x - 1, y, z, ForgeDirection.WEST);
        boolean east = pane.canPaneConnectTo(blockAccess, x + 1, y, z, ForgeDirection.EAST);

        boolean noConnections = !north && !south && !west && !east;

        boolean oldRenderAllFaces = renderer.renderAllFaces;

        renderer.renderAllFaces = true;

        /*
         * Center post.
         */
        renderStandardPiece(
                renderer,
                block,
                x,
                y,
                z,
                PANE_MIN,
                0.0D,
                PANE_MIN,
                PANE_MAX,
                1.0D,
                PANE_MAX
        );

        /*
         * North arm.
         */
        if (north || noConnections)
        {
            renderStandardPiece(
                    renderer,
                    block,
                    x,
                    y,
                    z,
                    PANE_MIN,
                    0.0D,
                    0.0D,
                    PANE_MAX,
                    1.0D,
                    PANE_MIN
            );
        }

        /*
         * South arm.
         */
        if (south || noConnections)
        {
            renderStandardPiece(
                    renderer,
                    block,
                    x,
                    y,
                    z,
                    PANE_MIN,
                    0.0D,
                    PANE_MAX,
                    PANE_MAX,
                    1.0D,
                    1.0D
            );
        }

        /*
         * West arm.
         */
        if (west || noConnections)
        {
            renderStandardPiece(
                    renderer,
                    block,
                    x,
                    y,
                    z,
                    0.0D,
                    0.0D,
                    PANE_MIN,
                    PANE_MIN,
                    1.0D,
                    PANE_MAX
            );
        }

        /*
         * East arm.
         */
        if (east || noConnections)
        {
            renderStandardPiece(
                    renderer,
                    block,
                    x,
                    y,
                    z,
                    PANE_MAX,
                    0.0D,
                    PANE_MIN,
                    1.0D,
                    1.0D,
                    PANE_MAX
            );
        }

        renderer.renderAllFaces = oldRenderAllFaces;

        /*
         * Always reset render bounds so the next block renderer does not
         * accidentally inherit our thin pane bounds.
         */
        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);


        return true;
    }

    private void renderStandardPiece(RenderBlocks renderer,
                                     Block block,
                                     int x,
                                     int y,
                                     int z,
                                     double minX,
                                     double minY,
                                     double minZ,
                                     double maxX,
                                     double maxY,
                                     double maxZ)
    {
        renderer.setRenderBounds(minX, minY, minZ, maxX, maxY, maxZ);
        renderer.renderStandardBlock(block, x, y, z);
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
