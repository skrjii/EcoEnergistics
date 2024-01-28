package aeternal.ecoenergistics.integration.avaritia.common.item;

import aeternal.ecoenergistics.Constants;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Constants.MOD_ID)
public class AvaritiaModuleItems {

    public static final Item AlloyAvaritia = new ItemAlloyAvaritia();
    public static final Item DustAvaritia = new ItemDustAvaritia();
    public static final Item CompressedAvaritia = new ItemCompressedAvaritia();
    public static final Item SolarCellAvaritia = new ItemSolarCellsAvaritia();
    public static final Item ControlCircuitAvaritia = new ItemControlCircuitAvaritia();

    public static void registerItems(IForgeRegistry<Item> registry) {
        if (Constants.AvaritiaLoaded && Constants.AvaritiaConfirm) {
            registry.register(init(ControlCircuitAvaritia, "ControlCircuitAvaritia"));
            registry.register(init(AlloyAvaritia, "AlloyAvaritia"));
            registry.register(init(DustAvaritia, "DustAvaritia"));
            registry.register(init(CompressedAvaritia, "CompressedAvaritia"));
            registry.register(init(SolarCellAvaritia, "SolarCellAvaritia"));
        }
    }

    public static Item init(Item item, String name) {
        return item.setTranslationKey(name).setRegistryName(new ResourceLocation(Constants.MOD_ID, name));
    }
}