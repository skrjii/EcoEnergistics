package aeternal.ecoenergistics.common.tile.stationsolar;

import aeternal.ecoenergistics.common.config.EcoConfig;

public enum StationSolarConfig {
    AdvancedGen_OUT(EcoConfig.current().generators.solarStationAdvancedGeneration.val() * 2),
    HybridGen_OUT(EcoConfig.current().generators.solarStationHybridGeneration.val() * 2),
    PerfectHybridGen_OUT(EcoConfig.current().generators.solarStationPerfectHybridGeneration.val() * 2),
    QuantumGen_OUT(EcoConfig.current().generators.solarStationQuantumGeneration.val() * 2),
    SpectralGen_OUT(EcoConfig.current().generators.solarStationSpectralGeneration.val() * 2),
    ProtonicGen_OUT(EcoConfig.current().generators.solarStationProtonicGeneration.val() * 2),
    SingularGen_OUT(EcoConfig.current().generators.solarStationSingularGeneration.val() * 2),
    DiffractiveGen_OUT(EcoConfig.current().generators.solarStationDiffractiveGeneration.val() * 2),
    PhotonicGen_OUT(EcoConfig.current().generators.solarStationPhotonicGeneration.val() * 2),
    NeutronGen_OUT(EcoConfig.current().generators.solarStationNeutronGeneration.val() * 2),


    AdvancedGenStorage(EcoConfig.current().Storage.solarStationAdvancedGeneratorStorage.val()),
    HybridGenStorage(EcoConfig.current().Storage.solarStationHybridGeneratorStorage.val()),
    PerfectHybridGenStorage(EcoConfig.current().Storage.solarStationPerfectHybridGeneratorStorage.val()),
    QuantumGenStorage(EcoConfig.current().Storage.solarStationQuantumGeneratorStorage.val()),
    SpectralGenStorage(EcoConfig.current().Storage.solarStationSpectralGeneratorStorage.val()),
    ProtonicGenStorage(EcoConfig.current().Storage.solarStationProtonicGeneratorStorage.val()),
    SingularGenStorage(EcoConfig.current().Storage.solarStationSingularGeneratorStorage.val()),
    DiffractiveGenStorage(EcoConfig.current().Storage.solarStationDiffractiveGeneratorStorage.val()),
    PhotonicGenStorage(EcoConfig.current().Storage.solarStationPhotonicGeneratorStorage.val()),
    NeutronGenStorage(EcoConfig.current().Storage.solarStationNeutronGeneratorStorage.val()),

    CrystalGen_OUT(EcoConfig.current().integration.solarStationCrystalGeneration.val() * 2),
    NeutroniumGen_OUT(EcoConfig.current().integration.solarStationNeutroniumGeneration.val() * 2),
    InfinityGen_OUT(EcoConfig.current().integration.solarStationInfinityGeneration.val() * 2),
    CrystalGenStorage(EcoConfig.current().integration.SolarStationCrystalGeneratorStorage.val()),
    NeutroniumGenStorage(EcoConfig.current().integration.SolarStationNeutroniumGeneratorStorage.val()),
    InfinityGenStorage(EcoConfig.current().integration.SolarStationInfinityGeneratorStorage.val());

    private final double value;

    StationSolarConfig(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
