package aeternal.ecoenergistics.client.render.item.panel;

import javax.annotation.Nonnull;
import mekanism.client.render.MekanismRenderer;
import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.client.model.ModelSolarPanelAdv;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelPerfectHybridItem {

    private static ModelSolarPanelAdv solarPanelAdv = new ModelSolarPanelAdv();

    public static void renderStack(@Nonnull ItemStack stack, TransformType transformType) {
        GlStateManager.rotate(180, 0, 0, 1);
        GlStateManager.rotate(90, 0, -1, 0);
        GlStateManager.translate(0, -1.0F, 0);
        MekanismRenderer.bindTexture(Constants.getResource(Constants.ResourceType.RENDER, "PerfectHybridSolarPanel.png"));
        solarPanelAdv.render(0.0625F);
    }
}
