package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelNeutronium extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelNeutronium() {
        super("SolarPanelNeutronium", PanelSloarConfig.NeutroniumGenStorage.getValue(), PanelSloarConfig.NeutroniumGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.NeutroniumGen_OUT.getValue();
    }
}
