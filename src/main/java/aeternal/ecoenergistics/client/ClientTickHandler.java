package aeternal.ecoenergistics.client;

import aeternal.ecoenergistics.EcoEnergistics;
import aeternal.ecoenergistics.api.IClientTicker;
import aeternal.ecoenergistics.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@SideOnly(Side.CLIENT)
public class ClientTickHandler {

    public static Minecraft mc = FMLClientHandler.instance().getClient();

    public static Set<IClientTicker> tickingSet = new HashSet<>();

    public boolean shouldReset = false;


    @SubscribeEvent
    public void onTick(ClientTickEvent event) {
        if (event.phase == Phase.START) {
            tickStart();
        }
    }

    public void tickStart() {
        ClientProxy.ticksPassed++;

        if (!EcoEnergistics.proxy.isPaused()) {
            for (Iterator<IClientTicker> iter = tickingSet.iterator(); iter.hasNext(); ) {
                IClientTicker ticker = iter.next();

                if (ticker.needsTicks()) {
                    ticker.clientTick();
                } else {
                    iter.remove();
                }
            }
        }

        if (mc.world != null) {
            shouldReset = true;
        } else if (shouldReset) {
            ClientProxy.reset();
            shouldReset = false;
        }

    }
}