//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: hwy_barrier_transR
// Model Creator: bida
// Created on: 08.08.2026 - 20:12:47
// Last changed on: 08.08.2026 - 20:12:47

package com.bidahochi.BlockMod.render.models.Street; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelhwy_barrier_transR extends ModelConverter //Same as Filename
{
	int textureX = 64;
	int textureY = 64;

	public Modelhwy_barrier_transR() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[10];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 2, 16, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 1, 27, textureX, textureY); // Box 2
		bodyModel[2] = new ModelRendererTurbo(this, 1, 4, textureX, textureY); // Box 4
		bodyModel[3] = new ModelRendererTurbo(this, 1, 10, textureX, textureY); // Box 5
		bodyModel[4] = new ModelRendererTurbo(this, 0, 32, textureX, textureY); // Box 1 rp
		bodyModel[5] = new ModelRendererTurbo(this, 27, 27, textureX, textureY); // Box 26
		bodyModel[6] = new ModelRendererTurbo(this, 27, 16, textureX, textureY); // Box 27
		bodyModel[7] = new ModelRendererTurbo(this, 17, 10, textureX, textureY); // Box 29
		bodyModel[8] = new ModelRendererTurbo(this, 16, 2, textureX, textureY); // Box 30
		bodyModel[9] = new ModelRendererTurbo(this, 0, 34, textureX, textureY); // Box 5 rpe

		bodyModel[0].addShapeBox(0F, 0F, 0F, 8, 8, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F); // Box 1
		bodyModel[0].setRotationPoint(0F, 0F, -1F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 8, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F); // Box 2
		bodyModel[1].setRotationPoint(0F, 8F, -1.5F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		bodyModel[2].setRotationPoint(5F, 9F, -2F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 5
		bodyModel[3].setRotationPoint(0F, 9F, -2F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 16, 8, 16, 0F,0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F); // Box 1 rp
		bodyModel[4].setRotationPoint(-8F, 10F, -8F);

		bodyModel[5].addShapeBox(0F, 0F, -1.5F, 12, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F); // Box 26
		bodyModel[5].setRotationPoint(-8F, 8F, 8F);
		bodyModel[5].rotateAngleY = -0.78539816F;

		bodyModel[6].addShapeBox(0F, 0F, -1F, 12, 8, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.05F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F); // Box 27
		bodyModel[6].setRotationPoint(-8F, 0F, 8F);
		bodyModel[6].rotateAngleY = -0.78539816F;

		bodyModel[7].addShapeBox(0F, 0F, -2F, 4, 1, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[7].setRotationPoint(-8F, 9F, 8F);
		bodyModel[7].rotateAngleY = -0.78539816F;

		bodyModel[8].addShapeBox(7F, 0F, -2F, 5, 1, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
		bodyModel[8].setRotationPoint(-8F, 9F, 8F);
		bodyModel[8].rotateAngleY = -0.78539816F;

		bodyModel[9].addBox(-5F, 0F, -5F, 5, 0, 5, 0F); // Box 5 rpe
		bodyModel[9].setRotationPoint(-8F, 9.98F, 13F);
		bodyModel[9].rotateAngleY = 1.57079633F;
	}
}