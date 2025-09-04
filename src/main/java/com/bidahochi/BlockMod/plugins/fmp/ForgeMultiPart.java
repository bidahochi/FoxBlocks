package com.bidahochi.BlockMod.plugins.fmp;

import codechicken.microblock.BlockMicroMaterial;
import codechicken.microblock.MicroMaterialRegistry;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import com.bidahochi.BlockMod.core.handler.IFoxBlockIDs;
import com.bidahochi.BlockMod.items.BaseItems.BaseItemSlab;
import com.bidahochi.BlockMod.items.BaseItems.BaseItemStairBlock;

public class ForgeMultiPart
{
    public static void registerBlocks(IFoxBlockIDs[] foxBlockIDs)
    {
        try
        {
            for (IFoxBlockIDs block : foxBlockIDs)
            {
                // Blocks that should never be registered because why
                if (block.getItemBlockClass() != BaseItemStairBlock.class
                        && block.getItemBlockClass() != BaseItemSlab.class)
                {
                    switch (block.GetMaxMetaData())
                    {
                        case -1:
                            // When the MaxMetaData is -1 this indicates that this block should never be allowed to be made a Multipart
                            // Blocks such as doors will crash the mod
                            break;
                        case 0:
                            MicroMaterialRegistry.registerMaterial(new BlockMicroMaterial(block.GetBlock(), 0), BlockMicroMaterial.materialKey(block.GetBlock(), 0));
                            break;
                        default:
                            for (byte i = 0; i <= block.GetMaxMetaData(); i++)
                            {
                                MicroMaterialRegistry.registerMaterial(new BlockMicroMaterial(block.GetBlock(), i), BlockMicroMaterial.materialKey(block.GetBlock(), i));
                            }
                            break;
                    }
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
