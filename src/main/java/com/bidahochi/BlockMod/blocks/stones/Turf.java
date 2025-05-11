package com.bidahochi.BlockMod.blocks.stones;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.BlockIDs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class Turf extends Block {

    public IIcon [] textures = new IIcon[6];

    public Turf(Material p_i45394_1_) {
        super(p_i45394_1_);
        setStepSound(soundTypeGrass);
        setHardness(0.5F);
        setResistance(0.1F);
        setHarvestLevel("shovel", 0);
        setBlockName(BlockIDs.turf.blockName);
        setBlockTextureName(FoxBlocks.MODID+":aggregates/grasses/turf");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
    }

    public void registerBlockIcons(IIconRegister reg) {
        for (int i = 0 ; i < 6; i++) {
            this.textures[i] = reg.registerIcon(this.textureName + "_" + i);
        }
    }

    public IIcon getIcon( int side, int meta) {
        return this.textures[side];
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
        return true;
    }
}
