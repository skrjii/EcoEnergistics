package aeternal.ecoenergistics.common.tier;

import aeternal.ecoenergistics.config.EcoConfig;
import mekanism.common.config.MekanismConfig;


public enum EcoCableTier implements ITier {
    ADVANCED(320000),
    HYBRID(1280000),
    PERFECTHYBRID(1280000),
    QUANTUM(1280000),
    SPECTRAL(1280000),
    PROTONIC(1280000),
    SINGULAR(1280000),
    DIFFRACTIVE(1280000),
    PHOTONIC(1280000),
    NEUTRON(1280000);

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