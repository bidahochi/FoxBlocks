package com.bidahochi.BlockMod.blocks.essentiallymemes;

/************************
 *
 *  This is the Pane source code. This code makes Panes work!
 *
 *  Inside each slab's public slabname() There should be a String (name of pane), Material of pane and Boolean (true for bar, false for pane)
 *
 *  In the Blockhanders file, register them
 *  Use Format:
 *      BlockIDs.<pane>.block = new <pane>(BlockIDs.<pane>.blockName, Material.<material of pane>, <true if bar, false if pane>);
 *
 *  Treat the rest of this file as a normal Block file, you can make this have metadata, hardness, textures etc as normal
 *  [Do not touch this file as it is a blueprint for all your panes!]
 *
 *  Any questions feel free to ping me or dm me on the discord!
 *
 *  -hariesh
 *
 **************************/

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

public class testPane extends BlockPane {

    public testPane(String string, Material material, Boolean bool) {
        super(string, string, material, bool);
        setBlockName("test");
    }
}
