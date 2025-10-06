package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

public class ConfigHandler
{
    /**
     * When enabled this removes certain blocks/items that may be a little too much
     * for younger audiences
     */
    public static Boolean SanitizeMod;

    public static void init(File configFile)
    {
        Configuration cf = new Configuration(configFile);
        try
        {
            cf.load();
            SanitizeMod = cf.get(CATEGORY_GENERAL, "SanitizeMod", false).getBoolean(false);
        }
        catch (Exception e)
        {
            FoxBlocks.blockLogger.fatal("Foxblocks had a problem loadings it config\n" + e);
        } finally {
            if(cf.hasChanged()) {
                cf.save();
            }
        }
    }
}
