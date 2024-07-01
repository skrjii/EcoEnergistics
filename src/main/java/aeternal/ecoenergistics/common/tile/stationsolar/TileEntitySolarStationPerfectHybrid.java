package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationPerfectHybrid extends TileEntityEcoSolarStation {

    public TileEntitySolarStationPerfectHybrid() {
        super("SolarStationPerfectHybrid", StationSolarConfig.PerfectHybridGenStorage.getValue(), StationSolarConfig.PerfectHybridGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.PerfectHybridGen_OUT.getValue();
    }
    

}
