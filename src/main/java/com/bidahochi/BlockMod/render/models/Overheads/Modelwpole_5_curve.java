//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: wpole_5_curve
// Model Creator: 
// Created on: 10.09.2023 - 17:53:44
// Last changed on: 10.09.2023 - 17:53:44

package com.bidahochi.BlockMod.render.models.Overheads; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class Modelwpole_5_curve extends ModelConverter //Same as Filename
{
	int textureX = 256;
	int textureY = 128;

	public Modelwpole_5_curve() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[27];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 76
		bodyModel[1] = new ModelRendererTurbo(this, 225, 54, textureX, textureY); // Box 77
		bodyModel[2] = new ModelRendererTurbo(this, 222, 57, textureX, textureY); // Box 78
		bodyModel[3] = new ModelRendererTurbo(this, 190, 60, textureX, textureY); // Box 79
		bodyModel[4] = new ModelRendererTurbo(this, 176, 58, textureX, textureY); // Box 80
		bodyModel[5] = new ModelRendererTurbo(this, 206, 51, textureX, textureY); // Box 81
		bodyModel[6] = new ModelRendererTurbo(this, 221, 51, textureX, textureY); // Box 82
		bodyModel[7] = new ModelRendererTurbo(this, 212, 49, textureX, textureY); // Box 83
		bodyModel[8] = new ModelRendererTurbo(this, 212, 53, textureX, textureY); // Box 84
		bodyModel[9] = new ModelRendererTurbo(this, 117, 64, textureX, textureY); // Box 8
		bodyModel[10] = new ModelRendererTurbo(this, 138, 64, textureX, textureY); // Box 9
		bodyModel[11] = new ModelRendererTurbo(this, 131, 64, textureX, textureY); // Box 10
		bodyModel[12] = new ModelRendererTurbo(this, 124, 64, textureX, textureY); // Box 11
		bodyModel[13] = new ModelRendererTurbo(this, 117, 58, textureX, textureY); // Box 13
		bodyModel[14] = new ModelRendererTurbo(this, 138, 56, textureX, textureY); // Box 14
		bodyModel[15] = new ModelRendererTurbo(this, 131, 57, textureX, textureY); // Box 10
		bodyModel[16] = new ModelRendererTurbo(this, 124, 58, textureX, textureY); // Box 11
		bodyModel[17] = new ModelRendererTurbo(this, 142, 110, textureX, textureY); // Box 9
		bodyModel[18] = new ModelRendererTurbo(this, 142, 110, textureX, textureY); // Box 9
		bodyModel[19] = new ModelRendererTurbo(this, 122, 90, textureX, textureY); // Box 9
		bodyModel[20] = new ModelRendererTurbo(this, 67, 72, textureX, textureY); // Box 9
		bodyModel[21] = new ModelRendererTurbo(this, 67, 124, textureX, textureY); // Box 9
		bodyModel[22] = new ModelRendererTurbo(this, 72, 118, textureX, textureY); // Box 9
		bodyModel[23] = new ModelRendererTurbo(this, 52, 118, textureX, textureY); // Box 9
		bodyModel[24] = new ModelRendererTurbo(this, 72, 118, textureX, textureY); // Box 9
		bodyModel[25] = new ModelRendererTurbo(this, 131, 64, textureX, textureY); // Box 10
		bodyModel[26] = new ModelRendererTurbo(this, 131, 57, textureX, textureY); // Box 10

		bodyModel[0].addBox(-2F, 0F, -2F, 4, 81, 4, 0F); // Box 76
		bodyModel[0].setRotationPoint(-66.5F, -71F, -14.5F);
		bodyModel[0].rotateAngleY = 0.80285146F;

		bodyModel[1].addBox(-0.5F, 0F, 2F, 1, 1, 1, 0F); // Box 77
		bodyModel[1].setRotationPoint(-66.5F, -60.5F, -14.5F);
		bodyModel[1].rotateAngleY = 0.80285146F;

		bodyModel[2].addBox(-0.5F, 0F, 2F, 1, 0, 2, 0F); // Box 78
		bodyModel[2].setRotationPoint(-66.5F, -60F, -14.5F);
		bodyModel[2].rotateAngleY = 0.80285146F;

		bodyModel[3].addBox(-0.5F, -14.15F, -28F, 1, 0, 34, 0F); // Box 79
		bodyModel[3].setRotationPoint(-66.5F, -45F, -14.5F);
		bodyModel[3].rotateAngleX = 0.4712389F;
		bodyModel[3].rotateAngleY = 0.80285146F;

		bodyModel[4].addBox(-1F, 0F, -40F, 2, 2, 38, 0F); // Box 80
		bodyModel[4].setRotationPoint(-66.5F, -45F, -14.5F);
		bodyModel[4].rotateAngleY = 0.80285146F;

		bodyModel[5].addShapeBox(-0.5F, 0F, -33.5F, 1, 1, 2, 0F,0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F, 0F, 0F, 0.125F); // Box 81
		bodyModel[5].setRotationPoint(-66.5F, -48F, -14.5F);
		bodyModel[5].rotateAngleY = 0.80285146F;

		bodyModel[6].addShapeBox(-1F, 0F, -33F, 1, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 82
		bodyModel[6].setRotationPoint(-66.05F, -47F, -14.05F);
		bodyModel[6].rotateAngleY = 0.80285146F;

		bodyModel[7].addShapeBox(-1F, 0F, -33.5F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 83
		bodyModel[7].setRotationPoint(-66.5F, -47F, -14.5F);
		bodyModel[7].rotateAngleY = 0.80285146F;

		bodyModel[8].addShapeBox(-1F, 0F, -33.5F, 2, 1, 2, 0F,0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F); // Box 84
		bodyModel[8].setRotationPoint(-66.5F, -46F, -14.5F);
		bodyModel[8].rotateAngleY = 0.80285146F;

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F,0F, 0F, -0.05F, -0.5F, 0F, -0.05F, -0.5F, 0F, -0.05F, 0F, 0F, -0.15F, 0F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, -0.5F, 0.25F, -0.05F, 0F, 0.25F, -0.15F); // Box 8
		bodyModel[9].setRotationPoint(7.5F, -43.25F, -17F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 1, 6, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.15F, 0F, 0F, -0.15F); // Box 9
		bodyModel[10].setRotationPoint(-33F, -45.75F, -33.6F);
		bodyModel[10].rotateAngleY = 0.38397244F;

		bodyModel[11].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F); // Box 10
		bodyModel[11].setRotationPoint(-12F, -44.5F, -25.17F);
		bodyModel[11].rotateAngleY = 0.38397244F;

		bodyModel[12].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0.125F, -0.1F, 0F, 0.125F, -0.1F, 0F, 0.125F, -0.1F, 0F, 0.125F, -0.1F); // Box 11
		bodyModel[12].setRotationPoint(-2F, -43.75F, -21.1F);
		bodyModel[12].rotateAngleY = 0.38397244F;

		bodyModel[13].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F,-0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.15F, 0F, -0.5F, -0.05F, 0F, 0F, -0.05F, 0F, 0F, -0.05F, 0F, -0.5F, -0.15F, 0F, -0.5F); // Box 13
		bodyModel[13].setRotationPoint(-65F, -43.5F, -88F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 2, 6, 1, 0F,0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0.1F, 0F, 0F); // Box 14
		bodyModel[14].setRotationPoint(-48.3F, -45.75F, -47F);
		bodyModel[14].rotateAngleY = -0.38397244F;

		bodyModel[15].addShapeBox(0F, 0F, 0F, 2, 5, 1, 0F,-0.15F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.15F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 10
		bodyModel[15].setRotationPoint(-52.5F, -45F, -57F);
		bodyModel[15].rotateAngleY = -0.38397244F;

		bodyModel[16].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F,-0.1F, 0F, 0F, -0.15F, 0F, 0F, -0.15F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0.125F, 0F, -0.1F, 0.125F, 0F, -0.1F, 0.125F, 0F, -0.1F, 0.125F, 0F); // Box 11
		bodyModel[16].setRotationPoint(-61.45F, -43.5F, -79F);
		bodyModel[16].rotateAngleY = -0.38397244F;

		bodyModel[17].addShapeBox(0F, 0F, 0F, 2, 1, 10, 0F,0F, 0F, 0F, 0F, 0F, 0F, 4F, 2F, 0F, -4.5F, 2F, 1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, -2F, 0F, -4.5F, -2F, 1.5F); // Box 9
		bodyModel[17].setRotationPoint(-48.5F, -46F, -47.5F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 2, 1, 10, 0F,0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F); // Box 9
		bodyModel[18].setRotationPoint(-65F, -44F, -88F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 2, 1, 30, 0F,0F, 0F, 0F, 0F, 0F, 0F, 12.5F, 2F, 0.5F, -12.5F, 2F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 12.5F, -2F, 0.5F, -12.5F, -2F, 0.5F); // Box 9
		bodyModel[19].setRotationPoint(-61F, -44F, -78F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 2, 1, 50, 0F,0F, 0F, 0F, 0F, 0F, 0F, 20.5F, 0F, 0.5F, -21F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 20.5F, 0F, 0.5F, -21F, 0F, 2F); // Box 9
		bodyModel[20].setRotationPoint(-65F, -40F, -88F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 50, 1, 2, 0F,0F, 0F, 0F, 0.5F, 0F, -20.5F, 0.5F, 0F, 20.5F, 1.5F, 0F, -0.5F, 0F, 0F, 0F, 0.5F, 0F, -20.5F, 0.5F, 0F, 20.5F, 1.5F, 0F, -0.5F); // Box 9
		bodyModel[21].setRotationPoint(-42.5F, -40F, -37.5F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, 0F, 0F, 0F, -2F, -4F, 0F, -2F, 4F, 1.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 2F, -4F, 0F, 2F, 4F, 1.5F, 0F, -0.5F); // Box 9
		bodyModel[22].setRotationPoint(-42.5F, -48F, -37.5F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 30, 1, 2, 0F,0F, 0F, 0F, 0.5F, -2F, -12.5F, 0.5F, -2F, 12.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 2F, -12.5F, 0.5F, 2F, 12.5F, 0F, 0F, 0F); // Box 9
		bodyModel[23].setRotationPoint(-32.5F, -46F, -33.5F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F); // Box 9
		bodyModel[24].setRotationPoint(-2F, -44F, -21F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F); // Box 10
		bodyModel[25].setRotationPoint(-22F, -45F, -29.27F);
		bodyModel[25].rotateAngleY = 0.38397244F;

		bodyModel[26].addShapeBox(0F, 0F, 0F, 2, 5, 1, 0F,-0.1F, 0F, 0F, -0.15F, 0F, 0F, -0.15F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 10
		bodyModel[26].setRotationPoint(-56.95F, -44.5F, -68F);
		bodyModel[26].rotateAngleY = -0.38397244F;
	}
}