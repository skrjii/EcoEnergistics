package aeternal.ecoenergistics.common.block;

import aeternal.ecoenergistics.EcoEnergistics;
import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoGeneratorAdd;
import aeternal.ecoenergistics.common.tile.BlockEcoContainer;
import aeternal.ecoenergistics.common.tile.TileEntityEcoBasicBlock;
import aeternal.ecoenergistics.common.tile.TileEntityEcoContainerBlock;
import aeternal.ecoenergistics.common.tile.TileEntityEcoElectricBlock;

import mekanism.api.IMekWrench;
import mekanism.api.energy.IEnergizedItem;
import mekanism.common.base.*;
import mekanism.common.block.states.BlockStateFacing;
import mekanism.common.integration.wrenches.Wrenches;
import mekanism.common.multiblock.IMultiblock;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.SecurityUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Random;


public abstract class BlockEcoGeneratorAdd extends BlockEcoContainer {

    private static final AxisAlignedBB SOLAR_BOUNDS = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.7F, 1.0F);

    public BlockEcoGeneratorAdd() {
        super(Material.IRON);
        setHardness(3.5F);
        setResistance(8F);
        setCreativeTab(EcoEnergistics.tabEcoEnergistics);
    }

    public static BlockEcoGeneratorAdd getGeneratorBlock(BlockStateEcoGeneratorAdd.EcoGeneratorBlock block) {
        return new BlockEcoGeneratorAdd() {
            @Override
            public BlockStateEcoGeneratorAdd.EcoGeneratorBlock getGeneratorBlock() {
                return block;
            }
        };
    }

    public abstract BlockStateEcoGeneratorAdd.EcoGeneratorBlock getGeneratorBlock();

    @Nonnull
    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateEcoGeneratorAdd(this, getTypeProperty());
    }

    @Nonnull
    @Override
    @Deprecated
    public IBlockState getStateFromMeta(int meta) {
        BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd type = BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.get(getGeneratorBlock(), meta & 0xF);
        return getDefaultState().withProperty(getTypeProperty(), type);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd type = state.getValue(getTypeProperty());
        return type.meta;
    }

    @Nonnull
    @Override
    @Deprecated
    public IBlockState getActualState(@Nonnull IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        TileEntity tile = MekanismUtils.getTileEntitySafe(worldIn, pos);
        if (tile instanceof TileEntityEcoBasicBlock && ((TileEntityEcoBasicBlock) tile).facing != null) {
            state = state.withProperty(BlockStateFacing.facingProperty, ((TileEntityEcoBasicBlock) tile).facing);
        }
        if (tile instanceof IActiveState) {
            state = state.withProperty(BlockStateEcoGeneratorAdd.activeProperty, ((IActiveState) tile).getActive());
        }
        return state;
    }

    @Override
    @Deprecated
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos neighborPos) {
        if (!world.isRemote) {
            final TileEntity tileEntity = MekanismUtils.getTileEntity(world, pos);
            if (tileEntity instanceof TileEntityEcoBasicBlock) {
                ((TileEntityEcoBasicBlock) tileEntity).onNeighborChange(neighborBlock);
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entityliving, ItemStack itemstack) {
        TileEntityEcoBasicBlock tileEntity = (TileEntityEcoBasicBlock) world.getTileEntity(pos);
        EnumFacing change = EnumFacing.SOUTH;
        if (tileEntity.canSetFacing(EnumFacing.DOWN) && tileEntity.canSetFacing(EnumFacing.UP)) {
            int height = Math.round(entityliving.rotationPitch);
            if (height >= 65) {
                change = EnumFacing.UP;
            } else if (height <= -65) {
                change = EnumFacing.DOWN;
            }
        }

        if (change != EnumFacing.DOWN && change != EnumFacing.UP) {
            int side = MathHelper.floor((double) (entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            switch (side) {
                case 0:
                    change = EnumFacing.NORTH;
                    break;
                case 1:
                    change = EnumFacing.EAST;
                    break;
                case 2:
                    change = EnumFacing.SOUTH;
                    break;
                case 3:
                    change = EnumFacing.WEST;
                    break;
            }
        }

        tileEntity.setFacing(change);
        tileEntity.redstone = world.getRedstonePowerFromNeighbors(pos) > 0;
        if (tileEntity instanceof IBoundingBlock) {
            ((IBoundingBlock) tileEntity).onPlace();
        }
        if (!world.isRemote && tileEntity instanceof IMultiblock) {
            ((IMultiblock<?>) tileEntity).doUpdate();
        }

    }

    /*@Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        if (MekanismConfig.current().client.enableAmbientLighting.val()) {
            TileEntity tileEntity = MekanismUtils.getTileEntitySafe(world, pos);
            if (tileEntity instanceof IActiveState && !(tileEntity instanceof TileEntitySolarPanelAdvanced)&& !(tileEntity instanceof TileEntitySolarPanelHybrid)) {
                if (((IActiveState) tileEntity).getActive() && ((IActiveState) tileEntity).lightUpdate()) {
                    return MekanismConfig.current().client.ambientLightingLevel.val();
                }
            }
        }
        return 0;
    }
*/

    @Override
    public int damageDropped(IBlockState state) {
        return state.getBlock().getMetaFromState(state);
    }

    @Override
    @Deprecated
    public float getPlayerRelativeBlockHardness(IBlockState state, @Nonnull EntityPlayer player, @Nonnull World world, @Nonnull BlockPos pos){
        return super.getPlayerRelativeBlockHardness(state, player, world, pos);
    }


    @Override
    public void getSubBlocks(CreativeTabs creativetabs, NonNullList<ItemStack> list) {
        for (BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd type : BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.values()) {
            if (type.isEnabled()) {
                list.add(new ItemStack(this, 1, type.meta));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
        BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd type = BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.get(state.getBlock(), state.getBlock().getMetaFromState(state));
        TileEntityEcoBasicBlock tileEntity = (TileEntityEcoBasicBlock) world.getTileEntity(pos);

        if (MekanismUtils.isActive(world, pos)) {
            float xRandom = (float) pos.getX() + 0.5F;
            float yRandom = (float) pos.getY() + random.nextFloat() * 6.0F / 16.0F;
            float zRandom = (float) pos.getZ() + 0.5F;
            float iRandom = 0.52F;
            float jRandom = random.nextFloat() * 0.6F - 0.3F;
        }
    }

    @Override
    public void breakBlock(World world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        TileEntityEcoBasicBlock tileEntity = (TileEntityEcoBasicBlock) world.getTileEntity(pos);
        if (tileEntity instanceof IBoundingBlock) {
            ((IBoundingBlock) tileEntity).onBreak();
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entityplayer,
                                    EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        TileEntityEcoBasicBlock tileEntity = (TileEntityEcoBasicBlock) world.getTileEntity(pos);
        int metadata = state.getBlock().getMetaFromState(state);
        ItemStack stack = entityplayer.getHeldItem(hand);

        if (!stack.isEmpty()) {
            IMekWrench wrenchHandler = Wrenches.getHandler(stack);
            if (wrenchHandler != null) {
                RayTraceResult raytrace = new RayTraceResult(new Vec3d(hitX, hitY, hitZ), side, pos);
                if (wrenchHandler.canUseWrench(entityplayer, hand, stack, raytrace)) {
                    /*if (SecurityUtils.canAccess(entityplayer, tileEntity)) {*/
                        wrenchHandler.wrenchUsed(entityplayer, hand, stack, raytrace);
                        if (entityplayer.isSneaking()) {
                            MekanismUtils.dismantleBlock(this, state, world, pos);
                            return true;
                        }
                        if (tileEntity != null) {
                            tileEntity.setFacing(tileEntity.facing.rotateY());
                            world.notifyNeighborsOfStateChange(pos, this, true);
                        }
                    /*}*/ else {
                        SecurityUtils.displayNoAccess(entityplayer);
                    }
                    return true;
                }
            }
        }

        int guiId = BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.get(getGeneratorBlock(), metadata).guiId;

        /*if (guiId != -1 && tileEntity != null) {
            if (!entityplayer.isSneaking()) {
                if (true) {
                    entityplayer.openGui(EcoEnergistics.instance, guiId, world, pos.getX(), pos.getY(), pos.getZ());
                } else {
                    SecurityUtils.displayNoAccess(entityplayer);
                }
                return true;
            }
        }*/
        return false;
    }

    @Override
    public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState state) {
        int metadata = state.getBlock().getMetaFromState(state);
        if (BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.get(getGeneratorBlock(), metadata) == null) {
            return null;
        }
        return BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.get(getGeneratorBlock(), metadata).create();
    }

    @Nonnull
    @Override
    @Deprecated
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Nonnull
    @Override
    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face) {
        BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd type = BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.get(state);
        if (type != null) {
            switch (type) {
                case SOLAR_STATION_ADVANCED:
                case SOLAR_STATION_HYBRID:
                case SOLAR_STATION_PERFECTHYBRID:
                case SOLAR_STATION_QUANTUM:
                case SOLAR_STATION_SPECTRAL:
                case SOLAR_STATION_PROTONIC:
                case SOLAR_STATION_SINGULAR:
                case SOLAR_STATION_DIFFRACTIVE:
                case SOLAR_STATION_PHOTONIC:
                case SOLAR_STATION_NEUTRON:
            }
        }
        return super.getBlockFaceShape(world, state, pos, face);
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    /*This method is not used, metadata manipulation is required to create a Tile Entity.*/
    @Override
    public TileEntity createNewTileEntity(@Nonnull World world, int meta) {
        return null;
    }

    @Nonnull
    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd type = BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.get(state);
        return super.getBoundingBox(state, world, pos);
    }

    @Nonnull
    @Override
    protected ItemStack getDropItem(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos) {
        TileEntityEcoBasicBlock tileEntity = (TileEntityEcoBasicBlock) world.getTileEntity(pos);
        ItemStack itemStack = new ItemStack(EcoEnergisticsBlocks.EcoGeneratorAdd, 1, state.getBlock().getMetaFromState(state));
        if (tileEntity == null) {
            return ItemStack.EMPTY;
        }

        if (tileEntity instanceof TileEntityEcoElectricBlock) {
            IEnergizedItem electricItem = (IEnergizedItem) itemStack.getItem();
            electricItem.setEnergy(itemStack, ((TileEntityEcoElectricBlock) tileEntity).electricityStored);
        }
        if (tileEntity instanceof TileEntityEcoContainerBlock && ((TileEntityEcoContainerBlock) tileEntity).handleInventory()) {
            ISustainedInventory inventory = (ISustainedInventory) itemStack.getItem();
            inventory.setInventory(((TileEntityEcoContainerBlock) tileEntity).getInventory(), itemStack);
        }
        if (tileEntity instanceof ISustainedData) {
            ((ISustainedData) tileEntity).writeSustainedData(itemStack);
        }
        return itemStack;
    }

    @Override
    @Deprecated
    public boolean isSideSolid(IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, EnumFacing side) {
        BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd type = BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.get(getGeneratorBlock(), state.getBlock().getMetaFromState(state));
        return
                 type != BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.SOLAR_STATION_ADVANCED && type != BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.SOLAR_STATION_HYBRID && type != BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.SOLAR_STATION_PERFECTHYBRID
                && type != BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.SOLAR_STATION_QUANTUM && type != BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.SOLAR_STATION_SPECTRAL && type != BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.SOLAR_STATION_PROTONIC
                && type != BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.SOLAR_STATION_SINGULAR && type != BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.SOLAR_STATION_DIFFRACTIVE && type != BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.SOLAR_STATION_PHOTONIC
                && type != BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.SOLAR_STATION_NEUTRON;

    }

    @Override
    public EnumFacing[] getValidRotations(World world, @Nonnull BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        EnumFacing[] valid = new EnumFacing[6];
        if (tile instanceof TileEntityEcoBasicBlock) {
            TileEntityEcoBasicBlock basicTile = (TileEntityEcoBasicBlock) tile;
            for (EnumFacing dir : EnumFacing.VALUES) {
                if (basicTile.canSetFacing(dir)) {
                    valid[dir.ordinal()] = dir;
                }
            }
        }
        return valid;
    }

    @Override
    public boolean rotateBlock(World world, @Nonnull BlockPos pos, @Nonnull EnumFacing axis) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileEntityEcoBasicBlock) {
            TileEntityEcoBasicBlock basicTile = (TileEntityEcoBasicBlock) tile;
            if (basicTile.canSetFacing(axis)) {
                basicTile.setFacing(axis);
                return true;
            }
        }
        return false;
    }

    public PropertyEnum<BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd> getTypeProperty() {
        return getGeneratorBlock().getProperty();
    }


    @Override
    public boolean hasComparatorInputOverride(IBlockState blockState) {
        BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd generatorType = BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.get(blockState);
        return generatorType != null && generatorType.hasRedstoneOutput;
    }

    @Override
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
        BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd generatorType = BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd.get(blockState);
        if (generatorType != null && generatorType.hasRedstoneOutput) {
            TileEntity tile = worldIn.getTileEntity(pos);
            if (tile instanceof IComparatorSupport) {
                return ((IComparatorSupport) tile).getRedstoneLevel();
            }
        }
        return 0;
    }
}