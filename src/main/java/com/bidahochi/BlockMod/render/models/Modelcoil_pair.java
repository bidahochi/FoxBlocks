//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: 
// Model Creator: 
// Created on: -
// Last changed on: -

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelcoil_pair extends ModelConverter//Same as Filename
{
	int textureX = 64;
	int textureY = 64;

	public Modelcoil_pair() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[16];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 15, textureX, textureY); // Box 2 she coil on my gon till i...
		bodyModel[1] = new ModelRendererTurbo(this, 3, 50, textureX, textureY); // Box 3 she coil on my gon till i...
		bodyModel[2] = new ModelRendererTurbo(this, 3, 2, textureX, textureY); // Box 4 she coil on my gon till i...
		bodyModel[3] = new ModelRendererTurbo(this, 1, 37, textureX, textureY); // Box 5 she coil on my gon till i...
		bodyModel[4] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 6 she coil on my gon till i...
		bodyModel[5] = new ModelRendererTurbo(this, 33, 29, textureX, textureY); // Box 7 she coil on my gon till i...
		bodyModel[6] = new ModelRendererTurbo(this, 33, 50, textureX, textureY); // Box 8 she coil on my gon till i...
		bodyModel[7] = new ModelRendererTurbo(this, 33, 34, textureX, textureY); // Box 9 she coil on my gon till i...
		bodyModel[8] = new ModelRendererTurbo(this, 3, 50, textureX, textureY); // Box 11
		bodyModel[9] = new ModelRendererTurbo(this, 33, 34, textureX, textureY); // Box 12
		bodyModel[10] = new ModelRendererTurbo(this, 1, 37, textureX, textureY); // Box 13
		bodyModel[11] = new ModelRendererTurbo(this, 33, 50, textureX, textureY); // Box 14
		bodyModel[12] = new ModelRendererTurbo(this, 3, 2, textureX, textureY); // Box 15
		bodyModel[13] = new ModelRendererTurbo(this, 33, 29, textureX, textureY); // Box 16
		bodyModel[14] = new ModelRendererTurbo(this, 1, 15, textureX, textureY); // Box 17
		bodyModel[15] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 18

		bodyModel[0].addBox(0F, 0F, 0F, 10, 5, 7, 0F); // Box 2 she coil on my gon till i...
		bodyModel[0].setRotationPoint(1F, -7F, -3.5F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 10, 7, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F); // Box 3 she coil on my gon till i...
		bodyModel[1].setRotationPoint(1F, -2F, -8.5F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 10, 7, 5, 0F,0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4 she coil on my gon till i...
		bodyModel[2].setRotationPoint(1F, -2F, 3.5F);

		bodyModel[3].addBox(0F, 0F, 0F, 10, 5, 7, 0F); // Box 5 she coil on my gon till i...
		bodyModel[3].setRotationPoint(1F, 5F, -3.5F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 6 she coil on my gon till i...
		bodyModel[4].setRotationPoint(1F, -2F, -3.5F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7 she coil on my gon till i...
		bodyModel[5].setRotationPoint(1F, -2F, 1.5F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8 she coil on my gon till i...
		bodyModel[6].setRotationPoint(1F, 3F, 1.5F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9 she coil on my gon till i...
		bodyModel[7].setRotationPoint(1F, 3F, -3.5F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 10, 7, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F); // Box 11
		bodyModel[8].setRotationPoint(-11F, -2F, -8.5F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
		bodyModel[9].setRotationPoint(-11F, 3F, -3.5F);

		bodyModel[10].addBox(0F, 0F, 0F, 10, 5, 7, 0F); // Box 13
		bodyModel[10].setRotationPoint(-11F, 5F, -3.5F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
		bodyModel[11].setRotationPoint(-11F, 3F, 1.5F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 10, 7, 5, 0F,0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
		bodyModel[12].setRotationPoint(-11F, -2F, 3.5F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
		bodyModel[13].setRotationPoint(-11F, -2F, 1.5F);

		bodyModel[14].addBox(0F, 0F, 0F, 10, 5, 7, 0F); // Box 17
		bodyModel[14].setRotationPoint(-11F, -7F, -3.5F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 18
		bodyModel[15].setRotationPoint(-11F, -2F, -3.5F);
	}
}