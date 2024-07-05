package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationAdv;
import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationDiffractive;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationDiffractive extends RenderSolarStation<TileEntitySolarStationDiffractive>{
    @Override
    public String bindTextures() {
        return "DiffractiveSolarStation.png";
    }
}
