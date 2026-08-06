//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: GaggleCam
// Model Creator: bida
// Created on: 06.08.2026 - 10:26:25
// Last changed on: 06.08.2026 - 10:26:25

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class Modelgagglecam extends ModelConverter //Same as Filename
{
	int textureX = 32;
	int textureY = 64;

	public Modelgagglecam() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[9];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);

		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 29, textureX, textureY); // Box 1 pole
		bodyModel[1] = new ModelRendererTurbo(this, 10, 27, textureX, textureY); // Box 3 camera
		bodyModel[2] = new ModelRendererTurbo(this, 17, 26, textureX, textureY, "cull"); // Box 4 cull
		bodyModel[3] = new ModelRendererTurbo(this, 9, 28, textureX, textureY); // Box 5 camera bottom
		bodyModel[4] = new ModelRendererTurbo(this, 2, 26, textureX, textureY); // Box 7 mount
		bodyModel[5] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 8 solar
		bodyModel[6] = new ModelRendererTurbo(this, 14, 5, textureX, textureY); // Box 9 battery
		bodyModel[7] = new ModelRendererTurbo(this, 21, 32, textureX, textureY); // Box 10 wire
		bodyModel[8] = new ModelRendererTurbo(this, 21, 30, textureX, textureY); // Box 11 wire

		bodyModel[0].addShapeBox(0F, 0F, 0F, 2, 32, 2, 0F,-0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F, -0.125F, 0F, -0.125F); // Box 1 pole
		bodyModel[0].setRotationPoint(-1F, -22F, -1F);

		bodyModel[1].addShapeBox(0F, -2F, 0F, 1, 8, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -4F, -2F, 0F, -4F, -2F); // Box 3 camera
		bodyModel[1].setRotationPoint(-3F, -15F, -1.5F);
		bodyModel[1].rotateAngleY = 0.29670597F;
		bodyModel[1].rotateAngleZ = 0.15707963F;

		bodyModel[2].addShapeBox(-1F, -2F, 0F, 1, 2, 2, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 4 cull
		bodyModel[2].setRotationPoint(-3F, -15F, -1.5F);
		bodyModel[2].rotateAngleY = 0.29670597F;
		bodyModel[2].rotateAngleZ = 0.15707963F;

		bodyModel[3].addShapeBox(0F, 2F, 0.5F, 1, 1, 1, 0F,0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 5 camera bottom
		bodyModel[3].setRotationPoint(-3F, -15F, -1.5F);
		bodyModel[3].rotateAngleY = 0.29670597F;
		bodyModel[3].rotateAngleZ = 0.15707963F;

		bodyModel[4].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F); // Box 7 mount
		bodyModel[4].setRotationPoint(-2.75F, -15.5F, -0.75F);

		bodyModel[5].addShapeBox(0F, -8F, 0F, 8, 8, 1, 0F,0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8 solar
		bodyModel[5].setRotationPoint(-4F, -20.5F, -4.25F);
		bodyModel[5].rotateAngleX = -0.90757121F;

		bodyModel[6].addShapeBox(3F, 1F, 0F, 2, 1, 6, 0F,0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F); // Box 9 battery
		bodyModel[6].setRotationPoint(-4F, -20.5F, -4.25F);
		bodyModel[6].rotateAngleX = 0.66322512F;

		bodyModel[7].addShapeBox(0F, 0F, 0F, 0, 5, 1, 0F,0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, -1F, 0.5F, 0F, -1F); // Box 10 wire
		bodyModel[7].setRotationPoint(-2F, -20F, 0F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 0, 2, 1, 0F,-1.5F, 0F, 0.5F, 1.5F, 0F, 0.5F, 1.5F, 0F, -1F, -1.5F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11 wire
		bodyModel[8].setRotationPoint(-2F, -22F, 0F);
	}
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		for (ModelRendererTurbo m : bodyModel) {
			if (m.boxName.equals("cull")) {
				GL11.glDisable(GL11.GL_CULL_FACE);
				m.render(f5);
				GL11.glEnable(GL11.GL_CULL_FACE);
			} else {
				m.render(f5);
			}
		}
	}
}