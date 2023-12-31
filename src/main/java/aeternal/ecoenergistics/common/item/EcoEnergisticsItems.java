package aeternal.ecoenergistics.common.item;

import aeternal.ecoenergistics.Constants;
import mekanism.common.item.ItemEnergized;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Constants.MOD_ID)
public class EcoEnergisticsItems {

    public static final Item MoreAlloy = new ItemMoreAlloy();
    public static final Item MoreControlCircuit = new ItemMoreControlCircuit();
    public static final Item MoreSolarCell = new ItemMoreSolarCells();
    public static final ItemEnergized EnergyTabletAdvanced = new ItemEnergized(2000000);
    public static final ItemEnergized EnergyTabletHybrid = new ItemEnergized(4000000);
    public static final ItemEnergized EnergyTabletPerfectHybrid = new ItemEnergized(16000000);
    public static final ItemEnergized EnergyTabletQuantum = new ItemEnergized(32000000);
    public static final ItemEnergized EnergyTabletSpectral = new ItemEnergized(64000000);
    public static final ItemEnergized EnergyTabletProtonic = new ItemEnergized(128000000);
    public static final ItemEnergized EnergyTabletSingular = new ItemEnergized(256000000);
    public static final ItemEnergized EnergyTabletDiffractive = new ItemEnergized(512000000);
    public static final ItemEnergized EnergyTabletPhotonic = new ItemEnergized(1024000000);
    public static final ItemEnergized EnergyTabletNeutron = new ItemEnergized(2048000000);
    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.register(init(MoreControlCircuit, "MoreControlCircuit"));
        registry.register(init(MoreAlloy, "MoreAlloy"));
        registry.register(init(MoreSolarCell, "MoreSolarCell"));
        registry.register(init(EnergyTabletAdvanced, "EnergyTabletAdvanced"));
        registry.register(init(EnergyTabletHybrid, "EnergyTabletHybrid"));
        registry.register(init(EnergyTabletPerfectHybrid, "EnergyTabletPerfectHybrid"));
        registry.register(init(EnergyTabletQuantum, "EnergyTabletQuantum"));
        registry.register(init(EnergyTabletSpectral, "EnergyTabletSpectral"));
        registry.register(init(EnergyTabletProtonic, "EnergyTabletProtonic"));
        registry.register(init(EnergyTabletSingular, "EnergyTabletSingular"));
        registry.register(init(EnergyTabletDiffractive, "EnergyTabletDiffractive"));
        registry.register(init(EnergyTabletPhotonic, "EnergyTabletPhotonic"));
        registry.register(init(EnergyTabletNeutron, "EnergyTabletNeutron"));
    }

    public static Item init(Item item, String name) {
        return item.setTranslationKey(name).setRegistryName(new ResourceLocation(Constants.MOD_ID, name));
    }
}