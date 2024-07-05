package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationSpectral;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationSpectral extends RenderSolarStation<TileEntitySolarStationSpectral> {
    @Override
    public String bindTextures() {
        return "SpectralSolarStation.png";
    }
}
