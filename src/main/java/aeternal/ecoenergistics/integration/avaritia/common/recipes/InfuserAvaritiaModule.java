package aeternal.ecoenergistics.integration.avaritia.common.recipes;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.enums.Ingot;
import aeternal.ecoenergistics.common.item.EcoEnergisticsItems;
import aeternal.ecoenergistics.integration.avaritia.common.item.AvaritiaModuleItems;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.infuse.InfuseType;
import mekanism.common.MekanismItems;
import mekanism.common.recipe.RecipeHandler;
import net.minecraft.item.ItemStack;

import static aeternal.ecoenergistics.common.Infusers.*;
import static aeternal.ecoenergistics.integration.avaritia.common.InfusersAvaritia.*;

public class InfuserAvaritiaModule {
    public static void InitAvaritiaInfuserRecipes() {
        if (Constants.INFUSION_ENABLED && Constants.AvaritiaLoaded && Constants.AvaritiaConfirm) {
            ItemStack neutronAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 9);
            ItemStack crystalAlloy = new ItemStack(AvaritiaModuleItems.AlloyAvaritia, 1, 0);
            ItemStack neutroniumAlloy = new ItemStack(AvaritiaModuleItems.AlloyAvaritia, 1, 1);
            ItemStack infinityAlloy = new ItemStack(AvaritiaModuleItems.AlloyAvaritia, 1, 2);

            // Metallurgic Infuser Recipes
            //Alloys
            RecipeHandler.addMetallurgicInfuserRecipe(crystal, 80, neutronAlloy, crystalAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(neutronium, 160, crystalAlloy, neutroniumAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(infinity, 10, neutroniumAlloy, infinityAlloy);

        }


    }

}
