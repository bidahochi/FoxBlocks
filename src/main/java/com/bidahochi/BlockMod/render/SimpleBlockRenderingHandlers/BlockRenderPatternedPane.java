package com.bidahochi.BlockMod.render.SimpleBlockRenderingHandlers;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Renders patterned panes with standard directional shading and continuous UV
 * coordinates. Unlike the Minecraft 1.7 pane renderer, an isolated pane is a
 * center post and grows arms only toward real connections.
 *
 * <p>The broad patterned faces and narrow edge faces are submitted separately.
 * This preserves the full pattern on the front while limiting the physical
 * edges to the texture's center strip.</p>
 */
public class BlockRenderPatternedPane implements ISimpleBlockRenderingHandler
{
    private static final double PANE_MIN = 0.4375D;
    private static final double PANE_MAX = 0.5625D;
    private static final double BLOCK_CENTER = 0.5D;
    private static final double BLOCK_MAX = 1.0D;
    private static final double TEXTURE_PIXEL_COUNT = 16.0D;
    private static final double EDGE_TEXTURE_MIN_PIXEL = 7.0D;
    private static final double EDGE_TEXTURE_MAX_PIXEL = 9.0D;

    private static final float DOWN_FACE_SHADE = 0.5F;
    private static final float X_FACE_SHADE = 0.6F;
    private static final float Z_FACE_SHADE = 0.8F;
    private static final float UP_FACE_SHADE = 1.0F;

    private static final int RED_CHANNEL_SHIFT = 16;
    private static final int GREEN_CHANNEL_SHIFT = 8;
    private static final int COLOR_CHANNEL_MASK = 255;
    private static final float COLOR_CHANNEL_MAX = 255.0F;
    private static final float ANAGLYPH_RED_WEIGHT = 30.0F;
    private static final float ANAGLYPH_GREEN_WEIGHT = 59.0F;
    private static final float ANAGLYPH_BLUE_WEIGHT = 11.0F;
    private static final float ANAGLYPH_SECONDARY_WEIGHT = 70.0F;
    private static final float ANAGLYPH_WEIGHT_TOTAL = 100.0F;

    private final int renderId;
    private final BlockRenderPrivacyPane inventoryRenderer;

    /**
     * Creates a pane renderer for the supplied Forge rendering identifier.
     *
     * @param renderId rendering identifier registered with Forge
     */
    public BlockRenderPatternedPane(int renderId)
    {
        this.renderId = renderId;
        this.inventoryRenderer = new BlockRenderPrivacyPane(renderId);
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {
        inventoryRenderer.renderInventoryBlock(block, metadata, modelId, renderer);
    }

    /**
     * Resolves pane connections, texture regions, packed color channels, and
     * world brightness before submitting the connected strips. Isolated panes
     * take an early center-post path to avoid unnecessary arm calculations.
     */
    @Override
    public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z,
                                    Block block, int modelId, RenderBlocks renderer)
    {
        if ((block instanceof BlockPane) == false)
        {
            return false;
        }

        BlockPane pane = (BlockPane) block;
        boolean hasNorthConnection = pane.canPaneConnectTo(blockAccess, x, y, z - 1, ForgeDirection.NORTH);
        boolean hasSouthConnection = pane.canPaneConnectTo(blockAccess, x, y, z + 1, ForgeDirection.SOUTH);
        boolean hasWestConnection = pane.canPaneConnectTo(blockAccess, x - 1, y, z, ForgeDirection.WEST);
        boolean hasEastConnection = pane.canPaneConnectTo(blockAccess, x + 1, y, z, ForgeDirection.EAST);
        boolean isIsolated = (hasNorthConnection == false)
                && (hasSouthConnection == false)
                && (hasWestConnection == false)
                && (hasEastConnection == false);

        int metadata = blockAccess.getBlockMetadata(x, y, z);
        IIcon faceIcon = renderer.hasOverrideBlockTexture()
                ? renderer.overrideBlockTexture
                : renderer.getBlockIconFromSideAndMetadata(block, 0, metadata);
        IIcon edgeIcon = renderer.hasOverrideBlockTexture()
                ? renderer.overrideBlockTexture
                : pane.func_150097_e();

        int packedColor = block.colorMultiplier(blockAccess, x, y, z);
        float red = (float) ((packedColor >> RED_CHANNEL_SHIFT) & COLOR_CHANNEL_MASK) / COLOR_CHANNEL_MAX;
        float green = (float) ((packedColor >> GREEN_CHANNEL_SHIFT) & COLOR_CHANNEL_MASK) / COLOR_CHANNEL_MAX;
        float blue = (float) (packedColor & COLOR_CHANNEL_MASK) / COLOR_CHANNEL_MAX;

        if (EntityRenderer.anaglyphEnable)
        {
            float anaglyphRed = (red * ANAGLYPH_RED_WEIGHT
                    + green * ANAGLYPH_GREEN_WEIGHT
                    + blue * ANAGLYPH_BLUE_WEIGHT) / ANAGLYPH_WEIGHT_TOTAL;
            float anaglyphGreen = (red * ANAGLYPH_RED_WEIGHT
                    + green * ANAGLYPH_SECONDARY_WEIGHT) / ANAGLYPH_WEIGHT_TOTAL;
            float anaglyphBlue = (red * ANAGLYPH_RED_WEIGHT
                    + blue * ANAGLYPH_SECONDARY_WEIGHT) / ANAGLYPH_WEIGHT_TOTAL;
            red = anaglyphRed;
            green = anaglyphGreen;
            blue = anaglyphBlue;
        }

        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(block.getMixedBrightnessForBlock(blockAccess, x, y, z));

        if (isIsolated)
        {
            renderEastWest(tessellator, faceIcon, edgeIcon, x, y, z,
                    PANE_MIN, PANE_MAX, false, false, false,
                    red, green, blue);
            return true;
        }

        if (hasNorthConnection || hasSouthConnection)
        {
            double minZ = hasNorthConnection ? 0.0D : BLOCK_CENTER;
            double maxZ = hasSouthConnection ? BLOCK_MAX : BLOCK_CENTER;
            renderNorthSouth(tessellator, faceIcon, edgeIcon, x, y, z, minZ, maxZ,
                    hasNorthConnection, hasSouthConnection,
                    hasWestConnection || hasEastConnection, red, green, blue);
        }

        if (hasWestConnection || hasEastConnection)
        {
            double minX = hasWestConnection ? 0.0D : BLOCK_CENTER;
            double maxX = hasEastConnection ? BLOCK_MAX : BLOCK_CENTER;
            renderEastWest(tessellator, faceIcon, edgeIcon, x, y, z, minX, maxX,
                    hasWestConnection, hasEastConnection,
                    hasNorthConnection || hasSouthConnection, red, green, blue);
        }

        return true;
    }

