package aeternal.ecoenergistics.common.enums;

import java.util.Locale;

public enum Dust {
    TITANIUM("Titanium", 0xaf8e77),
    URANIUM("Uranium", 0xaf8e77),
    IRIDIUM("Iridium",0xaf8e77);

    public final int tint;
    private String name;

    Dust(String s, int t) {
        name = s;
        tint = t;
    }

    public static Dust getFromName(String s) {
        s = s.toLowerCase(Locale.ROOT);
        for (Dust r : values()) {
            if (r.name.toLowerCase(Locale.ROOT).equals(s)) {
                return r;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}