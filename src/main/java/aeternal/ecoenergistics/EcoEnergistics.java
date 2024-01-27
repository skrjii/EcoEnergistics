package aeternal.ecoenergistics;

import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.common.creativetab.EcoEnergisticsCreativeTab;
import aeternal.ecoenergistics.common.enums.Ore;
import aeternal.ecoenergistics.common.item.EcoEnergisticsItems;
import aeternal.ecoenergistics.common.world.GenHandler;
import aeternal.ecoenergistics.proxy.CommonProxy;
import io.netty.buffer.ByteBuf;
import mekanism.api.MekanismAPI;
import mekanism.api.transmitters.DynamicNetwork;
import mekanism.client.ClientTickHandler;
import mekanism.common.Mekanism;
import mekanism.common.Version;
import mekanism.common.base.IModule;
import mekanism.common.config.MekanismConfig;
import mekanism.common.network.PacketSimpleGui;
import mekanism.common.recipe.BinRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.CompoundDataFixer;
import net.minecraftforge.common.util.ModFixs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

import static aeternal.ecoenergistics.common.EcoEnergisticsBlocks.OreBlock;
import static aeternal.ecoenergistics.common.Infusers.registerInfuseObject;
import static aeternal.ecoenergistics.common.Infusers.registerInfuseType;
import static aeternal.ecoenergistics.common.item.EcoEnergisticsItems.Dust;
import static aeternal.ecoenergistics.common.recipes.Crusher.InitCustomCrusherRecipes;
import static aeternal.ecoenergistics.common.recipes.Enrichment.InitCustomEnrichmentRecipes;
import static aeternal.ecoenergistics.common.recipes.Infuser.InitCustomInfuserRecipes;
import static aeternal.ecoenergistics.common.recipes.Injection.InitCustomInjectionRecipes;
import static aeternal.ecoenergistics.common.recipes.Purification.InitCustomPurificationRecipes;


@Mod(modid = EcoEnergistics.MOD_ID, useMetadata = true, guiFactory = "mekanism.generators.client.gui.GeneratorsGuiFactory", dependencies = "required-after:mekanism;required-after:mekanismgenerators")
@Mod.EventBusSubscriber()
public class EcoEnergistics implements IModule {

    public static final String MOD_ID = "mekanismecoenergistics";
    public static Configuration configuration;
    public static EcoEnergisticsCreativeTab tabEcoEnergistics = new EcoEnergisticsCreativeTab();

    @SidedProxy(clientSide = "aeternal.ecoenergistics.proxy.ClientProxy", serverSide = "aeternal.ecoenergistics.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Instance(EcoEnergistics.MOD_ID)
    public static EcoEnergistics instance;

    public static Version versionNumber = new Version(999, 999, 999);
    public static final int DATA_VERSION = 1;
    public static GenHandler genHandler = new GenHandler();
    public static Logger logger = LogManager.getLogger("EcoEnergistics");

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        EcoEnergisticsBlocks.registerBlocks(event.getRegistry());
        if (Constants.AvaritiaLoaded && Constants.AvaritiaConfirm) {
            EcoEnergisticsBlocks.registerAvaritiaBlocks(event.getRegistry());
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        EcoEnergisticsItems.registerItems(event.getRegistry());
        EcoEnergisticsBlocks.registerItemBlocks(event.getRegistry());
        registerOreDict();
        if (Constants.AvaritiaLoaded && Constants.AvaritiaConfirm) {
            EcoEnergisticsBlocks.registerAvaritiaItemBlocks(event.getRegistry());
        }
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        proxy.registerBlockRenders();
        proxy.registerItemRenders();

    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        registerInfuseType();
        File config = event.getSuggestedConfigurationFile();
        //Set the mod's configuration
        configuration = new Configuration(config);

        //Load configuration
        proxy.loadConfiguration();

        proxy.preInit();


    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //Add this module to the core list
        Mekanism.modulesLoaded.add(this);

        //Register this module's GUI handler in the simple packet protocol
        PacketSimpleGui.handlers.add(1, proxy);

        //Set up the GUI handler
        //     NetworkRegistry.INSTANCE.registerGuiHandler(this, new GeneratorsGuiHandler());
        MinecraftForge.EVENT_BUS.register(this);


        proxy.registerTileEntities();
        proxy.registerTESRs();
        GameRegistry.registerWorldGenerator(genHandler, 1);

        CompoundDataFixer fixer = FMLCommonHandler.instance().getDataFixer();
        ModFixs fixes = fixer.init(MOD_ID, DATA_VERSION);
        Mekanism.logger.info("Loaded MekanismEcoEnergistics module.");
    }


    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        event.getRegistry().register(new BinRecipe());
        InitCustomInfuserRecipes();
        InitCustomEnrichmentRecipes();
        InitCustomPurificationRecipes();
        InitCustomCrusherRecipes();
        InitCustomInjectionRecipes();
        InitSmeltingRecipes();
        registerInfuseObject();
    }

