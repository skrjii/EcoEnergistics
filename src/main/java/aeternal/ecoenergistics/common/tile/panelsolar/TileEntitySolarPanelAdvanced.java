package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelAdvanced extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelAdvanced() {
        super("SolarPanelAdvanced", PanelSloarConfig.AdvancedGenStorage.getValue(), PanelSloarConfig.AdvancedGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.AdvancedGen_OUT.getValue();
    }
}
