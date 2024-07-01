package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarStation;

public class TileEntitySolarStationQuantum extends TileEntityEcoSolarStation {

    public TileEntitySolarStationQuantum() {
        super("SolarStationQuantum", StationSolarConfig.QuantumGenStorage.getValue(), StationSolarConfig.QuantumGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) StationSolarConfig.QuantumGen_OUT.getValue();
    }
    

}
