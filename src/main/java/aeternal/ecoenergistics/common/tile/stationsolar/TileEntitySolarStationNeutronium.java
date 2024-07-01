package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationNeutronium extends TileEntityEcoSolarStation {

    public TileEntitySolarStationNeutronium() {
        super("SolarStationNeutronium", StationSolarConfig.NeutroniumGenStorage.getValue(), StationSolarConfig.NeutroniumGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.NeutroniumGen_OUT.getValue();
    }


}
