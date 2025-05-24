package com.bidahochi.BlockMod.blocks.BaseClassFolder;

import net.minecraft.util.MathHelper;

public class BaseTileEntityOmniDirection extends BaseTileEntity
{
    public BaseTileEntityOmniDirection(float entityRotationYaw)
    {
        super(MathHelper.floor_double(((entityRotationYaw) * 8.0F / 360.0F + 0.5D)) & 18);
    }
}
