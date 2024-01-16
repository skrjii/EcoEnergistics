package aeternal.ecoenergistics.common.recipes;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.enums.Ingot;
import aeternal.ecoenergistics.common.enums.MoreDust;
import aeternal.ecoenergistics.common.item.EcoEnergisticsItems;
import mekanism.common.recipe.RecipeHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Purification {
    public static void InitCustomPurificationRecipes() {
        if (Constants.PURIFICATION_ENABLED) {
            RecipeHandler.addCrusherRecipe(new ItemStack(Items.DYE,1,4), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.LAPIS.ordinal()));
            RecipeHandler.addCrusherRecipe(new ItemStack(EcoEnergisticsItems.MoreIngot,1,Ingot.ACTIVATEDGLOWSTONE.ordinal()), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.ACTIVATEDGLOWSTONE.ordinal()));
            RecipeHandler.addCrusherRecipe(new ItemStack(Items.EMERALD), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.EMERALD.ordinal()));
            RecipeHandler.addCrusherRecipe(new ItemStack(EcoEnergisticsItems.MoreIngot, 1, Ingot.ACTIVATEDGLOWSTONE.ordinal()), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.ACTIVATEDGLOWSTONE.ordinal()));
        }


    }

}
