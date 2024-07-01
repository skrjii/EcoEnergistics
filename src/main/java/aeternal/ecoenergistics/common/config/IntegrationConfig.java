package aeternal.ecoenergistics.common.config;

import mekanism.common.config.BaseConfig;
import mekanism.common.config.options.BooleanOption;
import mekanism.common.config.options.DoubleOption;

public class IntegrationConfig extends BaseConfig {


    public final BooleanOption AvaritiaEnable = new BooleanOption(this, "integration", "EnableAvaritiaIntegration", true,"Enable Avaritia Integration").setRequiresGameRestart(true);

    public final DoubleOption solarPanelCrystalGeneration = new DoubleOption(this, "integration", "CrystalSolarPanelGeneration", 1330000.0, "Peak output for the Crystal Solar Panel.");
    public final DoubleOption solarPanelNeutroniumGeneration = new DoubleOption(this, "integration", "NeutronSolarPanelGeneration", 53200000.0, "Peak output for the Neutron Solar Panel.");
    public final DoubleOption solarPanelInfinityGeneration = new DoubleOption(this, "integration", "InfinitySolarPanelGeneration", 254520000, "Peak output for the Solar Panel of Infinity.");
    public final DoubleOption solarStationCrystalGeneration = new DoubleOption(this, "integration", "CrystalSolarStationGeneration", 5320000.0, "Peak output for the Crystal Solar Station.");
    public final DoubleOption solarStationNeutroniumGeneration = new DoubleOption(this, "integration", "NeutronSolarStationGeneration", 212800000.0, "Peak output for the Neutron Solar Station.");
    public final DoubleOption solarStationInfinityGeneration = new DoubleOption(this, "integration", "InfinitySolarStationGeneration", 1119888000.0, "Peak output for the Solar Station of Infinity.");

    public final DoubleOption SolarPanelCrystalGeneratorStorage = new DoubleOption(this, "integration", "SolarPanelCrystalGeneratorStorage", 5320000D, "Energy capable of being stored");
    public final DoubleOption SolarPanelInfinityGeneratorStorage = new DoubleOption(this, "integration", "SolarPanelInfinityGeneratorStorage", 1119888000D, "Energy capable of being stored");
    public final DoubleOption SolarPanelNeutroniumGeneratorStorage = new DoubleOption(this, "integration", "SolarPanelNeutroniumGeneratorStorage", 212800000D, "Energy capable of being stored");
    public final DoubleOption SolarStationCrystalGeneratorStorage = new DoubleOption(this, "integration", "SolarStationCrystalGeneratorStorage", 21280000D, "Energy capable of being stored");
    public final DoubleOption SolarStationInfinityGeneratorStorage = new DoubleOption(this, "integration", "SolarStationInfinityGeneratorStorage", Integer.MAX_VALUE, "Energy capable of being stored");
    public final DoubleOption SolarStationNeutroniumGeneratorStorage = new DoubleOption(this, "integration", "SolarStationNeutroniumGeneratorStorage", 851200000D, "Energy capable of being stored");
}
