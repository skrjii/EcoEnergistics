package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelInfinity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelInfinity extends  RenderSolarPanel<TileEntitySolarPanelInfinity>{

    @Override
    public String bindTextures() {
        return "InfinitySolarPanel.png";
    }
}
