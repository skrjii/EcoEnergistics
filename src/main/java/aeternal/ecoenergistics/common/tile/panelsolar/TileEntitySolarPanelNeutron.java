package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelNeutron extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelNeutron() {
        super("SolarPanelNeutron", PanelSloarConfig.NeutronGenStorage.getValue(), PanelSloarConfig.NeutronGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.NeutronGen_OUT.getValue();
    }
}
