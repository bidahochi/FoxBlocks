package com.bidahochi.BlockMod.blocks.roadpaints;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.BaseRoadPaintBlockContainer;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import net.minecraft.block.Block;

public final class RoadPaintPlacement {
    private static final ThreadLocal<Boolean> ALLOW_STACKING = new ThreadLocal<Boolean>();

    private RoadPaintPlacement() {
    }

    public static boolean isRoadPaint(Block block) {
        return block instanceof ScrollRoadPaintBlock || block instanceof BaseRoadPaintBlockContainer;
    }

    public static boolean isStackingAllowed() {
        return Boolean.TRUE.equals(ALLOW_STACKING.get());
    }

    public static void setStackingAllowed(boolean allowed) {
        if (allowed) {
            ALLOW_STACKING.set(Boolean.TRUE);
        } else {
            ALLOW_STACKING.remove();
        }
    }

}
