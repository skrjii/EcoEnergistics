package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationCrystal extends TileEntityEcoSolarStation {

    public TileEntitySolarStationCrystal() {
        super("SolarStationCrystal", StationSolarConfig.CrystalGenStorage.getValue(), StationSolarConfig.CrystalGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.CrystalGen_OUT.getValue();
    }


}
