package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.lwjgl.Sys;

import java.util.List;

public class MissingBlockHandler
{
    public static void initMissingBlock(List<FMLMissingMappingsEvent.MissingMapping> events)
    {
        for (FMLMissingMappingsEvent.MissingMapping mapping : events)
        {
            System.out.println("Missing Block Detected: Attempting Remapping of: " + mapping.name);
            if (mapping.name.equals("foxblocks:EmberStone Stair"))
            {
                if (GameRegistry.Type.ITEM.equals(mapping.type))
                {
                    Item item = GameRegistry.findItem(FoxBlocks.MODID, "Ember Stone_0_Stair");
                    mapping.remap(item);


                }
                else if (GameRegistry.Type.BLOCK.equals(mapping.type))
                {
                    Block block = GameRegistry.findBlock(FoxBlocks.MODID, "Ember Stone_0_Stair");
                    mapping.remap(block);
                }
            }
            else if (mapping.name.equals("foxblocks:Dark EmberStone Stair"))
            {
                if (GameRegistry.Type.ITEM.equals(mapping.type))
                {
                    Item item = GameRegistry.findItem(FoxBlocks.MODID, "Dark Ember Stone_0_Stair");
                    if (item == null)
                    {
                        System.out.println("ITEM NULL" + "Dark Ember Stone_0_Stair");
                    }
                    mapping.remap(item);
                }
                else if (GameRegistry.Type.BLOCK.equals(mapping.type))
                {
                    Block block = GameRegistry.findBlock(FoxBlocks.MODID, "Dark Ember Stone_0_Stair");
                    if (block == null)
                    {
                        System.out.println("block NULL" + "Dark Ember Stone_0_Stair");
                    }
                    mapping.remap(block);
                }
            }
            else if (mapping.name.equals("foxblocks:Soapstone Stair"))
            {
                if (GameRegistry.Type.ITEM.equals(mapping.type))
                {
                    Item item = GameRegistry.findItem(FoxBlocks.MODID, "Soapstone_0_Stair");
                    if (item == null)
                    {
                        System.out.println("ITEM NULL" + "Soapstone_0_Stair");
                    }
                    mapping.remap(item);
                }
                else if (GameRegistry.Type.BLOCK.equals(mapping.type))
                {
                    Block block = GameRegistry.findBlock(FoxBlocks.MODID, "Soapstone_0_Stair");
                    if (block == null)
                    {
                        System.out.println("block NULL" + "Soapstone_0_Stair");
                    }
                    mapping.remap(block);
                }
            }
            else if (mapping.name.equals("foxblocks:EmberStone Slab"))
            {
                if (GameRegistry.Type.ITEM.equals(mapping.type))
                {
                    Item item = GameRegistry.findItem(FoxBlocks.MODID, "Ember Stone_Slab");
                    if (item == null)
                    {
                        System.out.println("ITEM NULL" + "Ember Stone_Slab");
                    }
                    mapping.remap(item);
                }
                else if (GameRegistry.Type.BLOCK.equals(mapping.type))
                {
                    Block block = GameRegistry.findBlock(FoxBlocks.MODID, "Ember Stone_Slab");
                    if (block == null)
                    {
                        System.out.println("block NULL" + "Ember Stone_Slab");
                    }
                    mapping.remap(block);
                }
            }
            else if (mapping.name.equals("foxblocks:Dark EmberStone Slab"))
            {
                if (GameRegistry.Type.ITEM.equals(mapping.type))
                {
                    Item item = GameRegistry.findItem(FoxBlocks.MODID, "Dark Ember Stone_Slab");
                    if (item == null)
                    {
                        System.out.println("ITEM NULL" + "Dark Ember Stone_Slab_0");
                    }
                    mapping.remap(item);
                }
                else if (GameRegistry.Type.BLOCK.equals(mapping.type))
                {
                    Block block = GameRegistry.findBlock(FoxBlocks.MODID, "Dark Ember Stone_Slab");
                    if (block == null)
                    {
                        System.out.println("block NULL" + "Dark Ember Stone_Slab");

                    }
                    mapping.remap(block);
                }
            }
            else if (mapping.name.equals("foxblocks:Soapstone Slab"))
            {
                if (GameRegistry.Type.ITEM.equals(mapping.type))
                {
                    Item item = GameRegistry.findItem(FoxBlocks.MODID, "Soapstone_Slab");
                    if (item == null)
                    {
                        System.out.println("ITEM NULL" + "Soapstone_Slab_0");
                    }
                    mapping.remap(item);
                }
                else if (GameRegistry.Type.BLOCK.equals(mapping.type))
                {
                    Block block = GameRegistry.findBlock(FoxBlocks.MODID, "Soapstone_Slab");
                    if (block == null)
                    {
                        System.out.println("block NULL" + "Soapstone_Slab_0");
                    }
                    mapping.remap(block);
                }
            }

        }
    }


    private static void remap(FMLMissingMappingsEvent.MissingMapping mapping, String name, Item item)
    {
        if (mapping.type == GameRegistry.Type.ITEM && mapping.name.equals(FoxBlocks.MODID + ":" + name))
        {
            mapping.remap(item);
        }
    }

    private static void remap(FMLMissingMappingsEvent.MissingMapping mapping, String name, net.minecraft.block.Block block)
    {
        remap(mapping, name, Item.getItemFromBlock(block));

        if (mapping.type == GameRegistry.Type.BLOCK && mapping.name.equals(FoxBlocks.MODID + ":" + name))
        {
            mapping.remap(block);
        }
    }
}


