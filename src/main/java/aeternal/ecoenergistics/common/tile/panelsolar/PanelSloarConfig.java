package aeternal.ecoenergistics.common.tile.panelsolar;

import aeternal.ecoenergistics.common.config.EcoConfig;

public enum PanelSloarConfig {
    AdvancedGen_OUT(EcoConfig.current().generators.solarPanelAdvancedGeneration.val() * 2),
    HybridGen_OUT(EcoConfig.current().generators.solarPanelHybridGeneration.val() * 2),
    PerfectHybridGen_OUT(EcoConfig.current().generators.solarPanelPerfectHybridGeneration.val() * 2),
    QuantumGen_OUT(EcoConfig.current().generators.solarPanelQuantumGeneration.val() * 2),
    SpectralGen_OUT(EcoConfig.current().generators.solarPanelSpectralGeneration.val() * 2),
    ProtonicGen_OUT(EcoConfig.current().generators.solarPanelProtonicGeneration.val() * 2),
    SingularGen_OUT(EcoConfig.current().generators.solarPanelSingularGeneration.val() * 2),
    DiffractiveGen_OUT(EcoConfig.current().generators.solarPanelDiffractiveGeneration.val() * 2),
    PhotonicGen_OUT(EcoConfig.current().generators.solarPanelPhotonicGeneration.val() * 2),
    NeutronGen_OUT(EcoConfig.current().generators.solarPanelNeutronGeneration.val() * 2),

    AdvancedGenStorage(EcoConfig.current().Storage.solarPanelAdvancedGeneratorStorage.val()),
    HybridGenStorage(EcoConfig.current().Storage.solarPanelHybridGeneratorStorage.val()),
    PerfectHybridGenStorage(EcoConfig.current().Storage.solarPanelPerfectHybridGeneratorStorage.val()),
    QuantumGenStorage(EcoConfig.current().Storage.solarPanelQuantumGeneratorStorage.val()),
    SpectralGenStorage(EcoConfig.current().Storage.solarPanelSpectralGeneratorStorage.val()),
    ProtonicGenStorage(EcoConfig.current().Storage.solarPanelProtonicGeneratorStorage.val()),
    SingularGenStorage(EcoConfig.current().Storage.solarPanelSingularGeneratorStorage.val()),
    DiffractiveGenStorage(EcoConfig.current().Storage.solarPanelDiffractiveGeneratorStorage.val()),
    PhotonicGenStorage(EcoConfig.current().Storage.solarPanelPhotonicGeneratorStorage.val()),
    NeutronGenStorage(EcoConfig.current().Storage.solarPanelNeutronGeneratorStorage.val()),

    CrystalGen_OUT(EcoConfig.current().integration.solarPanelCrystalGeneration.val() * 2),
    NeutroniumGen_OUT(EcoConfig.current().integration.solarPanelNeutroniumGeneration.val() * 2),
    InfinityGen_OUT(EcoConfig.current().integration.solarPanelInfinityGeneration.val() * 2),

    CrystalGenStorage(EcoConfig.current().integration.SolarPanelCrystalGeneratorStorage.val()),
    InfinityGenStorage(EcoConfig.current().integration.SolarPanelInfinityGeneratorStorage.val()),
    NeutroniumGenStorage(EcoConfig.current().integration.SolarPanelNeutroniumGeneratorStorage.val());
    private final double value;

    PanelSloarConfig(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
