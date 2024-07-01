package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelInfinity extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelInfinity() {
        super("SolarPanelInfinity", PanelSloarConfig.InfinityGenStorage.getValue(), PanelSloarConfig.InfinityGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.InfinityGen_OUT.getValue();
    }
}
