package aeternal.ecoenergistics.client.render.item.station;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.client.model.ModelSolarStationAdv;
import mekanism.client.render.MekanismRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class RenderSolarStationSingularItem {

    private static ModelSolarStationAdv advancedSolarStation = new ModelSolarStationAdv();

    public static void renderStack(@Nonnull ItemStack stack, TransformType transformType) {
        GlStateManager.rotate(180, 0, 0, 1);
        GlStateManager.rotate(90, 0, 1, 0);
        GlStateManager.translate(0, 0.2F, 0);
        MekanismRenderer.bindTexture(Constants.getResource(Constants.ResourceType.RENDER, "SingularSolarStation.png"));
        advancedSolarStation.render(0.022F);
    }
}