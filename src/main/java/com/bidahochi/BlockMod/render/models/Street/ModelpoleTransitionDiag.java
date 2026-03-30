//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: pole_transition_diag
// Model Creator: bida
// Created on: 13.03.2026 - 09:00:49
// Last changed on: 13.03.2026 - 09:00:49

package com.bidahochi.BlockMod.render.models.Street; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelpoleTransitionDiag extends ModelConverter //Same as Filename
{
	int textureX = 64;
	int textureY = 32;

	public ModelpoleTransitionDiag() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[4];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);

		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 6, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 10, 6, textureX, textureY); // Box 3
		bodyModel[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 4
		bodyModel[3] = new ModelRendererTurbo(this, 10, 6, textureX, textureY); // Box 6

		bodyModel[0].addBox(-1F, 0F, -1F, 2, 16, 2, 0F); // Box 1
		bodyModel[0].setRotationPoint(0F, -6F, 0F);
		bodyModel[0].rotateAngleY = -0.78539816F;

		bodyModel[1].addBox(1F, 0F, -1F, 23, 2, 2, 0F); // Box 3
		bodyModel[1].setRotationPoint(0F, -6F, 0F);
		bodyModel[1].rotateAngleY = 0.78539816F;

		bodyModel[2].addShapeBox(-20.55F, -12.4F, -1F, 27, 2, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 4
		bodyModel[2].setRotationPoint(0F, -4F, 0F);
		bodyModel[2].rotateAngleY = 0.78539816F;
		bodyModel[2].rotateAngleZ = -2.60054059F;

		bodyModel[3].addShapeBox(24F, 0F, -1F, 10, 2, 2, 0F,0F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, 0F, 0F, 0F); // Box 6
		bodyModel[3].setRotationPoint(0F, -6F, 0F);
		bodyModel[3].rotateAngleY = 0.78539816F;
	}
}