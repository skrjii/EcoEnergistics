package aeternal.ecoenergistics.common.capabilities;

import aeternal.ecoenergistics.common.tier.IEcoAlloyInteraction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class EcoCapabilities {

    @CapabilityInject(IEcoAlloyInteraction.class)
    public static Capability<IEcoAlloyInteraction> ALLOY_INTERACTION_CAPABILITY = null;

    public static void registerCapabilities() {
        DefaultEcoAlloyInteraction.register();
    }
}
