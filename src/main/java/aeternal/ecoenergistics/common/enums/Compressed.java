package aeternal.ecoenergistics.common.enums;

import java.util.Locale;

public enum Compressed {
    LAPIS("Lapis", 0xaf8e77),
    EMERALD("Emerald", 0xf2cd67),
    GLOWSTONE("Glowstone",0xf2cd67),
    GOLD("Gold",0xf2cd67),
    TITANIUM("Titanium",0xf2cd67),
    URANIUM("Uranium",0xf2cd67),
    IRIDIUM("Iridium",0xf2cd67);


    public final int tint;
    private String name;

    Compressed(String s, int t) {
        name = s;
        tint = t;
    }

    public static Compressed getFromName(String s) {
        s = s.toLowerCase(Locale.ROOT);
        for (Compressed r : values()) {
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