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
            InfuseType carbon = InfuseRegistry.get("CARBON");
            InfuseType diamond = InfuseRegistry.get("DIAMOND");
            InfuseType obsidian = InfuseRegistry.get("OBSIDIAN");
            InfuseType redstone = InfuseRegistry.get("REDSTONE");

            ItemStack advancedAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 0);
            ItemStack hybridAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 1);
            ItemStack perfecthybridAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 2);
            ItemStack quantumAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 3);
            ItemStack spectralAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 4);
            ItemStack protonicAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 5);
            ItemStack singularAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 6);
            ItemStack diffractiveAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 7);
            ItemStack photonicAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 8);
            ItemStack neutronAlloy = new ItemStack(EcoEnergisticsItems.MoreAlloy, 1, 9);
            ItemStack activeGlowstoneIngot = new ItemStack(EcoEnergisticsItems.MoreIngot,1, Ingot.ACTIVATEDGLOWSTONE.ordinal());
            ItemStack GlowstoneIngot = new ItemStack(MekanismItems.Ingot,1,3);
            ItemStack lithiumDust = new ItemStack(MekanismItems.OtherDust, 1,4);
            ItemStack refinedlithiumDust = new ItemStack(EcoEnergisticsItems.MoreDust, 1,3);
            ItemStack hdperod = new ItemStack(MekanismItems.Polyethene, 1,1);
            ItemStack steelrod = new ItemStack(EcoEnergisticsItems.MoreRod, 1,0);

            ItemStack crystalAlloy = new ItemStack(AvaritiaModuleItems.AlloyAvaritia, 1, 0);
            ItemStack neutroniumAlloy = new ItemStack(AvaritiaModuleItems.AlloyAvaritia, 1, 1);
            ItemStack infinityAlloy = new ItemStack(AvaritiaModuleItems.AlloyAvaritia, 1, 2);


            // Metallurgic Infuser Recipes
            //Alloys

            RecipeHandler.addMetallurgicInfuserRecipe(crystal, 64, neutronAlloy, crystalAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(neutronium, 48, crystalAlloy, neutroniumAlloy);
            RecipeHandler.addMetallurgicInfuserRecipe(infinity, 32, neutroniumAlloy, infinityAlloy);

        }


    }

}
