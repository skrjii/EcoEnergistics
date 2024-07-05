package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelProtonic;
import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelQuantum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelQuantum extends RenderSolarPanel<TileEntitySolarPanelQuantum> {

    @Override
    public String bindTextures() {
        return "QuantumSolarPanel.png";
    }
}
