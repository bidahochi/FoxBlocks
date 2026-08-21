package com.bidahochi.BlockMod.blocks.props.configurable;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.blocks.props.configurable.block.BlockConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.block.BlockConfigurablePropLightEmitter;
import com.bidahochi.BlockMod.blocks.props.configurable.block.BlockConfigurablePropPart;
import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropCatalog;
import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropCatalogEntry;
import com.bidahochi.BlockMod.blocks.props.configurable.content.IConfigurablePropContentEntry;
import com.bidahochi.BlockMod.blocks.props.configurable.content.ConfigurablePropIds;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropDefinition;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropBlockProperties;
import com.bidahochi.BlockMod.blocks.props.configurable.definition.ConfigurablePropRegistry;
import com.bidahochi.BlockMod.blocks.props.configurable.gui.ConfigurablePropGuiHandler;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteractionRegistry;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.ConfigurablePropInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.LightPropInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.FridgeStoragePropInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.SeatPropInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.interaction.StoragePropInteraction;
import com.bidahochi.BlockMod.blocks.props.configurable.item.ItemBlockConfigurableProp;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropController;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropLightEmitter;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropPart;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropProcessor;
import com.bidahochi.BlockMod.blocks.props.configurable.tile.TileConfigurablePropStorage;
import com.bidahochi.BlockMod.customization.data.AppearanceData;
import com.bidahochi.BlockMod.customization.registry.CustomizationProfile;
import com.bidahochi.BlockMod.customization.registry.CustomizationRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

/**
 * Coordinates configurable-prop registration across pre-initialization, block
 * creation, tile registration, interactions, and GUI routing.
 */
public final class ConfigurablePropSystem
{

    /** GUI discriminator for a configurable prop's storage inventory. */
    public static final int GUI_STORAGE = 40;
    /** GUI discriminator for editing a configurable prop item. */
    public static final int GUI_CUSTOMIZATION = 41;
    /** GUI discriminator delegated to a processor interaction's custom factory hooks. */
    public static final int GUI_PROCESSOR = 42;

    /** Invisible structure-part block shared by wood-family multiblock props. */
    public static Block configurablePropPart;
    /** Invisible wood-family structure part used at authored light emitters. */
    public static Block configurablePropLightEmitter;
    private static Block configurablePropMetalPart;
    private static Block configurablePropMetalLightEmitter;
    private static Block configurablePropStonePart;
    private static Block configurablePropStoneLightEmitter;
    private static boolean catalogBlocksRegistered;
    private static boolean contentRegistrationClosed;

    /** Prevents construction of this static utility class. */
    private ConfigurablePropSystem()
    {
    }

    /** Registers built-in content, blocks, interactions, and tile entities. */
    public static void preInit()
    {
        ConfigurablePropCatalog.registerDefaults();
        registerInteractions();
        ConfigurablePropCatalog.registerCustomization();
        ConfigurablePropCatalog.registerDefinitions();
        registerBlocks();
        registerTileEntities();
        MinecraftForge.EVENT_BUS.register(new ConfigurablePropChunkLoadHandler());
    }

    /** Closes registration and installs the configurable-prop GUI handler. */
    public static void init()
    {
        contentRegistrationClosed = true;
        NetworkRegistry.INSTANCE.registerGuiHandler(FoxBlocks.instance, new ConfigurablePropGuiHandler());
    }

    /**
     * Registers add-on content during pre-initialization. Content added after
     * block creation is completed immediately; registration after init fails.
     *
     * @param content add-on entry that supplies customization, definition, and block metadata
     * @throws IllegalArgumentException when the entry is invalid or duplicates registered content
     * @throws IllegalStateException when called after configurable-prop initialization closes
     */
    public static void registerContent(IConfigurablePropContentEntry content)
    {
        if (contentRegistrationClosed)
        {
            throw new IllegalStateException(
                    "Configurable prop content must be registered before FoxBlocks init."
            );
        }
        if (catalogBlocksRegistered == false)
        {
            ConfigurablePropCatalog.registerEntry(content);
            return;
        }
        registerContentAfterBlockCreation(content);
    }

