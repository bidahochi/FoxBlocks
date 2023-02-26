package com.bidahochi.BlockMod.blocks.props;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.core.handler.ItemIDs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class DoorA1 extends BlockDoor {
    @SideOnly(Side.CLIENT)
    public IIcon[] iiconA;
    @SideOnly(Side.CLIENT)
    public IIcon[] iiconB;
    public Item doorAitem;

    public DoorA1(Material mat) {
        super(mat);
        setBlockName("doorA");
        setHardness(3F);
        //setResistance(6.5F);
        //setHarvestLevel("axe", 1);
        setStepSound(soundTypeWood);
        setBlockTextureName(FoxBlocks.MODID+":door_a");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister doorIcons)
    {
        this.iiconA = new IIcon[2];
        this.iiconB = new IIcon[2];
        this.iiconA[0] = doorIcons.registerIcon(this.getTextureName() + "_upper");
        this.iiconB[0] = doorIcons.registerIcon(this.getTextureName() + "_lower");
        this.iiconA[1] = new IconFlipped(this.iiconA[0], true, false);
        this.iiconB[1] = new IconFlipped(this.iiconB[0], true, false);
    }

    @Override
    public Item getItemDropped(int itemDropped, Random p_149650_2_, int p_149650_3_)
    {
        return (itemDropped & 8) != 0 ? null : (this.doorAitem);
    }
}
