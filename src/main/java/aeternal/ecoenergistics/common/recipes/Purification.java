package aeternal.ecoenergistics.common.recipes;


import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;

import aeternal.ecoenergistics.common.EcoEnergisticsItems;
import mekanism.common.block.states.BlockStateMachine;
import mekanism.common.config.MekanismConfig;
import mekanism.common.recipe.RecipeHandler;
import net.minecraft.item.ItemStack;

public class Purification {
    public static void InitCustomPurificationRecipes() {
        if (MekanismConfig.current().general.machinesManager.isEnabled(BlockStateMachine.MachineType.PURIFICATION_CHAMBER)) {
            ItemStack titaniumOre = new ItemStack(EcoEnergisticsBlocks.EcoOreBlock,1,0);
            ItemStack uraniummOre = new ItemStack(EcoEnergisticsBlocks.EcoOreBlock,1,1);
            ItemStack iridiumOre = new ItemStack(EcoEnergisticsBlocks.EcoOreBlock,1,2);

            ItemStack titaniumClump = new ItemStack(EcoEnergisticsItems.MoreClump,1,0);
            ItemStack titaniumClump2 = titaniumClump.copy();
            titaniumClump2.setCount(titaniumClump2.getCount() *3);
            ItemStack uraniumClump = new ItemStack(EcoEnergisticsItems.MoreClump,1,1);
            ItemStack uraniumClump2 = uraniumClump.copy();
            uraniumClump2.setCount(uraniumClump2.getCount() *3);
            ItemStack iridiumClump = new ItemStack(EcoEnergisticsItems.MoreClump,1,2);
            ItemStack iridiumClump2 = iridiumClump.copy();
            iridiumClump2.setCount(iridiumClump2.getCount() *3);

            ItemStack titaniumShard = new ItemStack(EcoEnergisticsItems.MoreShard,1,0);
            ItemStack uraniumShard = new ItemStack(EcoEnergisticsItems.MoreShard,1,1);
            ItemStack iridiumShard = new ItemStack(EcoEnergisticsItems.MoreShard,1,2);

            RecipeHandler.addPurificationChamberRecipe(titaniumOre, titaniumClump2);
            RecipeHandler.addPurificationChamberRecipe(uraniummOre, uraniumClump2);
            RecipeHandler.addPurificationChamberRecipe(iridiumOre, iridiumClump2);

            RecipeHandler.addPurificationChamberRecipe(titaniumShard, titaniumClump);
            RecipeHandler.addPurificationChamberRecipe(uraniumShard, uraniumClump);
            RecipeHandler.addPurificationChamberRecipe(iridiumShard, iridiumClump);

        }


    }

}
