package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationHybrid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationHybrid extends RenderSolarStation<TileEntitySolarStationHybrid> {
    @Override
    public String bindTextures() {
        return "HybridSolarStation.png";
    }
}
