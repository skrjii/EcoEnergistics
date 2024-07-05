package aeternal.ecoenergistics.common.block.states;

import aeternal.ecoenergistics.common.EcoEnergistics;
import aeternal.ecoenergistics.common.block.BlockEcoTransmitter;
import aeternal.ecoenergistics.common.tier.MEETiers;
import mekanism.api.transmitters.TransmissionType;
import mekanism.common.block.property.PropertyColor;
import mekanism.common.block.property.PropertyConnection;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

import javax.annotation.Nonnull;
import java.util.Locale;

public class BlockStateEcoTransmitter extends ExtendedBlockState {

    public static final PropertyEnum<EcoTransmitterType> typeProperty = PropertyEnum.create("type", EcoTransmitterType.class);
    public static final PropertyEnum<MEETiers> tierProperty = PropertyEnum.create("tier", MEETiers.class);

    public BlockStateEcoTransmitter(BlockEcoTransmitter block) {
        super(block, new IProperty[]{typeProperty, tierProperty}, new IUnlistedProperty[]{OBJModel.OBJProperty.INSTANCE, PropertyColor.INSTANCE, PropertyConnection.INSTANCE});
    }

    public enum EcoTransmitterType implements IStringSerializable {
        UNIVERSAL_CABLE("UniversalCable", Size.SMALL, TransmissionType.ENERGY, false, true),
        MECHANICAL_PIPE("MechanicalPipe", Size.LARGE, TransmissionType.FLUID, false, true),
        PRESSURIZED_TUBE("PressurizedTube", Size.SMALL, TransmissionType.GAS, false, true);

        private String unlocalizedName;
        private Size size;
        private TransmissionType transmissionType;
        private boolean transparencyRender;
        private boolean tiers;

        EcoTransmitterType(String name, Size s, TransmissionType type, boolean transparency, boolean b) {
            unlocalizedName = name;
            size = s;
            transmissionType = type;
            transparencyRender = transparency;
            tiers = b;
        }
        public static EcoTransmitterType get(int meta) {
            return EcoTransmitterType.values()[meta];
        }

        @Override
        public String getName() {
            return name().toLowerCase(Locale.ROOT);
        }

        public String getTranslationKey() {
            return unlocalizedName;
        }

        public Size getSize() {
            return size;
        }

        public boolean hasTransparency() {
            return transparencyRender;
        }

        public TransmissionType getTransmission() {
            return transmissionType;
        }

        public boolean hasTiers() {
            return tiers;
        }

        public enum Size {
            SMALL(6),
            LARGE(8);

            public int centerSize;

            Size(int size) {
                centerSize = size;
            }
        }
    }

    public static class TransmitterStateMapper extends StateMapperBase {

        @Nonnull
        @Override
        protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
            BlockEcoTransmitter block = (BlockEcoTransmitter) state.getBlock();
            EcoTransmitterType type = state.getValue(typeProperty);
            StringBuilder builder = new StringBuilder();
            String nameOverride = null;

            if (type.tiers) {
                MEETiers tier = state.getValue(tierProperty);
                nameOverride = type.getName() + "_" + tier.getName();
            }
            if (builder.length() == 0) {
                builder.append("normal");
            }
            ResourceLocation baseLocation = new ResourceLocation(EcoEnergistics.MOD_ID, nameOverride != null ? nameOverride : type.getName());
            return new ModelResourceLocation(baseLocation, builder.toString());
        }
    }

}

