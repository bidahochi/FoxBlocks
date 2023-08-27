//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2023 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: 
// Model Creator: bida
// Created on: 08.01.2022 - 20:59:29
// Last changed on: 08.01.2022 - 20:59:29

package com.bidahochi.BlockMod.render.models; //Path where the model is located


import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class Modelexterior_light_square extends ModelConverter//Same as Filename
{
	int textureX = 32;
	int textureY = 32;

	public Modelexterior_light_square() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[3];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 15, 7, textureX, textureY); // Box 2
		bodyModel[2] = new ModelRendererTurbo(this, 2, 7, textureX, textureY, "lamp"); // Box 3 lamp part

		bodyModel[0].addBox(0F, 0F, 0F, 3, 1, 4, 0F); // Box 1
		bodyModel[0].setRotationPoint(5F, 0F, -2F);

		bodyModel[1].addBox(0F, 0F, 0F, 1, 3, 4, 0F); // Box 2
		bodyModel[1].setRotationPoint(7F, 1F, -2F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 2, 3, 4, 0F,-0.125F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F); // Box 3 lamp part
		bodyModel[2].setRotationPoint(5F, 1F, -2F);
	}
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		for (int i = 0; i < 3; i++) {
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