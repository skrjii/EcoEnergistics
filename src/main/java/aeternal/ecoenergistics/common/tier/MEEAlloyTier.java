package aeternal.ecoenergistics.common.tier;


import mekanism.api.EnumColor;

public enum MEEAlloyTier implements MEEITier {

    ADVANCED("Advanced", MEETiers.ADVANCED),
    HYBRID("Hybrid", MEETiers.HYBRID),
    PERFECTHYBRID("PerfectHybrid", MEETiers.PERFECTHYBRID),
    QUANTUM("Quantum", MEETiers.QUANTUM),
    SPECTRAL("Spectral", MEETiers.SPECTRAL),
    PROTONIC("Protonic", MEETiers.PROTONIC),
    SINGULAR("Singular", MEETiers.SINGULAR),
    DIFFRACTIVE("Diffractive", MEETiers.DIFFRACTIVE),
    PHOTONIC("Photonic", MEETiers.PHOTONIC),
    NEUTRON("Neutron", MEETiers.NEUTRON);

    private final MEETiers baseTier;
    private final String name;
    private final EnumColor color;

    MEEAlloyTier(String name, MEETiers base) {
        baseTier = base;
        this.name = name;
        color = base.getColor();
    }

    public String getName() {
        return name;
    }

    @Override
    public MEETiers getBaseTier() {
        return baseTier;
    }

    public EnumColor getColor() {
        return color;
    }
}
