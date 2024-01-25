package aeternal.ecoenergistics.proxy;

//import aeternal.ecoenergistics.client.gui.GuiSolarPanel;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.client.render.EcoERender;
import aeternal.ecoenergistics.client.render.item.RenderEcoGeneratorItem;
import aeternal.ecoenergistics.client.render.item.RenderEcoGeneratorItemAdd;
import aeternal.ecoenergistics.client.render.obj.TransmitterModel;
import aeternal.ecoenergistics.client.render.solar.panel.*;
import aeternal.ecoenergistics.client.render.solar.station.*;
import aeternal.ecoenergistics.client.render.transmitter.RenderMechanicalPipe;
import aeternal.ecoenergistics.client.render.transmitter.RenderPressurizedTube;
import aeternal.ecoenergistics.client.render.transmitter.RenderUniversalCable;
import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.common.block.states.*;
import aeternal.ecoenergistics.common.block.states.BlockStateBasic.EnumBasicType;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoGenerator.EcoGeneratorType;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoTransmitter.EcoTransmitterType;
import aeternal.ecoenergistics.common.block.states.BlockStateOre.EnumOreType;
import aeternal.ecoenergistics.common.item.EcoEnergisticsItems;
import aeternal.ecoenergistics.common.item.ItemBlockEcoTransmitter;
import aeternal.ecoenergistics.common.tier.MEETiers;
import aeternal.ecoenergistics.common.tile.solar.panel.*;
import aeternal.ecoenergistics.common.tile.solar.station.*;
import aeternal.ecoenergistics.common.tile.transmitter.TileEntityEcoMechanicalPipe;
import aeternal.ecoenergistics.common.tile.transmitter.TileEntityEcoPressurizedTube;
import aeternal.ecoenergistics.common.tile.transmitter.TileEntityEcoUniversalCable;
import mekanism.client.render.item.ItemLayerWrapper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    private static final IStateMapper generatorMapper = new BlockStateEcoGenerator.GeneratorBlockStateMapper();
    private static final IStateMapper generatorMapperAdd = new BlockStateEcoGeneratorAdd.GeneratorBlockStateMapperAdd();
    private static final IStateMapper transmitterMapper = new BlockStateEcoTransmitter.TransmitterStateMapper();
    public static Map<String, ModelResourceLocation> transmitterResources = new HashMap<>();
    public static long ticksPassed = 0;
    @Override
    public boolean isPaused() {
        if (FMLClientHandler.instance().getClient().isSingleplayer() && !FMLClientHandler.instance().getClient().getIntegratedServer().getPublic()) {
            GuiScreen screen = FMLClientHandler.instance().getClient().currentScreen;
            return screen != null && screen.doesGuiPauseGame();
        }
        return false;
    }

    @Override
    public void registerTESRs() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelAdvanced.class, new RenderSolarPanelAdv());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelHybrid.class, new RenderSolarPanelHybrid());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelPerfectHybrid.class, new RenderSolarPanelPerfectHybrid());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelQuantum.class, new RenderSolarPanelQuantum());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelSpectral.class, new RenderSolarPanelSpectral());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelProtonic.class, new RenderSolarPanelProtonic());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelSingular.class, new RenderSolarPanelSingular());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelDiffractive.class, new RenderSolarPanelDiffractive());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelPhotonic.class, new RenderSolarPanelPhotonic());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelNeutron.class, new RenderSolarPanelNeutron());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarStationAdv.class, new RenderSolarStationAdv());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarStationHybrid.class, new RenderSolarStationHybrid());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarStationPerfectHybrid.class, new RenderSolarStationPerfectHybrid());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarStationQuantum.class, new RenderSolarStationQuantum());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarStationSpectral.class, new RenderSolarStationSpectral());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarStationProtonic.class, new RenderSolarStationProtonic());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarStationSingular.class, new RenderSolarStationSingular());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarStationDiffractive.class, new RenderSolarStationDiffractive());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarStationPhotonic.class, new RenderSolarStationPhotonic());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarStationNeutron.class, new RenderSolarStationNeutron());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEcoUniversalCable.class, new RenderUniversalCable());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEcoPressurizedTube.class, new RenderPressurizedTube());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEcoMechanicalPipe.class, new RenderMechanicalPipe());
    }


    @Override
    public void registerItemRenders() {
        Item.getItemFromBlock(EcoEnergisticsBlocks.EcoGenerator).setTileEntityItemStackRenderer(new RenderEcoGeneratorItem());
        Item.getItemFromBlock(EcoEnergisticsBlocks.EcoGeneratorAdd).setTileEntityItemStackRenderer(new RenderEcoGeneratorItemAdd());
        registerItemRender(EcoEnergisticsItems.MoreControlCircuit);
        registerItemRender(EcoEnergisticsItems.MoreAlloy);
        registerItemRender(EcoEnergisticsItems.MoreDust);
        registerItemRender(EcoEnergisticsItems.Dust);
        registerItemRender(EcoEnergisticsItems.MoreCompressed);
        registerItemRender(EcoEnergisticsItems.MoreRod);
        registerItemRender(EcoEnergisticsItems.MoreIngot);
        registerItemRender(EcoEnergisticsItems.MoreNugget);
        registerItemRender(EcoEnergisticsItems.MoreCrystal);
        registerItemRender(EcoEnergisticsItems.MoreClump);
        registerItemRender(EcoEnergisticsItems.MoreShard);
        registerItemRender(EcoEnergisticsItems.MoreDirtyDust);
        registerItemRender(EcoEnergisticsItems.MoreSolarCell);
        registerItemRender(EcoEnergisticsItems.EnergyTabletAdvanced);
        registerItemRender(EcoEnergisticsItems.EnergyTabletHybrid);
        registerItemRender(EcoEnergisticsItems.EnergyTabletPerfectHybrid);
        registerItemRender(EcoEnergisticsItems.EnergyTabletQuantum);
        registerItemRender(EcoEnergisticsItems.EnergyTabletSpectral);
        registerItemRender(EcoEnergisticsItems.EnergyTabletProtonic);
        registerItemRender(EcoEnergisticsItems.EnergyTabletSingular);
        registerItemRender(EcoEnergisticsItems.EnergyTabletDiffractive);
        registerItemRender(EcoEnergisticsItems.EnergyTabletPhotonic);
        registerItemRender(EcoEnergisticsItems.EnergyTabletNeutron);
    }

    @Override
    public void registerBlockRenders() {
        ModelLoader.setCustomStateMapper(EcoEnergisticsBlocks.EcoGenerator, generatorMapper);
        ModelLoader.setCustomStateMapper(EcoEnergisticsBlocks.EcoGeneratorAdd, generatorMapperAdd);
        ModelLoader.setCustomStateMapper(EcoEnergisticsBlocks.EcoTransmitter, transmitterMapper);
        for (EcoGeneratorType type : EcoGeneratorType.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(type.blockType.getBlock()), type.meta, new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, type.getName()), "inventory"));
        }
        for (EcoGeneratorTypeAdd type : EcoGeneratorTypeAdd.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(type.blockType.getBlock()), type.meta, new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, type.getName()), "inventory"));
        }
        for (EnumOreType ore : BlockStateOre.EnumOreType.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(EcoEnergisticsBlocks.OreBlock), ore.ordinal(), new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, "OreBlock"), "type=" + ore.getName()));
        }
        for (EnumBasicType block : BlockStateBasic.EnumBasicType.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(EcoEnergisticsBlocks.BlockBasic), block.ordinal(), new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, "BlockBasic"), "type=" + block.getName()));
        }

        for (EcoTransmitterType type : EcoTransmitterType.values()) {
            List<ModelResourceLocation> modelsToAdd = new ArrayList<>();
            String resource = "mekanism:" + type.getName();
            MEETiers tierPointer = null;

            if (type.hasTiers()) {
                tierPointer = MEETiers.values()[0];
                resource = "mekanismecoenergistics:" + type.getName() + "_" + tierPointer.getName();
            }

            while (true) {
                if (transmitterResources.get(resource) == null) {
                    String properties = "inventory";
                    ModelResourceLocation model = new ModelResourceLocation(resource, properties);
                    transmitterResources.put(resource, model);
                    modelsToAdd.add(model);
                    if (type.hasTiers()) {
                        if (tierPointer.ordinal() < MEETiers.values().length - 1) {
                            tierPointer = MEETiers.values()[tierPointer.ordinal() + 1];
                            if (true) {
                                resource = "mekanismecoenergistics:" + type.getName() + "_" + tierPointer.getName();
                                continue;
                            }
                        }
                    }
                }
                break;
            }

            ModelLoader.registerItemVariants(Item.getItemFromBlock(EcoEnergisticsBlocks.EcoTransmitter), modelsToAdd.toArray(new ModelResourceLocation[]{}));
        }
        ItemMeshDefinition transmitterMesher = stack -> {
            EcoTransmitterType type = EcoTransmitterType.get(stack.getItemDamage());

            if (type != null) {
                String resource = "mekanismecoenergistics:" + type.getName();
                if (type.hasTiers()) {
                    MEETiers tier = ((ItemBlockEcoTransmitter) stack.getItem()).getBaseTier(stack);
                    resource = "mekanismecoenergistics:" + type.getName() + "_" + tier.getName();
                }
                return transmitterResources.get(resource);
            }
            return null;
        };

        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(EcoEnergisticsBlocks.EcoTransmitter), transmitterMesher);

    }

    public void registerItemRender(Item item) {
        EcoERender.registerItemRender(Constants.MOD_ID, item);
    }

    @SubscribeEvent
    public void onModelBake(ModelBakeEvent event) {
        IRegistry<ModelResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
        generatorModelBake(modelRegistry, EcoGeneratorType.SOLAR_PANEL_ADVANCED);
        generatorModelBake(modelRegistry, EcoGeneratorType.SOLAR_PANEL_HYBRID);
        generatorModelBake(modelRegistry, EcoGeneratorType.SOLAR_PANEL_PERFECTHYBRID);
        generatorModelBake(modelRegistry, EcoGeneratorType.SOLAR_PANEL_QUANTUM);
        generatorModelBake(modelRegistry, EcoGeneratorType.SOLAR_PANEL_SPECTRAL);
        generatorModelBake(modelRegistry, EcoGeneratorType.SOLAR_PANEL_PROTONIC);
        generatorModelBake(modelRegistry, EcoGeneratorType.SOLAR_PANEL_SINGULAR);
        generatorModelBake(modelRegistry, EcoGeneratorType.SOLAR_PANEL_DIFFRACTIVE);
        generatorModelBake(modelRegistry, EcoGeneratorType.SOLAR_PANEL_PHOTONIC);
        generatorModelBake(modelRegistry, EcoGeneratorType.SOLAR_PANEL_NEUTRON);
    }
    @SubscribeEvent
    public void onModelBake2(ModelBakeEvent event) {
        IRegistry<ModelResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
        generatorModelBake2(modelRegistry, EcoGeneratorTypeAdd.SOLAR_STATION_ADVANCED);
        generatorModelBake2(modelRegistry, EcoGeneratorTypeAdd.SOLAR_STATION_HYBRID);
        generatorModelBake2(modelRegistry, EcoGeneratorTypeAdd.SOLAR_STATION_PERFECTHYBRID);
        generatorModelBake2(modelRegistry, EcoGeneratorTypeAdd.SOLAR_STATION_QUANTUM);
        generatorModelBake2(modelRegistry, EcoGeneratorTypeAdd.SOLAR_STATION_SPECTRAL);
        generatorModelBake2(modelRegistry, EcoGeneratorTypeAdd.SOLAR_STATION_PROTONIC);
        generatorModelBake2(modelRegistry, EcoGeneratorTypeAdd.SOLAR_STATION_SINGULAR);
        generatorModelBake2(modelRegistry, EcoGeneratorTypeAdd.SOLAR_STATION_DIFFRACTIVE);
        generatorModelBake2(modelRegistry, EcoGeneratorTypeAdd.SOLAR_STATION_PHOTONIC);
        generatorModelBake2(modelRegistry, EcoGeneratorTypeAdd.SOLAR_STATION_NEUTRON);
    }

    private void generatorModelBake(IRegistry<ModelResourceLocation, IBakedModel> modelRegistry, EcoGeneratorType type) {
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, type.getName()), "inventory");
        ItemLayerWrapper itemLayerWrapper = new ItemLayerWrapper(modelRegistry.getObject(modelResourceLocation));
        RenderEcoGeneratorItem.modelMap.put(type, itemLayerWrapper);
        modelRegistry.putObject(modelResourceLocation, itemLayerWrapper);
    }
    private void generatorModelBake2(IRegistry<ModelResourceLocation, IBakedModel> modelRegistry, EcoGeneratorTypeAdd type) {
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, type.getName()), "inventory");
        ItemLayerWrapper itemLayerWrapper = new ItemLayerWrapper(modelRegistry.getObject(modelResourceLocation));
        RenderEcoGeneratorItemAdd.modelMap.put(type, itemLayerWrapper);
        modelRegistry.putObject(modelResourceLocation, itemLayerWrapper);
    }

    @Override
    public void preInit() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    /*@Override
    public GuiScreen getClientGui(int ID, EntityPlayer player, World world, BlockPos pos) {
        TileEntity tileEntity = world.getTileEntity(pos);

        if (ID == 0) {
            return new GuiSolarPanel(player.inventory, (TileEntitySolarPanelAdvanced) tileEntity);
        }

        return null;
    }*/

    @SubscribeEvent
    public void onStitch(TextureStitchEvent.Pre event) {
    }

    public static void reset() {

        TransmitterModel.clearCache();


    }
}