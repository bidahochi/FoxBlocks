package com.bidahochi.BlockMod.blocks.props.configurable.gui;

import com.bidahochi.BlockMod.blocks.props.configurable.client.ConfigurablePropPreviewRenderer;
import com.bidahochi.BlockMod.blocks.props.configurable.data.ConfigurablePropHeightMode;
import com.bidahochi.BlockMod.blocks.props.configurable.data.PropPlacementOffset;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.item.ItemBlockConfigurableProp;
import com.bidahochi.BlockMod.core.handler.PacketHandler;
import com.bidahochi.BlockMod.customization.data.AppearanceData;
import com.bidahochi.BlockMod.customization.data.CustomizationNumberParser;
import com.bidahochi.BlockMod.customization.registry.CustomizationProfile;
import com.bidahochi.BlockMod.customization.registry.CustomizationRegistry;
import com.bidahochi.BlockMod.customization.registry.CustomizationTrait;
import com.bidahochi.BlockMod.customization.registry.CustomizationTraitOption;
import com.bidahochi.BlockMod.customization.registry.SkinDefinition;
import com.bidahochi.BlockMod.network.PacketConfigureConfigurablePropItem;
import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.Collections;
import java.util.List;

/** Edits an item's profile-defined appearance and placement options before placement. */
@SideOnly(Side.CLIENT)
public class GuiConfigurablePropCustomization extends GuiScreen
{

    private static final int GRID_COLUMNS = 4;
    private static final int GRID_ROWS = 3;
    private static final int PAGE_SIZE = GRID_COLUMNS * GRID_ROWS;
    private static final int OPTION_BUTTON_START = 100;
    private static final int OFFSET_RESET_BUTTON = 300;
    private static final int MODEL_FLIP_BUTTON = 400;
    private static final int HEIGHT_MODE_BUTTON = 500;
    private static final int ROTATION_MODE_BUTTON = 600;
    private static final int MAX_GUI_WIDTH = 420;
    private static final int GUI_HEIGHT = 258;
    private static final int LEFT_COLUMN_WIDTH = 210;
    private static final int PREVIEW_LEFT = 225;
    private static final int SELECTED_PREVIEW_TEXT_TOP = 160;
    private static final int OFFSET_ROW_TOP = 178;
    private static final int ROTATION_ROW_TOP = 207;
    private static final int ACTION_ROW_TOP = 235;
    private static final float PREVIEW_YAW = 135.0F;

    private final EntityPlayer player;
    private final int slot;
    private final ConfigurablePropDefinition definition;
    private final CustomizationProfile profile;
    private final ConfigurablePropPreviewRenderer previewRenderer = new ConfigurablePropPreviewRenderer();
    private AppearanceData appearance;
    private PropPlacementOffset offset;
    private ConfigurablePropHeightMode heightMode;
    private boolean modelFlipped;
    private boolean manualPlacementRotation;
    private RotationAmount placementRotation;
    private GuiTextField redField;
    private GuiTextField greenField;
    private GuiTextField blueField;
    private GuiTextField offsetRightField;
    private GuiTextField offsetUpField;
    private GuiTextField offsetForwardField;
    private GuiTextField placementRotationField;
    private int traitIndex;
    private int optionPage;

    /**
     * Opens an editor for the configurable prop in one player inventory slot.
     *
     * @param player player whose inventory contains the item
     * @param slot zero-based player inventory slot submitted to the server
     * @param stack current configurable prop stack used to initialize controls
     */
    public GuiConfigurablePropCustomization(EntityPlayer player, int slot, ItemStack stack)
    {
        this.player = player;
        this.slot = slot;
        ItemBlockConfigurableProp item = (ItemBlockConfigurableProp) stack.getItem();
        appearance = item.getAppearance(stack);
        offset = item.getPlacementOffset(stack);
        heightMode = item.getHeightMode(stack);
        modelFlipped = item.isModelFlipped(stack);
        manualPlacementRotation = item.isManualPlacementRotation(stack);
        placementRotation = item.getManualPlacementRotation(stack);
        definition = item.getConfigurablePropDefinition();
        profile = definition != null
                ? CustomizationRegistry.getProfile(definition.getCustomizationProfileId())
                : null;
    }

    /** {@inheritDoc} */
    @Override
    public void initGui()
    {
        rebuildButtons();
    }

