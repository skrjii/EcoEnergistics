package aeternal.ecoenergistics.common.enums;

import mekanism.api.EnumColor;
import mekanism.common.util.LangUtils;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum AvaritiaTiers implements IStringSerializable {
    CRYSTALMATRIX("CrystalMatrix", EnumColor.DARK_AQUA),
    NEUTRONIUM("Neutronium", EnumColor.BLACK),
    INFINITY("Infinity", EnumColor.RED);


    private String name;
    private EnumColor color;

    AvaritiaTiers(String s, EnumColor c) {
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