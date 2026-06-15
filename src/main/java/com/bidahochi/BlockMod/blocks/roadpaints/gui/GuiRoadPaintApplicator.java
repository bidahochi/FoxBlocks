package com.bidahochi.BlockMod.blocks.roadpaints.gui;

import com.bidahochi.BlockMod.blocks.roadpaints.RoadPaintCatalog;
import com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer.BaseRoadPaintBlockContainer;
import com.bidahochi.BlockMod.core.handler.ItemIDs;
import com.bidahochi.BlockMod.core.handler.PacketHandler;
import com.bidahochi.BlockMod.items.ItemRoadPaintApplicator;
import com.bidahochi.BlockMod.network.PacketRoadPaintApplicatorRefill;
import com.bidahochi.BlockMod.network.PacketRoadPaintApplicatorSettings;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

public class GuiRoadPaintApplicator extends GuiScreen {
    private static final int GRID_COLUMNS = 6;
    private static final int GRID_ROWS = 3;
    private static final int PAGE_SIZE = GRID_COLUMNS * GRID_ROWS;
    private static final int PATTERN_BUTTON_START = 100;
    private static final int GUI_WIDTH = 300;
    private static final int GUI_HEIGHT = 230;
    private static final int GRID_TOP = 28;
    private static final int SUMMARY_TOP = 115;
    private static final int CONTROLS_TOP = 141;
    private static final int HEIGHT_TOP = 166;
    private static final int ACTIONS_TOP = 191;

    private final EntityPlayer player;
    private final int slot;
    private final RenderItem renderItem = new RenderItem();
    private int selection;
    private int rotation;
    private boolean manualRotation;
    private boolean layered;
    private int heightOverride;
    private RoadPaintCatalog.Category category;
    private int page;
    private List<Integer> visibleEntries = new ArrayList<Integer>();

    public GuiRoadPaintApplicator(EntityPlayer player) {
        this.player = player;
        this.slot = player.inventory.currentItem;
        ItemStack stack = player.inventory.getStackInSlot(slot);
        selection = ItemRoadPaintApplicator.getSelection(stack);
        rotation = ItemRoadPaintApplicator.getRotation(stack);
        manualRotation = ItemRoadPaintApplicator.isManualRotation(stack);
        layered = ItemRoadPaintApplicator.isLayered(stack);
        heightOverride = ItemRoadPaintApplicator.getHeightOverride(stack);
        RoadPaintCatalog.Entry entry = RoadPaintCatalog.get(selection);
        int savedCategory = ItemRoadPaintApplicator.getGuiCategory(stack);
        category = savedCategory >= 0 && savedCategory < RoadPaintCatalog.Category.values().length
                ? RoadPaintCatalog.Category.values()[savedCategory]
                : entry == null ? RoadPaintCatalog.Category.CENTER : entry.category;
        page = Math.max(0, ItemRoadPaintApplicator.getGuiPage(stack));
    }

    @Override
    public void initGui() {
        rebuildButtons();
    }

