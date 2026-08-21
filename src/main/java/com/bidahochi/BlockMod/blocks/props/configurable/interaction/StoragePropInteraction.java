package com.bidahochi.BlockMod.blocks.props.configurable.interaction;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.props.configurable.ConfigurablePropSystem;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropStorage;
import net.minecraft.entity.player.EntityPlayer;

/** Opens either a selected compartment or the controller's flat storage inventory. */
public class StoragePropInteraction extends ConfigurablePropStorageInteraction
{

    /** {@inheritDoc} */
    @Override
    public boolean onInteract(
            TileConfigurablePropController controller,
            EntityPlayer player,
            int side,
            float hitX,
            float hitY,
            float hitZ
    )
    {
        return onInteractAt(controller, player, 0, 0, 0, side, hitX, hitY, hitZ);
    }

    /** {@inheritDoc} */
    @Override
    public boolean onInteractAt(
            TileConfigurablePropController controller,
            EntityPlayer player,
            int partOffsetX,
            int partOffsetY,
            int partOffsetZ,
            int side,
            float hitX,
            float hitY,
            float hitZ
    )
    {
        if ((controller instanceof TileConfigurablePropStorage) == false)
        {
            return false;
        }
        TileConfigurablePropStorage storage = (TileConfigurablePropStorage) controller;
        if (storage.getInventoryForRelativeOffset(
                partOffsetX,
                partOffsetY,
                partOffsetZ
        ) == null)
        {
            return false;
        }
        player.openGui(
                FoxBlocks.instance,
                ConfigurablePropSystem.GUI_STORAGE,
                controller.getWorldObj(),
                controller.xCoord + partOffsetX,
                controller.yCoord + partOffsetY,
                controller.zCoord + partOffsetZ
        );
        return true;
    }
}
