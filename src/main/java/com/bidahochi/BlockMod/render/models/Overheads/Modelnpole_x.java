//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: crossover_simp
// Model Creator: 
// Created on: 04.11.2020 - 22:42:51
// Last changed on: 04.11.2020 - 22:42:51

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelnpole_x extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 32;

	public Modelnpole_x() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[18];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 0, 5, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 2, 9, textureX, textureY); // Box 2
		bodyModel[2] = new ModelRendererTurbo(this, 2, 9, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 2, 9, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 2, 9, textureX, textureY); // Box 3
		bodyModel[5] = new ModelRendererTurbo(this, 2, 9, textureX, textureY); // Box 3
		bodyModel[6] = new ModelRendererTurbo(this, 2, 9, textureX, textureY); // Box 3
		bodyModel[7] = new ModelRendererTurbo(this, 0, 1, textureX, textureY); // Box 0
		bodyModel[8] = new ModelRendererTurbo(this, 52, 8, textureX, textureY); // Box 0
		bodyModel[9] = new ModelRendererTurbo(this, 9, 10, textureX, textureY); // Box 2
		bodyModel[10] = new ModelRendererTurbo(this, 9, 10, textureX, textureY); // Box 2
		bodyModel[11] = new ModelRendererTurbo(this, 9, 10, textureX, textureY); // Box 3
		bodyModel[12] = new ModelRendererTurbo(this, 9, 10, textureX, textureY); // Box 3
		bodyModel[13] = new ModelRendererTurbo(this, 9, 10, textureX, textureY); // Box 3
		bodyModel[14] = new ModelRendererTurbo(this, 9, 10, textureX, textureY); // Box 3
		bodyModel[15] = new ModelRendererTurbo(this, 1, 8, textureX, textureY); // Box 0
		bodyModel[16] = new ModelRendererTurbo(this, 52, 8, textureX, textureY); // Box 0
		bodyModel[17] = new ModelRendererTurbo(this, 1, 8, textureX, textureY); // Box 0

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

		bodyModel[8].addBox(0F, 0F, 0F, 2, 1, 23, 0F); // Box 0
		bodyModel[8].setRotationPoint(-17F, -40F, -15F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F,-0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F); // Box 2
		bodyModel[9].setRotationPoint(-17F, -43.5F, -40.5F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F,-0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.05F, 0F, -0.5F); // Box 2
		bodyModel[10].setRotationPoint(-17F, -43.5F, 7.5F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F,-0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F); // Box 3
		bodyModel[11].setRotationPoint(-17F, -43.5F, -31F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F,-0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F); // Box 3
		bodyModel[12].setRotationPoint(-17F, -43.5F, -21F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F,-0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F); // Box 3
		bodyModel[13].setRotationPoint(-17F, -43.5F, -12F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F,-0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F); // Box 3
		bodyModel[14].setRotationPoint(-17F, -43.5F, -3F);

		bodyModel[15].addBox(0F, 0F, 0F, 2, 1, 23, 0F); // Box 0
		bodyModel[15].setRotationPoint(-17F, -44F, -15F);

		bodyModel[16].addBox(0F, 0F, 0F, 2, 1, 23, 0F); // Box 0
		bodyModel[16].setRotationPoint(-17F, -40F, -40F);

		bodyModel[17].addBox(0F, 0F, 0F, 2, 1, 23, 0F); // Box 0
		bodyModel[17].setRotationPoint(-17F, -44F, -40F);
	}
}