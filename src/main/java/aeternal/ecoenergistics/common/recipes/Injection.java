package aeternal.ecoenergistics.common.recipes;

import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.common.EcoEnergisticsItems;
import mekanism.common.MekanismFluids;
import mekanism.common.block.states.BlockStateMachine;
import mekanism.common.config.MekanismConfig;
import mekanism.common.recipe.RecipeHandler;
import net.minecraft.item.ItemStack;

public class Injection {
    public static void InitCustomInjectionRecipes() {
        if (MekanismConfig.current().general.machinesManager.isEnabled(BlockStateMachine.MachineType.CHEMICAL_INJECTION_CHAMBER)) {
            ItemStack titaniumOre = new ItemStack(EcoEnergisticsBlocks.EcoOreBlock, 1, 0);
            ItemStack uraniummOre = new ItemStack(EcoEnergisticsBlocks.EcoOreBlock, 1, 1);
            ItemStack iridiumOre = new ItemStack(EcoEnergisticsBlocks.EcoOreBlock, 1, 2);

            ItemStack titaniumShard = new ItemStack(EcoEnergisticsItems.MoreShard, 1, 0);
            titaniumShard.setCount(titaniumShard.getCount() * 4);
            ItemStack uraniumShard = new ItemStack(EcoEnergisticsItems.MoreShard, 1, 1);
            uraniumShard.setCount(uraniumShard.getCount() * 4);
            ItemStack iridiumShard = new ItemStack(EcoEnergisticsItems.MoreShard, 1, 2);
            iridiumShard.setCount(iridiumShard.getCount() * 4);

            RecipeHandler.addChemicalInjectionChamberRecipe(titaniumOre, MekanismFluids.HydrogenChloride, titaniumShard);
            RecipeHandler.addChemicalInjectionChamberRecipe(uraniummOre, MekanismFluids.HydrogenChloride, uraniumShard);
            RecipeHandler.addChemicalInjectionChamberRecipe(iridiumOre, MekanismFluids.HydrogenChloride, iridiumShard);
        }


    }

}
