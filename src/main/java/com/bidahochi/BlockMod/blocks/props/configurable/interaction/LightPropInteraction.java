package com.bidahochi.BlockMod.blocks.props.configurable.interaction;

import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/** Toggles the controller-owned state of a manually controlled prop light. */
public final class LightPropInteraction extends ConfigurablePropInteraction
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
        World world = controller.getWorldObj();
        if (world == null)
        {
            return false;
        }
        if (world.isRemote)
        {
            return true;
        }
        return controller.toggleLight();
    }
}
