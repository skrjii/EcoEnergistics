package aeternal.ecoenergistics.integration.avaritia.common.block.states;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.integration.avaritia.common.block.BlockIntegratedAvaritiaGenerator;
import aeternal.ecoenergistics.integration.avaritia.common.tile.solar.panel.TileEntitySolarPanelCrystal;
import aeternal.ecoenergistics.integration.avaritia.common.tile.solar.panel.TileEntitySolarPanelInfinity;
import aeternal.ecoenergistics.integration.avaritia.common.tile.solar.panel.TileEntitySolarPanelNeutronium;
import aeternal.ecoenergistics.integration.avaritia.common.tile.solar.station.TileEntitySolarStationCrystal;
import aeternal.ecoenergistics.integration.avaritia.common.tile.solar.station.TileEntitySolarStationInfinity;
import aeternal.ecoenergistics.integration.avaritia.common.tile.solar.station.TileEntitySolarStationNeutronium;
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

public class BlockStateIntegratedAVAGenerator extends ExtendedBlockState {

    public static final PropertyBool activeProperty = PropertyBool.create("active");

    public BlockStateIntegratedAVAGenerator(BlockIntegratedAvaritiaGenerator block, PropertyEnum<?> typeProperty) {
        super(block, new IProperty[]{BlockStateFacing.facingProperty, typeProperty, activeProperty}, new IUnlistedProperty[]{});
    }

    public enum AvaritiaGeneratorBlock {
        GENERATOR_BLOCK_AVARITIA;

        PropertyEnum<AvaritiaGeneratorType> generatorTypeProperty;

        public PropertyEnum<AvaritiaGeneratorType> getProperty() {
            if (generatorTypeProperty == null) {
                generatorTypeProperty = PropertyEnum.create("type", AvaritiaGeneratorType.class, input -> input != null && input.blockType == this);
            }
            return generatorTypeProperty;
        }

        public Block getBlock() {
            if (this == AvaritiaGeneratorBlock.GENERATOR_BLOCK_AVARITIA) {
                return EcoEnergisticsBlocks.EcoGenerator;
            }
            return null;
        }
    }

    public enum AvaritiaGeneratorType implements IStringSerializable, IBlockType {
        SOLAR_PANEL_CRYSTAL(AvaritiaGeneratorBlock.GENERATOR_BLOCK_AVARITIA, 0, "SolarPanelCrystal", 1, 5320000, TileEntitySolarPanelCrystal::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_NEUTRON(AvaritiaGeneratorBlock.GENERATOR_BLOCK_AVARITIA, 1, "SolarPanelNeutronium", 1, 21280000, TileEntitySolarPanelNeutronium::new, true, Plane.HORIZONTAL, false),
        SOLAR_PANEL_INFINITY(AvaritiaGeneratorBlock.GENERATOR_BLOCK_AVARITIA, 2, "SolarPanelInfinity", 1, 339360000, TileEntitySolarPanelInfinity::new, true, Plane.HORIZONTAL, false),

        SOLAR_STATION_CRYSTAL(AvaritiaGeneratorBlock.GENERATOR_BLOCK_AVARITIA, 3, "SolarStationCrystal", 1, 339360000,TileEntitySolarStationCrystal::new, true,Plane.HORIZONTAL, false),
        SOLAR_STATION_NEUTRON(AvaritiaGeneratorBlock.GENERATOR_BLOCK_AVARITIA, 4, "SolarStationNeutronium", 1, 339360000,TileEntitySolarStationNeutronium::new, true,Plane.HORIZONTAL, false),
        SOLAR_STATION_INFINITY(AvaritiaGeneratorBlock.GENERATOR_BLOCK_AVARITIA, 5, "SolarStationInfinity", 1, 339360000,TileEntitySolarStationInfinity::new, true,Plane.HORIZONTAL, false);

        public AvaritiaGeneratorBlock blockType;
        public int meta;
        public String blockName;
        public int guiId;
        public double maxEnergy;
        public Supplier<TileEntity> tileEntitySupplier;
        public boolean hasModel;
        public Predicate<EnumFacing> facingPredicate;
        public boolean activable;
        public boolean hasRedstoneOutput;

        AvaritiaGeneratorType(AvaritiaGeneratorBlock block, int m, String name, int gui, double energy, Supplier<TileEntity> tileClass, boolean model, Predicate<EnumFacing> predicate,
                         boolean hasActiveTexture) {
            this(block, m, name, gui, energy, tileClass, model, predicate, hasActiveTexture, false);
        }

        AvaritiaGeneratorType(AvaritiaGeneratorBlock block, int m, String name, int gui, double energy, Supplier<TileEntity> tileClass, boolean model, Predicate<EnumFacing> predicate,
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

        public static AvaritiaGeneratorType get(IBlockState state) {
            if (state.getBlock() instanceof BlockIntegratedAvaritiaGenerator) {
                return state.getValue(((BlockIntegratedAvaritiaGenerator) state.getBlock()).getTypeProperty());
            }
            return null;
        }

        public static AvaritiaGeneratorType get(Block block, int meta) {
            if (block instanceof BlockIntegratedAvaritiaGenerator) {
                return get(((BlockIntegratedAvaritiaGenerator) block).getGeneratorBlock(), meta);
            }
            return null;
        }

        public static AvaritiaGeneratorType get(AvaritiaGeneratorBlock block, int meta) {
            for (AvaritiaGeneratorType type : values()) {
                if (type.meta == meta && type.blockType == block) {
                    return type;
                }
            }
            return null;
        }

        public static AvaritiaGeneratorType get(ItemStack stack) {
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
            return new ItemStack(EcoEnergisticsBlocks.EcoGenerator, 1, meta);
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
            BlockIntegratedAvaritiaGenerator block = (BlockIntegratedAvaritiaGenerator) state.getBlock();
            AvaritiaGeneratorType type = state.getValue(block.getTypeProperty());
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