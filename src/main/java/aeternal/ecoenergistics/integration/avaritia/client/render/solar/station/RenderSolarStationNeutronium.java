package aeternal.ecoenergistics.integration.avaritia.client.render.solar.station;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.integration.avaritia.client.model.ModelSolarStationAvaritia;
import aeternal.ecoenergistics.integration.avaritia.common.tile.solar.station.TileEntitySolarStationNeutronium;
import mekanism.client.render.MekanismRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationNeutronium extends TileEntitySpecialRenderer<TileEntitySolarStationNeutronium> {

    private ModelSolarStationAvaritia model = new ModelSolarStationAvaritia();

    @Override
    public void render(TileEntitySolarStationNeutronium tileEntity, double x, double y, double z, float partialTick, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(Constants.getResource(Constants.ResourceType.RENDER, "NeutroniumSolarStation.png"));
        MekanismRenderer.rotate(tileEntity.facing, 0, 180, 90, 270);
        GlStateManager.rotate(180, 0, 0, 1);
        model.render(0.0625F);
        GlStateManager.popMatrix();
    }
}