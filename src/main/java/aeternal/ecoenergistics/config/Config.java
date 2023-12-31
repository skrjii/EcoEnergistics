package aeternal.ecoenergistics.config;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.common.config.Configuration;

public class Config extends BaseConfig {

    public final DoubleOption solarPanelAdvancedGeneration = new DoubleOption(this, "generation", "AdvancedSolarPanelGeneration", 1000.0, "Peak output for the Advanced Solar Panel. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarPanelHybridGeneration = new DoubleOption(this, "generation", "HybridSolarPanelGeneration", 8000.0, "Peak output for the Hybrid Solar Panel. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarPanelPerfectHybridGeneration = new DoubleOption(this, "generation", "PerfectHybridSolarPanelGeneration", 16000.0, "Peak output for the PerfectHybrid Solar Panel. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarPanelQuantumGeneration = new DoubleOption(this, "generation", "QuantumSolarPanelGeneration", 24000.0, "Peak output for the PerfectHybrid Solar Panel. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarPanelSpectralGeneration = new DoubleOption(this, "generation", "SpectralSolarPanelGeneration", 32000.0, "Peak output for the Quantum Solar Panel. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarPanelProtonicGeneration = new DoubleOption(this, "generation", "ProtonicSolarPanelGeneration", 40000.0, "Peak output for Spectral the Solar Panel. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarPanelSingularGeneration = new DoubleOption(this, "generation", "SingularSolarPanelGeneration", 48000.0, "Peak output for the Protonic Solar Panel. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarPanelDiffractiveGeneration = new DoubleOption(this, "generation", "DiffractiveSolarPanelGeneration", 56000.0, "Peak output for the Singular Solar Panel. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarPanelPhotonicGeneration = new DoubleOption(this, "generation", "PhotonicSolarPanelGeneration", 192000.0, "Peak output for the Diffractive Solar Panel. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarPanelNeutronGeneration = new DoubleOption(this, "generation", "NeutronSolarPanelGeneration", 288000, "Peak output for the Photonic Solar Panel. Note: It can go higher than this value in some extreme environments.");



    public final DoubleOption solarStationAdvancedGeneration = new DoubleOption(this, "generation", "AdvancedSolarStationGeneration", 5000.0, "Peak output for the Advanced Solar Station. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarStationHybridGeneration = new DoubleOption(this, "generation", "HybridSolarStationGeneration", 32000.0, "Peak output for the Advanced Solar Station. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarStationPerfectHybridGeneration = new DoubleOption(this, "generation", "PerfectHybridSolarStationGeneration", 64000.0, "Peak output for the Advanced Solar Station. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarStationQuantumGeneration = new DoubleOption(this, "generation", "QuantumSolarStationGeneration", 96000.0, "Peak output for the Advanced Solar Station. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarStationSpectralGeneration = new DoubleOption(this, "generation", "SpectralSolarStationGeneration", 128000.0, "Peak output for the Advanced Solar Station. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarStationProtonicGeneration = new DoubleOption(this, "generation", "ProtonicSolarStationGeneration", 160000.0, "Peak output for the Advanced Solar Station. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarStationSingularGeneration = new DoubleOption(this, "generation", "SingularSolarStationGeneration", 192000.0, "Peak output for the Advanced Solar Station. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarStationDiffractiveGeneration = new DoubleOption(this, "generation", "DiffractiveSolarStationGeneration", 224000.0, "Peak output for the Advanced Solar Station. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarStationPhotonicGeneration = new DoubleOption(this, "generation", "PhotonicSolarStationGeneration", 768000, "Peak output for the Advanced Solar Station. Note: It can go higher than this value in some extreme environments.");
    public final DoubleOption solarStationNeutronGeneration = new DoubleOption(this, "generation", "NeutronSolarStationGeneration", 1152000.0, "Peak output for the Advanced Solar Station. Note: It can go higher than this value in some extreme environments.");





//    public TypeConfigManager<BlockStateEcoGenerator.EcoGeneratorType> generatorsManager = new TypeConfigManager(this, "generators", BlockStateEcoGenerator.EcoGeneratorType.class, BlockStateEcoGenerator.EcoGeneratorType::getGeneratorsForConfig, BlockStateEcoGenerator.EcoGeneratorType::getBlockName);

 /*   public Config() {
    }*/

    public void load(Configuration config) {
        super.load(config);
        this.validate();
    }

    public void read(ByteBuf config) {
        super.read(config);
        this.validate();
    }

    private void validate() {

    }
}
