//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: pole_horizontal
// Model Creator: bida
// Created on: 13.03.2026 - 09:15:09
// Last changed on: 13.03.2026 - 09:15:09

package com.bidahochi.BlockMod.render.models.Street; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelpoleHorizontal extends ModelConverter//Same as Filename
{
	int textureX = 64;
	int textureY = 32;

	public ModelpoleHorizontal() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[1];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);

		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 10, 11, textureX, textureY); // Box 5

		bodyModel[0].addBox(0F, 0F, -2F, 16, 2, 2, 0F); // Box 5
		bodyModel[0].setRotationPoint(-1F, -6F, -8F);
		bodyModel[0].rotateAngleY = 1.57079633F;
	}
}