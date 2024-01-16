package aeternal.ecoenergistics.common.recipes;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.common.item.EcoEnergisticsItems;
import mekanism.common.MekanismFluids;
import mekanism.common.recipe.RecipeHandler;
import net.minecraft.item.ItemStack;

public class Injection {
    public static void InitCustomInjectionRecipes() {
        if (Constants.INJECTION_ENABLED) {
            ItemStack titaniumOre = new ItemStack(EcoEnergisticsBlocks.OreBlock,1,0);
            ItemStack uraniummOre = new ItemStack(EcoEnergisticsBlocks.OreBlock,1,1);
            ItemStack iridiumOre = new ItemStack(EcoEnergisticsBlocks.OreBlock,1,2);

            ItemStack titaniumShard = new ItemStack(EcoEnergisticsItems.MoreShard,1,0);
            titaniumShard.setCount(titaniumShard.getCount() *4);
            ItemStack uraniumShard = new ItemStack(EcoEnergisticsItems.MoreShard,1,1);
            uraniumShard.setCount(uraniumShard.getCount() *4);
            ItemStack iridiumShard = new ItemStack(EcoEnergisticsItems.MoreShard,1,2);
            iridiumShard.setCount(iridiumShard.getCount() *4);

            RecipeHandler.addChemicalInjectionChamberRecipe(titaniumOre, MekanismFluids.HydrogenChloride,titaniumShard);
            RecipeHandler.addChemicalInjectionChamberRecipe(uraniummOre, MekanismFluids.HydrogenChloride,uraniumShard);
            RecipeHandler.addChemicalInjectionChamberRecipe(iridiumOre, MekanismFluids.HydrogenChloride,iridiumShard);
        }


    }

}
