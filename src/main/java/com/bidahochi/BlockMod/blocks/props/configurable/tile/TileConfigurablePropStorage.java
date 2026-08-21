package com.bidahochi.BlockMod.blocks.props.configurable.tile;

import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropCompartment;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.inventory.ConfigurablePropCompartmentInventory;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropStorageInteraction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * Adds persistent flat or compartment storage to the shared configurable-prop
 * controller without burdening decorative, seating, or light-only props with an
 * inventory contract.
 */
public class TileConfigurablePropStorage extends TileConfigurablePropController
        implements IInventory
{

    private ItemStack[] inventory = new ItemStack[0];

    /** Creates an unconfigured storage tile for Minecraft's reflective loading. */
    public TileConfigurablePropStorage()
    {
    }

    /**
     * Creates storage for a newly placed definition and allocates its configured slots.
     *
     * @param initialDefinitionId stable definition identifier assigned by the block
     */
    public TileConfigurablePropStorage(String initialDefinitionId)
    {
        super(initialDefinitionId);
        initializeInventory(getDefinition());
    }

    /**
     * Returns the compartment occupying a clicked structure cell or the complete
     * flat inventory when the definition has no compartments.
     *
     * @param relativeX clicked cell's world-X offset from the controller
     * @param relativeY clicked cell's world-Y offset from the controller
     * @param relativeZ clicked cell's world-Z offset from the controller
     * @return selected compartment, this flat inventory, or {@code null} when no
     *         compartment owns the clicked cell
     */
    public IInventory getInventoryForRelativeOffset(
            int relativeX,
            int relativeY,
            int relativeZ
    )
    {
        ConfigurablePropDefinition definition = getDefinition();
        if (definition == null || definition.hasCompartments() == false)
        {
            return this;
        }
        ConfigurablePropCompartment compartment = definition.getCompartmentAtRelativeOffset(
                relativeX,
                relativeY,
                relativeZ,
                getRotation()
        );
        return compartment != null
                ? new ConfigurablePropCompartmentInventory(this, compartment)
                : null;
    }

    /** {@inheritDoc} */
    @Override
    protected void onDefinitionChanged(ConfigurablePropDefinition definition)
    {
        resizeInventory(definition != null ? definition.getInventorySize() : 0);
    }

    /** {@inheritDoc} */
    @Override
    protected void dropCapabilityContents()
    {
        for (int slot = 0; slot < inventory.length; slot++)
        {
            ItemStack stack = inventory[slot];
            if (stack != null)
            {
                spawnDrop(stack.copy());
                inventory[slot] = null;
            }
        }
        super.markDirty();
    }

    /** {@inheritDoc} */
    @Override
    protected void writeCapabilityDataToNBT(NBTTagCompound tag)
    {
        ConfigurablePropDefinition definition = getDefinition();
        if (definition != null && definition.hasCompartments())
        {
            NBTTagList compartments = new NBTTagList();
            for (ConfigurablePropCompartment compartment : definition.getCompartments())
            {
                NBTTagCompound compartmentTag = new NBTTagCompound();
                compartmentTag.setString("Id", compartment.getId());
                compartmentTag.setTag(
                        "Items",
                        writeItems(compartment.getStartSlot(), compartment.getSize())
                );
                compartments.appendTag(compartmentTag);
            }
            tag.setTag("Compartments", compartments);
            return;
        }
        tag.setTag("Items", writeItems(0, inventory.length));
    }

    /** {@inheritDoc} */
    @Override
    protected void readCapabilityDataFromNBT(
            NBTTagCompound tag,
            ConfigurablePropDefinition definition
    )
    {
        initializeInventory(definition);
        if (definition != null
                && definition.hasCompartments()
                && tag.hasKey("Compartments"))
        {
            NBTTagList compartments = tag.getTagList("Compartments", 10);
            for (int index = 0; index < compartments.tagCount(); index++)
            {
                NBTTagCompound compartmentTag = compartments.getCompoundTagAt(index);
                ConfigurablePropCompartment compartment = definition.getCompartment(
                        compartmentTag.getString("Id")
                );
                if (compartment != null)
                {
                    readItems(
                            compartmentTag.getTagList("Items", 10),
                            compartment.getStartSlot(),
                            compartment.getSize()
                    );
                }
            }
            return;
        }
        readItems(tag.getTagList("Items", 10), 0, inventory.length);
    }

    /** {@inheritDoc} */
    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return slot >= 0 && slot < inventory.length ? inventory[slot] : null;
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        ItemStack stack = getStackInSlot(slot);
        if (stack == null)
        {
            return null;
        }
        if (stack.stackSize <= amount)
        {
            inventory[slot] = null;
            markDirty();
            return stack;
        }
        ItemStack result = stack.splitStack(amount);
        if (stack.stackSize <= 0)
        {
            inventory[slot] = null;
        }
        markDirty();
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null)
        {
            inventory[slot] = null;
            markDirty();
        }
        return stack;
    }

    /** {@inheritDoc} */
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        if (slot < 0 || slot >= inventory.length)
        {
            return;
        }
        inventory[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit())
        {
            stack.stackSize = getInventoryStackLimit();
        }
        markDirty();
    }

    /** {@inheritDoc} */
    @Override
    public String getInventoryName()
    {
        ConfigurablePropDefinition definition = getDefinition();
        return definition != null
                ? definition.getInventoryName()
                : "container.foxblocks.configurable_prop";
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /** {@inheritDoc} */
    @Override
    public void openInventory()
    {
    }

    /** {@inheritDoc} */
    @Override
    public void closeInventory()
    {
    }

    /** {@inheritDoc} */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        if (slot < 0 || slot >= inventory.length)
        {
            return false;
        }
        ConfigurablePropInteraction interaction = getInteraction();
        if ((interaction instanceof ConfigurablePropStorageInteraction) == false)
        {
            return true;
        }
        return ((ConfigurablePropStorageInteraction) interaction).isItemValidForSlot(
                this,
                slot,
                stack
        );
    }

    /**
     * Persists inventory mutations and notifies processor subclasses. This also
     * catches direct stack-size changes followed by {@code Slot.onSlotChanged()},
     * which do not pass through the inventory setter methods.
     */
    @Override
    public void markDirty()
    {
        super.markDirty();
        onInventoryChanged();
    }

    /**
     * Allows processor subclasses to react after an inventory operation has
     * completed. Storage-only props require no additional lifecycle work.
     */
    protected void onInventoryChanged()
    {
    }

    /**
     * Allocates an empty inventory sized by the resolved definition.
     *
     * @param definition active definition, or {@code null} for no slots
     */
    private void initializeInventory(ConfigurablePropDefinition definition)
    {
        inventory = new ItemStack[definition != null ? definition.getInventorySize() : 0];
    }

    /**
     * Resizes storage while preserving the lowest slots that still fit.
     *
     * @param size non-negative target slot count
     */
    private void resizeInventory(int size)
    {
        if (inventory != null && inventory.length == size)
        {
            return;
        }
        ItemStack[] previousInventory = inventory;
        inventory = new ItemStack[size];
        if (previousInventory != null)
        {
            System.arraycopy(
                    previousInventory,
                    0,
                    inventory,
                    0,
                    Math.min(previousInventory.length, inventory.length)
            );
        }
    }

    /**
     * Serializes an inventory range using slot numbers local to that range.
     *
     * @param startSlot first combined inventory slot in the range
     * @param size number of consecutive slots to serialize
     * @return list containing every non-empty stack in the range
     */
    private NBTTagList writeItems(int startSlot, int size)
    {
        NBTTagList items = new NBTTagList();
        for (int localSlot = 0; localSlot < size; localSlot++)
        {
            ItemStack stack = inventory[startSlot + localSlot];
            if (stack != null)
            {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setByte("Slot", (byte) localSlot);
                stack.writeToNBT(itemTag);
                items.appendTag(itemTag);
            }
        }
        return items;
    }

    /**
     * Restores locally numbered slots into one range of the combined inventory.
     *
     * @param items serialized stacks using local slot numbers
     * @param startSlot first combined inventory slot receiving restored stacks
     * @param size maximum number of slots belonging to the range
     */
    private void readItems(NBTTagList items, int startSlot, int size)
    {
        for (int index = 0; index < items.tagCount(); index++)
        {
            NBTTagCompound itemTag = items.getCompoundTagAt(index);
            int localSlot = itemTag.getByte("Slot") & 255;
            if (localSlot < size && startSlot + localSlot < inventory.length)
            {
                inventory[startSlot + localSlot] = ItemStack.loadItemStackFromNBT(itemTag);
            }
        }
    }
}
