package com.bidahochi.BlockMod.blocks.roadpaints;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class ScrollingItemBlock extends ItemBlockWithMetadata {

    private final Block block;

    public ScrollingItemBlock(Block block) {
        super(block, block);
        this.block = block;
        this.setHasSubtypes(true);
        this.setMaxDamage(EnumRoadShapes.values().length);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata) {
        return this.block.getIcon(ForgeDirection.UP.ordinal(), metadata);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int metadata = itemStack.getItemDamage();
        return String.format("%s.%d", this.block.getUnlocalizedName(), metadata);
    }
}
