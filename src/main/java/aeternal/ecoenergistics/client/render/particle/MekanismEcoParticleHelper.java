package aeternal.ecoenergistics.client.render.particle;

import aeternal.ecoenergistics.common.base.EcoITieredTile;
import mekanism.api.EnumColor;
import mekanism.client.render.particle.TieredParticleDigging;
import mekanism.common.base.ITieredTile;
import mekanism.common.util.MekanismUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MekanismEcoParticleHelper   {
    private static final double OFFSET_1 = 0.20000000298023224D;
    private static final double OFFSET_2 = 0.10000000149011612D;
    public static boolean addBlockHitEffects(World world, BlockPos pos, EnumFacing side, ParticleManager manager) {
        TileEntity tile = MekanismUtils.getTileEntitySafe(world, pos);
        EnumColor color = null;
        IBlockState iblockstate = world.getBlockState(pos);
        iblockstate = iblockstate.getBlock().getActualState(iblockstate, world, pos);
        if (tile instanceof EcoITieredTile){
            color = ((ITieredTile) tile).getTier().getColor();
        }
        if (iblockstate.getRenderType() != EnumBlockRenderType.INVISIBLE) {
            int blockX = pos.getX();
            int blockY = pos.getY();
            int blockZ = pos.getZ();
            AxisAlignedBB axisalignedbb = iblockstate.getBoundingBox(world, pos);
            double particleX = (double) blockX + world.rand.nextDouble() * (axisalignedbb.maxX - axisalignedbb.minX - OFFSET_1) + OFFSET_2 + axisalignedbb.minX;
            double particleY = (double) blockY + world.rand.nextDouble() * (axisalignedbb.maxY - axisalignedbb.minY - OFFSET_1) + OFFSET_2 + axisalignedbb.minY;
            double particleZ = (double) blockZ + world.rand.nextDouble() * (axisalignedbb.maxZ - axisalignedbb.minZ - OFFSET_1) + OFFSET_2 + axisalignedbb.minZ;

            switch (side) {
                case DOWN -> particleY = (double) blockY + axisalignedbb.minY - OFFSET_2;
                case UP -> particleY = (double) blockY + axisalignedbb.maxY + OFFSET_2;
                case NORTH -> particleZ = (double) blockZ + axisalignedbb.minZ - OFFSET_2;
                case SOUTH -> particleZ = (double) blockZ + axisalignedbb.maxZ + OFFSET_2;
                case WEST -> particleX = (double) blockX + axisalignedbb.minX - OFFSET_2;
                case EAST -> particleX = (double) blockX + axisalignedbb.maxX + OFFSET_2;
            }
            manager.addEffect(new TieredParticleDigging(world, particleX, particleY, particleZ, 0, 0, 0, iblockstate, color)
                    .setBlockPos(pos).multiplyVelocity(0.2F).multipleParticleScaleBy(0.6F));

        }
        return true;
    }
}
