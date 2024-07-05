package aeternal.ecoenergistics.client.render.item.stationsolar;

import aeternal.ecoenergistics.common.util.EcoEnergisticsUtils;
import mekanism.client.render.MekanismRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class RenderSolarStationPerfectHybridItem extends RenderSolarStationsolarGeneratorItem {

    public static void renderStack(@Nonnull ItemStack stack, ItemCameraTransforms.TransformType transformType) {
        GlStateManager.rotate(180, 0, 0, 1);
        GlStateManager.rotate(90, 0, 1, 0);
        GlStateManager.translate(0, 0.2F, 0);
        MekanismRenderer.bindTexture(EcoEnergisticsUtils.getResource(EcoEnergisticsUtils.ResourceType.RENDER, "PerfectHybridSolarStation.png"));
        advancedSolarGenerator.render(0.022F);
    }


}
