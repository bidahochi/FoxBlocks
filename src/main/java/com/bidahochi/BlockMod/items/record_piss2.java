package com.bidahochi.BlockMod.items;

import com.bidahochi.BlockMod.FoxBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

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
