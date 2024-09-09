package com.bidahochi.BlockMod.blocks.roadpaints.TileEntitySpecialRenderer.centered_yellow;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntitySpecialRenderer.BaseRoadPaintBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRpb_cy_r extends BaseRoadPaintBlock
{
    public RenderRpb_cy_r()
    {
        setTexture2("rpb_cy_r.png");
    }
}