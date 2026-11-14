package com.bidahochi.BlockMod.blocks.displayframe.client;

import com.bidahochi.BlockMod.blocks.displayframe.BlockDisplayFrame;
import com.bidahochi.BlockMod.blocks.displayframe.TileDisplayFrame;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

/** Adds Display Frame geometry to the chunk's block mesh and renders the frame item in inventories. */
public final class DisplayFrameRenderer implements ISimpleBlockRenderingHandler
{
    private static final double RIM_RADIUS = 0.5 - BlockDisplayFrame.EDGE;
    private static final double RIM_DEPTH = BlockDisplayFrame.DEPTH;
    private static final double OPENING_RADIUS = RIM_RADIUS - 1.0 / 16.0;
    private static final double BACKING_DEPTH = RIM_DEPTH / 2;
    private static final double LABEL_HALF_WIDTH = 7.0 / 16.0;
    private static final double LABEL_TOP = -RIM_RADIUS;
    private static final double LABEL_BOTTOM = -0.5;
    private static final double LABEL_DEPTH = RIM_DEPTH;
    private static final double ITEM_SCALE = 0.5128205;
    private static final double ITEM_RADIUS = ITEM_SCALE / 2;
    // RenderItemFrame anchors the item at 0.5 - 0.453125 blocks from its support.
    private static final double ITEM_ANCHOR_DEPTH = 3.0 / 64.0;
    // RenderItem centers a single sprite at half the layer spacing, with its outer face toward the viewer.
    private static final double ICON_FRONT_DEPTH = ITEM_ANCHOR_DEPTH + (0.0625 - 0.021875) * ITEM_SCALE / 2;
    private static final double ICON_THICKNESS = 0.0625 * ITEM_SCALE;
    private static final double ICON_CENTER_HEIGHT = 0.10 + (0.5 - 0.25 - 0.05) * ITEM_SCALE;
    // RenderHelper's two standard item lights point along (0.2, 1, -0.7) and (-0.2, 1, 0.7).
    private static final float ITEM_AMBIENT = 0.4F;
    private static final float ITEM_DIFFUSE = 0.6F / (float) Math.sqrt(0.2 * 0.2 + 1 + 0.7 * 0.7);
    private final DisplayFramePreviews previews = new DisplayFramePreviews();

    /** Registers the chunk renderer and hooks preview creation into client events. */
    public static void register()
    {
        BlockDisplayFrame.renderId = RenderingRegistry.getNextAvailableRenderId();
        DisplayFrameRenderer renderer = new DisplayFrameRenderer();
        RenderingRegistry.registerBlockHandler(renderer);
        MinecraftForge.EVENT_BUS.register(renderer.previews);
        FMLCommonHandler.instance().bus().register(renderer.previews);
    }

