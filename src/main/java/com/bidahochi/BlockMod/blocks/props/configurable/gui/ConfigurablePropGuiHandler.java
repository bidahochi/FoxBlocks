package com.bidahochi.BlockMod.blocks.props.configurable.gui;

import com.bidahochi.BlockMod.blocks.props.configurable.ConfigurablePropSystem;
import com.bidahochi.BlockMod.blocks.props.configurable.inventory.ContainerConfigurablePropStorage;
import com.bidahochi.BlockMod.blocks.props.configurable.inventory.ContainerConfigurablePropCustomization;
import com.bidahochi.BlockMod.blocks.props.configurable.item.ItemBlockConfigurableProp;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropPart;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropStorage;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropProcessor;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropProcessorInteraction;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/** Resolves server containers and client screens for prop storage and customization. */
public class ConfigurablePropGuiHandler implements IGuiHandler
{

    /** {@inheritDoc} */
    @Override
    public Object getServerGuiElement(
            int id,
            EntityPlayer player,
            World world,
            int x,
            int y,
            int z
    )
    {
        if (id == ConfigurablePropSystem.GUI_CUSTOMIZATION)
        {
            return new ContainerConfigurablePropCustomization(player, x);
        }
        if (id == ConfigurablePropSystem.GUI_STORAGE)
        {
            IInventory storage = resolveStorageAt(world, x, y, z);
            return storage != null
                    ? new ContainerConfigurablePropStorage(player.inventory, storage)
                    : null;
        }
        if (id == ConfigurablePropSystem.GUI_PROCESSOR)
        {
            TileConfigurablePropProcessor processor = resolveProcessorAt(world, x, y, z);
            ConfigurablePropProcessorInteraction interaction = processor != null
                    ? processor.getProcessorInteraction()
                    : null;
            return interaction != null
                    ? interaction.createServerGuiElement(player, processor)
                    : null;
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Object getClientGuiElement(
            int id,
            EntityPlayer player,
            World world,
            int x,
            int y,
            int z
    )
    {
        if (id == ConfigurablePropSystem.GUI_CUSTOMIZATION
                && x >= 0
                && x < player.inventory.getSizeInventory())
        {
            ItemStack stack = player.inventory.getStackInSlot(x);
            if (stack != null && stack.getItem() instanceof ItemBlockConfigurableProp)
            {
                return new GuiConfigurablePropCustomization(player, x, stack);
            }
            return null;
        }
        if (id == ConfigurablePropSystem.GUI_STORAGE)
        {
            IInventory storage = resolveStorageAt(world, x, y, z);
            return storage != null
                    ? new GuiConfigurablePropStorage(player.inventory, storage)
                    : null;
        }
        if (id == ConfigurablePropSystem.GUI_PROCESSOR)
        {
            TileConfigurablePropProcessor processor = resolveProcessorAt(world, x, y, z);
            ConfigurablePropProcessorInteraction interaction = processor != null
                    ? processor.getProcessorInteraction()
                    : null;
            return interaction != null
                    ? interaction.createClientGuiElement(player, processor)
                    : null;
        }
        return null;
    }

    /**
     * Resolves a clicked controller or part to the inventory compartment
     * occupying that exact controller-relative cell.
     */
    private IInventory resolveStorageAt(World world, int x, int y, int z)
    {
        TileConfigurablePropController controller = resolveControllerAt(world, x, y, z);
        return controller instanceof TileConfigurablePropStorage
                ? ((TileConfigurablePropStorage) controller).getInventoryForRelativeOffset(
                        x - controller.xCoord,
                        y - controller.yCoord,
                        z - controller.zCoord
                )
                : null;
    }

    /** Resolves a clicked controller or multiblock part to a processor tile. */
    private TileConfigurablePropProcessor resolveProcessorAt(World world, int x, int y, int z)
    {
        TileConfigurablePropController controller = resolveControllerAt(world, x, y, z);
        return controller instanceof TileConfigurablePropProcessor
                ? (TileConfigurablePropProcessor) controller
                : null;
    }

    /** Resolves a clicked controller or invisible part to its owning controller. */
    private TileConfigurablePropController resolveControllerAt(
            World world,
            int x,
            int y,
            int z
    )
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileConfigurablePropController)
        {
            return (TileConfigurablePropController) tile;
        }
        if (tile instanceof TileConfigurablePropPart)
        {
            return ((TileConfigurablePropPart) tile).getController();
        }
        return null;
    }

}