    private void rebuildButtons() {
        buttonList.clear();
        int left = width / 2 - GUI_WIDTH / 2;
        int top = height / 2 - GUI_HEIGHT / 2;

        RoadPaintCatalog.Category[] categories = RoadPaintCatalog.Category.values();
        int tabWidth = GUI_WIDTH / categories.length;
        for (int i = 0; i < categories.length; i++) {
            RoadPaintCatalog.Category tab = categories[i];
            GuiButton button = new GuiButton(10 + i, left + i * tabWidth, top, tabWidth - 2, 20,
                    tab.getDisplayName());
            button.enabled = tab != category;
            buttonList.add(button);
        }

        visibleEntries = RoadPaintCatalog.indicesFor(category);
        int maxPage = Math.max(0, (visibleEntries.size() - 1) / PAGE_SIZE);
        page = Math.min(page, maxPage);

        int gridLeft = left + 9;
        int gridTop = top + GRID_TOP;
        int first = page * PAGE_SIZE;
        for (int cell = 0; cell < PAGE_SIZE && first + cell < visibleEntries.size(); cell++) {
            int catalogIndex = visibleEntries.get(first + cell);
            int x = gridLeft + (cell % GRID_COLUMNS) * 47;
            int y = gridTop + (cell / GRID_COLUMNS) * 28;
            buttonList.add(new PatternButton(PATTERN_BUTTON_START + cell, x, y, 43, 24, catalogIndex));
        }

        buttonList.add(new GuiButton(0, left, top + CONTROLS_TOP, 25, 20, "<"));
        buttonList.add(new GuiButton(1, left + 275, top + CONTROLS_TOP, 25, 20, ">"));
        buttonList.add(new GuiButton(2, left + 30, top + CONTROLS_TOP, 92, 20, rotationModeLabel()));
        GuiButton rotateButton = new GuiButton(6, left + 126, top + CONTROLS_TOP, 48, 20,
                translateFormatted("rotation.angle", rotation * 90));
        rotateButton.enabled = manualRotation;
        buttonList.add(rotateButton);
        buttonList.add(new GuiButton(3, left + 178, top + CONTROLS_TOP, 92, 20, modeLabel()));
        buttonList.add(new GuiButton(7, left, top + HEIGHT_TOP, GUI_WIDTH, 20, heightLabel()));
        buttonList.add(new GuiButton(4, left, top + ACTIONS_TOP, 195, 20, translate("loadCompound")));
        buttonList.add(new GuiButton(5, left + 200, top + ACTIONS_TOP, 100, 20, translate("done")));
    }

    private String modeLabel() {
        return translateFormatted("mode",
                translate(layered ? "mode.layered" : "mode.protected"));
    }

    private String rotationModeLabel() {
        return translateFormatted("rotation.mode",
                translate(manualRotation ? "rotation.manual" : "rotation.auto"));
    }

    private String heightLabel() {
        return translateFormatted("height", translate(heightTranslationKey(heightOverride)));
    }

    private String heightTranslationKey(int value) {
        if (value == ItemRoadPaintApplicator.HEIGHT_FULL_BLOCK) {
            return "height.fullBlock";
        }
        if (value == ItemRoadPaintApplicator.HEIGHT_SLAB) {
            return "height.slab";
        }
        if (value == ItemRoadPaintApplicator.HEIGHT_ROAD_COVER) {
            return "height.roadCover";
        }
        return "height.auto";
    }

    private String translate(String suffix) {
        return StatCollector.translateToLocal("gui.foxblocks.roadPaintApplicator." + suffix);
    }

    private String translateFormatted(String suffix, Object... values) {
        return StatCollector.translateToLocalFormatted(
                "gui.foxblocks.roadPaintApplicator." + suffix, values);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id >= 10 && button.id < 10 + RoadPaintCatalog.Category.values().length) {
            category = RoadPaintCatalog.Category.values()[button.id - 10];
            page = 0;
            rebuildButtons();
            sendSettings();
            return;
        }

        if (button.id >= PATTERN_BUTTON_START) {
            int cell = button.id - PATTERN_BUTTON_START;
            int listIndex = page * PAGE_SIZE + cell;
            if (listIndex < visibleEntries.size()) {
                selection = visibleEntries.get(listIndex);
                sendSettings();
            }
            return;
        }

