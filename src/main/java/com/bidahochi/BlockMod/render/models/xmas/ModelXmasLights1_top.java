//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2024 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: xmas_lights_1_top
// Model Creator: bida
// Created on: 09.11.2024 - 21:40:25
// Last changed on: 09.11.2024 - 21:40:25

package com.bidahochi.BlockMod.render.models.xmas; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class ModelXmasLights1_top extends ModelConverter //Same as Filename
{
	int textureX = 32;
	int textureY = 32;

	public ModelXmasLights1_top() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[11];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 0, -15, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 21, 9, textureX, textureY, "lamp"); // Box 3 light
		bodyModel[2] = new ModelRendererTurbo(this, 1, 9, textureX, textureY, "lamp"); // Box 4 light
		bodyModel[3] = new ModelRendererTurbo(this, 16, 9, textureX, textureY, "lamp"); // Box 5 light
		bodyModel[4] = new ModelRendererTurbo(this, 6, 9, textureX, textureY, "lamp"); // Box 6 light
		bodyModel[5] = new ModelRendererTurbo(this, 11, 9, textureX, textureY, "lamp"); // Box 7 light
		bodyModel[6] = new ModelRendererTurbo(this, 11, 6, textureX, textureY); // Box 8
		bodyModel[7] = new ModelRendererTurbo(this, 6, 6, textureX, textureY); // Box 9
		bodyModel[8] = new ModelRendererTurbo(this, 16, 6, textureX, textureY); // Box 10
		bodyModel[9] = new ModelRendererTurbo(this, 1, 6, textureX, textureY); // Box 11
		bodyModel[10] = new ModelRendererTurbo(this, 21, 6, textureX, textureY); // Box 12

		bodyModel[0].addShapeBox(0F, 0F, 0F, 0, 4, 16, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 1
		bodyModel[0].setRotationPoint(8F, -5F, -8F);
		bodyModel[0].rotateAngleZ = -0.31415927F;

		bodyModel[1].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 3 light
		bodyModel[1].setRotationPoint(7F, -4.53F, -7F);
		bodyModel[1].rotateAngleZ = -0.01745329F;

		bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 4 light
		bodyModel[2].setRotationPoint(7F, -4.53F, 6F);
		bodyModel[2].rotateAngleZ = -0.03490659F;

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 5 light
		bodyModel[3].setRotationPoint(7F, -4.06F, -3.75F);
		bodyModel[3].rotateAngleZ = 0.01745329F;

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 6 light
		bodyModel[4].setRotationPoint(7F, -4.06F, 2.75F);
		bodyModel[4].rotateAngleZ = -0.01745329F;

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 7 light
		bodyModel[5].setRotationPoint(7F, -3.6F, -0.5F);
		bodyModel[5].rotateAngleZ = -0.03490659F;

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F); // Box 8
		bodyModel[6].setRotationPoint(7F, -3.6F, -0.5F);
		bodyModel[6].rotateAngleZ = -0.03490659F;

		bodyModel[7].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F); // Box 9
		bodyModel[7].setRotationPoint(7F, -4.06F, 2.75F);
		bodyModel[7].rotateAngleZ = -0.01745329F;

		bodyModel[8].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F); // Box 10
		bodyModel[8].setRotationPoint(7F, -4.06F, -3.75F);
		bodyModel[8].rotateAngleZ = 0.01745329F;

		bodyModel[9].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F); // Box 11
		bodyModel[9].setRotationPoint(7F, -4.53F, 6F);
		bodyModel[9].rotateAngleZ = -0.03490659F;

		bodyModel[10].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F, 0.05F, -0.5F, 0.05F); // Box 12
		bodyModel[10].setRotationPoint(7F, -4.53F, -7F);
		bodyModel[10].rotateAngleZ = -0.01745329F;
	}
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		for(ModelRendererTurbo m :bodyModel) {
			if(m.boxName.equals("lamp")){
				Minecraft.getMinecraft().entityRenderer.disableLightmap(1D);
				m.render(f5);
				Minecraft.getMinecraft().entityRenderer.enableLightmap(1D);
			}else{
				m.render(f5);
			}
		}
	}
}