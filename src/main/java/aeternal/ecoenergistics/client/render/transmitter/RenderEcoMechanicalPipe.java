package aeternal.ecoenergistics.client.render.transmitter;

import aeternal.ecoenergistics.common.tile.transmitter.TileEntityEcoMechanicalPipe;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import mekanism.client.render.FluidRenderMap;
import mekanism.client.render.MekanismRenderer;
import mekanism.common.ColourRGBA;
import mekanism.common.config.MekanismConfig;
import mekanism.common.tile.transmitter.TileEntitySidedPipe;
import mekanism.common.transmitters.grid.FluidNetwork;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;


public class RenderEcoMechanicalPipe extends RenderEcoTransmitterBase<TileEntityEcoMechanicalPipe> {

    private static final int stages = 100;
    private static final double height = 0.45;
    private static final double offset = 0.015;

    private static Int2ObjectMap<FluidRenderMap<MekanismRenderer.DisplayInteger[]>> cachedLiquids = new Int2ObjectArrayMap<>(7);

    public static void onStitch() {
        cachedLiquids.clear();
    }

    @Override
    public void render(TileEntityEcoMechanicalPipe pipe, double x, double y, double z, float partialTick, int destroyStage, float alpha) {
        if (MekanismConfig.current().client.opaqueTransmitters.val()) {
            return;
        }
        float targetScale;
        Fluid fluid;
        FluidStack fluidStack;
        if (pipe.getTransmitter().hasTransmitterNetwork()) {
            FluidNetwork network = pipe.getTransmitter().getTransmitterNetwork();
            targetScale = network.fluidScale;
            fluid = network.refFluid;
            fluidStack = network.buffer;
        } else {
            targetScale = (float) pipe.buffer.getFluidAmount() / (float) pipe.buffer.getCapacity();
            fluidStack = pipe.getBuffer();
            fluid = fluidStack == null ? null : fluidStack.getFluid();
        }

        if (Math.abs(pipe.currentScale - targetScale) > 0.01) {
            pipe.currentScale = (12 * pipe.currentScale + targetScale) / 13;
        } else {
            pipe.currentScale = targetScale;
        }

        float scale = Math.min(pipe.currentScale, 1);
        if (scale > 0.01 && fluid != null) {
            GlStateManager.pushMatrix();
            GlStateManager.enableCull();
            GlStateManager.disableLighting();
            MekanismRenderer.GlowInfo glowInfo;
            if (fluidStack != null) {
                glowInfo = MekanismRenderer.enableGlow(fluidStack);
                MekanismRenderer.color(fluidStack);
            } else {
                glowInfo = MekanismRenderer.enableGlow(fluid);
                MekanismRenderer.color(fluid);
            }

            bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            GlStateManager.translate((float) x, (float) y, (float) z);

            boolean gas = fluidStack == null ? fluid.isGaseous() : fluid.isGaseous(fluidStack);
            for (EnumFacing side : EnumFacing.VALUES) {
                if (pipe.getConnectionType(side) == TileEntitySidedPipe.ConnectionType.NORMAL) {
                    renderDisplayLists(getListAndRender(side, fluidStack), scale, gas);
                } else if (pipe.getConnectionType(side) != TileEntitySidedPipe.ConnectionType.NONE) {
                    GlStateManager.translate(0.5F, 0.5F, 0.5F);
                    Tessellator tessellator = Tessellator.getInstance();
                    BufferBuilder worldRenderer = tessellator.getBuffer();
                    if (renderFluidInOut(worldRenderer, side, pipe)) {
                        tessellator.draw();
                    }
                    GlStateManager.translate(-0.5F, -0.5F, -0.5F);
                }
            }
            renderDisplayLists(getListAndRender(null, fluidStack), scale, gas);
            MekanismRenderer.resetColor();
            MekanismRenderer.disableGlow(glowInfo);
            GlStateManager.enableLighting();
            GlStateManager.disableCull();
            GlStateManager.popMatrix();
        }
    }

    private void renderDisplayLists(MekanismRenderer.DisplayInteger[] displayLists, float scale, boolean gas) {
        if (displayLists != null) {
            if (gas) {
                GlStateManager.color(1, 1, 1, scale);
                displayLists[stages - 1].render();
                MekanismRenderer.resetColor();
            } else {
                displayLists[Math.max(3, (int) (scale * (stages - 1)))].render();
            }
        }
    }

