package aeternal.ecoenergistics.client.gui;

import aeternal.ecoenergistics.EcoEnergistics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CoreGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return EcoEnergistics.proxy.getServerGui(ID, player, world, new BlockPos(x, y, z));
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return EcoEnergistics.proxy.getClientGui(ID, player, world, new BlockPos(x, y, z));
    }
}