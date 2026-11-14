package com.bidahochi.BlockMod.blocks.displayframe.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

final class DisplayFrameBlockMesh
{
    private static final int VIEWPORT_SIZE = 1024;
    private static final int FLOATS_PER_VERTEX = 11;
    private static final int CHEST_RENDER_TYPE = 22;
    private static final int FIRST_FORGE_RENDER_TYPE = 42;
    private static final double ANCHOR_DEPTH = 3.0 / 64;
    private static final double BACKING_DEPTH = 1.0 / 32;
    private final FloatBuffer feedback = BufferUtils.createFloatBuffer(16384);

    /**
     * Captures vanilla inventory geometry and terrain UVs for use in the chunk mesh.
     * Returns null for unsupported renderers or invalid geometry and restores the caller's OpenGL state.
     */
    Mesh capture(Minecraft minecraft, ItemStack stack)
    {
        Item item = stack.getItem();
        if ((item instanceof ItemBlock) == false || item.getSpriteNumber() != 0
                || MinecraftForgeClient.getItemRenderer(stack, ItemRenderType.ENTITY) != null)
        {
            return null;
        }
        Block block = Block.getBlockFromItem(item);
        int renderType = block.getRenderType();
        if (RenderBlocks.renderItemIn3d(renderType) == false || block.getRenderBlockPass() != 0)
        {
            return null;
        }
        // Chest models and Forge inventory handlers can use textures outside the terrain atlas.
        if (renderType == CHEST_RENDER_TYPE || renderType >= FIRST_FORGE_RENDER_TYPE
                || GL11.glGetInteger(GL11.GL_RENDER_MODE) != GL11.GL_RENDER)
        {
            return null;
        }

        int matrixMode = GL11.glGetInteger(GL11.GL_MATRIX_MODE);
        float minX = (float) block.getBlockBoundsMinX();
        float minY = (float) block.getBlockBoundsMinY();
        float minZ = (float) block.getBlockBoundsMinZ();
        float maxX = (float) block.getBlockBoundsMaxX();
        float maxY = (float) block.getBlockBoundsMaxY();
        float maxZ = (float) block.getBlockBoundsMaxZ();
        int count;
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glPushClientAttrib(GL11.GL_CLIENT_VERTEX_ARRAY_BIT);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GL11.glMatrixMode(GL11.GL_TEXTURE);
        GL11.glPushMatrix();
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPushMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPushMatrix();
        try
        {
            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GL11.glOrtho(-1, 1, -1, 1, -1, 1);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glViewport(0, 0, VIEWPORT_SIZE, VIEWPORT_SIZE);
            GL11.glDepthRange(0, 1);
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_TEXTURE_GEN_S);
            GL11.glDisable(GL11.GL_TEXTURE_GEN_T);
            GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
            GL11.glColor4f(1, 1, 1, 1);
            minecraft.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);

            // Match RenderItem's in-frame scale and orientation without the animated bob.
            GL11.glTranslated(0, -0.0175, ANCHOR_DEPTH);
            double scale;
            switch (renderType)
            {
                case 1:
                case 2:
                case 12:
                case 19:
                    scale = 0.625;
                    break;
                default:
                    scale = 0.3125;
                    break;
            }
            GL11.glScaled(scale, scale, scale);
            GL11.glRotatef(-90, 0, 1, 0);

