package aeternal.ecoenergistics.proxy;

import aeternal.ecoenergistics.EcoEnergistics;
import aeternal.ecoenergistics.common.tile.solar.panel.*;
import aeternal.ecoenergistics.common.tile.solar.station.*;
import aeternal.ecoenergistics.config.BaseConfig;
import aeternal.ecoenergistics.config.Config;
import aeternal.ecoenergistics.config.EcoConfig;
import mekanism.common.Mekanism;
import mekanism.common.base.IGuiProvider;
import mekanism.common.config.MekanismConfig;
import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.inventory.container.ContainerEcoSolarPanel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiProvider {

    private static void registerTileEntity(Class<? extends TileEntity> clazz, String name) {
        GameRegistry.registerTileEntity(clazz, new ResourceLocation(Constants.MOD_ID, name));
    }


    public void registerTileEntities() {
        registerTileEntity(TileEntitySolarPanelAdvanced.class, "advanced_solar_panel");
        registerTileEntity(TileEntitySolarPanelHybrid.class, "hybrid_solar_panel");
        registerTileEntity(TileEntitySolarPanelPerfectHybrid.class, "perfecthybrid_solar_panel");
        registerTileEntity(TileEntitySolarPanelQuantum.class, "quantum_solar_panel");
        registerTileEntity(TileEntitySolarPanelSpectral.class, "spectral_solar_panel");
        registerTileEntity(TileEntitySolarPanelProtonic.class, "protonic_solar_panel");
        registerTileEntity(TileEntitySolarPanelSingular.class, "singular_solar_panel");
        registerTileEntity(TileEntitySolarPanelDiffractive.class, "diffractive_solar_panel");
        registerTileEntity(TileEntitySolarPanelPhotonic.class, "photonic_solar_panel");
        registerTileEntity(TileEntitySolarPanelNeutron.class, "neutron_solar_panel");



        registerTileEntity(TileEntitySolarStationAdv.class, "advanced_solar_station");
        registerTileEntity(TileEntitySolarStationHybrid.class, "hybrid_solar_station");
        registerTileEntity(TileEntitySolarStationPerfectHybrid.class, "perfecthybrid_solar_station");
        registerTileEntity(TileEntitySolarStationQuantum.class, "quantum_solar_station");
        registerTileEntity(TileEntitySolarStationSpectral.class, "spectral_solar_station");
        registerTileEntity(TileEntitySolarStationProtonic.class, "protonic_solar_station");
        registerTileEntity(TileEntitySolarStationSingular.class, "singular_solar_station");
        registerTileEntity(TileEntitySolarStationDiffractive.class, "diffractive_solar_station");
        registerTileEntity(TileEntitySolarStationPhotonic.class, "photonic_solar_station");
        registerTileEntity(TileEntitySolarStationNeutron.class, "neutron_solar_station");
    }

    public void registerTESRs() {
    }

    public void registerItemRenders() {
    }

    public void registerBlockRenders() {
    }

    public void preInit() {
    }

    public void loadConfiguration() {
        EcoConfig.local().generators.load(EcoEnergistics.configuration);
        EcoEnergistics.configuration.save();
//        BaseConfig.load
/*        if (EcoConfig.configuration.hasChanged()) {
            Mekanism.configuration.save();
        }*/
    }

    @Override
    public Object getClientGui(int ID, EntityPlayer player, World world, BlockPos pos) {
        return null;
    }

    @Override
    public Container getServerGui(int ID, EntityPlayer player, World world, BlockPos pos) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (ID == 0) {
            return new ContainerEcoSolarPanel(player.inventory, (TileEntitySolarPanelAdvanced) tileEntity);
        }

        return null;
    }
}