package aeternal.ecoenergistics.integration.avaritia.common.enums;

import java.util.Locale;

import aeternal.ecoenergistics.api.EnumColor;
;
import mekanism.common.util.LangUtils;
import net.minecraft.util.IStringSerializable;

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