    /**
     * Recreates trait, page, offset, and action controls from the current edit
     * state. Fields from inactive trait kinds are cleared to prevent stale input.
     */
    private void rebuildButtons()
    {
        buttonList.clear();
        int guiWidth = getGuiWidth();
        int left = getGuiLeft(guiWidth);
        int top = height / 2 - GUI_HEIGHT / 2;
        CustomizationTrait trait = getActiveTrait();
        List<CustomizationTraitOption> options = getActiveOptions();
        int maxPage = Math.max(0, (options.size() - 1) / PAGE_SIZE);
        optionPage = Math.min(Math.max(0, optionPage), maxPage);
        boolean colorTrait = isColorTrait(trait);

        if (profile != null && profile.getTraits().isEmpty() == false)
        {
            GuiButton previousTrait = new GuiButton(10, left, top + 18, 25, 20, "<");
            GuiButton nextTrait = new GuiButton(
                    11,
                    left + LEFT_COLUMN_WIDTH - 25,
                    top + 18,
                    25,
                    20,
                    ">"
            );
            previousTrait.enabled = traitIndex > 0;
            nextTrait.enabled = traitIndex < profile.getTraits().size() - 1;
            buttonList.add(previousTrait);
            buttonList.add(nextTrait);
        }

        if (colorTrait)
        {
            setupColorFields(left + 32, top + 66, trait);
        }
        else
        {
            redField = null;
            greenField = null;
            blueField = null;
            int first = optionPage * PAGE_SIZE;
            int gridLeft = left + 9;
            int gridTop = top + 48;
            for (int cell = 0; cell < PAGE_SIZE && first + cell < options.size(); cell++)
            {
                buttonList.add(new OptionButton(
                        OPTION_BUTTON_START + cell,
                        gridLeft + (cell % GRID_COLUMNS) * 47,
                        gridTop + (cell / GRID_COLUMNS) * 28,
                        43,
                        24,
                        first + cell
                ));
            }

            GuiButton previousPage = new GuiButton(0, left, top + 136, 25, 20, "<");
            GuiButton nextPage = new GuiButton(
                    1,
                    left + LEFT_COLUMN_WIDTH - 25,
                    top + 136,
                    25,
                    20,
                    ">"
            );
            previousPage.enabled = optionPage > 0;
            nextPage.enabled = optionPage < maxPage;
            buttonList.add(previousPage);
            buttonList.add(nextPage);
        }

        int offsetLeft = left + 36;
        if (definition != null && definition.isAutoHeightAdjustmentEnabled())
        {
            buttonList.add(new GuiButton(
                    HEIGHT_MODE_BUTTON,
                    left + 4,
                    top + OFFSET_ROW_TOP,
                    78,
                    20,
                    translate(heightMode == ConfigurablePropHeightMode.AUTO
                            ? "heightAutoButton"
                            : "heightManualButton")
            ));
            offsetLeft = left + 88;
        }
        if (definition != null && definition.isModelFlipEnabled())
        {
                buttonList.add(new GuiButton(
                    MODEL_FLIP_BUTTON,
                    left + 4,
                    definition != null && definition.isAutoHeightAdjustmentEnabled()
                            ? top + 146
                            : top + OFFSET_ROW_TOP,
                    78,
                    20,
                    translate(modelFlipped ? "flipOn" : "flipOff")
            ));
            if (offsetLeft < left + 88)
            {
                offsetLeft = left + 88;
            }
        }
        setupOffsetFields(offsetLeft, top + OFFSET_ROW_TOP);
        setupPlacementRotationControls(left, top + ROTATION_ROW_TOP);
        int actionsTop = top + ACTION_ROW_TOP;
        int actionWidth = 118;
        int actionGap = 14;
        int actionsLeft = left + (guiWidth - actionWidth * 2 - actionGap) / 2;
        buttonList.add(new GuiButton(2, actionsLeft, actionsTop, actionWidth, 20, translate("apply")));
        buttonList.add(new GuiButton(3, actionsLeft + actionWidth + actionGap, actionsTop, actionWidth, 20, translate("cancel")));
    }

    /** Creates the optional automatic/manual placement-angle controls. */
    private void setupPlacementRotationControls(int left, int top)
    {
        placementRotationField = null;
        if (definition == null || definition.isManualPlacementRotationEnabled() == false)
        {
            return;
        }
        buttonList.add(new GuiButton(
                ROTATION_MODE_BUTTON,
                left + 4,
                top,
                98,
                20,
                translate(manualPlacementRotation
                        ? "rotationManualButton"
                        : "rotationAutomaticButton")
        ));
        if (manualPlacementRotation)
        {
            placementRotationField = new GuiTextField(
                    fontRendererObj,
                    left + 112,
                    top,
                    64,
                    20
            );
            placementRotationField.setMaxStringLength(8);
            placementRotationField.setText(formatDegrees(placementRotation.toDegrees()));
        }
    }

