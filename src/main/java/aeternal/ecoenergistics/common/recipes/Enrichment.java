package aeternal.ecoenergistics.common.recipes;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
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
            ItemStack titaniumOre = new ItemStack(EcoEnergisticsBlocks.OreBlock,1,0);
            ItemStack uraniummOre = new ItemStack(EcoEnergisticsBlocks.OreBlock,1,1);
            ItemStack iridiumOre = new ItemStack(EcoEnergisticsBlocks.OreBlock,1,2);

            ItemStack titaniumClump = new ItemStack(EcoEnergisticsItems.MoreClump,1,0);
            ItemStack uraniumClump = new ItemStack(EcoEnergisticsItems.MoreClump,1,1);
            ItemStack iridiumClump = new ItemStack(EcoEnergisticsItems.MoreClump,1,2);

            ItemStack titaniumDirty = new ItemStack(EcoEnergisticsItems.MoreDirtyDust,1,0);
            ItemStack uraniumDirty = new ItemStack(EcoEnergisticsItems.MoreDirtyDust,1,1);
            ItemStack iridiumDirty = new ItemStack(EcoEnergisticsItems.MoreDirtyDust,1,2);

            ItemStack titaniumCompressed = new ItemStack(EcoEnergisticsItems.MoreCompressed,1,4);
            ItemStack uraniumCompressed = new ItemStack(EcoEnergisticsItems.MoreCompressed,1,5);
            ItemStack iridiumCompressed = new ItemStack(EcoEnergisticsItems.MoreCompressed,1,6);

            ItemStack titaniumDust = new ItemStack(EcoEnergisticsItems.Dust,1,0);
            ItemStack titaniumDust2 = titaniumDust.copy();
            titaniumDust2.setCount(titaniumDust2.getCount() *2);
            ItemStack uraniumDust = new ItemStack(EcoEnergisticsItems.Dust,1,1);
            ItemStack uraniumDust2 = uraniumDust.copy();
            uraniumDust2.setCount(uraniumDust2.getCount() *2);
            ItemStack iridiumDust = new ItemStack(EcoEnergisticsItems.Dust,1,2);
            ItemStack iridiumDust2 = iridiumDust.copy();
            iridiumDust2.setCount(iridiumDust2.getCount() *2);

            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.LAPIS.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 0));
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.EMERALD.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 1));
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.ACTIVATEDGLOWSTONE.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 2));
            RecipeHandler.addEnrichmentChamberRecipe(new ItemStack(MekanismItems.Dust,1, Resource.GOLD.ordinal()), new ItemStack(EcoEnergisticsItems.MoreCompressed, 1, 3));


            RecipeHandler.addEnrichmentChamberRecipe(titaniumOre,titaniumDust2);
            RecipeHandler.addEnrichmentChamberRecipe(uraniummOre,uraniumDust2);
            RecipeHandler.addEnrichmentChamberRecipe(iridiumOre,iridiumDust2);

            RecipeHandler.addEnrichmentChamberRecipe(titaniumDirty,titaniumDust);
            RecipeHandler.addEnrichmentChamberRecipe(uraniumDirty,uraniumDust);
            RecipeHandler.addEnrichmentChamberRecipe(iridiumDirty,iridiumDust);

            RecipeHandler.addEnrichmentChamberRecipe(titaniumDust,titaniumCompressed);
            RecipeHandler.addEnrichmentChamberRecipe(uraniumDust,uraniumCompressed);
            RecipeHandler.addEnrichmentChamberRecipe(iridiumDust,iridiumCompressed);

        }


    }

}
