package aeternal.ecoenergistics.common.block.states;

import java.util.Locale;
import java.util.function.Predicate;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.block.BlockEcoGeneratorAdd;
import aeternal.ecoenergistics.common.tile.solar.station.*;
import mekanism.common.base.IBlockType;
import mekanism.common.block.states.BlockStateFacing;
import mekanism.common.block.states.BlockStateUtils;
import mekanism.common.util.LangUtils;
import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Plane;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

public class BlockStateEcoGeneratorAdd extends ExtendedBlockState {

    public static final PropertyBool activeProperty = PropertyBool.create("active");

    public BlockStateEcoGeneratorAdd(BlockEcoGeneratorAdd block, PropertyEnum<?> typeProperty) {
        super(block, new IProperty[]{BlockStateFacing.facingProperty, typeProperty, activeProperty}, new IUnlistedProperty[]{});
    }

    public enum EcoGeneratorBlock {
        GENERATOR_BLOCK_ECO2;

        PropertyEnum<EcoGeneratorTypeAdd> generatorTypeProperty;

        public PropertyEnum<EcoGeneratorTypeAdd> getProperty() {
            if (generatorTypeProperty == null) {
                generatorTypeProperty = PropertyEnum.create("type", EcoGeneratorTypeAdd.class, input -> input != null && input.blockType == this);
            }
            return generatorTypeProperty;
        }

        public Block getBlock() {
            if (this == EcoGeneratorBlock.GENERATOR_BLOCK_ECO2) {
                return EcoEnergisticsBlocks.EcoGeneratorAdd;
            }
            return null;
        }
    }

    public enum EcoGeneratorTypeAdd implements IStringSerializable, IBlockType {

        SOLAR_STATION_ADVANCED(EcoGeneratorBlock.GENERATOR_BLOCK_ECO2, 0, "SolarStationAdvanced", 1, 800000, TileEntitySolarStationAdv::new, true, Plane.HORIZONTAL, false),
        SOLAR_STATION_HYBRID(EcoGeneratorBlock.GENERATOR_BLOCK_ECO2, 1, "SolarStationHybrid", 1, 2400000, TileEntitySolarStationHybrid::new, true, Plane.HORIZONTAL, false),
        SOLAR_STATION_PERFECTHYBRID(EcoGeneratorBlock.GENERATOR_BLOCK_ECO2, 2, "SolarStationPerfectHybrid", 1, 7200000,TileEntitySolarStationPerfectHybrid::new, true,Plane.HORIZONTAL, false),
        SOLAR_STATION_QUANTUM(EcoGeneratorBlock.GENERATOR_BLOCK_ECO2, 3, "SolarStationQuantum", 1, 21600000, TileEntitySolarStationQuantum::new, true, Plane.HORIZONTAL, false),
        SOLAR_STATION_SPECTRAL(EcoGeneratorBlock.GENERATOR_BLOCK_ECO2, 4, "SolarStationSpectral", 1, 6480000,TileEntitySolarStationSpectral::new, true,Plane.HORIZONTAL, false),
        SOLAR_STATION_PROTONIC(EcoGeneratorBlock.GENERATOR_BLOCK_ECO2, 5, "SolarStationProtonic", 1, 8640000,TileEntitySolarStationProtonic::new, true,Plane.HORIZONTAL, false),
        SOLAR_STATION_SINGULAR(EcoGeneratorBlock.GENERATOR_BLOCK_ECO2, 6, "SolarStationSingular", 1, 34560000, TileEntitySolarStationSingular::new, true, Plane.HORIZONTAL, false),
        SOLAR_STATION_DIFFRACTIVE(EcoGeneratorBlock.GENERATOR_BLOCK_ECO2, 7, "SolarStationDiffractive", 1, 138240000, TileEntitySolarStationDiffractive::new, true, Plane.HORIZONTAL, false),
        SOLAR_STATION_PHOTONIC(EcoGeneratorBlock.GENERATOR_BLOCK_ECO2, 8, "SolarStationPhotonic", 1, 552960000, TileEntitySolarStationPhotonic::new, true, Plane.HORIZONTAL, false),
        SOLAR_STATION_NEUTRON(EcoGeneratorBlock.GENERATOR_BLOCK_ECO2, 9, "SolarStationNeutron", 1, 663552000, TileEntitySolarStationNeutron::new, true, Plane.HORIZONTAL, false);


