package com.bidahochi.BlockMod.blocks.props.configurable.model;

import com.bidahochi.BlockMod.render.tmt.ModelConverter;
import com.bidahochi.BlockMod.render.tmt.ModelRendererTurbo;

/** Generated two-block refrigerator geometry used by the 1970s fridge definition. */
public class ModelCubert70sFridge2BlockTall extends ModelConverter
{
    private final int textureX = 128;
    private final int textureY = 128;

    /** Builds the complete two-block refrigerator model hierarchy. */
    public ModelCubert70sFridge2BlockTall()
    {
        bodyModel = new ModelRendererTurbo[38];

        initbodyModel_1();

        translateAll(0F, 0F, 0F);
        flipAll();
    }

    /** Initializes the generated body geometry and texture coordinates. */
    private void initbodyModel_1()
    {
        bodyModel[0] = new ModelRendererTurbo(this, 54, 44, textureX, textureY); // Box 1
        bodyModel[1] = new ModelRendererTurbo(this, 8, 92, textureX, textureY); // Box 2
        bodyModel[2] = new ModelRendererTurbo(this, 34, 64, textureX, textureY); // Box 3
        bodyModel[3] = new ModelRendererTurbo(this, 1, 62, textureX, textureY); // Box 4
        bodyModel[4] = new ModelRendererTurbo(this, 89, 44, textureX, textureY); // Box 6
        bodyModel[5] = new ModelRendererTurbo(this, 52, 58, textureX, textureY); // Box 7
        bodyModel[6] = new ModelRendererTurbo(this, 88, 43, textureX, textureY); // Box 8
        bodyModel[7] = new ModelRendererTurbo(this, 88, 50, textureX, textureY); // Box 9
        bodyModel[8] = new ModelRendererTurbo(this, 32, 68, textureX, textureY); // Box 10
        bodyModel[9] = new ModelRendererTurbo(this, 88, 35, textureX, textureY); // Box 12
        bodyModel[10] = new ModelRendererTurbo(this, 29, 68, textureX, textureY); // Box 14
        bodyModel[11] = new ModelRendererTurbo(this, 88, 39, textureX, textureY); // Box 15
        bodyModel[12] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 16
        bodyModel[13] = new ModelRendererTurbo(this, 65, 34, textureX, textureY); // Box 17
        bodyModel[14] = new ModelRendererTurbo(this, 65, 39, textureX, textureY); // Box 18
        bodyModel[15] = new ModelRendererTurbo(this, 92, 1, textureX, textureY); // Box 19
        bodyModel[16] = new ModelRendererTurbo(this, 107, 2, textureX, textureY); // Box 20
        bodyModel[17] = new ModelRendererTurbo(this, 34, 72, textureX, textureY); // Box 21
        bodyModel[18] = new ModelRendererTurbo(this, 47, 1, textureX, textureY); // Box 22
        bodyModel[19] = new ModelRendererTurbo(this, 47, 1, textureX, textureY); // Box 23
        bodyModel[20] = new ModelRendererTurbo(this, 47, 9, textureX, textureY); // Box 24
        bodyModel[21] = new ModelRendererTurbo(this, 42, 4, textureX, textureY); // Box 25
        bodyModel[22] = new ModelRendererTurbo(this, 35, 7, textureX, textureY); // Box 26
        bodyModel[23] = new ModelRendererTurbo(this, 125, 61, textureX, textureY); // Box 27
        bodyModel[24] = new ModelRendererTurbo(this, 122, 61, textureX, textureY); // Box 28
        bodyModel[25] = new ModelRendererTurbo(this, 95, 48, textureX, textureY); // Box 29
        bodyModel[26] = new ModelRendererTurbo(this, 24, 62, textureX, textureY); // Box 30
        bodyModel[27] = new ModelRendererTurbo(this, 19, 68, textureX, textureY); // Box 31
        bodyModel[28] = new ModelRendererTurbo(this, 46, 1, textureX, textureY); // Box 32
        bodyModel[29] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 33
        bodyModel[30] = new ModelRendererTurbo(this, 39, 6, textureX, textureY); // Box 34
        bodyModel[31] = new ModelRendererTurbo(this, 35, 5, textureX, textureY); // Box 35
        bodyModel[32] = new ModelRendererTurbo(this, 42, 6, textureX, textureY); // Box 36
        bodyModel[33] = new ModelRendererTurbo(this, 53, 0, textureX, textureY); // Box 38
        bodyModel[34] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 39
        bodyModel[35] = new ModelRendererTurbo(this, 56, 1, textureX, textureY); // Box 40
        bodyModel[36] = new ModelRendererTurbo(this, 38, 5, textureX, textureY); // Box 38
        bodyModel[37] = new ModelRendererTurbo(this, 29, 62, textureX, textureY); // Box 39

        bodyModel[0].addBox(0F, 0F, 0F, 6, 0, 13, 0F); // Box 1
        bodyModel[0].setRotationPoint(0F, 10F, -6.5F);

        bodyModel[1].addBox(0F, 0F, 0F, 12, 21, 15, 0F); // Box 2
        bodyModel[1].setRotationPoint(-6F, -18F, -7.5F);

        bodyModel[2].addShapeBox(0F, 0F, 0F, 1, 12, 15, 0F,0.25F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, 0.25F, -0.25F, 0F, 0.25F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, 0.25F, -0.25F, 0F); // Box 3
        bodyModel[2].setRotationPoint(-6.5F, -19F, -7.5F);

        bodyModel[3].addShapeBox(0F, 0F, 0F, 1, 14, 15, 0F,0.25F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, 0.25F, -0.25F, 0F, 0.25F, -0.25F, 0F, -0.5F, -0.25F, 0F, -0.5F, -0.25F, 0F, 0.25F, -0.25F, 0F); // Box 4
        bodyModel[3].setRotationPoint(-6.5F, -7F, -7.5F);

        bodyModel[4].addShapeBox(0F, 0F, 0F, 5, 2, 14, 0F,0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 6
        bodyModel[4].setRotationPoint(-5.5F, 8F, -7F);

        bodyModel[5].addBox(0F, 0F, 0F, 6, 5, 15, 0F); // Box 7
        bodyModel[5].setRotationPoint(-6F, 3F, -7.5F);

        bodyModel[6].addBox(0F, 0F, 0F, 6, 5, 1, 0F); // Box 8
        bodyModel[6].setRotationPoint(0F, 3F, -7.5F);

        bodyModel[7].addBox(0F, 0F, 0F, 6, 5, 1, 0F); // Box 9
        bodyModel[7].setRotationPoint(0F, 3F, 6.5F);

        bodyModel[8].addShapeBox(0F, 0F, 0F, 0, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 10
        bodyModel[8].setRotationPoint(6F, 3F, -6.5F);

        bodyModel[9].addShapeBox(0F, 0F, 0F, 6, 2, 1, 0F,0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
        bodyModel[9].setRotationPoint(0F, 8F, -7.5F);

        bodyModel[10].addShapeBox(0F, 0F, 0F, 0, 7, 1, 0F,0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
        bodyModel[10].setRotationPoint(6F, 3F, 5.5F);

        bodyModel[11].addShapeBox(0F, 0F, 0F, 6, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 15
        bodyModel[11].setRotationPoint(0F, 8F, 6.5F);

        bodyModel[12].addBox(0F, 0F, 0F, 4, 2, 5, 0F); // Box 16
        bodyModel[12].setRotationPoint(1F, 4F, -2.5F);

        bodyModel[13].addBox(0F, 0F, 0F, 4, 0, 4, 0F); // Box 17
        bodyModel[13].setRotationPoint(1F, 6F, -6.5F);

        bodyModel[14].addBox(0F, 0F, 0F, 4, 0, 4, 0F); // Box 18
        bodyModel[14].setRotationPoint(1F, 6F, 2.5F);

        bodyModel[15].addBox(0F, 0F, 0F, 4, 3, 3, 0F); // Box 19
        bodyModel[15].setRotationPoint(1F, 7F, 0.5F);

        bodyModel[16].addBox(0F, 0F, 0F, 2, 3, 2, 0F); // Box 20
        bodyModel[16].setRotationPoint(1F, 7F, -1.5F);

        bodyModel[17].addBox(0F, 0F, 0F, 0, 1, 5, 0F); // Box 21
        bodyModel[17].setRotationPoint(2F, 7F, -6.5F);

        bodyModel[18].addBox(0F, 0F, 0F, 0, 5, 2, 0F); // Box 22
        bodyModel[18].setRotationPoint(2F, 3F, 3.5F);

        bodyModel[19].addBox(0F, 0F, 0F, 0, 5, 2, 0F); // Box 23
        bodyModel[19].setRotationPoint(4F, 3F, 3.5F);

        bodyModel[20].addBox(0F, 0F, 0F, 2, 1, 0, 0F); // Box 24
        bodyModel[20].setRotationPoint(2F, 7F, -3.5F);

        bodyModel[21].addBox(0F, 0F, 0F, 1, 2, 0, 0F); // Box 25
        bodyModel[21].setRotationPoint(3F, 5F, -3.5F);

        bodyModel[22].addBox(0F, 0F, 0F, 1, 0, 1, 0F); // Box 26
        bodyModel[22].setRotationPoint(3F, 5F, -3.5F);

        bodyModel[23].addShapeBox(0F, 0F, 0F, 1, 17, 0, 0F,0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 27
        bodyModel[23].setRotationPoint(6F, -15F, -6.5F);

        bodyModel[24].addShapeBox(0F, 0F, 0F, 1, 17, 0, 0F,0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 28
        bodyModel[24].setRotationPoint(6F, -15F, 6.5F);

        bodyModel[25].addShapeBox(0F, 0F, 0F, 0, 17, 13, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
        bodyModel[25].setRotationPoint(6.5F, -15F, -6.5F);

        bodyModel[26].addShapeBox(0F, 0F, 0F, 1, 13, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
        bodyModel[26].setRotationPoint(-7.25F, -6.5F, 5.5F);

        bodyModel[27].addShapeBox(0F, 0F, 0F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 31
        bodyModel[27].setRotationPoint(-7.25F, -14.5F, 5.5F);

        bodyModel[28].addShapeBox(0F, 0F, 0F, 2, 0, 1, 0F,-0.25F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.25F, 0F, 0F); // Box 32
        bodyModel[28].setRotationPoint(-7F, -19F, -7.5F);

        bodyModel[29].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 33
        bodyModel[29].setRotationPoint(-5.5F, -19F, -7.5F);

        bodyModel[30].addShapeBox(0F, 0F, 0F, 0, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F); // Box 34
        bodyModel[30].setRotationPoint(-6.75F, -19F, -7.5F);

        bodyModel[31].addShapeBox(0F, 0F, 0F, 1, 0, 1, 0F,-0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F); // Box 35
        bodyModel[31].setRotationPoint(-7F, -7F, -7.5F);

        bodyModel[32].addShapeBox(0F, 0F, 0F, 0, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F); // Box 36
        bodyModel[32].setRotationPoint(-6.75F, -7F, -7.5F);

        bodyModel[33].addShapeBox(0F, 0F, 0F, 0, 1, 1, 0F,0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
        bodyModel[33].setRotationPoint(-6.75F, 6F, -7.5F);

        bodyModel[34].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 39
        bodyModel[34].setRotationPoint(-7.05F, -6F, -4.5F);

        bodyModel[35].addShapeBox(0F, 0F, 0F, 0, 5, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F); // Box 40
        bodyModel[35].setRotationPoint(-7F, -5.5F, -5.5F);

        bodyModel[36].addShapeBox(0F, 0F, 0F, 1, 0, 1, 0F,-0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F); // Box 38
        bodyModel[36].setRotationPoint(-7F, 7F, -7.5F);

        bodyModel[37].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 39
        bodyModel[37].setRotationPoint(-7F, -17.5F, -6.25F);
    }
}

