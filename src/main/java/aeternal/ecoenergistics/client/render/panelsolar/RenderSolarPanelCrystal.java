package aeternal.ecoenergistics.client.render.panelsolar;

import aeternal.ecoenergistics.common.tile.panelsolar.TileEntitySolarPanelCrystal;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarPanelCrystal extends  RenderSolarPanel<TileEntitySolarPanelCrystal>{

    @Override
    public String bindTextures() {
        return "CrystalSolarPanel.png";
    }
}
