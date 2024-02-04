package aeternal.ecoenergistics.common.tier;

import aeternal.ecoenergistics.config.EcoConfig;
import mekanism.common.config.MekanismConfig;

public enum EcoPipeTier implements ITier {
    ADVANCED(64000, 25600),
    HYBRID(256000, 102400),
    PERFECTHYBRID(512000, 409600),
    QUANTUM(10240000, 1638400),
    SPECTRAL(40960000, 8192000),
    PROTONIC(163840000, 32768000),
    SINGULAR(81920000, 134217728),
    DIFFRACTIVE(268435456, 536870912),
    PHOTONIC(1073741824, 268435456),
    NEUTRON(Integer.MAX_VALUE, Integer.MAX_VALUE);


    private final int baseCapacity;
    private final int basePull;
    private final MEETiers baseTier;

    EcoPipeTier(int capacity, int pullAmount) {
        baseCapacity = capacity;
        basePull = pullAmount;
        baseTier = MEETiers.values()[ordinal()];
    }

    public static EcoPipeTier get(MEETiers tier) {
        for (EcoPipeTier transmitter : values()) {
            if (transmitter.getBaseTier() == tier) {
                return transmitter;
            }
        }
        return ADVANCED;
    }

    @Override
    public MEETiers getBaseTier() {
        return baseTier;
    }

    public int getPipeCapacity() {
        return EcoConfig.current().generators.tiers.get(baseTier).PipeCapacity.val();
    }

    public int getPipePullAmount() {
        return EcoConfig.current().generators.tiers.get(baseTier).PipePullAmount.val();
    }

    public int getBaseCapacity() {
        return baseCapacity;
    }

    public int getBasePull() {
        return basePull;
    }
}