package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationNeutron;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationNeutron extends RenderSolarStation<TileEntitySolarStationNeutron> {
    @Override
    public String bindTextures() {
        return "NeutronSolarStation.png";
    }
}
