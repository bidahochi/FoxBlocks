//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: 3_long_simp
// Model Creator: 
// Created on: 04.11.2020 - 22:42:51
// Last changed on: 04.11.2020 - 22:42:51

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelnpole_3_straight extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 32;

	public Modelnpole_3_straight() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[8];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 15, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 2
		bodyModel[2] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[5] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[6] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[7] = new ModelRendererTurbo(this, 1, 2, textureX, textureY); // Box 0

		bodyModel[0].addBox(0F, 0F, 0F, 48, 1, 2, 0F); // Box 0
		bodyModel[0].setRotationPoint(-40F, -40F, -17F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 2
		bodyModel[1].setRotationPoint(7.5F, -43.5F, -17F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,-0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, -0.5F, 0F, -0.05F); // Box 2
		bodyModel[2].setRotationPoint(-40.5F, -43.5F, -17F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[3].setRotationPoint(-2F, -43.5F, -17F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[4].setRotationPoint(-12F, -43.5F, -17F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[5].setRotationPoint(-21F, -43.5F, -17F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[6].setRotationPoint(-30F, -43.5F, -17F);

		bodyModel[7].addBox(0F, 0F, 0F, 48, 1, 2, 0F); // Box 0
		bodyModel[7].setRotationPoint(-40F, -44F, -17F);
	}
}