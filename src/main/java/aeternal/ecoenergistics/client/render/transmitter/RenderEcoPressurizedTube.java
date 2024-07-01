package aeternal.ecoenergistics.client.render.transmitter;

import aeternal.ecoenergistics.common.tile.transmitter.TileEntityEcoPressurizedTube;
import aeternal.ecoenergistics.common.transmitters.TransmitterEcoImpl;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasStack;
import mekanism.api.gas.IGasHandler;
import mekanism.common.ColourRGBA;
import mekanism.common.config.MekanismConfig;
import mekanism.common.transmitters.grid.GasNetwork;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.EnumFacing;

public class RenderEcoPressurizedTube extends RenderEcoTransmitterSimple<TileEntityEcoPressurizedTube> {

    @Override
    public void render(TileEntityEcoPressurizedTube tube, double x, double y, double z, float partialTick, int destroyStage, float alpha) {
        if (!MekanismConfig.current().client.opaqueTransmitters.val()) {
            TransmitterEcoImpl<IGasHandler, GasNetwork, GasStack> transmitter = tube.getTransmitter();
            if (transmitter.hasTransmitterNetwork() && transmitter.getTransmitterNetwork().refGas != null && transmitter.getTransmitterNetwork().gasScale != 0) {
                render(tube, x, y, z, 0);
            }
        }
    }


    @Override
    protected void renderSide(BufferBuilder renderer, EnumFacing side, TileEntityEcoPressurizedTube tube) {
        bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        Gas gas = tube.getTransmitter().getTransmitterNetwork().refGas;
        ColourRGBA c = new ColourRGBA(1.0, 1.0, 1.0, tube.currentScale);
        c.setRGBFromInt(gas.getTint());
        renderTransparency(renderer, gas.getSprite(), getModelForSide(tube, side), c);
    }
}
