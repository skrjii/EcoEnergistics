package aeternal.ecoenergistics.integration.avaritia.client.render.item.station;

import javax.annotation.Nonnull;

import aeternal.ecoenergistics.integration.avaritia.client.model.ModelSolarStationAvaritia;
import mekanism.client.render.MekanismRenderer;
import aeternal.ecoenergistics.Constants;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationCrystalItem {

    private static ModelSolarStationAvaritia crystalSolarStation = new ModelSolarStationAvaritia();

    public static void renderStack(@Nonnull ItemStack stack, TransformType transformType) {
        GlStateManager.rotate(180, 0, 0, 1);
        GlStateManager.rotate(90, 0, 1, 0);
        GlStateManager.translate(0, 0.2F, 0);
        MekanismRenderer.bindTexture(Constants.getResource(Constants.ResourceType.RENDER, "CrystalSolarStation.png"));
        crystalSolarStation.render(0.022F);
    }
}