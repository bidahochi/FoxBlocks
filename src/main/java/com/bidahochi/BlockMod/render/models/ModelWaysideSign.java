//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2023 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: 
// Model Creator: 
// Created on: 04.12.2021 - 22:59:57
// Last changed on: 04.12.2021 - 22:59:57

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelWaysideSign extends ModelConverter //Same as Filename
{
	int textureX = 32;
	int textureY = 32;

	public ModelWaysideSign() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[5];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 18, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 1, -7, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 1, 12, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 6, 12, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 9, 13, textureX, textureY); // Box 4

		bodyModel[0].addBox(0F, 0F, 0F, 1, 15, 1, 0F); // Box 0
		bodyModel[0].setRotationPoint(-0.5F, -6.98F, -0.5F);

		bodyModel[1].addBox(0F, 0F, 0F, 0, 10, 8, 0F); // Box 1
		bodyModel[1].setRotationPoint(-0.51F, -6.48F, -4F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 2
		bodyModel[2].setRotationPoint(-0.5F, 8F, 0.5F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		bodyModel[3].setRotationPoint(-0.5F, 8F, -1.5F);

		bodyModel[4].addBox(0F, 0F, 0F, 1, 0, 2, 0F); // Box 4
		bodyModel[4].setRotationPoint(-0.5F, 7.99F, -1F);
	}
}