package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelPhotonic;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelPhotonic extends RenderSolarPanel<TileEntitySolarPanelPhotonic> {

    @Override
    public String bindTextures() {
        return "PhotonicSolarPanel.png";
    }
}
