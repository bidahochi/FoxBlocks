package com.bidahochi.BlockMod.customization.data;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Immutable, extensible appearance traits keyed by normalized stable IDs. No
 * particular trait category is mandatory.
 */
public final class AppearanceData
{

    /** Sentinel skin ID used before a definition supplies its registered default. */
    public static final String DEFAULT_SKIN_ID = "foxblocks:default";
    /** Conventional trait ID for selecting a registered skin. */
    public static final String TRAIT_SKIN = "skin";

    private final Map<String, String> traits;

    /**
     * Creates an immutable snapshot with normalized lower-case trait IDs.
     *
     * @param traitValues source ID/value pairs; {@code null} creates an empty snapshot
     */
    public AppearanceData(Map<String, String> traitValues)
    {
        Map<String, String> normalized = new LinkedHashMap<String, String>();
        if (traitValues != null)
        {
            for (Map.Entry<String, String> entry : traitValues.entrySet())
            {
                if (entry.getKey() != null && entry.getKey().trim().length() > 0)
                {
                    normalized.put(
                            entry.getKey().trim().toLowerCase(Locale.ROOT),
                            entry.getValue() != null ? entry.getValue() : ""
                    );
                }
            }
        }
        traits = Collections.unmodifiableMap(normalized);
    }

    /**
     * Returns an appearance with no explicitly selected traits.
     *
     * @return new immutable empty appearance
     */
    public static AppearanceData defaultAppearance()
    {
        return new AppearanceData(Collections.<String, String>emptyMap());
    }

    /**
     * Returns the immutable normalized trait snapshot owned by this value.
     *
     * @return immutable trait ID to serialized value map
     */
    public Map<String, String> getTraits()
    {
        return traits;
    }

    /**
     * Returns one trait value without imposing category-specific validation.
     *
     * @param id trait ID; lookup is case-insensitive and trims whitespace
     * @param fallback value returned when the ID is absent or invalid
     * @return stored value or {@code fallback}
     */
    public String getTrait(String id, String fallback)
    {
        String normalizedId = normalizeTraitId(id);
        String value = normalizedId != null ? traits.get(normalizedId) : null;
        return value != null ? value : fallback;
    }

    /**
     * Returns a new snapshot with one normalized trait value replaced.
     *
     * @param traitId nonblank trait ID
     * @param traitValue replacement serialized value; {@code null} becomes empty
     * @return immutable updated snapshot
     */
    public AppearanceData withTrait(String traitId, String traitValue)
    {
        String normalizedId = normalizeTraitId(traitId);
        if (normalizedId == null)
        {
            throw new IllegalArgumentException("Appearance trait ID cannot be empty");
        }
        Map<String, String> updated = new LinkedHashMap<String, String>(traits);
        updated.put(normalizedId, traitValue != null ? traitValue : "");
        return new AppearanceData(updated);
    }

    /**
     * Returns the selected normalized skin ID or the default sentinel.
     *
     * @return selected skin ID, or {@link #DEFAULT_SKIN_ID} when absent
     */
    public String getSkinId()
    {
        return normalizeSkinId(getTrait(TRAIT_SKIN, DEFAULT_SKIN_ID));
    }

    /**
     * Writes every trait as an ID/value pair under the {@code Traits} list.
     *
     * @param tag destination item or tile compound
     */
    public void writeToNBT(NBTTagCompound tag)
    {
        NBTTagList list = new NBTTagList();
        for (Map.Entry<String, String> entry : traits.entrySet())
        {
            NBTTagCompound traitTag = new NBTTagCompound();
            traitTag.setString("Id", entry.getKey());
            traitTag.setString("Value", entry.getValue());
            list.appendTag(traitTag);
        }
        tag.setTag("Traits", list);
    }

    /**
     * Reads the extensible trait list.
     *
     * @param tag stored appearance compound, or {@code null}
     * @return immutable normalized appearance, empty when data is absent
     */
    public static AppearanceData readFromNBT(NBTTagCompound tag)
    {
        if (tag == null)
        {
            return defaultAppearance();
        }
        Map<String, String> traitValues = new LinkedHashMap<String, String>();
        if (tag.hasKey("Traits"))
        {
            NBTTagList list = tag.getTagList("Traits", 10);
            for (int index = 0; index < list.tagCount(); index++)
            {
                NBTTagCompound traitTag = list.getCompoundTagAt(index);
                traitValues.put(traitTag.getString("Id"), traitTag.getString("Value"));
            }
        }
        return new AppearanceData(traitValues);
    }

    /**
     * Parses an integer-valued trait without throwing for malformed data.
     *
     * @param id integer trait ID
     * @param fallback value returned when the trait is absent, malformed, or overflowing
     * @return parsed integer or {@code fallback}
     */
    public int getIntegerTrait(String id, int fallback)
    {
        return CustomizationNumberParser.parseInteger(getTrait(id, null), fallback);
    }

    /** Normalizes stored skin IDs and replaces empty legacy values with the sentinel. */
    private static String normalizeSkinId(String value)
    {
        if (value == null)
        {
            return DEFAULT_SKIN_ID;
        }
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        return normalized.length() == 0 ? DEFAULT_SKIN_ID : normalized;
    }

    /** Returns a normalized trait ID, or {@code null} when no ID was supplied. */
    private static String normalizeTraitId(String value)
    {
        if (value == null || value.trim().length() == 0)
        {
            return null;
        }
        return value.trim().toLowerCase(Locale.ROOT);
    }
}
