package aeternal.ecoenergistics.client.render.solar.station;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.tile.solar.station.TileEntitySolarStationAdv;
import aeternal.ecoenergistics.common.tile.solar.station.TileEntitySolarStationHybrid;
import mekanism.client.render.MekanismRenderer;

import mekanism.generators.client.model.ModelAdvancedSolarGenerator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationHybrid extends TileEntitySpecialRenderer<TileEntitySolarStationHybrid> {

    private ModelAdvancedSolarGenerator model = new ModelAdvancedSolarGenerator();

    @Override
    public void render(TileEntitySolarStationHybrid tileEntity, double x, double y, double z, float partialTick, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(Constants.getResource(Constants.ResourceType.RENDER, "HybridSolarStation.png"));
        MekanismRenderer.rotate(tileEntity.facing, 0, 180, 90, 270);
        GlStateManager.rotate(180, 0, 0, 1);
        model.render(0.0625F);
        GlStateManager.popMatrix();
    }
}