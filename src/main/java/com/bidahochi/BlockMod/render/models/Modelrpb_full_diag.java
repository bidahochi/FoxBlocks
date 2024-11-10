//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: rpb_full_diag
// Model Creator: 
// Created on: 23.07.2024 - 11:46:32
// Last changed on: 23.07.2024 - 11:46:32

package com.bidahochi.BlockMod.render.models; //Path where the model is located


import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelrpb_full_diag extends ModelConverter //Same as Filename
{
	int textureX = 64;
	int textureY = 32;

	public Modelrpb_full_diag() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[5];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 8, 12, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 8, 12, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 5

		bodyModel[0].addShapeBox(0F, 0F, 0F, 16, 16, 16, 0F,0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F); // Box 1
		bodyModel[0].setRotationPoint(-8F, 10F, -8F);

		bodyModel[1].addBox(0F, 0F, 0F, 2, 0, 2, 0F); // Box 1
		bodyModel[1].setRotationPoint(-9F, 9.98F, -9F);

		bodyModel[2].addBox(0F, 0F, 0F, 2, 0, 2, 0F); // Box 2
		bodyModel[2].setRotationPoint(7F, 9.98F, 7F);

		bodyModel[3].addBox(0F, 0F, 0F, 4, 0, 4, 0F); // Box 3
		bodyModel[3].setRotationPoint(6F, 9.98F, 6F);

		bodyModel[4].addBox(0F, 0F, 0F, 4, 0, 4, 0F); // Box 5
		bodyModel[4].setRotationPoint(-10F, 9.98F, -10F);
	}
}