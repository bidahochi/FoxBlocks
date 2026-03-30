//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: pole_transition
// Model Creator: bida
// Created on: 13.03.2026 - 09:00:49
// Last changed on: 13.03.2026 - 09:00:49
package com.bidahochi.BlockMod.render.models.Street; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelpoleTransition extends ModelConverter//Same as Filename
{
	int textureX = 64;
	int textureY = 32;

	public ModelpoleTransition() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[3];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);

		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 6, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 10, 6, textureX, textureY); // Box 3
		bodyModel[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 4

		bodyModel[0].addBox(0F, 0F, 0F, 2, 16, 2, 0F); // Box 1
		bodyModel[0].setRotationPoint(-1F, -6F, -1F);

		bodyModel[1].addBox(0F, 0F, -2F, 23, 2, 2, 0F); // Box 3
		bodyModel[1].setRotationPoint(-1F, -6F, 1F);
		bodyModel[1].rotateAngleY = 1.57079633F;

		bodyModel[2].addShapeBox(0F, 0F, -2F, 27, 2, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 4
		bodyModel[2].setRotationPoint(-1F, -4F, 24F);
		bodyModel[2].rotateAngleY = 1.57079633F;
		bodyModel[2].rotateAngleZ = -2.60054059F;
	}
}