    public static void InitSmeltingRecipes() {
        GameRegistry.addSmelting(new ItemStack(EcoEnergisticsItems.MoreDust, 1, aeternal.ecoenergistics.common.enums.MoreDust.ACTIVATEDGLOWSTONE.ordinal()), new ItemStack(EcoEnergisticsItems.MoreIngot, 1, 0), 0.0F);
        GameRegistry.addSmelting(new ItemStack(Dust, 1, aeternal.ecoenergistics.common.enums.Dust.TITANIUM.ordinal()), new ItemStack(EcoEnergisticsItems.MoreIngot, 1, 1), 0.0F);
        GameRegistry.addSmelting(new ItemStack(Dust, 1, aeternal.ecoenergistics.common.enums.Dust.URANIUM.ordinal()), new ItemStack(EcoEnergisticsItems.MoreIngot, 1, 2), 0.0F);
        GameRegistry.addSmelting(new ItemStack(Dust, 1, aeternal.ecoenergistics.common.enums.Dust.IRIDIUM.ordinal()), new ItemStack(EcoEnergisticsItems.MoreIngot, 1, 3), 0.0F);
        GameRegistry.addSmelting(new ItemStack(OreBlock, 1, Ore.TITANIUM.ordinal()), new ItemStack(EcoEnergisticsItems.MoreIngot, 1, 1), 0.0F);
        GameRegistry.addSmelting(new ItemStack(OreBlock, 1, Ore.URANIUM.ordinal()), new ItemStack(EcoEnergisticsItems.MoreIngot, 1, 2), 0.0F);
        GameRegistry.addSmelting(new ItemStack(OreBlock, 1, Ore.IRIDIUM.ordinal()), new ItemStack(EcoEnergisticsItems.MoreIngot, 1, 3), 0.0F);
    }

