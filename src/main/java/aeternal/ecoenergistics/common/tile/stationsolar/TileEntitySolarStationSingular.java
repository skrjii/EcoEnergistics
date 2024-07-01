package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationSingular extends TileEntityEcoSolarStation {

    public TileEntitySolarStationSingular() {
        super("SolarStationSingular", StationSolarConfig.SingularGenStorage.getValue(), StationSolarConfig.SingularGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.SingularGen_OUT.getValue();
    }
    

}
