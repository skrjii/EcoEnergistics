package aeternal.ecoenergistics.common.integration.tesla;

import aeternal.ecoenergistics.common.tile.transmitter.TileEntityEcoUniversalCable;
import mekanism.common.integration.MekanismHooks;
import mekanism.common.integration.tesla.TeslaIntegration;
import net.darkhax.tesla.api.ITeslaConsumer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.Optional;

@Optional.Interface(iface = "net.darkhax.tesla.api.ITeslaConsumer", modid = MekanismHooks.TESLA_MOD_ID)
public class EcoTeslaCableIntegration  implements ITeslaConsumer {
    public TileEntityEcoUniversalCable tileEntity;

    public EnumFacing side;
    public EcoTeslaCableIntegration(TileEntityEcoUniversalCable tile, EnumFacing facing) {
        tileEntity = tile;
        side = facing;
    }
    @Override
    @Optional.Method(modid = MekanismHooks.TESLA_MOD_ID)
    public long givePower(long power, boolean simulate) {
        return TeslaIntegration.toTesla(tileEntity.acceptEnergy(side, TeslaIntegration.fromTesla(power), simulate));
    }
}
