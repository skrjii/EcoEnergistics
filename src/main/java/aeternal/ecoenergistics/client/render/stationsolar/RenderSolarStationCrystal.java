package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationCrystal;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationCrystal extends RenderSolarStation<TileEntitySolarStationCrystal> {
    @Override
    public String bindTextures() {
        return "CrystalSolarStation.png";
    }
}
