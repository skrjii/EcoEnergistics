package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelDiffractive;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelDiffractive extends RenderSolarPanel<TileEntitySolarPanelDiffractive> {

    @Override
    public String bindTextures() {
        return "DiffractiveSolarPanel.png";
    }
}
