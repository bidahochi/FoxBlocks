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

public class Modelcoil_centered extends ModelConverter //Same as Filename
{
	int textureX = 64;
	int textureY = 64;

	public Modelcoil_centered() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[8];

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

		bodyModel[0].addBox(0F, 0F, 0F, 10, 5, 7, 0F); // Box 2 she coil on my gon till i...
		bodyModel[0].setRotationPoint(-5F, -7F, -3.5F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 10, 7, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F); // Box 3 she coil on my gon till i...
		bodyModel[1].setRotationPoint(-5F, -2F, -8.5F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 10, 7, 5, 0F,0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4 she coil on my gon till i...
		bodyModel[2].setRotationPoint(-5F, -2F, 3.5F);

		bodyModel[3].addBox(0F, 0F, 0F, 10, 5, 7, 0F); // Box 5 she coil on my gon till i...
		bodyModel[3].setRotationPoint(-5F, 5F, -3.5F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 6 she coil on my gon till i...
		bodyModel[4].setRotationPoint(-5F, -2F, -3.5F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7 she coil on my gon till i...
		bodyModel[5].setRotationPoint(-5F, -2F, 1.5F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8 she coil on my gon till i...
		bodyModel[6].setRotationPoint(-5F, 3F, 1.5F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9 she coil on my gon till i...
		bodyModel[7].setRotationPoint(-5F, 3F, -3.5F);
	}
}