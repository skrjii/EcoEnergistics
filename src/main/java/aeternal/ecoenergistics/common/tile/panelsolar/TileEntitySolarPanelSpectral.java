package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelSpectral extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelSpectral() {
        super("SolarPanelSpectral", PanelSloarConfig.SpectralGenStorage.getValue(), PanelSloarConfig.SpectralGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.SpectralGen_OUT.getValue();
    }
}
