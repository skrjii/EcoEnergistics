package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelProtonic;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelProtonic extends RenderSolarPanel<TileEntitySolarPanelProtonic> {

    @Override
    public String bindTextures() {
        return "ProtonicSolarPanel.png";
    }
}
