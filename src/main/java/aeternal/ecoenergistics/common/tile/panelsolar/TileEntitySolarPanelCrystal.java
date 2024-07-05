package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;

public class TileEntitySolarPanelCrystal extends TileEntityEcoSolarPanel {

    public TileEntitySolarPanelCrystal() {
        super("SolarPanelCrystal", PanelSloarConfig.CrystalGenStorage.getValue(), PanelSloarConfig.CrystalGen_OUT.getValue());
    }

    @Override
    public float getConfiguredMax() {
        return (float) PanelSloarConfig.CrystalGen_OUT.getValue();
    }
}
