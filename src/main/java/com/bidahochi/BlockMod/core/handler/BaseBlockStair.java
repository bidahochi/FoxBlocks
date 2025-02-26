package com.bidahochi.BlockMod.core.handler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.util.IIcon;


public class BaseBlockStair extends BlockStairs
{
    Block ParentBlock;
    private boolean FirstBlockHasNoIndex = false;
    public final byte Metadata;

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
        if (blockProperty.SoundType != null)
        {
            setStepSound(blockProperty.SoundType);
        }

        this.useNeighborBrightness = true;
        Metadata = (byte) metaData;
    }

    @Override
    public String getUnlocalizedName()
    {
        return super.getUnlocalizedName() + "_" + Metadata;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ParentBlock.getIcon(side, Metadata);
    }
}
