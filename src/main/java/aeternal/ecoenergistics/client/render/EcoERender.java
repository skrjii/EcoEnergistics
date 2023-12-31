package aeternal.ecoenergistics.client.render;

import aeternal.ecoenergistics.common.item.IMetaItem;
import mekanism.client.render.tileentity.RenderConfigurableMachine;
import mekanism.common.base.ISideConfiguration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EcoERender {

    public static void init() {
        MinecraftForge.EVENT_BUS.register(new EcoERender());
    }


    public static void registerItemRender(String domain, Item item) {
        if (item instanceof IMetaItem) {
            IMetaItem metaItem = (IMetaItem) item;
            for (int i = 0; i < metaItem.getVariants(); i++) {
                if (metaItem.getTexture(i) == null) {
                    continue;
                }

                ModelResourceLocation loc = new ModelResourceLocation(new ResourceLocation(domain, metaItem.getTexture(i)), "inventory");
                ModelLoader.setCustomModelResourceLocation(item, i, loc);
                ModelBakery.registerItemVariants(item, new ResourceLocation(domain, metaItem.getTexture(i)));
            }
            return;
        }
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void bindTexture(ResourceLocation texture) {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
    }


}