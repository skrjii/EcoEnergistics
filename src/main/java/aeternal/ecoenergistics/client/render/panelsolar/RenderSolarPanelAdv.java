package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelAdvanced;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelAdv extends  RenderSolarPanel<TileEntitySolarPanelAdvanced>{

    @Override
    public String bindTextures() {
        return "AdvancedSolarPanel.png";
    }
}
