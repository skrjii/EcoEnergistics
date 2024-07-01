package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelPerfectHybrid extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelPerfectHybrid() {
        super("SolarPanelPerfectHybrid", PanelSloarConfig.PerfectHybridGenStorage.getValue(), PanelSloarConfig.PerfectHybridGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.PerfectHybridGen_OUT.getValue();
    }
}
