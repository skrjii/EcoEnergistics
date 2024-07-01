package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationSpectral extends TileEntityEcoSolarStation {

    public TileEntitySolarStationSpectral() {
        super("SolarStationSpectral", StationSolarConfig.SpectralGenStorage.getValue(), StationSolarConfig.SpectralGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.SpectralGen_OUT.getValue();
    }
}
