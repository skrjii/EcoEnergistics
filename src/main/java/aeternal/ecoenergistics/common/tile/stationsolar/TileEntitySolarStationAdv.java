package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationAdv extends TileEntityEcoSolarStation {

    public TileEntitySolarStationAdv() {
        super("SolarStationAdvanced", StationSolarConfig.AdvancedGenStorage.getValue(), StationSolarConfig.AdvancedGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.AdvancedGen_OUT.getValue();
    }


}
