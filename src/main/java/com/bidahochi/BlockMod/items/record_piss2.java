package com.bidahochi.BlockMod.items;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.MusicDiscs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockJukebox;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class record_piss2 extends ItemRecord {
    public record_piss2(String par0Str) {
        super(par0Str);
        setMaxStackSize(1);
        setUnlocalizedName("record_piss2");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabItems);
    }
/*public class record_piss2 extends ItemRecord
{
    private static final Map records = new HashMap();


    public final String recordName;


    public record_piss2(String recordName)
    {
        super(recordName);

        this.recordName = recordName;
        this.maxStackSize = 1;
        //setCreativeTab(FoxBlocks.foxBlocksCreativeTabItems);

        records.put(recordName, this);
    }*/


    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(FoxBlocks.MODID.toLowerCase() + ":record_piss");
    }

    /*@Override
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation("FoxBlocks:" + name);
    }*/

    @Override
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(FoxBlocks.MODID + ":" + name);
    }
}
