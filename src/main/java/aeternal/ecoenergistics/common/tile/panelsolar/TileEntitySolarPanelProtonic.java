package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelProtonic extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelProtonic() {
        super("SolarPanelProtonic", PanelSloarConfig.ProtonicGenStorage.getValue(), PanelSloarConfig.ProtonicGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.ProtonicGen_OUT.getValue();
    }
}
