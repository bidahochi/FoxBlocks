package com.bidahochi.BlockMod.blocks.props;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.render.models.ModelPropTrailerDryvan;
import com.bidahochi.BlockMod.render.tmt.Tessellator;
import com.bidahochi.BlockMod.utils.FBMultiPartHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
    public class RenderPropTrailerDryvan1 extends TileEntitySpecialRenderer {
        private ResourceLocation texture2 = new ResourceLocation(FoxBlocks.MODID, "textures/blocks/props/53ft_dryvan_2.png");
        private ModelPropTrailerDryvan model = new ModelPropTrailerDryvan();

        @Override
        public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
            if(!(tileEntity instanceof TilePropTrailerDryvan1)){return;}
            GL11.glPushMatrix();
            Tessellator.bindTexture(texture2);
            GL11.glTranslated(x + 0.5, y + 0.625, z + 0.5);
            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glRotatef(90F, 0F, 1F, 0F);
            int dir = ((TilePropTrailerDryvan1)tileEntity).dir;
            switch(dir) {
                case 0:{//west // north
                    GL11.glRotated(180,0,1,0);
                    break;
                }
                case 3: {//south? //west
                    GL11.glRotated(90,0,1,0);
                    break;
                }
                case 1: {//north //east
                    GL11.glRotated(270,0,1,0);
                    break;
                }
                case 2: {//east //south
                    GL11.glRotated(180,0,1,0);
                    GL11.glRotated(180,0,1,0);
                    break;
                }
            }
            Block block = tileEntity.getWorldObj().getBlock(tileEntity.xCoord,tileEntity.yCoord-1,tileEntity.zCoord);
            if((block instanceof BlockSlab || FoxBlocks.isForgeMultiPartLoaded && FBMultiPartHelper.BlockInstanceOfBlockMultipart(block)) && !block.isNormalCube())
            {
                GL11.glTranslatef(0, 0.5f, 0);
            }
            model.render(null, 0, 0, 0, 0, 0, 0.0625f);
            GL11.glPopMatrix();
        }
    }