    /**
     * Renders the east-west strip, including broad Z-facing surfaces, narrow
     * horizontal edges, and any exposed end caps.
     */
    private void renderEastWest(Tessellator tessellator, IIcon faceIcon, IIcon edgeIcon,
                                int x, int y, int z, double minX, double maxX,
                                boolean hasWestConnection, boolean hasEastConnection,
                                boolean hasPerpendicularConnection,
                                float red, float green, float blue)
    {
        double worldMinX = x + minX;
        double worldMaxX = x + maxX;
        double minZ = z + PANE_MIN;
        double maxZ = z + PANE_MAX;
        double minY = y;
        double maxY = y + BLOCK_MAX;
        double faceMinU = faceIcon.getInterpolatedU(minX * TEXTURE_PIXEL_COUNT);
        double faceMaxU = faceIcon.getInterpolatedU(maxX * TEXTURE_PIXEL_COUNT);
        double faceMinV = faceIcon.getMinV();
        double faceMaxV = faceIcon.getMaxV();

        setColor(tessellator, red, green, blue, Z_FACE_SHADE);
        addDoubleSidedVerticalQuad(tessellator, worldMinX, worldMaxX, minZ, maxZ,
                minY, maxY, faceMinU, faceMaxU, faceMinV, faceMaxV, true);

        renderHorizontalEdges(tessellator, edgeIcon, worldMinX, worldMaxX,
                minZ, maxZ, minY, maxY, minX, maxX, true, red, green, blue);

        boolean shouldRenderWestCap = (hasWestConnection == false)
                && (hasPerpendicularConnection == false);
        boolean shouldRenderEastCap = (hasEastConnection == false)
                && (hasPerpendicularConnection == false);
        setColor(tessellator, red, green, blue, X_FACE_SHADE);
        if (shouldRenderWestCap)
        {
            addVerticalCap(tessellator, worldMinX, minZ, maxZ, minY, maxY, edgeIcon, true);
        }
        if (shouldRenderEastCap)
        {
            addVerticalCap(tessellator, worldMaxX, minZ, maxZ, minY, maxY, edgeIcon, true);
        }
    }

