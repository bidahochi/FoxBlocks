package com.bidahochi.BlockMod.blocks.roadpaints;

import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.ScrollRoadPaintBlock;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import com.bidahochi.BlockMod.utils.HelperUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RoadPaintCatalog {
    public enum Category {
        DYNAMIC("gui.foxblocks.roadPaintApplicator.category.dynamic"),
        CENTER("gui.foxblocks.roadPaintApplicator.category.center"),
        OFFSET("gui.foxblocks.roadPaintApplicator.category.offset"),
        SYMBOLS("gui.foxblocks.roadPaintApplicator.category.symbols");

        private final String translationKey;

        Category(String translationKey) {
            this.translationKey = translationKey;
        }

        public String getDisplayName() {
            return StatCollector.translateToLocal(translationKey);
        }
    }

    public static final class Entry {
        public final Block block;
        public final int metadata;
        public final Category category;
        public final boolean dynamic;

        private Entry(Block block, int metadata, Category category, boolean dynamic) {
            this.block = block;
            this.metadata = metadata;
            this.category = category;
            this.dynamic = dynamic;
        }

        public String getDisplayName() {
            Item item = Item.getItemFromBlock(block);
            if (item != null) {
                return new ItemStack(item, 1, metadata).getDisplayName();
            }
            return StatCollector.translateToLocal(block.getUnlocalizedName() + ".name");
        }

        public String getShape() {
            if (block instanceof ScrollRoadPaintBlock) {
                ScrollRoadPaintBlock scrolling = (ScrollRoadPaintBlock) block;
                return HelperUtils.getValueByIndex(scrolling.getShapeTextures(), metadata);
            }
            return "straight";
        }
    }

    private static final List<Entry> ENTRIES = new ArrayList<Entry>();

    private RoadPaintCatalog() {
    }

    public static void initialize() {
        ENTRIES.clear();
        addDynamic(BlockIDs.rpb_cy);
        addDynamic(BlockIDs.rpb_cy2);
        addDynamic(BlockIDs.rpb_cw);
        addDynamic(BlockIDs.rpb_cw2);
        addDynamic(BlockIDs.rpb_oyd);
        addDynamic(BlockIDs.rpb_oys);
        addDynamic(BlockIDs.rpb_owd);
        addDynamic(BlockIDs.rpb_ows);

        addStatic(BlockIDs.srpb_cy, Category.CENTER);
        addStatic(BlockIDs.srpb_cy2, Category.CENTER);
        addStatic(BlockIDs.srpb_cysd, Category.CENTER);
        addStatic(BlockIDs.srpb_cw, Category.CENTER);
        addStatic(BlockIDs.srpb_cw2, Category.CENTER);
        addStatic(BlockIDs.srpb_cwsd, Category.CENTER);
        addStatic(BlockIDs.srpb_whiteOffset, Category.OFFSET);
        addStatic(BlockIDs.srpb_yellowOffset, Category.OFFSET);
        addStatic(BlockIDs.srpb_dw1, Category.SYMBOLS);
        addStatic(BlockIDs.srpb_dw2, Category.SYMBOLS);
    }

    private static void addDynamic(BlockIDs id) {
        if (id.block != null) {
            ENTRIES.add(new Entry(id.block, 0, Category.DYNAMIC, true));
        }
    }

    private static void addStatic(BlockIDs id, Category category) {
        if (!(id.block instanceof ScrollRoadPaintBlock)) {
            return;
        }
        ScrollRoadPaintBlock block = (ScrollRoadPaintBlock) id.block;
        for (int metadata = 0; metadata < block.getShapeTextures().size(); metadata++) {
            ENTRIES.add(new Entry(id.block, metadata, category, false));
        }
    }

    public static List<Entry> entries() {
        return Collections.unmodifiableList(ENTRIES);
    }

    public static Entry get(int index) {
        return index >= 0 && index < ENTRIES.size() ? ENTRIES.get(index) : null;
    }

    public static List<Integer> indicesFor(Category category) {
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < ENTRIES.size(); i++) {
            if (ENTRIES.get(i).category == category) {
                indices.add(i);
            }
        }
        return indices;
    }
}
