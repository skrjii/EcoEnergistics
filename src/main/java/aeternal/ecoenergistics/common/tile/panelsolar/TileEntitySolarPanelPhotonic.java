package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelPhotonic extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelPhotonic() {
        super("SolarPanelPhotonic", PanelSloarConfig.PhotonicGenStorage.getValue(), PanelSloarConfig.PhotonicGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.PhotonicGen_OUT.getValue();
    }
}
