package aeternal.ecoenergistics.client.render.stationsolar;

import aeternal.ecoenergistics.common.tile.stationsolar.TileEntitySolarStationQuantum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarStationQuantum extends RenderSolarStation<TileEntitySolarStationQuantum> {
    @Override
    public String bindTextures() {
        return "QuantumSolarStation.png";
    }
}
