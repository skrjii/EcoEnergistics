package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationPerfectHybrid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationPerfectHybrid extends RenderSolarStation<TileEntitySolarStationPerfectHybrid> {
    @Override
    public String bindTextures() {
        return "PerfectHybridSolarStation.png";
    }
}
