package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.blocks.roadpaints.RoadPaintCatalog;
import com.bidahochi.BlockMod.items.ItemRoadPaintApplicator;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class RoadPaintApplicatorHud {
    private final RenderItem renderItem = new RenderItem();

    @SubscribeEvent
    public void renderSelectedPaint(RenderGameOverlayEvent.Post event) {
        if (event.type != RenderGameOverlayEvent.ElementType.HOTBAR) {
            return;
        }

        Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft.thePlayer == null || minecraft.currentScreen != null) {
            return;
        }

        ItemStack held = minecraft.thePlayer.getHeldItem();
        if (held == null || !(held.getItem() instanceof ItemRoadPaintApplicator)) {
            return;
        }

        RoadPaintCatalog.Entry selected =
                RoadPaintCatalog.get(ItemRoadPaintApplicator.getSelection(held));
        String paintName = selected == null
                ? StatCollector.translateToLocal("gui.foxblocks.roadPaintApplicator.none")
                : selected.getDisplayName();
        String text = StatCollector.translateToLocalFormatted(
                "gui.foxblocks.roadPaintApplicator.hud.selected", paintName);
        ScaledResolution resolution =
                new ScaledResolution(minecraft, minecraft.displayWidth, minecraft.displayHeight);
        Item paintItem = selected == null ? null : Item.getItemFromBlock(selected.block);
        int iconWidth = paintItem == null ? 0 : 20;
        int groupWidth = iconWidth + minecraft.fontRenderer.getStringWidth(text);
        int x = (resolution.getScaledWidth() - groupWidth) / 2;
        int y = resolution.getScaledHeight() - 76;

        if (paintItem != null) {
            RenderHelper.enableGUIStandardItemLighting();
            renderItem.renderItemAndEffectIntoGUI(minecraft.fontRenderer, minecraft.getTextureManager(),
                    new ItemStack(paintItem, 1, selected.metadata), x, y);
            RenderHelper.disableStandardItemLighting();
        }
        minecraft.fontRenderer.drawStringWithShadow(text, x + iconWidth, y + 4, 0xFFFFFF);
    }
}
