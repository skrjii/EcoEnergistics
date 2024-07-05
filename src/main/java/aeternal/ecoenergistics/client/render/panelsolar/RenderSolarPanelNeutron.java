package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelNeutron;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelNeutron extends RenderSolarPanel<TileEntitySolarPanelNeutron> {

    @Override
    public String bindTextures() {
        return "NeutronSolarPanel.png";
    }
}
