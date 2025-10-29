package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

import static com.bidahochi.BlockMod.core.handler.RenderBlockHandler.MinecraftFenceAbstractionLayer;

public class BaseBlockFence extends net.minecraft.block.BlockFence
{
    Block ParentBlock;
    public final byte AmountOfSubBlocks;

    public BaseBlockFence(Block block, BlockProperty blockProperty)
    {
        super("", blockProperty.TheMaterial);
        ParentBlock = block;
        AmountOfSubBlocks = (byte) blockProperty.TotalTextureCount;
        setCreativeTab(blockProperty.getFenceCreativeTab());
        setBlockName(blockProperty.BlockName + "_Fence");
        setHarvestLevel(blockProperty.ToolClass, blockProperty.HarvestLevel);
        setResistance(blockProperty.BlockResistance);
        if (blockProperty.SoundType != null)
        {
            setStepSound(blockProperty.SoundType);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ParentBlock.getIcon(side, meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < AmountOfSubBlocks; ++i)
        {
            list.add(new ItemStack(item, 1,  i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        // This is being overwritten sense metadata does not work in the inventory for Fences
        return MinecraftFenceAbstractionLayer;
    }
}
