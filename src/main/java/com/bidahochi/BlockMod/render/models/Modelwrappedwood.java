//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2023 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: wrapped wood block
// Model Creator: bida
// Created on: 19.11.2021 - 11:21:44
// Last changed on: 19.11.2021 - 11:21:44

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class Modelwrappedwood extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 128;

	public Modelwrappedwood() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[7];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 2, 5, textureX, textureY); // Box 1 wood
		bodyModel[1] = new ModelRendererTurbo(this, 56, 40, textureX, textureY); // Box 3 support
		bodyModel[2] = new ModelRendererTurbo(this, 91, 40, textureX, textureY); // Box 4 support
		bodyModel[3] = new ModelRendererTurbo(this, 56, 58, textureX, textureY, "cull"); // Box 6 strap cull
		bodyModel[4] = new ModelRendererTurbo(this, 51, 73, textureX, textureY, "cull"); // Box 7 strap cull
		bodyModel[5] = new ModelRendererTurbo(this, 56, 58, textureX, textureY, "cull"); // Box 6 strap cull
		bodyModel[6] = new ModelRendererTurbo(this, 51, 73, textureX, textureY, "cull"); // Box 7 strap cull

		bodyModel[0].addBox(0F, 0F, 0F, 32, 15, 16, 0F); // Box 1 wood
		bodyModel[0].setRotationPoint(-16F, -6F, -8F);

		bodyModel[1].addBox(0F, 0F, 0F, 2, 1, 15, 0F); // Box 3 support
		bodyModel[1].setRotationPoint(-9.5F, 9F, -7.5F);

		bodyModel[2].addBox(0F, 0F, 0F, 2, 1, 15, 0F); // Box 4 support
		bodyModel[2].setRotationPoint(7.5F, 9F, -7.5F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 15, 16, 0F,0F, 0.01F, 0.01F, 0F, 0.01F, 0.01F, 0F, 0.01F, 0.01F, 0F, 0.01F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F); // Box 6 strap cull
		bodyModel[3].setRotationPoint(-9F, -6F, -8F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 15, 1, 0F,0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0.51F, 0F, 0F, 0.51F, 0F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0.51F, 0F, 0F, 0.51F, 0F); // Box 7 strap cull
		bodyModel[4].setRotationPoint(-9F, 10F, -7.5F);
		bodyModel[4].rotateAngleX = 1.57079633F;

		bodyModel[5].addShapeBox(0F, 0F, 0F, 1, 15, 16, 0F,0F, 0.01F, 0.01F, 0F, 0.01F, 0.01F, 0F, 0.01F, 0.01F, 0F, 0.01F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0F, 0.01F); // Box 6 strap cull
		bodyModel[5].setRotationPoint(8F, -6F, -8F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 1, 15, 1, 0F,0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0.51F, 0F, 0F, 0.51F, 0F, 0F, 0F, 0.01F, 0F, 0F, 0.01F, 0F, 0.51F, 0F, 0F, 0.51F, 0F); // Box 7 strap cull
		bodyModel[6].setRotationPoint(8F, 10F, -7.5F);
		bodyModel[6].rotateAngleX = 1.57079633F;
	}
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		for (int i = 0; i < 7; i++) {
			if (bodyModel[i].boxName != null && bodyModel[i].boxName.contains("cull")) {
				GL11.glDisable(GL11.GL_CULL_FACE);
				bodyModel[i].render(f5);
				GL11.glEnable(GL11.GL_CULL_FACE);
			} else {
				bodyModel[i].render(f5);
			}
		}
	}
}