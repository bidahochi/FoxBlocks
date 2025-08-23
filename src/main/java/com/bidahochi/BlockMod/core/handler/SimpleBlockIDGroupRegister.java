package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.core.handler.baseBlocks.*;
import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import com.bidahochi.BlockMod.items.BaseItems.BaseItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;

import java.util.HashMap;

public class SimpleBlockIDGroupRegister
{
    public void RegisterIFoxBlockIDs(IFoxBlockIDs[] blockIDs, HashMap<IFoxBlockIDs, BlockProperty> tempBlockCache)
    {
        for (IFoxBlockIDs block : blockIDs)
        {
            if (!block.hasItemBlock())
            {
                System.out.println(block.GetBlockName());
                GameRegistry.registerBlock(block.GetBlock(), block.GetBlockName());
            }
            else
            {
                System.out.println(block.GetBlockName());
                GameRegistry.registerBlock(block.GetBlock(), block.getItemBlockClass(), block.GetBlockName());
            }

            if (block.GetMaxMetaData() > -1
                    && block.hasItemBlock()
                    && (BaseItemBlock.class.equals(block.getItemBlockClass()) || block.getItemBlockClass().getClass().isInstance(BaseItemBlock.class.getClass()))
                    && (block.GetBlock() instanceof BaseBlock || block.GetBlock() instanceof BasePillarBlock || block.GetBlock() instanceof BaseFallingBlock))
            {
                BlockProperty blockProperty = tempBlockCache.get(block);
                if (blockProperty != null)
                {
                    GameRegistry.registerBlock(blockProperty.getNewDoubleSlab(), com.bidahochi.BlockMod.items.BaseItems.BaseItemSlab.class, blockProperty.BlockName + "_DoubleSlab");
                    GameRegistry.registerBlock(blockProperty.getNewSingleSlab(), com.bidahochi.BlockMod.items.BaseItems.BaseItemSlab.class, blockProperty.BlockName + "_Slab");

                    if (blockProperty.TotalTextureCount > 8)
                    {
                        GameRegistry.registerBlock(blockProperty.getSecondNewDoubleSlab(), com.bidahochi.BlockMod.items.BaseItems.BaseItemSlab.class, blockProperty.BlockName + "_2_DoubleSlab");
                        GameRegistry.registerBlock(blockProperty.getSecondNewSingleSlab(), com.bidahochi.BlockMod.items.BaseItems.BaseItemSlab.class, blockProperty.BlockName + "_2_Slab");
                    }

                    for(int i = 0; i < blockProperty.TotalTextureCount; i++)
                    {
                        if (block.GetBlock() instanceof BaseFallingBlock)
                        {
                            GameRegistry.registerBlock(new BaseFallingBlockStair(block.GetBlock(), i, blockProperty), com.bidahochi.BlockMod.items.BaseItems.BaseItemStairBlock.class, blockProperty.BlockName + "_" + i + "_Stair");
                        }
                        else
                        {
                            GameRegistry.registerBlock(new BaseBlockStair(block.GetBlock(), i, blockProperty), com.bidahochi.BlockMod.items.BaseItems.BaseItemStairBlock.class, blockProperty.BlockName + "_" + i + "_Stair");
                        }
                    }

                    if (blockProperty.IsWallBlockAllowed())
                    {
                        GameRegistry.registerBlock(new BaseBlockWall(block.GetBlock(), blockProperty), com.bidahochi.BlockMod.items.BaseItems.BaseItemWallBlock.class, blockProperty.BlockName + "_Wall");
                    }

                    if (blockProperty.Is1XTileAllowed())
                    {
                        String blockName = blockProperty.IfExistsGetBlockOverrideName(blockProperty.TileKey);
                        if (blockName.equals("@~NO~@"))
                        {
                            GameRegistry.registerBlock(new BaseBlock1XTile(blockProperty), com.bidahochi.BlockMod.items.BaseItems.BaseItemBlock_1XTile.class, blockProperty.BlockName + "_1XTile");
                        }
                        else
                        {
                            GameRegistry.registerBlock(new BaseBlock1XTile(blockProperty), com.bidahochi.BlockMod.items.BaseItems.BaseItemBlock_1XTile.class, blockName);
                        }
                    }
                }
            }
        }
    }

    public void RegisterIFoxBlockIDRecipes(IFoxBlockIDs[] blockIDs, HashMap<IFoxBlockIDs, BlockProperty> tempBlockCache)
    {

    }

}
