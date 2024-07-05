package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationPhotonic extends TileEntityEcoSolarStation {

    public TileEntitySolarStationPhotonic() {
        super("SolarStationPhotonic", StationSolarConfig.PhotonicGenStorage.getValue(), StationSolarConfig.PhotonicGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.PhotonicGen_OUT.getValue();
    }
    

}
