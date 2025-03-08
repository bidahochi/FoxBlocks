package com.bidahochi.BlockMod.core.handler.baseBlocks;

import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class BaseBlock extends Block
{
    public IIcon[] textures = new IIcon[16];
    protected byte amountOfSubBlocks = 0;
    private boolean FirstBlockHasNoIndex = false;
    public BaseBlock(BlockProperty blockProperty)
    {
        super(blockProperty.TheMaterial);
        setCreativeTab(blockProperty.CreativeTab);
        setBlockName(blockProperty.BlockName);
        setHardness(blockProperty.BlockHardness);
        setBlockTextureName(blockProperty.TexturePath);
        setHarvestLevel(blockProperty.ToolClass, blockProperty.HarvestLevel);
        setResistance(blockProperty.BlockResistance);
        if (blockProperty.SoundType != null)
        {
            setStepSound(blockProperty.SoundType);
        }

        if (blockProperty.lightLevel > 0f)
        {
            setLightLevel(blockProperty.lightLevel);
        }

        amountOfSubBlocks = ((byte) blockProperty.TotalTextureCount);
        FirstBlockHasNoIndex = blockProperty.FirstBlockHasNoIndex;
    }

    @Override
    protected void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(p_149642_1_, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }

    public void registerBlockIcons(IIconRegister reg) {
        for (int i = 0 ; i < amountOfSubBlocks; i++)
        {
            if (i == 0 && FirstBlockHasNoIndex)
            {
                this.textures[i] = reg.registerIcon(this.textureName);
            }
            else
            {
                this.textures[i] = reg.registerIcon(this.textureName + "_" + i);
            }
        }
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player)
    {
        return super.getPickBlock(target, world, x, y, z, player);
    }

    public int damageDropped( int oldmeta){
        return oldmeta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        if (meta > amountOfSubBlocks - 1)
        {
            meta = 0;
        }

        return this.textures[meta];
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < amountOfSubBlocks; ++i)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
