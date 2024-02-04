package aeternal.ecoenergistics.common.enums;

import java.util.Locale;

public enum Rods {
    STEEL("Steel", 0xaf8e77);



    public final int tint;
    private String name;

    Rods(String s, int t) {
        name = s;
        tint = t;
    }

    public static Rods getFromName(String s) {
        s = s.toLowerCase(Locale.ROOT);
        for (Rods r : values()) {
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