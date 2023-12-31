package aeternal.ecoenergistics.client.render.solar.panel;

import aeternal.ecoenergistics.common.tile.solar.panel.TileEntitySolarPanelAdvanced;
import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.client.model.ModelSolarPanelAdv;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderSolarPanelAdv extends TileEntitySpecialRenderer<TileEntitySolarPanelAdvanced> {

    private ModelSolarPanelAdv model = new ModelSolarPanelAdv();

    @Override
    public void render(TileEntitySolarPanelAdvanced tileEntity, double x, double y, double z, float partialTick, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(Constants.getResource(Constants.ResourceType.RENDER, "AdvancedSolarPanel.png"));
        GlStateManager.rotate(180, 0, 0, 1);
        model.render(0.0625F);
        GlStateManager.popMatrix();
    }
}