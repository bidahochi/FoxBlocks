//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: BridgeACenterDiag
// Model Creator: Bida
// Created on: 14.02.2022 - 20:52:14
// Last changed on: 14.02.2022 - 20:52:14

package com.bidahochi.BlockMod.render.models.BridgePrototype; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelbridgeACenterDiag extends ModelConverter //Same as Filename
{
	int textureX = 64;
	int textureY = 128;

	public ModelbridgeACenterDiag() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[2];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 0, 4, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 16, 32, textureX, textureY); // Box 3

		bodyModel[0].addBox(0F, 0F, 0F, 16, 8, 16, 0F); // Box 1
		bodyModel[0].setRotationPoint(-8F, -6F, -8F);

		bodyModel[1].addBox(-4F, 0F, -4F, 8, 72, 8, 0F); // Box 3
		bodyModel[1].setRotationPoint(0F, 2F, 0F);
		bodyModel[1].rotateAngleY = 0.78539816F;
	}
}