package aeternal.ecoenergistics.common.tier;

import java.util.Locale;

import mekanism.api.EnumColor;
import mekanism.common.util.LangUtils;
import net.minecraft.util.IStringSerializable;

public enum MEETiers implements IStringSerializable {
    ADVANCED("Advanced", EnumColor.YELLOW),
    HYBRID("Hybrid", EnumColor.AQUA),
    PERFECTHYBRID("PerfectHybrid", EnumColor.DARK_AQUA),
    QUANTUM("Quantum", EnumColor.DARK_GREEN),
    SPECTRAL("Spectral", EnumColor.ORANGE),
    PROTONIC("Protonic", EnumColor.PURPLE),
    SINGULAR("Singular", EnumColor.BLACK),
    DIFFRACTIVE("Diffractive", EnumColor.DARK_RED),
    PHOTONIC("Photonic", EnumColor.BRIGHT_GREEN),
    NEUTRON("Neutron", EnumColor.DARK_BLUE);

    private String name;
    private EnumColor color;

    MEETiers(String s, EnumColor c) {
        name = s;
        color = c;
    }

    public String getSimpleName() {
        return name;
    }

    public String getLocalizedName() {
        return LangUtils.localize("tier." + getSimpleName());
    }

    public EnumColor getColor() {
        return color;
    }

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }
}