package com.bidahochi.BlockMod.common.rotation.client;

import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/** Applies a horizontal rotation amount to the current OpenGL model matrix. */
@SideOnly(Side.CLIENT)
public final class RotationRenderHelper
{

    /** Prevents construction of this static utility class. */
    private RotationRenderHelper()
    {
    }

    /**
     * Applies a counter-clockwise Y-axis rotation around the current origin.
     *
     * @param rotation horizontal rotation; {@code null} applies zero degrees
     */
    public static void rotateY(RotationAmount rotation)
    {
        rotateY(rotation, 0.0F, false);
    }

    /**
     * Applies a Y-axis rotation with an additional model-authored yaw.
     *
     * @param rotation horizontal placement rotation; {@code null} means zero degrees
     * @param modelBaseRotationDegrees fixed model correction in degrees
     * @param clockwise whether to negate the placement rotation before applying it
     */
    public static void rotateY(
            RotationAmount rotation,
            float modelBaseRotationDegrees,
            boolean clockwise
    )
    {
        float rotationDegrees = rotation != null ? rotation.toDegrees() : 0.0F;
        if (clockwise)
        {
            rotationDegrees = -rotationDegrees;
        }
        GL11.glRotatef(modelBaseRotationDegrees + rotationDegrees, 0.0F, 1.0F, 0.0F);
    }
}