    /**
     * Registers reusable behavior that prop definitions may select before init.
     *
     * @param interactionId stable identifier stored by prop definitions
     * @param interaction server-authoritative behavior implementation
     * @throws IllegalArgumentException when either argument is invalid or duplicated
     * @throws IllegalStateException when called after configurable-prop initialization closes
     */
    public static void registerInteraction(
            String interactionId,
            ConfigurablePropInteraction interaction
    )
    {
        if (contentRegistrationClosed)
        {
            throw new IllegalStateException(
                    "Configurable prop interactions must be registered before FoxBlocks init."
            );
        }
        ConfigurablePropInteractionRegistry.register(interactionId, interaction);
    }

    /**
     * Builds the validated default appearance for a registered definition.
     *
     * @param definitionId stable prop definition identifier
     * @return profile defaults, or an empty appearance when the definition or profile is unknown
     */
    public static AppearanceData getDefaultAppearance(String definitionId)
    {
        ConfigurablePropDefinition definition = ConfigurablePropRegistry.getDefinition(definitionId);
        if (definition == null)
        {
            return AppearanceData.defaultAppearance();
        }
        CustomizationProfile profile = CustomizationRegistry.getProfile(
                definition.getCustomizationProfileId()
        );
        return profile != null
                ? CustomizationRegistry.validateAppearance(profile, null)
                : AppearanceData.defaultAppearance();
    }

    /** Creates blocks and definitions after all built-in content entries are known. */
    private static void registerBlocks()
    {
        for (IConfigurablePropContentEntry content : ConfigurablePropCatalog.getEntries())
        {
            registerContentBlock(content);
        }

        configurablePropPart = new BlockConfigurablePropPart().setBlockName("configurablePropPart");
        GameRegistry.registerBlock(configurablePropPart, "configurable_prop_part");
        configurablePropLightEmitter = new BlockConfigurablePropLightEmitter()
                .setBlockName("configurablePropLightEmitter");
        GameRegistry.registerBlock(
                configurablePropLightEmitter,
                "configurable_prop_light_emitter"
        );
        configurablePropMetalPart = new BlockConfigurablePropPart(
                ConfigurablePropBlockProperties.metal()
        ).setBlockName("configurablePropMetalPart");
        GameRegistry.registerBlock(
                configurablePropMetalPart,
                "configurable_prop_metal_part"
        );
        configurablePropMetalLightEmitter = new BlockConfigurablePropLightEmitter(
                ConfigurablePropBlockProperties.metal()
        ).setBlockName("configurablePropMetalLightEmitter");
        GameRegistry.registerBlock(
                configurablePropMetalLightEmitter,
                "configurable_prop_metal_light_emitter"
        );
        configurablePropStonePart = new BlockConfigurablePropPart(
                ConfigurablePropBlockProperties.stone()
        ).setBlockName("configurablePropStonePart");
        GameRegistry.registerBlock(
                configurablePropStonePart,
                "configurable_prop_stone_part"
        );
        configurablePropStoneLightEmitter = new BlockConfigurablePropLightEmitter(
                ConfigurablePropBlockProperties.stone()
        ).setBlockName("configurablePropStoneLightEmitter");
        GameRegistry.registerBlock(
                configurablePropStoneLightEmitter,
                "configurable_prop_stone_light_emitter"
        );
        catalogBlocksRegistered = true;
    }

