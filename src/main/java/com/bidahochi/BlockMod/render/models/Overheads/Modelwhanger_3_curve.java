//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: whanger_3_curve
// Model Creator: 
// Created on: 05.07.2020 - 22:04:54
// Last changed on: 05.07.2020 - 22:04:54

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelwhanger_3_curve extends ModelConverter //Same as Filename
{
	int textureX = 256;
	int textureY = 128;

	public Modelwhanger_3_curve() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[24];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 5
		bodyModel[1] = new ModelRendererTurbo(this, 25, 27, textureX, textureY); // Box 7
		bodyModel[2] = new ModelRendererTurbo(this, 18, 32, textureX, textureY); // Box 8
		bodyModel[3] = new ModelRendererTurbo(this, 46, 29, textureX, textureY); // Box 9
		bodyModel[4] = new ModelRendererTurbo(this, 39, 30, textureX, textureY); // Box 10
		bodyModel[5] = new ModelRendererTurbo(this, 32, 31, textureX, textureY); // Box 11
		bodyModel[6] = new ModelRendererTurbo(this, 18, 26, textureX, textureY); // Box 13
		bodyModel[7] = new ModelRendererTurbo(this, 46, 29, textureX, textureY); // Box 14
		bodyModel[8] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 28
		bodyModel[9] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 29
		bodyModel[10] = new ModelRendererTurbo(this, 18, 86, textureX, textureY); // Box 6
		bodyModel[11] = new ModelRendererTurbo(this, 19, 62, textureX, textureY); // Box 6
		bodyModel[12] = new ModelRendererTurbo(this, 25, 68, textureX, textureY); // Box 40
		bodyModel[13] = new ModelRendererTurbo(this, 39, 23, textureX, textureY); // Box 10
		bodyModel[14] = new ModelRendererTurbo(this, 32, 25, textureX, textureY); // Box 11
		bodyModel[15] = new ModelRendererTurbo(this, 72, 62, textureX, textureY); // Box 40
		bodyModel[16] = new ModelRendererTurbo(this, 72, 62, textureX, textureY); // Box 40
		bodyModel[17] = new ModelRendererTurbo(this, 58, 44, textureX, textureY); // Box 6
		bodyModel[18] = new ModelRendererTurbo(this, 59, 49, textureX, textureY); // Box 6
		bodyModel[19] = new ModelRendererTurbo(this, 28, 6, textureX, textureY); // Box 29
		bodyModel[20] = new ModelRendererTurbo(this, 18, 6, textureX, textureY); // Box 29
		bodyModel[21] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 5
		bodyModel[22] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 28
		bodyModel[23] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 29

		bodyModel[0].addShapeBox(-1F, 0F, -1F, 2, 1, 2, 0F,-0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F); // Box 5
		bodyModel[0].setRotationPoint(-21F, -53F, -27F);
		bodyModel[0].rotateAngleY = 0.78539816F;

		bodyModel[1].addShapeBox(-0.5F, 0F, -1F, 1, 1, 2, 0F,0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F); // Box 7
		bodyModel[1].setRotationPoint(-20F, -48F, -28F);
		bodyModel[1].rotateAngleY = 0.78539816F;

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.15F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.15F); // Box 8
		bodyModel[2].setRotationPoint(7.5F, -43.25F, -17F);

		bodyModel[3].addShapeBox(-0.5F, 0F, -1F, 1, 6, 2, 0F,0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.5F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.5F); // Box 9
		bodyModel[3].setRotationPoint(-14F, -45.75F, -22F);
		bodyModel[3].rotateAngleY = 0.43633231F;

		bodyModel[4].addShapeBox(-0.5F, 0F, -1F, 1, 5, 2, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F); // Box 10
		bodyModel[4].setRotationPoint(-6.95F, -45F, -20.05F);
		bodyModel[4].rotateAngleY = 0.26179939F;

		bodyModel[5].addShapeBox(-0.5F, 0F, -1F, 1, 4, 2, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0.125F, -0.1F, 0F, 0.125F, -0.1F, 0F, 0.125F, -0.1F, 0F, 0.125F, -0.1F); // Box 11
		bodyModel[5].setRotationPoint(0.149999999999999F, -44.13F, -18.15F);
		bodyModel[5].rotateAngleY = 0.26179939F;

		bodyModel[6].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F,-0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.15F, 0F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.15F, 0F, -0.5F); // Box 13
		bodyModel[6].setRotationPoint(-33F, -43.5F, -56F);

		bodyModel[7].addShapeBox(-0.5F, 0F, -1F, 1, 6, 2, 0F,0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.5F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.5F, 0F, 0F, -0.3F); // Box 14
		bodyModel[7].setRotationPoint(-26F, -45.75F, -34F);
		bodyModel[7].rotateAngleY = 1.06465084F;

		bodyModel[8].addShapeBox(-1F, 0F, -1F, 2, 1, 2, 0F,-0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F); // Box 28
		bodyModel[8].setRotationPoint(-21F, -54F, -27F);
		bodyModel[8].rotateAngleY = 0.78539816F;

		bodyModel[9].addShapeBox(-0.5F, 0F, -0.5F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[9].setRotationPoint(-21F, -54F, -27F);
		bodyModel[9].rotateAngleY = 0.78539816F;

		bodyModel[10].addShapeBox(0F, 0F, 0F, 22, 1, 2, 0F,0F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F); // Box 6
		bodyModel[10].setRotationPoint(-14F, -40F, -17F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 2, 1, 22, 0F,0F, 0F, 0F, 0F, 0F, 0F, 6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 6F, 0F, 0F, -6F, 0F, 0F); // Box 6
		bodyModel[11].setRotationPoint(-33F, -40F, -56F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 2, 1, 16, 0F,0F, 0F, 0F, 0F, 0F, 0F, 11F, 0F, -5F, -13F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 11F, 0F, -5F, -13F, 0F, -3F); // Box 40
		bodyModel[12].setRotationPoint(-27F, -40F, -34F);

		bodyModel[13].addShapeBox(-1F, 0F, -0.5F, 2, 5, 1, 0F,-0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 10
		bodyModel[13].setRotationPoint(-28.15F, -45F, -42F);
		bodyModel[13].rotateAngleY = -0.26179939F;

		bodyModel[14].addShapeBox(-1F, 0F, -0.5F, 2, 4, 1, 0F,-0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0.125F, 0F, -0.1F, 0.125F, 0F, -0.1F, 0.125F, 0F, -0.1F, 0.125F, 0F); // Box 11
		bodyModel[14].setRotationPoint(-30.1F, -44.13F, -49F);
		bodyModel[14].rotateAngleY = -0.26179939F;

		bodyModel[15].addShapeBox(0F, 0F, 0F, 2, 1, 9, 0F,0F, -2F, -1F, 0F, -2F, -1F, 5.5F, 0F, -2.5F, -6.5F, 0F, -1.5F, 0F, 2F, -1F, 0F, 2F, -1F, 5.5F, 0F, -2.5F, -6.5F, 0F, -1.5F); // Box 40
		bodyModel[15].setRotationPoint(-27F, -48F, -35F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 2, 1, 9, 0F,0F, 0F, 0F, -1F, 0F, 1F, 4.5F, -2F, -4.5F, -6.5F, -2F, -2.5F, 0F, 0F, 0F, -1F, 0F, 1F, 4.5F, 2F, -4.5F, -6.5F, 2F, -2.5F); // Box 40
		bodyModel[16].setRotationPoint(-20.5F, -48F, -27.5F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 22, 1, 2, 0F,0F, 0F, 6F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -6F, 0F, 0F, 6F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, -6F); // Box 6
		bodyModel[17].setRotationPoint(-14F, -46F, -17F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 2, 1, 22, 0F,0F, 0F, 0F, 0F, 0F, 0F, 6F, 2F, 0F, -6F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 6F, -2F, 0F, -6F, -2F, 0F); // Box 6
		bodyModel[18].setRotationPoint(-33F, -44F, -56F);

		bodyModel[19].addShapeBox(-0.5F, 0F, -0.5F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[19].setRotationPoint(-20F, -51F, -28F);
		bodyModel[19].rotateAngleY = 0.78539816F;

		bodyModel[20].addShapeBox(-1F, 0F, -2.5F, 2, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[20].setRotationPoint(-20F, -52F, -28F);
		bodyModel[20].rotateAngleY = 0.78539816F;

		bodyModel[21].addShapeBox(-1F, 0F, -1F, 2, 1, 2, 0F,-0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F); // Box 5
		bodyModel[21].setRotationPoint(-19F, -53F, -29F);
		bodyModel[21].rotateAngleY = 0.78539816F;

		bodyModel[22].addShapeBox(-1F, 0F, -1F, 2, 1, 2, 0F,-0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F, -0.125F); // Box 28
		bodyModel[22].setRotationPoint(-19F, -54F, -29F);
		bodyModel[22].rotateAngleY = 0.78539816F;

		bodyModel[23].addShapeBox(-0.5F, 0F, -0.5F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[23].setRotationPoint(-19F, -54F, -29F);
		bodyModel[23].rotateAngleY = 0.78539816F;
	}
}