    public static void registerOreDict() {

        OreDictionary.registerOre("dustLapisCrushed", new ItemStack(EcoEnergisticsItems.MoreDust, 1, 0));
        OreDictionary.registerOre("dustEmeraldCrushed", new ItemStack(EcoEnergisticsItems.MoreDust, 1, 1));
        OreDictionary.registerOre("dustEnrichedGlowstone", new ItemStack(EcoEnergisticsItems.MoreDust, 1, 2));
        OreDictionary.registerOre("dustTitanium", new ItemStack(Dust, 1, 0));
        OreDictionary.registerOre("dustUranium", new ItemStack(Dust, 1, 1));
        OreDictionary.registerOre("dustIridium", new ItemStack(Dust, 1, 2));

        OreDictionary.registerOre("itemCompressedLapis", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 0));
        OreDictionary.registerOre("itemCompressedEmerald", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 1));
        OreDictionary.registerOre("itemCompressedGlowstone", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 2));
        OreDictionary.registerOre("itemCompressedGold", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 3));
        OreDictionary.registerOre("itemCompressedTitanium", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 4));
        OreDictionary.registerOre("itemCompressedUranium", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 5));
        OreDictionary.registerOre("itemCompressedIridium", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 6));

        OreDictionary.registerOre("ingotTitanium", new ItemStack(EcoEnergisticsItems.MoreIngot, 1, 1));
        OreDictionary.registerOre("ingotUranium", new ItemStack(EcoEnergisticsItems.MoreIngot, 1, 2));
        OreDictionary.registerOre("ingotIridium", new ItemStack(EcoEnergisticsItems.MoreIngot, 1, 3));

        OreDictionary.registerOre("nuggetActivatedGlowstone", new ItemStack(EcoEnergisticsItems.MoreNugget, 1, 0));
        OreDictionary.registerOre("nuggetTitanium", new ItemStack(EcoEnergisticsItems.MoreNugget, 1, 1));
        OreDictionary.registerOre("nuggetUranium", new ItemStack(EcoEnergisticsItems.MoreNugget, 1, 2));
        OreDictionary.registerOre("nuggetIridium", new ItemStack(EcoEnergisticsItems.MoreNugget, 1, 3));

        OreDictionary.registerOre("dustDirtyTitanium", new ItemStack(EcoEnergisticsItems.MoreDirtyDust, 1, 0));
        OreDictionary.registerOre("dustDirtyUranium", new ItemStack(EcoEnergisticsItems.MoreDirtyDust, 1, 1));
        OreDictionary.registerOre("dustDirtyIridium", new ItemStack(EcoEnergisticsItems.MoreDirtyDust, 1, 2));

        OreDictionary.registerOre("clumpTitanium", new ItemStack(EcoEnergisticsItems.MoreClump, 1, 0));
        OreDictionary.registerOre("clumpUranium", new ItemStack(EcoEnergisticsItems.MoreClump, 1, 1));
        OreDictionary.registerOre("clumpIridium", new ItemStack(EcoEnergisticsItems.MoreClump, 1, 2));

        OreDictionary.registerOre("shardTitanium", new ItemStack(EcoEnergisticsItems.MoreShard, 1, 0));
        OreDictionary.registerOre("shardUranium", new ItemStack(EcoEnergisticsItems.MoreShard, 1, 1));
        OreDictionary.registerOre("shardIridium", new ItemStack(EcoEnergisticsItems.MoreShard, 1, 2));

        OreDictionary.registerOre("crystalTitanium", new ItemStack(EcoEnergisticsItems.MoreCrystal, 1, 0));
        OreDictionary.registerOre("crystalUranium", new ItemStack(EcoEnergisticsItems.MoreCrystal, 1, 1));
        OreDictionary.registerOre("crystalIridium", new ItemStack(EcoEnergisticsItems.MoreCrystal, 1, 2));

        OreDictionary.registerOre("oreTitanium", new ItemStack(OreBlock, 1, 0));
        OreDictionary.registerOre("oreUranium", new ItemStack(OreBlock, 1, 1));
        OreDictionary.registerOre("oreIridium", new ItemStack(OreBlock, 1, 2));

        OreDictionary.registerOre("blockTitanium", new ItemStack(EcoEnergisticsBlocks.BlockBasic, 1, 0));
        OreDictionary.registerOre("blockUranium", new ItemStack(EcoEnergisticsBlocks.BlockBasic, 1, 1));
        OreDictionary.registerOre("blockIridium", new ItemStack(EcoEnergisticsBlocks.BlockBasic, 1, 2));

        OreDictionary.registerOre("circuitAdvancedVariation", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 0));
        OreDictionary.registerOre("circuitHybrid", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 1));
        OreDictionary.registerOre("circuitPerfectHybrid", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 2));
        OreDictionary.registerOre("circuitQuantum", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 3));
        OreDictionary.registerOre("circuitSpectral", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 4));
        OreDictionary.registerOre("circuitProtonic", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 5));
        OreDictionary.registerOre("circuitSingular", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 6));
        OreDictionary.registerOre("circuitDiffractive", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 7));
        OreDictionary.registerOre("circuitPhotonic", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 8));
        OreDictionary.registerOre("circuitNeutron", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 9));

        OreDictionary.registerOre("alloyAdvancedVariation", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 0));
        OreDictionary.registerOre("alloyHybrid", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 1));
        OreDictionary.registerOre("alloyPerfectHybrid", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 2));
        OreDictionary.registerOre("alloyQuantum", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 3));
        OreDictionary.registerOre("alloySpectral", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 4));
        OreDictionary.registerOre("alloyProtonic", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 5));
        OreDictionary.registerOre("alloySingular", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 6));
        OreDictionary.registerOre("alloyDiffractive", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 7));
        OreDictionary.registerOre("alloyPhotonic", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 8));
        OreDictionary.registerOre("alloyNeutron", new ItemStack(EcoEnergisticsItems.MoreControlCircuit, 1, 9));
    }

    @Override
    public Version getVersion() {
        return versionNumber;
    }

    @Override
    public String getName() {
        return "EcoEnergistics";
    }

    @Override
    public void writeConfig(ByteBuf dataStream, MekanismConfig config) {
        config.generators.write(dataStream);
    }

    @Override
    public void readConfig(ByteBuf dataStream, MekanismConfig destConfig) {
        destConfig.generators.read(dataStream);
    }

    @Override
    public void resetClient() {
    }


    @SubscribeEvent
    public void onConfigChanged(OnConfigChangedEvent event) {
        if (event.getModID().equals(EcoEnergistics.MOD_ID) || event.getModID().equals(EcoEnergistics.MOD_ID)) {
            proxy.loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onBlacklistUpdate(MekanismAPI.BoxBlacklistEvent event) {
        MekanismAPI.addBoxBlacklist(EcoEnergisticsBlocks.EcoGenerator, 2); // Advanced Solar Station
    }
}