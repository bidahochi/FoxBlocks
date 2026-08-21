package com.bidahochi.BlockMod.network;

import com.bidahochi.BlockMod.blocks.props.configurable.item.ItemBlockConfigurableProp;
import com.bidahochi.BlockMod.blocks.props.configurable.data.ConfigurablePropHeightMode;
import com.bidahochi.BlockMod.blocks.props.configurable.data.PropPlacementOffset;
import com.bidahochi.BlockMod.customization.data.AppearanceData;
import com.bidahochi.BlockMod.common.rotation.RotationAmount;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Transfers bounded item customization choices to the server, which revalidates
 * them against the held prop's registered profile before mutating item NBT.
 */
public class PacketConfigureConfigurablePropItem implements IFoxBlocksPacket
{

    private static final int MAX_TRAITS = 256;
    private static final int MAX_TRAIT_ID_LENGTH = 128;
    private static final int MAX_TRAIT_VALUE_LENGTH = 512;

    private int slot;
    private AppearanceData appearance;
    private PropPlacementOffset placementOffset;
    private boolean modelFlipped;
    private ConfigurablePropHeightMode heightMode;
    private boolean manualPlacementRotation;
    private RotationAmount placementRotation;

    /** Creates an empty packet for reflective network decoding. */
    public PacketConfigureConfigurablePropItem()
    {
    }

    /**
     * Captures the complete client-edited item state. The server treats every
     * field as untrusted and validates it against the held item and definition.
     *
     * @param slot zero-based player inventory slot containing the edited item
     * @param appearance requested untrusted appearance snapshot
     * @param placementOffset requested local-axis placement offset
     * @param modelFlipped requested model mirror state
     * @param heightMode requested support-height mode
     * @param manualPlacementRotation whether to override player-facing placement
     * @param placementRotation requested manual angle
     */
    public PacketConfigureConfigurablePropItem(
            int slot,
            AppearanceData appearance,
            PropPlacementOffset placementOffset,
            boolean modelFlipped,
            ConfigurablePropHeightMode heightMode,
            boolean manualPlacementRotation,
            RotationAmount placementRotation
    )
    {
        this.slot = slot;
        this.appearance = appearance;
        this.placementOffset = placementOffset;
        this.modelFlipped = modelFlipped;
        this.heightMode = heightMode;
        this.manualPlacementRotation = manualPlacementRotation;
        this.placementRotation = placementRotation;
    }

    /** {@inheritDoc} */
    @Override
    public void processData(EntityPlayer player, ByteBufInputStream input) throws IOException
    {
        int slot = input.readInt();
        int traitCount = input.readUnsignedShort();
        if (traitCount > MAX_TRAITS)
        {
            return;
        }
        Map<String, String> traits = new LinkedHashMap<String, String>();
        for (int index = 0; index < traitCount; index++)
        {
            String traitId = input.readUTF();
            String traitValue = input.readUTF();
            if (traitId.length() > MAX_TRAIT_ID_LENGTH
                    || traitValue.length() > MAX_TRAIT_VALUE_LENGTH)
            {
                return;
            }
            traits.put(traitId, traitValue);
        }
        PropPlacementOffset requestedPlacementOffset = new PropPlacementOffset(
                input.readShort(),
                input.readShort(),
                input.readShort()
        );
        boolean modelFlipped = input.readBoolean();
        ConfigurablePropHeightMode heightMode = ConfigurablePropHeightMode.fromId(input.readUTF());
        boolean manualPlacementRotation = input.readBoolean();
        RotationAmount placementRotation = RotationAmount.fromAngleUnits(input.readInt());

        if (slot != player.inventory.currentItem
                || slot < 0
                || slot >= player.inventory.getSizeInventory())
        {
            return;
        }
        ItemStack stack = player.inventory.getStackInSlot(slot);
        if (stack == null || (stack.getItem() instanceof ItemBlockConfigurableProp) == false)
        {
            return;
        }

        ItemBlockConfigurableProp configurableProp = (ItemBlockConfigurableProp) stack.getItem();
        configurableProp.setAppearance(stack, new AppearanceData(traits));
        configurableProp.setPlacementOffset(stack, requestedPlacementOffset);
        configurableProp.setModelFlipped(stack, modelFlipped);
        configurableProp.setHeightMode(stack, heightMode);
        configurableProp.setManualPlacementRotation(
                stack,
                manualPlacementRotation,
                placementRotation
        );
        if (player instanceof EntityPlayerMP)
        {
            ((EntityPlayerMP) player).inventoryContainer.detectAndSendChanges();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void appendData(ByteBuf buffer) throws IOException
    {
        ByteBufOutputStream output = new ByteBufOutputStream(buffer);
        output.writeInt(slot);
        AppearanceData serializedAppearance = appearance != null
                ? appearance
                : AppearanceData.defaultAppearance();
        Map<String, String> traits = serializedAppearance.getTraits();
        if (traits.size() > MAX_TRAITS)
        {
            throw new IOException(
                    "Configurable prop appearance exceeds the packet trait limit"
            );
        }
        output.writeShort(traits.size());
        for (Map.Entry<String, String> entry : traits.entrySet())
        {
            if (entry.getKey().length() > MAX_TRAIT_ID_LENGTH
                    || entry.getValue().length() > MAX_TRAIT_VALUE_LENGTH)
            {
                throw new IOException("Configurable prop appearance trait exceeds packet limits");
            }
            output.writeUTF(entry.getKey());
            output.writeUTF(entry.getValue());
        }
        PropPlacementOffset serializedPlacementOffset = placementOffset != null
                ? placementOffset
                : PropPlacementOffset.zero();
        output.writeShort(serializedPlacementOffset.getRightHundredths());
        output.writeShort(serializedPlacementOffset.getUpHundredths());
        output.writeShort(serializedPlacementOffset.getForwardHundredths());
        output.writeBoolean(modelFlipped);
        output.writeUTF((heightMode != null ? heightMode : ConfigurablePropHeightMode.MANUAL).getId());
        output.writeBoolean(manualPlacementRotation);
        output.writeInt(placementRotation != null ? placementRotation.getAngleUnits() : 0);
    }
}
