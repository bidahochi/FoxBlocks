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
        super(Material.wood);
        setBlockTextureName(FoxBlocks.MODID+":constructionmaterials/pfence/pfence");
        setBlockName("PFencing");
        amountOfSubBlocks = 4;
        setStepSound(soundTypeWood);
    }

    @Override
    public int getRenderType() {
        return privacyPaneRenderId;//11 is fence (doesnt work), 18 is pane, 41 is stainedglasspane
        //-1 is invisible
        //0 is trying to be a regular block
        //1 is grass/ flowers/ ect
        //2 is blocktorch
        //3 is fire (gamecrash)
        //4 is liquid
        //5 turns it into redstone
        //6 is crop
        //7 is door (invisible)
        //8 is ladder (invisible)
        //9 is rail (gamecrash)

    }
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
}

