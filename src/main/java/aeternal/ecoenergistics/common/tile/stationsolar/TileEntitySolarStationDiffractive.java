package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationDiffractive extends TileEntityEcoSolarStation {

    public TileEntitySolarStationDiffractive() {
        super("SolarStationDiffractive", StationSolarConfig.DiffractiveGenStorage.getValue(), StationSolarConfig.DiffractiveGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.DiffractiveGen_OUT.getValue();
    }
    

}
