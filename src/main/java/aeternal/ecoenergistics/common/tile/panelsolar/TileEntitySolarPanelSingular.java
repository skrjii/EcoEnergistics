package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelSingular extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelSingular() {
        super("SolarPanelSingular", PanelSloarConfig.SingularGenStorage.getValue(), PanelSloarConfig.SingularGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.SingularGen_OUT.getValue();
    }
}