    /**
     * Renders the north-south strip, including broad X-facing surfaces, narrow
     * horizontal edges, and any exposed end caps.
     */
    private void renderNorthSouth(Tessellator tessellator, IIcon faceIcon, IIcon edgeIcon,
                                  int x, int y, int z, double minZ, double maxZ,
                                  boolean hasNorthConnection, boolean hasSouthConnection,
                                  boolean hasPerpendicularConnection,
                                  float red, float green, float blue)
    {
        double minX = x + PANE_MIN;
        double maxX = x + PANE_MAX;
        double worldMinZ = z + minZ;
        double worldMaxZ = z + maxZ;
        double minY = y;
        double maxY = y + BLOCK_MAX;
        double faceMinU = faceIcon.getInterpolatedU(minZ * TEXTURE_PIXEL_COUNT);
        double faceMaxU = faceIcon.getInterpolatedU(maxZ * TEXTURE_PIXEL_COUNT);
        double faceMinV = faceIcon.getMinV();
        double faceMaxV = faceIcon.getMaxV();

        setColor(tessellator, red, green, blue, X_FACE_SHADE);
        addDoubleSidedVerticalQuad(tessellator, worldMinZ, worldMaxZ, minX, maxX,
                minY, maxY, faceMinU, faceMaxU, faceMinV, faceMaxV, false);

        renderHorizontalEdges(tessellator, edgeIcon, worldMinZ, worldMaxZ,
                minX, maxX, minY, maxY, minZ, maxZ, false, red, green, blue);

        boolean shouldRenderNorthCap = (hasNorthConnection == false)
                && (hasPerpendicularConnection == false);
        boolean shouldRenderSouthCap = (hasSouthConnection == false)
                && (hasPerpendicularConnection == false);
        setColor(tessellator, red, green, blue, Z_FACE_SHADE);
        if (shouldRenderNorthCap)
        {
            addVerticalCap(tessellator, worldMinZ, minX, maxX, minY, maxY, edgeIcon, false);
        }
        if (shouldRenderSouthCap)
        {
            addVerticalCap(tessellator, worldMaxZ, minX, maxX, minY, maxY, edgeIcon, false);
        }
    }

    /**
     * Submits the two outward-facing patterned surfaces at the pane's minimum
     * and maximum thickness coordinates. Vertex order is chosen per axis so
     * back-face culling keeps both exterior faces visible.
     */
    private void addDoubleSidedVerticalQuad(Tessellator tessellator,
                                            double minAlong, double maxAlong,
                                            double fixedMin, double fixedMax,
                                            double minY, double maxY,
                                            double minU, double maxU, double minV, double maxV,
                                            boolean alongX)
    {
        if (alongX)
        {
            addQuad(tessellator, maxAlong, maxY, fixedMin, maxU, minV,
                    maxAlong, minY, fixedMin, maxU, maxV,
                    minAlong, minY, fixedMin, minU, maxV,
                    minAlong, maxY, fixedMin, minU, minV);
            addQuad(tessellator, minAlong, maxY, fixedMax, maxU, minV,
                    minAlong, minY, fixedMax, maxU, maxV,
                    maxAlong, minY, fixedMax, minU, maxV,
                    maxAlong, maxY, fixedMax, minU, minV);
        }
        else
        {
            addQuad(tessellator, fixedMin, maxY, minAlong, minU, minV,
                    fixedMin, minY, minAlong, minU, maxV,
                    fixedMin, minY, maxAlong, maxU, maxV,
                    fixedMin, maxY, maxAlong, maxU, minV);
            addQuad(tessellator, fixedMax, maxY, maxAlong, minU, minV,
                    fixedMax, minY, maxAlong, minU, maxV,
                    fixedMax, minY, minAlong, maxU, maxV,
                    fixedMax, maxY, minAlong, maxU, minV);
        }
    }

    /**
     * Renders the top and bottom thickness faces using the texture center strip.
     */
    private void renderHorizontalEdges(Tessellator tessellator, IIcon icon,
                                       double minAlong, double maxAlong,
                                       double minAcross, double maxAcross,
                                       double minY, double maxY,
                                       double localMinAlong, double localMaxAlong,
                                       boolean alongX, float red, float green, float blue)
    {
        double minU = icon.getInterpolatedU(EDGE_TEXTURE_MIN_PIXEL);
        double maxU = icon.getInterpolatedU(EDGE_TEXTURE_MAX_PIXEL);
        double minV = icon.getInterpolatedV(localMinAlong * TEXTURE_PIXEL_COUNT);
        double maxV = icon.getInterpolatedV(localMaxAlong * TEXTURE_PIXEL_COUNT);

        setColor(tessellator, red, green, blue, UP_FACE_SHADE);
        addHorizontalEdge(tessellator, minAlong, maxAlong, minAcross, maxAcross,
                maxY, minU, maxU, minV, maxV, alongX, true);
        setColor(tessellator, red, green, blue, DOWN_FACE_SHADE);
        addHorizontalEdge(tessellator, minAlong, maxAlong, minAcross, maxAcross,
                minY, minU, maxU, minV, maxV, alongX, false);
    }

