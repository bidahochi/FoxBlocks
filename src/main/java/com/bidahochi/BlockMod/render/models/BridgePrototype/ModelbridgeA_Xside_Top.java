//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2022 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: BridgeAXsideTop
// Model Creator: Bida
// Created on: 15.02.2022 - 07:51:13
// Last changed on: 15.02.2022 - 07:51:13

package com.bidahochi.BlockMod.render.models.BridgePrototype; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;


public class ModelbridgeA_Xside_Top extends ModelConverter //Same as Filename
{
	int textureX = 256;
	int textureY = 32;

	public ModelbridgeA_Xside_Top() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[3];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 8, textureX, textureY); // Box 41
		bodyModel[1] = new ModelRendererTurbo(this, 1, 16, textureX, textureY); // Box 42
		bodyModel[2] = new ModelRendererTurbo(this, 1, 24, textureX, textureY); // Box 43

		bodyModel[0].addBox(0F, -6F, 0F, 66, 6, 1, 0F); // Box 41
		bodyModel[0].setRotationPoint(-1F, 74F, 7F);
		bodyModel[0].rotateAngleX = -0.12217305F;

		bodyModel[1].addBox(0F, -6F, 0F, 96, 6, 1, 0F); // Box 42
		bodyModel[1].setRotationPoint(-1F, 74F, 6F);
		bodyModel[1].rotateAngleX = -0.12217305F;
		bodyModel[1].rotateAngleY = 0.1134464F;
		bodyModel[1].rotateAngleZ = 0.76794487F;

		bodyModel[2].addBox(0F, -6F, -1F, 96, 6, 1, 0F); // Box 43
		bodyModel[2].setRotationPoint(64F, 74F, 6F);
		bodyModel[2].rotateAngleX = 0.12217305F;
		bodyModel[2].rotateAngleY = 3.01069296F;
		bodyModel[2].rotateAngleZ = 0.76794487F;
	}
}