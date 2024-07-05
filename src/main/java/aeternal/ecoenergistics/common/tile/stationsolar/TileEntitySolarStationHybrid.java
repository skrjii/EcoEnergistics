package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationHybrid extends TileEntityEcoSolarStation {

    public TileEntitySolarStationHybrid() {
        super("SolarStationHybrid", StationSolarConfig.HybridGenStorage.getValue(), StationSolarConfig.HybridGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.HybridGen_OUT.getValue();
    }


}
