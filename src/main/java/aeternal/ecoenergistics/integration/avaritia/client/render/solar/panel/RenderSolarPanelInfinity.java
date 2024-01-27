package aeternal.ecoenergistics.integration.avaritia.client.render.solar.panel;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.integration.avaritia.client.model.ModelSolarPanelAvaritia;
import aeternal.ecoenergistics.integration.avaritia.common.tile.solar.panel.TileEntitySolarPanelInfinity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderSolarPanelInfinity extends TileEntitySpecialRenderer<TileEntitySolarPanelInfinity> {

    private ModelSolarPanelAvaritia model = new ModelSolarPanelAvaritia();

    @Override
    public void render(TileEntitySolarPanelInfinity tileEntity, double x, double y, double z, float partialTick, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(Constants.getResource(Constants.ResourceType.RENDER, "InfinitySolarPanel.png"));
        GlStateManager.rotate(180, 0, 0, 1);
        model.render(0.0625F);
        GlStateManager.popMatrix();
    }
}