package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationQuantum;
import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationSingular;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationSingular extends RenderSolarStation<TileEntitySolarStationSingular> {
    @Override
    public String bindTextures() {
        return "SingularSolarStation.png";
    }
}
