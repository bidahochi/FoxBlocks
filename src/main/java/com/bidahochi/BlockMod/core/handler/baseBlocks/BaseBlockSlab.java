package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BaseBlockSlab extends BlockSlab
{
    public IIcon[] textures = new IIcon[8];
    private BaseBlockSlab singleSlab;
    protected byte amountOfSubBlocks = 0;
    /*
    This is used to identify where a block should start for textures
     */
    public final byte BlockNumberStartingIndex;
    private boolean FirstBlockHasNoIndex = false;
    public final String BaseBlockName;

    public BaseBlockSlab(Boolean isDoubleSlab, BlockProperty blockProperty, Block singleSlab, int blockNumberStartingIndex)
    {
        super(singleSlab != null, blockProperty.TheMaterial);
        BlockNumberStartingIndex = (byte)blockNumberStartingIndex;
        this.singleSlab = (BaseBlockSlab)singleSlab;
        BaseBlockName = blockProperty.BlockName;

        if (BlockNumberStartingIndex == 0)
        {
            if (singleSlab == null)
            {
                setBlockName(BaseBlockName + "_Slab");
            }
            else
            {
                setBlockName(BaseBlockName + "_DoubleSlab");
            }
        }
        else
        {
            if (singleSlab == null)
            {
                setBlockName(BaseBlockName + "_2_Slab");
            }
            else
            {
                setBlockName(BaseBlockName + "_2_DoubleSlab");
            }
        }


        setTickRandomly(false);
        setHardness(blockProperty.BlockHardness);
        setBlockTextureName(blockProperty.TexturePath);

        if (blockProperty.lightLevel > 0f)
        {
            setLightLevel(blockProperty.lightLevel);
        }

        if (blockProperty.SoundType != null)
        {
            setStepSound(blockProperty.SoundType);
        }

        setHarvestLevel(blockProperty.ToolClass, blockProperty.HarvestLevel);
        setResistance(blockProperty.BlockResistance);
        setLightLevel(lightValue);

        if (isDoubleSlab() == false)
        {
            setCreativeTab(blockProperty.CreativeTab);
        }
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

        FirstBlockHasNoIndex = blockProperty.FirstBlockHasNoIndex;
    }

    public boolean isDoubleSlab()
    {
        return singleSlab != null;
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_)
    {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }

    public void registerBlockIcons(IIconRegister reg)
    {
        for (int i = 0 ; i < amountOfSubBlocks; i++)
        {
            if (i == 0 && FirstBlockHasNoIndex)
            {
                this.textures[i] = reg.registerIcon(this.textureName);
            }
            else
            {
                this.textures[i] = reg.registerIcon(this.textureName + "_" + (i + BlockNumberStartingIndex));
            }
        }
    }

    /************
     * DROPS
     ************/
   @Override
   public Item getItemDropped(int par1, Random par2Random, int par3)
   {
       return Item.getItemFromBlock(singleSlab == null ? this : singleSlab);
   }

    protected ItemStack createStackedBlock(int stacked)
    {
        return new ItemStack(this, 2, stacked);
    }

    public int damageDropped(int oldmeta)
    {
        return oldmeta & 7;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player)
    {
        BaseBlockSlab block = (BaseBlockSlab) world.getBlock(x, y, z);

        return new ItemStack(block.isDoubleSlab() ? GetSingleBlock() : block, 1, world.getBlockMetadata(x,y,z) & 7);
    }

    private Block GetSingleBlock()
    {
        return GameRegistry.findBlock(FoxBlocks.MODID, BaseBlockName + (getUnlocalizedName().contains("_2_") ? "_2_Slab" : "_Slab"));
    }

    /************
     * TEXTURES
     ************/

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.textures[meta & 7];
    }

    @Override
    public String func_150002_b(int damage)
    {
        return getUnlocalizedName() + "_" + damage + "_" + (isDoubleSlab() ? "DoubleSlab" : "Slab");
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < amountOfSubBlocks; ++i)
        {
            list.add(new ItemStack(item, 1,  i));
        }
    }
}
