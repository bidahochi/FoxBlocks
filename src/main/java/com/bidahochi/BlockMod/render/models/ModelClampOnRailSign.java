//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2021 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: ClampOnSign
// Model Creator: Bida
// Created on: 06.08.2021 - 20:09:37
// Last changed on: 06.08.2021 - 20:09:37

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelClampOnRailSign extends ModelConverter //Same as Filename
{
	int textureX = 64;
	int textureY = 64;

	public ModelClampOnRailSign() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[9];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
		//fixRotation(bodyModel);
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 15, 23, textureX, textureY); // Box 2 sign horizontal
		bodyModel[1] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 5
		bodyModel[2] = new ModelRendererTurbo(this, 1, 7, textureX, textureY); // Box 6
		bodyModel[3] = new ModelRendererTurbo(this, 6, 7, textureX, textureY); // Box 7
		bodyModel[4] = new ModelRendererTurbo(this, 5, 5, textureX, textureY); // Box 8
		bodyModel[5] = new ModelRendererTurbo(this, 1, 19, textureX, textureY); // Box 9
		bodyModel[6] = new ModelRendererTurbo(this, 6, -3, textureX, textureY); // Box 10
		bodyModel[7] = new ModelRendererTurbo(this, 6, 2, textureX, textureY); // Box 11
		bodyModel[8] = new ModelRendererTurbo(this, 31, 6, textureX, textureY); // Box 12 sign vertical

		bodyModel[0].addShapeBox(0F, 0F, 0F, 0, 16, 24, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -18F, 0F, 0F, -18F, 0F, -12F, 0F, 0F, -12F, 0F, 0F, -12F, -18F, 0F, -12F, -18F); // Box 2 sign horizontal
		bodyModel[0].setRotationPoint(0.19F, -6F, -3F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 5
		bodyModel[1].setRotationPoint(0F, -5F, -0.5F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -5.2F, -0.2F, 0F, -5.2F, -0.2F, 0F, 4.8F, -0.2F, 0F, 4.8F); // Box 6
		bodyModel[2].setRotationPoint(0F, -1F, -0.5F);

		bodyModel[3].addBox(0F, 0F, 0F, 3, 1, 0, 0F); // Box 7
		bodyModel[3].setRotationPoint(-1F, 9F, 5.5F);

		bodyModel[4].addBox(0F, 0F, 0F, 3, 0, 1, 0F); // Box 8
		bodyModel[4].setRotationPoint(-1F, 9F, 5.5F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 9
		bodyModel[5].setRotationPoint(0F, 9F, 4.5F);

		bodyModel[6].addShapeBox(0F, -0.5F, 0F, 0, 1, 4, 0F,0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 10
		bodyModel[6].setRotationPoint(0.2F, 7F, 4F);
		bodyModel[6].rotateAngleX = -0.43633231F;

		bodyModel[7].addShapeBox(0F, 0.5F, 3F, 0, 1, 1, 0F,0F, 0.2F, -0.4F, 0F, 0.2F, -0.4F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
		bodyModel[7].setRotationPoint(0.2F, 7F, 4F);
		bodyModel[7].rotateAngleX = -0.43633231F;

		bodyModel[8].addShapeBox(0F, -18F, 1F, 0, 24, 16, 0F,0F, -18F, 0F, 0F, -18F, 0F, 0F, -18F, -12F, 0F, -18F, -12F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -12F, 0F, 0F, -12F); // Box 12 sign vertical
		bodyModel[8].setRotationPoint(0.19F, -7F, -3F);
	}
}