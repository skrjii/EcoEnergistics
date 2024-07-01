package aeternal.ecoenergistics.client.render;

import aeternal.ecoenergistics.client.render.transmitter.RenderEcoMechanicalPipe;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EcoRenderer {

    public static void init() {
        MinecraftForge.EVENT_BUS.register(new EcoRenderer());
    }

    @SubscribeEvent
    public void onStitch(TextureStitchEvent.Post event) {
        RenderEcoMechanicalPipe.onStitch();
    }
}