    /** Creates local-axis offset fields and the reset action at the supplied GUI origin. */
    private void setupOffsetFields(int left, int top)
    {
        offsetRightField = offsetField(left, top, offset.getRightBlocks(), 38);
        offsetUpField = offsetField(left + 46, top, offset.getUpBlocks(), 38);
        offsetForwardField = offsetField(left + 92, top, offset.getForwardBlocks(), 44);
        buttonList.add(new GuiButton(
                OFFSET_RESET_BUTTON,
                left + 144,
                top,
                48,
                20,
                translate("reset")
        ));
    }

    /** Creates a placement-offset input initialized with a display-safe value. */
    private GuiTextField offsetField(int x, int y, double value, int width)
    {
        GuiTextField field = new GuiTextField(fontRendererObj, x, y, width, 20);
        field.setMaxStringLength(7);
        field.setText(formatOffset(value));
        return field;
    }

    /** Rebuilds RGB inputs from the selected color trait's current packed value. */
    private void setupColorFields(int left, int top, CustomizationTrait trait)
    {
        int color = parseColor(appearance.getTrait(trait.getId(), trait.getDefaultValue()));
        redField = colorField(left, top, (color >> 16) & 255);
        greenField = colorField(left + 58, top, (color >> 8) & 255);
        blueField = colorField(left + 116, top, color & 255);
    }

    /** Creates one bounded RGB-channel input. */
    private GuiTextField colorField(int x, int y, int value)
    {
        GuiTextField field = new GuiTextField(fontRendererObj, x, y, 42, 18);
        field.setMaxStringLength(3);
        field.setText(Integer.toString(value));
        return field;
    }

    /** {@inheritDoc} */
    @Override
    protected void actionPerformed(GuiButton button)
    {
        if (button.id == OFFSET_RESET_BUTTON)
        {
            offset = definition != null
                    ? definition.getDefaultPlacementOffset()
                    : PropPlacementOffset.zero();
            syncOffsetFields();
            return;
        }
        if (button.id == MODEL_FLIP_BUTTON
                && definition != null
                && definition.isModelFlipEnabled())
        {
            modelFlipped = modelFlipped == false;
            rebuildButtons();
            return;
        }
        if (button.id == HEIGHT_MODE_BUTTON
                && definition != null
                && definition.isAutoHeightAdjustmentEnabled())
        {
            heightMode = heightMode == ConfigurablePropHeightMode.AUTO
                    ? ConfigurablePropHeightMode.MANUAL
                    : ConfigurablePropHeightMode.AUTO;
            rebuildButtons();
            return;
        }
        if (button.id == ROTATION_MODE_BUTTON
                && definition != null
                && definition.isManualPlacementRotationEnabled())
        {
            updatePlacementRotationFromField();
            manualPlacementRotation = manualPlacementRotation == false;
            rebuildButtons();
            return;
        }
        if (button.id >= OPTION_BUTTON_START
                && button.id < OPTION_BUTTON_START + PAGE_SIZE)
        {
            selectOption(optionPage * PAGE_SIZE + button.id - OPTION_BUTTON_START);
            rebuildButtons();
            return;
        }
        if (button.id == 0)
        {
            optionPage = Math.max(0, optionPage - 1);
            rebuildButtons();
        }
        else if (button.id == 1)
        {
            int maxPage = Math.max(0, (getActiveOptions().size() - 1) / PAGE_SIZE);
            optionPage = Math.min(maxPage, optionPage + 1);
            rebuildButtons();
        }
        else if (button.id == 2)
        {
            updateColorAppearance();
            updateOffsetFromFields();
            updatePlacementRotationFromField();
            PacketHandler.sendPacketToServer(
                    new PacketConfigureConfigurablePropItem(
                            slot,
                            appearance,
                            offset,
                            modelFlipped,
                            heightMode,
                            manualPlacementRotation,
                            placementRotation
                    )
            );
            mc.displayGuiScreen(null);
        }
        else if (button.id == 3)
        {
            mc.displayGuiScreen(null);
        }
        else if (button.id == 10)
        {
            traitIndex = Math.max(0, traitIndex - 1);
            optionPage = 0;
            rebuildButtons();
        }
        else if (button.id == 11 && profile != null)
        {
            traitIndex = Math.min(profile.getTraits().size() - 1, traitIndex + 1);
            optionPage = 0;
            rebuildButtons();
        }
    }

