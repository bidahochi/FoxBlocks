//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: whanger_6_long
// Model Creator: 
// Created on: 05.07.2020 - 22:04:54
// Last changed on: 05.07.2020 - 22:04:54

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelwhanger_6_long extends ModelConverter //Same as Filename
{
	int textureX = 256;
	int textureY = 128;

	public Modelwhanger_6_long() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[26];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 5
		bodyModel[1] = new ModelRendererTurbo(this, 18, 90, textureX, textureY); // Box 6
		bodyModel[2] = new ModelRendererTurbo(this, 25, 27, textureX, textureY); // Box 7
		bodyModel[3] = new ModelRendererTurbo(this, 18, 32, textureX, textureY); // Box 8
		bodyModel[4] = new ModelRendererTurbo(this, 46, 29, textureX, textureY); // Box 9
		bodyModel[5] = new ModelRendererTurbo(this, 39, 30, textureX, textureY); // Box 10
		bodyModel[6] = new ModelRendererTurbo(this, 32, 31, textureX, textureY); // Box 11
		bodyModel[7] = new ModelRendererTurbo(this, 25, 32, textureX, textureY); // Box 12
		bodyModel[8] = new ModelRendererTurbo(this, 18, 32, textureX, textureY); // Box 13
		bodyModel[9] = new ModelRendererTurbo(this, 46, 29, textureX, textureY); // Box 14
		bodyModel[10] = new ModelRendererTurbo(this, 39, 30, textureX, textureY); // Box 15
		bodyModel[11] = new ModelRendererTurbo(this, 32, 31, textureX, textureY); // Box 16
		bodyModel[12] = new ModelRendererTurbo(this, 25, 32, textureX, textureY); // Box 17
		bodyModel[13] = new ModelRendererTurbo(this, 40, 44, textureX, textureY); // Box 18
		bodyModel[14] = new ModelRendererTurbo(this, 22, 44, textureX, textureY); // Box 19
		bodyModel[15] = new ModelRendererTurbo(this, 40, 44, textureX, textureY); // Box 22
		bodyModel[16] = new ModelRendererTurbo(this, 40, 44, textureX, textureY); // Box 23
		bodyModel[17] = new ModelRendererTurbo(this, 22, 44, textureX, textureY); // Box 24
		bodyModel[18] = new ModelRendererTurbo(this, 40, 44, textureX, textureY); // Box 27
		bodyModel[19] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 28
		bodyModel[20] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 29
		bodyModel[21] = new ModelRendererTurbo(this, 28, 6, textureX, textureY); // Box 29
		bodyModel[22] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 5
		bodyModel[23] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 28
		bodyModel[24] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 29
		bodyModel[25] = new ModelRendererTurbo(this, 18, 6, textureX, textureY); // Box 29

		bodyModel[0].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 5
		bodyModel[0].setRotationPoint(-41F, -53F, -19F);

		bodyModel[1].addBox(0F, 0F, 0F, 96, 1, 2, 0F); // Box 6
		bodyModel[1].setRotationPoint(-88F, -40F, -17F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F,0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F); // Box 7
		bodyModel[2].setRotationPoint(-40.5F, -48F, -17F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.05F); // Box 8
		bodyModel[3].setRotationPoint(7.5F, -43.25F, -17F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 6, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 9
		bodyModel[4].setRotationPoint(-30F, -46F, -17F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 10
		bodyModel[5].setRotationPoint(-21F, -45F, -17F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 11
		bodyModel[6].setRotationPoint(-12F, -44.13F, -17F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 12
		bodyModel[7].setRotationPoint(-3F, -43.5F, -17F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,-0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F); // Box 13
		bodyModel[8].setRotationPoint(-88.5F, -43.25F, -17F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 6, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 14
		bodyModel[9].setRotationPoint(-51F, -46F, -17F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 15
		bodyModel[10].setRotationPoint(-60F, -45F, -17F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 16
		bodyModel[11].setRotationPoint(-69F, -44.13F, -17F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 17
		bodyModel[12].setRotationPoint(-78F, -43.5F, -17F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.5F, 0F, 0F, 1.5F, 0F, 0F, 0F, 0F); // Box 18
		bodyModel[13].setRotationPoint(-40F, -48F, -17F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 28, 1, 2, 0F,0F, 0F, 0F, 0F, -2.5F, 0F, 0F, -2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2.5F, 0F, 0F, 2.5F, 0F, 0F, 0F, 0F); // Box 19
		bodyModel[14].setRotationPoint(-30F, -46.5F, -17F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		bodyModel[15].setRotationPoint(-2F, -44F, -17F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.5F, 0F); // Box 23
		bodyModel[16].setRotationPoint(-50F, -48F, -17F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 28, 1, 2, 0F,0F, 0F, 0F, 0F, 2.5F, 0F, 0F, 2.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, 0F, 0F, -2.5F, 0F, 0F, 0F, 0F); // Box 24
		bodyModel[17].setRotationPoint(-78F, -44F, -17F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 27
		bodyModel[18].setRotationPoint(-88F, -44F, -17F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 28
		bodyModel[19].setRotationPoint(-41F, -54F, -19F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[20].setRotationPoint(-40.5F, -54F, -18.5F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[21].setRotationPoint(-40.5F, -51F, -16.5F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 5
		bodyModel[22].setRotationPoint(-41F, -53F, -15F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 28
		bodyModel[23].setRotationPoint(-41F, -54F, -15F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[24].setRotationPoint(-40.5F, -54F, -14.5F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 2, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[25].setRotationPoint(-41F, -52F, -18.5F);
	}
}