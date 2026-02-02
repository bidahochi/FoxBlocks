package com.bidahochi.BlockMod.blocks;

import com.bidahochi.BlockMod.blocks.scrolling.IFoxBlocksScrollingBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBlockScrolling extends ItemBlock {
    public ItemBlockScrolling(Block block)
    {
        super(block);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List flavorText, boolean par4)
    {
        flavorText.add("\u00a77" + "Shift+Scroll to");
        flavorText.add("\u00a77" + "Cycle Between " + getFlavorText(((IFoxBlocksScrollingBlock)field_150939_a).getScrollListID()));
    }

    private String getFlavorText(int scrollGroupID)
    {
        switch (scrollGroupID)
        {
            case 0:
                return "Bridge Center Pieces";
            case 1:
                return "Bridge Side Pieces";
            case 2:
                return "Bridge X Pieces";
            default:
                return "Blocks";
        }
    }
}
