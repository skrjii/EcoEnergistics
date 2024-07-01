package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.TileEntityEcoGenerator;
import aeternal.ecoenergistics.common.util.EcoEnergisticsUtils;
import mekanism.generators.client.model.ModelSolarGenerator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static aeternal.ecoenergistics.common.util.EcoEnergisticsUtils.getResource;

@SideOnly(Side.CLIENT)
public abstract class RenderSolarPanel<T extends TileEntityEcoGenerator> extends TileEntitySpecialRenderer<T> {

    private ModelSolarGenerator model = new ModelSolarGenerator();

    @Override
    public void render(T tileEntity, double x, double y, double z, float partialTick, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(getResource(EcoEnergisticsUtils.ResourceType.RENDER, bindTextures()));
        GlStateManager.rotate(180, 0, 0, 1);
        model.render(0.0625F);
        GlStateManager.popMatrix();
    }

    public abstract String bindTextures();
}
