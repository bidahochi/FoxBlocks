package com.bidahochi.BlockMod.items.BaseItems;

        import com.bidahochi.BlockMod.FoxBlocks;
        import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseAbstractSlab;
        import com.bidahochi.BlockMod.core.handler.baseBlocks.BaseBlockSlab;
        import cpw.mods.fml.common.registry.GameRegistry;
        import net.minecraft.block.Block;
        import net.minecraft.block.BlockSlab;
        import net.minecraft.item.ItemSlab;
        import net.minecraft.item.ItemStack;

public class BaseItemSlab extends ItemSlab
{
    public BaseItemSlab(Block block)
    {
        super(block,
                (BlockSlab) block, // BlockIDs.searchEnum(BlockIDs.class, block.getUnlocalizedName().replace("_DoubleSlab","_Slab").replace("tile.", "").replace(" ", "")).block
                (BaseAbstractSlab) GameRegistry.findBlock(FoxBlocks.MODID, ((BaseAbstractSlab)block).BaseBlockName + (block.getUnlocalizedName().contains("_2_") ? "_2_" : "_") + "DoubleSlab"), // BlockIDs.searchEnum(BlockIDs.class, block.getUnlocalizedName().replace("_Slab","_DoubleSlab").replace("tile.", "").replace(" ", "")).block
                block.getUnlocalizedName().contains("_DoubleSlab"));
        setHasSubtypes(true);
    }


    public String getUnlocalizedName(ItemStack itemstack)
    {
        return super.getUnlocalizedName() + "_" + itemstack.getItemDamage();
    }
}
