//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: 18_slope_simp
// Model Creator: 
// Created on: 28.03.2022 - 18:46:20
// Last changed on: 28.03.2022 - 18:46:20

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelnpole_18_slope extends ModelConverter //Same as Filename
{
	int textureX = 512;
	int textureY = 32;

	public Modelnpole_18_slope() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[33];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 15, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 2
		bodyModel[2] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[3] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 2
		bodyModel[4] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[5] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[6] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[7] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[8] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[9] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[10] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[11] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[12] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[13] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[14] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[15] = new ModelRendererTurbo(this, 1, 15, textureX, textureY); // Box 0
		bodyModel[16] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[17] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[18] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[19] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[20] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[21] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[22] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[23] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[24] = new ModelRendererTurbo(this, 1, 2, textureX, textureY); // Box 0
		bodyModel[25] = new ModelRendererTurbo(this, 1, 2, textureX, textureY); // Box 0
		bodyModel[26] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[27] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[28] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[29] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[30] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[31] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3
		bodyModel[32] = new ModelRendererTurbo(this, 2, 7, textureX, textureY); // Box 3

		bodyModel[0].addShapeBox(0F, 0F, 0F, 144, 1, 2, 0F,0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, 8F, 0F, 0F, 0F, 0F); // Box 0
		bodyModel[0].setRotationPoint(-136F, -48F, -17F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.05F); // Box 2
		bodyModel[1].setRotationPoint(7.5F, -43.13F, -17F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 3
		bodyModel[2].setRotationPoint(-106F, -50F, -17F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,-0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F); // Box 2
		bodyModel[3].setRotationPoint(-280.5F, -59F, -17F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 3
		bodyModel[4].setRotationPoint(-166F, -53.2F, -17F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[5].setRotationPoint(-226F, -56.4F, -17F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[6].setRotationPoint(-216F, -55.8F, -17F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[7].setRotationPoint(-206F, -55.2F, -17F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[8].setRotationPoint(-196F, -54.7F, -17F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[9].setRotationPoint(-186F, -54.2F, -17F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[10].setRotationPoint(-86F, -48.75F, -17F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[11].setRotationPoint(-76F, -48.2F, -17F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[12].setRotationPoint(-66F, -47.6F, -17F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[13].setRotationPoint(-56F, -47F, -17F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[14].setRotationPoint(-46F, -46.5F, -17F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 144, 1, 2, 0F,0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, 8F, 0F, 0F, 0F, 0F); // Box 0
		bodyModel[15].setRotationPoint(-280F, -56F, -17F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[16].setRotationPoint(-36F, -45.9F, -17F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[17].setRotationPoint(-26F, -45.3F, -17F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[18].setRotationPoint(-16F, -44.8F, -17F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[19].setRotationPoint(-6F, -44.2F, -17F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[20].setRotationPoint(-266F, -58.6F, -17F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[21].setRotationPoint(-256F, -58.2F, -17F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[22].setRotationPoint(-246F, -57.6F, -17F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[23].setRotationPoint(-236F, -57F, -17F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 144, 1, 2, 0F,0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, 8F, 0F, 0F, 0F, 0F); // Box 0
		bodyModel[24].setRotationPoint(-136F, -52F, -17F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 144, 1, 2, 0F,0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, 8F, 0F, 0F, 0F, 0F); // Box 0
		bodyModel[25].setRotationPoint(-280F, -60F, -17F);

		bodyModel[26].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 3
		bodyModel[26].setRotationPoint(-136.5F, -51.5F, -17F);

		bodyModel[27].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[27].setRotationPoint(-96F, -49.2F, -17F);

		bodyModel[28].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[28].setRotationPoint(-176F, -53.6F, -17F);

		bodyModel[29].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 3
		bodyModel[29].setRotationPoint(-146F, -52.1F, -17F);

		bodyModel[30].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[30].setRotationPoint(-156F, -52.5F, -17F);

		bodyModel[31].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F, 0F, 0.125F, -0.05F); // Box 3
		bodyModel[31].setRotationPoint(-116F, -50.4F, -17F);

		bodyModel[32].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F); // Box 3
		bodyModel[32].setRotationPoint(-126F, -50.8F, -17F);
	}
}