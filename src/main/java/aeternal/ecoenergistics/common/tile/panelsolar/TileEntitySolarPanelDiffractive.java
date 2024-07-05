package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelDiffractive extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelDiffractive() {
        super("SolarPanelDiffractive", PanelSloarConfig.DiffractiveGenStorage.getValue(), PanelSloarConfig.DiffractiveGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.DiffractiveGen_OUT.getValue();
    }
}