            feedback.clear();
            GL11.glFeedbackBuffer(GL11.GL_3D_COLOR_TEXTURE, feedback);
            GL11.glRenderMode(GL11.GL_FEEDBACK);
            try
            {
                new RenderBlocks().renderBlockAsItem(block, stack.getItemDamage(), 1);
            }
            finally
            {
                count = GL11.glRenderMode(GL11.GL_RENDER);
            }
        }
        finally
        {
            block.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glPopMatrix();
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glPopMatrix();
            OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glPopMatrix();
            GL11.glPopClientAttrib();
            GL11.glPopAttrib();
            GL11.glMatrixMode(matrixMode);
        }
        return count <= 0 ? null : readMesh(count);
    }

    /** Reads vertices, UVs, and tint captured by OpenGL without rasterizing, then clips them to fit the mount. */
    private Mesh readMesh(int length)
    {
        feedback.limit(length);
        List<Face> framed = new ArrayList<>();
        List<Face> againstWall = new ArrayList<>();
        List<Face> freestanding = new ArrayList<>();
        while (feedback.remaining() >= 2)
        {
            if (feedback.get() != GL11.GL_POLYGON_TOKEN)
            {
                return null;
            }
            int count = (int) feedback.get();
            if (count < 3 || count > 4 || feedback.remaining() < count * FLOATS_PER_VERTEX)
            {
                return null;
            }
            List<Vertex> vertices = new ArrayList<>(count);
            for (int index = 0; index < count; index++)
            {
                vertices.add(readVertex());
            }
            addFace(freestanding, vertices);
            List<Vertex> wallVertices = clip(vertices, 0.001);
            List<Vertex> framedVertices = clip(vertices, BACKING_DEPTH + 0.0001);
            addFace(againstWall, wallVertices);
            addFace(framed, framedVertices);
        }
        if (feedback.hasRemaining() || framed.isEmpty())
        {
            return null;
        }
        return new Mesh(framed, againstWall, freestanding);
    }

    private Vertex readVertex()
    {
        float x = feedback.get() * 2 / VIEWPORT_SIZE - 1;
        float y = feedback.get() * 2 / VIEWPORT_SIZE - 1;
        float z = 1 - feedback.get() * 2;
        float red = feedback.get();
        float green = feedback.get();
        float blue = feedback.get();
        feedback.get(); // Alpha
        float u = feedback.get();
        float v = feedback.get();
        feedback.position(feedback.position() + 2); // Texture R and Q
        return new Vertex(x, y, z, u, v, red, green, blue);
    }

    /** Trims a polygon to the part in front of the given local depth in blocks. */
    private static List<Vertex> clip(List<Vertex> vertices, double near)
    {
        List<Vertex> clipped = new ArrayList<>(vertices.size() + 1);
        Vertex previous = vertices.get(vertices.size() - 1);
        for (Vertex current : vertices)
        {
            boolean previousBehind = previous.z < near;
            boolean currentBehind = current.z < near;
            if (previousBehind != currentBehind)
            {
                double fractionToPlane = (near - previous.z) / (current.z - previous.z);
                Vertex intersection = previous.lerp(current, fractionToPlane);
                clipped.add(intersection);
            }
            if (current.z >= near)
            {
                clipped.add(current);
            }
            previous = current;
        }
        return clipped;
    }

    private static void addFace(List<Face> faces, List<Vertex> vertices)
    {
        if (vertices.size() < 3)
        {
            return;
        }
        Vertex a = vertices.get(0);
        for (int i = 2; i < vertices.size(); i++)
        {
            Vertex b = vertices.get(i - 1);
            Vertex c = vertices.get(i);
            double nx = (b.y - a.y) * (c.z - a.z) - (b.z - a.z) * (c.y - a.y);
            double ny = (b.z - a.z) * (c.x - a.x) - (b.x - a.x) * (c.z - a.z);
            double nz = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
            double magnitude = Math.sqrt(nx * nx + ny * ny + nz * nz);
            if (magnitude > 1e-8)
            {
                Vertex[] faceVertices = vertices.toArray(new Vertex[vertices.size()]);
                faces.add(new Face(faceVertices, nx / magnitude, ny / magnitude, nz / magnitude));
                return;
            }
        }
    }

    static final class Mesh
    {
        final Face[] framed;
        final Face[] againstWall;
        final Face[] freestanding;

        Mesh(List<Face> framed, List<Face> againstWall, List<Face> freestanding)
        {
            this.framed = framed.toArray(new Face[framed.size()]);
            this.againstWall = againstWall.toArray(new Face[againstWall.size()]);
            this.freestanding = freestanding.toArray(new Face[freestanding.size()]);
        }
    }

    static final class Face
    {
        final Vertex[] vertices;
        final double nx, ny, nz;

        Face(Vertex[] vertices, double nx, double ny, double nz)
        {
            this.vertices = vertices;
            this.nx = nx;
            this.ny = ny;
            this.nz = nz;
        }
    }

    static final class Vertex
    {
        final double x, y, z, u, v;
        final float red, green, blue;

        Vertex(double x, double y, double z, double u, double v, float red, float green, float blue)
        {
            this.x = x;
            this.y = y;
            this.z = z;
            this.u = u;
            this.v = v;
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        private Vertex lerp(Vertex other, double fraction)
        {
            double clippedX = x + (other.x - x) * fraction;
            double clippedY = y + (other.y - y) * fraction;
            double clippedZ = z + (other.z - z) * fraction;
            double clippedU = u + (other.u - u) * fraction;
            double clippedV = v + (other.v - v) * fraction;
            float clippedRed = (float) (red + (other.red - red) * fraction);
            float clippedGreen = (float) (green + (other.green - green) * fraction);
            float clippedBlue = (float) (blue + (other.blue - blue) * fraction);
            return new Vertex(clippedX, clippedY, clippedZ, clippedU, clippedV, clippedRed, clippedGreen, clippedBlue);
        }
    }
}
