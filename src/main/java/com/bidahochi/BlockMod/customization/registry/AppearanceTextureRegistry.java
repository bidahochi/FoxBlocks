package com.bidahochi.BlockMod.customization.registry;

import com.bidahochi.BlockMod.customization.data.AppearanceData;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/** Resolves the most specific registered texture mapping for an appearance. */
public final class AppearanceTextureRegistry
{

    private static final String GROUP_SEPARATOR = "#group:";

    private static final List<AppearanceTextureDefinition> TEXTURE_RULES =
            new ArrayList<AppearanceTextureDefinition>();

    /** Prevents construction of this static utility class. */
    private AppearanceTextureRegistry()
    {
    }

    /**
     * Adds a texture rule. Equally specific matching rules retain registration
     * order, so add general rules before more intentional tie-breaking rules.
     *
     * @param textureRule immutable matching rule to append
     * @throws IllegalArgumentException when {@code textureRule} is {@code null}
     */
    public static void register(AppearanceTextureDefinition textureRule)
    {
        if (textureRule == null)
        {
            throw new IllegalArgumentException("Appearance texture rule cannot be null.");
        }
        TEXTURE_RULES.add(textureRule);
    }

    /**
     * Resolves the matching rule with the most required traits, or returns the
     * supplied fallback when no rule matches.
     *
     * @param textureTargetId prop or group target whose rules should be considered
     * @param appearance validated appearance used for exact trait matching
     * @param fallback texture returned when no registered rule matches; may be null
     * @return the most-specific matching texture, or {@code fallback}
     * @throws IllegalArgumentException when the target is empty or
     *         {@code appearance} is {@code null}
     */
    public static ResourceLocation resolveTexture(
            String textureTargetId,
            AppearanceData appearance,
            ResourceLocation fallback
    )
    {
        if (textureTargetId == null || textureTargetId.trim().length() == 0)
        {
            throw new IllegalArgumentException("Appearance texture target ID cannot be empty.");
        }
        if (appearance == null)
        {
            throw new IllegalArgumentException("Appearance texture resolution requires appearance data.");
        }
        AppearanceTextureDefinition bestMatch = null;
        for (AppearanceTextureDefinition textureRule : TEXTURE_RULES)
        {
            int requiredTraitCount = textureRule.getRequiredTraitCount();
            boolean moreSpecificMatch = bestMatch == null
                    || requiredTraitCount > bestMatch.getRequiredTraitCount();
            if (textureRule.getTextureTargetId().equals(textureTargetId)
                    && textureRule.matchesAppearance(appearance)
                    && moreSpecificMatch)
            {
                bestMatch = textureRule;
            }
        }
        return bestMatch != null ? bestMatch.getTexture() : fallback;
    }

    /**
     * Resolves a texture for one independently textured model group.
     *
     * @param configurablePropId stable prop definition identifier
     * @param groupId stable model group identifier
     * @param appearance validated appearance used for trait matching
     * @param fallback texture returned when no group rule matches; may be null
     * @return the most-specific matching group texture, or {@code fallback}
     */
    public static ResourceLocation resolveGroupTexture(
            String configurablePropId,
            String groupId,
            AppearanceData appearance,
            ResourceLocation fallback
    )
    {
        return resolveTexture(
                createGroupTextureTargetId(configurablePropId, groupId),
                appearance,
                fallback
        );
    }

    /**
     * Builds the internal target identifier used to isolate one model group's rules.
     *
     * @param configurablePropId stable prop definition identifier
     * @param groupId stable model group identifier
     * @return deterministic target identifier accepted by texture definitions
     * @throws IllegalArgumentException when either identifier is empty
     */
    public static String createGroupTextureTargetId(String configurablePropId, String groupId)
    {
        if (configurablePropId == null || configurablePropId.trim().length() == 0)
        {
            throw new IllegalArgumentException("Configurable prop texture target ID cannot be empty");
        }
        if (groupId == null || groupId.trim().length() == 0)
        {
            throw new IllegalArgumentException("Configurable prop texture group ID cannot be empty");
        }
        return configurablePropId.trim() + GROUP_SEPARATOR + groupId.trim();
    }
}