    /** Appends the rim, backing, and cached contents for one frame to the current chunk mesh. */
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
                                    Block block, int modelId, RenderBlocks renderer)
    {
        int metadata = world.getBlockMetadata(x, y, z);
        int side = BlockDisplayFrame.getFacing(metadata);
        if (side >= Orientation.ALL.length)
        {
            return false;
        }

        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        Orientation facing = Orientation.ALL[side];
        boolean standalone = BlockDisplayFrame.isStandalone(metadata);
        double inset = standalone ? RIM_DEPTH / 2 : 0.5;
        double centerX = x + 0.5 - facing.normal.offsetX * inset;
        double centerY = y + 0.5 - facing.normal.offsetY * inset;
        double centerZ = z + 0.5 - facing.normal.offsetZ * inset;
        IIcon override = renderer.hasOverrideBlockTexture() ? renderer.overrideBlockTexture : null;
        TileDisplayFrame frame = null;
        ItemStack stack = null;
        if (override == null)
        {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile instanceof TileDisplayFrame)
            {
                frame = (TileDisplayFrame) tile;
                stack = frame.getDisplayedItem();
            }
        }
        boolean showItemOnly = stack != null && frame.isItemOnly();
        if (showItemOnly == false)
        {
            IIcon rim = override == null ? Blocks.planks.getIcon(1, 2) : override;
            IIcon backing = override == null ? block.getIcon(side, 0) : override;
            drawFrame(tessellator, facing, centerX, centerY, centerZ, backing, rim, true);
            if (standalone)
            {
                ForgeDirection back = facing.normal.getOpposite();
                setFrameShade(tessellator, back, true);
                frameFace(tessellator, back, facing.right.getOpposite(), facing.up, centerX, centerY, centerZ,
                        -RIM_RADIUS, -RIM_RADIUS, RIM_RADIUS, RIM_RADIUS, 0, rim);
            }
        }

        if (stack != null)
        {
            if (frame.isLabeled())
            {
                IIcon label = previews.getLabel(stack, x, y, z);
                if (label != null)
                {
                    drawLabel(tessellator, facing, centerX, centerY, centerZ, label);
                }
            }
            ItemAxes axes = facing.itemAxes[frame.getRotation()];
            DisplayFramePreviews.Appearance appearance = previews.getPreview(stack, x, y, z, frame.isFlat());
            if (appearance.mesh != null)
            {
                drawBlockModel(tessellator, facing, axes, centerX, centerY, centerZ, appearance.mesh,
                        showItemOnly, standalone);
            }
            else
            {
                double pivot = ICON_CENTER_HEIGHT - 0.16;
                centerX += facing.up.offsetX * -0.02 + axes.upX * pivot;
                centerY += facing.up.offsetY * -0.02 + axes.upY * pivot;
                centerZ += facing.up.offsetZ * -0.02 + axes.upZ * pivot;
                drawIcon(tessellator, axes, centerX, centerY, centerZ, appearance.icon, showItemOnly);
            }
        }
        tessellator.setColorOpaque_F(1, 1, 1);
        return true;
    }

    /** Draws the nameplate in the frame's orientation using the occupied rows of the atlas sprite. */
    private static void drawLabel(Tessellator tessellator, Orientation facing,
                                  double centerX, double centerY, double centerZ, IIcon label)
    {
        setItemShade(tessellator, facing.normal);
        double labelRows = 16.0 * DisplayFrameThumbnail.LABEL_HEIGHT / DisplayFrameThumbnail.LABEL_WIDTH;
        float bottomV = label.getInterpolatedV(labelRows);
        quad(tessellator, facing.normal, facing.right, facing.up, centerX, centerY, centerZ,
                -LABEL_HALF_WIDTH, LABEL_BOTTOM, LABEL_HALF_WIDTH, LABEL_TOP, LABEL_DEPTH,
                label.getMinU(), label.getMaxU(), label.getMinV(), bottomV);
    }

    /** Draws the empty frame model for inventories and held items. */
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {
        Tessellator tessellator = Tessellator.instance;
        GL11.glPushMatrix();
        try
        {
            tessellator.startDrawingQuads();
            tessellator.setNormal(0, 0, 1);
            tessellator.setColorOpaque_F(1, 1, 1);
            drawFrame(tessellator, Orientation.SOUTH, 0, 0, -RIM_DEPTH / 2,
                    block.getIcon(3, 0), Blocks.planks.getIcon(1, 2), false);
            tessellator.draw();
        }
        finally
        {
            GL11.glPopMatrix();
        }
    }

    /** Draws the sprite faces and the sides of its opaque outline using the same rotated axes. */
    private static void drawIcon(Tessellator tessellator, ItemAxes axes, double x, double y, double z,
                                 IIcon icon, boolean showItemOnly)
    {
        DisplayFrameIconOutline outline = DisplayFramePreviews.getOutline(icon);
        setItemShade(tessellator, axes.forward);
        drawIconFace(tessellator, axes, x, y, z, ICON_FRONT_DEPTH, icon, false);
        double rear = BACKING_DEPTH;
        if (showItemOnly)
        {
            rear = outline == null ? ICON_FRONT_DEPTH : ICON_FRONT_DEPTH - ICON_THICKNESS;
            setItemShade(tessellator, axes.forward.getOpposite());
            drawIconFace(tessellator, axes, x, y, z, rear, icon, true);
        }
        if (outline == null)
        {
            return;
        }
        for (DisplayFrameIconOutline.Edge edge : outline.edges)
        {
            float light = Math.min(1, axes.shade(edge.outward.offsetX, edge.outward.offsetY, 0));
            tessellator.setColorOpaque_F(light, light, light);
            addIconEdgeVertex(tessellator, axes, x, y, z, rear, edge.start, icon);
            addIconEdgeVertex(tessellator, axes, x, y, z, rear, edge.end, icon);
            addIconEdgeVertex(tessellator, axes, x, y, z, ICON_FRONT_DEPTH, edge.end, icon);
            addIconEdgeVertex(tessellator, axes, x, y, z, ICON_FRONT_DEPTH, edge.start, icon);
        }
    }

    /** Reverses vertex order on the back so both faces keep their outward winding. */
    private static void drawIconFace(Tessellator tessellator, ItemAxes axes, double x, double y, double z,
                                     double depth, IIcon icon, boolean back)
    {
        float minU = icon.getMinU();
        float maxU = icon.getMaxU();
        float minV = icon.getMinV();
        float maxV = icon.getMaxV();
        for (int index = 0; index < 4; index++)
        {
            int corner = back ? 3 - index : index;
            boolean rightSide = corner == 1 || corner == 2;
            boolean topSide = corner >= 2;
            double horizontal = rightSide ? ITEM_RADIUS : -ITEM_RADIUS;
            double vertical = topSide ? ITEM_RADIUS : -ITEM_RADIUS;
            float u = rightSide ? maxU : minU;
            float v = topSide ? minV : maxV;
            axes.addVertex(tessellator, x, y, z, horizontal, vertical, depth, u, v);
        }
    }

    private static void addIconEdgeVertex(Tessellator tessellator, ItemAxes axes,
                                          double x, double y, double z, double depth,
                                          DisplayFrameIconOutline.Point point, IIcon icon)
    {
        double horizontal = point.x * ITEM_RADIUS;
        double vertical = point.y * ITEM_RADIUS;
        float u = icon.getInterpolatedU(point.u);
        float v = icon.getInterpolatedV(point.v);
        axes.addVertex(tessellator, x, y, z, horizontal, vertical, depth, u, v);
    }

    private static void drawFrame(Tessellator tessellator, Orientation face, double x, double y, double z,
                                  IIcon backing, IIcon rim, boolean chunkLighting)
    {
        setFrameShade(tessellator, face.normal, chunkLighting);
        frameFace(tessellator, face.normal, face.right, face.up, x, y, z,
                -OPENING_RADIUS, -OPENING_RADIUS, OPENING_RADIUS, OPENING_RADIUS, BACKING_DEPTH, backing);
        frameFace(tessellator, face.normal, face.right, face.up, x, y, z,
                -RIM_RADIUS, -RIM_RADIUS, RIM_RADIUS, -OPENING_RADIUS, RIM_DEPTH, rim);
        frameFace(tessellator, face.normal, face.right, face.up, x, y, z,
                -RIM_RADIUS, OPENING_RADIUS, RIM_RADIUS, RIM_RADIUS, RIM_DEPTH, rim);
        frameFace(tessellator, face.normal, face.right, face.up, x, y, z,
                -RIM_RADIUS, -OPENING_RADIUS, -OPENING_RADIUS, OPENING_RADIUS, RIM_DEPTH, rim);
        frameFace(tessellator, face.normal, face.right, face.up, x, y, z,
                OPENING_RADIUS, -OPENING_RADIUS, RIM_RADIUS, OPENING_RADIUS, RIM_DEPTH, rim);

        drawRimEdge(tessellator, face.right, face.up, face.normal, x, y, z, rim, chunkLighting);
        drawRimEdge(tessellator, face.up, face.right.getOpposite(), face.normal, x, y, z, rim, chunkLighting);
        drawRimEdge(tessellator, face.right.getOpposite(), face.up.getOpposite(), face.normal, x, y, z, rim, chunkLighting);
        drawRimEdge(tessellator, face.up.getOpposite(), face.right, face.normal, x, y, z, rim, chunkLighting);
    }

    private static void drawRimEdge(Tessellator tessellator, ForgeDirection outward, ForgeDirection along,
                                    ForgeDirection normal, double x, double y, double z, IIcon rim, boolean chunkLighting)
    {
        setFrameShade(tessellator, outward, chunkLighting);
        frameFace(tessellator, outward, along, normal, x, y, z,
                -RIM_RADIUS, 0, RIM_RADIUS, RIM_DEPTH, RIM_RADIUS, rim);
        setFrameShade(tessellator, outward.getOpposite(), chunkLighting);
        frameFace(tessellator, outward.getOpposite(), along.getOpposite(), normal, x, y, z,
                -OPENING_RADIUS, BACKING_DEPTH, OPENING_RADIUS, RIM_DEPTH, -OPENING_RADIUS, rim);
    }

    private static void drawBlockModel(Tessellator tessellator, Orientation frame, ItemAxes axes,
                                       double x, double y, double z, DisplayFrameBlockMesh.Mesh mesh, boolean showItemOnly,
                                       boolean standalone)
    {
        DisplayFrameBlockMesh.Face[] faces = mesh.framed;
        if (showItemOnly)
        {
            faces = standalone ? mesh.freestanding : mesh.againstWall;
        }
        double pivotOffset = 0.0025;
        x += (axes.upX - frame.up.offsetX) * pivotOffset;
        y += (axes.upY - frame.up.offsetY) * pivotOffset;
        z += (axes.upZ - frame.up.offsetZ) * pivotOffset;
        for (DisplayFrameBlockMesh.Face face : faces)
        {
            float light = axes.shade(face.nx, face.ny, face.nz);
            DisplayFrameBlockMesh.Vertex[] vertices = face.vertices;
            if (vertices.length == 4)
            {
                for (DisplayFrameBlockMesh.Vertex vertex : vertices)
                {
                    addBlockVertex(tessellator, axes, x, y, z, light, vertex);
                }
            }
            else
            {
                for (int index = 2; index < vertices.length; index++)
                {
                    // A triangle becomes a quad with a repeated last vertex.
                    addBlockVertex(tessellator, axes, x, y, z, light, vertices[0]);
                    addBlockVertex(tessellator, axes, x, y, z, light, vertices[index - 1]);
                    addBlockVertex(tessellator, axes, x, y, z, light, vertices[index]);
                    addBlockVertex(tessellator, axes, x, y, z, light, vertices[index]);
                }
            }
        }
    }

    private static void addBlockVertex(Tessellator tessellator, ItemAxes axes,
                                       double x, double y, double z, float light,
                                       DisplayFrameBlockMesh.Vertex vertex)
    {
        tessellator.setColorOpaque_F(Math.min(1, vertex.red * light),
                Math.min(1, vertex.green * light), Math.min(1, vertex.blue * light));
        axes.addVertex(tessellator, x, y, z, vertex.x, vertex.y, vertex.z, vertex.u, vertex.v);
    }

    private static void setFrameShade(Tessellator tessellator, ForgeDirection normal, boolean chunkLighting)
    {
        if (chunkLighting)
        {
            setItemShade(tessellator, normal);
        }
    }

    private static void setItemShade(Tessellator tessellator, ForgeDirection normal)
    {
        float light = Math.min(1, itemShade(normal.offsetX, normal.offsetY, normal.offsetZ));
        tessellator.setColorOpaque_F(light, light, light);
    }

    private static float itemShade(double x, double y, double z)
    {
        float horizontal = (float) (x * 0.2 - z * 0.7);
        return ITEM_AMBIENT + ITEM_DIFFUSE * (float) (Math.max(0, y + horizontal)
                + Math.max(0, y - horizontal));
    }

    private static void frameFace(Tessellator tessellator, ForgeDirection face, ForgeDirection horizontalAxis,
                                  ForgeDirection verticalAxis, double x, double y, double z, double left, double bottom,
                                  double right, double top, double depth, IIcon icon)
    {
        // Sample a patch at block scale, so a one-pixel strip uses one row or column of the sprite.
        float minU = icon.getInterpolatedU(8 + left * 16);
        float maxU = icon.getInterpolatedU(8 + right * 16);
        float minV = icon.getInterpolatedV(8 - top * 16);
        float maxV = icon.getInterpolatedV(8 - bottom * 16);
        quad(tessellator, face, horizontalAxis, verticalAxis, x, y, z, left, bottom, right, top, depth,
                minU, maxU, minV, maxV);
    }

    private static void quad(Tessellator tessellator, ForgeDirection face, ForgeDirection horizontalAxis,
                             ForgeDirection verticalAxis, double x, double y, double z, double left, double bottom,
                             double right, double top, double depth, float minU, float maxU, float minV, float maxV)
    {
        double centerX = x + face.offsetX * depth;
        double centerY = y + face.offsetY * depth;
        double centerZ = z + face.offsetZ * depth;
        for (int corner = 0; corner < 4; corner++)
        {
            boolean rightSide = corner == 1 || corner == 2;
            boolean topSide = corner >= 2;
            double horizontal = rightSide ? right : left;
            double vertical = topSide ? top : bottom;
            double vertexX = centerX + horizontal * horizontalAxis.offsetX + vertical * verticalAxis.offsetX;
            double vertexY = centerY + horizontal * horizontalAxis.offsetY + vertical * verticalAxis.offsetY;
            double vertexZ = centerZ + horizontal * horizontalAxis.offsetZ + vertical * verticalAxis.offsetZ;
            float u = rightSide ? maxU : minU;
            float v = topSide ? minV : maxV;
            tessellator.addVertexWithUV(vertexX, vertexY, vertexZ, u, v);
        }
    }

    /** Uses the frame model for inventory rendering. */
    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }

    /** Matches the render ID returned by the Display Frame block. */
    @Override
    public int getRenderId()
    {
        return BlockDisplayFrame.renderId;
    }

    private enum Orientation
    {
        DOWN(ForgeDirection.DOWN, ForgeDirection.EAST, ForgeDirection.SOUTH),
        UP(ForgeDirection.UP, ForgeDirection.EAST, ForgeDirection.NORTH),
        NORTH(ForgeDirection.NORTH, ForgeDirection.WEST, ForgeDirection.UP),
        SOUTH(ForgeDirection.SOUTH, ForgeDirection.EAST, ForgeDirection.UP),
        WEST(ForgeDirection.WEST, ForgeDirection.SOUTH, ForgeDirection.UP),
        EAST(ForgeDirection.EAST, ForgeDirection.NORTH, ForgeDirection.UP);

        private static final Orientation[] ALL = values();
        private final ForgeDirection normal;
        private final ForgeDirection right;
        private final ForgeDirection up;
        private final ItemAxes[] itemAxes = new ItemAxes[TileDisplayFrame.ROTATION_STEPS];

        private Orientation(ForgeDirection normal, ForgeDirection right, ForgeDirection up)
        {
            this.normal = normal;
            this.right = right;
            this.up = up;
            for (int rotation = 0; rotation < itemAxes.length; rotation++)
            {
                itemAxes[rotation] = new ItemAxes(normal, right, up, rotation);
            }
        }
    }

    /** Maps item-local coordinates and normals into the world for one face and rotation. */
    private static final class ItemAxes
    {
        private static final double DIAGONAL = Math.sqrt(0.5);
        private static final double[] COSINE = {1, DIAGONAL, 0, -DIAGONAL, -1, -DIAGONAL, 0, DIAGONAL};
        private static final double[] SINE = {0, DIAGONAL, 1, DIAGONAL, 0, -DIAGONAL, -1, -DIAGONAL};
        private final ForgeDirection forward;
        private final double rightX;
        private final double rightY;
        private final double rightZ;
        private final double upX;
        private final double upY;
        private final double upZ;

        private ItemAxes(ForgeDirection forward, ForgeDirection right, ForgeDirection up, int rotation)
        {
            this.forward = forward;
            double cosine = COSINE[rotation];
            double sine = SINE[rotation];
            rightX = right.offsetX * cosine - up.offsetX * sine;
            rightY = right.offsetY * cosine - up.offsetY * sine;
            rightZ = right.offsetZ * cosine - up.offsetZ * sine;
            upX = right.offsetX * sine + up.offsetX * cosine;
            upY = right.offsetY * sine + up.offsetY * cosine;
            upZ = right.offsetZ * sine + up.offsetZ * cosine;
        }

        private float shade(double horizontal, double vertical, double depth)
        {
            double normalX = horizontal * rightX + vertical * upX + depth * forward.offsetX;
            double normalY = horizontal * rightY + vertical * upY + depth * forward.offsetY;
            double normalZ = horizontal * rightZ + vertical * upZ + depth * forward.offsetZ;
            return itemShade(normalX, normalY, normalZ);
        }

        private void addVertex(Tessellator tessellator, double x, double y, double z,
                               double horizontal, double vertical, double depth, double u, double v)
        {
            double vertexX = x + horizontal * rightX + vertical * upX + depth * forward.offsetX;
            double vertexY = y + horizontal * rightY + vertical * upY + depth * forward.offsetY;
            double vertexZ = z + horizontal * rightZ + vertical * upZ + depth * forward.offsetZ;
            tessellator.addVertexWithUV(vertexX, vertexY, vertexZ, u, v);
        }
    }
}
