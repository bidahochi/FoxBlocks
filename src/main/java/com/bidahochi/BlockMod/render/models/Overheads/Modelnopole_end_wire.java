//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: nopole_end_wire
// Model Creator: 
// Created on: 20.04.2024 - 16:15:36
// Last changed on: 20.04.2024 - 16:15:36

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;


public class Modelnopole_end_wire extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 32;

	public Modelnopole_end_wire() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[14];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 5
		bodyModel[1] = new ModelRendererTurbo(this, 1, 19, textureX, textureY); // Box 6
		bodyModel[2] = new ModelRendererTurbo(this, 42, 7, textureX, textureY); // Box 8
		bodyModel[3] = new ModelRendererTurbo(this, 42, 1, textureX, textureY); // Box 12
		bodyModel[4] = new ModelRendererTurbo(this, 1, 15, textureX, textureY); // Box 22
		bodyModel[5] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 28
		bodyModel[6] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 29
		bodyModel[7] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 5
		bodyModel[8] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 28
		bodyModel[9] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 29
		bodyModel[10] = new ModelRendererTurbo(this, 1, -14, textureX, textureY); // Box 1
		bodyModel[11] = new ModelRendererTurbo(this, 42, 1, textureX, textureY); // Box 12
		bodyModel[12] = new ModelRendererTurbo(this, 42, 1, textureX, textureY); // Box 12
		bodyModel[13] = new ModelRendererTurbo(this, 42, 1, textureX, textureY); // Box 12

		bodyModel[0].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 5
		bodyModel[0].setRotationPoint(-41F, -53F, -10F);

		bodyModel[1].addBox(0F, 0F, 0F, 48, 1, 2, 0F); // Box 6
		bodyModel[1].setRotationPoint(-40F, -40F, -17F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.05F); // Box 8
		bodyModel[2].setRotationPoint(7.5F, -43.25F, -17F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 12
		bodyModel[3].setRotationPoint(-3F, -43.5F, -17F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 48, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		bodyModel[4].setRotationPoint(-40F, -44F, -17F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 28
		bodyModel[5].setRotationPoint(-41F, -54F, -10F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[6].setRotationPoint(-40.5F, -54F, -9.5F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 5
		bodyModel[7].setRotationPoint(-41F, -53F, -24F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 28
		bodyModel[8].setRotationPoint(-41F, -54F, -24F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[9].setRotationPoint(-40.5F, -54F, -23.5F);

		bodyModel[10].addBox(0F, 0F, 0F, 0, 13, 15, 0F); // Box 1
		bodyModel[10].setRotationPoint(-40.01F, -52F, -23.5F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 12
		bodyModel[11].setRotationPoint(-13F, -43.5F, -17F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 12
		bodyModel[12].setRotationPoint(-23F, -43.5F, -17F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 12
		bodyModel[13].setRotationPoint(-33F, -43.5F, -17F);
	}
}