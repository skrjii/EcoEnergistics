package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationProtonic;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationProtonic extends RenderSolarStation<TileEntitySolarStationProtonic> {
    @Override
    public String bindTextures() {
        return "ProtonicSolarStation.png";
    }
}
