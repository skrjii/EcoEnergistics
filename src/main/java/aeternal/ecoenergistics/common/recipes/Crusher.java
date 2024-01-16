package aeternal.ecoenergistics.common.recipes;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.common.enums.Ingot;
import aeternal.ecoenergistics.common.enums.MoreDust;
import aeternal.ecoenergistics.common.item.EcoEnergisticsItems;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.infuse.InfuseType;
import mekanism.common.MekanismItems;
import mekanism.common.recipe.RecipeHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static aeternal.ecoenergistics.common.Infusers.*;

public class Crusher {
    public static void InitCustomCrusherRecipes() {
        if (Constants.CRUSHER_ENABLED) {

            ItemStack titaniumOre = new ItemStack(EcoEnergisticsBlocks.OreBlock,1,0);
            ItemStack uraniummOre = new ItemStack(EcoEnergisticsBlocks.OreBlock,1,1);
            ItemStack iridiumOre = new ItemStack(EcoEnergisticsBlocks.OreBlock,1,2);

            ItemStack titaniumClump = new ItemStack(EcoEnergisticsItems.MoreClump,1,0);
            ItemStack uraniumClump = new ItemStack(EcoEnergisticsItems.MoreClump,1,1);
            ItemStack iridiumClump = new ItemStack(EcoEnergisticsItems.MoreClump,1,2);

            ItemStack titaniumDirty = new ItemStack(EcoEnergisticsItems.MoreDirtyDust,1,0);
            ItemStack uraniumDirty = new ItemStack(EcoEnergisticsItems.MoreDirtyDust,1,1);
            ItemStack iridiumDirty = new ItemStack(EcoEnergisticsItems.MoreDirtyDust,1,2);

            ItemStack titaniumIngot = new ItemStack(EcoEnergisticsItems.MoreIngot,1,1);
            ItemStack uraniumIngot = new ItemStack(EcoEnergisticsItems.MoreIngot,1,2);
            ItemStack iridiumIngot = new ItemStack(EcoEnergisticsItems.MoreIngot,1,3);

            ItemStack titaniumDust = new ItemStack(EcoEnergisticsItems.Dust,1,0);
            ItemStack titaniumDust2 = titaniumDust.copy();
            titaniumDust2.setCount(titaniumDust2.getCount() *2);
            ItemStack uraniumDust = new ItemStack(EcoEnergisticsItems.Dust,1,1);
            ItemStack uraniumDust2 = uraniumDust.copy();
            uraniumDust2.setCount(uraniumDust2.getCount() *2);
            ItemStack iridiumDust = new ItemStack(EcoEnergisticsItems.Dust,1,2);
            ItemStack iridiumDust2 = iridiumDust.copy();
            iridiumDust2.setCount(iridiumDust2.getCount() *2);


            RecipeHandler.addCrusherRecipe(new ItemStack(Items.DYE,1,4), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.LAPIS.ordinal()));
            RecipeHandler.addCrusherRecipe(new ItemStack(EcoEnergisticsItems.MoreIngot,1,Ingot.ACTIVATEDGLOWSTONE.ordinal()), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.ACTIVATEDGLOWSTONE.ordinal()));
            RecipeHandler.addCrusherRecipe(new ItemStack(Items.EMERALD), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.EMERALD.ordinal()));
            RecipeHandler.addCrusherRecipe(new ItemStack(EcoEnergisticsItems.MoreIngot, 1, Ingot.ACTIVATEDGLOWSTONE.ordinal()), new ItemStack(EcoEnergisticsItems.MoreDust, 1, MoreDust.ACTIVATEDGLOWSTONE.ordinal()));
            RecipeHandler.addCrusherRecipe(titaniumClump,titaniumDirty);
            RecipeHandler.addCrusherRecipe(uraniumClump,uraniumDirty);
            RecipeHandler.addCrusherRecipe(iridiumClump,iridiumDirty);

            RecipeHandler.addCrusherRecipe(titaniumIngot,titaniumDust);
            RecipeHandler.addCrusherRecipe(uraniumIngot,uraniumDust);
            RecipeHandler.addCrusherRecipe(iridiumIngot,iridiumDust);



        }


    }

}
