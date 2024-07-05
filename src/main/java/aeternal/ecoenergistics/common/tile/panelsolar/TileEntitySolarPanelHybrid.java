package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelHybrid extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelHybrid() {
        super("SolarPanelHybrid", PanelSloarConfig.HybridGenStorage.getValue(), PanelSloarConfig.HybridGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.HybridGen_OUT.getValue();
    }
}
