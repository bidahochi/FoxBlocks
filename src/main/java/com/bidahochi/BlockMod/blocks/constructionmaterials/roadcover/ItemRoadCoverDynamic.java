package com.bidahochi.BlockMod.blocks.constructionmaterials.roadcover;

import com.bidahochi.BlockMod.core.handler.BlockIDs;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemRoadCoverDynamic extends ItemBlockWithMetadata
{
    public ItemRoadCoverDynamic(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName( ItemStack item){
        return this.getUnlocalizedName() + "_" + item.getItemDamage();
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        if (world.isRemote == false)
        {
            world.setBlock(x, y + 1, z, BlockIDs.roadcover_dynamic.block, MathHelper.floor_double((player != null ? player.rotationYaw : par10) * 4.0F / 360.0F + 0.5D) & 3, 3);
            TileRoadCoverDynamic roadCoverDynamic = (TileRoadCoverDynamic) world.getTileEntity(x, y + 1, z);
            Block block = world.getBlock(x, y, z);
            int blockID = Block.getIdFromBlock(block);
            roadCoverDynamic.setRoadCoverMaterial(blockID);
            roadCoverDynamic.setRoadCoverMetadata(world.getBlockMetadata(x, y, z));

            if (player == null || !player.capabilities.isCreativeMode) {
                --itemstack.stackSize;
            }
            return true;
        }
        return false;
    }
}