    private MekanismRenderer.DisplayInteger[] getListAndRender(EnumFacing side, FluidStack fluid) {
        if (fluid == null) {
            return null;
        }

        int sideOrdinal = side != null ? side.ordinal() : 6;

        if (cachedLiquids.containsKey(sideOrdinal) && cachedLiquids.get(sideOrdinal).containsKey(fluid)) {
            return cachedLiquids.get(sideOrdinal).get(fluid);
        }

        MekanismRenderer.Model3D toReturn = new MekanismRenderer.Model3D();
        toReturn.baseBlock = Blocks.WATER;
        toReturn.setTexture(MekanismRenderer.getFluidTexture(fluid, MekanismRenderer.FluidType.STILL));

        if (side != null) {
            toReturn.setSideRender(side, false);
            toReturn.setSideRender(side.getOpposite(), false);
        }

        MekanismRenderer.DisplayInteger[] displays = new MekanismRenderer.DisplayInteger[stages];

        if (cachedLiquids.containsKey(sideOrdinal)) {
            cachedLiquids.get(sideOrdinal).put(fluid, displays);
        } else {
            FluidRenderMap<MekanismRenderer.DisplayInteger[]> map = new FluidRenderMap<>();
            map.put(fluid, displays);
            cachedLiquids.put(sideOrdinal, map);
        }

        for (int i = 0; i < stages; i++) {
            displays[i] = MekanismRenderer.DisplayInteger.createAndStart();

            switch (sideOrdinal) {
                case 6:
                    toReturn.minX = 0.25 + offset;
                    toReturn.minY = 0.25 + offset;
                    toReturn.minZ = 0.25 + offset;

                    toReturn.maxX = 0.75 - offset;
                    toReturn.maxY = 0.25 + offset + ((float) i / (float) stages) * height;
                    toReturn.maxZ = 0.75 - offset;
                    break;
                case 0:
                    toReturn.minX = 0.5 - (((float) i / (float) stages) * height) / 2;
                    toReturn.minY = 0.0;
                    toReturn.minZ = 0.5 - (((float) i / (float) stages) * height) / 2;

                    toReturn.maxX = 0.5 + (((float) i / (float) stages) * height) / 2;
                    toReturn.maxY = 0.25 + offset;
                    toReturn.maxZ = 0.5 + (((float) i / (float) stages) * height) / 2;
                    break;
                case 1:
                    toReturn.minX = 0.5 - (((float) i / (float) stages) * height) / 2;
                    toReturn.minY = 0.25 - offset + ((float) i / (float) stages) * height;
                    toReturn.minZ = 0.5 - (((float) i / (float) stages) * height) / 2;

                    toReturn.maxX = 0.5 + (((float) i / (float) stages) * height) / 2;
                    toReturn.maxY = 1.0;
                    toReturn.maxZ = 0.5 + (((float) i / (float) stages) * height) / 2;
                    break;
                case 2:
                    toReturn.minX = 0.25 + offset;
                    toReturn.minY = 0.25 + offset;
                    toReturn.minZ = 0.0;

                    toReturn.maxX = 0.75 - offset;
                    toReturn.maxY = 0.25 + offset + ((float) i / (float) stages) * height;
                    toReturn.maxZ = 0.25 + offset;
                    break;
                case 3:
                    toReturn.minX = 0.25 + offset;
                    toReturn.minY = 0.25 + offset;
                    toReturn.minZ = 0.75 - offset;

                    toReturn.maxX = 0.75 - offset;
                    toReturn.maxY = 0.25 + offset + ((float) i / (float) stages) * height;
                    toReturn.maxZ = 1.0;
                    break;
                case 4:
                    toReturn.minX = 0.0;
                    toReturn.minY = 0.25 + offset;
                    toReturn.minZ = 0.25 + offset;

                    toReturn.maxX = 0.25 + offset;
                    toReturn.maxY = 0.25 + offset + ((float) i / (float) stages) * height;
                    toReturn.maxZ = 0.75 - offset;
                    break;
                case 5:
                    toReturn.minX = 0.75 - offset;
                    toReturn.minY = 0.25 + offset;
                    toReturn.minZ = 0.25 + offset;

                    toReturn.maxX = 1.0;
                    toReturn.maxY = 0.25 + offset + ((float) i / (float) stages) * height;
                    toReturn.maxZ = 0.75 - offset;
                    break;
            }

            MekanismRenderer.renderObject(toReturn);
            MekanismRenderer.DisplayInteger.endList();
        }

        return displays;
    }

    public boolean renderFluidInOut(BufferBuilder renderer, EnumFacing side, TileEntityEcoMechanicalPipe pipe) {
        if (pipe != null && pipe.getTransmitter() != null && pipe.getTransmitter().getTransmitterNetwork() != null) {
            bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            FluidNetwork fn = pipe.getTransmitter().getTransmitterNetwork();
            TextureAtlasSprite tex;
            if (fn.buffer != null) {
                tex = MekanismRenderer.getFluidTexture(fn.buffer, MekanismRenderer.FluidType.STILL);
            } else {
                tex = MekanismRenderer.getBaseFluidTexture(fn.refFluid, MekanismRenderer.FluidType.STILL);
            }
            int color = fn.buffer != null ? fn.buffer.getFluid().getColor(fn.buffer) : fn.refFluid.getColor();
            ColourRGBA c = new ColourRGBA(1.0, 1.0, 1.0, pipe.currentScale);
            if (color != 0xFFFFFFFF) {
                c.setRGBFromInt(color);
            }
            renderTransparency(renderer, tex, getModelForSide(pipe, side), c);
            return true;
        }
        return false;
    }


}

