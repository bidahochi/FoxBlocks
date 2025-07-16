package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.util.IIcon;


public class BaseBlockStair extends BlockStairs
{
    public Block ParentBlock;
    public final byte Metadata;

    public BaseBlockStair(Block block, int metaData, BlockProperty blockProperty)
    {
        super(block, 3);
        ParentBlock = block;
        Metadata = (byte) metaData;
        setCreativeTab(blockProperty.CreativeTab);
        setBlockName(blockProperty.BlockName + "_" + Metadata + "_Stair");
        setHardness(blockProperty.BlockHardness);
        setBlockTextureName(blockProperty.TexturePath);
        setHarvestLevel(blockProperty.ToolClass, blockProperty.HarvestLevel);
        setResistance(blockProperty.BlockResistance);
        if (blockProperty.SoundType != null)
        {
            setStepSound(blockProperty.SoundType);
        }
        this.useNeighborBrightness = true;
    }

    /**
     * Used to constructor a vanilla block as a foxblocks version of it
     * @param block
     * @param metaData
     */
    public BaseBlockStair(Block block, int metaData)
    {
        super(block, 3);
        ParentBlock = block;
        Metadata = (byte) metaData;
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabVanillaPlus);
        setBlockName(block.getUnlocalizedName().replace("tile.", "") + "_" + Metadata + "_Stair");
        setHardness(block.getBlockHardness(null, 0, 0, 0));

        setResistance(block.getExplosionResistance(null) * 5.0F);
        if (block.stepSound != null)
        {
            setStepSound(block.stepSound );
        }
        this.useNeighborBrightness = true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ParentBlock.getIcon(side, Metadata);
    }
}
