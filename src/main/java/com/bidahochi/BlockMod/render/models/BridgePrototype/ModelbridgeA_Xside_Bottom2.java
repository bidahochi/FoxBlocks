//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2022 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: BridgeAXsideBottom2
// Model Creator: Bida
// Created on: 15.02.2022 - 07:51:13
// Last changed on: 15.02.2022 - 07:51:13

package com.bidahochi.BlockMod.render.models.BridgePrototype; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelbridgeA_Xside_Bottom2 extends ModelConverter //Same as Filename
{
	int textureX = 256;
	int textureY = 32;

	public ModelbridgeA_Xside_Bottom2() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[3];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 8, textureX, textureY); // Box 44
		bodyModel[1] = new ModelRendererTurbo(this, 1, 24, textureX, textureY); // Box 69
		bodyModel[2] = new ModelRendererTurbo(this, 1, 16, textureX, textureY); // Box 70

		bodyModel[0].addBox(0F, -6F, 0F, 97, 6, 1, 0F); // Box 44
		bodyModel[0].setRotationPoint(-1F, 76F, -1F);
		bodyModel[0].rotateAngleX = -0.12217305F;

		bodyModel[1].addBox(0F, -6F, -1F, 120, 6, 1, 0F); // Box 69
		bodyModel[1].setRotationPoint(96F, 76F, -2.5F);
		bodyModel[1].rotateAngleX = 0.12217305F;
		bodyModel[1].rotateAngleY = 3.05432619F;
		bodyModel[1].rotateAngleZ = 0.5846853F;

		bodyModel[2].addBox(0F, -6F, 0F, 120, 6, 1, 0F); // Box 70
		bodyModel[2].setRotationPoint(-1F, 76F, -2.5F);
		bodyModel[2].rotateAngleX = -0.12217305F;
		bodyModel[2].rotateAngleY = 0.07853982F;
		bodyModel[2].rotateAngleZ = 0.5846853F;
	}
}