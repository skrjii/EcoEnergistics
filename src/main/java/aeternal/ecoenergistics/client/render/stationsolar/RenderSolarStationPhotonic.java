package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationPhotonic;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationPhotonic extends RenderSolarStation<TileEntitySolarStationPhotonic> {
    @Override
    public String bindTextures() {
        return "PhotonicSolarStation.png";
    }
}
