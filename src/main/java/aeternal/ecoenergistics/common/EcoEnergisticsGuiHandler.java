package aeternal.ecoenergistics.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.jetbrains.annotations.Nullable;

public class EcoEnergisticsGuiHandler implements IGuiHandler {

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return EcoEnergistics.proxy.getServerGui(ID, player, world, new BlockPos(x, y, z));
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return EcoEnergistics.proxy.getClientGui(ID, player, world, new BlockPos(x, y, z));
    }
}
