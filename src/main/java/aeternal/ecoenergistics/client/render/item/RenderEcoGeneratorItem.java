package aeternal.ecoenergistics.client.render.item;

import java.util.EnumMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import aeternal.ecoenergistics.client.render.item.panel.*;
import aeternal.ecoenergistics.client.render.item.station.*;

import mekanism.client.render.item.ItemLayerWrapper;
import mekanism.client.render.item.SubTypeItemRenderer;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoGeneratorAdd.EcoGeneratorTypeAdd;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoGenerator.EcoGeneratorType;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEcoGeneratorItem extends SubTypeItemRenderer<EcoGeneratorType> {

    public static Map<EcoGeneratorType, ItemLayerWrapper> modelMap = new EnumMap<>(EcoGeneratorType.class);

    @Override
    protected boolean earlyExit() {
        return true;
    }

    @Override
    protected void renderBlockSpecific(@Nonnull ItemStack stack, TransformType transformType) {
        EcoGeneratorType generatorType = EcoGeneratorType.get(stack);
        if (generatorType != null) {
            switch (generatorType) {
                case SOLAR_PANEL_ADVANCED:
                    RenderSolarPanelAdvItem.renderStack(stack, transformType);
                    break;
                    case SOLAR_PANEL_HYBRID:
                    RenderSolarPanelHybridItem.renderStack(stack, transformType);
                    break;
                case SOLAR_PANEL_PERFECTHYBRID:
                    RenderSolarPanelPerfectHybridItem.renderStack(stack, transformType);
                    break;
                case SOLAR_PANEL_QUANTUM:
                    RenderSolarPanelQuantumItem.renderStack(stack, transformType);
                    break;
                case SOLAR_PANEL_SPECTRAL:
                    RenderSolarPanelSpectralItem.renderStack(stack, transformType);
                    break;
                case SOLAR_PANEL_PROTONIC:
                    RenderSolarPanelProtonicItem.renderStack(stack, transformType);
                    break;
                case SOLAR_PANEL_SINGULAR:
                    RenderSolarPanelSingularItem.renderStack(stack, transformType);
                    break;
                case SOLAR_PANEL_DIFFRACTIVE:
                    RenderSolarPanelDiffractiveItem.renderStack(stack, transformType);
                    break;
                case SOLAR_PANEL_PHOTONIC:
                    RenderSolarPanelPhotonicItem.renderStack(stack, transformType);
                    break;
                case SOLAR_PANEL_NEUTRON:
                    RenderSolarPanelNeutronItem.renderStack(stack, transformType);
                    break;


            }
        }

    }


    @Override
    protected void renderItemSpecific(@Nonnull ItemStack stack, TransformType transformType) {

    }

    @Nullable
    @Override
    protected ItemLayerWrapper getModel(EcoGeneratorType generatorType) {
        return modelMap.get(generatorType);
    }

    @Nullable
    @Override
    protected EcoGeneratorType getType(@Nonnull ItemStack stack) {
        return EcoGeneratorType.get(stack);
    }
}