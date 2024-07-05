package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelHybrid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelHybrid extends RenderSolarPanel<TileEntitySolarPanelHybrid> {

    @Override
    public String bindTextures() {
        return "HybridSolarPanel.png";
    }
}
