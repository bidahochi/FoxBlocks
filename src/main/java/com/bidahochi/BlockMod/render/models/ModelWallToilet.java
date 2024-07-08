//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: wall mounter shitter
// Model Creator: bida
// Created on: 07.07.2024 - 19:51:49
// Last changed on: 07.07.2024 - 19:51:49

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelWallToilet extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 64;

	public ModelWallToilet() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[46];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 14
		bodyModel[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 16
		bodyModel[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 18
		bodyModel[3] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 19
		bodyModel[4] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 20
		bodyModel[5] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 21
		bodyModel[6] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 22
		bodyModel[7] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 23
		bodyModel[8] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 24
		bodyModel[9] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 25
		bodyModel[10] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 26
		bodyModel[11] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 27
		bodyModel[12] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 28
		bodyModel[13] = new ModelRendererTurbo(this, 9, 9, textureX, textureY); // Box 29
		bodyModel[14] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Box 30
		bodyModel[15] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 31
		bodyModel[16] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 32
		bodyModel[17] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 33
		bodyModel[18] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 34
		bodyModel[19] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 35
		bodyModel[20] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 36
		bodyModel[21] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 37
		bodyModel[22] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 38
		bodyModel[23] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 39
		bodyModel[24] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 40
		bodyModel[25] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 41
		bodyModel[26] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 42
		bodyModel[27] = new ModelRendererTurbo(this, 89, 17, textureX, textureY); // Box 43
		bodyModel[28] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 44
		bodyModel[29] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 45
		bodyModel[30] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 46
		bodyModel[31] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 47
		bodyModel[32] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 48
		bodyModel[33] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 49
		bodyModel[34] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 50
		bodyModel[35] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 51
		bodyModel[36] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 52
		bodyModel[37] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 53
		bodyModel[38] = new ModelRendererTurbo(this, 105, 25, textureX, textureY); // Box 54
		bodyModel[39] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 55
		bodyModel[40] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 56
		bodyModel[41] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 57
		bodyModel[42] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 58
		bodyModel[43] = new ModelRendererTurbo(this, 27, 34, textureX, textureY); // Box 59
		bodyModel[44] = new ModelRendererTurbo(this, 30, 32, textureX, textureY); // Box 60
		bodyModel[45] = new ModelRendererTurbo(this, 30, 39, textureX, textureY); // Box 61

		bodyModel[0].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F,-0.125F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.125F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
		bodyModel[0].setRotationPoint(-4.5F, 0F, -2F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F,-2F, 0F, -0.625F, 1.5F, 0F, -1F, 0F, 0F, 0F, -0.125F, 0F, 0F, -2F, 0F, -0.5F, 1.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
		bodyModel[1].setRotationPoint(-4.5F, 0F, -4F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, 0.25F, 0.5F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, 0.5F, 0.5F, 0F, -0.5F); // Box 18
		bodyModel[2].setRotationPoint(-2F, 0F, 3F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F,0.5F, 0F, -0.625F, 0F, 0F, 0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0.5F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.25F, 0F, 0F, 0F); // Box 19
		bodyModel[3].setRotationPoint(-2F, 0F, -4F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 6, 2, 1, 0F,0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 20
		bodyModel[4].setRotationPoint(2F, 0F, -4.5F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F,-0.125F, 0F, 0F, 0F, 0F, 0F, 1.5F, 0F, -1F, -2F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 1.5F, 0F, -1F, -2F, 0F, -0.5F); // Box 21
		bodyModel[5].setRotationPoint(-4.5F, 0F, 2F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 6, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		bodyModel[6].setRotationPoint(2F, 0F, 3.5F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 3, 2, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 23
		bodyModel[7].setRotationPoint(5F, 0F, -3.5F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F); // Box 24
		bodyModel[8].setRotationPoint(2F, 0F, -3.5F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F,0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 25
		bodyModel[9].setRotationPoint(2F, 0F, 2.5F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F,0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -2F); // Box 26
		bodyModel[10].setRotationPoint(4F, 0F, -3.5F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F,0F, 0F, -2F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 27
		bodyModel[11].setRotationPoint(4F, 0F, 0.5F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 1.5F, 0F, -1F, 1.5F, 0F, -1F, -1.5F, 0F, 0F); // Box 28
		bodyModel[12].setRotationPoint(-4.5F, 2F, -2F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 1, 4, 6, 0F,0F, 0F, 1.5F, 0F, 0F, 1.5F, 0F, 0F, 1.5F, 0F, 0F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[13].setRotationPoint(7F, 2F, -3F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F,0.5F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.25F, 0F, 0F, 0F, -0.5F, 0F, -1.125F, 0F, 0F, -0.25F, 0F, 0F, 0.75F, -0.5F, 0F, 1F); // Box 30
		bodyModel[14].setRotationPoint(-2F, 2F, -4F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, 0.5F, 0.5F, 0F, -0.5F, -0.5F, 0F, 1F, 0F, 0F, 0.75F, 0F, 0F, -0.25F, -0.5F, 0F, -1.125F); // Box 31
		bodyModel[15].setRotationPoint(-2F, 2F, 3F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F,-2F, 0F, -0.5F, 1.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -1.125F, 2F, 0F, -2F, 1.5F, 0F, 1F, -1.5F, 0F, 0F); // Box 32
		bodyModel[16].setRotationPoint(-4.5F, 2F, -4F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 1.5F, 0F, -1F, -2F, 0F, -0.5F, -1.5F, 0F, 0F, 1.5F, 0F, 1F, 2F, 0F, -2F, -3F, 0F, -1.125F); // Box 33
		bodyModel[17].setRotationPoint(-4.5F, 2F, 2F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,0F, 0F, 1.5F, 0F, 0F, 1.5F, 0F, 0F, 1.5F, 0F, 0F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 34
		bodyModel[18].setRotationPoint(7F, 6F, -1.5F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 3, 2, 1, 0F,0F, 0F, 0.5F, 0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, -0.5F, 0F, -0.625F, -0.5F, 0F, 1F, 0F, 0F, 0.75F); // Box 35
		bodyModel[19].setRotationPoint(2F, 2F, -4F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 3, 2, 1, 0F,0F, 0F, -0.25F, 0F, 0F, 0F, 0.5F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.75F, -0.5F, 0F, 1F, -0.5F, 0F, -0.625F, 0F, 0F, -0.25F); // Box 36
		bodyModel[20].setRotationPoint(2F, 2F, 3F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -0.5F, 1.5F, 0F, -1F, 1.5F, 0F, 1F, -1.5F, 0F, 0F, -3F, 0F, -0.625F, 2F, 0F, -2F); // Box 37
		bodyModel[21].setRotationPoint(6.5F, 2F, 2F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F,1.5F, 0F, -1F, -2F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -2F, -3F, 0F, -0.625F, -1.5F, 0F, 0F, 1.5F, 0F, 1F); // Box 38
		bodyModel[22].setRotationPoint(6.5F, 2F, -4F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.5F, 0F, -1F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 1.5F, 0F, -1F); // Box 39
		bodyModel[23].setRotationPoint(6.5F, 2F, -2F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 40
		bodyModel[24].setRotationPoint(6F, 2F, -2F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 9, 1, 4, 0F,1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 41
		bodyModel[25].setRotationPoint(-1.5F, 4F, -2F);

		bodyModel[26].addShapeBox(0F, 0F, 0F, 4, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 42
		bodyModel[26].setRotationPoint(-0.5F, 4F, -3F);

		bodyModel[27].addShapeBox(0F, 0F, 0F, 4, 1, 1, 0F,2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F); // Box 43
		bodyModel[27].setRotationPoint(-0.5F, 4F, 2F);

		bodyModel[28].addShapeBox(0F, 0F, 0F, 5, 1, 2, 0F,1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 44
		bodyModel[28].setRotationPoint(2F, 5F, -1F);

		bodyModel[29].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 45
		bodyModel[29].setRotationPoint(-1.5F, -1F, -4F);

		bodyModel[30].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, -0.5F, -1.75F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 1.5F, 0F, 0F, -1.75F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1.5F); // Box 46
		bodyModel[30].setRotationPoint(-4.5F, -1F, -4F);

		bodyModel[31].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0F); // Box 47
		bodyModel[31].setRotationPoint(-1.5F, -1F, 3F);

		bodyModel[32].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,-0.5F, -0.5F, 1.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -1.75F, -0.5F, 0F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.75F); // Box 48
		bodyModel[32].setRotationPoint(-4.5F, -1F, 3F);

		bodyModel[33].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F,0F, -0.5F, 0.5F, 0F, -0.5F, -0.5F, -0.5F, -0.5F, 0F, 0F, -0.5F, -1F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, -1F); // Box 49
		bodyModel[33].setRotationPoint(1.5F, -1F, -4F);

		bodyModel[34].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F,0F, -0.5F, -1F, -0.5F, -0.5F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0.5F, 0F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F); // Box 50
		bodyModel[34].setRotationPoint(1.5F, -1F, 2F);

		bodyModel[35].addShapeBox(0F, 0F, 0F, 2, 1, 4, 0F,0F, -0.5F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F); // Box 51
		bodyModel[35].setRotationPoint(4F, -1F, -2F);

		bodyModel[36].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F,0F, -0.5F, 0F, -0.25F, -0.25F, 0F, -1.5F, -0.5F, 0.5F, 0F, -0.5F, -1F, 0F, 0F, 0F, -0.25F, 0F, 0F, -1.5F, 0F, 0.5F, 0F, 0F, -1F); // Box 52
		bodyModel[36].setRotationPoint(4F, -1F, 2F);

		bodyModel[37].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F,0F, -0.5F, -1F, -1.5F, -0.5F, 0.5F, -0.25F, -0.25F, 0F, 0F, -0.5F, 0F, 0F, 0F, -1F, -1.5F, 0F, 0.5F, -0.25F, 0F, 0F, 0F, 0F, 0F); // Box 53
		bodyModel[37].setRotationPoint(4F, -1F, -3F);

		bodyModel[38].addShapeBox(0F, 0F, 0F, 2, 7, 2, 0F,-0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F); // Box 54
		bodyModel[38].setRotationPoint(6F, -7F, -1F);

		bodyModel[39].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F); // Box 55
		bodyModel[39].setRotationPoint(6F, -7.5F, -1F);

		bodyModel[40].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F,-0.125F, -0.125F, 0.125F, -0.125F, -0.125F, 0.125F, -0.125F, -0.125F, 0.125F, -0.125F, -0.125F, 0.125F, -0.125F, -0.125F, 0.125F, -0.125F, -0.125F, 0.125F, -0.125F, -0.125F, 0.125F, -0.125F, -0.125F, 0.125F); // Box 56
		bodyModel[40].setRotationPoint(6.5F, -6F, -3F);

		bodyModel[41].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F,-0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F, -0.375F, 0F, -0.375F); // Box 57
		bodyModel[41].setRotationPoint(6F, -5F, 0F);
		bodyModel[41].rotateAngleX = 1.57079633F;

		bodyModel[42].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F,0F, 0F, -0.375F, 0F, 0F, -0.375F, 0F, 0F, -0.375F, 0F, 0F, -0.375F, 0F, 0F, -0.375F, 0F, 0F, -0.375F, 0F, 0F, -0.375F, 0F, 0F, -0.375F); // Box 58
		bodyModel[42].setRotationPoint(7.63F, -5F, 2F);
		bodyModel[42].rotateAngleX = 1.57079633F;

		bodyModel[43].addBox(0F, 0F, 0F, 9, 0, 4, 0F); // Box 59
		bodyModel[43].setRotationPoint(-4F, 2F, -2F);

		bodyModel[44].addShapeBox(0F, 0F, 0F, 9, 0, 1, 0F,0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0.5F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0.5F, 0F, 0F, 0F); // Box 60
		bodyModel[44].setRotationPoint(-3F, 2F, 2F);

		bodyModel[45].addShapeBox(0F, 0F, 0F, 9, 0, 1, 0F,0F, 0F, 0F, -0.5F, 0F, 0.5F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0.5F, 0F, 0F, 0F, 0.5F, 0F, 0F); // Box 61
		bodyModel[45].setRotationPoint(-3F, 2F, -3F);
	}
}