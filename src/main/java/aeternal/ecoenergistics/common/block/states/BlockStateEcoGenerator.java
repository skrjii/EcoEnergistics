package aeternal.ecoenergistics.common.block.states;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.EcoGeneratorsBlocks;
import aeternal.ecoenergistics.common.block.BlockEcoGenerator;
import aeternal.ecoenergistics.common.tile.solar.panel.*;
import mekanism.common.base.IBlockType;
import mekanism.common.block.states.BlockStateFacing;
import mekanism.common.block.states.BlockStateUtils;
import mekanism.common.util.LangUtils;
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

import javax.annotation.Nonnull;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BlockStateEcoGenerator extends ExtendedBlockState {

    public static final PropertyBool activeProperty = PropertyBool.create("active");

    public BlockStateEcoGenerator(BlockEcoGenerator block, PropertyEnum<?> typeProperty) {
        super(block, new IProperty[]{BlockStateFacing.facingProperty, typeProperty, activeProperty}, new IUnlistedProperty[]{});
    }

    public enum EcoGeneratorBlock {
        GENERATOR_BLOCK_ECO;

        PropertyEnum<EcoGeneratorType> generatorTypeProperty;

        public PropertyEnum<EcoGeneratorType> getProperty() {
            if (generatorTypeProperty == null) {
                generatorTypeProperty = PropertyEnum.create("type", EcoGeneratorType.class, input -> input != null && input.blockType == this);
            }
            return generatorTypeProperty;
        }

        public Block getBlock() {
            if (this == EcoGeneratorBlock.GENERATOR_BLOCK_ECO) {
                return EcoGeneratorsBlocks.EcoGenerator;
            }
            return null;
        }
    }

    public enum EcoGeneratorType implements IStringSerializable, IBlockType {
        SOLAR_PANEL_ADVANCED(EcoGeneratorBlock.GENERATOR_BLOCK_ECO, 0, "SolarPanelAdvanced", 1, 192000, TileEntitySolarPanelAdvanced::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_HYBRID(EcoGeneratorBlock.GENERATOR_BLOCK_ECO, 1, "SolarPanelHybrid", 1, 384000, TileEntitySolarPanelHybrid::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_PERFECTHYBRID(EcoGeneratorBlock.GENERATOR_BLOCK_ECO, 2, "SolarPanelPerfectHybrid", 1, 768000, TileEntitySolarPanelPerfectHybrid::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_QUANTUM(EcoGeneratorBlock.GENERATOR_BLOCK_ECO, 3, "SolarPanelQuantum", 1, 1536000, TileEntitySolarPanelQuantum::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_SPECTRAL(EcoGeneratorBlock.GENERATOR_BLOCK_ECO, 4, "SolarPanelSpectral", 1, 3072000, TileEntitySolarPanelSpectral::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_PROTONIC(EcoGeneratorBlock.GENERATOR_BLOCK_ECO, 5, "SolarPanelProtonic", 1, 6144000, TileEntitySolarPanelProtonic::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_SINGULAR(EcoGeneratorBlock.GENERATOR_BLOCK_ECO, 6, "SolarPanelSingular", 1, 12288000, TileEntitySolarPanelSingular::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_DIFFRACTIVE(EcoGeneratorBlock.GENERATOR_BLOCK_ECO, 7, "SolarPanelDiffractive", 1, 24576000, TileEntitySolarPanelDiffractive::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_PHOTONIC(EcoGeneratorBlock.GENERATOR_BLOCK_ECO, 8, "SolarPanelPhotonic", 1, 49152000, TileEntitySolarPanelPhotonic::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_NEUTRON(EcoGeneratorBlock.GENERATOR_BLOCK_ECO, 9, "SolarPanelNeutron", 1, 58982000, TileEntitySolarPanelNeutron::new, true, Plane.HORIZONTAL, false);


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

        EcoGeneratorType(EcoGeneratorBlock block, int m, String name, int gui, double energy, Supplier<TileEntity> tileClass, boolean model, Predicate<EnumFacing> predicate,
                      boolean hasActiveTexture) {
            this(block, m, name, gui, energy, tileClass, model, predicate, hasActiveTexture, false);
        }

        EcoGeneratorType(EcoGeneratorBlock block, int m, String name, int gui, double energy, Supplier<TileEntity> tileClass, boolean model, Predicate<EnumFacing> predicate,
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

        public static EcoGeneratorType get(IBlockState state) {
            if (state.getBlock() instanceof BlockEcoGenerator) {
                return state.getValue(((BlockEcoGenerator) state.getBlock()).getTypeProperty());
            }
            return null;
        }

        public static EcoGeneratorType get(Block block, int meta) {
            if (block instanceof BlockEcoGenerator) {
                return get(((BlockEcoGenerator) block).getGeneratorBlock(), meta);
            }
            return null;
        }

        public static EcoGeneratorType get(EcoGeneratorBlock block, int meta) {
            for (EcoGeneratorType type : values()) {
                if (type.meta == meta && type.blockType == block) {
                    return type;
                }
            }
            return null;
        }

        public static EcoGeneratorType get(ItemStack stack) {
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
            return new ItemStack(EcoGeneratorsBlocks.EcoGenerator, 1, meta);
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

    public static class GeneratorBlockStateMapper extends StateMapperBase {

        @Nonnull
        @Override
        protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
            BlockEcoGenerator block = (BlockEcoGenerator) state.getBlock();
            EcoGeneratorType type = state.getValue(block.getTypeProperty());
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