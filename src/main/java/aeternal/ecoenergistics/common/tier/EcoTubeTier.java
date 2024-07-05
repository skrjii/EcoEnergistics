package aeternal.ecoenergistics.common.tier;


import aeternal.ecoenergistics.common.config.EcoConfig;

public enum EcoTubeTier implements MEEITier {
    ADVANCED(16384, 4096),
    HYBRID(65536, 16384),
    PERFECTHYBRID(262144, 65536),
    QUANTUM(1048576, 262144),
    SPECTRAL(4194304, 1048576),
    PROTONIC(16777216, 4194304),
    SINGULAR(67108864, 16777216),
    DIFFRACTIVE(268435456, 67108864),
    PHOTONIC(1073741824, 268435456),
    NEUTRON(Integer.MAX_VALUE, Integer.MAX_VALUE);

    private final int baseCapacity;
    private final int basePull;
    private final MEETiers baseTier;

    EcoTubeTier(int capacity, int pullAmount) {
        baseCapacity = capacity;
        basePull = pullAmount;
        baseTier = MEETiers.values()[ordinal()];
    }

    public static EcoTubeTier get(MEETiers tier) {
        for (EcoTubeTier transmitter : values()) {
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

    public int getTubeCapacity() {
        return EcoConfig.current().generators.tiers.get(baseTier).TubeCapacity.val();
    }

    public int getTubePullAmount() {
        return EcoConfig.current().generators.tiers.get(baseTier).TubePullAmount.val();
    }

    public int getBaseCapacity() {
        return baseCapacity;
    }

    public int getBasePull() {
        return basePull;
    }
}