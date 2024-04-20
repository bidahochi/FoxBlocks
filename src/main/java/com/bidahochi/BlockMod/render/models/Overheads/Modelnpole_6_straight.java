//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: 6_long_simp
// Model Creator: 
// Created on: 04.11.2020 - 22:42:51
// Last changed on: 04.11.2020 - 22:42:51

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelnpole_6_straight extends ModelConverter //Same as Filename
{
	int textureX = 256;
	int textureY = 32;

	public Modelnpole_6_straight() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[13];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 15, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 2
		bodyModel[2] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[3] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[5] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[6] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 2
		bodyModel[7] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[8] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[9] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[10] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[11] = new ModelRendererTurbo(this, 1, 2, textureX, textureY); // Box 0
		bodyModel[12] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3

		bodyModel[0].addBox(0F, 0F, 0F, 96, 1, 2, 0F); // Box 0
		bodyModel[0].setRotationPoint(-88F, -40F, -17F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 2
		bodyModel[1].setRotationPoint(7.5F, -43.5F, -17F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[2].setRotationPoint(-31F, -43.5F, -17F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[3].setRotationPoint(-21F, -43.5F, -17F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[4].setRotationPoint(-12F, -43.5F, -17F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[5].setRotationPoint(-3F, -43.5F, -17F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,-0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, -0.5F, 0F, -0.05F); // Box 2
		bodyModel[6].setRotationPoint(-88.5F, -43.5F, -17F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[7].setRotationPoint(-50F, -43.5F, -17F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[8].setRotationPoint(-60F, -43.5F, -17F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[9].setRotationPoint(-69F, -43.5F, -17F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[10].setRotationPoint(-78F, -43.5F, -17F);

		bodyModel[11].addBox(0F, 0F, 0F, 96, 1, 2, 0F); // Box 0
		bodyModel[11].setRotationPoint(-88F, -44F, -17F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[12].setRotationPoint(-40.5F, -43.5F, -17F);
	}
}