package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelSingular;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelSingular extends RenderSolarPanel<TileEntitySolarPanelSingular> {

    @Override
    public String bindTextures() {
        return "SingularSolarPanel.png";
    }
}
