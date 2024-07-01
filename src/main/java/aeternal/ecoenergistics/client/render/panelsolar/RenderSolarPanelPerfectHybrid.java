package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelPerfectHybrid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelPerfectHybrid extends RenderSolarPanel<TileEntitySolarPanelPerfectHybrid> {

    @Override
    public String bindTextures() {
        return "PerfectHybridSolarPanel.png";
    }
}
