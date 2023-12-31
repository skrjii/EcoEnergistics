package aeternal.ecoenergistics.client.render.item;

import aeternal.ecoenergistics.client.render.item.panel.*;
import aeternal.ecoenergistics.client.render.item.station.*;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoGenerator.EcoGeneratorType;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd;
import mekanism.client.render.item.ItemLayerWrapper;
import mekanism.client.render.item.SubTypeItemRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.EnumMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderEcoGeneratorItemAdd extends SubTypeItemRenderer<EcoGeneratorTypeAdd> {

    public static Map<EcoGeneratorTypeAdd, ItemLayerWrapper> modelMap = new EnumMap<>(EcoGeneratorTypeAdd.class);

    @Override
    protected boolean earlyExit() {
        return true;
    }

    @Override
    protected void renderBlockSpecific(@Nonnull ItemStack stack, TransformType transformType) {
        EcoGeneratorTypeAdd generatorType = EcoGeneratorTypeAdd.get(stack);
        if (generatorType != null) {
            switch (generatorType) {

                case SOLAR_STATION_ADVANCED:
                    RenderSolarStationAdvItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_HYBRID:
                    RenderSolarStationHybridItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_PERFECTHYBRID:
                    RenderSolarStationPerfectHybridItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_QUANTUM:
                    RenderSolarStationQuantumItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_SPECTRAL:
                    RenderSolarStationSpectralItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_PROTONIC:
                    RenderSolarStationProtonicItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_SINGULAR:
                    RenderSolarStationSingularItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_DIFFRACTIVE:
                    RenderSolarStationDiffractiveItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_PHOTONIC:
                    RenderSolarStationPhotonicItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_NEUTRON:
                    RenderSolarStationNeutronItem.renderStack(stack, transformType);
                    break;
            }
        }
    }


    @Override
    protected void renderItemSpecific(@Nonnull ItemStack stack, TransformType transformType) {

    }

    @Nullable
    @Override
    protected ItemLayerWrapper getModel(EcoGeneratorTypeAdd generatorType) {
        return modelMap.get(generatorType);
    }

    @Nullable
    @Override
    protected EcoGeneratorTypeAdd getType(@Nonnull ItemStack stack) {
        return EcoGeneratorTypeAdd.get(stack);
    }
}