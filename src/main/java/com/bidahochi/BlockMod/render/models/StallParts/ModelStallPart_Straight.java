//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: StallPart_Straight
// Model Creator: bida
// Created on: 07.07.2024 - 18:11:57
// Last changed on: 07.07.2024 - 18:11:57

package com.bidahochi.BlockMod.render.models.StallParts; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelStallPart_Straight extends ModelConverter //Same as Filename
{
	int textureX = 64;
	int textureY = 32;

	public ModelStallPart_Straight() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[1];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 3, 5, textureX, textureY); // Box 2

		bodyModel[0].addBox(0F, 0F, 0F, 16, 16, 2, 0F); // Box 2
		bodyModel[0].setRotationPoint(-8F, -6F, -1F);
	}
}