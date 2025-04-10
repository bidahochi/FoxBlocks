package com.bidahochi.BlockMod.blocks.constructionmaterials;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.BaseClassFolder.BaseBlockPane;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

import static com.bidahochi.BlockMod.core.handler.RenderBlockHandler.privacyPaneRenderId;

public class PFencing extends BaseBlockPane
{
    public PFencing() {
        super(Material.iron);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/pfence/pfence");
        setBlockName("PFencing");
        amountOfSubBlocks = 4;
        setStepSound(soundTypeWood);


    }

    @Override
    public int getRenderType() {
        return privacyPaneRenderId;
    }
}
