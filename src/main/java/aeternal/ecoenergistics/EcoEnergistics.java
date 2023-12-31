package aeternal.ecoenergistics;

import aeternal.ecoenergistics.common.EcoGeneratorsBlocks;
import aeternal.ecoenergistics.common.creativetab.EcoEnergisticsCreativeTab;
import aeternal.ecoenergistics.common.item.EcoEnergisticsItems;
import aeternal.ecoenergistics.proxy.CommonProxy;
import io.netty.buffer.ByteBuf;
import mekanism.api.MekanismAPI;
import mekanism.api.infuse.InfuseObject;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.infuse.InfuseType;
import mekanism.common.Mekanism;
import mekanism.common.MekanismItems;
import mekanism.common.Version;
import mekanism.common.base.IModule;
import mekanism.common.block.states.BlockStateMachine;
import mekanism.common.config.MekanismConfig;
import mekanism.common.network.PacketSimpleGui;
import mekanism.common.recipe.BinRecipe;
import mekanism.common.recipe.RecipeHandler;
import mekanism.generators.common.GeneratorsGuiHandler;
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
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.io.File;

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


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        EcoGeneratorsBlocks.registerBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        EcoEnergisticsItems.registerItems(event.getRegistry());
        EcoGeneratorsBlocks.registerItemBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        proxy.registerBlockRenders();
        proxy.registerItemRenders();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
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

        CompoundDataFixer fixer = FMLCommonHandler.instance().getDataFixer();
        ModFixs fixes = fixer.init(MOD_ID, DATA_VERSION);
        
        Mekanism.logger.info("Loaded MekanismEcoEnergistics module.");
    }
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        event.getRegistry().register(new BinRecipe());
        addRecipes();

    }
    public static void addRecipes() {
        if (MekanismConfig.current().general.machinesManager.isEnabled(BlockStateMachine.MachineType.METALLURGIC_INFUSER)) {
            InfuseType carbon = InfuseRegistry.get("CARBON");
            InfuseType diamond = InfuseRegistry.get("DIAMOND");
            InfuseType obsidian = InfuseRegistry.get("OBSIDIAN");
         //   InfuseType gold = InfuseRegistry.get("GOLD");


            //Infuse Objects
         //   ItemStack goldDust = new ItemStack(MekanismItems.Dust, 1, 1);
         //   InfuseRegistry.registerInfuseObject(goldDust, new InfuseObject(gold, 80));


            ItemStack advancedAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 0);
            ItemStack hybridAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 1);
            ItemStack perfecthybridAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 2);
            ItemStack quantumAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 3);
            ItemStack spectralAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 4);
            ItemStack protonicAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 5);
            ItemStack singularAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 6);
            ItemStack diffractiveAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 7);
            ItemStack photonicAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 8);
            ItemStack neutronAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 9);


            //Metallurgic Infuser Recipes
            // Metallurgic Infuser Recipes
            RecipeHandler.addMetallurgicInfuserRecipe(diamond, 10, new ItemStack(MekanismItems.ReinforcedAlloy), advancedAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(diamond, 15, advancedAlloy, hybridAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(diamond, 20, hybridAlloy, perfecthybridAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(diamond, 25, perfecthybridAlloy, quantumAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(diamond, 30, quantumAlloy, spectralAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(obsidian, 15, spectralAlloy, protonicAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(obsidian, 20, protonicAlloy, singularAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(obsidian, 25, singularAlloy, diffractiveAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(obsidian, 30, diffractiveAlloy, photonicAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(obsidian, 35, photonicAlloy, neutronAlloy);
        }
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