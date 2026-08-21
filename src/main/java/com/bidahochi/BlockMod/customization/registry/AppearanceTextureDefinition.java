package com.bidahochi.BlockMod.customization.registry;

import com.bidahochi.BlockMod.customization.data.AppearanceData;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/** Selects a texture when an appearance contains every required trait value. */
public final class AppearanceTextureDefinition
{

    private final String textureTargetId;
    private final Map<String, String> requiredTraits;
    private final ResourceLocation texture;

    /**
     * Creates an immutable exact-match texture rule for a prop or model group.
     * Trait identifiers are normalized to lower case and the requirements map is
     * copied. An empty requirements map creates a target-specific fallback rule.
     *
     * @param textureTargetId prop ID or group target ID produced by the registry
     * @param requiredTraits trait identifiers and exact serialized values to match
     * @param texture texture selected when all required values match
     * @throws IllegalArgumentException when the target, requirements, or texture is missing
     */
    public AppearanceTextureDefinition(
            String textureTargetId,
            Map<String, String> requiredTraits,
            ResourceLocation texture
    )
    {
        if (textureTargetId == null || textureTargetId.trim().length() == 0)
        {
            throw new IllegalArgumentException("Appearance texture target ID cannot be empty");
        }
        if (requiredTraits == null)
        {
            throw new IllegalArgumentException("Appearance texture requirements cannot be null");
        }
        if (texture == null)
        {
            throw new IllegalArgumentException("Appearance texture cannot be null");
        }
        this.textureTargetId = textureTargetId.trim();
        Map<String, String> normalizedTraits = new LinkedHashMap<String, String>();
        for (Map.Entry<String, String> entry : requiredTraits.entrySet())
        {
            if (entry.getKey() == null || entry.getKey().trim().length() == 0)
            {
                throw new IllegalArgumentException("Appearance texture trait ID cannot be empty");
            }
            normalizedTraits.put(
                    entry.getKey().trim().toLowerCase(Locale.ROOT),
                    entry.getValue() != null ? entry.getValue() : ""
            );
        }
        this.requiredTraits = Collections.unmodifiableMap(normalizedTraits);
        this.texture = texture;
    }

    /** Returns the prop or group target matched by this texture rule. */
    public String getTextureTargetId()
    {
        return textureTargetId;
    }

    /** Returns this rule's specificity for most-specific-match resolution. */
    public int getRequiredTraitCount()
    {
        return requiredTraits.size();
    }

    /** Returns the texture selected when this rule wins resolution. */
    public ResourceLocation getTexture()
    {
        return texture;
    }

    /**
     * Tests whether every trait required by this rule matches exactly.
     *
     * @param appearance validated appearance to compare with the rule
     * @return {@code true} when all required trait values match
     * @throws IllegalArgumentException when {@code appearance} is {@code null}
     */
    public boolean matchesAppearance(AppearanceData appearance)
    {
        if (appearance == null)
        {
            throw new IllegalArgumentException("Appearance texture matching requires appearance data.");
        }
        for (Map.Entry<String, String> entry : requiredTraits.entrySet())
        {
            if (entry.getValue().equals(
                    appearance.getTrait(entry.getKey(), "")
            ) == false)
            {
                return false;
            }
        }
        return true;
    }
}
