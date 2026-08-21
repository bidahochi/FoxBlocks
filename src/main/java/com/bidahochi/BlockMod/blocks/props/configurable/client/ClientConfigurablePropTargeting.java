package com.bidahochi.BlockMod.blocks.props.configurable.client;

import com.bidahochi.BlockMod.blocks.props.configurable.block.BlockConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.block.BlockConfigurablePropPart;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropPart;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.event.MouseEvent;

/**
 * Corrects the client crosshair target for props whose configurable visual
 * offset moves their selection bounds away from the underlying block cell.
 */
@SideOnly(Side.CLIENT)
public final class ClientConfigurablePropTargeting
{

    /** Covers one shifted block cell beyond normal player reach. */
    private static final double TARGET_SCAN_MARGIN = 2.0D;

    /**
     * Refreshes the target immediately so attacks and placements use offset
     * bounds instead of a stale underlying vanilla block target.
     *
     * @param event Forge mouse event raised before Minecraft handles the click
     */
    @SubscribeEvent
    public void onMouseEvent(MouseEvent event)
    {
        boolean attackButton = event.button == 0;
        boolean useButton = event.button == 1;
        if ((attackButton == false && useButton == false) || event.buttonstate == false)
        {
            return;
        }
        updateCrosshairTarget();
    }

    /**
     * Refreshes the normal crosshair target once at the end of each client tick.
     *
     * @param event client tick event; only the end phase is processed
     */
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        if (event.phase != TickEvent.Phase.END)
        {
            return;
        }
        updateCrosshairTarget();
    }

    /**
     * Reapplies offset targeting after vanilla calculates the frame's reach ray.
     *
     * @param event render tick event; only the start phase is processed
     */
    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event)
    {
        Minecraft minecraft = Minecraft.getMinecraft();
        boolean attacking = minecraft.gameSettings.keyBindAttack.getIsKeyPressed();
        boolean usingItem = minecraft.gameSettings.keyBindUseItem.getIsKeyPressed();
        if (event.phase != TickEvent.Phase.END
                || (attacking == false && usingItem == false))
        {
            return;
        }
        updateCrosshairTarget();
    }

    /**
     * Tests loaded configurable controller and part cells against the reach ray,
     * replacing Minecraft's target only when an offset prop is the nearer hit.
     */
    private void updateCrosshairTarget()
    {
        Minecraft minecraft = Minecraft.getMinecraft();
        EntityPlayer player = minecraft.thePlayer;
        World world = minecraft.theWorld;
        if (player == null
                || world == null
                || minecraft.playerController == null
                || minecraft.currentScreen != null)
        {
            return;
        }

        Vec3 start = Vec3.createVectorHelper(
                player.posX,
                player.posY + player.getEyeHeight(),
                player.posZ
        );
        double reach = minecraft.playerController.getBlockReachDistance();
        Vec3 look = player.getLook(1.0F);
        Vec3 end = start.addVector(
                look.xCoord * reach,
                look.yCoord * reach,
                look.zCoord * reach
        );
        double scanDistance = reach + TARGET_SCAN_MARGIN;
        double scanDistanceSquared = scanDistance * scanDistance;

        MovingObjectPosition closest = minecraft.objectMouseOver;
        double closestDistance = hitDistanceSquared(start, closest);
        for (Object loadedTileEntity : world.loadedTileEntityList)
        {
            boolean isController = loadedTileEntity instanceof TileConfigurablePropController;
            boolean isPart = loadedTileEntity instanceof TileConfigurablePropPart;
            if (isController == false && isPart == false)
            {
                continue;
            }

            TileEntity controllerTile = (TileEntity) loadedTileEntity;
            double tileCenterX = controllerTile.xCoord + 0.5D;
            double tileCenterY = controllerTile.yCoord + 0.5D;
            double tileCenterZ = controllerTile.zCoord + 0.5D;
            double deltaX = start.xCoord - tileCenterX;
            double deltaY = start.yCoord - tileCenterY;
            double deltaZ = start.zCoord - tileCenterZ;
            if (deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ
                    > scanDistanceSquared)
            {
                continue;
            }
            Block targetBlock = world.getBlock(
                    controllerTile.xCoord,
                    controllerTile.yCoord,
                    controllerTile.zCoord
            );
            boolean isControllerBlock = targetBlock instanceof BlockConfigurablePropController;
            boolean isPartBlock = targetBlock instanceof BlockConfigurablePropPart;
            if (isControllerBlock == false && isPartBlock == false)
            {
                continue;
            }

            MovingObjectPosition hit = targetBlock.collisionRayTrace(
                    world,
                    controllerTile.xCoord,
                    controllerTile.yCoord,
                    controllerTile.zCoord,
                    start,
                    end
            );
            double distance = hitDistanceSquared(start, hit);
            if (distance < closestDistance)
            {
                closest = hit;
                closestDistance = distance;
            }
        }

        if (closest != null && closest != minecraft.objectMouseOver)
        {
            minecraft.objectMouseOver = closest;
        }
    }

    /** Returns squared eye-ray distance, or infinity when a candidate has no hit point. */
    private double hitDistanceSquared(Vec3 start, MovingObjectPosition hit)
    {
        return hit != null && hit.hitVec != null
                ? start.squareDistanceTo(hit.hitVec)
                : Double.POSITIVE_INFINITY;
    }
}
