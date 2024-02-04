package aeternal.ecoenergistics.integration.avaritia.common.recipes;

import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.integration.avaritia.common.enums.AvaritiaTiers;
import aeternal.ecoenergistics.integration.avaritia.common.item.AvaritiaModuleItems;
import mekanism.common.recipe.RecipeHandler;
import morph.avaritia.init.ModItems;
import net.minecraft.item.ItemStack;

public class CrusherAvaritiaModule {
    public static void InitAvaritiaCrusherRecipes() {
        if (Constants.CRUSHER_ENABLED && Constants.AvaritiaLoaded && Constants.AvaritiaConfirm) {
            ItemStack crystalDust = new ItemStack(AvaritiaModuleItems.DustAvaritia,1,0);
            ItemStack neutroniumDust = new ItemStack(AvaritiaModuleItems.DustAvaritia,1,1);
            ItemStack infinityDust = new ItemStack(AvaritiaModuleItems.DustAvaritia,1, AvaritiaTiers.INFINITY.ordinal());
            ItemStack crystalIngot = ModItems.crystal_matrix_ingot;
            ItemStack neutroniumIngot = ModItems.neutronium_ingot;
            ItemStack infinityIngot = ModItems.infinity_ingot;

            RecipeHandler.addCrusherRecipe(crystalIngot,crystalDust);
            RecipeHandler.addCrusherRecipe(neutroniumIngot,neutroniumDust);
            RecipeHandler.addCrusherRecipe(infinityIngot,infinityDust);

        }


    }

}
