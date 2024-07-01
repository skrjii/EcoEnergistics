package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationNeutron extends TileEntityEcoSolarStation {

    public TileEntitySolarStationNeutron() {
        super("SolarStationNeutron", StationSolarConfig.NeutronGenStorage.getValue(), StationSolarConfig.NeutronGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.NeutronGen_OUT.getValue();
    }


}
