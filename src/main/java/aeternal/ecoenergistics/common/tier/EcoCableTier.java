package aeternal.ecoenergistics.common.tier;

import aeternal.ecoenergistics.config.EcoConfig;
import mekanism.common.config.MekanismConfig;


public enum EcoCableTier implements ITier {
    ADVANCED(1280000),
    HYBRID(5120000),
    PERFECTHYBRID(10240000),
    QUANTUM(40960000),
    SPECTRAL(163840000),
    PROTONIC(655360000),
    SINGULAR(1310720000),
    DIFFRACTIVE(1703936000),
    PHOTONIC(1959526400),
    NEUTRON(Integer.MAX_VALUE);

    private final int baseCapacity;
    private final MEETiers baseTier;

    EcoCableTier(int capacity) {
        baseCapacity = capacity;
        baseTier = MEETiers.values()[ordinal()];
    }

    public static EcoCableTier get(MEETiers tier) {
        for (EcoCableTier transmitter : values()) {
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

    public int getCableCapacity() {
        return EcoConfig.current().generators.tiers.get(baseTier).CableCapacity.val();
    }

    public int getBaseCapacity() {
        return baseCapacity;
    }
}