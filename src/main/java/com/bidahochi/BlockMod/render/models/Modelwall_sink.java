//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2025 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: wall mounted sink
// Model Creator: bida
// Created on: 13.01.2025 - 12:17:29
// Last changed on: 13.01.2025 - 12:17:29

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelwall_sink extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 64;

	public Modelwall_sink() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[32];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 2
		bodyModel[2] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 3
		bodyModel[3] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 4
		bodyModel[4] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 5
		bodyModel[5] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 6
		bodyModel[6] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 7
		bodyModel[7] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 8
		bodyModel[8] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 9
		bodyModel[9] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 10
		bodyModel[10] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Box 11
		bodyModel[11] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 12
		bodyModel[12] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 13
		bodyModel[13] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 14
		bodyModel[14] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 15
		bodyModel[15] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 16
		bodyModel[16] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 17
		bodyModel[17] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 18
		bodyModel[18] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 19
		bodyModel[19] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 20
		bodyModel[20] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 21
		bodyModel[21] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 22
		bodyModel[22] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 23
		bodyModel[23] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 24
		bodyModel[24] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 25
		bodyModel[25] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 26
		bodyModel[26] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 27
		bodyModel[27] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 28
		bodyModel[28] = new ModelRendererTurbo(this, 41, 25, textureX, textureY); // Box 29
		bodyModel[29] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 30
		bodyModel[30] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 31
		bodyModel[31] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 32

		bodyModel[0].addBox(0F, 0F, 0F, 3, 3, 12, 0F); // Box 1
		bodyModel[0].setRotationPoint(5F, -6F, -6F);

		bodyModel[1].addBox(0F, 0F, 0F, 12, 2, 1, 0F); // Box 2
		bodyModel[1].setRotationPoint(-4F, -6F, -7F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 2, 12, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0F, 0F); // Box 3
		bodyModel[2].setRotationPoint(-4F, -6F, -6F);

		bodyModel[3].addBox(0F, 0F, 0F, 12, 2, 1, 0F); // Box 4
		bodyModel[3].setRotationPoint(-4F, -6F, 6F);

		bodyModel[4].addBox(0F, 0F, 0F, 1, 2, 14, 0F); // Box 5
		bodyModel[4].setRotationPoint(7F, -8F, -7F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, -1F, -0.125F, 0F); // Box 6
		bodyModel[5].setRotationPoint(4F, -6F, -5F);

		bodyModel[6].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 7
		bodyModel[6].setRotationPoint(4F, -6F, -6F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F); // Box 8
		bodyModel[7].setRotationPoint(4F, -6F, 2F);

		bodyModel[8].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 9
		bodyModel[8].setRotationPoint(4F, -6F, 5F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.125F, 0F, 0F, 0.25F, 0F, -1F, 0.125F, 0F, 0F, 0.125F, 0F); // Box 10
		bodyModel[9].setRotationPoint(-3F, -6F, -6F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.125F, 0F, -1F, 0.125F, 0F, 0F, 0.25F, 0F, 0F, 0.125F, 0F); // Box 11
		bodyModel[10].setRotationPoint(-3F, -6F, 5F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.375F, -1F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.375F, 0F); // Box 12
		bodyModel[11].setRotationPoint(1F, -6F, 5F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -0.375F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.375F, -1F); // Box 13
		bodyModel[12].setRotationPoint(1F, -6F, -6F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 6, 2, 1, 0F,0F, -2F, -0.75F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
		bodyModel[13].setRotationPoint(1F, -8F, 6F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 6, 2, 1, 0F,0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, -2F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.75F); // Box 15
		bodyModel[14].setRotationPoint(1F, -8F, -7F);

		bodyModel[15].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 16
		bodyModel[15].setRotationPoint(5.5F, -6.5F, -2F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, 0.5F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F); // Box 17
		bodyModel[16].setRotationPoint(3F, -7F, -0.5F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.25F, 0F, -0.125F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.125F); // Box 18
		bodyModel[17].setRotationPoint(2F, -7.5F, -0.5F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F,-0.125F, -0.5F, 0F, -0.125F, -0.5F, 0F, -0.125F, -0.5F, 0F, -0.125F, -0.5F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F); // Box 19
		bodyModel[18].setRotationPoint(5.5F, -7.5F, 1F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F,-0.125F, -0.5F, 0F, -0.125F, -0.5F, 0F, -0.125F, -0.5F, 0F, -0.125F, -0.5F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F); // Box 20
		bodyModel[19].setRotationPoint(5.5F, -7.5F, -3F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 21
		bodyModel[20].setRotationPoint(-4F, -4F, 6F);

		bodyModel[21].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 22
		bodyModel[21].setRotationPoint(3F, -4F, 6F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 23
		bodyModel[22].setRotationPoint(-4F, -4F, -7F);

		bodyModel[23].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 24
		bodyModel[23].setRotationPoint(3F, -4F, -7F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 7, 1, 12, 0F,0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 25
		bodyModel[24].setRotationPoint(-4F, -4F, -6F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F,0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
		bodyModel[25].setRotationPoint(3F, -4F, -6F);

		bodyModel[26].addShapeBox(0F, 0F, 0F, 3, 1, 6, 0F,0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 27
		bodyModel[26].setRotationPoint(0F, -3F, -3F);

		bodyModel[27].addShapeBox(0F, 0F, 0F, 5, 1, 6, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
		bodyModel[27].setRotationPoint(3F, -3F, -3F);

		bodyModel[28].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F,0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F); // Box 29
		bodyModel[28].setRotationPoint(3.5F, -2F, -0.5F);

		bodyModel[29].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0.5F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0.5F, 0F, 0.25F); // Box 30
		bodyModel[29].setRotationPoint(6.5F, 1F, -0.5F);

		bodyModel[30].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0.75F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.75F, 0F, 0.25F, 0F, 0F, 0.25F, -0.25F, 0F, 0.25F, -0.25F, 0F, 0.25F, 0F, 0F, 0.25F); // Box 31
		bodyModel[30].setRotationPoint(4F, 2F, -0.5F);

		bodyModel[31].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F,0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0.5F, 0F, 0.25F); // Box 32
		bodyModel[31].setRotationPoint(6.5F, 0F, -0.5F);
	}
}