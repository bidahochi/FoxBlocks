package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.constructionmaterials.ItemBlockdryWall;
import com.bidahochi.BlockMod.blocks.constructionmaterials.ItemBlockfiberGlass;
import com.bidahochi.BlockMod.blocks.constructionmaterials.ItemBlocksoapStoneDeco;
import com.bidahochi.BlockMod.blocks.constructionmaterials.ItemBlockwallPaper;
import com.bidahochi.BlockMod.blocks.metals.ItemBlockmetalSiding;
import com.bidahochi.BlockMod.core.handler.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

import static net.minecraft.block.Block.*;

public enum BlockProperties {


    testBlock2(false,null,"Test block 2 ", 1F,1F, "axe",1, Material.sand,soundTypeAnvil,"text"),
    ;

    public Block block;
    public boolean hasItemBlock;
    public Class itemBlockClass;
    public String blockName;
    public float hardness;
    public float resistance;
    public String harvestTool;
    public int harvestLevel;
    public Material material;
    public SoundType sound;
    public String textureLocation;


    BlockProperties(boolean hasItemBlock,Class<? extends ItemBlock> itemBlockClass, String blockName, float hardness, float resistance, String harvestTool, int harvestLevel, Material material, Block.SoundType sound, String textureLocation) {
        this.hasItemBlock = hasItemBlock;
        this.itemBlockClass = itemBlockClass;
        this.blockName = blockName;
        this.hardness = hardness;
        this.resistance = resistance;
        this.harvestTool = harvestTool;
        this.harvestLevel = harvestLevel;
        this.material = material;
        this.sound = sound;
        this.textureLocation = textureLocation;
    }
}
