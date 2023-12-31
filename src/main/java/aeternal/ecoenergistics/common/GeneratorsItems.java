package aeternal.ecoenergistics.common;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.item.ItemMEE;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Constants.MOD_ID)
public class GeneratorsItems {
    public static Item init(Item item, String name) {
        return item.setTranslationKey(name).setRegistryName(new ResourceLocation(Constants.MOD_ID, name));
    }
}