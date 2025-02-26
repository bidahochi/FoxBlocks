package com.bidahochi.BlockMod.core.handler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BaseBlockStair extends BlockStairs
{
    Block ParentBlock;
    private boolean FirstBlockHasNoIndex = false;
    public byte Metadata;

    public BaseBlockStair(Block block, int metaData, BlockProperty blockProperty)
    {
        super(block, metaData);
        ParentBlock = block;
        setCreativeTab(blockProperty.CreativeTab);
        setBlockName(blockProperty.BlockName + "_Stair");
        setHardness(blockProperty.BlockHardness);
        setBlockTextureName(blockProperty.TexturePath);
        setHarvestLevel(blockProperty.ToolClass, blockProperty.HarvestLevel);
        setResistance(blockProperty.BlockResistance);
        setStepSound(blockProperty.SoundType);
        this.useNeighborBrightness = true;
        Metadata = (byte) metaData;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ParentBlock.getIcon(side, Metadata);
    }

    public int damageDropped( int oldmeta)
    {
        return oldmeta;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        list.add(new ItemStack(item, 1, Metadata));
    }

}
