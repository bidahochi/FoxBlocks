//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: whanger_8_s_curve
// Model Creator: 
// Created on: 26.07.2023 - 16:24:05
// Last changed on: 26.07.2023 - 16:24:05

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelwhanger_8_s_curve extends ModelConverter //Same as Filename
{
	int textureX = 256;
	int textureY = 128;

	public Modelwhanger_8_s_curve() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[31];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 206, 51, textureX, textureY); // Box 81
		bodyModel[1] = new ModelRendererTurbo(this, 221, 51, textureX, textureY); // Box 82
		bodyModel[2] = new ModelRendererTurbo(this, 212, 49, textureX, textureY); // Box 83
		bodyModel[3] = new ModelRendererTurbo(this, 212, 53, textureX, textureY); // Box 84
		bodyModel[4] = new ModelRendererTurbo(this, 65, 122, textureX, textureY); // Box 6
		bodyModel[5] = new ModelRendererTurbo(this, 18, 32, textureX, textureY); // Box 13
		bodyModel[6] = new ModelRendererTurbo(this, 46, 29, textureX, textureY); // Box 14
		bodyModel[7] = new ModelRendererTurbo(this, 39, 30, textureX, textureY); // Box 15
		bodyModel[8] = new ModelRendererTurbo(this, 25, 32, textureX, textureY); // Box 17
		bodyModel[9] = new ModelRendererTurbo(this, 100, 117, textureX, textureY); // Box 6
		bodyModel[10] = new ModelRendererTurbo(this, 100, 117, textureX, textureY); // Box 6
		bodyModel[11] = new ModelRendererTurbo(this, 77, 117, textureX, textureY); // Box 6
		bodyModel[12] = new ModelRendererTurbo(this, 32, 31, textureX, textureY); // Box 16
		bodyModel[13] = new ModelRendererTurbo(this, 39, 30, textureX, textureY); // Box 15
		bodyModel[14] = new ModelRendererTurbo(this, 18, 32, textureX, textureY); // Box 13
		bodyModel[15] = new ModelRendererTurbo(this, 46, 29, textureX, textureY); // Box 14
		bodyModel[16] = new ModelRendererTurbo(this, 39, 30, textureX, textureY); // Box 15
		bodyModel[17] = new ModelRendererTurbo(this, 25, 32, textureX, textureY); // Box 17
		bodyModel[18] = new ModelRendererTurbo(this, 32, 31, textureX, textureY); // Box 16
		bodyModel[19] = new ModelRendererTurbo(this, 39, 30, textureX, textureY); // Box 15
		bodyModel[20] = new ModelRendererTurbo(this, 65, 122, textureX, textureY); // Box 6
		bodyModel[21] = new ModelRendererTurbo(this, 100, 117, textureX, textureY); // Box 6
		bodyModel[22] = new ModelRendererTurbo(this, 100, 117, textureX, textureY); // Box 6
		bodyModel[23] = new ModelRendererTurbo(this, 77, 117, textureX, textureY); // Box 6
		bodyModel[24] = new ModelRendererTurbo(this, 32, 31, textureX, textureY); // Box 16
		bodyModel[25] = new ModelRendererTurbo(this, 32, 31, textureX, textureY); // Box 16
		bodyModel[26] = new ModelRendererTurbo(this, 28, 6, textureX, textureY); // Box 29
		bodyModel[27] = new ModelRendererTurbo(this, 18, 6, textureX, textureY); // Box 29
		bodyModel[28] = new ModelRendererTurbo(this, 221, 51, textureX, textureY); // Box 82
		bodyModel[29] = new ModelRendererTurbo(this, 212, 49, textureX, textureY); // Box 83
		bodyModel[30] = new ModelRendererTurbo(this, 212, 53, textureX, textureY); // Box 84

		bodyModel[0].addShapeBox(-0.5F, 0F, 0F, 1, 1, 2, 0F,0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F); // Box 81
		bodyModel[0].setRotationPoint(-56F, -48F, -9F);

		bodyModel[1].addShapeBox(-0.5F, 0F, -0.5F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 82
		bodyModel[1].setRotationPoint(-56F, -54F, -6F);

		bodyModel[2].addShapeBox(-1F, 0F, -1F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 83
		bodyModel[2].setRotationPoint(-56F, -54F, -6F);

		bodyModel[3].addShapeBox(-1F, 0F, -1F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 84
		bodyModel[3].setRotationPoint(-56F, -53F, -6F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 64, 1, 2, 0F,0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F); // Box 6
		bodyModel[4].setRotationPoint(-56F, -40F, -17F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.05F); // Box 13
		bodyModel[5].setRotationPoint(7.5F, -43.25F, -17F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 6, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 14
		bodyModel[6].setRotationPoint(-47F, -45.5F, -10.15F);
		bodyModel[6].rotateAngleY = -0.12217305F;

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 15
		bodyModel[7].setRotationPoint(-28F, -44.5F, -12.5F);
		bodyModel[7].rotateAngleY = -0.12217305F;

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 17
		bodyModel[8].setRotationPoint(-2F, -43.5F, -15.75F);
		bodyModel[8].rotateAngleY = -0.12217305F;

		bodyModel[9].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, 1.25F, 0F, 0F, -1.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.25F, 0F, 0F, -1.25F, 0F, 0F, 0F); // Box 6
		bodyModel[9].setRotationPoint(-2F, -44F, -15.75F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, 0F, 0F, 0F, -2F, 1.25F, 0F, -2F, -1.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 1.25F, 0F, 2F, -1.25F, 0F, 0F, 0F); // Box 6
		bodyModel[10].setRotationPoint(-56F, -48F, -9F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 44, 1, 2, 0F,0F, 0F, 0F, 0F, -2F, 5.5F, 0F, -2F, -5.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 5.5F, 0F, 2F, -5.5F, 0F, 0F, 0F); // Box 6
		bodyModel[11].setRotationPoint(-46F, -46F, -10.25F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 16
		bodyModel[12].setRotationPoint(-19F, -44.13F, -13.65F);
		bodyModel[12].rotateAngleY = -0.12217305F;

		bodyModel[13].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 15
		bodyModel[13].setRotationPoint(-38F, -45F, -11.25F);
		bodyModel[13].rotateAngleY = -0.12217305F;

		bodyModel[14].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,-0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F); // Box 13
		bodyModel[14].setRotationPoint(-120.5F, -43.25F, -1F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 1, 6, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 14
		bodyModel[15].setRotationPoint(-66F, -45.5F, -7.75F);
		bodyModel[15].rotateAngleY = -0.12217305F;

		bodyModel[16].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 15
		bodyModel[16].setRotationPoint(-83F, -44.5F, -5.65F);
		bodyModel[16].rotateAngleY = -0.12217305F;

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 17
		bodyModel[17].setRotationPoint(-111F, -43.5F, -2.15F);
		bodyModel[17].rotateAngleY = -0.12217305F;

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 16
		bodyModel[18].setRotationPoint(-92F, -44.13F, -4.5F);
		bodyModel[18].rotateAngleY = -0.12217305F;

		bodyModel[19].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 15
		bodyModel[19].setRotationPoint(-74F, -45F, -6.75F);
		bodyModel[19].rotateAngleY = -0.12217305F;

		bodyModel[20].addShapeBox(0F, 0F, 0F, 64, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, -8F, 0F, 0F, 0F); // Box 6
		bodyModel[20].setRotationPoint(-120F, -40F, -1F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, 0F, -1.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.25F, 0F, 0F, -1.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.25F); // Box 6
		bodyModel[21].setRotationPoint(-120F, -44F, -2.25F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, -2F, -1.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1.25F, 0F, 2F, -1.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 1.25F); // Box 6
		bodyModel[22].setRotationPoint(-66F, -48F, -9F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 44, 1, 2, 0F,0F, -2F, -5.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 5.5F, 0F, 2F, -5.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 5.5F); // Box 6
		bodyModel[23].setRotationPoint(-110F, -46F, -7.75F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 16
		bodyModel[24].setRotationPoint(-10F, -44.13F, -14.75F);
		bodyModel[24].rotateAngleY = -0.12217305F;

		bodyModel[25].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 16
		bodyModel[25].setRotationPoint(-101F, -44.13F, -3.4F);
		bodyModel[25].rotateAngleY = -0.12217305F;

		bodyModel[26].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[26].setRotationPoint(-56.5F, -51F, -8.5F);

		bodyModel[27].addShapeBox(0F, 0F, 0F, 2, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[27].setRotationPoint(-57F, -52F, -10.5F);

		bodyModel[28].addShapeBox(-0.5F, 0F, -0.5F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 82
		bodyModel[28].setRotationPoint(-56F, -54F, -10F);

		bodyModel[29].addShapeBox(-1F, 0F, -1F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 83
		bodyModel[29].setRotationPoint(-56F, -54F, -10F);

		bodyModel[30].addShapeBox(-1F, 0F, -1F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 84
		bodyModel[30].setRotationPoint(-56F, -53F, -10F);
	}
}