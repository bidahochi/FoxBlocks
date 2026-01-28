//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2022 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: BridgeASideBottom
// Model Creator: Bida
// Created on: 14.02.2022 - 21:02:24
// Last changed on: 14.02.2022 - 21:02:24

package com.bidahochi.BlockMod.render.models.BridgePrototype; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;


public class ModelbridgeASide_Bottom extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 128;

	public ModelbridgeASide_Bottom() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[2];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 16, 24, textureX, textureY); // Box 18
		bodyModel[1] = new ModelRendererTurbo(this, 26, 90, textureX, textureY); // Box 21

		bodyModel[0].addShapeBox(0F, 0F, 0F, 8, 80, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 8F, 0F, 0F, 8F); // Box 18
		bodyModel[0].setRotationPoint(-4F, -6F, 0F);

		bodyModel[1].addBox(0F, 0F, 0F, 16, 8, 24, 0F); // Box 21
		bodyModel[1].setRotationPoint(-8F, -6F, -8F);
	}
}