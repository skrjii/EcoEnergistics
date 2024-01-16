package aeternal.ecoenergistics;

import aeternal.ecoenergistics.common.EcoGeneratorsBlocks;
import aeternal.ecoenergistics.common.Infusers;
import aeternal.ecoenergistics.common.creativetab.EcoEnergisticsCreativeTab;
import aeternal.ecoenergistics.common.enums.MoreDust;
import aeternal.ecoenergistics.common.enums.Ingot;
import aeternal.ecoenergistics.common.item.EcoEnergisticsItems;
import aeternal.ecoenergistics.common.recipes.Infuser;
import aeternal.ecoenergistics.common.world.GenHandler;
import aeternal.ecoenergistics.proxy.CommonProxy;
import io.netty.buffer.ByteBuf;
import mekanism.api.MekanismAPI;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.infuse.InfuseType;
import mekanism.common.Mekanism;
import mekanism.common.MekanismItems;
import mekanism.common.Resource;
import mekanism.common.Version;
import mekanism.common.base.IModule;
import mekanism.common.block.states.BlockStateMachine;
import mekanism.common.config.MekanismConfig;
import mekanism.common.network.PacketSimpleGui;
import mekanism.common.recipe.BinRecipe;
import mekanism.common.recipe.RecipeHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

import java.io.File;

import static aeternal.ecoenergistics.common.Infusers.*;
import static aeternal.ecoenergistics.common.recipes.Crusher.InitCustomCrusherRecipes;
import static aeternal.ecoenergistics.common.recipes.Enrichment.InitCustomEnrichmentRecipes;
import static aeternal.ecoenergistics.common.recipes.Infuser.InitCustomInfuserRecipes;
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

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        EcoGeneratorsBlocks.registerBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        EcoEnergisticsItems.registerItems(event.getRegistry());
        EcoGeneratorsBlocks.registerItemBlocks(event.getRegistry());
        registerOreDict();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        proxy.registerBlockRenders();
        proxy.registerItemRenders();

    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    //    InfuseRegistry.registerInfuseType(new InfuseType("GOLD", new ResourceLocation(Constants.MOD_ID, "blocks/infuse/InfuseGold")).setTranslationKey("gold"));
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
        registerInfuseObject();
    }

/*    public static void addRecipes() {

        //Crusher
        *//*if (MekanismConfig.current().general.machinesManager.isEnabled(BlockStateMachine.MachineType.CRUSHER)) {
            RecipeHandler.addCrusherRecipe(new ItemStack(Items.DYE,1,4), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.LAPIS.ordinal()));
            RecipeHandler.addCrusherRecipe(new ItemStack(EcoEnergisticsItems.MoreIngot,1,Ingot.ACTIVATEDGLOWSTONE.ordinal()), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.ACTIVATEDGLOWSTONE.ordinal()));
            RecipeHandler.addCrusherRecipe(new ItemStack(Items.EMERALD), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.EMERALD.ordinal()));
            RecipeHandler.addCrusherRecipe(new ItemStack(EcoEnergisticsItems.MoreIngot, 1, Ingot.ACTIVATEDGLOWSTONE.ordinal()), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.ACTIVATEDGLOWSTONE.ordinal()));
        }*//*


        //Enrichment
        *//*if (Constants.ENRICHMENT_ENABLED) {
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.LAPIS.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 0));
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.EMERALD.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 1));
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.ACTIVATEDGLOWSTONE.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 2));
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(MekanismItems.Dust,1,Resource.GOLD.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 3));
         //   RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(MekanismItems.Ingot,1,3), new ItemStack(EcoEnergisticsItems.MoreIngot, 1, Ingot.ACTIVATEDGLOWSTONE.ordinal()));
        }*//*

        //Purification Chamber Recipes
        if (MekanismConfig.current().general.machinesManager.isEnabled(BlockStateMachine.MachineType.PURIFICATION_CHAMBER)) {
            RecipeHandler.addPurificationChamberRecipe(new ItemStack(Blocks.GRAVEL), new ItemStack(Items.FLINT));
        }
    }*/
    public static void registerOreDict() {

        OreDictionary.registerOre("dustLapisCrushed", new ItemStack(EcoEnergisticsItems.MoreDust, 1, 0));
        OreDictionary.registerOre("dustEmeraldCrushed", new ItemStack(EcoEnergisticsItems.MoreDust, 1, 1));
        OreDictionary.registerOre("dustEnrichedGlowstone", new ItemStack(EcoEnergisticsItems.MoreDust, 1, 2));
        OreDictionary.registerOre("itemCompressedLapis", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 0));
        OreDictionary.registerOre("itemCompressedEmerald", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 1));
        OreDictionary.registerOre("itemCompressedGlowstone", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 2));
        OreDictionary.registerOre("itemCompressedGold", new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 3));

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
        MekanismAPI.addBoxBlacklist(EcoGeneratorsBlocks.EcoGenerator, 2); // Advanced Solar Station
    }
}