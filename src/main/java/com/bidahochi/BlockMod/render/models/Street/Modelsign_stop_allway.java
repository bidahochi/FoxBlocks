//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: sign_stop_block
// Model Creator: bida
// Created on: 13.03.2026 - 09:06:08
// Last changed on: 13.03.2026 - 09:06:08

package com.bidahochi.BlockMod.render.models.Street; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelsign_stop_allway extends ModelConverter //Same as Filename
{
	int textureX = 64;
	int textureY = 32;

	public Modelsign_stop_allway() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[7];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 50, -4, textureX, textureY); // Box 21
		bodyModel[1] = new ModelRendererTurbo(this, 50, -4, textureX, textureY); // Box 22
		bodyModel[2] = new ModelRendererTurbo(this, 50, -4, textureX, textureY); // Box 23
		bodyModel[3] = new ModelRendererTurbo(this, 50, -4, textureX, textureY); // Box 24
		bodyModel[4] = new ModelRendererTurbo(this, 1, -23, textureX, textureY); // Box 25
		bodyModel[5] = new ModelRendererTurbo(this, 1, 10, textureX, textureY); // Box 5 all way
		bodyModel[6] = new ModelRendererTurbo(this, 34, 18, textureX, textureY); // Box 6

		bodyModel[0].addShapeBox(0F, 0F, 0F, 0, 24, 5, 0F,0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F); // Box 21
		bodyModel[0].setRotationPoint(7.99F, -8F, -2.5F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 0, 24, 5, 0F,0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F); // Box 22
		bodyModel[1].setRotationPoint(7.99F, -8F, 2.5F);
		bodyModel[1].rotateAngleX = -0.78539816F;

		bodyModel[2].addShapeBox(0F, 0F, 0F, 0, 24, 5, 0F,0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F); // Box 23
		bodyModel[2].setRotationPoint(7.99F, -4.5F, 6F);
		bodyModel[2].rotateAngleX = -1.57079633F;

		bodyModel[3].addShapeBox(0F, 0F, 0F, 0, 24, 5, 0F,0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, 0F); // Box 24
		bodyModel[3].setRotationPoint(7.99F, 0.5F, 6F);
		bodyModel[3].rotateAngleX = -2.35619449F;

		bodyModel[4].addShapeBox(0F, 0F, 0F, 0, 24, 24, 0F,0F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, -12F, 0F, 0F, -12F, 0F, -12F, 0F, 0.01F, -12F, 0F, 0.01F, -12F, -12F, 0F, -12F, -12F); // Box 25
		bodyModel[4].setRotationPoint(7.99F, -8F, -6F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 0, 4, 16, 0F,0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, -8F, 0.01F, 0F, -8F, 0.01F, -2F, 0F, 0.01F, -2F, 0F, 0.01F, -2F, -8F, 0.01F, -2F, -8F); // Box 5 all way
		bodyModel[5].setRotationPoint(8F, 4.5F, -4F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 0, 2, 8, 0F,0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F); // Box 6
		bodyModel[6].setRotationPoint(8F, 4.5F, -4F);
	}
}