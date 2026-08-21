package com.bidahochi.BlockMod.blocks.props.configurable.definition;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/** Immutable physical block properties applied to a registered prop controller. */
public final class ConfigurablePropBlockProperties
{

    private final Material material;
    private final float hardness;
    private final float resistance;
    private final Block.SoundType stepSound;
    private final String harvestTool;
    private final int harvestLevel;

    /** Creates one immutable physical-property snapshot. */
    private ConfigurablePropBlockProperties(
            Material material,
            float hardness,
            float resistance,
            Block.SoundType stepSound,
            String harvestTool,
            int harvestLevel
    )
    {
        this.material = material != null ? material : Material.wood;
        this.hardness = hardness;
        this.resistance = resistance;
        this.stepSound = stepSound != null ? stepSound : Block.soundTypeWood;
        this.harvestTool = harvestTool != null && harvestTool.trim().length() > 0
                ? harvestTool.trim()
                : "";
        this.harvestLevel = harvestLevel;
    }

    /**
     * Returns the standard wood-like prop preset.
     *
     * @return immutable wood material, sound, hardness, and resistance values
     */
    public static ConfigurablePropBlockProperties wood()
    {
        return new ConfigurablePropBlockProperties(
                Material.wood,
                2.0F,
                5.0F,
                Block.soundTypeWood,
                "",
                0
        );
    }

    /**
     * Returns the standard metal-like prop preset.
     *
     * @return immutable iron material, metal sound, hardness, and resistance values
     */
    public static ConfigurablePropBlockProperties metal()
    {
        return new ConfigurablePropBlockProperties(
                Material.iron,
                2.0F,
                4.0F,
                Block.soundTypeMetal,
                "",
                0
        );
    }

    /**
     * Returns the standard stone-like prop preset.
     *
     * @return immutable rock material, stone sound, hardness, and resistance values
     */
    public static ConfigurablePropBlockProperties stone()
    {
        return new ConfigurablePropBlockProperties(
                Material.rock,
                2.0F,
                4.0F,
                Block.soundTypeStone,
                "",
                0
        );
    }

    /**
     * Returns a copy with replacement block hardness.
     *
     * @param hardness Minecraft block hardness; larger values take longer to break
     * @return new immutable property set with the supplied hardness
     */
    public ConfigurablePropBlockProperties withHardness(float hardness)
    {
        return new ConfigurablePropBlockProperties(
                material,
                hardness,
                resistance,
                stepSound,
                harvestTool,
                harvestLevel
        );
    }

    /**
     * Returns a copy with replacement explosion resistance.
     *
     * @param resistance Minecraft explosion-resistance value
     * @return new immutable property set with the supplied resistance
     */
    public ConfigurablePropBlockProperties withResistance(float resistance)
    {
        return new ConfigurablePropBlockProperties(
                material,
                hardness,
                resistance,
                stepSound,
                harvestTool,
                harvestLevel
        );
    }

    /**
     * Returns a copy with replacement footstep and impact sound.
     *
     * @param stepSound Minecraft sound family; {@code null} falls back to wood
     * @return new immutable property set with the resolved sound
     */
    public ConfigurablePropBlockProperties withStepSound(Block.SoundType stepSound)
    {
        return new ConfigurablePropBlockProperties(
                material,
                hardness,
                resistance,
                stepSound,
                harvestTool,
                harvestLevel
        );
    }

    /**
     * Returns a copy requiring a particular tool class and harvest level.
     *
     * @param tool Forge tool class such as {@code pickaxe}; blank removes the requirement
     * @param level minimum Forge harvest level for the tool
     * @return new immutable property set with the supplied harvest requirement
     */
    public ConfigurablePropBlockProperties withHarvestTool(String tool, int level)
    {
        return new ConfigurablePropBlockProperties(
                material,
                hardness,
                resistance,
                stepSound,
                tool,
                level
        );
    }

    /**
     * Returns the material used when constructing the controller block.
     *
     * @return non-null Minecraft block material
     */
    public Material getMaterial()
    {
        return material;
    }

    /**
     * Returns the block-breaking hardness.
     *
     * @return configured Minecraft hardness value
     */
    public float getHardness()
    {
        return hardness;
    }

    /**
     * Returns the explosion resistance.
     *
     * @return configured Minecraft resistance value
     */
    public float getResistance()
    {
        return resistance;
    }

    /**
     * Returns the footstep and impact sound family.
     *
     * @return non-null Minecraft sound type
     */
    public Block.SoundType getStepSound()
    {
        return stepSound;
    }

    /**
     * Tests whether these properties declare a harvest tool requirement.
     *
     * @return {@code true} when a nonblank tool class is configured
     */
    public boolean hasHarvestTool()
    {
        return harvestTool.length() > 0;
    }

    /**
     * Returns the configured harvest tool class.
     *
     * @return Forge tool class, or an empty string when unrestricted
     */
    public String getHarvestTool()
    {
        return harvestTool;
    }

    /**
     * Returns the minimum harvest level for the configured tool.
     *
     * @return configured Forge harvest level
     */
    public int getHarvestLevel()
    {
        return harvestLevel;
    }
}
