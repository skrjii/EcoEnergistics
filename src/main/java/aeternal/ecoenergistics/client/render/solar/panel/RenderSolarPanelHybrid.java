package aeternal.ecoenergistics.client.render.solar.panel;

import aeternal.ecoenergistics.client.model.ModelSolarPanelHybrid;
import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.tile.solar.panel.TileEntitySolarPanelHybrid;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderSolarPanelHybrid extends TileEntitySpecialRenderer<TileEntitySolarPanelHybrid> {

    private ModelSolarPanelHybrid model = new ModelSolarPanelHybrid();

    @Override
    public void render(TileEntitySolarPanelHybrid tileEntity, double x, double y, double z, float partialTick, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(Constants.getResource(Constants.ResourceType.RENDER, "HybridSolarPanel.png"));
        GlStateManager.rotate(180, 0, 0, 1);
        model.render(0.0625F);
        GlStateManager.popMatrix();
    }
}