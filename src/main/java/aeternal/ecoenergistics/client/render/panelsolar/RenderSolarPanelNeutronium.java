package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelNeutronium;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelNeutronium extends  RenderSolarPanel<TileEntitySolarPanelNeutronium>{

    @Override
    public String bindTextures() {
        return "NeutroniumSolarPanel.png";
    }
}
