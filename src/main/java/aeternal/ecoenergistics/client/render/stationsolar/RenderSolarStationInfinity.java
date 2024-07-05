package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationInfinity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationInfinity extends RenderSolarStation<TileEntitySolarStationInfinity> {
    @Override
    public String bindTextures() {
        return "InfinitySolarStation.png";
    }
}
