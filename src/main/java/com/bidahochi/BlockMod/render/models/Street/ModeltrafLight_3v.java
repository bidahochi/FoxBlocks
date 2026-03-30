//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2026 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: trafLight_3v_nb
// Model Creator: 
// Created on: 30.03.2026 - 09:14:55
// Last changed on: 30.03.2026 - 09:14:55

package com.bidahochi.BlockMod.render.models.Street; //Path where the model is located

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModeltrafLight_3v extends ModelConverter //Same as Filename
{
	int textureX = 32;
	int textureY = 32;

	public ModeltrafLight_3v() //Same as Filename
	{
		bodyModel = new ModelRendererTurbo[10];

		initbodyModel_1();

		translateAll(0F, 0F, 0F);

		flipAll();
	}

	private void initbodyModel_1()
	{
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 1
		bodyModel[1] = new ModelRendererTurbo(this, 15, -1, textureX, textureY); // Box 2 RED
		bodyModel[2] = new ModelRendererTurbo(this, 15, 2, textureX, textureY); // Box 3 YELLOW
		bodyModel[3] = new ModelRendererTurbo(this, 15, 5, textureX, textureY); // Box 4 GREEN
		bodyModel[4] = new ModelRendererTurbo(this, 10, 3, textureX, textureY); // Box 20
		bodyModel[5] = new ModelRendererTurbo(this, 20, 1, textureX, textureY, "cull"); // Box 21 CULL
		bodyModel[6] = new ModelRendererTurbo(this, 20, 1, textureX, textureY, "cull"); // Box 22 CULL
		bodyModel[7] = new ModelRendererTurbo(this, 20, 1, textureX, textureY, "cull"); // Box 23 CULL
		bodyModel[8] = new ModelRendererTurbo(this, 21, 8, textureX, textureY, "cull"); // Box 24 cull attacher
		bodyModel[9] = new ModelRendererTurbo(this, 21, 15, textureX, textureY); // Box 26 border

		bodyModel[0].addShapeBox(0F, 0F, 0F, 1, 9, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		bodyModel[0].setRotationPoint(5F, -9.5F, -1.5F);

		bodyModel[1].addBox(0F, 0F, 0F, 0, 2, 2, 0F); // Box 2 RED
		bodyModel[1].setRotationPoint(4.98F, -9F, -1F);

		bodyModel[2].addBox(0F, 0F, 0F, 0, 2, 2, 0F); // Box 3 YELLOW
		bodyModel[2].setRotationPoint(4.98F, -6F, -1F);

		bodyModel[3].addBox(0F, 0F, 0F, 0, 2, 2, 0F); // Box 4 GREEN
		bodyModel[3].setRotationPoint(4.98F, -3F, -1F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F,0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F); // Box 20
		bodyModel[4].setRotationPoint(6F, -9.5F, -0.5F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 2, 3, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 21 CULL
		bodyModel[5].setRotationPoint(3.25F, -9F, -1F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 2, 3, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 22 CULL
		bodyModel[6].setRotationPoint(3.25F, -6F, -1F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 2, 3, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 23 CULL
		bodyModel[7].setRotationPoint(3.25F, -3F, -1F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 3, 10, 1, 0F,0F, 0F, -0.125F, -1F, 0F, -0.125F, -1F, 0F, -0.125F, 0F, 0F, -0.125F, 0F, 0F, -0.125F, -1F, 0F, -0.125F, -1F, 0F, -0.125F, 0F, 0F, -0.125F); // Box 24 cull attacher
		bodyModel[8].setRotationPoint(6F, -10F, -0.5F);

		bodyModel[9].addBox(0F, 0F, 0F, 0, 11, 5, 0F); // Box 26 border
		bodyModel[9].setRotationPoint(5.02F, -10.5F, -2.5F);
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