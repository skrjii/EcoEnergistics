package aeternal.ecoenergistics.integration.avaritia.client.render;

import java.util.EnumMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import aeternal.ecoenergistics.integration.avaritia.client.render.item.panel.RenderSolarPanelCrystalItem;
import aeternal.ecoenergistics.integration.avaritia.client.render.item.panel.RenderSolarPanelInfinityItem;
import aeternal.ecoenergistics.integration.avaritia.client.render.item.panel.RenderSolarPanelNeutroniumItem;
import aeternal.ecoenergistics.integration.avaritia.client.render.item.station.RenderSolarStationCrystalItem;
import aeternal.ecoenergistics.integration.avaritia.client.render.item.station.RenderSolarStationInfinityItem;
import aeternal.ecoenergistics.integration.avaritia.client.render.item.station.RenderSolarStationNeutroniumItem;
import aeternal.ecoenergistics.integration.avaritia.common.block.states.BlockStateIntegratedAVAGenerator.AvaritiaGeneratorType;
import mekanism.client.render.item.ItemLayerWrapper;
import mekanism.client.render.item.SubTypeItemRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAvaritiaGeneratorItem extends SubTypeItemRenderer<AvaritiaGeneratorType> {

    public static Map<AvaritiaGeneratorType, ItemLayerWrapper> modelMap = new EnumMap<>(AvaritiaGeneratorType.class);

    @Override
    protected boolean earlyExit() {
        return true;
    }

    @Override
    protected void renderBlockSpecific(@Nonnull ItemStack stack, TransformType transformType) {
        AvaritiaGeneratorType generatorType = AvaritiaGeneratorType.get(stack);
        if (generatorType != null) {
            switch (generatorType) {
                case SOLAR_PANEL_CRYSTAL:
                    RenderSolarPanelCrystalItem.renderStack(stack, transformType);
                    break;
                case SOLAR_PANEL_NEUTRON:
                    RenderSolarPanelNeutroniumItem.renderStack(stack, transformType);
                    break;
                case SOLAR_PANEL_INFINITY:
                    RenderSolarPanelInfinityItem.renderStack(stack, transformType);
                    break;

                case SOLAR_STATION_CRYSTAL:
                    RenderSolarStationCrystalItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_NEUTRON:
                    RenderSolarStationNeutroniumItem.renderStack(stack, transformType);
                    break;
                case SOLAR_STATION_INFINITY:
                    RenderSolarStationInfinityItem.renderStack(stack, transformType);
                    break;
            }
        }

    }


    @Override
    protected void renderItemSpecific(@Nonnull ItemStack stack, TransformType transformType) {

    }

    @Nullable
    @Override
    protected ItemLayerWrapper getModel(AvaritiaGeneratorType generatorType) {
        return modelMap.get(generatorType);
    }

    @Nullable
    @Override
    protected AvaritiaGeneratorType getType(@Nonnull ItemStack stack) {
        return AvaritiaGeneratorType.get(stack);
    }
}