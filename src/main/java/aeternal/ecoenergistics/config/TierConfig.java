

package aeternal.ecoenergistics.config;

import java.util.EnumMap;

import aeternal.ecoenergistics.common.tier.EcoCableTier;
import aeternal.ecoenergistics.common.tier.EcoPipeTier;
import aeternal.ecoenergistics.common.tier.EcoTubeTier;
import aeternal.ecoenergistics.common.tier.MEETiers;
import aeternal.ecoenergistics.config.options.IntOption;


public class TierConfig {

    public final IntOption CableCapacity;
    public final IntOption PipeCapacity;
    public final IntOption PipePullAmount;
    public final IntOption TubeCapacity;
    public final IntOption TubePullAmount;


    public static EnumMap<MEETiers, TierConfig> create(BaseConfig baseConfig) {
        EnumMap<MEETiers, TierConfig> map = new EnumMap(MEETiers.class);
        MEETiers[] var2 = MEETiers.values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            MEETiers baseTier = var2[var4];
            map.put(baseTier, new TierConfig(baseConfig, baseTier));
        }

        return map;
    }

    private TierConfig(BaseConfig baseConfig, MEETiers tier) {
        String name = tier.getSimpleName();
        this.CableCapacity = new IntOption(baseConfig, "tier", name + "CableCapacity", EcoCableTier.values()[tier.ordinal()].getBaseCapacity(), "Internal buffer in Joules of each " + name + " universal cable.");
        this.PipeCapacity = new IntOption(baseConfig, "tier", name + "PipeCapacity", EcoPipeTier.values()[tier.ordinal()].getBaseCapacity(), "Capacity of " + name + " mechanical pipe in mB.");
        this.PipePullAmount = new IntOption(baseConfig, "tier", name + "PipePullAmount", EcoPipeTier.values()[tier.ordinal()].getBasePull(), "Pump rate of " + name + " mechanical pipe in mB/t.");
        this.TubeCapacity = new IntOption(baseConfig, "tier", name + "TubeCapacity", EcoTubeTier.values()[tier.ordinal()].getBaseCapacity(), "Capacity of " + name + " pressurized tube in mB.");
        this.TubePullAmount = new IntOption(baseConfig, "tier", name + "TubePullAmount", EcoTubeTier.values()[tier.ordinal()].getBasePull(), "Pump rate of " + name + " pressurized tube in mB/t.");


    }
}
