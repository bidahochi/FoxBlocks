package com.bidahochi.BlockMod.blocks.constructionmaterials;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseBlockPane;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

import static com.bidahochi.BlockMod.core.handler.RenderBlockHandler.PATTERNED_PANE_RENDER_ID;

/**
 * Provides metadata-based FoxBlocks glass panes with modern connection,
 * selection, and collision behavior.
 */
public class GlassAssortedPane extends BaseBlockPane
{
    private static final float PANE_MIN = 0.4375F;
    private static final float PANE_MAX = 0.5625F;

    /**
     * Creates the assorted pane variants that share the assorted-glass texture set.
     */
    public GlassAssortedPane()
    {
        super(net.minecraft.block.material.Material.glass);
        setBlockTextureName(FoxBlocks.MODID + ":constructionmaterials/glass/assortedGlass");
        setBlockName("glassAssortedPane");
        amountOfSubBlocks = 8;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return PATTERNED_PANE_RENDER_ID;
    }

    /**
     * Extends the Minecraft 1.7 pane rules to recognize the matching FoxBlocks
     * glass block, which is transparent and therefore is not side-solid.
     */
    @Override
    public boolean canPaneConnectTo(IBlockAccess world, int x, int y, int z, ForgeDirection direction)
    {
        return world.getBlock(x, y, z) == BlockIDs.glassAssorted.block
                || super.canPaneConnectTo(world, x, y, z, direction);
    }

    /**
     * Uses a center-post selection box for an isolated pane. Connected panes
     * retain the established Minecraft 1.7 bounds for their visible arms.
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        if (hasHorizontalConnection(world, x, y, z))
        {
            super.setBlockBoundsBasedOnState(world, x, y, z);
        }
        else
        {
            setBlockBounds(PANE_MIN, 0.0F, PANE_MIN, PANE_MAX, 1.0F, PANE_MAX);
        }
    }

    /**
     * Adds only the center-post collision box when the pane has no horizontal
     * connections, preventing invisible collision arms around isolated panes.
     */
    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z,
                                        AxisAlignedBB mask, List boxes, Entity entity)
    {
        if (hasHorizontalConnection(world, x, y, z))
        {
            super.addCollisionBoxesToList(world, x, y, z, mask, boxes, entity);
            return;
        }

        AxisAlignedBB centerPost = AxisAlignedBB.getBoundingBox(
                x + PANE_MIN, y, z + PANE_MIN,
                x + PANE_MAX, y + 1.0D, z + PANE_MAX
        );

        if (mask.intersectsWith(centerPost))
        {
            boxes.add(centerPost);
        }
    }

    /**
     * Reports whether any horizontal neighbor should receive a pane arm.
     */
    private boolean hasHorizontalConnection(IBlockAccess world, int x, int y, int z)
    {
        return canPaneConnectTo(world, x, y, z - 1, ForgeDirection.NORTH)
                || canPaneConnectTo(world, x, y, z + 1, ForgeDirection.SOUTH)
                || canPaneConnectTo(world, x - 1, y, z, ForgeDirection.WEST)
                || canPaneConnectTo(world, x + 1, y, z, ForgeDirection.EAST);
    }
}
