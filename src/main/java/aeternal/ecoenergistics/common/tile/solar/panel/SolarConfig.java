package aeternal.ecoenergistics.common.tile.solar.panel;

import aeternal.ecoenergistics.config.EcoConfig;

public enum SolarConfig {
    AdvancedGen_S(EcoConfig.current().generators.solarPanelAdvancedGeneration.val() * 2),
    HybridGen_S(EcoConfig.current().generators.solarPanelHybridGeneration.val() * 2),
    PerfectHybridGen_S(EcoConfig.current().generators.solarPanelPerfectHybridGeneration.val() * 2),
    QuantumGen_S(EcoConfig.current().generators.solarPanelQuantumGeneration.val() * 2),
    SpectralGen_S(EcoConfig.current().generators.solarPanelSpectralGeneration.val() * 2),
    ProtonicGen_S(EcoConfig.current().generators.solarPanelProtonicGeneration.val() * 2),
    SingularGen_S(EcoConfig.current().generators.solarPanelSingularGeneration.val() * 2),
    DiffractiveGen_S(EcoConfig.current().generators.solarPanelDiffractiveGeneration.val() * 2),
    PhotonicGen_S(EcoConfig.current().generators.solarPanelPhotonicGeneration.val() * 2),
    NeutronGen_S(EcoConfig.current().generators.solarPanelNeutronGeneration.val() * 2),


    AdvancedGen_SS(EcoConfig.current().generators.solarStationAdvancedGeneration.val() * 2),
    HybridGen_SS(EcoConfig.current().generators.solarStationHybridGeneration.val() * 2),
    PerfectHybridGen_SS(EcoConfig.current().generators.solarStationPerfectHybridGeneration.val() * 2),
    QuantumGen_SS(EcoConfig.current().generators.solarStationQuantumGeneration.val() * 2),
    SpectralGen_SS(EcoConfig.current().generators.solarStationSpectralGeneration.val() * 2),
    ProtonicGen_SS(EcoConfig.current().generators.solarStationProtonicGeneration.val() * 2),
    SingularGen_SS(EcoConfig.current().generators.solarStationSingularGeneration.val() * 2),
    DiffractiveGen_SS(EcoConfig.current().generators.solarStationDiffractiveGeneration.val() * 2),
    PhotonicGen_SS(EcoConfig.current().generators.solarStationPhotonicGeneration.val() * 2),
    NeutronGen_SS(EcoConfig.current().generators.solarStationNeutronGeneration.val() * 2);
    private final double value;

    SolarConfig(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
