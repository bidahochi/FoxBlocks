//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: hwy_barrier
// Model Creator: bida
// Created on: 08.08.2026 - 10:54:52
// Last changed on: 08.08.2026 - 10:54:52

package com.bidahochi.BlockMod.render.models.Street; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelhwy_barrier extends ModelConverter //Same as Filename
{
	int textureX = 64;
	int textureY = 64;

	public Modelhwy_barrier() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[6];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 2, 16, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 1, 27, textureX, textureY); // Box 2
		bodyModel[2] = new ModelRendererTurbo(this, 11, 2, textureX, textureY); // Box 3
		bodyModel[3] = new ModelRendererTurbo(this, 0, 4, textureX, textureY); // Box 4
		bodyModel[4] = new ModelRendererTurbo(this, 1, 10, textureX, textureY); // Box 5
		bodyModel[5] = new ModelRendererTurbo(this, 0, 32, textureX, textureY); // Box 1 rp

		bodyModel[0].addShapeBox(0F, 0F, 0F, 16, 8, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F); // Box 1
		bodyModel[0].setRotationPoint(-8F, 0F, -1F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 16, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F); // Box 2
		bodyModel[1].setRotationPoint(-8F, 8F, -1.5F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		bodyModel[2].setRotationPoint(-8F, 9F, -2F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		bodyModel[3].setRotationPoint(5F, 9F, -2F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 6, 1, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 5
		bodyModel[4].setRotationPoint(-3F, 9F, -2F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 16, 8, 16, 0F,0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F); // Box 1 rp
		bodyModel[5].setRotationPoint(-8F, 10F, -8F);
	}
}