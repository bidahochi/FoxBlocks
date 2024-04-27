//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: wpole_end_wire
// Model Creator: 
// Created on: 05.07.2020 - 22:04:54
// Last changed on: 05.07.2020 - 22:04:54

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelwpole_end_wire extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 128;

	public Modelwpole_end_wire() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[28];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 19, 21, textureX, textureY); // Box 3
		bodyModel[2] = new ModelRendererTurbo(this, 24, 10, textureX, textureY); // Box 4
		bodyModel[3] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[4] = new ModelRendererTurbo(this, 19, 21, textureX, textureY); // Box 3
		bodyModel[5] = new ModelRendererTurbo(this, 24, 10, textureX, textureY); // Box 4
		bodyModel[6] = new ModelRendererTurbo(this, 2, 1, textureX, textureY); // Box 2
		bodyModel[7] = new ModelRendererTurbo(this, 2, 1, textureX, textureY); // Box 2
		bodyModel[8] = new ModelRendererTurbo(this, 1, 27, textureX, textureY); // Box 1
		bodyModel[9] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 5
		bodyModel[10] = new ModelRendererTurbo(this, 13, 95, textureX, textureY); // Box 6
		bodyModel[11] = new ModelRendererTurbo(this, 24, 4, textureX, textureY); // Box 8
		bodyModel[12] = new ModelRendererTurbo(this, 24, 4, textureX, textureY); // Box 12
		bodyModel[13] = new ModelRendererTurbo(this, 13, 91, textureX, textureY); // Box 22
		bodyModel[14] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 28
		bodyModel[15] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 29
		bodyModel[16] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 5
		bodyModel[17] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 28
		bodyModel[18] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 29
		bodyModel[19] = new ModelRendererTurbo(this, -42, 1, textureX, textureY); // Box 1
		bodyModel[20] = new ModelRendererTurbo(this, 19, 21, textureX, textureY); // Box 3
		bodyModel[21] = new ModelRendererTurbo(this, 24, 10, textureX, textureY); // Box 4
		bodyModel[22] = new ModelRendererTurbo(this, 19, 21, textureX, textureY); // Box 3
		bodyModel[23] = new ModelRendererTurbo(this, 24, 10, textureX, textureY); // Box 4
		bodyModel[24] = new ModelRendererTurbo(this, 24, -2, textureX, textureY); // Box 1
		bodyModel[25] = new ModelRendererTurbo(this, 24, 4, textureX, textureY); // Box 12
		bodyModel[26] = new ModelRendererTurbo(this, 24, 4, textureX, textureY); // Box 12
		bodyModel[27] = new ModelRendererTurbo(this, 24, 4, textureX, textureY); // Box 12

		bodyModel[0].addBox(0F, 0F, 0F, 4, 81, 4, 0F); // Box 0
		bodyModel[0].setRotationPoint(-42F, -67F, 14.5F);

		bodyModel[1].addBox(0F, 0F, 0F, 1, 0, 2, 0F); // Box 3
		bodyModel[1].setRotationPoint(-40.5F, -61F, 18.5F);

		bodyModel[2].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 4
		bodyModel[2].setRotationPoint(-40.5F, -61.5F, 18.5F);

		bodyModel[3].addBox(0F, 0F, 0F, 4, 81, 4, 0F); // Box 0
		bodyModel[3].setRotationPoint(-42F, -67F, -49.5F);

		bodyModel[4].addBox(0F, 0F, 0F, 1, 0, 2, 0F); // Box 3
		bodyModel[4].setRotationPoint(-40.5F, -61F, -51.5F);

		bodyModel[5].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 4
		bodyModel[5].setRotationPoint(-40.5F, -61.5F, -50.5F);

		bodyModel[6].addBox(0F, 0F, 0F, 1, 0, 19, 0F); // Box 2
		bodyModel[6].setRotationPoint(-40.5F, -48F, 1.5F);
		bodyModel[6].rotateAngleX = 0.78539816F;

		bodyModel[7].addBox(0F, 0F, 0F, 1, 0, 19, 0F); // Box 2
		bodyModel[7].setRotationPoint(-40.5F, -48F, -32.5F);
		bodyModel[7].rotateAngleX = 2.35619449F;

		bodyModel[8].addBox(0F, 0F, 0F, 2, 2, 60, 0F); // Box 1
		bodyModel[8].setRotationPoint(-41F, -48F, -45.5F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 5
		bodyModel[9].setRotationPoint(-41F, -45F, -10F);

		bodyModel[10].addBox(0F, 0F, 0F, 48, 1, 2, 0F); // Box 6
		bodyModel[10].setRotationPoint(-40F, -40F, -17F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.05F); // Box 8
		bodyModel[11].setRotationPoint(7.5F, -43.25F, -17F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 12
		bodyModel[12].setRotationPoint(-3F, -43.5F, -17F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 48, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		bodyModel[13].setRotationPoint(-40F, -44F, -17F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 28
		bodyModel[14].setRotationPoint(-41F, -46F, -10F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[15].setRotationPoint(-40.5F, -46F, -9.5F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 5
		bodyModel[16].setRotationPoint(-41F, -45F, -24F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 28
		bodyModel[17].setRotationPoint(-41F, -46F, -24F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		bodyModel[18].setRotationPoint(-40.5F, -46F, -23.5F);

		bodyModel[19].addBox(0F, 0F, 0F, 1, 0, 60, 0F); // Box 1
		bodyModel[19].setRotationPoint(-40.5F, -64F, -45.5F);

		bodyModel[20].addBox(0F, 0F, 0F, 1, 0, 2, 0F); // Box 3
		bodyModel[20].setRotationPoint(-40.5F, -64F, -51.5F);

		bodyModel[21].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 4
		bodyModel[21].setRotationPoint(-40.5F, -64.5F, -50.5F);

		bodyModel[22].addBox(0F, 0F, 0F, 1, 0, 2, 0F); // Box 3
		bodyModel[22].setRotationPoint(-40.5F, -64F, 18.5F);

		bodyModel[23].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 4
		bodyModel[23].setRotationPoint(-40.5F, -64.5F, 18.5F);

		bodyModel[24].addBox(0F, 0F, 0F, 0, 5, 15, 0F); // Box 1
		bodyModel[24].setRotationPoint(-40.01F, -44F, -23.5F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 12
		bodyModel[25].setRotationPoint(-13F, -43.5F, -17F);

		bodyModel[26].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 12
		bodyModel[26].setRotationPoint(-23F, -43.5F, -17F);

		bodyModel[27].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F, 0F, 0.5F, -0.05F); // Box 12
		bodyModel[27].setRotationPoint(-33F, -43.5F, -17F);
	}
}