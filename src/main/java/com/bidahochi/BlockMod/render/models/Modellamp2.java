//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2025 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: 
// Model Creator: 
// Created on: 12.05.2025 - 11:09:44
// Last changed on: 12.05.2025 - 11:09:44

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class Modellamp2 extends ModelConverter //Same as Filename
{
	int textureX = 32;
	int textureY = 32;

	public Modellamp2() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[6];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 12, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 19, 12, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 19, 17, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 10, 12, textureX, textureY, "lamp"); // Box 4 lamp
		bodyModel[4] = new ModelRendererTurbo(this, 0, 9, textureX, textureY, "lamp"); // Box 5 lamp
		bodyModel[5] = new ModelRendererTurbo(this, 0, 6, textureX, textureY, "lamp"); // Box 6 lamp

		bodyModel[0].addBox(0F, 0F, 0F, 1, 16, 3, 0F); // Box 0
		bodyModel[0].setRotationPoint(-8F, -5F, -1.5F);
		bodyModel[0].rotateAngleZ = 1.57079633F;

		bodyModel[1].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, 0F, 0.5F, 0F); // Box 1
		bodyModel[1].setRotationPoint(-8F, -5F, -1.5F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.5F, 0.5F, 0F); // Box 2
		bodyModel[2].setRotationPoint(7F, -5F, -1.5F);

		bodyModel[3].addShapeBox(-1F, 0F, 0F, 1, 15, 3, 0F,-0.25F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, -0.25F, 0F, -0.125F, -0.25F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, -0.25F, 0F, -0.125F); // Box 4 lamp
		bodyModel[3].setRotationPoint(-7.5F, -5F, -1.5F);
		bodyModel[3].rotateAngleZ = 1.57079633F;

		bodyModel[4].addShapeBox(0F, 0F, 0F, 15, 1, 1, 0F,0F, -0.25F, 0.125F, 0F, -0.25F, 0.125F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.125F, 0F, -0.25F, -0.125F); // Box 5 lamp
		bodyModel[4].setRotationPoint(-7.5F, -4.5F, -1.25F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 15, 1, 1, 0F,0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.125F, 0F, -0.25F, 0.125F, 0F, -0.25F, -0.125F, 0F, -0.25F, -0.125F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F); // Box 6 lamp
		bodyModel[5].setRotationPoint(-7.5F, -4.5F, 0.25F);
	}
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		for (int i = 0; i < 6; i++) {
			if (bodyModel[i].boxName != null && bodyModel[i].boxName.contains("lamp")) {
				Minecraft.getMinecraft().entityRenderer.disableLightmap(1D);
				bodyModel[i].render(f5);
				Minecraft.getMinecraft().entityRenderer.enableLightmap(1D);

			} else {
				bodyModel[i].render(f5);
			}
		}
	}
}