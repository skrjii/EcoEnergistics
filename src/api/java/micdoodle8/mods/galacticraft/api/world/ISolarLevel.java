package micdoodle8.mods.galacticraft.api.world;

/**
 * Used to change the panel multiplier of certain world providers
 * <p/>
 * If you have a panel feature in your mod, check whether the world's provider inherits this class and multiply the panel generation by the panel multiplier double
 * <p/>
 * for example:
 * <p/>
 * if (world.provider instanceof ISolarLevel) solarStrength *= ((ISolarLevel) world.provider).getSolarEnergyMultiplier();
 */
public interface ISolarLevel {

    double getSolarEnergyMultiplier();
}