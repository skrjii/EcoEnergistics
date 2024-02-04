package aeternal.ecoenergistics.integration.avaritia.common.tile.solar;

import aeternal.ecoenergistics.config.EcoConfig;

public enum AvaritiaSolarConfig {
    CrystalGen_S(EcoConfig.current().generators.solarPanelCrystalGeneration.val() * 2),
    NeutroniumGen_S(EcoConfig.current().generators.solarPanelNeutroniumGeneration.val() * 2),
    InfinityGen_S(EcoConfig.current().generators.solarPanelInfinityGeneration.val() * 2),

    CrystalGen_SS(EcoConfig.current().generators.solarStationCrystalGeneration.val() * 2),
    NeutroniumGen_SS(EcoConfig.current().generators.solarStationNeutroniumGeneration.val() * 2),
    InfinityGen_SS(EcoConfig.current().generators.solarStationInfinityGeneration.val() * 2);

    private final double value;

    AvaritiaSolarConfig(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
