package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationNeutronium;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationNeutronium extends RenderSolarStation<TileEntitySolarStationNeutronium> {
    @Override
    public String bindTextures() {
        return "NeutroniumSolarStation.png";
    }
}
