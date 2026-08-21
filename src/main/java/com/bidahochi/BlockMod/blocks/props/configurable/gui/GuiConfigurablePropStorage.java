package com.bidahochi.BlockMod.blocks.props.configurable.gui;

import com.bidahochi.BlockMod.blocks.props.configurable.inventory.ContainerConfigurablePropStorage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

/** Displays either a controller inventory or one selected named compartment. */
@SideOnly(Side.CLIENT)
public class GuiConfigurablePropStorage extends GuiContainer
{

    private static final ResourceLocation TEXTURE =
            new ResourceLocation("textures/gui/container/generic_54.png");
    private final IInventory storage;
    /** Number of visible storage rows used to crop the generic chest texture. */
    private final int storageRows;

    /**
     * Creates a client screen for a controller or compartment inventory.
     *
     * @param playerInventory interacting player's inventory
     * @param storage controller or compartment inventory displayed by the GUI
     */
    public GuiConfigurablePropStorage(InventoryPlayer playerInventory, IInventory storage)
    {
        super(new ContainerConfigurablePropStorage(playerInventory, storage));
        this.storage = storage;
        storageRows = (storage.getSizeInventory() + 8) / 9;
        ySize = 114 + storageRows * 18;
    }

    /** {@inheritDoc} */
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        fontRendererObj.drawString(
                StatCollector.translateToLocal(storage.getInventoryName()),
                8,
                6,
                4210752
        );
        fontRendererObj.drawString(
                StatCollector.translateToLocal("container.inventory"),
                8,
                ySize - 94,
                4210752
        );
    }

    /** {@inheritDoc} */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(TEXTURE);
        int left = (width - xSize) / 2;
        int top = (height - ySize) / 2;
        int storageHeight = 17 + storageRows * 18;
        drawTexturedModalRect(left, top, 0, 0, xSize, storageHeight);
        drawTexturedModalRect(left, top + storageHeight, 0, 126, xSize, 96);
    }
}
