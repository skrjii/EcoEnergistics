package aeternal.ecoenergistics.integration.avaritia.common.recipes;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.integration.avaritia.common.enums.AvaritiaTiers;
import aeternal.ecoenergistics.integration.avaritia.common.item.AvaritiaModuleItems;
import mekanism.common.recipe.RecipeHandler;
import net.minecraft.item.ItemStack;

public class EnrichmentAvaritiaModule {
    public static void InitAvaritiaEnrichmentRecipes() {
        if (Constants.ENRICHMENT_ENABLED && Constants.AvaritiaLoaded && Constants.AvaritiaConfirm) {


            ItemStack dustCrystal = new ItemStack(AvaritiaModuleItems.DustAvaritia,1, AvaritiaTiers.CRYSTALMATRIX.ordinal());
            ItemStack dustNeutronium = new ItemStack(AvaritiaModuleItems.DustAvaritia,1, AvaritiaTiers.NEUTRONIUM.ordinal());
            ItemStack dustInfinity = new ItemStack(AvaritiaModuleItems.DustAvaritia,1, AvaritiaTiers.INFINITY.ordinal());

            ItemStack compressedCrystal = new ItemStack(AvaritiaModuleItems.CompressedAvaritia,1, AvaritiaTiers.CRYSTALMATRIX.ordinal());
            ItemStack compressedNeutronium = new ItemStack(AvaritiaModuleItems.CompressedAvaritia,1, AvaritiaTiers.NEUTRONIUM.ordinal());
            ItemStack compressedInfinity = new ItemStack(AvaritiaModuleItems.CompressedAvaritia,1, AvaritiaTiers.INFINITY.ordinal());


            RecipeHandler.addEnrichmentChamberRecipe(dustCrystal,compressedCrystal);
            RecipeHandler.addEnrichmentChamberRecipe(dustNeutronium,compressedNeutronium);
            RecipeHandler.addEnrichmentChamberRecipe(dustInfinity,compressedInfinity);



        }


    }

}
