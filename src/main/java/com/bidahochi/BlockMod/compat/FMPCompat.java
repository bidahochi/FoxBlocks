package com.bidahochi.BlockMod.compat;

import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.TMultiPart;
import codechicken.multipart.MultiPartRegistry.IPartConverter;
import codechicken.multipart.MultiPartRegistry.IPartFactory;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import com.bidahochi.BlockMod.core.handler.BlockIDs;

public class FMPCompat implements IPartFactory, IPartConverter {
    public FMPCompat() {
    }

    public void init() {
        MultiPartRegistry.registerConverter(this);
    }

    public Iterable<Block> blockTypes() {
        return null;
    }

    public TMultiPart convert(World world, Object pos) {
        return null;
    }



    public TMultiPart createPart(String name, boolean client) {
        return null;
    }
}