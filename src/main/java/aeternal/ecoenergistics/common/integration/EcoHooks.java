package aeternal.ecoenergistics.common.integration;

import net.minecraftforge.fml.common.Loader;

public final class EcoHooks {
    public static final String AVARITIA_MOD_ID = "avaritia";
    public boolean AvaritiaLoaded = false;

    public void hookPreInit() {
        AvaritiaLoaded = Loader.isModLoaded(AVARITIA_MOD_ID);
    }
}
