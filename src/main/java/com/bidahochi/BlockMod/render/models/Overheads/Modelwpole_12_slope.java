//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: wpole_12_slope
// Model Creator: 
// Created on: 05.07.2020 - 22:04:54
// Last changed on: 05.07.2020 - 22:04:54

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelwpole_12_slope extends ModelConverter //Same as Filename
{
	int textureX = 512;
	int textureY = 128;

	public Modelwpole_12_slope() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[36];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 3
		bodyModel[3] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 4
		bodyModel[4] = new ModelRendererTurbo(this, 18, 90, textureX, textureY); // Box 0
		bodyModel[5] = new ModelRendererTurbo(this, 25, 27, textureX, textureY); // Box 1
		bodyModel[6] = new ModelRendererTurbo(this, 18, 32, textureX, textureY); // Box 2
		bodyModel[7] = new ModelRendererTurbo(this, 46, 29, textureX, textureY); // Box 3
		bodyModel[8] = new ModelRendererTurbo(this, 39, 30, textureX, textureY); // Box 3
		bodyModel[9] = new ModelRendererTurbo(this, 32, 31, textureX, textureY); // Box 3
		bodyModel[10] = new ModelRendererTurbo(this, 25, 32, textureX, textureY); // Box 3
		bodyModel[11] = new ModelRendererTurbo(this, 18, 32, textureX, textureY); // Box 2
		bodyModel[12] = new ModelRendererTurbo(this, 46, 29, textureX, textureY); // Box 3
		bodyModel[13] = new ModelRendererTurbo(this, 39, 30, textureX, textureY); // Box 3
		bodyModel[14] = new ModelRendererTurbo(this, 32, 31, textureX, textureY); // Box 3
		bodyModel[15] = new ModelRendererTurbo(this, 25, 32, textureX, textureY); // Box 3
		bodyModel[16] = new ModelRendererTurbo(this, 97, 44, textureX, textureY); // Box 12
		bodyModel[17] = new ModelRendererTurbo(this, 80, 44, textureX, textureY); // Box 13
		bodyModel[18] = new ModelRendererTurbo(this, 48, 44, textureX, textureY); // Box 16
		bodyModel[19] = new ModelRendererTurbo(this, 98, 44, textureX, textureY); // Box 12
		bodyModel[20] = new ModelRendererTurbo(this, 80, 44, textureX, textureY); // Box 15
		bodyModel[21] = new ModelRendererTurbo(this, 48, 44, textureX, textureY); // Box 16
		bodyModel[22] = new ModelRendererTurbo(this, 25, 18, textureX, textureY); // Box 3
		bodyModel[23] = new ModelRendererTurbo(this, 25, 18, textureX, textureY); // Box 3
		bodyModel[24] = new ModelRendererTurbo(this, 25, 18, textureX, textureY); // Box 3
		bodyModel[25] = new ModelRendererTurbo(this, 25, 18, textureX, textureY); // Box 3
		bodyModel[26] = new ModelRendererTurbo(this, 25, 18, textureX, textureY); // Box 3
		bodyModel[27] = new ModelRendererTurbo(this, 25, 18, textureX, textureY); // Box 3
		bodyModel[28] = new ModelRendererTurbo(this, 25, 18, textureX, textureY); // Box 3
		bodyModel[29] = new ModelRendererTurbo(this, 25, 18, textureX, textureY); // Box 3
		bodyModel[30] = new ModelRendererTurbo(this, 25, 18, textureX, textureY); // Box 3
		bodyModel[31] = new ModelRendererTurbo(this, 25, 18, textureX, textureY); // Box 3
		bodyModel[32] = new ModelRendererTurbo(this, 22, 49, textureX, textureY); // Box 2
		bodyModel[33] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 5
		bodyModel[34] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 28
		bodyModel[35] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 29

		bodyModel[0].addBox(0F, 0F, 0F, 4, 89, 4, 0F); // Box 0
		bodyModel[0].setRotationPoint(-90F, -79F, 14.5F);

		bodyModel[1].addBox(0F, 0F, 0F, 2, 2, 38, 0F); // Box 1
		bodyModel[1].setRotationPoint(-89F, -53F, -23.5F);

		bodyModel[2].addBox(0F, 0F, 0F, 1, 0, 2, 0F); // Box 3
		bodyModel[2].setRotationPoint(-88.5F, -68F, 18.5F);

		bodyModel[3].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 4
		bodyModel[3].setRotationPoint(-88.5F, -68.5F, 18.5F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 192, 1, 2, 0F,0F, 0F, 0F, 0F, -16F, 0F, 0F, -16F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 16F, 0F, 0F, 16F, 0F, 0F, 0F, 0F); // Box 0
		bodyModel[4].setRotationPoint(-184F, -56F, -17F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F,0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F); // Box 1
		bodyModel[5].setRotationPoint(-88.5F, -56F, -17F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.05F); // Box 2
		bodyModel[6].setRotationPoint(7.5F, -43.13F, -17F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[7].setRotationPoint(-78F, -52F, -17F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[8].setRotationPoint(-69F, -51.2F, -17F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 3
		bodyModel[9].setRotationPoint(-60F, -49.73F, -17F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 3
		bodyModel[10].setRotationPoint(-51F, -48.35F, -17F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,-0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F); // Box 2
		bodyModel[11].setRotationPoint(-184.5F, -59F, -17F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 6, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[12].setRotationPoint(-99F, -54.9F, -17F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[13].setRotationPoint(-108F, -54.6F, -17F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 3
		bodyModel[14].setRotationPoint(-117F, -54.47F, -17F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 3
		bodyModel[15].setRotationPoint(-126F, -54.6F, -17F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F); // Box 12
		bodyModel[16].setRotationPoint(-88F, -56F, -17F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 27, 1, 2, 0F,0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F); // Box 13
		bodyModel[17].setRotationPoint(-78F, -53F, -17F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 59, 1, 2, 0F,0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F); // Box 16
		bodyModel[18].setRotationPoint(-51F, -49F, -17F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F); // Box 12
		bodyModel[19].setRotationPoint(-98F, -56F, -17F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 27, 1, 2, 0F,0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F); // Box 15
		bodyModel[20].setRotationPoint(-125F, -55F, -17F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 59, 1, 2, 0F,0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F); // Box 16
		bodyModel[21].setRotationPoint(-184F, -60F, -17F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[22].setRotationPoint(-173.5F, -58.5F, -17F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[23].setRotationPoint(-163.5F, -57.75F, -17F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[24].setRotationPoint(-154.5F, -57F, -17F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[25].setRotationPoint(-144.5F, -56.25F, -17F);

		bodyModel[26].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[26].setRotationPoint(-135.5F, -55.5F, -17F);

		bodyModel[27].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[27].setRotationPoint(-39.5F, -47.35F, -17F);

		bodyModel[28].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[28].setRotationPoint(-29.5F, -46.6F, -17F);

		bodyModel[29].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[29].setRotationPoint(-20.5F, -45.85F, -17F);

		bodyModel[30].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[30].setRotationPoint(-10.5F, -45.1F, -17F);

		bodyModel[31].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[31].setRotationPoint(-1.5F, -44.35F, -17F);

		bodyModel[32].addBox(0F, 0F, 0F, 1, 0, 34, 0F); // Box 2
		bodyModel[32].setRotationPoint(-88.5F, -53F, -14.5F);
		bodyModel[32].rotateAngleX = 0.4712389F;

		bodyModel[33].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 5
		bodyModel[33].setRotationPoint(-89F, -54F, -17F);

		bodyModel[34].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 28
		bodyModel[34].setRotationPoint(-89F, -55F, -17F);

		bodyModel[35].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[35].setRotationPoint(-88.5F, -55F, -16.5F);
	}
}