package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationInfinity extends TileEntityEcoSolarStation {

    public TileEntitySolarStationInfinity() {
        super("SolarStationInfinity", StationSolarConfig.InfinityGenStorage.getValue(), StationSolarConfig.InfinityGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.InfinityGen_OUT.getValue();
    }


}