    /**
     * Selects the bounded shared part family matching a prop's authored material.
     * Exact coordinate-aware hardness and resistance still delegate to the
     * controller, while this selection supplies Minecraft's immutable material
     * and sound fields.
     *
     * @param definition definition owning the prospective part
     * @param lightEmitter whether the cell is an authored light emitter
     * @return registered wood, metal, or stone structure-part block
     */
    public static Block getStructurePartBlock(
            ConfigurablePropDefinition definition,
            boolean lightEmitter
    )
    {
        Material material = definition != null
                ? definition.getBlockProperties().getMaterial()
                : Material.wood;
        if (material == Material.iron)
        {
            return lightEmitter
                    ? configurablePropMetalLightEmitter
                    : configurablePropMetalPart;
        }
        if (material == Material.rock)
        {
            return lightEmitter
                    ? configurablePropStoneLightEmitter
                    : configurablePropStonePart;
        }
        return lightEmitter ? configurablePropLightEmitter : configurablePropPart;
    }

    /**
     * Tests whether a block is one of the registered invisible part families.
     *
     * @param block candidate block
     * @return {@code true} for any wood, metal, or stone part or emitter block
     */
    public static boolean isStructurePartBlock(Block block)
    {
        return block == configurablePropPart
                || block == configurablePropLightEmitter
                || block == configurablePropMetalPart
                || block == configurablePropMetalLightEmitter
                || block == configurablePropStonePart
                || block == configurablePropStoneLightEmitter;
    }

    /** Completes registration for an entry added after block creation began. */
    private static void registerContentAfterBlockCreation(IConfigurablePropContentEntry content)
    {
        ConfigurablePropCatalog.registerEntry(content);
        content.registerCustomization();
        ConfigurablePropRegistry.register(content.getCatalogEntry().getDefinition());
        registerContentBlock(content);
    }

    /** Creates and registers the controller block belonging to one content entry. */
    private static void registerContentBlock(IConfigurablePropContentEntry content)
    {
        ConfigurablePropCatalogEntry entry = content.getCatalogEntry();
        Block block = createConfigurablePropBlock(entry);
        GameRegistry.registerBlock(
                block,
                ItemBlockConfigurableProp.class,
                entry.getRegistryName()
        );
        ConfigurablePropRegistry.registerBlock(entry.getDefinition().getId(), block);
    }

    /** Constructs a controller using catalog identity and definition properties. */
    private static Block createConfigurablePropBlock(ConfigurablePropCatalogEntry entry)
    {
        return new BlockConfigurablePropController(
                entry.getDefinition().getId(),
                entry.getResourceDomain(),
                entry.getIconPath(),
                entry.getDefinition().getBlockProperties(),
                entry.getDefinition().hasLight()
        )
                .setBlockName(entry.getBlockName())
                .setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
    }

    /** Publishes the built-in storage and seat interaction strategies. */
    private static void registerInteractions()
    {
        ConfigurablePropInteractionRegistry.register(
                ConfigurablePropIds.INTERACTION_SEAT,
                new SeatPropInteraction()
        );
        ConfigurablePropInteractionRegistry.register(
                ConfigurablePropIds.INTERACTION_STORAGE,
                new StoragePropInteraction()
        );
        ConfigurablePropInteractionRegistry.register(
                ConfigurablePropIds.INTERACTION_FRIDGE_STORAGE,
                new FridgeStoragePropInteraction()
        );
        ConfigurablePropInteractionRegistry.register(
                ConfigurablePropIds.INTERACTION_LIGHT,
                new LightPropInteraction()
        );
    }

    /** Registers the shared configurable controller, part, and light-emitter tiles. */
    private static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(
                TileConfigurablePropController.class,
                FoxBlocks.MODID + ":configurable_prop_controller"
        );
        GameRegistry.registerTileEntity(
                TileConfigurablePropStorage.class,
                FoxBlocks.MODID + ":configurable_prop_storage"
        );
        GameRegistry.registerTileEntity(
                TileConfigurablePropProcessor.class,
                FoxBlocks.MODID + ":configurable_prop_processor"
        );
        GameRegistry.registerTileEntity(
                TileConfigurablePropPart.class,
                FoxBlocks.MODID + ":configurable_prop_part"
        );
        GameRegistry.registerTileEntity(
                TileConfigurablePropLightEmitter.class,
                FoxBlocks.MODID + ":configurable_prop_light_emitter"
        );
    }
}
