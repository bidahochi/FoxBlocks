package com.bidahochi.BlockMod.core.handler.baseBlocks.vanillaBlockConvertions;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.BaseClassFolder.IScrollingSlabToVerticalSlabBlock;
import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseAbstractSlab;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

import static com.bidahochi.BlockMod.FoxBlocks.foxBlocksCreativeTabVanillaPlus;

public class BaseVanillaBlockSlab extends BlockSlab implements IScrollingSlabToVerticalSlabBlock
{
    public Block ParentBlock;
    private BaseVanillaBlockSlab singleSlab;
    private byte amountOfSubBlocks = 0;

    public final byte BlockNumberStartingIndex;
    private String altBlockName;

    public String GetBaseBlockName()
    {
        if (altBlockName == null)
        {
            return ParentBlock.getUnlocalizedName().replace("tile.", "");
        }

        return altBlockName;
    }

    public BaseVanillaBlockSlab(Boolean isDoubleSlab, VanillaBlockProperty blockProperty, Block singleSlab, int blockNumberStartingIndex)
    {
        super(singleSlab != null, blockProperty.block.getMaterial());
        this.singleSlab = (BaseVanillaBlockSlab)singleSlab;
        BlockNumberStartingIndex = (byte) blockNumberStartingIndex;
        ParentBlock = blockProperty.block;
        if (blockNumberStartingIndex == 0)
        {
            if (singleSlab == null)
            {
                setCreativeTab(FoxBlocks.foxBlocksCreativeTabVanillaPlus);
                setBlockName(GetBaseBlockName() + "_Slab");
            }
            else
            {
                setBlockName(GetBaseBlockName() + "_DoubleSlab");
            }
        }
        else
        {
            if (singleSlab == null)
            {
                setCreativeTab(FoxBlocks.foxBlocksCreativeTabVanillaPlus);
                setBlockName(GetBaseBlockName() + "_2_Slab");
            }
            else
            {
                setBlockName(GetBaseBlockName() + "_2_DoubleSlab");
            }
        }

        setTickRandomly(false);
        blockHardness = ParentBlock.getBlockHardness(null, 0, 0, 0);
        setBlockTextureName(blockProperty.textureName);
        setStepSound(ParentBlock.stepSound);
        setLightLevel(lightValue);
        useNeighborBrightness = true;

        if (blockProperty.TotalTextureCount > 8 && blockNumberStartingIndex == 0)
        {
            amountOfSubBlocks = (byte)8;
        }
        else if (blockNumberStartingIndex == 8)
        {
            amountOfSubBlocks = (byte)(blockProperty.TotalTextureCount - 8);
        }
        else
        {
            amountOfSubBlocks = ((byte) blockProperty.TotalTextureCount);
        }
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_)
    {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }

    public int damageDropped(int oldmeta)
    {
        return oldmeta & 7;
    }

    protected ItemStack createStackedBlock(int stacked)
    {
        return new ItemStack(this, 2, stacked);
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player)
    {
        BaseVanillaBlockSlab block = (BaseVanillaBlockSlab) world.getBlock(x, y, z);

        return new ItemStack(block.isDoubleSlab() ? GetSingleBlock() : block, 1, world.getBlockMetadata(x,y,z) & 7);
    }

    public boolean isDoubleSlab()
    {
        return singleSlab != null;
    }

    private Block GetSingleBlock()
    {
        return GameRegistry.findBlock(FoxBlocks.MODID,  GetBaseBlockName() + (getUnlocalizedName().contains("_2_") ? "_2_Slab" : "_Slab"));
    }


    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ParentBlock.getIcon(side, (meta & 7) + BlockNumberStartingIndex);
    }

    @Override
    public String func_150002_b(int damage)
    {
        return getUnlocalizedName() + "_" + damage + "_" + (isDoubleSlab() ? "DoubleSlab" : "Slab");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < amountOfSubBlocks; ++i)
        {
            list.add(new ItemStack(item, 1,  i));
        }
    }
}