        public EcoGeneratorBlock blockType;
        public int meta;
        public String blockName;
        public int guiId;
        public double maxEnergy;
        public Supplier<TileEntity> tileEntitySupplier;
        public boolean hasModel;
        public Predicate<EnumFacing> facingPredicate;
        public boolean activable;
        public boolean hasRedstoneOutput;

        EcoGeneratorTypeAdd(EcoGeneratorBlock block, int m, String name, int gui, double energy, Supplier<TileEntity> tileClass, boolean model, Predicate<EnumFacing> predicate,
                         boolean hasActiveTexture) {
            this(block, m, name, gui, energy, tileClass, model, predicate, hasActiveTexture, false);
        }

        EcoGeneratorTypeAdd(EcoGeneratorBlock block, int m, String name, int gui, double energy, Supplier<TileEntity> tileClass, boolean model, Predicate<EnumFacing> predicate,
                         boolean hasActiveTexture, boolean hasRedstoneOutput) {
            blockType = block;
            meta = m;
            blockName = name;
            guiId = gui;
            maxEnergy = energy;
            tileEntitySupplier = tileClass;
            hasModel = model;
            facingPredicate = predicate;
            activable = hasActiveTexture;
            this.hasRedstoneOutput = hasRedstoneOutput;
        }

        public static EcoGeneratorTypeAdd get(IBlockState state) {
            if (state.getBlock() instanceof BlockEcoGeneratorAdd) {
                return state.getValue(((BlockEcoGeneratorAdd) state.getBlock()).getTypeProperty());
            }
            return null;
        }

        public static EcoGeneratorTypeAdd get(Block block, int meta) {
            if (block instanceof BlockEcoGeneratorAdd) {
                return get(((BlockEcoGeneratorAdd) block).getGeneratorBlock(), meta);
            }
            return null;
        }

        public static EcoGeneratorTypeAdd get(EcoGeneratorBlock block, int meta) {
            for (EcoGeneratorTypeAdd type : values()) {
                if (type.meta == meta && type.blockType == block) {
                    return type;
                }
            }
            return null;
        }

        public static EcoGeneratorTypeAdd get(ItemStack stack) {
            return get(Block.getBlockFromItem(stack.getItem()), stack.getItemDamage());
        }

        @Override
        public String getBlockName() {
            return blockName;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        public TileEntity create() {
            return this.tileEntitySupplier != null ? this.tileEntitySupplier.get() : null;
        }

        @Override
        public String getName() {
            return name().toLowerCase(Locale.ROOT);
        }

        public String getDescription() {
            return LangUtils.localize("tooltip." + blockName);
        }

        public ItemStack getStack() {
            return new ItemStack(EcoEnergisticsBlocks.EcoGeneratorAdd, 1, meta);
        }

        public boolean canRotateTo(EnumFacing side) {
            return facingPredicate.test(side);
        }

        public boolean hasRotations() {
            return !facingPredicate.equals(BlockStateUtils.NO_ROTATION);
        }

        public boolean hasActiveTexture() {
            return activable;
        }
    }

    public static class GeneratorBlockStateMapperAdd extends StateMapperBase {

        @Nonnull
        @Override
        protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
            BlockEcoGeneratorAdd block = (BlockEcoGeneratorAdd) state.getBlock();
            EcoGeneratorTypeAdd type = state.getValue(block.getTypeProperty());
            StringBuilder builder = new StringBuilder();
            String nameOverride = null;

            if (type.hasActiveTexture()) {
                builder.append(activeProperty.getName());
                builder.append("=");
                builder.append(state.getValue(activeProperty));
            }

            if (type.hasRotations()) {
                EnumFacing facing = state.getValue(BlockStateFacing.facingProperty);
                if (!type.canRotateTo(facing)) {
                    facing = EnumFacing.NORTH;
                }
                if (builder.length() > 0) {
                    builder.append(",");
                }
                builder.append(BlockStateFacing.facingProperty.getName());
                builder.append("=");
                builder.append(facing.getName());
            }

            if (builder.length() == 0) {
                builder.append("normal");
            }
            ResourceLocation baseLocation = new ResourceLocation(Constants.MOD_ID, nameOverride != null ? nameOverride : type.getName());

            return new ModelResourceLocation(baseLocation, builder.toString());
        }
    }
}