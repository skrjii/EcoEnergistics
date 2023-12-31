package aeternal.ecoenergistics.config;

import javax.annotation.Nullable;

public class EcoConfig {

    private static EcoConfig LOCAL = new EcoConfig();
    private static EcoConfig SERVER = null;

    /**
     * Current config, for use when querying the config
     *
     * @return when connected to a server, SERVER, otherwise LOCAL.
     */
    public static EcoConfig current() {
        return SERVER != null ? SERVER : LOCAL;
    }

    /**
     * Local config, mainly for the config GUI
     *
     * @return LOCAL
     */
    public static EcoConfig local() {
        return LOCAL;
    }

    public static void setSyncedConfig(@Nullable EcoConfig newConfig) {
        /*if (newConfig != null) {
            newConfig.client = LOCAL.client;
        }*/
        SERVER = newConfig;
    }

    public Config generators = new Config();


 //   public EcoConfig generators = new EcoConfig() : null;

}