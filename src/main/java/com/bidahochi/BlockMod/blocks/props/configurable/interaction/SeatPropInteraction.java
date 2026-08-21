package com.bidahochi.BlockMod.blocks.props.configurable.interaction;

import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropSeat;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import com.bidahochi.BlockMod.entities.EntityChair;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

/** Mounts a player on the named seat anchor nearest the clicked part location. */
public final class SeatPropInteraction extends ConfigurablePropInteraction
{

    private static final double EXISTING_SEAT_RADIUS = 0.125D;

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
        World world = controller.getWorldObj();
        if (world.isRemote)
        {
            return true;
        }

        int controllerX = controller.xCoord;
        int controllerY = controller.yCoord;
        int controllerZ = controller.zCoord;
        double placementOffsetX = controller.getWorldOffsetX();
        double placementOffsetY = controller.getWorldOffsetY();
        double placementOffsetZ = controller.getWorldOffsetZ();
        ConfigurablePropSeat anchor = findClickedSeat(
                controller,
                partOffsetX + hitX - placementOffsetX,
                partOffsetY + hitY - placementOffsetY,
                partOffsetZ + hitZ - placementOffsetZ
        );
        double seatOffsetX = anchor != null
                ? anchor.getControllerOffsetX(controller.getRotation())
                : 0.5D;
        double seatOffsetY = anchor != null ? anchor.getControllerOffsetY() : 0.48D;
        double seatOffsetZ = anchor != null
                ? anchor.getControllerOffsetZ(controller.getRotation())
                : 0.5D;
        double seatX = controllerX + seatOffsetX + placementOffsetX;
        double seatY = controllerY + seatOffsetY + placementOffsetY;
        double seatZ = controllerZ + seatOffsetZ + placementOffsetZ;
        List existingSeatEntities = world.getEntitiesWithinAABB(
                EntityChair.class,
                AxisAlignedBB.getBoundingBox(
                        seatX - EXISTING_SEAT_RADIUS,
                        seatY - EXISTING_SEAT_RADIUS,
                        seatZ - EXISTING_SEAT_RADIUS,
                        seatX + EXISTING_SEAT_RADIUS,
                        seatY + EXISTING_SEAT_RADIUS,
                        seatZ + EXISTING_SEAT_RADIUS
                )
        );
        EntityChair seat = existingSeatEntities.isEmpty()
                ? null
                : (EntityChair) existingSeatEntities.get(0);
        if (seat == null)
        {
            seat = new EntityChair(world);
            seat.blockPos = Vec3.createVectorHelper(controllerX, controllerY, controllerZ);
            seat.setPosition(seatX, seatY, seatZ);
            seat.rotationYaw = anchor != null
                    ? anchor.getWorldYaw(controller.getRotation())
                    : controller.getRotation().toDegrees();
            world.spawnEntityInWorld(seat);
        }
        if (seat.riddenByEntity == null)
        {
            player.mountEntity(seat);
        }
        return true;
    }

    /** Selects the seat anchor nearest to the click in controller-relative space. */
    private ConfigurablePropSeat findClickedSeat(
            TileConfigurablePropController controller,
            double clickX,
            double clickY,
            double clickZ
    )
    {
        ConfigurablePropDefinition definition = controller.getDefinition();
        if (definition == null || definition.hasSeats() == false)
        {
            return null;
        }

        ConfigurablePropSeat nearest = null;
        double nearestDistance = Double.MAX_VALUE;
        for (ConfigurablePropSeat seat : definition.getSeats())
        {
            double deltaX = clickX - seat.getControllerOffsetX(controller.getRotation());
            double deltaY = clickY - seat.getControllerOffsetY();
            double deltaZ = clickZ - seat.getControllerOffsetZ(controller.getRotation());
            double distance = deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
            if (distance < nearestDistance)
            {
                nearest = seat;
                nearestDistance = distance;
            }
        }
        return nearest;
    }
}
