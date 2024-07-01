package aeternal.ecoenergistics.common.config;


import net.minecraftforge.fml.common.Loader;

public class EcoConfig {

    private static EcoConfig LOCAL = new EcoConfig();
    private static EcoConfig SERVER = null;

    public static EcoConfig current() {
        return SERVER != null ? SERVER : LOCAL;
    }

    public static EcoConfig local() {
        return LOCAL;
    }

    public EcoEnergisticsConfig generators = new EcoEnergisticsConfig();
    public EcoEnergisticsStorageConfig Storage = new EcoEnergisticsStorageConfig();
    public IntegrationConfig integration = new IntegrationConfig();
}
