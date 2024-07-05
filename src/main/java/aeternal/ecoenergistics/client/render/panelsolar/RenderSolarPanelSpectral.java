package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelSpectral;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelSpectral extends RenderSolarPanel<TileEntitySolarPanelSpectral> {

    @Override
    public String bindTextures() {
        return "SpectralSolarPanel.png";
    }
}
