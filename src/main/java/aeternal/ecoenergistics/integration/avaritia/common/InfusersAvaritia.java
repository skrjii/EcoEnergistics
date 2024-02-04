package aeternal.ecoenergistics.integration.avaritia.common;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.integration.avaritia.common.enums.AvaritiaTiers;
import aeternal.ecoenergistics.integration.avaritia.common.item.AvaritiaModuleItems;
import mekanism.api.infuse.InfuseObject;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.infuse.InfuseType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class InfusersAvaritia {

    public static InfuseType crystal;
    public static InfuseType neutronium;
    public static InfuseType infinity;


    public static void registerAvaritiaInfuseType() {
        if (Constants.AvaritiaLoaded && Constants.AvaritiaConfirm) {
            crystal = new InfuseType("CRYSTAL", new ResourceLocation(Constants.MOD_ID, "blocks/infuse/InfuseCrystal")).setTranslationKey("crystal");
            InfuseRegistry.registerInfuseType(crystal);
            neutronium = new InfuseType("NEUTRONIUM", new ResourceLocation(Constants.MOD_ID, "blocks/infuse/InfuseNeutronium")).setTranslationKey("neutronium");
            InfuseRegistry.registerInfuseType(neutronium);
            infinity = new InfuseType("INFINITY", new ResourceLocation(Constants.MOD_ID, "blocks/infuse/InfuseInfinity")).setTranslationKey("infinity");
            InfuseRegistry.registerInfuseType(infinity);
        }

    }
    public static void registerAvaritiaInfuseObject() {
        if (Constants.AvaritiaLoaded && Constants.AvaritiaConfirm) {
            InfuseType crystal = InfuseRegistry.get("CRYSTAL");
            InfuseType neutronium = InfuseRegistry.get("NEUTRONIUM");
            InfuseType infinity = InfuseRegistry.get("INFINITY");

            if (crystal != null) {
                ItemStack crystalDust = new ItemStack(AvaritiaModuleItems.DustAvaritia, 1, 0);
                ItemStack crystalCompressed = new ItemStack(AvaritiaModuleItems.CompressedAvaritia, 1, AvaritiaTiers.CRYSTALMATRIX.ordinal());
                InfuseRegistry.registerInfuseObject(crystalDust, new InfuseObject(crystal, 10));
                InfuseRegistry.registerInfuseObject(crystalCompressed, new InfuseObject(crystal, 80));
            }
            if (neutronium != null) {
                ItemStack neutroniumDust = new ItemStack(AvaritiaModuleItems.DustAvaritia, 1, 1);
                ItemStack neutroniumCompressed = new ItemStack(AvaritiaModuleItems.CompressedAvaritia, 1, 1);
                InfuseRegistry.registerInfuseObject(neutroniumDust, new InfuseObject(neutronium, 10));
                InfuseRegistry.registerInfuseObject(neutroniumCompressed, new InfuseObject(neutronium, 80));
            }
            if (infinity != null) {
                ItemStack infinityDust = new ItemStack(AvaritiaModuleItems.DustAvaritia, 1, 2);
                ItemStack infinityCompressed = new ItemStack(AvaritiaModuleItems.CompressedAvaritia, 1, 2);
                InfuseRegistry.registerInfuseObject(infinityDust, new InfuseObject(infinity, 10));
                InfuseRegistry.registerInfuseObject(infinityCompressed, new InfuseObject(infinity, 80));
            }
        }

    }

}

