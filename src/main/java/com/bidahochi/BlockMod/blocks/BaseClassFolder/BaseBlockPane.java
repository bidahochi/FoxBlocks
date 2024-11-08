package com.bidahochi.BlockMod.blocks.BaseClassFolder;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public abstract class BaseBlockPane extends BlockPane
{
    protected IIcon[] textures = new IIcon[16];
    protected int metaNum = 0;
    protected int amountOfSubBlocks = 0;

    protected BaseBlockPane()
    {
        super("", "", Material.glass, false);
        setHardness(0.4F);
        setStepSound(Block.soundTypeGlass);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
    }

    @Override
    public Block setLightOpacity(int p_149713_1_) {
        return super.setLightOpacity(1);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public IIcon func_150097_e()
    {
        return this.textures[metaNum];
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        for (int i = 0; i < amountOfSubBlocks; i++)
        {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }

    @Override
    public IIcon getIcon (int side, int meta){
        if (meta > amountOfSubBlocks-1 )
        {
            meta = 0;
        }
        metaNum = meta;
        return this.textures[meta];
    }

    public int damageDropped(int oldmeta)
    {
        return oldmeta;
    }

    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < amountOfSubBlocks; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
