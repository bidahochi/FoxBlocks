//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2025 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: soda_machine
// Model Creator: bida
// Created on: 29.11.2025 - 17:26:41
// Last changed on: 29.11.2025 - 17:26:41

package com.bidahochi.BlockMod.render.models; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class Modelsoda_machine extends ModelConverter //Same as Filename
{
	int textureX = 128;
	int textureY = 64;

	public Modelsoda_machine() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[22];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);


		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 56, 1, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 2
		bodyModel[2] = new ModelRendererTurbo(this, 85, 50, textureX, textureY); // Box 3
		bodyModel[3] = new ModelRendererTurbo(this, 68, 50, textureX, textureY); // Box 7
		bodyModel[4] = new ModelRendererTurbo(this, 34, 50, textureX, textureY); // Box 8
		bodyModel[5] = new ModelRendererTurbo(this, 51, 50, textureX, textureY); // Box 9
		bodyModel[6] = new ModelRendererTurbo(this, 0, 50, textureX, textureY); // Box 10
		bodyModel[7] = new ModelRendererTurbo(this, 17, 50, textureX, textureY); // Box 11
		bodyModel[8] = new ModelRendererTurbo(this, 1, 5, textureX, textureY); // Box 12
		bodyModel[9] = new ModelRendererTurbo(this, 1, 5, textureX, textureY); // Box 13
		bodyModel[10] = new ModelRendererTurbo(this, 1, 5, textureX, textureY); // Box 14
		bodyModel[11] = new ModelRendererTurbo(this, 1, 5, textureX, textureY); // Box 15
		bodyModel[12] = new ModelRendererTurbo(this, 1, 5, textureX, textureY); // Box 16
		bodyModel[13] = new ModelRendererTurbo(this, 1, 5, textureX, textureY); // Box 17
		bodyModel[14] = new ModelRendererTurbo(this, 1, 8, textureX, textureY, "cull"); // Box 18 cull
		bodyModel[15] = new ModelRendererTurbo(this, 1, 8, textureX, textureY, "cull"); // Box 19 cull
		bodyModel[16] = new ModelRendererTurbo(this, 1, 8, textureX, textureY, "cull"); // Box 18 cull
		bodyModel[17] = new ModelRendererTurbo(this, 1, 8, textureX, textureY, "cull"); // Box 19 cull
		bodyModel[18] = new ModelRendererTurbo(this, 1, 8, textureX, textureY, "cull"); // Box 18 cull
		bodyModel[19] = new ModelRendererTurbo(this, 1, 8, textureX, textureY, "cull"); // Box 19 cull
		bodyModel[20] = new ModelRendererTurbo(this, 40, 21, textureX, textureY, "lamp"); // Box 24 glow logo
		bodyModel[21] = new ModelRendererTurbo(this, 43, 20, textureX, textureY); // Box 25

		bodyModel[0].addBox(0F, 0F, 0F, 15, 2, 16, 0F); // Box 1
		bodyModel[0].setRotationPoint(-7F, 8F, -8F);

		bodyModel[1].addBox(0F, 0F, 0F, 11, 16, 16, 0F); // Box 2
		bodyModel[1].setRotationPoint(-3F, -8F, -8F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 3, 8, 5, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -2.6F, 0F, 0F, -2.6F, 0F, -4F, -0.1F, 0F, -4F, -0.1F, 0F, -4F, -2.6F, 0F, -4F, -2.6F); // Box 3
		bodyModel[2].setRotationPoint(-6F, -3F, -7.5F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 3, 8, 5, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -2.6F, 0F, 0F, -2.6F, 0F, -4F, -0.1F, 0F, -4F, -0.1F, 0F, -4F, -2.6F, 0F, -4F, -2.6F); // Box 7
		bodyModel[3].setRotationPoint(-6F, -3F, -5F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 3, 8, 5, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -2.6F, 0F, 0F, -2.6F, 0F, -4F, -0.1F, 0F, -4F, -0.1F, 0F, -4F, -2.6F, 0F, -4F, -2.6F); // Box 8
		bodyModel[4].setRotationPoint(-6F, -3F, 0F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 3, 8, 5, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -2.6F, 0F, 0F, -2.6F, 0F, -4F, -0.1F, 0F, -4F, -0.1F, 0F, -4F, -2.6F, 0F, -4F, -2.6F); // Box 9
		bodyModel[5].setRotationPoint(-6F, -3F, -2.5F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 3, 8, 5, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -2.6F, 0F, 0F, -2.6F, 0F, -4F, -0.1F, 0F, -4F, -0.1F, 0F, -4F, -2.6F, 0F, -4F, -2.6F); // Box 10
		bodyModel[6].setRotationPoint(-6F, -3F, 5F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 3, 8, 5, 0F,0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -2.6F, 0F, 0F, -2.6F, 0F, -4F, -0.1F, 0F, -4F, -0.1F, 0F, -4F, -2.6F, 0F, -4F, -2.6F); // Box 11
		bodyModel[7].setRotationPoint(-6F, -3F, 2.5F);

		bodyModel[8].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 12
		bodyModel[8].setRotationPoint(-5.25F, 1F, -6.75F);

		bodyModel[9].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 13
		bodyModel[9].setRotationPoint(-5.25F, 1F, -1.75F);

		bodyModel[10].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 14
		bodyModel[10].setRotationPoint(-5.25F, 1F, 3.25F);

		bodyModel[11].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 15
		bodyModel[11].setRotationPoint(-5.25F, 1F, 5.75F);

		bodyModel[12].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 16
		bodyModel[12].setRotationPoint(-5.25F, 1F, 0.75F);

		bodyModel[13].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 17
		bodyModel[13].setRotationPoint(-5.25F, 1F, -4.25F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, -0.5F, 1F, -0.125F, 0.25F, 0F, -0.125F, 0.25F, 0F, -0.125F, -0.5F, 1F, -0.125F); // Box 18 cull
		bodyModel[14].setRotationPoint(-5.25F, 1F, -6.75F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, -0.5F, 1F, -0.125F, 0.25F, 0F, -0.125F, 0.25F, 0F, -0.125F, -0.5F, 1F, -0.125F); // Box 19 cull
		bodyModel[15].setRotationPoint(-5.25F, 1F, -4.25F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, -0.5F, 1F, -0.125F, 0.25F, 0F, -0.125F, 0.25F, 0F, -0.125F, -0.5F, 1F, -0.125F); // Box 18 cull
		bodyModel[16].setRotationPoint(-5.25F, 1F, -1.75F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, -0.5F, 1F, -0.125F, 0.25F, 0F, -0.125F, 0.25F, 0F, -0.125F, -0.5F, 1F, -0.125F); // Box 19 cull
		bodyModel[17].setRotationPoint(-5.25F, 1F, 0.75F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, -0.5F, 1F, -0.125F, 0.25F, 0F, -0.125F, 0.25F, 0F, -0.125F, -0.5F, 1F, -0.125F); // Box 18 cull
		bodyModel[18].setRotationPoint(-5.25F, 1F, 3.25F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F,0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, -0.5F, 1F, -0.125F, 0.25F, 0F, -0.125F, 0.25F, 0F, -0.125F, -0.5F, 1F, -0.125F); // Box 19 cull
		bodyModel[19].setRotationPoint(-5.25F, 1F, 5.75F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 1, 5, 16, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 24 glow logo
		bodyModel[20].setRotationPoint(-4F, -8F, -8F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 8, 0, 16, 0F,0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F); // Box 25
		bodyModel[21].setRotationPoint(-7F, 7.99F, -8F);
	}
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		for (ModelRendererTurbo m : bodyModel) {
			if (m.boxName.equals("lamp")) {
				Minecraft.getMinecraft().entityRenderer.disableLightmap(1D);
				m.render(f5);
				Minecraft.getMinecraft().entityRenderer.enableLightmap(1D);
			} else if (m.boxName.equals("cull")) {
				GL11.glDisable(GL11.GL_CULL_FACE);
				m.render(f5);
				GL11.glEnable(GL11.GL_CULL_FACE);
			} else {
				m.render(f5);
			}
		}
	}
}