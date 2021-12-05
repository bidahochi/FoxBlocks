//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2021 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: 
// Model Creator: Bida
// Created on: 06.08.2021 - 20:09:37
// Last changed on: 06.08.2021 - 20:09:37

package com.bidahochi.BlockMod.render.models; //Path where the model is located


import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelNeonCageLight extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 32;

	public ModelNeonCageLight() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[21];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 20, 1, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 20, 1, textureX, textureY); // Box 2
		bodyModel[2] = new ModelRendererTurbo(this, 1, 15, textureX, textureY); // Box 3
		bodyModel[3] = new ModelRendererTurbo(this, 1, 15, textureX, textureY); // Box 4
		bodyModel[4] = new ModelRendererTurbo(this, 1, 1, textureX, textureY, "lamp"); // Box 6 lamp
		bodyModel[5] = new ModelRendererTurbo(this, 24, 1, textureX, textureY); // Box 8
		bodyModel[6] = new ModelRendererTurbo(this, 1, 1, textureX, textureY, "lamp"); // Box 11 lamp
		bodyModel[7] = new ModelRendererTurbo(this, 1, 1, textureX, textureY, "lamp"); // Box 12 lamp
		bodyModel[8] = new ModelRendererTurbo(this, 24, 1, textureX, textureY); // Box 13
		bodyModel[9] = new ModelRendererTurbo(this, 24, 1, textureX, textureY); // Box 14
		bodyModel[10] = new ModelRendererTurbo(this, 1, 20, textureX, textureY); // Box 15
		bodyModel[11] = new ModelRendererTurbo(this, 1, 20, textureX, textureY); // Box 16
		bodyModel[12] = new ModelRendererTurbo(this, 0, 18, textureX, textureY); // Box 13
		bodyModel[13] = new ModelRendererTurbo(this, 0, 18, textureX, textureY); // Box 14
		bodyModel[14] = new ModelRendererTurbo(this, 1, 13, textureX, textureY); // Box 15
		bodyModel[15] = new ModelRendererTurbo(this, 1, 13, textureX, textureY); // Box 16
		bodyModel[16] = new ModelRendererTurbo(this, 1, 13, textureX, textureY); // Box 17
		bodyModel[17] = new ModelRendererTurbo(this, 25, 21, textureX, textureY); // Box 18
		bodyModel[18] = new ModelRendererTurbo(this, 25, 21, textureX, textureY); // Box 19
		bodyModel[19] = new ModelRendererTurbo(this, 25, 21, textureX, textureY); // Box 20
		bodyModel[20] = new ModelRendererTurbo(this, 25, 21, textureX, textureY); // Box 21

		bodyModel[0].addShapeBox(0F, 0F, 0F, 1, 1, 28, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 1
		bodyModel[0].setRotationPoint(-6F, -5F, -14F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 1, 1, 28, 0F,0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 2
		bodyModel[1].setRotationPoint(5F, -5F, -14F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 10, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 3
		bodyModel[2].setRotationPoint(-5F, -5F, -14F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 10, 1, 1, 0F,0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		bodyModel[3].setRotationPoint(-5F, -5F, 13F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 1, 22, 0F,0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F); // Box 6 lamp
		bodyModel[4].setRotationPoint(2.5F, -4.5F, -11F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 0, 27, 0F,-0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F); // Box 8
		bodyModel[5].setRotationPoint(-3.5F, -4.5F, -13.5F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 1, 22, 0F,0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F); // Box 11 lamp
		bodyModel[6].setRotationPoint(-0.5F, -4.5F, -11F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 1, 22, 0F,0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F, 0.1F, 0.1F, 0F); // Box 12 lamp
		bodyModel[7].setRotationPoint(-3.5F, -4.5F, -11F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 0, 27, 0F,-0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F); // Box 13
		bodyModel[8].setRotationPoint(-0.5F, -4.5F, -13.5F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 0, 27, 0F,-0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F); // Box 14
		bodyModel[9].setRotationPoint(2.5F, -4.5F, -13.5F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 7, 2, 0, 0F,0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
		bodyModel[10].setRotationPoint(-3.5F, -6.5F, -6F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 7, 2, 0, 0F,0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
		bodyModel[11].setRotationPoint(-3.5F, -6.5F, 6F);

		bodyModel[12].addBox(0F, 0F, 0F, 7, 0, 1, 0F); // Box 13
		bodyModel[12].setRotationPoint(-3.5F, -6F, 5.5F);

		bodyModel[13].addBox(0F, 0F, 0F, 7, 0, 1, 0F); // Box 14
		bodyModel[13].setRotationPoint(-3.5F, -6F, -6.5F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 9, 1, 0, 0F,1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
		bodyModel[14].setRotationPoint(-4.5F, -4F, 14F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 9, 1, 0, 0F,1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
		bodyModel[15].setRotationPoint(-4.5F, -4F, -14F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 9, 1, 0, 0F,1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
		bodyModel[16].setRotationPoint(-4.5F, -4F, 0F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 10, 0, 1, 0F,0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F); // Box 18
		bodyModel[17].setRotationPoint(-5F, -4.5F, -3.5F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 10, 0, 1, 0F,0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F); // Box 19
		bodyModel[18].setRotationPoint(-5F, -4.5F, 2.5F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 10, 0, 1, 0F,0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F); // Box 20
		bodyModel[19].setRotationPoint(-5F, -4.5F, 8.5F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 10, 0, 1, 0F,0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F); // Box 21
		bodyModel[20].setRotationPoint(-5F, -4.5F, -9.5F);
	}
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		for (int i = 0; i < 21; i++) {
			if (bodyModel[i].boxName != null && bodyModel[i].boxName.contains("lamp")) {
				Minecraft.getMinecraft().entityRenderer.disableLightmap(1D);
				bodyModel[i].render(f5);
				Minecraft.getMinecraft().entityRenderer.enableLightmap(1D);
			} else if (bodyModel[i].boxName != null && bodyModel[i].boxName.contains("cull")) {
				GL11.glDisable(GL11.GL_CULL_FACE);
				bodyModel[i].render(f5);
				GL11.glEnable(GL11.GL_CULL_FACE);
			} else {
				bodyModel[i].render(f5);
			}
		}
	}
}