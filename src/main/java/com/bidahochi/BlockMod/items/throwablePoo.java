package com.bidahochi.BlockMod.items;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.entity.EntityPoo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionAbsoption;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.item.ItemFood;



public class throwablePoo extends ItemFood {
    private PotionEffect poopotion = new PotionEffect(19,300,1,false);
    private PotionEffect poopotioneaten = new PotionEffect(9,300,1,false);


    public throwablePoo(){
        super(1,1,true);


        this.setCreativeTab(FoxBlocks.foxBlocksCreativeTabItems);
        this.setAlwaysEdible();


    }
    /*
    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        p_77659_3_.addPotionEffect(poopotion);
        --p_77659_1_.stackSize;

        // //p_77659_3_.canEat(this.alwaysEdible)// true inside the iff statement before

        if (true)
        {
            p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        }

        return p_77659_1_;
    }

     */



    @Override
    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        --p_77654_1_.stackSize;
        p_77654_3_.getFoodStats().func_151686_a(this, p_77654_1_);
        p_77654_2_.playSoundAtEntity(p_77654_3_, "random.burp", 0.5F, p_77654_2_.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(p_77654_1_, p_77654_2_, p_77654_3_);
        return p_77654_1_;
    }
    @Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        p_77648_2_.addPotionEffect(poopotion);
        --p_77648_1_.stackSize;
        return false;
    }

    protected void onFoodEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
        --p_77654_1_.stackSize;
        p_77654_3_.addPotionEffect(poopotion);
        p_77654_3_.addPotionEffect(poopotioneaten);
    }

}
