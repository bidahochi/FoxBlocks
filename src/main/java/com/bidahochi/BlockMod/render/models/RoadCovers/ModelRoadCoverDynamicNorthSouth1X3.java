package com.bidahochi.BlockMod.render.models.RoadCovers;

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelRoadCoverDynamicNorthSouth1X3 extends ModelConverter //Same as Filename
{
    int textureX = 16;
    int textureY = 16;

    public ModelRoadCoverDynamicNorthSouth1X3() //Same as Filename
    {
        bodyModel = new ModelRendererTurbo[3];
        bodyModel[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 0
        bodyModel[0].addBox(0F, 0F, 0F, 16, 1, 16, 0F); // Box 0
        bodyModel[0].setRotationPoint(0F, 0F, 0F);
        bodyModel[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 1
        bodyModel[1].addBox(0F, 0F, 0F, 16, 1, 16, 0F); // Box 1
        bodyModel[1].setRotationPoint(-16F, 0F, 0F);
        bodyModel[2] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 1
        bodyModel[2].addBox(0F, 0F, 0F, 16, 1, 16, 0F); // Box 1
        bodyModel[2].setRotationPoint(-32F, 0F, 0F);

        translateAll(0F, 0F, 0F);

        flipAll();
    }
}