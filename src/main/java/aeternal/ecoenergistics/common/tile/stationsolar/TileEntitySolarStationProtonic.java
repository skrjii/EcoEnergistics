package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationProtonic extends TileEntityEcoSolarStation {

    public TileEntitySolarStationProtonic() {
        super("SolarStationProtonic", StationSolarConfig.ProtonicGenStorage.getValue(), StationSolarConfig.ProtonicGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.ProtonicGen_OUT.getValue();
    }
    

}
