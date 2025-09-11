package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.core.handler.baseBlocks.*;
import com.bidahochi.BlockMod.core.handler.baseBlocks.blockPropertys.BlockProperty;
import com.bidahochi.BlockMod.items.BaseItems.BaseItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class SimpleBlockIDGroupRegister
{
    private String MODID;

    public SimpleBlockIDGroupRegister(String modid)
    {
        MODID = modid;
    }


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
                        GameRegistry.registerBlock(blockProperty.getBlockStair(i), com.bidahochi.BlockMod.items.BaseItems.BaseItemStairBlock.class, blockProperty.BlockName + "_" + i + "_Stair");
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
                            GameRegistry.registerBlock(blockProperty.getNewBlock1XTile(), com.bidahochi.BlockMod.items.BaseItems.BaseItemBlock_1XTile.class, blockProperty.BlockName + "_1XTile");
                        }
                        else
                        {
                            GameRegistry.registerBlock(blockProperty.getNewBlock1XTile(), com.bidahochi.BlockMod.items.BaseItems.BaseItemBlock_1XTile.class, blockName);
                        }
                    }
                }
            }
        }
    }

    /**
     * USE ONLY AFTER ITEMS HAVE BEEN INITIALIZED DO NOT CALL THIS FROM YOUR BLOCK REIGSTER
     * @param blockIDs
     * @param tempBlockCache
     */
    public void RegisterIFoxBlockIDRecipes(IFoxBlockIDs[] blockIDs, HashMap<IFoxBlockIDs, BlockProperty> tempBlockCache)
    {
        // Auto Register Slab And Stair Recipes
        for (IFoxBlockIDs block : blockIDs)
        {
            if (block.GetMaxMetaData() > -1
                    && block.hasItemBlock()
                    && (BaseItemBlock.class.equals(block.getItemBlockClass()) || block.getItemBlockClass().getClass().isInstance(BaseItemBlock.class.getClass()))
                    && (block.GetBlock() instanceof BaseBlock || block.GetBlock() instanceof BasePillarBlock || block.GetBlock() instanceof BaseFallingBlock))
            {
                BlockProperty blockProperty = tempBlockCache.get(block);
                if (blockProperty != null && blockProperty.Is1XTileAllowed())
                {
                    String blockName = blockProperty.IfExistsGetBlockOverrideName(blockProperty.TileKey);
                    Block block1XTile;
                    if (blockName.equals("@~NO~@"))
                    {
                        block1XTile = GameRegistry.findBlock(MODID, block.GetBlockName() + "_1XTile");
                    }
                    else
                    {
                        block1XTile = GameRegistry.findBlock(MODID, blockName);
                    }

                    for (int i = 0; i <= block.GetMaxMetaData(); i++)
                    {
                        GameRegistry.addShapedRecipe(new ItemStack(block1XTile, 16, i), "IX", "  ", 'I', new ItemStack(block.GetBlock(), 1, i), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
                    }
                }

                // Slabs can only go up to 7 as metadata is used for the bottom and top sate
                if (block.GetMaxMetaData() < 8)
                {
                    Block blockSlab = GameRegistry.findBlock(MODID, block.GetBlockName() + "_Slab");
                    if (blockSlab == null)
                    {
                        blockSlab = GameRegistry.findBlock(MODID, block.GetBlockName().replace(" ", "") + "_Slab");
                    }

                    if (blockSlab != null)
                    {
                        for (int i = 0; i <= block.GetMaxMetaData(); i++)
                        {
                            GameRegistry.addShapedRecipe(new ItemStack(blockSlab, 6, i), "   ", "   ", "III", 'I', new ItemStack(block.GetBlock(), 1, i));
                            GameRegistry.addShapedRecipe(new ItemStack(blockSlab, 2, i), " X", " I", 'I', new ItemStack(block.GetBlock(), 1, i), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
                            GameRegistry.addShapedRecipe(new ItemStack(block.GetBlock(), 1, i), "   ", " I ", " I ", 'I', new ItemStack(blockSlab, 1, i));
                        }
                    }
                }
                else
                {
                    Block blockSlab = GameRegistry.findBlock(MODID, block.GetBlockName() + "_Slab");
                    if (blockSlab == null)
                    {
                        blockSlab  = GameRegistry.findBlock(MODID, block.GetBlockName().replace(" ", "") + "_Slab");
                    }

                    if (blockSlab != null)
                    {
                        for (int i = 0; i <= 7; i++)
                        {
                            GameRegistry.addShapedRecipe(new ItemStack(blockSlab, 6, i), "   ", "   ", "III", 'I', new ItemStack(block.GetBlock(), 1, i));
                            GameRegistry.addShapedRecipe(new ItemStack(blockSlab, 2, i), " X", " I", 'I', new ItemStack(block.GetBlock(), 1, i), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
                            GameRegistry.addShapedRecipe(new ItemStack(block.GetBlock(), 1, i), "   ", " I ", " I ", 'I', new ItemStack(blockSlab, 1, i));
                        }
                    }

                    Block blockSlabTwo = GameRegistry.findBlock(MODID, block.GetBlockName() + "_2_Slab");
                    if (blockSlabTwo == null)
                    {
                        blockSlabTwo  = GameRegistry.findBlock(MODID, block.GetBlockName().replace(" ", "") + "_2_Slab");
                    }

                    if (blockSlabTwo != null)
                    {
                        for (int i = 0; i <= block.GetMaxMetaData() - 8; i++)
                        {
                            GameRegistry.addShapedRecipe(new ItemStack(blockSlabTwo, 6, i), "   ", "   ", "III", 'I', new ItemStack(block.GetBlock(), 1, i + 8));
                            GameRegistry.addShapedRecipe(new ItemStack(blockSlabTwo, 2, i), " X", " I", 'I', new ItemStack(block.GetBlock(), 1, i + 8), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
                            GameRegistry.addShapedRecipe(new ItemStack(block.GetBlock(), 1, i + 8), "   ", " I ", " I ", 'I', new ItemStack(blockSlabTwo, 1, i));
                        }
                    }
                }

                for (int i = 0; i <= block.GetMaxMetaData(); i++)
                {
                    Block blockStair = GameRegistry.findBlock(MODID, block.GetBlockName() + "_" + i + "_Stair");
                    if (blockStair == null)
                    {
                        blockStair = GameRegistry.findBlock(MODID, block.GetBlockName().replace(" ", "") + "_" + i + "_Stair");
                    }

                    GameRegistry.addShapedRecipe(new ItemStack(blockStair, 6, 0), "B  ", "BB ", "BBB", 'B', new ItemStack(block.GetBlock(), 1, i));
                    GameRegistry.addShapedRecipe(new ItemStack(blockStair, 1, 0), "  ", "BX", 'B', new ItemStack(block.GetBlock(), 1, i), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
                }

                if (tempBlockCache.containsKey(block) && tempBlockCache.get(block).IsWallBlockAllowed())
                {
                    for (int i = 0; i <= block.GetMaxMetaData(); i++)
                    {
                        Block blockWall = GameRegistry.findBlock(MODID, block.GetBlockName() + "_Wall");

                        GameRegistry.addShapedRecipe(new ItemStack(blockWall, 6, i), "BBB", "BBB", "   ", 'B', new ItemStack(block.GetBlock(), 1, i));
                        GameRegistry.addShapedRecipe(new ItemStack(blockWall, 1, i), " X", "B ", 'B', new ItemStack(block.GetBlock(), 1, i), 'X', new ItemStack(ItemIDs.bolsterChisel.item, 1, 0));
                    }
                }
            }
        }
    }

}
