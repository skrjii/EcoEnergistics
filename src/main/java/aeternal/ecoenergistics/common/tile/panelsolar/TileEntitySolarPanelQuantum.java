package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelQuantum extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelQuantum() {
        super("SolarPanelQuantum", PanelSloarConfig.QuantumGenStorage.getValue(), PanelSloarConfig.QuantumGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.QuantumGen_OUT.getValue();
    }
}
