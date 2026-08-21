package com.bidahochi.BlockMod.blocks.props.configurable.interaction;

import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Defines activation behavior selected by a prop definition. Storage and
 * processing capabilities are exposed by narrower interaction subclasses.
 */
public abstract class ConfigurablePropInteraction
{

    /**
     * Handles activation when the clicked structure cell is not relevant. The
     * method runs on both logical sides; implementations must keep mutations
     * server-authoritative and may return {@code true} client-side for prediction.
     *
     * @param controller authoritative prop controller
     * @param player player activating the prop
     * @param side clicked Minecraft block side
     * @param hitX hit X coordinate within the targeted block cell
     * @param hitY hit Y coordinate within the targeted block cell
     * @param hitZ hit Z coordinate within the targeted block cell
     * @return whether the interaction consumed the activation
     */
    public abstract boolean onInteract(
            TileConfigurablePropController controller,
            EntityPlayer player,
            int side,
            float hitX,
            float hitY,
            float hitZ
    );

    /**
     * Handles activation with the clicked multiblock cell included. The base
     * implementation routes to {@link #onInteract} for location-agnostic props.
     *
     * @param controller authoritative prop controller
     * @param player player activating the prop
     * @param partOffsetX clicked cell's world-X offset from the controller
     * @param partOffsetY clicked cell's world-Y offset from the controller
     * @param partOffsetZ clicked cell's world-Z offset from the controller
     * @param side clicked Minecraft block side
     * @param hitX hit X coordinate within the clicked cell
     * @param hitY hit Y coordinate within the clicked cell
     * @param hitZ hit Z coordinate within the clicked cell
     * @return whether the interaction consumed the activation
     */
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
        return onInteract(controller, player, side, hitX, hitY, hitZ);
    }

}
