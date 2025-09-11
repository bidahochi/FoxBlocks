//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2021 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: 
// Model Creator: 
// Created on: 30.12.2020 - 15:57:20
// Last changed on: 30.12.2020 - 15:57:20

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelBreakerBox extends ModelConverter//Same as Filename
{
	int textureX = 64;
	int textureY = 32;

	public ModelBreakerBox() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[19];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 6, 14, textureX, textureY); // Box 2
		bodyModel[1] = new ModelRendererTurbo(this, 1, 14, textureX, textureY); // Box 3
		bodyModel[2] = new ModelRendererTurbo(this, 33, 2, textureX, textureY); // Box 4
		bodyModel[3] = new ModelRendererTurbo(this, 10, 23, textureX, textureY); // Box 5
		bodyModel[4] = new ModelRendererTurbo(this, 10, 15, textureX, textureY); // Box 6
		bodyModel[5] = new ModelRendererTurbo(this, 26, 17, textureX, textureY); // Box 7
		bodyModel[6] = new ModelRendererTurbo(this, 26, 17, textureX, textureY); // Box 8
		bodyModel[7] = new ModelRendererTurbo(this, 26, 17, textureX, textureY); // Box 9
		bodyModel[8] = new ModelRendererTurbo(this, 26, 17, textureX, textureY); // Box 10
		bodyModel[9] = new ModelRendererTurbo(this, 19, 17, textureX, textureY); // Box 11
		bodyModel[10] = new ModelRendererTurbo(this, 19, 17, textureX, textureY); // Box 12
		bodyModel[11] = new ModelRendererTurbo(this, 19, 17, textureX, textureY); // Box 13
		bodyModel[12] = new ModelRendererTurbo(this, 19, 17, textureX, textureY); // Box 14
		bodyModel[13] = new ModelRendererTurbo(this, 26, 17, textureX, textureY); // Box 15
		bodyModel[14] = new ModelRendererTurbo(this, 19, 17, textureX, textureY); // Box 16
		bodyModel[15] = new ModelRendererTurbo(this, 22, 10, textureX, textureY); // Box 17
		bodyModel[16] = new ModelRendererTurbo(this, 23, -7, textureX, textureY); // Box 18
		bodyModel[17] = new ModelRendererTurbo(this, 1, -9, textureX, textureY); // Box 19
		bodyModel[18] = new ModelRendererTurbo(this, 1, -9, textureX, textureY); // Box 20

		bodyModel[0].addBox(0F, 0F, 0F, 1, 16, 1, 0F); // Box 2
		bodyModel[0].setRotationPoint(0F, -16F, -4F);

		bodyModel[1].addBox(0F, 0F, 0F, 1, 16, 1, 0F); // Box 3
		bodyModel[1].setRotationPoint(0F, -16F, 3F);

		bodyModel[2].addBox(0F, 0F, 0F, 7, 16, 8, 0F); // Box 4
		bodyModel[2].setRotationPoint(1F, -16F, -4F);

		bodyModel[3].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 5
		bodyModel[3].setRotationPoint(0F, -1F, -3F);

		bodyModel[4].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 6
		bodyModel[4].setRotationPoint(0F, -16F, -3F);

		bodyModel[5].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 7
		bodyModel[5].setRotationPoint(0.5F, -14F, -3F);

		bodyModel[6].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 8
		bodyModel[6].setRotationPoint(0.5F, -12F, -3F);

		bodyModel[7].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 9
		bodyModel[7].setRotationPoint(0.5F, -10F, -3F);

		bodyModel[8].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 10
		bodyModel[8].setRotationPoint(0.5F, -8F, -3F);

		bodyModel[9].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 11
		bodyModel[9].setRotationPoint(0.5F, -8F, 1F);

		bodyModel[10].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 12
		bodyModel[10].setRotationPoint(0.5F, -10F, 1F);

		bodyModel[11].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 13
		bodyModel[11].setRotationPoint(0.5F, -12F, 1F);

		bodyModel[12].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 14
		bodyModel[12].setRotationPoint(0.5F, -14F, 1F);

		bodyModel[13].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 15
		bodyModel[13].setRotationPoint(0.5F, -6F, -3F);

		bodyModel[14].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 16
		bodyModel[14].setRotationPoint(0.5F, -6F, 1F);

		bodyModel[15].addBox(0F, 0F, 0F, 1, 2, 4, 0F); // Box 17
		bodyModel[15].setRotationPoint(0.5F, -3F, -2F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 0, 8, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, -6F, -6F, 0F, -6F, -6F); // Box 18
		bodyModel[16].setRotationPoint(0.49F, -3F, -1F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 0, 10, 10, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, -6F, -6F, 0F, -6F, -6F); // Box 19
		bodyModel[17].setRotationPoint(6F, -13F, -4.01F);
		bodyModel[17].rotateAngleY = 1.57079633F;

		bodyModel[18].addShapeBox(0F, 0F, 0F, 0, 10, 10, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, -6F, -6F, 0F, -6F, -6F); // Box 20
		bodyModel[18].setRotationPoint(6F, -13F, 4.01F);
		bodyModel[18].rotateAngleY = 1.57079633F;
	}
	/*@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		for(int i = 0; i < 19; i++)
		{
			bodyModel[i].render(f5);
		}
	}*/
}