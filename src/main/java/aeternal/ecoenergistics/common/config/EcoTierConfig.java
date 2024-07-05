package aeternal.ecoenergistics.common.config;

import aeternal.ecoenergistics.common.tier.EcoCableTier;
import aeternal.ecoenergistics.common.tier.EcoPipeTier;
import aeternal.ecoenergistics.common.tier.EcoTubeTier;
import aeternal.ecoenergistics.common.tier.MEETiers;
import mekanism.common.config.BaseConfig;
import mekanism.common.config.options.IntOption;

import java.util.EnumMap;

public class EcoTierConfig {

    public static EnumMap<MEETiers,EcoTierConfig> create(BaseConfig baseConfig) {
        EnumMap<MEETiers,EcoTierConfig> map = new EnumMap<>(MEETiers.class);
        for (MEETiers baseTier : MEETiers.values()){
            map.put(baseTier, new EcoTierConfig(baseConfig, baseTier));
        }
        return map;
    }

    public final IntOption CableCapacity;
    public final IntOption PipeCapacity;
    public final IntOption PipePullAmount;
    public final IntOption TubeCapacity;
    public final IntOption TubePullAmount;

    private EcoTierConfig(BaseConfig baseConfig, MEETiers tier) {
        String name = tier.getSimpleName();
        this.CableCapacity = new IntOption(baseConfig, "tier", name + "CableCapacity", EcoCableTier.values()[tier.ordinal()].getBaseCapacity(), "Internal buffer in Joules of each " + name + " universal cable.");
        this.PipeCapacity = new IntOption(baseConfig, "tier", name + "PipeCapacity", EcoPipeTier.values()[tier.ordinal()].getBaseCapacity(), "Capacity of " + name + " mechanical pipe in mB.");
        this.PipePullAmount = new IntOption(baseConfig, "tier", name + "PipePullAmount", EcoPipeTier.values()[tier.ordinal()].getBasePull(), "Pump rate of " + name + " mechanical pipe in mB/t.");
        this.TubeCapacity = new IntOption(baseConfig, "tier", name + "TubeCapacity", EcoTubeTier.values()[tier.ordinal()].getBaseCapacity(), "Capacity of " + name + " pressurized tube in mB.");
        this.TubePullAmount = new IntOption(baseConfig, "tier", name + "TubePullAmount", EcoTubeTier.values()[tier.ordinal()].getBasePull(), "Pump rate of " + name + " pressurized tube in mB/t.");


    }

}
