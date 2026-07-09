package com.bidahochi.BlockMod.blocks.stones;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;


public class soapStoneMagmatic extends Block {
    public soapStoneMagmatic(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("Magmatic Soapstone");
        setHardness(2F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeStone);
        setLightLevel(0.7F);
        setBlockTextureName(FoxBlocks.MODID+":stones/soapstone_magmatic");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRock);
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
        boolean silkTouchPickaxe = isHeldItemPickaxe(player) && canSilkHarvest(world, player, x, y, z, meta) && EnchantmentHelper.getSilkTouchModifier(player);

        super.harvestBlock(world, player, x, y, z, meta);

        if (!world.isRemote && !silkTouchPickaxe) {
            world.setBlock(x, y, z, Blocks.flowing_lava, 0, 3);
        }
    }

    private boolean isHeldItemPickaxe(EntityPlayer player) {
        ItemStack heldItem = player.getHeldItem();

        if (heldItem == null) {
            return false;
        }

        Item item = heldItem.getItem();
        return item.getToolClasses(heldItem).contains("pickaxe") || item.getHarvestLevel(heldItem, "pickaxe") >= 0;
    }
}
