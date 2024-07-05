package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationAdv;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationAdv extends RenderSolarStation<TileEntitySolarStationAdv>{
    @Override
    public String bindTextures() {
        return "AdvancedSolarStation.png";
    }
}
