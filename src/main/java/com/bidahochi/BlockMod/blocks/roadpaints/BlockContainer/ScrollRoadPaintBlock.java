package com.bidahochi.BlockMod.blocks.roadpaints.BlockContainer;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.roadpaints.EnumRoadShapes;
import com.bidahochi.BlockMod.blocks.roadpaints.TileEntity.TileRPB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.*;

import static com.bidahochi.BlockMod.utils.HelperUtils.getValueByIndex;

public abstract class ScrollRoadPaintBlock extends BlockContainer implements IScrollRoadPaintBlock
{
    public String offset;
    public String color;
    //public HashMap<EnumRoadShapes, IIcon> icons = new HashMap<>();
    private IIcon[] textures;
    public LinkedHashMap<EnumRoadShapes, String> shapeTextures = new LinkedHashMap<>();
    public EnumRoadShapes currentShape = EnumRoadShapes.straight;

    public ScrollRoadPaintBlock(Material p_i45394_1_) {
        super(p_i45394_1_);
        setHardness(2F);
        setResistance(4.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeStone);
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabRoadRail);
    }

    public void SetCurrentShape(EnumRoadShapes enumRoadShape)
    {
        currentShape = enumRoadShape;
    }

    public LinkedHashMap<EnumRoadShapes, String> getShapeTextures()
    {
        return shapeTextures;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileRPB();
    }

    @Override
    public boolean canCollideCheck(int p_149678_1_, boolean p_149678_2_) {
        return true;
    }

    @Override //entity collision, this doesn't need changing, but needs inclusion
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox((double) x + this.minX, (double) y + this.minY, (double) z + this.minZ, (double) x + this.maxX, (double) y + this.maxY, (double) z + this.maxZ);
    }

    @Override //actual collision stuff you change
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.1F, 1F);
    }

    @Override
    public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {

    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        super.onBlockPlacedBy(world, x, y, z, entity, stack);
        if (shapeTextures.isEmpty()) {
            world.setTileEntity(x, y, z, new TileRPB(getDir(entity), color, "straight", offset, stack));
        }
        else {
            int dir = getDir(entity);
            String shape = getValueByIndex(shapeTextures, stack.getItemDamage());
            EnumRoadShapes s = currentShape==null? EnumRoadShapes.straight:currentShape;
            if (entity.isSneaking()) {
                switch (s) {
                    case turn:
                    case diagonal:
                    case yIntersection:
                        dir = (dir + 1) % 4;
                        break;
                }
            }
            world.setTileEntity(x, y, z, new TileRPB(dir, color, shape, offset, stack));
        }
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta > textures.length) meta = 0;
        return textures[meta];

        //Below is a potential stopgap until the icon issue can be resolved. commented out for now.
/*        if (currentShape != null) {
            for (IIcon texture : textures) {
                if (texture.getIconName().contains(currentShape.type)) {
                    return texture;
                }
            }
        }
        for (IIcon texture : textures) {
            if (texture.getIconName().contains("straight")) {
                return texture;
            }
        }
        return textures[meta];
        */
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.textures = new IIcon[shapeTextures.size()];
        for (int i = 0; i < shapeTextures.size(); i++)
        {
            String s = FoxBlocks.MODID + ":roadpaints/rp_icon/" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1) + "/" + shapeTextures.keySet().toArray()[i];
            this.textures[i] = iconRegister.registerIcon(s);
        }
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < this.shapeTextures.size(); i++){
            list.add(new ItemStack(item, 1, i));
        }
        //ScrollRoadPaintBlock.getBlockFromItem(((ItemStack)list.get(0)).getItem()).setCreativeTab(FoxBlocks.foxBlocksCreativeTabRoadRail);
    }

    @Override
    public int damageDropped(int metadata) {
        return metadata;
    }

    // Helper to get the Direction
    protected int getDir(EntityLivingBase entity) {
        return MathHelper.floor_double((entity.rotationYaw / 90.0F) + 2.5D) & 3;
    }
}
