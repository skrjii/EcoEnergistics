package aeternal.ecoenergistics.common.enums;

import java.util.Locale;

public enum MoreDust {
    LAPIS("Lapis", 0xaf8e77),
    EMERALD("Emerald", 0xf2cd67),
    ACTIVATEDGLOWSTONE("ActivatedGlowstone",0xf2cd67),
    REFINEDLITHIUM("RefinedLithium",0xf2cd67);

    public final int tint;
    private String name;

    MoreDust(String s, int t) {
        name = s;
        tint = t;
    }

    public static MoreDust getFromName(String s) {
        s = s.toLowerCase(Locale.ROOT);
        for (MoreDust r : values()) {
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