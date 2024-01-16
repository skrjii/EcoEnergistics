package aeternal.ecoenergistics.common.recipes;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.enums.Ingot;
import aeternal.ecoenergistics.common.enums.MoreDust;
import aeternal.ecoenergistics.common.item.EcoEnergisticsItems;
import mekanism.common.MekanismItems;
import mekanism.common.Resource;
import mekanism.common.recipe.RecipeHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Enrichment {
    public static void InitCustomEnrichmentRecipes() {
        if (Constants.ENRICHMENT_ENABLED) {
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.LAPIS.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 0));
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.EMERALD.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 1));
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.ACTIVATEDGLOWSTONE.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 2));
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(MekanismItems.Dust,1, Resource.GOLD.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 3));
        }


    }

}
