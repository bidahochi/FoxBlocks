package com.bidahochi.BlockMod.blocks.displayframe.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Captures item sprites for the Display Frame preview atlas. */
public final class DisplayFrameThumbnail
{
    private static final int SIZE = DisplayFramePreviews.SIZE;
    /** Width of the nameplate region and its square atlas slot, in pixels. */
    public static final int LABEL_WIDTH = 128;
    /** Height of the nameplate region inside its square atlas slot, in pixels. */
    public static final int LABEL_HEIGHT = 24;
    private static final int LABEL_PADDING = 3;
    private static final int LABEL_BACKGROUND = 0xFF302318;
    private static final int LABEL_FOREGROUND = 0xFFFFF2D2;
    /** Normalized alpha threshold shared by thumbnail capture and icon outline generation. */
    public static final float ALPHA_CUTOFF = 0.1F;
    private static final int FRAMEBUFFER_BINDING = 0x8CA6;
    private static final int RENDERBUFFER_BINDING = 0x8CA7;
    private final RenderItem renderer = new RenderItem();
    private final RenderBlocks blocks = new RenderBlocks();
    private final PixelCapture itemCapture = new PixelCapture(SIZE);
    private PixelCapture labelCapture;

    /** Creates a thumbnail capture helper that allocates its framebuffer on first use. */
    public DisplayFrameThumbnail()
    {
    }

    /**
     * Renders an item into a reusable off-screen buffer and reads its pixels for the terrain atlas.
     * Returns null if framebuffer rendering is unavailable or the result is transparent.
     * Restores the caller's OpenGL state before returning.
     */
    public int[] capture(Minecraft minecraft, ItemStack stack)
    {
        return itemCapture.capture(16, SIZE, () ->
        {
            RenderHelper.enableGUIStandardItemLighting();
            TextureManager textures = minecraft.getTextureManager();
            boolean customRendererDrewItem = ForgeHooksClient.renderInventoryItem(blocks, textures, stack, true, 0, 0, 0);
            if (customRendererDrewItem == false)
            {
                renderer.renderItemIntoGUI(minecraft.fontRenderer, textures, stack, 0, 0, false);
            }
        });
    }

    /** Lays out a name in at most two font-width-constrained lines. */
    public static List<String> fitLabel(FontRenderer font, String name)
    {
        int textWidth = LABEL_WIDTH - 2 * LABEL_PADDING;
        if (font.getStringWidth(name) <= textWidth)
        {
            return Collections.singletonList(name);
        }

        String first = trimLine(font, name, textWidth);
        String rest = name.substring(first.length()).trim();
        if (font.getStringWidth(rest) <= textWidth)
        {
            return Arrays.asList(first, rest);
        }

        String ellipsis = font.getCharWidth('\u2026') > 0 ? "\u2026" : "...";
        int widthBeforeEllipsis = textWidth - font.getStringWidth(ellipsis);
        String second = trimLine(font, rest, widthBeforeEllipsis);
        return Arrays.asList(first, second + ellipsis);
    }

    /** Fits a line at the last available word break, splitting a long word only when needed. */
    private static String trimLine(FontRenderer font, String text, int width)
    {
        String prefix = font.trimStringToWidth(text, width);
        if (prefix.length() < text.length() && text.charAt(prefix.length()) == ' ')
        {
            return prefix;
        }
        int lastSpace = prefix.lastIndexOf(' ');
        return lastSpace > 0 ? prefix.substring(0, lastSpace) : prefix;
    }

    /** Rasterizes a fitted label into a strip, padding the text above and below for mipmaps. */
    public int[] captureLabel(FontRenderer font, List<String> lines, int stripHeight)
    {
        if (labelCapture == null)
        {
            labelCapture = new PixelCapture(LABEL_WIDTH);
        }
        return labelCapture.capture(LABEL_WIDTH, stripHeight, () ->
        {
            GL11.glDisable(GL11.GL_LIGHTING);
            Gui.drawRect(0, 0, LABEL_WIDTH, stripHeight, LABEL_BACKGROUND);
            int lineTop = (LABEL_HEIGHT - lines.size() * font.FONT_HEIGHT) / 2;
            for (String line : lines)
            {
                int lineLeft = (LABEL_WIDTH - font.getStringWidth(line)) / 2;
                font.drawString(line, lineLeft, lineTop, LABEL_FOREGROUND);
                lineTop += font.FONT_HEIGHT;
            }
        });
    }

