//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2023 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: cover
// Model Creator: 
// Created on: 26.02.2023 - 11:48:29
// Last changed on: 26.02.2023 - 11:48:29

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;


public class ModelRoadCover extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 32;

	public ModelRoadCover() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[1];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 6, 6, textureX, textureY); // Box 0

		bodyModel[0].addBox(0F, 0F, 0F, 32, 1, 16, 0F); // Box 0
		bodyModel[0].setRotationPoint(-8F, 9F, -8F);
	}
}