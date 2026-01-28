//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: BridgeAXsideTopDiag
// Model Creator: Bida
// Created on: 15.02.2022 - 07:51:13
// Last changed on: 15.02.2022 - 07:51:13

package com.bidahochi.BlockMod.render.models.BridgePrototype; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelbridgeA_Xside_TopDiag extends ModelConverter //Same as Filename
{
	int textureX = 256;
	int textureY = 32;

	public ModelbridgeA_Xside_TopDiag() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[4];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 8, textureX, textureY); // Box 142
		bodyModel[1] = new ModelRendererTurbo(this, 1, 16, textureX, textureY); // Box 143
		bodyModel[2] = new ModelRendererTurbo(this, 1, 24, textureX, textureY); // Box 144
		bodyModel[3] = new ModelRendererTurbo(this, 1, 8, textureX, textureY); // Box 146

		bodyModel[0].addBox(0F, -6F, 0.5F, 66, 6, 1, 0F); // Box 142
		bodyModel[0].setRotationPoint(8F, 74F, -7F);
		bodyModel[0].rotateAngleX = -0.12217305F;
		bodyModel[0].rotateAngleY = 0.78539816F;

		bodyModel[1].addBox(0F, -6F, 0.5F, 96, 6, 1, 0F); // Box 143
		bodyModel[1].setRotationPoint(8F, 74F, -8F);
		bodyModel[1].rotateAngleX = -0.12217305F;
		bodyModel[1].rotateAngleY = 0.89011792F;
		bodyModel[1].rotateAngleZ = 0.76794487F;

		bodyModel[2].addBox(0F, -6F, -1.5F, 96, 6, 1, 0F); // Box 144
		bodyModel[2].setRotationPoint(55F, 74F, 39F);
		bodyModel[2].rotateAngleX = 0.12217305F;
		bodyModel[2].rotateAngleY = 3.81354442F;
		bodyModel[2].rotateAngleZ = 0.76794487F;

		bodyModel[3].addBox(0F, -72F, 0.5F, 66, 6, 1, 0F); // Box 146
		bodyModel[3].setRotationPoint(8F, 74F, -7F);
		bodyModel[3].rotateAngleX = -0.12217305F;
		bodyModel[3].rotateAngleY = 0.78539816F;
	}
}