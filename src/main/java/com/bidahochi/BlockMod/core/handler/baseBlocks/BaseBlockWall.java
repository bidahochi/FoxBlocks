package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

import static com.bidahochi.BlockMod.core.handler.RenderBlockHandler.MC20w15aWall;

public class BaseBlockWall extends BlockWall
{
    Block ParentBlock;
    public final byte Metadata;

    public BaseBlockWall(Block block, int metaData, BlockProperty blockProperty)
    {
        super(block);
        ParentBlock = block;
        Metadata = (byte) metaData;
        setCreativeTab(blockProperty.CreativeTab);
        setBlockName(blockProperty.BlockName + "_" + Metadata + "_Wall");
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

    @Override
    public boolean func_149730_j()
    {
        return true;
    }

    public int getRenderType() {
        return MC20w15aWall;
    }

    @Override
    public boolean isNormalCube() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean canConnectWallTo(IBlockAccess blockAccess, int p_canConnectWallTo_2_, int p_canConnectWallTo_3_, int p_canConnectWallTo_4_)
    {
        Block block = blockAccess.getBlock(p_canConnectWallTo_2_, p_canConnectWallTo_3_, p_canConnectWallTo_4_);
        if (block != this && block != Blocks.fence_gate && block instanceof BlockPane == false && block instanceof BaseBlockWall == false)
        {
            if (block.getMaterial().isOpaque() && block.renderAsNormalBlock())
            {
                return block.getMaterial() != Material.gourd;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ParentBlock.getIcon(side, Metadata);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_getSubBlocks_1_, CreativeTabs p_getSubBlocks_2_, List p_getSubBlocks_3_) {
        p_getSubBlocks_3_.add(new ItemStack(p_getSubBlocks_1_, 1, 0));
    }
}
