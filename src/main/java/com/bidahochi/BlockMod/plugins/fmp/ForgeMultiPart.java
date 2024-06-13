package com.bidahochi.BlockMod.plugins.fmp;

import codechicken.microblock.BlockMicroMaterial;
import codechicken.microblock.MicroMaterialRegistry;
import com.bidahochi.BlockMod.core.handler.BlockIDs;

public class ForgeMultiPart
{
    public static void registerBlocks()
    {
        try
        {
            for (BlockIDs block : BlockIDs.values())
            {
                switch (block.MaxMetadata)
                {
                    case -1:
                        // When the MaxMetaData is -1 this indicates that this block should never be allowed to be made a Multipart
                        // Blocks such as doors will crash the mod
                        break;
                    case 0:
                        MicroMaterialRegistry.registerMaterial(new BlockMicroMaterial(block.block, 0), BlockMicroMaterial.materialKey(block.block, 0));
                        break;
                    default:
                        for (byte i = 0; i <= block.MaxMetadata; i++)
                        {
                            MicroMaterialRegistry.registerMaterial(new BlockMicroMaterial(block.block, i), BlockMicroMaterial.materialKey(block.block, i));
                        }
                        break;
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