    private static final class PixelCapture
    {
        private final int size;
        private final ByteBuffer readback;
        private Framebuffer target;

        private PixelCapture(int size)
        {
            this.size = size;
            readback = BufferUtils.createByteBuffer(size * size * 4);
        }

        /** Captures the requested rows from the top of the framebuffer and restores graphics state. */
        private int[] capture(int drawingSize, int rows, Runnable draw)
        {
            if (OpenGlHelper.isFramebufferEnabled() == false)
            {
                return null;
            }

            int framebuffer = GL11.glGetInteger(FRAMEBUFFER_BINDING);
            int renderbuffer = GL11.glGetInteger(RENDERBUFFER_BINDING);
            int matrixMode = GL11.glGetInteger(GL11.GL_MATRIX_MODE);
            GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
            GL11.glPushClientAttrib(GL11.GL_CLIENT_PIXEL_STORE_BIT | GL11.GL_CLIENT_VERTEX_ARRAY_BIT);
            OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glPushMatrix();
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glPushMatrix();
            try
            {
                if (target == null)
                {
                    target = new Framebuffer(size, size, true);
                    target.setFramebufferColor(0, 0, 0, 0);
                }

                target.bindFramebuffer(true);
                GL11.glDrawBuffer(OpenGlHelper.field_153200_g);
                GL11.glReadBuffer(OpenGlHelper.field_153200_g);
                GL11.glDisable(GL11.GL_SCISSOR_TEST);
                GL11.glDisable(GL11.GL_FOG);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColorMask(true, true, true, true);
                GL11.glDepthMask(true);
                GL11.glClearColor(0, 0, 0, 0);
                GL11.glClearDepth(1);
                GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
                GL11.glEnable(GL11.GL_DEPTH_TEST);
                GL11.glDepthFunc(GL11.GL_LEQUAL);
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glEnable(GL11.GL_ALPHA_TEST);
                GL11.glAlphaFunc(GL11.GL_GREATER, ALPHA_CUTOFF);
                GL11.glEnable(GL12.GL_RESCALE_NORMAL);
                GL11.glColor4f(1, 1, 1, 1);
                GL11.glMatrixMode(GL11.GL_PROJECTION);
                GL11.glLoadIdentity();
                GL11.glOrtho(0, drawingSize, drawingSize, 0, 1000, 3000);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glLoadIdentity();
                GL11.glTranslatef(0, 0, -2000);
                draw.run();
                GL11.glPixelStorei(GL11.GL_PACK_ALIGNMENT, 1);
                GL11.glPixelStorei(GL11.GL_PACK_ROW_LENGTH, 0);
                GL11.glPixelStorei(GL11.GL_PACK_SKIP_PIXELS, 0);
                GL11.glPixelStorei(GL11.GL_PACK_SKIP_ROWS, 0);
                readback.clear();
                GL11.glReadPixels(0, size - rows, size, rows, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, readback);
                return toAtlasPixels(rows);
            }
            finally
            {
                OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, framebuffer);
                OpenGlHelper.func_153176_h(OpenGlHelper.field_153199_f, renderbuffer);
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
        }

        private int[] toAtlasPixels(int rows)
        {
            int[] pixels = new int[size * rows];
            boolean visible = false;
            for (int y = 0; y < rows; y++)
            {
                for (int x = 0; x < size; x++)
                {
                    // OpenGL returns rows bottom-up in RGBA order. The atlas expects top-down ARGB.
                    int byteOffset = ((rows - 1 - y) * size + x) * 4;
                    int red = Byte.toUnsignedInt(readback.get(byteOffset));
                    int green = Byte.toUnsignedInt(readback.get(byteOffset + 1));
                    int blue = Byte.toUnsignedInt(readback.get(byteOffset + 2));
                    int alpha = Byte.toUnsignedInt(readback.get(byteOffset + 3));
                    visible = visible || alpha > 255 * ALPHA_CUTOFF;
                    pixels[y * size + x] = (alpha << 24) | (red << 16) | (green << 8) | blue;
                }
            }
            return visible ? pixels : null;
        }
    }
}