    /**
     * Submits one horizontal thickness face with outward vertex winding for the
     * requested top or bottom surface.
     */
    private void addHorizontalEdge(Tessellator tessellator,
                                   double minAlong, double maxAlong,
                                   double minAcross, double maxAcross, double y,
                                   double minU, double maxU, double minV, double maxV,
                                   boolean alongX, boolean top)
    {
        if (alongX)
        {
            if (top)
            {
                addQuad(tessellator, minAlong, y, minAcross, minU, minV,
                        minAlong, y, maxAcross, maxU, minV,
                        maxAlong, y, maxAcross, maxU, maxV,
                        maxAlong, y, minAcross, minU, maxV);
            }
            else
            {
                addQuad(tessellator, maxAlong, y, minAcross, minU, maxV,
                        maxAlong, y, maxAcross, maxU, maxV,
                        minAlong, y, maxAcross, maxU, minV,
                        minAlong, y, minAcross, minU, minV);
            }
        }
        else
        {
            if (top)
            {
                addQuad(tessellator, minAcross, y, minAlong, minU, minV,
                        minAcross, y, maxAlong, minU, maxV,
                        maxAcross, y, maxAlong, maxU, maxV,
                        maxAcross, y, minAlong, maxU, minV);
            }
            else
            {
                addQuad(tessellator, maxAcross, y, minAlong, maxU, minV,
                        maxAcross, y, maxAlong, maxU, maxV,
                        minAcross, y, maxAlong, minU, maxV,
                        minAcross, y, minAlong, minU, minV);
            }
        }
    }

    /**
     * Renders both sides of an exposed vertical end cap. The face-axis flag
     * selects whether its fixed world coordinate is X or Z.
     */
    private void addVerticalCap(Tessellator tessellator, double fixed,
                                double minAcross, double maxAcross,
                                double minY, double maxY, IIcon icon, boolean fixedX)
    {
        double minU = icon.getInterpolatedU(EDGE_TEXTURE_MIN_PIXEL);
        double maxU = icon.getInterpolatedU(EDGE_TEXTURE_MAX_PIXEL);
        double minV = icon.getMinV();
        double maxV = icon.getMaxV();
        if (fixedX)
        {
            addQuad(tessellator, fixed, maxY, minAcross, minU, minV,
                    fixed, minY, minAcross, minU, maxV,
                    fixed, minY, maxAcross, maxU, maxV,
                    fixed, maxY, maxAcross, maxU, minV);
            addQuad(tessellator, fixed, maxY, maxAcross, minU, minV,
                    fixed, minY, maxAcross, minU, maxV,
                    fixed, minY, minAcross, maxU, maxV,
                    fixed, maxY, minAcross, maxU, minV);
        }
        else
        {
            addQuad(tessellator, minAcross, maxY, fixed, minU, minV,
                    minAcross, minY, fixed, minU, maxV,
                    maxAcross, minY, fixed, maxU, maxV,
                    maxAcross, maxY, fixed, maxU, minV);
            addQuad(tessellator, maxAcross, maxY, fixed, minU, minV,
                    maxAcross, minY, fixed, minU, maxV,
                    minAcross, minY, fixed, maxU, maxV,
                    minAcross, maxY, fixed, maxU, minV);
        }
    }

    /**
     * Adds a textured quad to the active world tessellation batch.
     */
    private void addQuad(Tessellator tessellator,
                         double x1, double y1, double z1, double u1, double v1,
                         double x2, double y2, double z2, double u2, double v2,
                         double x3, double y3, double z3, double u3, double v3,
                         double x4, double y4, double z4, double u4, double v4)
    {
        tessellator.addVertexWithUV(x1, y1, z1, u1, v1);
        tessellator.addVertexWithUV(x2, y2, z2, u2, v2);
        tessellator.addVertexWithUV(x3, y3, z3, u3, v3);
        tessellator.addVertexWithUV(x4, y4, z4, u4, v4);
    }

    /**
     * Applies the face-direction shade to the block's metadata color.
     */
    private void setColor(Tessellator tessellator, float red, float green, float blue, float shade)
    {
        tessellator.setColorOpaque_F(red * shade, green * shade, blue * shade);
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return false;
    }

    @Override
    public int getRenderId()
    {
        return renderId;
    }
}