    /** Applies one validated option from the active trait page to the preview state. */
    private void selectOption(int index)
    {
        CustomizationTrait trait = getActiveTrait();
        List<CustomizationTraitOption> options = getActiveOptions();
        if (trait != null && index >= 0 && index < options.size())
        {
            appearance = appearance.withTrait(trait.getId(), options.get(index).getValue());
        }
    }

    /** {@inheritDoc} */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        ItemStack stack = player.inventory.getStackInSlot(slot);
        if (player.inventory.currentItem != slot
                || stack == null
                || (stack.getItem() instanceof ItemBlockConfigurableProp) == false)
        {
            mc.displayGuiScreen(null);
            return;
        }

        drawDefaultBackground();
        int guiWidth = getGuiWidth();
        int left = getGuiLeft(guiWidth);
        int top = height / 2 - GUI_HEIGHT / 2;
        int center = left + guiWidth / 2;
        int leftCenter = left + LEFT_COLUMN_WIDTH / 2;
        drawCenteredString(fontRendererObj, translate("title"), center, top + 4, 0xFFFFFF);
        drawPreviewPanel(left, top, guiWidth);

        CustomizationTrait trait = getActiveTrait();
        List<CustomizationTraitOption> options = getActiveOptions();
        String selectedText = null;
        String selectedDisplayText = null;
        int previewPanelLeft = left + PREVIEW_LEFT;
        int previewPanelRight = left + guiWidth;
        int selectedTextY = top + SELECTED_PREVIEW_TEXT_TOP;
        if (trait != null)
        {
            drawCenteredString(
                    fontRendererObj,
                    translateFormatted(
                            "characteristic",
                            StatCollector.translateToLocal(trait.getDisplayNameKey()),
                            traitIndex + 1,
                            profile.getTraits().size()
                    ),
                    leftCenter,
                    top + 24,
                    0xFFFFFF
            );
            selectedText = translateFormatted(
                    "selected",
                    optionDisplayName(
                            trait,
                            appearance.getTrait(
                                    trait.getId(),
                                    trait.getDefaultValue()
                            )
                    )
            );
            selectedDisplayText = trimToWidthWithEllipsis(
                    selectedText,
                    previewPanelRight - previewPanelLeft - 8
            );
            drawCenteredString(
                    fontRendererObj,
                    selectedDisplayText,
                    previewPanelLeft + (previewPanelRight - previewPanelLeft) / 2,
                    selectedTextY,
                    0xFFFFFF
            );
            if (isColorTrait(trait))
            {
                drawColorInputs(left, top);
            }
            else
            {
                drawCenteredString(
                        fontRendererObj,
                        translateFormatted(
                                "page",
                                optionPage + 1,
                                Math.max(1, (options.size() + PAGE_SIZE - 1) / PAGE_SIZE)
                        ),
                        leftCenter,
                        top + 142,
                        0xFFFFFF
                );
            }
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
        drawOffsetInputs();
        drawPlacementRotationInput();

        boolean drewHoverText = false;
        for (Object object : buttonList)
        {
            if (object instanceof OptionButton && ((OptionButton) object).func_146115_a())
            {
                int optionIndex = ((OptionButton) object).optionIndex;
                if (trait != null && optionIndex >= 0 && optionIndex < options.size())
                {
                    drawHoveringText(
                            Collections.singletonList(
                                    optionDisplayName(trait, options.get(optionIndex).getValue())
                            ),
                            mouseX,
                            mouseY,
                            fontRendererObj
                    );
                    drewHoverText = true;
                }
                break;
            }
        }
        if (drewHoverText == false
                && selectedText != null
                && selectedDisplayText != null
                && selectedText.equals(selectedDisplayText) == false
                && mouseX >= previewPanelLeft
                && mouseX <= previewPanelRight
                && mouseY >= selectedTextY
                && mouseY <= selectedTextY + fontRendererObj.FONT_HEIGHT)
        {
            drawHoveringText(
                    Collections.singletonList(selectedText),
                    mouseX,
                    mouseY,
                    fontRendererObj
            );
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    protected void keyTyped(char typedChar, int keyCode)
    {
        if (offsetFieldKeyTyped(typedChar, keyCode))
        {
            updateOffsetFromFields();
            return;
        }
        if (placementRotationField != null
                && placementRotationField.textboxKeyTyped(typedChar, keyCode))
        {
            sanitizePlacementRotationField();
            updatePlacementRotationFromField();
            return;
        }
        if (redField != null
                && (redField.textboxKeyTyped(typedChar, keyCode)
                || greenField.textboxKeyTyped(typedChar, keyCode)
                || blueField.textboxKeyTyped(typedChar, keyCode)))
        {
            normalizeColorFields();
            updateColorAppearance();
            return;
        }
        super.keyTyped(typedChar, keyCode);
    }

    /** {@inheritDoc} */
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int button)
    {
        super.mouseClicked(mouseX, mouseY, button);
        if (offsetRightField != null)
        {
            offsetRightField.mouseClicked(mouseX, mouseY, button);
            offsetUpField.mouseClicked(mouseX, mouseY, button);
            offsetForwardField.mouseClicked(mouseX, mouseY, button);
        }
        if (redField != null)
        {
            redField.mouseClicked(mouseX, mouseY, button);
            greenField.mouseClicked(mouseX, mouseY, button);
            blueField.mouseClicked(mouseX, mouseY, button);
        }
        if (placementRotationField != null)
        {
            placementRotationField.mouseClicked(mouseX, mouseY, button);
        }
    }

    /** Returns the currently selected trait, or {@code null} when no traits exist. */
    private CustomizationTrait getActiveTrait()
    {
        if (profile == null || profile.getTraits().isEmpty())
        {
            return null;
        }
        traitIndex = Math.min(Math.max(0, traitIndex), profile.getTraits().size() - 1);
        return profile.getTraits().get(traitIndex);
    }

    /** Returns the active trait's fixed options, or an empty list when unavailable. */
    private List<CustomizationTraitOption> getActiveOptions()
    {
        CustomizationTrait trait = getActiveTrait();
        return trait != null
                ? trait.getOptions()
                : Collections.<CustomizationTraitOption>emptyList();
    }

    /** Reports whether the supplied trait accepts a freely selected color. */
    private boolean isColorTrait(CustomizationTrait trait)
    {
        return trait != null && trait.getKind() == CustomizationTrait.Kind.COLOR;
    }

    /** Draws the RGB inputs and their current color swatch. */
    private void drawColorInputs(int left, int top)
    {
        drawCenteredString(
                fontRendererObj,
                translate("rgbHelp"),
                left + LEFT_COLUMN_WIDTH / 2,
                top + 50,
                0xFFFFFF
        );
        fontRendererObj.drawString(translate("red"), left + 32, top + 90, 0xFFFFFF);
        fontRendererObj.drawString(translate("green"), left + 90, top + 90, 0xFFFFFF);
        fontRendererObj.drawString(translate("blue"), left + 148, top + 90, 0xFFFFFF);
        redField.drawTextBox();
        greenField.drawTextBox();
        blueField.drawTextBox();
        int color = makeColor(
                readColorField(redField),
                readColorField(greenField),
                readColorField(blueField)
        );
        drawRect(left + 79, top + 116, left + 130, top + 135, 0xFF000000 | color);
    }

    /** Draws the model-placement offset inputs when they are available. */
    private void drawOffsetInputs()
    {
        if (offsetRightField == null)
        {
            return;
        }
        fontRendererObj.drawString("Right", offsetRightField.xPosition, offsetRightField.yPosition - 9, 0xFFFFFF);
        fontRendererObj.drawString("Up", offsetUpField.xPosition, offsetUpField.yPosition - 9, 0xFFFFFF);
        fontRendererObj.drawString("Forward", offsetForwardField.xPosition, offsetForwardField.yPosition - 9, 0xFFFFFF);
        offsetRightField.drawTextBox();
        offsetUpField.drawTextBox();
        offsetForwardField.drawTextBox();
    }

    /** Draws the manual degree field when manual placement is selected. */
    private void drawPlacementRotationInput()
    {
        if (placementRotationField == null)
        {
            return;
        }
        placementRotationField.drawTextBox();
        fontRendererObj.drawString(
                translate("degrees"),
                placementRotationField.xPosition + 70,
                placementRotationField.yPosition + 6,
                0xFFFFFF
        );
    }

    /**
     * Draws the isolated model preview. The preview renderer restores its temporary
     * model-view and lighting state before normal GUI rendering resumes.
     */
    private void drawPreviewPanel(int left, int top, int guiWidth)
    {
        int panelLeft = left + PREVIEW_LEFT;
        int panelRight = left + guiWidth;
        if (panelRight - panelLeft < 100)
        {
            return;
        }
        drawRect(panelLeft, top + 18, panelRight, top + 156, 0xAA202020);
        drawRect(panelLeft, top + 18, panelRight, top + 19, 0xFF808080);
        drawRect(panelLeft, top + 155, panelRight, top + 156, 0xFF404040);
        drawCenteredString(
                fontRendererObj,
                translate("preview"),
                panelLeft + (panelRight - panelLeft) / 2,
                top + 24,
                0xFFFFFF
        );
        previewRenderer.renderPreview(
                definition,
                appearance,
                panelLeft + (panelRight - panelLeft) / 2,
                top + 86,
                previewScale(),
                manualPlacementRotation ? placementRotation.toDegrees() : PREVIEW_YAW,
                modelFlipped
        );
    }

    /** Calculates a preview scale that accounts for model size and definition tuning. */
    private float previewScale()
    {
        if (definition == null)
        {
            return 26.0F;
        }
        int largest = Math.max(
                definition.getHeight(),
                Math.max(definition.getWidth(), definition.getDepth())
        );
        float baseScale = largest > 1 ? 18.0F : 26.0F;
        return baseScale * definition.getGuiPreviewScale();
    }

    /** Returns the responsive customization-panel width. */
    private int getGuiWidth()
    {
        return Math.min(MAX_GUI_WIDTH, Math.max(300, width - 8));
    }

    /** Returns the horizontal origin that centers the supplied panel width. */
    private int getGuiLeft(int guiWidth)
    {
        return Math.max(4, width / 2 - guiWidth / 2);
    }

    /** Resolves skin-specific names before falling back to the trait option label. */
    private String optionDisplayName(CustomizationTrait trait, String value)
    {
        if (trait.getKind() == CustomizationTrait.Kind.COLOR)
        {
            return formatRgb(parseColor(value));
        }
        if (trait.getKind() == CustomizationTrait.Kind.SKIN)
        {
            SkinDefinition skin = CustomizationRegistry.getSkin(value);
            if (skin != null)
            {
                return StatCollector.translateToLocal(skin.getDisplayNameKey());
            }
        }
        CustomizationTraitOption option = trait.findOption(value);
        return option != null
                ? StatCollector.translateToLocal(option.getDisplayNameKey())
                : value;
    }

    /** Rebuilds the active packed color trait from the three RGB input fields. */
    private void updateColorAppearance()
    {
        CustomizationTrait trait = getActiveTrait();
        if (isColorTrait(trait) == false || redField == null)
        {
            return;
        }
        int color = makeColor(
                readColorField(redField),
                readColorField(greenField),
                readColorField(blueField)
        );
        appearance = appearance.withTrait(trait.getId(), Integer.toString(0xFF000000 | color));
    }

    /** Clamps every RGB text field to the persisted channel range of 0 through 255. */
    private void normalizeColorFields()
    {
        normalizeColorField(redField);
        normalizeColorField(greenField);
        normalizeColorField(blueField);
    }

    /** Rewrites one RGB field as a clamped decimal channel value. */
    private void normalizeColorField(GuiTextField field)
    {
        String text = field.getText();
        StringBuilder digits = new StringBuilder();
        for (int index = 0; index < text.length(); index++)
        {
            char character = text.charAt(index);
            if (character >= '0' && character <= '9')
            {
                digits.append(character);
            }
        }
        if (digits.toString().equals(text) == false)
        {
            field.setText(digits.toString());
        }
        if (digits.length() > 0)
        {
            int value = Math.min(
                    255,
                    CustomizationNumberParser.parseInteger(digits.toString(), 0)
            );
            if (Integer.toString(value).equals(field.getText()) == false)
            {
                field.setText(Integer.toString(value));
            }
        }
    }

    /** Reads one RGB field, returning zero for invalid input and clamping to 255. */
    private int readColorField(GuiTextField field)
    {
        int value = CustomizationNumberParser.parseInteger(field.getText(), 0);
        return Math.min(255, Math.max(0, value));
    }

    /** Parses a packed color, returning opaque white when the stored value is invalid. */
    private int parseColor(String value)
    {
        return CustomizationNumberParser.parseInteger(value, 0xFFFFFFFF);
    }

    /** Packs three eight-bit channels into an RGB integer. */
    private int makeColor(int red, int green, int blue)
    {
        return ((red & 255) << 16) | ((green & 255) << 8) | (blue & 255);
    }

    /** Formats a packed color for human-readable GUI text. */
    private String formatRgb(int color)
    {
        return "RGB "
                + ((color >> 16) & 255)
                + ", "
                + ((color >> 8) & 255)
                + ", "
                + (color & 255);
    }

    /** Applies the active definition's placement limits when one is available. */
    private PropPlacementOffset clampOffset(PropPlacementOffset value)
    {
        return definition != null ? definition.clampPlacementOffset(value) : value;
    }

    /** Routes one key event to offset inputs and refreshes the local preview value. */
    private boolean offsetFieldKeyTyped(char typedChar, int keyCode)
    {
        if (offsetRightField == null)
        {
            return false;
        }
        boolean typed = offsetRightField.textboxKeyTyped(typedChar, keyCode)
                || offsetUpField.textboxKeyTyped(typedChar, keyCode)
                || offsetForwardField.textboxKeyTyped(typedChar, keyCode);
        if (typed)
        {
            sanitizeOffsetField(offsetRightField);
            sanitizeOffsetField(offsetUpField);
            sanitizeOffsetField(offsetForwardField);
        }
        return typed;
    }

    /**
     * Parses and clamps local-axis fields for the preview. Complete values that
     * exceed an axis, definition, or horizontal-radius limit are immediately
     * rewritten so the fields show exactly what applying the GUI will save.
     */
    private void updateOffsetFromFields()
    {
        if (offsetRightField == null)
        {
            return;
        }
        int requestedRight = readOffsetHundredths(
                offsetRightField,
                offset.getRightHundredths()
        );
        int requestedUp = readOffsetHundredths(
                offsetUpField,
                offset.getUpHundredths()
        );
        int requestedForward = readOffsetHundredths(
                offsetForwardField,
                offset.getForwardHundredths()
        );
        offset = clampOffset(new PropPlacementOffset(
                requestedRight,
                requestedUp,
                requestedForward
        ));
        boolean normalizedCompleteInput = offsetFieldsAreComplete()
                && (requestedRight != offset.getRightHundredths()
                || requestedUp != offset.getUpHundredths()
                || requestedForward != offset.getForwardHundredths());
        if (normalizedCompleteInput)
        {
            syncOffsetFields();
        }
    }

    /** Rewrites all offset fields from the normalized in-memory value. */
    private void syncOffsetFields()
    {
        if (offsetRightField == null)
        {
            return;
        }
        offsetRightField.setText(formatOffset(offset.getRightBlocks()));
        offsetUpField.setText(formatOffset(offset.getUpBlocks()));
        offsetForwardField.setText(formatOffset(offset.getForwardBlocks()));
    }

    /**
     * Parses a block-unit field into persisted hundredths, retaining the prior
     * component while the user has entered an incomplete numeric token.
     */
    private int readOffsetHundredths(GuiTextField field, int fallback)
    {
        String text = field.getText();
        if (text == null
                || text.length() == 0
                || "-".equals(text)
                || ".".equals(text)
                || "-.".equals(text))
        {
            return fallback;
        }
        return CustomizationNumberParser.parseHundredths(text, fallback);
    }

    /** Returns whether every offset input contains a complete sanitized number. */
    private boolean offsetFieldsAreComplete()
    {
        return offsetFieldIsComplete(offsetRightField)
                && offsetFieldIsComplete(offsetUpField)
                && offsetFieldIsComplete(offsetForwardField);
    }

    /** Returns whether one field is ready to normalize without disrupting partial input. */
    private boolean offsetFieldIsComplete(GuiTextField field)
    {
        String text = field.getText();
        return text != null
                && text.length() > 0
                && "-".equals(text) == false
                && ".".equals(text) == false
                && "-.".equals(text) == false;
    }

    /** Replaces malformed or out-of-range offset text with its normalized decimal form. */
    private void sanitizeOffsetField(GuiTextField field)
    {
        String text = field.getText();
        StringBuilder sanitized = new StringBuilder();
        boolean sawMinus = false;
        boolean sawDecimal = false;
        for (int index = 0; index < text.length(); index++)
        {
            char character = text.charAt(index);
            if (character == '-' && sawMinus == false && sanitized.length() == 0)
            {
                sanitized.append(character);
                sawMinus = true;
            }
            else if (character == '.' && sawDecimal == false)
            {
                sanitized.append(character);
                sawDecimal = true;
            }
            else if (character >= '0' && character <= '9')
            {
                sanitized.append(character);
            }
        }
        String value = sanitized.toString();
        int decimal = value.indexOf('.');
        if (decimal >= 0 && value.length() > decimal + 3)
        {
            value = value.substring(0, decimal + 3);
        }
        if (value.equals(text) == false)
        {
            field.setText(value);
        }
    }

    /** Parses the manual degree field and applies the definition's footprint limits. */
    private void updatePlacementRotationFromField()
    {
        if (placementRotationField == null)
        {
            return;
        }
        String text = placementRotationField.getText();
        if (text == null
                || text.length() == 0
                || "-".equals(text)
                || ".".equals(text)
                || "-.".equals(text))
        {
            return;
        }
        int fallbackHundredths = Math.round(placementRotation.toDegrees() * 100.0F);
        int degreeHundredths = CustomizationNumberParser.parseHundredths(
                text,
                fallbackHundredths
        );
        RotationAmount requested = RotationAmount.fromDegrees(degreeHundredths / 100.0D);
        placementRotation = definition != null
                ? definition.normalizeManualPlacementRotation(requested)
                : requested;
    }

    /** Keeps manual degree input numeric with at most two decimal places. */
    private void sanitizePlacementRotationField()
    {
        sanitizeOffsetField(placementRotationField);
    }

    /** Formats a block offset with the precision exposed by the GUI. */
    private String formatOffset(double value)
    {
        return String.format("%.2f", value);
    }

    /** Formats an editable placement angle in degrees. */
    private String formatDegrees(double value)
    {
        return String.format("%.2f", value);
    }

    /** Trims text to the requested pixel width and marks truncation with an ellipsis. */
    private String trimToWidthWithEllipsis(String text, int maxWidth)
    {
        if (text == null || fontRendererObj.getStringWidth(text) <= maxWidth)
        {
            return text;
        }
        String ellipsis = "...";
        int textWidth = Math.max(0, maxWidth - fontRendererObj.getStringWidth(ellipsis));
        return fontRendererObj.trimStringToWidth(text, textWidth) + ellipsis;
    }

    /** Resolves a customization GUI translation by suffix. */
    private String translate(String suffix)
    {
        return StatCollector.translateToLocal("gui.foxblocks.propAppearance." + suffix);
    }

    /** Resolves and formats a customization GUI translation by suffix. */
    private String translateFormatted(String suffix, Object... values)
    {
        return StatCollector.translateToLocalFormatted(
                "gui.foxblocks.propAppearance." + suffix,
                values
        );
    }

    /** Associates a visible paged button with its absolute trait-option index. */
    private class OptionButton extends GuiButton
    {

        private final int optionIndex;

        /** Creates a paged button associated with an absolute option index. */
        private OptionButton(
                int id,
                int x,
                int y,
                int width,
                int height,
                int optionIndex
        )
        {
            super(id, x, y, width, height, "");
            this.optionIndex = optionIndex;
        }

        /** {@inheritDoc} */
        @Override
        public void drawButton(
                net.minecraft.client.Minecraft minecraft,
                int mouseX,
                int mouseY
        )
        {
            super.drawButton(minecraft, mouseX, mouseY);
            CustomizationTrait trait = getActiveTrait();
            List<CustomizationTraitOption> options = getActiveOptions();
            if (trait == null || optionIndex < 0 || optionIndex >= options.size())
            {
                return;
            }
            CustomizationTraitOption option = options.get(optionIndex);
            String name = optionDisplayName(trait, option.getValue());
            drawCenteredString(
                    fontRendererObj,
                    name.length() > 5 ? name.substring(0, 5) : name,
                    xPosition + width / 2,
                    yPosition + 8,
                    0xFFFFFF
            );
            if (option.getValue().equals(
                    appearance.getTrait(trait.getId(), trait.getDefaultValue())
            ))
            {
                drawRect(xPosition, yPosition, xPosition + width, yPosition + 2, 0xFFFFFF00);
                drawRect(
                        xPosition,
                        yPosition + height - 2,
                        xPosition + width,
                        yPosition + height,
                        0xFFFFFF00
                );
            }
        }
    }
}
