package com.bidahochi.BlockMod.render.models.RoadCovers;

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

public class ModelRoadCoverDynamicEastWest1X2 extends ModelConverter //Same as Filename
{
    int textureX = 16;
    int textureY = 16;

    public ModelRoadCoverDynamicEastWest1X2() //Same as Filename
    {
        bodyModel = new ModelRendererTurbo[2];
        bodyModel[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box0
        bodyModel[0].addBox(0F, 0F, 0F, 16, 1, 16, 0F); // Box0
        bodyModel[0].setRotationPoint(0F, 0F, 0F);
        bodyModel[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box1
        bodyModel[1].addBox(0F, 0F, 0F, 16, 1, 16, 0F); // Box 1
        bodyModel[1].setRotationPoint(0F, 0F, -16F);

        translateAll(0F, 0F, 0F);

        flipAll();
    }
}