        switch (button.id) {
            case 0:
                page = Math.max(0, page - 1);
                rebuildButtons();
                sendSettings();
                break;
            case 1:
                int maxPage = Math.max(0, (visibleEntries.size() - 1) / PAGE_SIZE);
                page = Math.min(maxPage, page + 1);
                rebuildButtons();
                sendSettings();
                break;
            case 2:
                manualRotation = !manualRotation;
                rebuildButtons();
                sendSettings();
                break;
            case 3:
                layered = !layered;
                button.displayString = modeLabel();
                sendSettings();
                break;
            case 4:
                PacketHandler.sendPacketToServer(new PacketRoadPaintApplicatorRefill(slot));
                break;
            case 5:
                mc.displayGuiScreen(null);
                break;
            case 6:
                rotation = (rotation + 1) & 3;
                button.displayString = translateFormatted("rotation.angle", rotation * 90);
                sendSettings();
                break;
            case 7:
                heightOverride = ItemRoadPaintApplicator.nextHeightOverride(heightOverride);
                rebuildButtons();
                sendSettings();
                break;
            default:
                break;
        }
    }

    private void sendSettings() {
        PacketHandler.sendPacketToServer(
                new PacketRoadPaintApplicatorSettings(
                        slot, selection, rotation, manualRotation, layered, heightOverride,
                        category.ordinal(), page));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ItemStack held = player.inventory.getStackInSlot(slot);
        if (held == null || !(held.getItem() instanceof ItemRoadPaintApplicator)
                || player.inventory.currentItem != slot) {
            mc.displayGuiScreen(null);
            return;
        }

        drawDefaultBackground();
        int center = width / 2;
        int top = height / 2 - GUI_HEIGHT / 2;
        drawCenteredString(fontRendererObj, translate("title"), center, top - 13, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);

        RoadPaintCatalog.Entry selected = RoadPaintCatalog.get(selection);
        String selectedName = selected == null ? translate("none") : selected.getDisplayName();
        drawCenteredString(fontRendererObj, translateFormatted("selected", selectedName),
                center, top + SUMMARY_TOP, 0xFFFFFF);
        String paintStatus = player.capabilities.isCreativeMode
                ? translate("paint.creative")
                : translateFormatted("paint.charges",
                ItemRoadPaintApplicator.getCharges(held), ItemRoadPaintApplicator.MAX_CHARGES);
        drawCenteredString(fontRendererObj,
                translateFormatted("summary", paintStatus,
                        manualRotation
                                ? translateFormatted("rotation.degrees", rotation * 90)
                                : translate("rotation.auto"),
                        page + 1,
                        Math.max(1, (visibleEntries.size() + PAGE_SIZE - 1) / PAGE_SIZE)),
                center, top + SUMMARY_TOP + 11, 0xDDDDDD);

        int compounds = 0;
        for (ItemStack stack : player.inventory.mainInventory) {
            if (stack != null && stack.getItem() == ItemIDs.paintCompound.item) {
                compounds += stack.stackSize;
            }
        }
        drawCenteredString(fontRendererObj, translateFormatted("compoundAvailable", compounds),
                center, top + ACTIONS_TOP + 23, 0xAAAAAA);

        for (Object object : buttonList) {
            if (object instanceof PatternButton) {
                PatternButton pattern = (PatternButton) object;
                if (pattern.func_146115_a()) {
                    RoadPaintCatalog.Entry entry = RoadPaintCatalog.get(pattern.catalogIndex);
                    if (entry != null) {
                        drawHoveringText(java.util.Collections.singletonList(entry.getDisplayName()), mouseX, mouseY, fontRendererObj);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) {
        if (keyCode == mc.gameSettings.keyBindInventory.getKeyCode()) {
            mc.displayGuiScreen(null);
            return;
        }
        super.keyTyped(typedChar, keyCode);
    }

    private class PatternButton extends GuiButton {
        private final int catalogIndex;

        private PatternButton(int id, int x, int y, int width, int height, int catalogIndex) {
            super(id, x, y, width, height, "");
            this.catalogIndex = catalogIndex;
        }

        @Override
        public void drawButton(net.minecraft.client.Minecraft minecraft, int mouseX, int mouseY) {
            super.drawButton(minecraft, mouseX, mouseY);
            RoadPaintCatalog.Entry entry = RoadPaintCatalog.get(catalogIndex);
            if (entry == null) {
                return;
            }
            Item item = Item.getItemFromBlock(entry.block);
            if (item != null) {
                RenderHelper.enableGUIStandardItemLighting();
                renderItem.renderItemAndEffectIntoGUI(fontRendererObj, minecraft.getTextureManager(),
                        new ItemStack(item, 1, entry.metadata), xPosition + 13, yPosition + 4);
                RenderHelper.disableStandardItemLighting();
            } else {
                BaseRoadPaintBlockContainer paint = (BaseRoadPaintBlockContainer) entry.block;
                String label = paint.color.substring(0, 1).toUpperCase()
                        + (paint.offset.startsWith("center") ? "C" : "O");
                drawCenteredString(fontRendererObj, label, xPosition + width / 2, yPosition + 8, 0xFFFFFF);
            }
            if (catalogIndex == selection) {
                drawRect(xPosition, yPosition, xPosition + width, yPosition + 2, 0xFFFFFF00);
                drawRect(xPosition, yPosition + height - 2, xPosition + width, yPosition + height, 0xFFFFFF00);
            }
        }
    }
}
