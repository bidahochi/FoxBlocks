//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: BridgeAXsideBottomDiag
// Model Creator: Bida
// Created on: 15.02.2022 - 07:51:13
// Last changed on: 15.02.2022 - 07:51:13

package com.bidahochi.BlockMod.render.models.BridgePrototype; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelbridgeA_Xside_BottomDiag extends ModelConverter //Same as Filename
{
	int textureX = 256;
	int textureY = 32;

	public ModelbridgeA_Xside_BottomDiag() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[4];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 8, textureX, textureY); // Box 153
		bodyModel[1] = new ModelRendererTurbo(this, 1, 24, textureX, textureY); // Box 154
		bodyModel[2] = new ModelRendererTurbo(this, 1, 16, textureX, textureY); // Box 155
		bodyModel[3] = new ModelRendererTurbo(this, 1, 8, textureX, textureY); // Box 156

		bodyModel[0].addBox(0F, -72F, 1F, 66, 6, 1, 0F); // Box 153
		bodyModel[0].setRotationPoint(14F, 74F, -13F);
		bodyModel[0].rotateAngleX = -0.12217305F;
		bodyModel[0].rotateAngleY = 0.78539816F;

		bodyModel[1].addBox(0F, -6F, -2F, 96, 6, 1, 0F); // Box 154
		bodyModel[1].setRotationPoint(61F, 74F, 33F);
		bodyModel[1].rotateAngleX = 0.12217305F;
		bodyModel[1].rotateAngleY = 3.81354442F;
		bodyModel[1].rotateAngleZ = 0.76794487F;

		bodyModel[2].addBox(0F, -6F, 1F, 96, 6, 1, 0F); // Box 155
		bodyModel[2].setRotationPoint(14F, 74F, -14F);
		bodyModel[2].rotateAngleX = -0.12217305F;
		bodyModel[2].rotateAngleY = 0.88139127F;
		bodyModel[2].rotateAngleZ = 0.76794487F;

		bodyModel[3].addBox(0F, -6F, 1F, 66, 6, 1, 0F); // Box 156
		bodyModel[3].setRotationPoint(14F, 74F, -13F);
		bodyModel[3].rotateAngleX = -0.12217305F;
		bodyModel[3].rotateAngleY = 0.78539816F;
	}
}