//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: POLE
// Model Creator: 
// Created on: 05.07.2020 - 22:04:54
// Last changed on: 05.07.2020 - 22:04:54

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelPOLE extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 128;

	public ModelPOLE() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[7];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 22, 49, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 4
		bodyModel[5] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 5
		bodyModel[6] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 29

		bodyModel[0].addBox(0F, 0F, 0F, 4, 81, 4, 0F); // Box 0
		bodyModel[0].setRotationPoint(-2F, -71F, 14.5F);

		bodyModel[1].addBox(0F, 0F, 0F, 2, 2, 38, 0F); // Box 1
		bodyModel[1].setRotationPoint(-1F, -42F, -23.5F);

		bodyModel[2].addBox(0F, 0F, 0F, 1, 0, 34, 0F); // Box 2
		bodyModel[2].setRotationPoint(-0.5F, -42F, -14.5F);
		bodyModel[2].rotateAngleX = 0.4712389F;

		bodyModel[3].addBox(0F, 0F, 0F, 1, 0, 2, 0F); // Box 3
		bodyModel[3].setRotationPoint(-0.5F, -57F, 18.5F);

		bodyModel[4].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 4
		bodyModel[4].setRotationPoint(-0.5F, -57.5F, 18.5F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 5
		bodyModel[5].setRotationPoint(-1F, -43F, -17F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[6].setRotationPoint(-0.5F, -43F, -16.5F);
	}
}