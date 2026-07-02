//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: clearancecone1
// Model Creator: bida
// Created on: 02.07.2026 - 07:16:41
// Last changed on: 02.07.2026 - 07:16:41

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelclearancecone1 extends ModelConverter //Same as Filename
{
	int textureX = 32;
	int textureY = 32;

	public Modelclearancecone1() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[2];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);

		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 2, 9, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 2, 2, textureX, textureY); // Box 2

		bodyModel[0].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0.25F, -0.75F, -0.25F, 0.25F, -0.75F, -0.25F, 0.25F, -0.75F, -0.25F, 0.25F, -0.75F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0.25F, 0F, -0.25F); // Box 1
		bodyModel[0].setRotationPoint(-1F, 9F, -1F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F,-0.4F, -0.25F, -0.4F, -0.4F, -0.25F, -0.4F, -0.4F, -0.25F, -0.4F, -0.4F, -0.25F, -0.4F, -0.4F, -0.25F, -0.4F, -0.4F, -0.25F, -0.4F, -0.4F, -0.25F, -0.4F, -0.4F, -0.25F, -0.4F); // Box 2
		bodyModel[1].setRotationPoint(-1F, 8F, -1F);
	}
}