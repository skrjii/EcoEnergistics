package aeternal.ecoenergistics.common.integration.forgeenergy;

import aeternal.ecoenergistics.common.tile.transmitter.TileEntityEcoUniversalCable;
import mekanism.common.integration.forgeenergy.ForgeEnergyIntegration;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.energy.IEnergyStorage;

public class EcoForgeEnergyCableIntegration implements IEnergyStorage {

    public TileEntityEcoUniversalCable tileEntity;

    public EnumFacing side;

    public EcoForgeEnergyCableIntegration(TileEntityEcoUniversalCable tile, EnumFacing facing) {
        tileEntity = tile;
        side = facing;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return ForgeEnergyIntegration.toForge(tileEntity.acceptEnergy(side, ForgeEnergyIntegration.fromForge(maxReceive), simulate));
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored() {
        return ForgeEnergyIntegration.toForge(tileEntity.getEnergy());
    }

    @Override
    public int getMaxEnergyStored() {
        return ForgeEnergyIntegration.toForge(tileEntity.getMaxEnergy());
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return tileEntity.canReceiveEnergy(side);
    }
}
